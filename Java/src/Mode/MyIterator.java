package Mode;

public class MyIterator implements MIterator{
	
	public MCollection mcollection;
	
	public int pos=-1;
	
	public MyIterator(MCollection mcollection){
		this.mcollection=mcollection;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(pos<mcollection.size()-1){
			pos++;
			return true;
		}
		return false;
	}

	public Object next() {
		// TODO Auto-generated method stub
		return mcollection.get(pos);
	}

}
