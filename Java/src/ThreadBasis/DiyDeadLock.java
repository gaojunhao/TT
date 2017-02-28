package ThreadBasis;

public class DiyDeadLock extends Thread{
public NewObject object1;
public NewObject object2;
public DiyDeadLock(NewObject o1,NewObject o2){
	object1=o1;
	object2=o2;
}
public void run(){
	synchronized(object1){
		try {
			System.out.println("object1");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(object2){
			System.out.println("object2++");
		}
	}
}
}
