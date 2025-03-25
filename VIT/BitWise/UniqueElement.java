package BitWise;

// public class UniqueElement {
//     public static int Unquie(int arr[]){
//         int uniqueNum=0;
//         for(int num:arr){
//             uniqueNum^=0;
//         }
//         return uniqueNum;

//     }
//     public static void main(String[] args) {
//         int arr[]={2,3,5,3,2};
        
//         System.out.println(Unquie(arr));

        
//     }
    
// }
public class UniqueElement {
    public static int findUnique(int[] arr) {
        int unique = 0;
        for (int num : arr) {
            unique ^= num; // XOR cancels out duplicate elements
        }
        return unique;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 3, 2};
        System.out.println("Unique Element: " + findUnique(arr));
    }
}

