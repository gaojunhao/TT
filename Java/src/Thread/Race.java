package Thread;

import java.util.concurrent.CountDownLatch;

public class Race {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=10;
		CountDownLatch begin=new CountDownLatch(1);
		CountDownLatch end=new CountDownLatch(num);
		//准备
		for(int i=0;i<num;i++){
			new Thread(new Runner(i,begin,end)).start();
		}
		System.out.println("judge say run");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//开始
		begin.countDown();
		long startTime=System.nanoTime();
		try {
			//等待结束
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			long endTime=System.nanoTime();
			System.out.println("judge say all arrived");
			System.out.println("all time:"+(endTime-startTime));
		}
	}

}
