package ThreadBasis;

public class Threadinfo extends Thread{
private String threadName;
private Thread t;
Threadinfo(String threadname){
	this.threadName=threadname;
}
public void run(){
	
		try {
			for(int i=0;i<4;i++){
				System.out.println("Runing"+threadName+"-"+i);	
			Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
public void start(){
	System.out.println("Starting"+"\t"+threadName);
	if(t==null){
		t=new Thread(this,threadName);
	    t.start();
	}
}
}
