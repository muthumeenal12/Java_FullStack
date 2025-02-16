package generics;
import java.util.*;
public class FirstOccurrence <T>{
 int occurence(List<T> numbers,T target)
{
	 for(int i=0;i<numbers.size();i++) {
		 if(numbers.get(i).equals(target))
			 return i;}
	return -1;
	
}
 public static void main(String[] args) {
	List<String> words = Arrays.asList("Pushpa","na","fire","ila","Wild","uh","Fire uh..","da");
	String target ="fire";
	FirstOccurrence<String> occur = new FirstOccurrence<String>();
	System.out.println("Index of Target ["+target+"] : "+occur.occurence(words, target));
}
}
