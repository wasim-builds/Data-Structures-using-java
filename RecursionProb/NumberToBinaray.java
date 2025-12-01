package RecursionProb;

public class NumberToBinaray {
    
    public static String FindBinary(int decimal, String result){
        if(decimal==0){
            return result;
        }
        result=decimal% 2 + result;
        return FindBinary(decimal/2,result);

    }
    public static void main(String[] args) {
        String binary=FindBinary(233,"");
        
    }
    
}
