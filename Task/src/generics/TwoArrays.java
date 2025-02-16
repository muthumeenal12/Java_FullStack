package generics;

import java.util.*;

public class TwoArrays<T> {
	static <T> boolean equals(T array1, T array2) {
		return array1.equals(array2);
	}

	public static void main(String[] args) {
		// Create arrays of same type
		List<Integer> array1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> array3 = Arrays.asList(1, 2, 4, 3, 5, 6);
		List<Integer> array4 = Arrays.asList(1, 2, 3, 1, 5, 6);
		List<String> array5 = Arrays.asList("I", "am", "Batman");
		List<String> array6 = Arrays.asList("I", "Batman", "am");
		List<String> array7 = Arrays.asList("I", "Batman", "Am");
		List<String> array8 = Arrays.asList("I", "am", "Batman");

		System.out.println("\nInteger Datatype: \n");
		// Same order and same elements
		System.out.println("Same order and same elements: " + equals(array1, array2));

		// SAme value but different order
		System.out.println("Same value but different order: " + equals(array1, array3));

		// Different values
		System.out.println("Different values: " + equals(array1, array4));

		System.out.println("--------------------------------------------\nString Datatype: \n");
		// Same type and different order and same value
		System.out.println("Same value but different order: " + equals(array5, array6));

		// Different value
		System.out.println("Different values: " + equals(array5, array7));

		// Same value and same order
		System.out.println("Same order and same elements: " + equals(array5, array8));

	}
}
