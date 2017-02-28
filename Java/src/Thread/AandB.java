package Thread;

public class AandB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ainterface a=Aclass.newA();
		a.execute(new B(){

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("AandB");
			}
			
		});
	}

}
