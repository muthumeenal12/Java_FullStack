package utils;
//A utility class to find length of the digits of the number.
//Example usage can be seen in programs package
public class NoOfDigits {
	public final static int length(int number)
	{	
		if (number>0)
			return 1+length(number/10);
		return 0;
	}
}
