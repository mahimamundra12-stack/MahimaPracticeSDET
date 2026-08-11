package Strings;

public class ReverseString {
    private char[] letter;

    public ReverseString(String str) {
        this.letter = str.toCharArray();
    }

    public void reverse() {
        for (int i = letter.length - 1; i >= 0; i--) {
            System.out.print(letter[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String name = "Mahima studying in BCA";
        ReverseString obj = new ReverseString(name);
        obj.reverse();
    }
}
