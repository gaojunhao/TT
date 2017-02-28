package Data;

public class StackInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        stack<String> st=new stack<String>();
        st.push("A");
        st.push("B");
        st.push("C");
        st.pop();
        System.out.println(st);
        System.out.println(st.size);
	}

}
class stack<T>{
	public int size;
	public Node head;
	private class Node{
		T item;
		Node node;
//		public Node(T _item,Node _node){
//			item=_item;
//			node=_node;
//		}
	}
	public void push(T _t){
//		head=new Node(_t,head);
		//保存旧的节点
		Node lasthead=head;
		//新建新的节点
		head=new Node();
		head.item=_t;
		//链接旧节点与新节点
		head.node=lasthead;
        size++;
		}
	public T pop(){
		T popitem=head.item;
//		head=new Node(head.node.item,head.node.node);
		head=head.node;
		size--;
		return popitem;
	}
	public String toString(){
		String str="";
		for(Node n=head;n!=null;n=n.node){
			str+=n.item;
		}
		return str;
	}
	}
