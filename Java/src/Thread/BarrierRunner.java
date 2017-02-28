package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierRunner implements Runnable{
	
	public int num;
	
	public CyclicBarrier barrier;
	
	public BarrierRunner(int num,CyclicBarrier barrier){
		this.num=num;
		this.barrier=barrier;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(num+" is ready");
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println(num+" is arrived");
		}
	}

}
