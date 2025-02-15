package exceptionHandling;

import java.io.*;

public class ListFile {

	public static void main(String[] args) throws IOException {
			try (//write();
			BufferedReader read = new BufferedReader(new FileReader("NumberList.txt"))) {
				String line;
				while ((line = read.readLine()) != null) {
					String[] num = line.split("\\s+");
					for(String n:num)
					{
						int val = Integer.parseInt(n);
						if(val>0)
							throw new RuntimeException("Positive Number Found!!!"+val);
						else
							System.out.println(val);
					}
				}
				read.close();
			} catch (NumberFormatException e) {

				e.printStackTrace();
			}

		}
	public static String write() throws IOException
	{
		String path="NumberList.txt";
	
		BufferedWriter write = new BufferedWriter(new FileWriter(path));
			write.write(-10 + " ");
			write.write(-190 + " ");
			write.write(-19 + " ");
			write.write(-80 + " ");
			write.write(-110 + " ");
			write.write(-11 + " ");
			write.write(-109 + " ");
			write.write(901 + " ");
			write.close();
			return path;

	}
	}

