package Mode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class P2C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		BlockingQueue<String> queue=new LinkedBlockingQueue<String>(2);
		
		Producer producer=new Producer(queue);
		Customer customer=new Customer(queue);
		for(int i=0;i<5;i++){
			new Thread(producer,"Producer"+(i+1)).start();
			new Thread(customer,"Customer"+(i+1)).start();
		}
		
	}

}
