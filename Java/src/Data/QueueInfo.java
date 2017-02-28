package Data;

public class QueueInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        queue<Integer> q=new queue<Integer>();
        q.push(10);
        q.push(30);
        q.push(20);
//        q.poll();
//        q.deleteLastNode();
        q.sort();
        System.out.println(q);
	}

}
class queue<T>{
	public int size;
	public Node tail;
	public Node head;
	private class Node{
		public T item;
		public Node node;
		public Node(T t,Node n){
			item=t;
			node=n;
		}
	}
	public void push(T t){
		//保存旧节点
		Node lasttail=tail;
		//新建新节点
		tail=new Node(t,null);
		//若头节点不存在，链接新节点与头节点;若头节点存在，链接旧节点与新节点
		if(head==null) head=tail;
		else lasttail.node=tail;
		size++;
	}
	public T poll(){
		if(head==null){
			return null;
		}else{
			T item=head.item;
			head=head.node;
			size--;
			return item;
		}
	}
	public String toString(){
		String str="";
		for(Node n=head;n!=null;n=n.node){
			str+=n.item+" ";
		}
		return str;
	}
	public void deleteLastNode(){
		int count=0;
		for(Node n=head;n!=null;n=n.node){
			if(count==size-2){
				n.node=null;
			}
			count++;
		}
	}
	public void sort(){
		T tmp;
		for(Node n=head;n!=null;n=n.node){
			for(Node p=head;p.node!=null;p=p.node){
				if(Integer.valueOf(p.item.toString())>Integer.valueOf(p.node.item.toString())){
					tmp=p.item;
					p.item=p.node.item;
					p.node.item=tmp;
				}
			}
		}
	}
}