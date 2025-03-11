import java.util.*;
public class FrequencyHashpmap{
    static void countFreq(int arr[],int n){
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i], mp.get(arr[i])+1);
            }

            else
            {
                mp.put(arr[i],1);
            }
        }
       
        
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }
    }
    // O(n)
    // O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size =sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int n=arr.length;
        countFreq(arr, n);
    }
}