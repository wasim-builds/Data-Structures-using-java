package arrays;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String args[]){
        int arr[]={3,5,6,7,7,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int largest=arr[0];
        int slargest=-1;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }
            else if (arr[i]<largest && arr[i]>slargest) {
                slargest=arr[i];
            }
        }
        System.out.println(slargest);
    }
}
// O(n)
// O(n)
