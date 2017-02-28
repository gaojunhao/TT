package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class BankGet implements Callable<String>{
public BlockingQueue<String> queue;
public BankGet(BlockingQueue<String> queue){
	this.queue=queue;
}
public String call() throws Exception {
	// TODO Auto-generated method stub
synchronized(this){
	if(queue.isEmpty()){
		wait();
	}
	notifyAll();
	return queue.poll();
}
}
}
