package task1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Capitalize {
	public static void main(String[] args) {
		
		//Create object for the class Capitalize
		Capitalize cap = new Capitalize();
		System.out.println(cap.capitalize("the harry potter"));
		
	}
	public String capitalize(String words)
	{
		//IntStream.range() is a primitive stream that works similar to for-range (python) and mapToObj is used to perform alternate capitalization of the String
		return IntStream.range(0,words.length()).mapToObj(s->(s%2==0)?String.valueOf(words.charAt(s)).toUpperCase():String.valueOf(words.charAt(s))).collect(Collectors.joining());
	}

}
