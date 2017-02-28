package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		BlockingQueue<String> queue=new LinkedBlockingQueue<String>(4);
		BankPut bankput=new BankPut(queue);
		BankGet bankget=new BankGet(queue);
		ExecutorService executor=Executors.newFixedThreadPool(6);
		
//		Future<String> future1=executor.submit(bankput);
//		System.out.println("put:"+future1.get());
//		
//		Future<String> future=executor.submit(bankget);
//		System.out.println("get:"+future.get());
		
		for(int i=0;i<20;i++){
			System.out.println("put:"+executor.submit(bankput).get());
			System.out.println("get:"+executor.submit(bankget).get());
		}
		executor.shutdown();
	}

}
