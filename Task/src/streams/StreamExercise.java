package streams;

import java.util.Arrays;
import java.util.List;

public class StreamExercise<T> {
	//Use reduce method to calculate average
	public double average(List<Integer> numbers) {
		return numbers.stream().reduce(0, (a, b) -> b + a) / numbers.size();
	}
	
	//To change the case of the string elements in a list
	public List<String> upperCase(List<String> words) {
		return words.stream().map(s -> (s.equals(s.toUpperCase())) ? s.toLowerCase() : s.toUpperCase()).toList();
	}

	//Calculate odd and even sum using forEach
	public String sum(List<Integer> numbers) {
		int[] sums = { 0, 0 };
		numbers.stream().forEach(s -> {
			if (s % 2 == 0)
				sums[0] += s;
			else
				sums[1] += s;
		});

		return Arrays.toString(sums);
	}
	
	//Count the elements that start with a specific character.
	public int count(List<String> words, String start) {
		return (int) words.stream().filter(s -> s.startsWith(start)).count();

	}
	
	//Find distinct elements from a list of duplicates
	public List<T> remove(List<T> list) {
		return list.stream().distinct().toList();
	}

	//Order a list of strings using sorted method
	public void sort(List<String> words) {
		System.out.println("\nAscending Order: " + words.stream().sorted().toList());
		System.out.println("Descending Order: " + words.stream().sorted((a, b) -> b.compareTo(a)).toList());
	}
	
	//Find max and min in Integer list using min() and max() method
	public void maxMin(List<Integer> intList )
	{
		int max= intList.stream().max(Integer::compareTo).orElse(0);
		int min= intList.stream().min(Integer::compareTo).orElse(0);
		System.out.println("\nMax: "+max+" and  Min: "+min);
	}
	public static void main(String[] args) {
		//1. Calculate average
		StreamExercise<Integer> exercise = new StreamExercise<Integer>();
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("Average: " + exercise.average(number));

		//2. Convert a list of Strings to upper or lower case
		List<String> word = Arrays.asList("magpie", "goT", "A", "pencil");
		System.out.println("\nCase Changing: " + exercise.upperCase(word));

		//3. Calculate sum of odd elements and sum of even elements
		System.out.println("\nEven Odd Sum: " + exercise.sum(Arrays.asList(1, 2, 3, 4, 5, 6, 9)));

		//4. Find Distinct elements from a list of elements
		StreamExercise<String> exercise1 = new StreamExercise<String>();
		List<Integer> duplicates = Arrays.asList(1, 2, 1, 2, 12, 4, 2);
		List<String> duplicate = Arrays.asList("tick", "tock", "tick", "tock", "tick");
		System.out.println("\nDistinct elements: " + exercise.remove(duplicates));
		System.out.println("Distinct elements: " + exercise1.remove(duplicate));

		//5. Count no of Strings in a list  that start with a specific letter
		String start = "a";
		List<String> words = Arrays.asList("adams", "eves", "apple", "tree", "liliath");
		System.out.println("\nCount of elements starting with " + start + " : " + exercise1.count(words, start));
		
		//6. sort a list of strings
		exercise1.sort(words);
		
		//7. Find the minimum and maximum values in a list
		exercise.maxMin(duplicates);
	}
}
