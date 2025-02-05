package programs;
import utils.Constants;
import java.util.Scanner;

public class DivideNumber {
//	Method to get quotient using '+' and '-'
	public static int divide(int dividend, int divisor) {
		if (dividend < divisor) {
			return 0;
		}
		return  1+divide(dividend - divisor, divisor);
	}
//Method to get Remainder using '-'
	public static int remainder(int dividend, int divisor) {
		if (dividend < divisor)
			return dividend;
		return remainder(dividend - divisor, divisor);
	}

	public static void main(String[] args) {
//		Get inputs from user
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Dividend and Divisor: ");
		int dividend = s.nextInt();
		int divisor = s.nextInt();
		s.close();
		System.out.println(Constants.DIVIDEND+ dividend + "\n"+Constants.DIVISOR + divisor);
//		Call the methods to find quoitent and remainder
		System.out.println(Constants.QUOTIENT+divide(dividend, divisor)+"\n"+Constants.REMAINDER+remainder(dividend,divisor));
	}

}
