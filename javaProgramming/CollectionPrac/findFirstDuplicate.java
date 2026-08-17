package CollectionPrac;

import java.util.*;

public class findFirstDuplicate {
    
    public static void main(String[] args) {
        findFirstDuplicate();
    }
    
    public static void findFirstDuplicate() {
        System.out.println("\n3. First Duplicate Element");

        int[] numbers = {4, 2, 7, 2, 4, 9, 7, 1};

        Set<Integer> seen = new HashSet<>();

        for (int number : numbers) {
            if (!seen.add(number)) {
                System.out.println("First duplicate: " + number);
                break;
            }
        }
    }
}
