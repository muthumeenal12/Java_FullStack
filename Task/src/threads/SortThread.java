package threads;

import java.util.Arrays;

public class SortThread extends Thread {
	private int[] arr;

	public SortThread(int[] arr) {
		super();
		this.arr = arr;
	}
	public void run()
	{
		Arrays.sort(arr);
	}
	public int[] getSortedArray()
	{
		return arr;
	}
	public static void main(String[] args) throws InterruptedException {
        int[] arr = {5, 3, 8, 1, 2, 9, 7, 6};
        SortThread sortThread = new SortThread(arr);
        sortThread.start();
        sortThread.join();
        System.out.println("Sorted Array: " + Arrays.toString(sortThread.getSortedArray()));
    }

}
