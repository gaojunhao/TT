package ThreadBasis;

public class ThreadMethod extends Thread{
	public static int count;
	public NewObject object;
	public ThreadMethod(NewObject o){
		object=o;
		count=0;
	}
	//**************************锁定引用的对象,单对象多线程*********************************//
	//synchronized修饰代码块
//public void run(){
//	synchronized(this){
//		for(int i=0;i<5;i++){
//			System.out.println(Thread.currentThread().getName()+"/"+count++);
//		}
//	}
//}
	
	//synchronized修饰方法
//	public synchronized void run(){
//		
//			for(int i=0;i<5;i++){
//				System.out.println(Thread.currentThread().getName()+"/"+count++);
//			}
//		}
	
	//synchronized修饰对象
//	public void run(){
//		synchronized(object){
//			object.save(100);
//			object.get(50);
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			object.query();
//		}
//	}
	//*****************锁定类，静态方法****************//
	//synchronized修饰静态方法
//	public synchronized static void method(){
//		for(int i=0;i<5;i++){
//			System.out.println(Thread.currentThread().getName()+"/"+count++);
//		}
//	}
//	public synchronized void run(){
//	method();
//	}
	//synchronized修饰类
	public void run(){		
		synchronized(ThreadMethod.class){for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"/"+count++);
			}
		}
	}
	
}
