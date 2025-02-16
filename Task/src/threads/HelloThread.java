package threads;

public class HelloThread extends Thread{
	//Extend Thread class
	//override run method
	public void run(){
		System.out.println("Hello, Java");
	}
	public static void main(String[] args) {
		HelloThread thread = new HelloThread();
		thread.start();
	}

}
