package Thread;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ThreadSafe ts=new ThreadSafe();
        String st="A";
        ts.addList(st);
        ts.removeList(st);
	}

}
