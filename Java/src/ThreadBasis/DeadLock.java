package ThreadBasis;

public class DeadLock extends Thread{
public static ThingObject object1=new ThingObject("object1");
public static ThingObject object2=new ThingObject("object2");
public int flag;
public void run(){
	if(flag==0){
		synchronized(object1){
			try {
				Thread.sleep(1000);
				System.out.print("object1++");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(object2){
				System.out.print("object2");
			}
		}
	}
	if(flag==1){
		synchronized(object2){
			try {
				Thread.sleep(1000);
				System.out.print("object2++");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(object1){
				System.out.print("object1");
			}
		}
	}
}
}
