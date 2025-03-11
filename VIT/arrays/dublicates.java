import java.util.*;
public class dublicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.toString(arr);
        int count =0;

        for(int i=0;i<n;i++){
            int dub=arr[i];
            if(dub == arr[i]){
                count++;
            }
        }
        System.out.println(count);

    }
}