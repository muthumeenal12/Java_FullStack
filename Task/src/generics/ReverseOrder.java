package generics;

import java.util.Arrays;
import java.util.List;

public class ReverseOrder<T extends Comparable<T>> {
	List<T> reverse(List<T> unorderedList) {
		// Use stream and sorted method and sort using Comparable.compareTo() method.
		return unorderedList.stream().sorted((a, b) -> b.compareTo(a)).toList();
	}

	public static void main(String[] args) {
		// Create Integer List and object for this class and call reverse method
		List<Integer> unsorted = Arrays.asList(89, 12, 34, 123, 809);
		ReverseOrder<Integer> order = new ReverseOrder<Integer>();
		System.out.println(order.reverse(unsorted));

		// Create String List and object for this class and call reverse method
		List<String> unsortedString = Arrays.asList("tote", "bag", "is", "good", "for", "Earth");
		ReverseOrder<String> order1 = new ReverseOrder<String>();
		System.out.println(order1.reverse(unsortedString));
	}
}
