package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test=new Test();
		test.Testbefore();
		test.Testafter();
		
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.execute(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Runnable");
			}
			
		});
		
	}

}
