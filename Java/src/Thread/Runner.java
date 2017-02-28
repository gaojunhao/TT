package Thread;

import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
	
	public int num;
	
	public CountDownLatch begin;
	
	public CountDownLatch end;
	
	public Runner(int num,CountDownLatch begin,CountDownLatch end){
		this.num=num;
		this.begin=begin;
		this.end=end;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(num+"is ready");
			//等待开始
			begin.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			end.countDown();
			System.out.println(num+"is arrived");
		}
	}

}
