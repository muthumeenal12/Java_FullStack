package task1;

import java.util.*;

public class Students {

	private String Name;
	private List<Integer> marks ;
	public Students(String name, List<Integer> list) {
		super();
		Name = name;
		this.marks = list;
	}
	public int total()
	{
		return marks.stream().reduce( 0,(s,e)->s+e);
		 
	}
	public String getName() {
		return Name;
	}
	public List<Integer> getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "Students [Name=" + Name + ", marks=" + marks + "]";
	}
	public int average()
	{
		return total()/marks.size();
		
	}
}
