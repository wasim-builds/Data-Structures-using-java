package Queue;
import java.util.Queue;
import java.util.LinkedList;





public class QueueExample {

    static void pop(Queue<Integer> q){
        if(q.isEmpty()){

        }
    }

    public static void main(String[] args)
    {
        Queue<Integer> q = new LinkedList<>();

        
        for (int i = 0; i < 5; i++)
            q.add(i);

        // Display contents of the queue.
        System.out.println("Elements of queue "
                           + q);
uu
       
        int removedele = q.remove();
        System.out.println("removed element-"
                           + removedele);

        System.out.println(q);

        
        int head = q.peek();
        System.out.println("head of queue-"
                           + head);

        
        int size = q.size();
        System.out.println("Size of queue-");


