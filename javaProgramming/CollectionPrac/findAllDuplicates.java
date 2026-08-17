package CollectionPrac;

import java.util.*;

public class findAllDuplicates {
    
    public static void main(String[] args) {
        findAllDuplicates();
    }
    
    public static void findAllDuplicates() {
        System.out.println("\n4. All Duplicate Elements");

        int[] numbers = {4, 2, 7, 2, 4, 9, 7, 1};

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int number : numbers) {
            if (!seen.add(number)) {
                duplicates.add(number);
            }
        }

        System.out.println("Duplicates: " + duplicates);
    }
}
