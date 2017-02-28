package Thread;

public class CountVal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
        Count countval=new Count();
        for(int i=0;i<5;i++){
        	new Thread(countval).start();
        }
//        System.out.print("value:"+countval.getCount());
	}

}
