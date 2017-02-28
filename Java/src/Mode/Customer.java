package Mode;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
	
	public BlockingQueue<String> queue;
	
	public Customer(BlockingQueue<String> queue){
		this.queue=queue;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			String tmp=queue.take();
			System.out.println("Customer:"+tmp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
