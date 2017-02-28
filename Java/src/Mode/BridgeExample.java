package Mode;

public class BridgeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SourceMethod source=new SourceMethod();
		
        Bridge bridge=new MyBridge();
        bridge.set(source);
        bridge.method();
	}

}
