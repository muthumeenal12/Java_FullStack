package exceptionHandling;

import java.io.*;



public class EmptyFile {
public static void main(String[] args) throws IOException {
	
	BufferedReader reader = new BufferedReader(new FileReader(write()));
	if(reader.readLine()==null)
		throw new EOFException("File is Empty!!!!");
}
public static String write() throws IOException {
String path ="file.txt";
BufferedWriter write = new BufferedWriter(new FileWriter(path));
write.close();
return path;
}
}
