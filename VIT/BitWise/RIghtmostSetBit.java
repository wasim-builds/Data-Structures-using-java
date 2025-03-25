package BitWise;

public class RIghtmostSetBit {
    public static int Result(int num){
        return num & -num;
    }
    public static void main(String[] args) {
        int num=19;
        int re=Result(num);
        System.out.println(re);
    
        
    }
    
}
