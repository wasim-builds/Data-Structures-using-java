import java.util.Arrays;
public class Arraysum {
   public static void main(String[] args) {

//Time Complexity: O(n)
//Auxiliary Space: O(1)
      // arry sum
    int num[]={7,6,5,4,3,2,1};
    int sum=Arrays.stream(num).sum();
    System.out.println(sum);
   }
}

