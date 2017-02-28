package ThreadBasis;

public class ThreadDemo implements Runnable{
	private Thread t;
	private String threadName;
    ThreadDemo(String threadname){
	threadName=threadname;
	System.out.println("Creating " +  threadName );
}
    public void run(){
    	System.out.println("Running " +  threadName );
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void start(){
    	System.out.println("Starting " +  threadName );
    	if(t==null){
    		t=new Thread(this,threadName);
    	    t.start();
    	}
    }
}
