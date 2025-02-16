package generics;

import java.util.*;

public class OddEvenSum<T> {
	public static <T extends Number> double[] Sum(List<T> arr) {
		double[] a = { 0, 0 };
		for (T num : arr) {
			if (num.intValue() % 2 == 0)
				a[0] += num.intValue();
			else
				a[1] += num.intValue();
		}
		return a;
	}

	public static void main(String[] args) {
		double[] answer = Sum(Arrays.asList(1, 2, 3, 4, 5));
		double[] answ = Sum(Arrays.asList(1.3, 2.2, 3.5, 9.4, 0.5));
		System.out.println("[even, odd]: "+Arrays.toString(answer));
		System.out.println("[even, odd]: "+Arrays.toString(answ));
	}
}
