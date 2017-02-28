package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a={{1,2},{3,4},{5,6}};
        TwoDArray(a);
        int m=20;
        int[] b=new int[30];
        for(int i=0;i<b.length;i++){
        	b[i]=(int) Math.floor(Math.random()*m);
        }
        System.out.println(Arrays.toString(histogram(b,m)));
        System.out.println("阶乘..:"+Math.log(numlevel(5)));
        int[] c={5,2,6,8,9,4,3};
        Arrays.sort(c);//很重要
        System.out.println(rank(c,0,c.length-1,3,0));
        System.out.println(rear(16,12));
        int[] d={5,2,6,8,9,4,3,2,6};
        Arrays.sort(d);
        System.out.println(del(d));
        int[] e={5,2,6,8,9,4,3,2,6,9,0};
        System.out.println(delset(e));
	}
    public static void TwoDArray(int[][] a){
    	int[][] b=new int[a[0].length][a.length];
    	for(int i=0;i<a.length;i++){
    		for(int j=0;j<a[i].length;j++){
    		System.out.print(a[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	for(int i=0;i<a.length;i++){
    		for(int j=0;j<a[i].length;j++){
    		b[j][i]=a[i][j];
    		}
    	}
    	for(int i=0;i<b.length;i++){
    		for(int j=0;j<b[i].length;j++){
    		System.out.print(b[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    public static int[] histogram(int[] a,int M){
    	int[] b=new int[M];
    	int sum=0;
    	for(int j=0;j<M;j++){
    		int count=0;
    	for(int i=0;i<a.length;i++){
    		if(j==a[i]) count++;
    	}
    	b[j]=count;
    	}
    	for(int i=0;i<b.length;i++) sum+=b[i];
    	System.out.println("sum:"+sum);
    	return b;
    }
    public static int numlevel(int n){
    	if(n<=1) return n;
    	return n*numlevel(n-1);
    }
    public static String rank(int[] a,int lo,int hi,int b,int count){
    	count++;
    	if(lo>hi) return "postion no found level:"+count;
    	int mid=(lo+hi)/2;
    	if(a[mid]==b) return "postion:"+mid+" level:"+count;
    	else if(b<a[mid]) return rank(a,lo,mid-1,b,count);
    	else  return rank(a,mid+1,hi,b,count);
    }
    public static int rear(int p,int q){
    	if(q==0) return p;
    	return rear(q,p%q);
    }
    public static List<Integer> del(int[] a){
    	List<Integer> list=new ArrayList<Integer>();
    	int tmp=a[0];
    	list.add(a[0]);
    	for(int i=0;i<a.length;i++){
    		if(tmp!=a[i]){
    			tmp=a[i];
    			list.add(a[i]);
    		}
    	}
    	return list;
    }
    public static Set<Integer> delset(int[] a){
    	Set<Integer> set=new HashSet<Integer>();
    	for(int b:a)
    		set.add(b);
    	return set;
    }
}
