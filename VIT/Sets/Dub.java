package Sets;
import java.util.HashSet;
import java.util.Scanner;
public class Dub {
    public static void main(String[] args) {
        HashSet<Integer> list = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        for(int i=0;i<n;i++){
            list.add(arr[i]);

        }
        System.out.println(list);

        // REMOVED DUBLICATES


        
    }

    
}
