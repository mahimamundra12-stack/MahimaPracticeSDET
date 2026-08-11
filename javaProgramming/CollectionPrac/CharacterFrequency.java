package CollectionPrac;

import java.util.HashMap;

public class CharacterFrequency {
    public static void main(String[] args) {
        String str = "hello world";
    //     int[] freq = new int[str.length()];
         char[] letters = str.toCharArray();
    //     for (int i = 0; i < str.length(); i++) {
    //         freq[i] = 1;
    //         for (int j = i + 1; j < str.length(); j++) {
    //             if (letters[i] == letters[j]) {
    //                 freq[i]++;
    //                 letters[j] = '0'; // Mark as counted
    //             }
    //         }
    //     }

    //     System.out.println("Character Frequency:");
    //     for (int i = 0; i < freq.length; i++) {
    //         if (letters[i] != ' ' && letters[i] != '0') {
    //             System.out.println(letters[i] + ": " + freq[i]);
    //         }
    //     }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch:letters){
            System.out.println(ch);

if(map.containsKey(ch))
{
    
    map.put(ch,map.get(ch)+1);
}
else{
    map.put(ch,1);
}
        }
        System.out.println(map);
}  

}



