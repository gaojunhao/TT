package Mode;

public class Proxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Source source=new SourceProxy();
        source.method1();
        source.method2();
	}

}
