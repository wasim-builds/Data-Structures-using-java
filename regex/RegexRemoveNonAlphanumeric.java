public class RegexRemoveNonAlphanumeric {
    public static void main(String[] args) {
        String text = "Hello@# World! 123.";
        String cleaned = text.replaceAll("[^A-Za-z0-9]", "");
        System.out.println(cleaned);
    }
}