package Strings;

public class ReverseStringUsingStringBuilder {
    
    public static void main(String[] args) {
        reverseString();
    }
    
    public static void reverseString() {
        String input = "Automation";

        String reversed = new StringBuilder(input)
                .reverse()
                .toString();

        System.out.println(reversed);
    }
}
