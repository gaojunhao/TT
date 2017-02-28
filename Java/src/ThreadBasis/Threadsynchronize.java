package ThreadBasis;

public class Threadsynchronize extends Thread{
public Data data;
public Threadsynchronize(Data t){
	data=t;
}
public void run(){
	
	try {
		for(int i=0;i<3;i++){
			data.fix(30);
			data.getdata();
//		System.out.println(this.getName()+"/"+data.getdata());
		Thread.sleep(1000);
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
