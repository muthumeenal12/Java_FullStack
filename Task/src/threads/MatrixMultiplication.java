package threads;
import java.util.*;
import java.util.stream.IntStream;
public class MatrixMultiplication extends Thread{
	//Create matrices and row
	private int[][] a,b,c;
	private int row;
	
	//COnstructor
	public  MatrixMultiplication(int[][]a,int[][]b,int[][]c,int row)
	{
		this.a=a;
		this.b=b;
		this.c=c;
		this.row=row;
	}
	
	//run method to multiply the matrices
	public void run()
	{
		IntStream.range(0, b[0].length).forEach(j ->
        c[row][j] = IntStream.range(0, a[0].length)
                            .map(k -> a[row][k] * b[k][j])
                            .sum()
    );
	}
	 public static void main(String[] args) throws InterruptedException {
		 //Create matrices and row
	        int[][] A = {{1, 2}, {3, 4}};
	        int[][] B = {{5, 6}, {7, 8}};
	        int[][] C = new int[A.length][B[0].length];
	        
	        //Create multiple threads to perform multiplication
	        Thread[] threads = new Thread[A.length];
	        for (int i = 0; i < A.length; i++) {
	            threads[i] = new MatrixMultiplication(A, B, C, i);
	            threads[i].start();
	        }
	        for (Thread t : threads) {
	            t.join();
	        }
	        for (int[] row : C) {
	            System.out.println(Arrays.toString(row));
	        }
	    }
}
