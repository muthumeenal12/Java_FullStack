package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MarkList {
public static void main(String[] args) {
	//Create objects for students class
	Students s = new Students("Joshua",Arrays.asList(74,28,90,68,66));
	Students s1 = new Students("Julie",Arrays.asList(99,89,79,98,80));
	Students s2 = new Students("Jenaine",Arrays.asList(12,10,50,48,51));
	
	//Add them into an array
	ArrayList <Students> students = new ArrayList<>(Arrays.asList(s,s1,s2));
	
	//Find average of marks of each students
	System.out.println("Average mark: ");
	students.stream().map(a->a.getName()+" " +a.average() + " / 100").forEach(System.out::println);
	System.out.println();
	
	//Find the total marks of each students
	System.out.println("Total scored: ");
	students.stream().map(a->a.getName()+" " +a.total()+" / "+a.getMarks().size()*100).forEach(System.out::println);
	System.out.println();
	
	//Sort the arraylist
	ArrayList<Students> sortedStudents = (ArrayList<Students>)students.stream().sorted(Comparator.comparing(Students::total)).collect(Collectors.toList());
	//Name of students from lowest to highest
	sortedStudents.forEach(e->System.out.println("Name: "+e.getName() +" Mark: "+e.total()));
}
}
