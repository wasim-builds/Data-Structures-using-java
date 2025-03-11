package ArrayList;
import java.util.ArrayList;

public class ArrayAndLIist {
    public static void main(String[] args) {
        String arr[]= {"First:", "Second: ", "Third: ", "Fourth: ", "Fifth: "};
        ArrayList<String> names = new ArrayList<String>(); 
        names.add("wasim");
        names.add("lokesh");
        names.add("mahesh");
        names.add("sekhar");
        names.add("ganesh");
        for(int i=0;i<5;i++){
            System.out.println(arr[i]+names.get(i));
        }
    }
}
