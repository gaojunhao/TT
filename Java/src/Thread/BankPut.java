package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class BankPut implements Callable<String>{
public BlockingQueue<String> queue;
public BankPut(BlockingQueue<String> queue){
	this.queue=queue;
}
	public String call() throws Exception {
		// TODO Auto-generated method stub
		synchronized(this){
		if(queue.size()>=3){
			wait();
		}
		queue.put(Thread.currentThread().getName());
		notifyAll();
		return Thread.currentThread().getName();
		}
	}

}
