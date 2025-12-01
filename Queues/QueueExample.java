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
        System.out.println("Size of queue-"
                           + size);

    }
}

//  smallesh element after k swap given a string 
// find the smallesh leckocal that can we applied by forming atmost k swap
// swap
// find the length of longest sub string that caontain only unique character input abc abc 
//abc output we should get 3
// using a hashset
// find the all permuttaion of string in another string
// s1 s2 find all sub string of s2 taht are permutation of s1
// a into b only using only inserting removing swapping adjcent character 
// output = 4
// long common sub string btw the two string

// shorest pallindrom in string
// find the minimum number of value 
// to make it a pallindrom
//abcd
//bcadabcdf