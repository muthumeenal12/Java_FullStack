package programs;

import java.util.Arrays;
import utils.Constants;

public class Variable {
	public static void main(String[] args) {
//		Get a primivite variable number
		int number = 6789;
//		Print before calling the method and call the method and after calling the method
		System.out.println(Constants.BEFORE_METHOD+number);
		increment(number);//type casting occurs
		System.out.println(Constants.AFTER_METHOD+number);
//		Get a reference variable
		double [] arrayDouble = {2.0,3.2,1.98};
//		Print before calling the method and call the method and after calling the method
		System.out.println(Constants.BEFORE_METHOD+Arrays.toString(arrayDouble));
		increment(arrayDouble);
		System.out.println(Constants.AFTER_METHOD+Arrays.toString(arrayDouble));
	}
//	Method to increment the number
	public static void increment(double number)
	{
		number++;
		System.out.println(number);
	}
//	Method overloading
	public static void increment(double [] arrayDouble)
	{
		for(int i =0;i<arrayDouble.length;i+=2)
		{
			arrayDouble[i]+=1;
		}
		System.out.println(Arrays.toString(arrayDouble));
	}
}
