package Thread;

import java.util.ArrayDeque;

public class deque {

	/**
	 * @param args
	 */
	
	//双端队列
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(JudgeDeque("asdsa"));
		System.out.println(JudgeDeque("asdsaf"));
	}

	public static boolean JudgeDeque(String string){
		
		int stringLength=string.length();
		
		ArrayDeque<Character> adeque=new ArrayDeque<Character>();
		
		for(int i=0;i<stringLength;i++){
			adeque.addLast(string.charAt(i));
		}
		
		boolean res=true;
		while(adeque.size()>1&&res){
			Character first=adeque.removeFirst();
			Character last=adeque.removeLast();
			if(!first.equals(last)){
				res=false;
			}
		}
		return res;
	}
}
