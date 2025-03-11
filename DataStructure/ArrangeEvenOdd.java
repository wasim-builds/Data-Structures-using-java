import java.util.Scanner;

public class ArrangeEvenOdd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[]=takeArrayInput(sc);
        arrangeEvenOdd(arr);
        printArray(arr);
    }
    public static int[] takeArrayInput(Scanner sc){
        int size = sc.nextInt();
        int arr[]= new int[size];
        System.out.println(size);
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();

        }
        return arr;
    }
    public static void arrangeEvenOdd(int[] arr){
        int left =0;
        int right = arr.length-1;
        while(left < right){
            if(arr[left] % 2 == 0){
                left++;
            }
            else if (arr[right] % 2==0){
                right--;
            }
            else{
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
    }
    public static void printArray(int[] arr){
        System.out.print("array after arranging even an odd numbers:");
        for(int element : arr){
            System.out.print(element + " ");

        }
        System.out.println();
    }

}
