package Thread;

public class Count implements Runnable{
private int count=0;
public int getCount(){
	return count;
}
public synchronized void addCount(){
	count++;
}
public synchronized void print(){
	System.out.println(count);
}
public void run() {
	// TODO Auto-generated method stub
	try {
		for(int i=0;i<400;i++){
		addCount();
        print();
		Thread.sleep(1);
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
