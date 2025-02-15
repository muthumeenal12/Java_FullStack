package exceptionHandling;

import java.util.Scanner;

public class tryCatch {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	try {
		System.out.println("Enter the number: ");
		int num = s.nextInt();
		int div = s.nextInt();
		System.out.println(num/div);
	}
	catch(ArithmeticException e)
	{
		System.out.println(e.getMessage());
	}
	finally {
		s.close();
	}
}
}
