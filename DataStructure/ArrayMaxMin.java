import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class ArrayMaxMin {
    public static void main(String[] args) {
        Integer arr[] = {4,2,5,-5,6,0,3,7,9,8};
        List<Integer> list = Arrays.asList(arr);
        int max=Collections.max(list);
        int min =Collections.min(list);
        //getting max and min value
    
        System.out.println("Max " + max);
        System.out.println("Min " + min);
    
    }
  

    
}

