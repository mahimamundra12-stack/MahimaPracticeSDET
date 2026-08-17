package CollectionPrac;

import java.util.*;

public class sortMapByValue {
    
    public static void main(String[] args) {
        sortMapByValue();
    }
    
    public static void sortMapByValue() {
        System.out.println("\n7. Sort Map By Value - Ascending");

        Map<String, Integer> map = new HashMap<>();

        map.put("A", 30);
        map.put("B", 10);
        map.put("C", 20);

        Map<String, Integer> sortedMap =
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(
                                LinkedHashMap::new,
                                (result, entry) ->
                                        result.put(
                                                entry.getKey(),
                                                entry.getValue() //..reversed()
                                        ),
                                LinkedHashMap::putAll
                        );

        System.out.println(sortedMap);
    }
}