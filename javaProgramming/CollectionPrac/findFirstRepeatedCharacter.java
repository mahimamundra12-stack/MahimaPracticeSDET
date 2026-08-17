package CollectionPrac;

import java.util.*;

public class findFirstRepeatedCharacter {
    
    public static void main(String[] args) {
        findFirstRepeatedCharacter();
    }
    
    public static void findFirstRepeatedCharacter() {
        System.out.println("\n6. First Repeated Character");

        String input = "swiss";

        Set<Character> seen = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (!seen.add(ch)) {
                System.out.println("First repeated character: " + ch);
                break;
            }
        }
    }
}