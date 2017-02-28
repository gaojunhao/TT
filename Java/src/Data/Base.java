package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Base {

	/**
	 * @param args
	 */
	public static int gcb(int a,int b){
		if(b==0) return a;//递归算法的出口
		return gcb(b,a%b);
	}
	public static <T> T[] reverseArray(T[] a){
		int len=a.length;
		T tmp;
		for(int i=0;i<len/2;i++){
			tmp=a[i];
			a[i]=a[len-1-i];
			a[len-1-i]=tmp;
		}
		return a;
	}
	public static int binarySearch(int[] a,int b){
		int len=a.length;
		int low=0;
		int high=len-1;
		while(low<=high){
			int middle=(low+high)/2;
			if(b<a[middle]) high=middle-1;
			else if(b==a[middle]) return middle;
			else low=middle+1;
		}
		return -1;
	}
	public static int rank(int[] a,int low,int high,int b){
		if(low>high) return -1;
		else{
			int middle=(low+high)/2;
			if(b<a[middle]) return rank(a,low,middle-1,b);
			else if(b==a[middle]) return middle;
			else return rank(a,middle+1,high,b);
		}
	}
	public static <T> LinkedList<T> linkT(LinkedList<T> a){
		a.removeLast();
		return a;
	}
	public static double formula(String stdin){
		Stack<String> express=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		for(int i=0;i<stdin.length();i++){
			String exp=String.valueOf(stdin.charAt(i));
			if(exp.equals("(")) ;
			else if(exp.equals("+")) express.push(exp);
			else if(exp.equals("-")) express.push(exp);
			else if(exp.equals("*")) express.push(exp);
			else if(exp.equals("/")) express.push(exp);
			else if(exp.equals("sqrt")) express.push(exp);
			else if(exp.equals(")")){
				String exppop=express.pop();
				double val=vals.pop();
				if(exppop.equals("+")) val=vals.pop()+val;
				else if(exppop.equals("-")) val=vals.pop()-val;
				else if(exppop.equals("*")) val=vals.pop()*val;
				else if(exppop.equals("/")) val=vals.pop()/val;
				else if(exppop.equals("sqrt")) val=Math.sqrt(vals.pop());
			    vals.push(val);
			}else{
				vals.push(Double.valueOf(exp));
			}
		}
		return vals.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//欧几里德算法
//        System.out.println(gcb(18,16));
		//颠倒数组元素的顺序
		String[] b={"A","B","C","D","E"};
		System.out.println(Arrays.toString(reverseArray(b)));
		String[] c=b;
		//起别名
		c[2]="F";
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(b));
		//二维数组
		int[][] num={{1,2,3},{4,5,6}};
		//二分查找法
		int[] number={3,6,2,8,5,7};
		Arrays.sort(number);
		System.out.println(Arrays.toString(number));
		System.out.println("index:"+binarySearch(number,8));
		//二分查找的递归实现
		System.out.println("index:"+rank(number,0,5,5));
		//引用型数据类型 Byte Integer Short Long Double Float Char Boolean String 
		//原始数据类型 byte int short long float double char boolean
		//引用类型继承toString() compareTo() equals() hashCode()方法
		//引用型数据类型与原始数据类型的转化
		byte d1=8;
		Byte d2=Byte.valueOf(d1);
		byte d3=d2.byteValue();
		
		int a1=1;
		//int->Integer
		Integer a2=Integer.valueOf(a1);
		//Integer->int
		int a3=a2.intValue();
		
		//int->String
		System.out.println(String.valueOf(a1));
		//Integer->String
		a2.toString();
		//String->Integer
		Integer.parseInt(a2.toString());
		//String->int(Integer与int自动装箱和拆箱)
		Integer.parseInt(a2.toString());
		
		//标准输入输出
//		Scanner scn=new Scanner(System.in);
//		while(scn.hasNext()){
//			System.out.println(scn.next());
//		}
		//TreeMap
		Pers p1=new Pers("A",10);
		Pers p2=new Pers("B",30);
		Pers p3=new Pers("C",40);
		Pers p4=new Pers("B",20);
		TreeMap<Pers,String> trmap=new TreeMap<Pers,String>(new compareage());
		trmap.put(p1, "100");
		trmap.put(p2, "200");
		trmap.put(p3, "300");
		trmap.put(p4, "400");
		System.out.println(trmap);
		//HashMap
		Map<Pers,String> hsmap=new HashMap<Pers,String>();
		hsmap.put(p1, "100");
		hsmap.put(p2, "200");
		hsmap.put(p3, "300");
		hsmap.put(p4, "400");
		System.out.println(hsmap);
		//单位正方形内Ｎ个点中距离最近两点的距离
//		Scanner scan=new Scanner(System.in);
//		System.out.println("请输入一个整数");
//		int Num=0;
//		while(scan.hasNext()){
//			Num=scan.nextInt();
//			break;
//		}
//		ponitD[] p=new ponitD[Num];
//		for(int i=0;i<Num;i++){
//			 p[i]=new ponitD(Math.random(),Math.random());
//		}
//		int allnum=Num*(Num-1)/2;
//		double min=2;
//		double[] array=new double[allnum];
//		int t=0;
//		for(int i=0;i<Num-1;i++){
//			for(int j=i+1;j<Num;j++){
//				array[t]=Math.sqrt(Math.pow(p[i].x-p[j].x,2)+Math.pow(p[i].y-p[j].y,2));
//				t++;
//			}
//		}
//		for(double r:array){
//			min=Math.min(min, r);
//		}
//		System.out.println("min:"+min);
		//Queue() 
		Queue<String> que=new LinkedList<String>();
		que.add("A");
		que.add("B");
		que.add("C");
		System.out.println(que);
		que.poll();
		System.out.println(que);
		//Stack()
		Stack<Integer> sta=new Stack<Integer>();
		sta.push(1);
		sta.push(2);
		sta.push(3);
		System.out.println(sta);
		sta.pop();
		System.out.println(sta);
		//LinkedList
		LinkedList<Character> link=new LinkedList<Character>();
		link.add('a');
		link.add('b');
		link.add('c');
		System.out.println(link);
		link.remove(link.indexOf('c'));
		System.out.println(link);
		//LinkedList<T>
		System.out.println(linkT(link));
		//双栈算术表达式求值算法
//		Scanner scanner=new Scanner(System.in);
//		System.out.println("请输入算术表达式:");
//		String formulastr="";
//		while(scanner.hasNext()){
//			formulastr=scanner.nextLine();
//			break;
//		}
//		System.out.println(formulastr+":"+formula(formulastr));
		//Iterator
		List<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		Iterator<String> ite=list.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}
}
class ponitD{
	public double x;
	public double y;
	public ponitD(double _x,double _y){
		x=_x;
		y=_y;
	}
}
class Pers{
	public String name;
	public int age;
	public Pers(String _name,int _age){
		name=_name;
		age=_age;
	}
	public int getAge(){
		return age;
	}
	public String toString(){
		return name;
	}
	public int hashCode(){
		final int pre=10;
		int result=1;
		result=pre*result+((name==null)?0:name.hashCode());
		return result;
	}
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		Pers other=(Pers)obj;
		if(name==null){
			if(other.name!=name){
				return false;
			}
		}else if(!other.name.equals(name)){
			return false;
		}
		return true;
	}
}
class compareage implements Comparator<Pers>{

	public int compare(Pers o1, Pers o2) {
		// TODO Auto-generated method stub
		return (o1.getAge()>o2.getAge())?1:-1;
	}
	
}