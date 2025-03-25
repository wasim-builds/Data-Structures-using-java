package BitWise;

public class ToggleBit {
    public static int toggle(int num,int pos){
        return num ^ (1 << pos);
    }
    public static void main(String[] args) {
        int num=10; //1010
        int pos=1; //0001
        int result=toggle(num,pos);
        System.err.println("Number after toggling bit at position "+pos+": "+result);
        
    }
    
}
