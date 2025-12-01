package leetcode;

import java.util.Arrays;

public class anagrams {
    public static boolean isAna(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        char arr[]=s.toCharArray();
        char arr1[]=t.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        for(int i=0;i<s.length();i++){
            if(arr[i]!=arr1[i]){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String s ="wasim";
        String t = "misaw";
        if(isAna(s,t)){
            System.out.println("t is ana");
        }
        else {
            System.out.println("t is not ana");
        }


    }
    
}
