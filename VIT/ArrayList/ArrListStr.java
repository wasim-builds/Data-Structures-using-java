package ArrayList;
import java.util.ArrayList;
public class ArrListStr {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<String>();
        name.add("Lokesh");
        name.add("is my");
        name.add("best friend");
        System.out.println(name);
        System.out.println(name.get(2));
        // change element at index any to anything
        name.set(2,"arripuka");
        System.out.println(name);
        name.add("hi");
        name.add("mahesh");
        for(int i=0;i<name.size();i++){
            System.out.println(name.get(i));
        }
    }

}
