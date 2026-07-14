package ArrayList;
import java.util.ArrayList;

public class ReverseAL{
    public static void main(String[] args) {
        ArrayList<String> letters = new ArrayList<String>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

        int original = letters.size();
        for(int i=original-1;i>=0;i--){
            letters.add(letters.get(i));
        }
        for(int j=0;j<original;j++){
            letters.remove(0);

        }
        System.out.println(letters);

    }
}
