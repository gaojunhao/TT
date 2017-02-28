package ThreadBasis;

public class Data {
private int num=100;
public int getdata(){
	System.out.println(Thread.currentThread().getName()+"/"+num);
	return num;
}
//线程通信
public synchronized void fix(int y) throws InterruptedException{
	if(num!=100){
		wait();
	}
	num=num-y;
	System.out.print(num);
	notifyAll();
//	synchronized (this){
//		num=num-y;
//	}
	
}
public synchronized void deal(int y) throws InterruptedException{
	if(num==100){
		wait();
	}
	num=num+y;
	System.out.print(num);
	notifyAll();
}
}
