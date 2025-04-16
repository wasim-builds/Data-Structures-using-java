package Queue;
import java.util.LinkedList;
import java.util.Queue;
public class QueueStr {

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        

        q.add("wasim");
        q.add("khan");
        q.add("Mohammed");
        System.out.println(q);
        String front = q.remove();
        System.out.println(front);
        System.out.println(q);

        q.add("date");
        String peeked = q.peek();

        System.out.println(peeked);
        System.out.println(q);
// queue in string
    }
    
}
