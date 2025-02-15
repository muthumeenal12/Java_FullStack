package exceptionHandling;

import java.io.*;
import java.util.Scanner;

public class FileEception {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the path: ");
		String path = s.next();
		try (//File name: chocolate.csv
		BufferedReader read = new BufferedReader(new FileReader(path))) {
			System.out.println(read.readLine());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			s.close();
		}
	}
}
