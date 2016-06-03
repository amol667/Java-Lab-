package java10;

public class InputThreads {
	
	public static void main(String[] args) throws InterruptedException { 
	GetStringThread getStringThread=  new GetStringThread();
	GetNumberThread getNumberThread = new GetNumberThread();
	getStringThread.start();
	Thread.sleep(100);
	getNumberThread.start();
	}
}