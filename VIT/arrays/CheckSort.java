package arrays;

public class CheckSort {
    static boolean  CheckSortOrnot(int arr[], int n){
        for(int i=1;i<n;i++){
            if(arr[i]>= arr[i-1]){
                
            }
            else{
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        int arr[] = {3,1,4,5,6};
        int n=arr.length;
        if(CheckSortOrnot(arr,n)){
            System.out.println("sorted");
        }else{
            System.out.println("not sorted");
        }

    }
    
}
