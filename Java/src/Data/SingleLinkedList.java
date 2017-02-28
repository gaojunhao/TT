package Data;

public class SingleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1=new Person(1,"A",10);
		Person p2=new Person(2,"B",20);
		Person p3=new Person(3,"C",30);
        PersonChain chain=new PersonChain();
        chain.addNode(p1);
        chain.addNode(p2);
        chain.addNode(p3);
//        chain.deleteNode(1);
//        System.out.println(chain.searchNode(2));
        chain.editNode(2, 40);
        chain.editNode(2, "D");
        chain.printAllNode();
        chain.sort();
        chain.printAllNode();
	}

}
class Person{
	public int id;
	public String name;
	public int age;
	public Person(int _id,String _name,int _age){
		id=_id;
		name=_name;
		age=_age;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
    public String toString(){
		return "id:"+id+" name:"+name+" age:"+age;
	}
}
class PersonNode{
	public Person person;
	public PersonNode node;
	public PersonNode(Person _person,PersonNode _node){
		person=_person;
		node=_node;
	}
	public Person getPerson(){
		return person;
	}
	public PersonNode getPersonNode(){
		return node;
	}
}
class PersonChain{
	private PersonNode head;
	private int size;
	private int modCount;
	public int getSize(){
		return size;
	}
	public void addNode(Person p){
		if(!contain(p.id)){
			if(head!=null){
				head=new PersonNode(p,head);//有头节点，添加新的节点作为新的头节点
				size++;
				modCount++;
			}else{
				head=new PersonNode(p,null);//没有头节点
				size++;
				modCount++;
			}
		}
	}
	public boolean contain(int personid){
		if(size!=0){
			for(PersonNode pnode=head;pnode!=null;pnode=pnode.node){
				if(pnode.person.id==personid) return true;
			}
		}
		return false;
	}
	public void printAllNode(){
		if(size!=0){
			for(PersonNode pnode=head;pnode!=null;pnode=pnode.node){
				System.out.println(pnode.person);
			}
		}
	}
	public void deleteNode(int personid){
		if(size==0){
			return;
		}
		if(size==1){
			if(head.person.id==personid){
				head=null;
				size=0;
			}
			return;
		}
		if(!contain(personid)){
			return;
		}
		int index=0;
		for(PersonNode pnode=head;pnode!=null;pnode=pnode.node){
			if(pnode.person.id==personid){
				break;
			}
			index++;
		}
		if(index==0){
			head=new PersonNode(head.node.person,head.node.node);
			size--;
			modCount++;
			return;
		}
		int count=0;
		for(PersonNode pnode=head;pnode!=null;pnode=pnode.node){
			if(count==index-1){
				if(index==size){
					pnode.node=null;
				}else{
				pnode.node=pnode.node.node;
				}
				size--;
				modCount++;
				return;
			}
			count++;
		}
		
	}
    public Person searchNode(int personid){
    	Person p=null;
		for(PersonNode pnode=head;pnode!=null;pnode=pnode.node){
			if(pnode.person.id==personid){
//				System.out.println(pnode.person);
				p=pnode.person;
			}
		}
		return p;
	}
    public void editNode(int personid,Object obj){
		Person p=searchNode(personid);
		if(p==null){
			return;
		}
		if(obj==null){
			return;
		}
//		if(obj.getClass()==java.lang.String.class){
//			p.name=obj.toString();
//			return;
//		}else if(obj.getClass()==java.lang.Integer.class){
//			p.age=Integer.parseInt(obj.toString());
//			return;
//		}
		if(obj.getClass()==java.lang.String.class){
			p.name=obj.toString();
			return;
		}try{
			p.age=Integer.parseInt(obj.toString());
			return;
		}catch(Exception e){
			System.out.println(e);
			return;
		}
	}
    public void sort(){
    	for(PersonNode pnode=head;pnode!=null;pnode=pnode.node){
    		for(PersonNode p=head;p.node!=null;p=p.node){
    			if(p.person.age>p.node.person.age){
    				Person tmp=p.person;
    				p.person=p.node.person;
    				p.node.person=tmp;
    			}
    		}
    	}
    }
    
}