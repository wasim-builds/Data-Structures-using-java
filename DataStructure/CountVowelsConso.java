public class CountVowelsConso {

    public static int countVowels(String str){
        int count = 0;
        for(char c: str.toCharArray()){
            if("aeiouAEIOU".indexOf(c)!=-1){
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args){
        String input = "hello world";
        System.out.println(countVowels(input));
    }
}
