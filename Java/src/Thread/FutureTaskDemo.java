package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		ExecutorService executor=Executors.newSingleThreadExecutor();
		FutureTask<Integer> futuretask=new FutureTask<Integer>(
		new Callable<Integer>(){

			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return fibc(6);
			}
		}		
		);
		executor.submit(futuretask);
		System.out.println("future task result:"+futuretask.get());
		executor.shutdown();
	}

	public static Integer fibc(int num){
		if(num==0){
			return 0;
		}
		if(num==1){
			return 1;
		}
		return fibc(num-1)+fibc(num-2);
	}
}
