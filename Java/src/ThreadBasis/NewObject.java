package ThreadBasis;

public class NewObject {
private int money;
public String account;
public NewObject(String name){
	account=name;
}
public int save(int m){
	money+=m;
	System.out.println(Thread.currentThread().getName()+" save money "+m);
	return money;
}
public int get(int m){
	if((money-m)<0){
		System.out.println("money not enough");
	}else{
	money-=m;
	System.out.println(Thread.currentThread().getName()+" get money "+m);
	}
	return money;
}
public int query(){
	System.out.println(Thread.currentThread().getName()+" query money "+money);
	return money;
}
}
