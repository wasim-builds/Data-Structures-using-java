import java.lang.*;
import java.util.*;

public class ArrListnegativereverse{
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arraylists = new ArrayList<>();
        
        
        // original array
        
       while (true) { 
            int arraylist= sc.nextInt();
            if(arraylist < 0){
                break;
           }
           arraylists.add(arraylist);
       }
        for(int i=arraylists.size()-1;i>=0;i--){
            System.out.print(arraylists.get(i)+" ");
        }
        sc.close();
        // get negative list

    }
}
