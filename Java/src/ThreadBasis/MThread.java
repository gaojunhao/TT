package ThreadBasis;

public class MThread extends Thread{
public boolean suspend=false;
public void run(){
	for(int i=0;i<10;i++){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-"+i);
		synchronized(this){
			
	while(suspend){
		try {
			wait();//需要synchronized
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		}
}
}
public void Suspend(){
	this.suspend=true;
	System.out.println("suspending");
}
public synchronized void Resume(){
	this.suspend=false;
	System.out.println("resuming");
	notify();//需要synchronized
}
}
