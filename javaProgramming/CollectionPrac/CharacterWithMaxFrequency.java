package CollectionPrac;

import java.util.HashMap;
import java.util.Map;

public class CharacterWithMaxFrequency {
    public static void main(String[] args) {
        String str = "bananas";
        char[] letters = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : letters) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
      
        char maxChar = ' ';
        int maxCount = 0;

        // Find maximum frequency
        for (char ch : letters) {

            if (map.get(ch) > maxCount) {

                maxCount = map.get(ch);
                maxChar = ch;
            }
        }

        System.out.println("Character : " + maxChar);
        System.out.println("Frequency : " + maxCount);
       // System.out.println(map);
    }
     
}
