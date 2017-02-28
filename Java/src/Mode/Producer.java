package Mode;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	public BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> queue){
		this.queue=queue;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		String tmp=Thread.currentThread().getName();
		System.out.println("producer:"+tmp);
		try {
			queue.put(tmp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
