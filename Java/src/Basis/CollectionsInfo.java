package Basis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class CollectionsInfo {

	/**
	 * @param args
	 */
	public static void displayCollections(Collection col){
		Iterator ite=col.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//数组转集合
		String [] str={"a","B","c","H"};
		List<String> list=Arrays.asList(str);
		System.out.println(list);
		//集合比较
		Set<String> set=new TreeSet<String>();
		for(int i=0;i<str.length;i++){
			set.add(str[i]);
		}
		System.out.println("min:"+Collections.min(set));
		System.out.println("min:"+Collections.min(set,String.CASE_INSENSITIVE_ORDER));
		System.out.println("max:"+Collections.max(set));
		System.out.println("max:"+Collections.max(set,String.CASE_INSENSITIVE_ORDER));
		//HashMap遍历
		HashMap<Integer,String> hmap=new HashMap<Integer,String>();
		hmap.put(1, "1st");
		hmap.put(2, "2nd");
		hmap.put(3, "3st");
		Collection<String> clo=hmap.values();
		Iterator<String> ite=clo.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		//集合长度
		HashSet<Double> hset=new HashSet<Double>();
		hset.add(3.99);
		hset.add(3.39);
		hset.add(5.99);
		Iterator iterator=hset.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println(hset.size());
		//集合打乱顺序
		List<Double> list1=new ArrayList<Double>();
		for(int i=0;i<5;i++){
			list1.add(Math.random());
		}
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);
		//集合遍历
		for(Double num:list1){
			System.out.println(num);
		}
		//集合反转
		Collections.reverse(list1);
		System.out.println(list1);
		//删除集合中指定元素
		hset.remove(3.99);
		System.out.println(hset);
		//只读集合
		List<Integer> list2=Arrays.asList(new Integer[]{2,3,4,6,4});
		Set hset1=new HashSet(list2);
		System.out.println(hset1);
		hset1=Collections.unmodifiableSet(hset1);
//		hset1.add(7);
		System.out.println(hset1);
		//集合输出
		Hashtable<Integer,String> hmap1=new Hashtable<Integer,String>(); 
		hmap1.put(1, "aa");
		hmap1.put(2, "bc");
		hmap1.put(3, "ab");
		System.out.println("**"+hmap1.values()+"**");
		HashMap<Integer,String> hmap2=new HashMap<Integer,String>(); 
		hmap2.put(1, "aa");
		hmap2.put(2, "bc");
		hmap2.put(3, "ab");
		System.out.println("**"+hmap2.values()+"**");
		TreeMap<Integer,String> tmap=new TreeMap<Integer,String>(); 
		tmap.put(1, "aa");
		tmap.put(2, "bc");
		tmap.put(3, "ab");
		System.out.println("**"+tmap.values()+"**");
		Iterator<Integer> tmap_ite=tmap.keySet().iterator();
		while(tmap_ite.hasNext()){
			System.out.println(tmap.get(tmap_ite.next()));
		}
		System.out.println(tmap.keySet());
		System.out.println(tmap.values());
		System.out.println(tmap.get(tmap.firstKey()));
		System.out.println(tmap.remove(tmap.lastKey()));
		System.out.println(tmap.keySet());
		//集合转数组
		Double[] dnum=hset.toArray(new Double[0]);
		System.out.println(Arrays.toString(dnum));
		Double[] dnum1=list1.toArray(new Double[0]);
		String[] dnum2=list.toArray(new String[0]);
		System.out.println(Arrays.toString(dnum2));
		//List 循环移动元素
		Collections.rotate(list, 2);
		System.out.println(list);
		//查找 List 中的最大最小值
		System.out.println(Collections.max(list2));
		System.out.println(Collections.min(list2));
		//遍历 HashTable 的键值
		Hashtable<Integer,String> htable=new Hashtable<Integer,String>();
		htable.put(1, "a");
		htable.put(2, "b");
		htable.put(3, "c");
		System.out.println(htable.keySet());
		System.out.println(htable.values());
		//使用 Enumeration 遍历 HashTable
		Enumeration<Integer> e=htable.keys();
		while(e.hasMoreElements()){
//			System.out.println(e.nextElement());
			Object key=e.nextElement();
			System.out.println(htable.get(key));
		}
		//集合中添加不同类型元素
		//displayCollections(perlist);
		//List 元素替换
		String[] str1="one two three one two three".split(" ");
		List<String> alllist=Arrays.asList(str1);
		Collections.replaceAll(alllist, "one", "four");
		System.out.println(alllist);
		//List 截取
		String[] str2="two three".split(" ");
		List<String> sublist=Arrays.asList(str2);
		System.out.println("##"+Collections.indexOfSubList(alllist, sublist)+"##");
		System.out.println("##"+Collections.lastIndexOfSubList(alllist, sublist)+"##");
		//HashMap以<key,value>存储至哈希表中，允许value　null,key允许null，线程非安全,key不可以重复，value允许重复
		//TreeMap存储至红黑二叉数中,value不允许null,线程非安全，对存入的元素自动排序,迭代输出的时候就按排序顺序输出 
		//HashTable线程同步,只允许一个key为null,多个value为null
		//两种常规Map性能: 
		//HashMap：适用于在Map中插入、删除和定位元素。
		//Treemap：适用于按自然顺序或自定义顺序遍历键(key)。 
		
//		List特点：元素有放入顺序，元素可重复 
//		Map特点：元素按键值对存储，无放入顺序 
//		Set特点：元素无放入顺序，元素不可重复（注意：元素虽然无放入顺序，但是元素在set中的位置是有该元素的HashCode决定的，其位置其实是固定的） 
//		List接口有三个实现类：LinkedList，ArrayList，Vector 
//		LinkedList：底层基于链表实现，链表内存是散乱的，每一个元素存储本身内存地址的同时还存储下一个元素的地址。链表增删快，查找慢 
//		ArrayList和Vector的区别：ArrayList是非线程安全的，效率高；Vector是基于线程安全的，效率低 
//		Set接口有两个实现类：HashSet(底层由HashMap实现)，LinkedHashSet 
//		SortedSet接口有一个实现类：TreeSet（底层由平衡二叉树实现） 
//		Query接口有一个实现类：LinkList 
//		Map接口有三个实现类：HashMap，HashTable，LinkeHashMap 
//		  HashMap非线程安全，高效，支持null；HashTable线程安全，低效，不支持null 
//		SortedMap有一个实现类：TreeMap 
//		其实最主要的是，list是用来处理序列的，而set是用来处理集的。Map是知道的，存储的是键值对 
//		set 一般无序不重复.map kv 结构 list 有序 
		
		/*HashMap TreeMap Hashtable*/
		User user1=new User("1","A",20);
		User user2=new User("2","B",25);
		User user3=new User("3","C",21);
		User user4=new User("4","D",22);
		LUser user5=new LUser("1","E",23);
		HashMap<User,Integer> hsmap=new HashMap<User,Integer>();
		hsmap.put(user1, 100);
		hsmap.put(user2, 200);
		hsmap.put(user3, 300);
		hsmap.put(user4, 400);
		hsmap.put(user5, 500);
		System.out.println(hsmap.values());

		TreeMap<User,Integer> trmap=new TreeMap<User,Integer>();
		trmap.put(user1, 10);
		trmap.put(user2, 20);
		trmap.put(user3, 30);
		trmap.put(user4, 40);
		System.out.println(trmap.values());
		//总结:对于HashMap而言，只要key的equals相等就表示两个元素相等，HashMap就存不进去；而TreeMap是不管equals和hashCode的，只要compareTo相等就表示两个元素相同，就存不进去。
	    
		List<User> userlist=new ArrayList<User>();
		userlist.add(user1);
		userlist.add(user2);
		userlist.add(user3);
		userlist.add(user4);
		userlist.add(user5);
		System.out.println(userlist);
		Collections.sort(userlist);
		System.out.println(userlist);
		
		//模型与算法分离
		Person person1=new Person("1","A1",10);
		Person person2=new Person("2","A2",30);
		Person person3=new Person("3","A3",30);
		Person person4=new Person("2","A4",40);
		Map<Person,Integer> permap=new HashMap<Person,Integer>();
		permap.put(person1, 11);
		permap.put(person2, 21);
		permap.put(person3, 31);
		permap.put(person4, 41);
		System.out.println(permap);
		
		TreeMap<Person,Integer> pertre=new TreeMap<Person,Integer>(new sortPerson());
		pertre.put(person1, 11);
		pertre.put(person2, 21);
		pertre.put(person3, 31);
		pertre.put(person4, 41);
		System.out.println(pertre);
		
		List<Person> perlist=new ArrayList<Person>();
		perlist.add(person1);
		perlist.add(person2);
		perlist.add(person3);
		perlist.add(person4);
		System.out.println(perlist);
		Collections.sort(perlist, new sortPerson());
		System.out.println(perlist);
		
		displayCollections(perlist);
		
	}

}
class LUser extends User{
	public LUser(String _id,String _name,Integer _age){
		super(_id,_name,_age);
	}
}
class User implements Comparable<User>{
	private String id;
	private String name;
	private Integer age;
	public User(String _id,String _name,Integer _age){
		id=_id;
		name=_name;
		age=_age;
	}
	public void setId(String _id){
		id=_id;
	}
	public void setName(String _name){
		name=_name;
	}
	public void setAge(Integer _age){
		age=_age;
	}
	public  String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public Integer getAge(){
		return age;
	}
	public String toString(){
		return this.name;
	}
//	public boolean equals(Object obj){
//		return true;
//	}
//	public int hashCode(){
//		return 0;
//	}
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}//两个对象的引用指向的地址
		if(obj==null){
			return false;
		}
		if(this.getClass()!=obj.getClass()){
			return false;
		}//类不同
		//以下是针对继承不同的类，如果继承相同的类则在hashCode中已经过滤掉了
		User other=(User) obj;//强制转换类
		if(id==null){
			if(other.id!=id){
				return false;
			}//null不能使用equals方法
		}else if(!other.id.equals(id)){
			return false;
		}
		return true;
	}
	public int hashCode(){
		final int prime=31;
		int result=1;
		result=prime*result+((id==null)?0:id.hashCode());
		return result;
	}//先判断hashCode后判断equals,使用主键来重新定义hashCode
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.age>o.getAge()?1:this.age==o.getAge()?0:-1;//>升序，=则存不进去
	}

}
class Person{
	private String id;
	private String name;
	private int age;
	public Person(String _id,String _name,int _age){
		id=_id;
		name=_name;
		age=_age;
	}
	public void setId(String _id){
		id=_id;
	}
	public void setName(String _name){
		name=_name;
	}
	public void setAge(int _age){
		age=_age;
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	@Override
	public String toString(){
		return name;
	}
	@Override
	public int hashCode(){
		final int prime=31;
		int result=1;
		result=prime*result+((id==null)?0:id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(getClass()!=obj.getClass()){
			return false;
		}
		Person other=(Person) obj;
		if(id==null){
			if(other.id!=id){
				return false;
			}
		}else if(!id.equals(other.id)){
			return false;
		}
		return true;
	}
}
class sortPerson implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return (o1.getAge()>=o2.getAge())?1:-1;
	}
	
}