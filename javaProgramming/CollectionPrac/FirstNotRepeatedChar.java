package CollectionPrac;

import java.util.HashMap;

public class FirstNotRepeatedChar {

    public static void main(String[] args) {
        String str = "aabbcdde";

        char[] letters = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : letters) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : letters) {
            if (map.get(ch) == 1) {
                System.out.println("First non-repeated character is: " + ch);
                return;
            }
        }

        System.out.println("No non-repeated character found.");
    }
}
