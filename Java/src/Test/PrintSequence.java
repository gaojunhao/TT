package Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		for(int v:stack){
			System.out.print(v+" ");
		}
		System.out.println();
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue.poll());
		for(int v:queue){
			System.out.print(v+" ");
		}
	}

}
