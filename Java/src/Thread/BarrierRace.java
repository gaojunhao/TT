package Thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BarrierRace {

	/**
	 * @param args
	 */
	//栅栏
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=5;
		
		CyclicBarrier barrier=new CyclicBarrier(num);

		ExecutorService executor=Executors.newFixedThreadPool(num);
		for(int i=0;i<num;i++){
			executor.submit(new Thread(new BarrierRunner(i,barrier)));
		}
		executor.shutdown();
	}

}
