package Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortInfo {

	/**
	 * @param args
	 */
	public static double[] auk;
	public static void DoubleSort(){
		Double[] a=new Double[10];
		for(int i=0;i<10;i++){
			a[i]=Math.random();
		}
		System.out.println(Arrays.toString(a));
//		Arrays.sort(a);
		Arrays.sort(a, new DoubleSort());
		System.out.println(Arrays.toString(a));
	}
	public static void StringSort(){
		String[] a={"ab","bc","ac"};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void ChooseSort(double[] a){
		int min;
		int tmp;
		for(int i=0;i<a.length;i++){
			min=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[min]){
					min=j;
				}
			}
			exchange(a,min,i);
		}
//		System.out.println(Arrays.toString(a));
	}
	public static boolean compare(double p,double q){
		if(p<q) return true;
		else return false;
	}
	public static void exchange(double[] a,int p,int q){
		double tmp;
		tmp=a[p];
		a[p]=a[q];
		a[q]=tmp;
	}
	public static void InsertSort(double[] a){
		for(int i=0;i<a.length;i++){
			for(int j=i;j>0&&compare(a[j],a[j-1]);j--){
				exchange(a,j,j-1);
			}
		}
//		System.out.println(Arrays.toString(a));
	}
	public static void ShellSort(double[] a){
		int h=1;
		int n=3;
		int N=a.length;
		while(h<N/n){
			h=n*h+1;//间隔:1,4,13...
		}
		while(h>=1){
		for(int i=h;i<N;i++){
			for(int j=i;j>=h&&compare(a[j],a[j-h]);j-=h){
				exchange(a,j,j-h);
			}
		}
		h=h/n;
		}
	}
	public static void merge(double[] a,int lo,int mid,int hi){
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<hi+1;k++){
			auk[k]=a[k];
		}
		for(int k=lo;k<hi+1;k++){
			if(i>mid) a[k]=auk[j++];
			else if(j>hi) a[k]=auk[i++];
			else if(compare(auk[i],auk[j])) a[k]=auk[i++];
			else a[k]=auk[j++];
		}
	}
	public static void MergeSort(double[] a,int lo,int hi){
		if(lo>=hi) return;
		int mid=(lo+hi)/2;
		MergeSort(a,lo,mid);
		MergeSort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	public static void MergeSort2(double[] a){
		int N=a.length;
		for(int sz=1;sz<N;sz=sz+sz){
			for(int lo=0;lo<N-sz;lo+=sz+sz){
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	public static void QuickSort(double[] a,int lo,int hi){
		if(lo>=hi) return;
		int j=partion(a,lo,hi);
		QuickSort(a,lo,j);
		QuickSort(a,j+1,hi);
	}
	public static int partion(double[] a,int lo,int hi){
		int i=lo;
		int j=hi+1;
		double v=a[lo];
		while(true){
			while(compare(a[++i],v)) if(i==hi) break;
			while(compare(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exchange(a,i,j);
		}
		exchange(a,lo,j);
		return j;
	}
	public static void Heapsort(int[] a){
		int N=a.length-1;
		for(int i=N/2;i>=1;i--){
			sink(a,i,N);
		}
		while(N>1){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	public static void sink(int[] a,int i,int n){
		while(2*i<n){
			int j=2*i;
			if(less(a,j,j+1)) j++;
			if(!less(a,i,j)) break;
			exch(a,i,j);
			i=j;
		}
	}
    public static void exch(int[] a,int i,int n){
		int tmp;
		tmp=a[n];
		a[n]=a[i];
		a[i]=tmp;
	}
    public static boolean less(int[] a,int i,int j){
    	return a[i]<a[j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a=new double[1000];
		for(int i=0;i<1000;i++){
			a[i]=Math.random()*1000;
		}
        DoubleSort();
        StringSort();
        long ChooseSortstart=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
        ChooseSort(a);
        }
        long ChooseSortstop=System.currentTimeMillis();
        System.out.printf("选择排序时间:%d",(ChooseSortstop-ChooseSortstart));
        System.out.println();
        for(int i=0;i<1000;i++){
        InsertSort(a);
        }
        long InsertSortstop=System.currentTimeMillis();
        System.out.printf("插入排序时间:%d",(InsertSortstop-ChooseSortstop));
        System.out.println();
        for(int i=0;i<1000;i++){
        	ShellSort(a);
            }
        long ShellSortstop=System.currentTimeMillis();
        System.out.printf("shell排序时间:%d",(ShellSortstop-InsertSortstop));
        System.out.println();
        auk=new double[a.length];
        for(int i=0;i<1000;i++){
        MergeSort(a,0,a.length-1);
        }
        long MergeSortstop=System.currentTimeMillis();
        System.out.printf("归并排序时间:%d",(MergeSortstop-ShellSortstop));
        System.out.println();
        double[] b={5,3,8,2,9,1,0,4};
//        MergeSort2(b);
//        System.out.println(Arrays.toString(b));
        QuickSort(b,0,b.length-1);
        System.out.println(Arrays.toString(b));
        
        Queue<population> priorityQueue=new PriorityQueue<population>(5,new sortPopulation());
        population p1=new population("A",10);
        population p2=new population("B",20);
        population p3=new population("C",30);
        priorityQueue.add(p1);
        priorityQueue.add(p2);
        priorityQueue.add(p3);
        for(int i=0;i<3;i++){
        population p=priorityQueue.poll();
        System.out.println(p.getAge());
        }
        
        HeapSort heapsort=new HeapSort(8);
        heapsort.insert(8);
        heapsort.insert(3);
        heapsort.insert(6);
        heapsort.insert(2);
        heapsort.insert(9);
        heapsort.insert(5);
        heapsort.insert(4);
        heapsort.insert(7);
        heapsort.delMax();
        System.out.println(heapsort);
        
        int[] c={7,3,6,8,2,9,4};
        int[] d=new int[c.length+1];
        d[0]=0;
        System.arraycopy(c, 0, d, 1, c.length);
        System.out.println(Arrays.toString(d));
        Heapsort(d);
        System.out.println(Arrays.toString(d));
	}

}
class DoubleSort implements Comparator<Double>{

	public int compare(Double o1, Double o2) {
		// TODO Auto-generated method stub
		return (o1<o2)?1:-1;
	}
	
}
class population{
	private String name;
	private int age;
	public population(String _name,int _age){
		name=_name;
		age=_age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}
class sortPopulation implements Comparator<population>{

	public int compare(population o1, population o2) {
		// TODO Auto-generated method stub
		return (o1.getAge()<o2.getAge())?1:-1;
	}
	
}
class HeapSort{
	private int[] heap;
	private int N=0;
	public HeapSort(int num){
		heap=new int[num+1];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void insert(int t){
		heap[++N]=t;
		swim(N);
	}
	public int delMax(){
		int max=heap[1];
		exch(1,N--);
		sink(1);
		return max;
	}
	public void swim(int n){
		while(n>1&&less(n/2,n)){
			exch(n/2,n);
			n=n/2;
		}
	}
	public void sink(int t){
		while(2*t<N){
		int j=2*t;
		if(less(j,j+1)) j++;
		if(!less(t,j)) break;
		exch(t,j);
		t=j;
		}
	}
	public boolean less(int i,int j){
		return heap[i]<heap[j];
	}
	public void exch(int i,int j){
		int tmp;
		tmp=heap[i];
		heap[i]=heap[j];
		heap[j]=tmp;
	}
	public String toString(){
		String str="";
		for(int i=1;i<N+1;i++){
			str+=" "+String.valueOf(heap[i]);
		}
		return str;
	}
}