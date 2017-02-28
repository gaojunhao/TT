package Test;

import java.util.Arrays;

public class sort {
public static void main(String[] args){
	int[] array=new int[]{55,52,34,31,11,65};
	select(array);
//	insert(array);
//	shell(array);
//	mergeSort(array,0,array.length);
    int b=BT(array,34, 0, array.length);
    System.out.print(b);
	System.out.print(Arrays.toString(array));
}
public static int BT(int[] a,int b,int lo,int hi){
	int mid=lo+(hi-lo)/2;
	if(lo>=hi) return -1;
	if(b<a[mid]) return BT(a,b,lo,mid);
	else if(b>a[mid]) return BT(a,b,mid+1,hi);
	else return mid;
}
public static void select(int[] a){
	for(int i=0;i<a.length;i++){
		for(int j=i+1;j<a.length;j++){
			if(more(a,i,j)){
				exch(a,i,j);
			}
		}
	}
}
public static void insert(int[] a){
	for(int i=0;i<a.length;i++){
		for(int j=0;j<=i;j++){
			if(more(a,j,i)){
				exch(a,i,j);
			}
		}
	}
}
public static void insert2(int[] a){
	for(int i=1;i<a.length;i++){
		for(int j=i;j>0;j--){
			if(less(a,j-1,j)){
				exch(a,j-1,j);
			}
		}
	}
}
public static void shell(int[] a){
	int N=a.length;
	int h=1;
	while(h<N/3) h=3*h+1;
	while(h>=1){
	for(int i=h;i<N;i++){
		for(int j=i;j>=h&&less(a,j-h,j);j-=h){
			exch(a,j-h,j);
		}
	}
	h=h/3;
	}
}
public static void merge(int[] a,int lo,int mid,int hi){
	int i=lo;
	int j=mid+1;
	int[] aux=new int[a.length];
	for(int t=lo;t<hi;t++){
		aux[t]=a[t];
	}
	for(int k=lo;k<hi;k++){
		if(i>mid) a[k]=aux[j++];
		else if(j>hi) a[k]=aux[i++];
		else if(less(aux,j,i)) a[k]=aux[j++];
		else a[k]=aux[i++];
	}
}
public static void mergeSort(int[] a,int lo,int hi){
	int mid=lo+(hi-lo)/2;
	if(hi<=lo) return;
	mergeSort(a,lo,mid);
	mergeSort(a,mid+1,hi);
	merge(a,lo,mid,hi);
}
public static void exch(int[] a,int i,int j){
	int c=a[j];
	a[j]=a[i];
	a[i]=c;
}
public static boolean more(int[] a,int i,int j){
	if(a[i]>a[j]){
		return true;
	}else{
		return false;
	}
}
public static boolean less(int[] a,int i,int j){
	if(a[i]<a[j]){
		return true;
	}else{
		return false;
	}
}
}
