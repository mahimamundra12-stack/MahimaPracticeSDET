import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static void main(String[] args) {

        String str = "Loveleen sharmaa haaas interview processes";

        // Step 1: Split sentence into words
        String[] words = str.split(" ");

        // Step 2: Process each word
        for (String word : words) {

            // Step 3: Create frequency map for this word
            Map<Character, Integer> frequency = new HashMap<>();

            // Step 4: Count every character
            for (char c : word.toLowerCase().toCharArray()) {

                frequency.put(
                        c,
                        frequency.getOrDefault(c, 0) + 1
                );
            }

            // Step 5: Create StringBuilder for transformed word
            StringBuilder result = new StringBuilder();

            // Step 6: Traverse the original word again
            for (char c : word.toLowerCase().toCharArray()) {

                int count = frequency.get(c);

                // Step 7: Check vowel occurring 3 times
                if (count == 3 && isVowel(c)) {

                    result.append('0');

                }
                // Step 8: Check consonant occurring 3 times
                else if (count == 3 && !isVowel(c)) {

                    result.append('1');

                }
                // Step 9: Otherwise keep original character
                else {

                    result.append(c);
                }
            }

            // Step 10: Print transformed word
            System.out.println(word + " -> " + result);
        }
    }

    // Method to check whether character is vowel
    public static boolean isVowel(char c) {

        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u';
    }
}