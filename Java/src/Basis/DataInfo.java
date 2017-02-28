package Basis;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;


public class DataInfo {

	/**
	 * @param args
	 */
	//压栈出栈的方法实现泛型反转
	public static <T> T[] myStack(T[] array){
		Stack<T> thestack=new Stack<T>();
		for(int i=0;i<array.length;i++){
			thestack.push(array[i]);
		}
        int size=thestack.size();
		for(int i=0;i<size;i++){
			array[i]=thestack.pop();
		}
		return array;
	}
	//压栈出栈的方法实现字符串反转
	public static String strStack(String str){
		Stack<Character> thestack=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			thestack.push(str.charAt(i));
		}
		int size=thestack.size();
		char[] chars=new char[size];
		for(int i=0;i<size;i++){
			chars[i]=thestack.pop();
		}
		return Arrays.toString(chars);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//数字求和运算
		int sum=0;
		int limit=100;
		int i=0;
		do{
		sum+=i;
		i++;
		}while(i<=limit);
		System.out.println("sum:"+sum);
		//利用堆栈将中缀表达式转换成后缀 
		
		//在链表（LinkedList）的开头和结 
		LinkedList<String> linklist=new LinkedList<String>();
		linklist.add("a");
		linklist.add("b");
		linklist.add("c");
		linklist.addFirst("q");
		linklist.addLast("w");
		//获取链表（LinkedList）的第一个 
		System.out.println(linklist.peek());
		System.out.println(linklist.getFirst());
		System.out.println(linklist);
		//删除链表中的元素
		linklist.remove("b");
		System.out.println(linklist);
		//获取链表的元素
		System.out.println(linklist.get(0));
		//获取向量元素的索引值
		Vector<Integer> vector=new Vector<Integer>();
		vector.add(10);
		vector.add(20);
		vector.add(30);
		Collections.sort(vector);
		System.out.println("*"+vector.indexOf(30)+"*");
		//栈的实现
		Stack<String> thestack=new Stack<String>();
		thestack.push("a");
		thestack.push("b");
		thestack.push("c");
		System.out.println(thestack.search("b"));
		System.out.println(thestack.size());
		System.out.println(thestack.isEmpty());
		System.out.println(thestack.peek());
		thestack.pop();
		System.out.println(thestack.peek());
		System.out.println(thestack.pop());
		System.out.println();
		//链表元素查找
		System.out.println(linklist.indexOf("c"));
		System.out.println();
		//压栈出栈的方法实现字符串反转
		String[] str={"w","d","c"};
		System.out.println(Arrays.toString(myStack(str)));
		System.out.println(strStack("abc"));
		//队列（Queue）用法
		Queue<String> queue=new LinkedList<String>();
		queue.add("q");
		queue.add("w");
		queue.add("e");
		System.out.println(queue.poll());//出队列
		System.out.println(queue.peek());
		System.out.println(queue.size());
		//获取向量的最大元素
		System.out.println("*"+Collections.max(vector)+"*");
		//链表修改
		linklist.set(1, "cc");
		System.out.println(linklist);
		System.out.println();
		//旋转向量
		Collections.swap(vector, 0, 1);
		System.out.println(vector);
		
	}

}