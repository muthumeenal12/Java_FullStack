package threads;

public class EvenOddThread {
	//create Eventhread class and run method to print even numbers
	static class EvenThread extends Thread {
		public void run() {

			for (int i = 2; i < 20; i += 2)
				System.out.println("Even: "+ i);

		}
	}
	//create OddThread class and run method to print odd numbers

	static class OddThread extends Thread {
		public void run() {
			for (int i = 1; i < 20; i += 2)
				System.out.println("Odd: "+i);

		}
	}

	public static void main(String[] args) {
		EvenThread even = new EvenThread();
		OddThread odd = new OddThread();
		even.start();
		odd.start();
	}
}
