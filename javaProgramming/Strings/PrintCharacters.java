package Strings;

public class PrintCharacters {

    public static void main(String[] args) {
        String str = "Hello, World!";
        char [] letter = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        for(int i = 0; i < letter.length; i++) { 
            System.out.println(letter[i]);
        }
    }
    
}
