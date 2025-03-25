package BitWise;

public class CountSetBitsKernighan {
    public static void main(String[] args) {
        int num=29;
        int count=0;
        while(num>0){
            num &=num-1;
            count++;
        }
        System.out.println("counter is : "+count);
    }
    
}
