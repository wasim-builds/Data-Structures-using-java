package arrays;
import java.util.*;
public class CelebrityProblem{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int celb = problem.find(n);
        if(celb == -1){
            System.out.println("celeb not found");
        }
        else{
            System.out.println("celeb is: "+ celb);
        }
    }
    public class problem{
        public  static boolean knows(int a, int b){
            int[][] party = {{0,1,1,1},
                              {0,0,1,1},
                              {0,0,0,0},
                              {0,1,1,0}};
            return party[a][b] == 1;
        } 
        public static int find(int n){
            int candidate = 0;
            for(int i=0; i<n; i++){
                if(knows(candidate,i)){
                    candidate = i;
                }
            }
            
            for(int i=0; i<n; i++){
                if(i != candidate){
                    if(knows(candidate,i)||!(knows(i,candidate))){
                        return -1;
                    }
                }
            }
            return candidate;
        }
    }
}