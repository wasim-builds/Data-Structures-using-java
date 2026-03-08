public class RegexSplitByComma {
    public static void main(String[] args) {
        String text = "one,two,'three,four',five";
        String[] parts = text.split(",(?=(?:[^']*'[^']*')*[^']*$)");
        for (String part : parts) {
            System.out.println(part.trim());
        }
    }
}