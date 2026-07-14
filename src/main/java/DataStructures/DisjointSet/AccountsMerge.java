package DataStructures.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Accounts Merge (LeetCode 721)
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * Return the accounts merged by grouping emails.
 */
public class AccountsMerge {
    static class UnionFind {
        int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int find(int p) {
            if (p == parent[p]) return p;
            return parent[p] = find(parent[p]);
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        
        Map<String, Integer> emailToAccount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToAccount.containsKey(email)) {
                    uf.union(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }
        
        Map<Integer, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToAccount.keySet()) {
            int root = uf.find(emailToAccount.get(email));
            rootToEmails.putIfAbsent(root, new ArrayList<>());
            rootToEmails.get(root).add(email);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (Integer root : rootToEmails.keySet()) {
            List<String> emails = rootToEmails.get(root);
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(root).get(0));
            merged.addAll(emails);
            res.add(merged);
        }
        
        return res;
    }
}
