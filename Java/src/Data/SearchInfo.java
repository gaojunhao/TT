package Data;

import java.util.Arrays;

public class SearchInfo {

	/**
	 * @param args
	 */
	public static int rank(int[] a,int lo,int hi,int data){
		int mid=(lo+hi)/2;
		if(a[mid]==data) return mid;
		else if(data<a[mid]) return rank(a,lo,mid-1,data);
		else if(data>a[mid]) return rank(a,mid+1,hi,data);
		else return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//顺序查找（基于无序链表）
        SequentialSearch sq=new SequentialSearch();
        sq.put(1,"A");
        sq.put(2,"B");
        sq.put(3,"C");
        System.out.println(sq.get(2));
        //二分查找
        int[] a={7,8,2,4,6,9,1};
        Arrays.sort(a);
        System.out.println(rank(a,0,a.length,9));
        //二叉查找树
        BST bst=new BST();
        Key key1=new Key("A",2);
        Key key2=new Key("B",6);
        Key key3=new Key("C",4);
        Key key4=new Key("D",1);
        Key key5=new Key("E",5);
        bst.put(key1, "AA");
        bst.put(key2, "BB");
        bst.put(key3, "CC");
        bst.put(key4, "DD");
        bst.put(key5, "EE");
        System.out.println(bst.get(key3)+bst.size());
        System.out.println(bst.max());
        System.out.println(bst.select(0));
        System.out.println(bst.rank(key2));
        bst.delete(key2);
        System.out.println(bst.max());
        //散列表
        SeparateChainingHashST st=new SeparateChainingHashST();
        st.put(key1, "A");
        st.put(key2, "B");
        st.put(key3, "C");
        st.put(key4, "D");
        System.out.println(st.get(key3));
        //可伸缩数组
        MyArray arr=new MyArray();
        arr.push(key1);
        arr.push(key2);
        arr.push(key3);
        arr.push(key4);
        arr.push(key5);
        arr.pop();
        arr.pop();
        arr.pop();
	}
}
class MyArray{
	public static int N;
	public Key[] array=new Key[4];
	public void resize(int sz){
		Key[] temp=new Key[sz];
		for(int i=0;i<N;i++){
			temp[i]=array[i];
		}
		array=temp;
		
	}
	public void push(Key key){
		if(N==array.length) resize(2*N);
		array[N++]=key;
//		System.out.println(array.length);
	}
	public Key pop(){
		Key key=array[--N];
		array[N]=null;
		if(N>0&&N==array.length/2) resize(array.length/2);
//		System.out.println(array.length);
		return key;
	}
}
class SeparateChainingHashST{
	public int M=997;
	public SequentialLinklist[] st=new SequentialLinklist[M];
	public SeparateChainingHashST(){
		for(int i=0;i<M;i++){
			st[i]=new SequentialLinklist();
		}
	}
	public int hash(Key key){
		return (key.hashCode()&0x7fffffff)%M;
	}
	public String get(Key key){
		return st[hash(key)].get(key);
	}
	public void put(Key key,String val){
		st[hash(key)].put(key, val);
	}
}
class SequentialLinklist{
	Node first;
	private class Node{
		public Node next;
		public String val;
		public Key key;
		public Node(Node node,Key _key,String _val){
			next=node;
			key=_key;
			val=_val;
		}
	}
	public String get(Key _key){
		if(first==null) return null;
		for(Node n=first;n!=null;n=n.next){
			if(n.key==_key) return n.val;
		}
		return null;
	}
	public void put(Key _key,String _val){
			first=new Node(first,_key,_val);
	}
}
class SequentialSearch{
	Node first;
	private class Node{
		Node next;
		int key;
		String val;
		public Node(Node _node,int _key,String _val){
			next=_node;
			key=_key;
			val=_val;
		}
	}
	public void put(int _key,String _val){
		for(Node nd=first;nd!=null;nd=nd.next){
			if(nd.key==_key){ 
				nd.val=_val;
				return;
		}
		}
		first=new Node(first,_key,_val);
	}
	public String get(int _key){
		for(Node nd=first;nd!=null;nd=nd.next){
			if(nd.key==_key){
				return nd.val;
			}
		}
		return null;
	}
}
class BST{
	Node root;
	private class Node{
		public Key key;
		public String val;
		public Node left,right;
		public int size;
		public Node(Key _key,String _val,int _size){
			key=_key;
			val=_val;
			size=_size;
		}
	}
	public int size(){
		return size(root);
	}
	public int size(Node x){
		if(x==null) return 0;
		else return x.size;
	}
	public Key min(){
		return min(root).key;
	}
	public Node min(Node x){
		if(x.left==null) return x;
		return min(x.left);
	}
	public Key max(){
		return max(root).key;
	}
	public Node max(Node x){
		if(x.right==null) return x;
		return max(x.right);
	}
	public String get(Key _key){
		return get(root,_key);
	}
	public void put(Key _key,String _val){
		root=put(root,_key,_val);
	}
	public String get(Node x,Key _key){
		if(x==null) return null;
		int cmp=_key.compareTo(x.key);
		if(cmp<0) return get(x.left,_key);
		else if(cmp>0) return get(x.right,_key);
		else return x.val;
	}
	public Node put(Node x,Key _key,String _val){
		if(x==null) return new Node(_key,_val,1);
		int cmp=_key.compareTo(x.key);
		if(cmp<0)  x.left=put(x.left,_key,_val);
		else if(cmp>0)  x.right=put(x.right,_key,_val);
		else x.val=_val;
		x.size=size(x.left)+size(x.right)+1;
		return x;
	}
	public Key select(int k){
		return select(root,k).key;
	}
	public Node select(Node x,int k){
		if(x==null) return null;
		int t=size(x.left);
		if(k<t) return select(x.left,k);
		else if(k>t) return select(x.right,k-t-1);
		else return x;
	}
	public int rank(Key key){
		return rank(root,key);
	}
	public int rank(Node x,Key key){
		if(x==null) return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return rank(x.left,key);
		else if(cmp>0) return rank(x.right,key)+size(x.left)+1;
		else return size(x.left);
	}
	public void deleteMin(){
		root=deleteMin(root);
	}
	public Node deleteMin(Node x){
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		x.size=size(x.left)+size(x.right)+1;
		return x;
	}
	public void delete(Key key){
		root=delete(root,key);
	}
	public Node delete(Node x,Key key){
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=delete(x.left,key);
		else if(cmp>0) x.right=delete(x.right,key);
		else{
			if(x.left==null) return x.right;
			if(x.right==null) return x.left;
			Node t=x;
			x=min(x.right);
			x.right=deleteMin(x.right);//deleteMin(x.right)返回的是root
			x.left=t.left;
		}
		x.size=size(x.left)+size(x.right)+1;
		return x;
	}
}
class Key implements Comparable<Key>{
	public String name;
	public int age;
	public Key(String _name,int _age){
		name=_name;
		age=_age;
	}
	public int getAge(){
		return age;
	}
	public String toString(){
		return name;
	}
	public int compareTo(Key o) {
		// TODO Auto-generated method stub
		return (this.getAge()>o.getAge())?1:(this.getAge()==o.getAge())?0:-1;
	}
}