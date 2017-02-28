package Mode;

public class MyCollection implements MCollection{

	String[] string=new String[]{"A","B","C","D"};
	
	public MIterator miterator() {
		// TODO Auto-generated method stub
		return new MyIterator(this);
	}

	public Object get(int i) {
		// TODO Auto-generated method stub
		return string[i];
	}

	public int size() {
		// TODO Auto-generated method stub
		return string.length;
	}

}
