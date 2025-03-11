package arrays;


import java.util.HashMap;
import java.util.Map;

public class FrequencyHashpmap {

    static void countFreq(int arr[],int n){
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            else{
                mp.put(arr[i],1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


    }
    public static void main(String[] args) {
        int arr[]={10,20,10,20,10,30,40,10,20,20};
        int n =arr.length;
        countFreq(arr,n);

    }

}