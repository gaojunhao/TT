package Basis;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import java.util.regex.Matcher;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import com.google.protobuf.TextFormat.ParseException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class SuperInfo<T> {

	/**
	 * @param args
	 * @throws java.text.ParseException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	
	private T t;
	public void add(T t){
		this.t=t;
	}
	public T get(){
		return t;
	}
	public static void main(String[] args) throws java.text.ParseException, InterruptedException, IOException {
		// TODO Auto-generated method stub
//		A a=new A(2);
//		B b=new B(5);
//		System.out.print(a.x+"\n");
//		System.out.print(b.x);
//		StringBuffer sBuffer=new StringBuffer("hhrgh");
//		char[] a={'a','d','f','r'};
//		sBuffer.append(a);
//        System.out.print(sBuffer+"\t");
//        sBuffer.reverse();
//        System.out.print(sBuffer+"\t");
//        sBuffer.insert(1,"23");
//        System.out.print(sBuffer+"\t");
//        sBuffer.replace(1,5,"223");
//        System.out.print(sBuffer+"\t");
//        System.out.print(sBuffer.capacity());
		
//		double[] myList = {9, 2.9, 3.4, 3.5,7,9};
//		double[] myList1 = new double[5];
//		double max=myList[0];
//		for(double x:myList){
//			max=Math.max(max,x);
//		}
//		System.out.print("max:"+max);
//		Arrays.sort(myList);
//		Arrays.fill(myList1, 2.0);
//		System.out.print(Arrays.equals(myList, myList1));
//		for(double x:myList){
//			System.out.print(x+"\t");
//		}
//		System.out.print(Arrays.binarySearch(myList, 9));
		
//		Date time=new Date();
//		System.out.print(time.toString());
//		SimpleDateFormat ftime=new SimpleDateFormat("yyyy:MM:dd 'at' hh:mm:ss");
//		System.out.print(ftime.format(time));
		
//		Date date;
//		String stringtime="2010-10-10";
//		SimpleDateFormat fs=new SimpleDateFormat("yyyy-MM-dd");
//		date=fs.parse(stringtime);
//		System.out.println(date); 
		
//		System.out.println(new Date()+"\t");
//		Thread.sleep(3000);
//		System.out.println(new Date());
		
//		String Input=new String("cat cat cat cattt cat");
//		String REGEX=new String("\\bcat\\b");
//		String Replacer=new String("dog");
//		Pattern p=Pattern.compile(REGEX);//Pattern编译
//		Matcher m=p.matcher(Input);//获取matcher对象
//		int count=0;
//		while(m.find()){
//			count++;
//			System.out.print("matchnum:"+count+"\n");
//			System.out.print("matchstart:"+m.start()+"\n");
//			System.out.print("matchend:"+m.end()+"\n");
//		}
//		
//		System.out.print("matchlooking:"+m.lookingAt()+"\n");
//		System.out.print("matches:"+m.matches()+"\n");// matcher 要求整个序列都匹配，而lookingAt 不要求
//	    
//		String output=new String(m.replaceAll(Replacer));//替换
//	    System.out.print("output:"+output+"\n");
//	    String output1=new String(m.replaceFirst(Replacer));
//	    System.out.print("output:"+output1+"\n");
//	    
//	    
//	    StringBuffer sb=new StringBuffer();
//	    try{
//	    while(m.find()){
//	    	m.appendReplacement(sb, Replacer);
//	    }
//	    m.appendTail(sb);
//	    System.out.print("StringBufferoutput:"+sb.toString()+"\n");
//	    }catch(PatternSyntaxException e){
//	    	System.out.print("PatternSyntaxException:"+e.getIndex()+"\n");
//	    }
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("q:exit");
//		char c;
//		String str;
////		do{
////			c=(char)br.read();
////			System.out.print(c);
////		}while(c!='q');
//		do{
//			str=br.readLine();
//			System.out.print(str);
//		}while(!str.equals("end"));
		
//		Configuration conf=new Configuration();
//		File filepath=new File("/home/here/Downloads/1.txt");
//		InputStream f=new FileInputStream(filepath);
////		IOUtils.copyBytes(f, System.out, conf);
//		byte[] bytes=new byte[2];
//		int c;
//		while((c=f.read(bytes))>0){
//			System.out.print(new String(bytes,0,c));
//		}
		
//		byte[] b={'d','f','g','c','\n','f','g','c'};
//		ByteArrayInputStream binput=new ByteArrayInputStream(b);
//		int c;
//		while((c=binput.read())!=-1){
//			System.out.print(Character.toUpperCase((char)c));
//		}
		
//		OutputStream output=new FileOutputStream("/home/here/Downloads/8.txt");
//		output.write(b);
//		FileInputStream fip=new FileInputStream("/home/here/Downloads/8.txt");
//		InputStreamReader input=new InputStreamReader(fip,"UTF-8");
//		StringBuffer strbuf=new StringBuffer();
//		while(input.ready()){
//			strbuf.append((char)input.read());
//		}
//		System.out.print(strbuf.toString());
//		fip.close();
//		input.close();
//		output.close();
		
//		String path=new String("/home/here/Downloads/newfile");
//		File fs=new File(path);
//	    fs.mkdirs();
		
//		String path=new String("/home/here/Downloads");
//		File fs=new File(path);
//		String[] dir=fs.list();
//		for(String dirpath:dir){
////			System.out.print(dirpath+"\n");
//			String newpath=path+"/"+dirpath;
//			File newfs=new File(newpath);
//			if(newfs.isDirectory()){
//				System.out.print(newpath+" is dir"+"\n");
//			}
//		}
		
//		Scanner scan=new Scanner(System.in);
//		String c=new String();
//		while(scan.hasNext()){
//			c=scan.next();
//			System.out.print(c+"\n");
//		}
//		while(scan.hasNextLine()){
//			c=scan.nextLine();
//			System.out.print(c+"\n");
//		}
		
		//------------------------数据结构－－－－－－－－－－－－－－－－－－－－//
//		Enumeration days;
//		Vector dayNames=new Vector();
//		dayNames.add("one");
//		dayNames.add("two");
//		days=dayNames.elements();
//		while(days.hasMoreElements()){
//			System.out.print(days.nextElement()+"\n");
//		}
		
//		BitSet bt=new BitSet(16);
//		BitSet bt1=new BitSet(16);
//		for(int i=0;i<16;i++){
//			if((i%2)==0)
//				bt.set(i);
//			 if((i%5)!=0)
//				bt1.set(i);
//		}
//		System.out.println(bt);
//		bt.and(bt1);
////		bt.clear();
//		BitSet bt2=(BitSet) bt.clone();
//		System.out.println(bt2);
		
//		Vector v=new Vector();
//		v.add("q");
//		v.add("w");
//		v.add("e");
//		System.out.print(v.capacity());
//		System.out.print(v.contains("3"));
//		System.out.print(v.get(1).hashCode());
		
//		double a;
//		Stack st=new Stack();
//		for(int i=0;i<3;i++){
//			a=Math.random();
//			st.push(a);
//			System.out.print(st+"\n");
//		}
//		System.out.print("##########");
//		for(int i=0;i<3;i++){
//			a=Math.random();
//			st.pop();
//			System.out.print("\n"+st);
//		}
		
//		Map map=new HashMap();
//		map.put("a","1");
//		map.put("b","2");
//		map.put("c","3");
//		System.out.print(map+"\n");
//		System.out.print(map.size()+"\n");
//		System.out.print(map.get("b"));
		
//		Hashtable hsmap=new Hashtable();
//		hsmap.put("q",new Double(5.42));
//		hsmap.put("w",new Double(79.42));
//		hsmap.put("e",new Double(5.665));
//		System.out.print(hsmap+"\n");
//		System.out.print(hsmap.get("q"));
//		Enumeration nums=hsmap.keys();
//		while(nums.hasMoreElements()){
//			System.out.print(nums.nextElement()+"\n");
//		}
		
//		Properties pros=new Properties();
//		pros.put("q","1");
//		pros.put("w","2");
//		pros.put("e","3");
//		System.out.print(pros+"\n");
//		System.out.print(pros.getProperty("q"));
//		System.out.print(pros.setProperty("q","22"));
//		System.out.print("\n"+pros);
		
		//遍历 ArrayList
//		List<String> list=new ArrayList<String>();
//		list.add("q");
//		list.add("w");
//		list.add("e");
//		Iterator ite=list.iterator();
//		while(ite.hasNext()){
//			System.out.print(ite.next()+"\n");
//		}
		
//		String[] str=new String[list.size()];
//		list.toArray(str);
//		for(int i=0;i<str.length;i++){
//			System.out.print(str[i]+"\n");
//		}
		
		//遍历 Map
//		Map<String,String> map=new HashMap<String,String>();
//		map.put("q","1");
//		map.put("w","2");
//		map.put("e","3");
		
//		Iterator<Map.Entry<String,String>> it=map.entrySet().iterator();
//		while(it.hasNext()){
//			Map.Entry<String,String> entry=it.next();
//			System.out.println("Key:"+entry.getKey()+"\t"+"Value:"+entry.getValue());
//		}
		
//		for(String key:map.keySet()){
//			System.out.println("Key:"+key+"\t"+"Value:"+map.get(key));
//		}
		
//		for(Map.Entry<String,String> entry:map.entrySet()){
//			System.out.println("Key:"+entry.getKey()+"\t"+"Value:"+entry.getValue());
//		}
		//泛型方法
//		String[] stringArray={"q","w","e"};
//		Integer[] intArray={1,2,3};
//		Boolean[] booleanArray={true,false,true};
//		printArray(stringArray);
//		System.out.println();
//		printArray(intArray);
//		System.out.println();
//		printArray(booleanArray);
		
		//泛型方法
//		System.out.println("max:"+maximum(1,2,3));
//		System.out.println("max:"+maximum("w","q","e"));
//		System.out.println("max:"+maximum(2.002,2.0009,2.001));
		
		//泛型类
		SuperInfo<Integer> integerbox=new SuperInfo<Integer>();
		SuperInfo<Character> charbox=new SuperInfo<Character>();
		integerbox.add(8);
		charbox.add('e');
//		getLowerNumber(integerbox);//类型通配符下限通过形如 List<? super Number>来定义，表示类型只能接受Number及其三层父类类型，如Objec类型的实例
		getUperNumber(integerbox);
//		getUperNumber(charbox);//类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型
//		getData(integerbox);
//		getData(charbox);
//		System.out.println(integerbox.get());
//		System.out.println(charbox.get());
	}
	//类型通配符 1、类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类
	public static void getData(SuperInfo<?> t){
		System.out.print(t.get()+"\t");
	}
	public static void getUperNumber(SuperInfo<? extends Number> t){
		System.out.print(t.get()+"\t");
	}
	public static void getLowerNumber(SuperInfo<? super Number> t){
		System.out.print(t.get()+"\t");
	}
	public static <E> void printArray(E[] Array){
		for(E element:Array){
		System.out.print(element);
		}
		}
	public static <T extends Comparable<T>> T maximum(T x,T y,T z){
		T max=x;
		if(y.compareTo(max)>0){
			max=y;
		}
        if(z.compareTo(max)>0){
			max=z;
		}
		return max;
	}
}
