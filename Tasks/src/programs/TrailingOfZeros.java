package programs;

public class TrailingOfZeros {
	public static int zeros(int number)
	{	
//		Initial the quotient
		int quoitent =0;
//		Divide the number by the powers of five where the powers of five 
//		should be less than the number
		for(int i =5;i<number;i*=5)
		{
			quoitent+=number/i;
		}
		return quoitent;
	}
	public static void main(String[] args) {
		System.out.println(zeros(145));
	}

}
