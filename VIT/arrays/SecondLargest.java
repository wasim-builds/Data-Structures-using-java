package arrays;

public class SecondLargest {
    public static void main(String args[]){
        int arr[] = {3, 5, 6, 7, 7, 1};
        
        // Variables to keep track of largest and second largest
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;
        
        // Traverse the array once to find the largest and second largest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                slargest = largest; // Update second largest
                largest = arr[i];   // Update largest
            } else if (arr[i] > slargest && arr[i] < largest) {
                slargest = arr[i]; // Update second largest
            }
        }

        // Handle the case where there is no second largest element
        if (slargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element");
        } else {
            System.out.println("Second largest element: " + slargest);
        }
    }
}

// O(n)
// O(n)
