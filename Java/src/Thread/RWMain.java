package Thread;

import java.util.HashMap;
import java.util.Map;

public class RWMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String,String> map=new HashMap<String,String>();
		RWMap<String,String> rw=new RWMap<String,String>(map);
		rw.put("A", "1");
		rw.put("B", "2");
		System.out.println(rw.get("A"));
	}

}
