package exceptionHandling;

import java.util.Scanner;

public class OddOneOut {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the input:");
		int number = s.nextInt();
		if (number % 2 == 1) {
			s.close();
			throw new Exception("Odd one out");
			}
		
		else
			System.out.println("Thank for the even input!!!");
		s.close();
		
	}

}
