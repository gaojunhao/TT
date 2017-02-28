package ThreadBasis;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runnable
//        ThreadDemo newthread=new ThreadDemo("newthread");
//        newthread.start();
        //thread
//        Runnable newthread1=new ThreadDemo("newthread1");
//        Thread thread=new Thread(newthread1);
//        thread.start();
		//
//		Threadinfo thread1=new Threadinfo("thread1");
//		Threadinfo thread2=new Threadinfo("thread2");
//		thread2.start();
//		thread1.start();
//		System.out.print(thread2.getName());
		
//		Data data=new Data();//多个线程操作的是同一个对象
//        ExecutorService executorService=Executors.newCachedThreadPool();
//        for (int i = 0; i < 3; i++) {
//            executorService.execute(new Threadsynchronize(data));
//        }
//        executorService.shutdown();//关闭线程池，如果不关闭线程池将一直运行。
		final Data data=new Data();
//		Threadsynchronize thread1=new Threadsynchronize(data);
//		Threadsynchronize thread2=new Threadsynchronize(data);
//		Threadsynchronize thread3=new Threadsynchronize(data);
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
		Thread thread1=new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i=0;i<3;i++){
						data.deal(100);
//						data.getdata();
//					System.out.println(Thread.currentThread().getName()+"/"+data.getdata());
					Thread.sleep(200);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		Thread thread2=new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i=0;i<3;i++){
						data.fix(100);
//						data.getdata();
//					System.out.println(Thread.currentThread().getName()+"/"+data.getdata());
					Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		Thread thread3=new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				//轮询
//				boolean i=true;
//				while(i==true){
//					if(data.getdata()==10){
//					System.out.println(Thread.currentThread().getName()+"/"+"666");
//					i=false;
//					}
//				}
				try {
					for(int i=0;i<3;i++){
						data.getdata();
						data.fix(30);
//					System.out.println(Thread.currentThread().getName()+"/"+data.getdata());
					Thread.sleep(300);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
//		DeadLock deadlock1=new DeadLock();
//		DeadLock deadlock2=new DeadLock();
//		deadlock1.flag=0;
//		deadlock2.flag=1;
//		deadlock1.start();
//		deadlock2.start();
		
		//一个对象
//		ThreadMethod thread=new ThreadMethod();
//		Thread method1=new Thread(thread,"method1");
//		Thread method2=new Thread(thread,"method2");
//		method1.start();
//		method2.start();
		
		//两个对象
//		ThreadMethod thread11=new ThreadMethod();
//		ThreadMethod thread22=new ThreadMethod();
//		Thread method1=new Thread(thread11,"method1");
//		Thread method2=new Thread(thread22,"method2");
//		method1.start();
//		method2.start();
		
		//确定某个对象,多对象多线程
//		NewObject object=new NewObject("Andy");
//		NewObject object1=new NewObject("Andy1");
//		ThreadMethod manager=new ThreadMethod(object);
//		ThreadMethod manager1=new ThreadMethod(object1);
//		Thread[] thread=new Thread[5];
//		Thread[] thread11=new Thread[5];
//		for(int i=0;i<5;i++){
//			thread[i]=new Thread(manager,"thread "+i);
//			thread11[i]=new Thread(manager1,"thread11 "+i);
//			thread[i].start();
//			thread11[i].start();
//		}
		
		//synchronized修饰静态方法,类
//		NewObject object1=new NewObject("a");
//		NewObject object2=new NewObject("b");
//		ThreadMethod method1=new ThreadMethod(object1);
//		ThreadMethod method2=new ThreadMethod(object2);
//		Thread[] thread11=new Thread[3];
//		Thread[] thread22=new Thread[3];
//		for(int i=0;i<3;i++){
//			thread11[i]=new Thread(method1,"thread11 "+i);
//			thread22[i]=new Thread(method2,"thread22 "+i);
//			thread11[i].start();
//			thread22[i].start();
//		}
		
		//死锁
//		NewObject object1=new NewObject("a");
//		NewObject object2=new NewObject("b");
//		DiyDeadLock thread11=new DiyDeadLock(object1,object2);
//		DiyDeadLock thread22=new DiyDeadLock(object2,object1);
//		thread11.start();
//		thread22.start();
		
		MThread thread11=new MThread();
		thread11.start();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.next();
			if(str.equals("b")){
				thread11.Suspend();
			}
			else if(str.equals("a")){
				thread11.Resume();
			}
		}	
	}
}
