package task1;
import java.util.*;
import java.util.stream.IntStream;
public class AlternateElements<T> {
	public static void main(String[] args) {
		//For Integer array of elements
		System.out.println("Integer Array:");
		AlternateElements<Integer> elements = new AlternateElements<Integer>();
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,89));
		List<Integer> alternateElements = elements.alternateElements(numbers);
		System.out.println(alternateElements+"\n");
		
		
		//For String Array Of Elements
		System.out.println("String Array:");
		AlternateElements<String> element = new AlternateElements<String>();
		ArrayList<String> words = new ArrayList<String>(Arrays.asList("on","a","sunny","day",",","there","lived","a","thirsty","crow"));
		List<String> alternateElement = element.alternateElements(words);
		System.out.println(alternateElement);
	}
	public  List<T> alternateElements(List<T> list)
	{
		//Use primitive stream to use index of the list and find the alternative numbers.
		return IntStream.range(0, list.size()).filter(index->index%2==0).mapToObj(list::get).toList();
	}

}
