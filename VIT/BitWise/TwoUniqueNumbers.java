package BitWise;

public class TwoUniqueNumbers {
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10,2,6,4};
        int xor=0;
        for(int num : arr){
            xor ^=num;
        }
        int rightmostSetBit=xor & -xor;
        int num1=0,num2=0;
        for(int num:arr){
            if((num & rightmostSetBit)==0){
                num1^=num;
            }
            else{
                num2^=num;
            }
        }
        System.out.println("unique numbers: "+num1+" "+num2);
    }
    
}
