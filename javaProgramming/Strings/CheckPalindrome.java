package Strings;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        String reversedStr = new StringBuilder(str).reverse().toString();
        if (str.equals(reversedStr)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }

        char [] c= str.toCharArray();
        for(int i=0;i<c.length/2;i++){
            if(c[i]!=c[c.length-1-i]){
                System.out.println(str + " is not a palindrome.");
                return;
            }
        }
        System.out.println(str + " is a palindrome.");
    }
}
