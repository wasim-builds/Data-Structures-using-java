package Stack;

public class practices {
    public int maxArea(int arr[]){
        int left=0;
        int right=arr.length-1;
        int maxarea=0;
        while(left<right){
            maxarea=Math.max(arr[left],arr[right]*(right-left));
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }


        }
        return maxarea;
        // int i=n-1;
        // int j=m-1;
        // int k=m+n-1;

        // // while(i>=0 && j>=0){
        // //     arr[k--]=(arr[i]>arr1[j]) ? arr[i--]:arr1[j--];
        // // }
        // while(i>=0 && j>=0){
        //     arr[k--]=(arr[i]>arr1[j]) ? arr[i--]:arr1[j--];
        // }
        // while(j>=0){
        //     arr[k--]=arr1[j--];
        // }
    }

    // static void moveZero(int arr[], int target){
    //     int index=0;
    //     for(int num:arr){
    //         if(num!=target){
    //             arr[index++]=num;
    //         }
    //     }
    //     while(index<arr.length){
    //         arr[index++]=target;

    //     }
    // }
    public static void main(String[] args) {
        practices list = new practices();
        

        int arr[]={1,8,6,2,5,4,8,3,7};
        System.out.println(list.maxArea(arr));
        
        

        
    
        
        
    }
    
}
