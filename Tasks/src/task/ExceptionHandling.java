package task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
//	Define main method and call userInput method
	public static void main(String[] args) {
		userInput();
	}

public static void userInput()
{
//	Get input from user
	Scanner s = new Scanner(System.in);
//	Create a try block and perform the reciprocal of the given number
	try {
		System.out.println("Enter the input: ");
		int input = s.nextInt();
//		Throw exception when input is negative
		if(input<0)
			throw new IllegalArgumentException("Entered input is lower than 0.");
//		Throws exception when input is Zero
		if(input==0)
			throw new Exception("Input cannot be 0!!!");
//		Perform reciprocal of the input
		int reciprocal = 1;
		while(input>0)
		{
			reciprocal*=10 + (input/10);
			input/=10;
		}
//		Print the output
		System.out.println("Reciprocal: "+reciprocal);
	}
//	Define catch blocks to counter the exceptions
//	Define a input mismatch exception when entered data type is not integer
	catch(InputMismatchException e)
	{
		e.printStackTrace();
	}
//	Define catch block when Arithmetic exception is encountered
	catch(ArithmeticException e)
	{
		System.out.println(e.getMessage());
	}
//	Catch the exception thrown from try block
	catch(IllegalArgumentException e)
	{
		e.printStackTrace();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
//	To close the opened Scanner.
	finally {
	s.close();
	}
	
}
}
