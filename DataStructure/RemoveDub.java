import java.util.Arrays;
import java.util.HashSet;
public class RemoveDub {

    public static void main(String[] args){
        Integer[] arr={1,1,2,2,2,3,3};
        HashSet<Integer> list = new HashSet<>(Arrays.asList(arr));
        Integer[] Nodub = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(Nodub));
    }
    
}
   
