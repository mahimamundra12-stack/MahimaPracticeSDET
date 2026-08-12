    package CollectionPrac;

    import java.util.HashMap;
    import java.util.Map;

    class CharachterWithMaxFrequency {
    public static void main(String[] args) {
        String str = "programming";
        char[] letters = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : letters) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
         for (char ch : letters) {
            if (map.get(ch) > 1) {
                System.out.println("Duplicate character: " + ch + ", Count: " + map.get(ch));
                map.put(ch, 0); // Set count to 0 to avoid printing duplicates again
            }
         }
       // System.out.println(map);
    }
     
}
