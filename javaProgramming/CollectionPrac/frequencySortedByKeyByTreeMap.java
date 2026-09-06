package CollectionPrac;

import java.util.*;

public class frequencySortedByKeyByTreeMap {
    
    public static void main(String[] args) {
        frequencySortedByKey();
    }
    
    public static void frequencySortedByKey() {
        System.out.println("\n14. Frequency Sorted By Key");

        int[] numbers = {4, 2, 7, 2, 4, 9, 7, 1};

        Map<Integer, Integer> frequency = new TreeMap<>();

        for (int number : numbers) {
            frequency.put(
                    number,
                    frequency.getOrDefault(number, 0) + 1
            );
        }

        System.out.println(frequency);
    }
}
