package Basis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.INEG;


public class ArrayInfo {

	/**
	 * @param args
	 */
	//打印数组
	public static void printarray(int[] arr){
		System.out.println("result:");
		for(int s:arr){
			System.out.println(s);
		}
	}
	//插入新数字后的新数组
	public static int[] addarray(int[] array,int num,int newindex){
		int[] destarray=new int[array.length+1];
		System.arraycopy(array, 0, destarray, 0, newindex);
		destarray[newindex]=num;
		System.arraycopy(array, newindex, destarray, newindex+1, array.length-newindex);
		return(destarray);
	}
	//添加任意数据类型（引用类型）数组至ArrayList
	public static <T> ArrayList arraychange(T[] d){
		ArrayList arraylist=new ArrayList();
		for(T t:d){
			arraylist.add(t);
		}
		return arraylist;
	}
	//添加任意数量的引用类型数组至ArrayList
	public static <T> T[] addarray(T[] input,T[]...rest){
		int length=input.length;
		for(T[] array:rest){
			length+=array.length;
		}
		T[] allarray=Arrays.copyOf(input, length);
		int offset=input.length;
		for(T[] array:rest){
			System.arraycopy(array, 0, allarray, offset, array.length);
			offset+=array.length;
		}
		return allarray;
	}
	//int[]转Integer[]
	public static Integer[] tointeger(int[] t){
		Integer[] integer=new Integer[t.length];
		for(int i=0;i<t.length;i++){
			integer[i]=Integer.valueOf(t[i]);
		}
		return integer;
	}
	//Integer转int
	public static int[] toint(Integer[] t){
		int[] a=new int[t.length];
		for(int i=0;i<t.length;i++){
			a[i]=t[i].intValue();
		}
		return a;
	}
	//set并集，元素唯一性
	public static Integer[] union(int[] a,int[]...rest){
		Integer[] inta=tointeger(a);
		Set<Integer> set=new HashSet<Integer>(); 
		for(Integer i:inta){
			set.add(i);
		}
		for(int[] array:rest){
			Integer[] intarray=tointeger(array);
			for(Integer t:intarray){
				set.add(t);
			}
		}
		Integer[] t = new Integer[set.size()];
		return  set.toArray(t);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//二维数组，数组的第一维装的是一个一维数组的引用，第二维里是元素数值
		int[] array={1,-2,3,-4,5,-6,7,-8,9,3};
		int[] array1={1,-2,3,-4};
		int[] array2={1,-2,3,-4,0};
        //数组排序及元素查找
		Arrays.sort(array);
		printarray(array);
		int index=Arrays.binarySearch(array, -6);
		System.out.println("index:"+index);
		//数组添加元素
		int num=-5;
		int index1=Arrays.binarySearch(array, num);//插入的位置
		int newindex=-index1-1;
		printarray(addarray(array,num,newindex));
		//获取数组长度
		System.out.println(array.length);
		//数组反转
		ArrayList arraylist=new ArrayList();
		for(int x:array){
		arraylist.add(x);
		}
		System.out.println("before:"+arraylist);
		Collections.reverse(arraylist);
		System.out.println("after:"+arraylist);
		//数组输出
		
		//数组获取最大和最小值
		//1)
		int max=array[0];
		for(int x:array){
			max=Math.max(max, x);
		}
		System.out.println("max:"+max);
		//2)
		Integer[] integerarray1=tointeger(array);
		Integer[] integerarray2=tointeger(array1);
		int listmax=Collections.max(Arrays.asList(integerarray1));
		int listmin=Collections.min(Arrays.asList(integerarray1));
		System.out.println("listmax:"+listmax+"\nlistmin:"+listmin);
		//数组合并
		//1)
		String[] a={"A","S","D"};
		String[] b={"c","d"};
		List list=new ArrayList(Arrays.asList(a));
		list.addAll(Arrays.asList(b));
		Object[] c=list.toArray();
		System.out.println("String:"+Arrays.toString(c));
		//2)
		Integer[] integer={1,-2,3,-4,5,-6,7,-8,9,3};
		Integer[] integer1={1,-2,3,-4};
		Integer[] d=new Integer[integer.length+integer1.length];
		System.arraycopy(integer, 0, d, 0, integer.length);
		System.arraycopy(integer1, 0, d, array.length, integer1.length);
		System.out.println("Integer:"+arraychange(d));
		//3)
		Integer[] aa=Arrays.copyOf(integer,integer.length+integer1.length);
		System.arraycopy(integer1, 0, aa, integer.length, integer1.length);
		System.out.println("Integer2:"+arraychange(aa));
		//4)
		Integer[] integer0={1,-2,3,-4,5,-6,7,-8,9,3};
		Integer[] integer2={1,-2,3,-4};
		Integer[] integer3={1,-2,3,-4,5,-6,7,-8,9,3};
		Integer[] integer4={1,-2,3,-4};
		System.out.println(Arrays.toString(addarray(integer0,integer2,integer3,integer4)));
		//5)Arrays.asList()括号内的类型必须为引用类型的数据类型
		int[] int11={1,-2,3,-4,5,-6,7,-8,9,3};
		int[] int22={1,-2,3,-4};
		Integer[] int1=tointeger(int11);
		Integer[] int2=tointeger(int22);
		List intergerlist=new ArrayList(Arrays.asList(int1));
		intergerlist.addAll(Arrays.asList(int2));
		Object[] intergerall=intergerlist.toArray();
		System.out.println(Arrays.toString(intergerall));
		//数组填充
		int[] array3=new int[6];
		Arrays.fill(array3, 100);
		System.out.println(Arrays.toString(array3));
		Arrays.fill(array3, 3, 6, 50);
		System.out.println(Arrays.toString(array3));
		//数组扩容
		String[] str1={"a","b","c"};
		String[] str2=new String[5];
		str2[3]="d";
		str2[4]="e";
		System.arraycopy(str1, 0, str2, 0, str1.length);
		System.out.println("扩容后的数组:"+Arrays.toString(str2));
		//数组排序及查找
		
		//删除数组元素
		ArrayList arraylist1=new ArrayList();
		arraylist1.add(0,"a");
		arraylist1.add(1,"b");
		arraylist1.add(2,"c");
		System.out.println("删除前:"+arraylist1);
//		arraylist1.remove(0);
//		arraylist1.remove("b");
//		System.out.println("删除后:"+arraylist1);
		//数组差集
		ArrayList arraylist2=new ArrayList();
		arraylist2.add(0,"a");
		arraylist2.add(1,"b");
//		arraylist1.removeAll(arraylist2);
		System.out.println("差集:"+arraylist1);
		//数组交集
//		arraylist1.retainAll(arraylist2);
		System.out.println("交集:"+arraylist1);
		//在数组中查找指定元素
		System.out.println("是否包含元素:"+arraylist1.contains("b"));
		System.out.println("是否包含数组:"+arraylist1.contains(arraylist2));
		//判断数组是否相等
		System.out.println("数组是否相等：:"+Arrays.equals(array,array1));
		//数组并集
		System.out.println("并集:"+Arrays.toString(union(array,array1,array2)));
	}

}
