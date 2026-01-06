public class RegexReplaceWhitespace {
    public static void main(String[] args) {
        String text = "This   is\ta test.\nNew line.";
        String replaced = text.replaceAll("\\s+", " ");
        System.out.println(replaced);
    }
}