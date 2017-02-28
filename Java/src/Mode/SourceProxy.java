package Mode;

public class SourceProxy implements Source{
	
	public SourceMethod sourceMethod;
	
	public SourceProxy(){
		this.sourceMethod=new SourceMethod();
	}

	public void method1() {
		// TODO Auto-generated method stub
		before();
		sourceMethod.method1();
		after();
	}

	public void method2() {
		// TODO Auto-generated method stub
		before();
		sourceMethod.method2();
		after();
	}

	public void before(){
		System.out.println("before");
	}
	public void after(){
		System.out.println("after");
	}
}
