package leetcode;
import java.util.Scanner;
public class SellStock {
    public static int SellStock(int prices[]){
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0]; // Track the minimum price so far
        int maxprofit = 0; // Track the maximum profit

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min; // Calculate profit if sold today
            maxprofit = Math.max(maxprofit, profit); // Update max profit
            min = Math.min(min, prices[i]); // Update the minimum price
        }

        return maxprofit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int prices[]= new int[x];
        //715364
        for(int i=0;i<x;i++){
            prices[i]=sc.nextInt();
        }
        int result=SellStock(prices);
        System.out.println(result);


        
    }
    
}
