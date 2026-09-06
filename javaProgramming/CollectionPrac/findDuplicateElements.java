package CollectionPrac;

import java.util.*;

public class findDuplicateElements {
    
    public static void main(String[] args) {
        findDuplicateElements();
    }
    
    public static void findDuplicateElements() {
        System.out.println("\n2. Duplicate Elements");

        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 2, 4, 1, 5);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer number : numbers) {
            if (!seen.add(number)) {
                duplicates.add(number);
            }
        }

        System.out.println("Duplicates: " + duplicates);
    }
}
