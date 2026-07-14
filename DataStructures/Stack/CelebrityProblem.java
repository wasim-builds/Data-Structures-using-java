package Stack;
import java.util.Stack;
public class CelebrityProblem {
    public static int findCelebrity(int[][] mat){
        Stack<Integer> stack=new Stack<>();
        // push all people onto the stack
        for(int i=0;i<mat.length;i++){
            stack.push(i);
        }

        // Eliminate non-celebrities

        while(stack.size()>1){
            int personA=stack.pop();
            int personB =stack.pop();

            //if personA knows personB, then personA can't be the celebrity
        if(mat[personA][personB]==1){
            stack.push(personB);
        }
        else{
            // if personA doesn't know personB, then personB can't be the celebrity
            stack.push(personA);
        }
        }

        

        // step 3: potential celebrity
        int candidate =stack.pop();
        //step 4 verify if candidate is a real celebrity
        for(int i=0;i<mat.length;i++){
            if(i==candidate) continue;
            if(mat[candidate][i]==1 || mat[i][candidate]==0){
                return -1; // not a celebrity
            }
            
        }
        return candidate; // confirmed celebrity


    }
    public static void main(String[] args) {
        int matrix[][]={
            {0,0,0,0},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,0,0}
        };
        int result =findCelebrity(matrix);
        if(result==-1){
            System.out.println("There is no celebrity in the party.");
        }
        else{
            System.out.println("Person "+result+" is the celebrity in the party.");
        }
    }
    
}
