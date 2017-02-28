package Mode;

public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MCollection collection=new MyCollection();
        MIterator iterator=collection.miterator();
        while(iterator.hasNext()){
        	System.out.print(iterator.next());
        }
	}

}
