package CollectionPrac;

import java.util.*;

public class convertListToLinkedHashSet {
    
    public static void main(String[] args) {
        convertListToLinkedHashSet();
    }
    
    public static void convertListToLinkedHashSet() {
        System.out.println("\n10. List To LinkedHashSet - Preserve Order");

        List<Integer> numbers =
                Arrays.asList(3, 1, 2, 1, 3);

        Set<Integer> set =
                new LinkedHashSet<>(numbers);

        System.out.println(set);
    }
}