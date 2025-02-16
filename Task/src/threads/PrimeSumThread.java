package threads;

public class PrimeSumThread extends Thread {

	private int start, end, sum;

	// Constructor
	public PrimeSumThread(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	// Check if the number is prime or not
	public boolean isPrime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// check prime or not for a range of numbers
	public void run() {
		sum = 0;
		while (start <= end) {
			if (isPrime(start))
				sum += start;

			start++;
		}
	}

	//method to get sum
	public int getSum() {
		return sum;
	}

	public static void main(String[] args) throws InterruptedException {
		//set limit and no of threads
		int limit = 100;
		int numThreads = 4;
		
		//create threads and separate limits by splitting the original limit
		PrimeSumThread[] threads = new PrimeSumThread[numThreads];
		int range = (int) Math.ceil((double) limit / numThreads);

		for (int i = 0; i < numThreads; i++) {
			int start = i * range + 1;
			int end = Math.min((i + 1) * range, limit);
			threads[i] = new PrimeSumThread(start, end);
			threads[i].start();
		}
		
		//add the sums from each thread.
		int totalSum = 0;
		for (PrimeSumThread thread : threads) {
			thread.join();
			totalSum += thread.getSum();
		}

		System.out.println("Sum of primes: " + totalSum);
	}
}
