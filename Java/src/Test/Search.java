package Test;

public class Search {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeChain chain=new NodeChain();
		chain.insert("AA", 1);
		chain.insert("BB", 2);
		System.out.print(chain.get("BB"));
	}
}
class NodeChain{
	Node first;
	class Node{
		String name;
		int age;
		Node next;
		public Node(String name,int age,Node next){
			this.name=name;
			this.age=age;
			this.next=next;
		}
        }
	public void insert(String name,int age){
		for(Node n1=first;n1!=null;n1=n1.next){
			if(n1.name.equals(name)){
				n1.age=age;
			}
		}
		first=new Node(name,age,first);
	}
	public int get(String name){
		for(Node n=first;n!=null;n=n.next){
			if(n.name.equals(name)){
				return n.age;
			}
		}
		return -1;
	}
}