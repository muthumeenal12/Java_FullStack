package task1;

import java.util.*;
import java.util.stream.IntStream;

public class CopyRange {
public static void main(String[] args) {
	//Given an integer array nums and an integer k, find the maximum element 
	//in every contiguous subarray of size k.
	
	//[100,102,104] -> 104
	//[102,104,105] -> 105
	//[104,105,109] -> 109
	//[105,109,299] -> 299
	//[109,299,290] -> 299
	
	int[] numbers = {100,102,104,105,109,299,290};
	
	int k =3;
	int[] maximumElements = Arrays.stream(IntStream.range(0,numbers.length-k+1).
									mapToObj(i->Arrays.copyOfRange(numbers, i, i+k)).
									mapToInt(array->Arrays.stream(array).max().orElse(Integer.MIN_VALUE)).toArray()).toArray();
	System.out.println(Arrays.toString(maximumElements));
}
}
