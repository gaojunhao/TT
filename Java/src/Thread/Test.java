package Thread;

public class Test extends UnderTest{
public void Testbefore(){
	try{
		System.out.println("Test before");
	}finally{
		before();
	}
}
public void Testafter(){
	try{
		after();
	}finally{
		System.out.println("Test after");
	}
}
}
