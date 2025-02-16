package generics;

import java.util.*;

public class AlternatingMerge {
    public static <T> List<T> mergeAlternating(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        
        //Get size of 2 lists and get the maxSize
        int size1 = list1.size(), size2 = list2.size();
        int maxSize = Math.max(size1, size2);
        
        //Merge the lists alternatively..
        for (int i = 0; i < maxSize; i++) {
            if (i < size1) mergedList.add(list1.get(i)); // Add from list1 if available
            if (i < size2) mergedList.add(list2.get(i)); // Add from list2 if available
        }
        
        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(5, 4, 6, 7, 8);

        List<Integer> mergedList = mergeAlternating(list1, list2);
        System.out.println(mergedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8]

        List<String> words1 = Arrays.asList("A", "C", "E");
        List<String> words2 = Arrays.asList("B", "D", "F", "G");

        List<String> mergedWords = mergeAlternating(words1, words2);
        System.out.println(mergedWords); // Output: [A, B, C, D, E, F, G]
    }
}

