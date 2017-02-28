package ThreadBasis;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadMoreInfo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//查看线程是否存活
//		thread thr=new thread("new thread");
//		System.out.println("before:"+thr.isAlive());
//		thr.start();
//		System.out.println("start:"+thr.isAlive());
//		thr.printthread();
//		System.out.println("after:"+thr.isAlive());
		//获取当前线程名称
//		System.out.println("current threadname:"+Thread.currentThread().getName());
		//状态监测
//		threadstate thread1=new threadstate();
//		thread1.setName("thread1");
//		thread1.start();
//		thread1.sleep(300);
//		System.out.println("thread state:"+thread1.isAlive());
//		thread1.suspending();
//		System.out.println("thread state:"+thread1.isAlive());
//		thread1.Resume();
//		while(thread1.isAlive()){
//			System.out.println("thread is alive");
//		}
		//线程优先级设置(适用于Runnable)
//		Thread thread1=new Thread(new thread("thread1"));
//		Thread thread2=new Thread(new thread("thread2"));
//		thread2.setPriority(Thread.MIN_PRIORITY);
//		thread1.setPriority(Thread.MAX_PRIORITY);
//		thread1.start();
//		thread2.start();
//		thread1.join();
//		thread2.join();
//		for(int i=0;i<5;i++){
//			System.out.println("current thread:"+Thread.currentThread().getName()+"thread priority:"+Thread.currentThread().getPriority()+"loop:"+i);
//		}
		//多线程同步计数
//		ExecutorService executor=Executors.newFixedThreadPool(10);
//		for(int i=0;i<10;i++){
//			threadpoolsynchronized thread=new threadpoolsynchronized();
//			executor.execute(thread);
//			if(i==9){
//				System.out.println("count:"+thread.getcount());
//			}
//		}
		//死锁及解决方法
//		object obj1=new object("obj1");
//		object obj2=new object("obj2");
//		new Thread(new deadlock(obj1,obj2)).start();
//		new Thread(new deadlock(obj2,obj1)).start();
		//获取线程id
//		Threadid id1=new Threadid();
//		Threadid id2=new Threadid();
//		Threadobj obj1=new Threadobj(id1);
//		Threadobj obj2=new Threadobj(id2);
//		new Thread(obj1,"threadA").start();
//		new Thread(obj2,"threadB").start();
//		new Thread(obj1,"threadC").start();
		//线程挂起
		//subThread.join();//主线程挂起，子线程运行完后后主线程运行
		//中断线程
//		Thread thread1=new ThreadInterrupt();
//		thread1.start();
//		System.out.println("10s内按键中断");
//		System.in.read();
//		thread1.interrupt();
//		thread1.join();
		
//		ThreadInterrupt2 thread2=new ThreadInterrupt2();
//		thread2.start();
//		Thread.sleep(1000);
//		thread2.interrupt=true;
		//生产者/消费者问题
//		bank bk=new bank();
//		consumer consumer1=new consumer(bk);
//		producer producer1=new producer(bk);
//		consumer1.start();
//		producer1.start();
		//获取线程状态
		/*
		 * 1.新建状态（New）
		 * 2. 就绪状态（Runnable）
		 * 3. 运行状态（Running）
		 * 4. 阻塞状态（Blocked）
		 * （一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。
		 * （二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
		 * （三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。
		 * 5. 死亡状态（Dead）
		 * */
		//获取所有线程
//		for(int i=0;i<3;i++){
//			switch(i){
//			case 1:
//				System.out.println("*"+i);
////				break;
//			case 2:
//				System.out.println("%"+i);
////				break;
//			default:
//				System.out.println("&"+i);
////				break;
//			}
//		}
		ExecutorService executor=Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++){
			task mytask=new task(i);
			executor.execute(mytask);
		}
		ThreadGroup currentgroup=Thread.currentThread().getThreadGroup();
		int threadnum=currentgroup.activeCount();
		Thread[] threads=new Thread[threadnum];
		currentgroup.enumerate(threads);
		for(int i=0;i<threadnum;i++){
			System.out.println("线程号:"+i+" "+threads[i].getName()+" "+threads[i].getPriority());
		}
		//查看线程优先级
		//中断线程
		//线程池
		//手动配置线程池参数
//		ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
//	    for(int i=0;i<15;i++){
//	    	task mytask=new task(i);
//	    	executor.execute(mytask);
//	    	System.out.println("线程池中线程数目:"+executor.getPoolSize()+"队列中等待执行的任务数目:"+executor.getQueue().size()+"已执行完别的任务数目"+executor.getCompletedTaskCount());
//	    }
		//corePoolSize=maximumPoolSize
//		ExecutorService executor=Executors.newFixedThreadPool(10);
//		for(int i=0;i<15;i++){
//	    	task mytask=new task(i);
//	    	executor.execute(mytask);
//	    }
		//corePoolSize=maximumPoolSize=1
//		ExecutorService executor=Executors.newSingleThreadExecutor();
//		for(int i=0;i<15;i++){
//	    	task mytask=new task(i);
//	    	executor.execute(mytask);
//	    }
		//corePoolSize=0,maximumPoolSize=Integer.MAX_VALUE
//		ExecutorService executor=Executors.newCachedThreadPool();
//		for(int i=0;i<15;i++){
//	    	task mytask=new task(i);
//	    	executor.execute(mytask);
//	    }
		//总结
//		从它们的具体实现来看，它们实际上也是调用了ThreadPoolExecutor，只不过参数都已配置好了。
//		newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的LinkedBlockingQueue；
//		newSingleThreadExecutor将corePoolSize和maximumPoolSize都设置为1，也使用的LinkedBlockingQueue；
//		newCachedThreadPool将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE，使用的SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程。
	}

}
//class thread extends Thread{
	class thread implements Runnable{
    public String name;
    public thread(String _name){
    	name=_name;
    }
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
		System.out.println("current thread:"+Thread.currentThread().getName()+"thread priority:"+Thread.currentThread().getPriority()+"loop:"+i);
	}
	}
	public void printthread(){
		System.out.println("current thread:"+Thread.currentThread().getName());
	}
}
class task implements Runnable{
	public int taskName;
	public task(int name){
		taskName=name;
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("running task:"+taskName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end task:"+taskName);
	}
}
class threadstate extends Thread{
	public boolean suspend=false;

	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(100);
				System.out.println("current thread:"+Thread.currentThread().getName());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				System.out.println("interrupted.");
				e1.printStackTrace();
			}
			
			while(suspend){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("interrupted");
					e.printStackTrace();
				}
			}
		}
		System.out.println("current thread:"+Thread.currentThread().getName()+" is terminating");
	}
	public void suspending(){
		suspend=true;
		System.out.println("suspending");
	}
	public synchronized  void Resume(){
		suspend=false;
		System.out.println("resuming");
		notify();
	}
}
class threadpoolsynchronized implements Runnable{
	private static int count=0;

	public void run() {
		// TODO Auto-generated method stub
		synchronized(this){
			count++;
			System.out.println(Thread.currentThread().getName()+" count:"+count);
		}
	}
	public int getcount(){
		return count;
	}
	
}
class object{
	public String name;
	public object(String _name){
		name=_name;
	}
}
class deadlock implements Runnable{
	public object obj1;
	public object obj2;
	public deadlock(object _obj1,object _obj2){
		obj1=_obj1;
		obj2=_obj2;
	}
	public void run() {
		// TODO Auto-generated method stub
		synchronized(obj1){
			try {
				Thread.sleep(3000);
				System.out.println("synchronized "+obj1.name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj2){
				System.out.println("synchronized obj2"+obj2.name);
			}
		}
	}
}
class Threadid extends ThreadLocal{
	private int nextID;
	public Threadid(){
		nextID=10001;
	}
	private synchronized Integer getNewID(){
		Integer id=new Integer(nextID);
		nextID++;
		return id;
	}
	protected Object initialValue(){//需重写
		System.out.println(Thread.currentThread().getName()+" initialValue");
		return getNewID();
	}
	public int getThreadid(){
		Integer id=(Integer)get();
		return id.intValue();
	}
}
class Threadobj extends Object implements Runnable{
	public Threadid threadid;
	public Threadobj(Threadid _threadid){
		threadid=_threadid;
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"**--**"+threadid.getThreadid());
	}
}
class ThreadInterrupt extends Thread{
	public void run(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
class ThreadInterrupt2 extends Thread{
	public boolean interrupt=false;
	public void run(){
		while(!interrupt){
			try {
				Thread.sleep(200);
				System.out.println("running...");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("terminating...");
	}
}
class bank{
	public int content;
	public boolean available=false;
	public synchronized int get(){
		if(available==false){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		available=false;
		notifyAll();
		return content;
	}
	public synchronized void put(int val){
		while(available==true){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		content=val;
		available=true;
		notifyAll();
	}
} 
class consumer extends Thread{
	public bank bk;
	public consumer(bank _bk){
		bk=_bk;
	}
	public void run(){
		for(int i=0;i<10;i++){
		System.out.println("consumer get"+bk.get());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
class producer extends Thread{
	public bank bk;
	public producer(bank _bk){
		bk=_bk;
	}
	public void run(){
		for(int i=0;i<10;i++){
		bk.put(i);
		System.out.println("producer put"+i);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}