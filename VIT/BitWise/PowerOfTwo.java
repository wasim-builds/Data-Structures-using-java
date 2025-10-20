package BitWise;



public class PowerOfTwo {
    public static boolean isPowerOfTwo(int num) {
    // num and num-1 == 0 then it is power of 2
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 4, 8, 16, 31, 32, 64, 100};

        for (int num : testCases) {
            System.out.println(num + " is Power of Two? " + isPowerOfTwo(num));
        }

// for each value
    }
}
