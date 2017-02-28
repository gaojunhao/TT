package Basis;
import java.util.ArrayList;


public class ClassInfo {

	/**
	 * @param args
	 */
	private String name;
	public ClassInfo(){
		System.out.println("无参数构造方法");
	}
	public ClassInfo(String input){
		name=input;
		System.out.println(name);
	}
	public void Info(){
		System.out.println("方法");
	}
	public void Info(String input){
		System.out.println(input);
	}
	//输出数组元素
	public static <T> void printArray(T[] input){
		for(T t:input){
			System.out.println(t);
		}
	}
	//输出数组
	public static <T> void printOneArray(T[] input){
		ArrayList arraylist=new ArrayList();
		for(T t:input){
			arraylist.add(t);
		}
		System.out.println("整个数组:"+arraylist);
	}
	//汉诺塔递归思想
	public static void doTowers(int topN,String from,String inter,String to){
		if(topN==1){
			System.out.println("disk"+topN+":from "+from+" to "+to);
		}else{
			doTowers(topN-1,from,to,inter);//A->B,B C交换
			System.out.println("disk"+topN+":from "+from+" to "+to);//A->C
			doTowers(topN-1,inter,from,to);//B->C,A B交换
		}
	}
	//斐波那契数列 
	public static int fibonacci(int num){
		if(num==0||num==1){
			return num;
		}else{
			return fibonacci(num-1)+fibonacci(num-2);
		}
	}
	//阶乘
	public static int factorial(int t){
		int num=1;
		for(int i=1;i<=t;i++){
			num*=i;
		}
		return num;
	}
	//Varargs 可变参数使用,rest相当于int[]
	public static void printint(int ...rest){
		for(int i:rest){
			System.out.println(i+" ");
		}
	}
	public static void printint(String ...rest){
		for(String i:rest){
			System.out.println(i+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//方法重载
        ClassInfo classinfo=new ClassInfo();
        ClassInfo classinfo1=new ClassInfo("有参数构造方法");
        classinfo.Info();
        classinfo1.Info("重载方法");
        //输出数组元素
        String[] str={"a","b","c"};
        Integer[] num=new Integer[]{1,2,3};
        Character[] chars={'A','B','C'};
        printArray(str);
        printArray(num);
        printArray(chars);
        printOneArray(str);
        printOneArray(num);
        printOneArray(chars);
        //汉诺塔算法
        doTowers(4,"A","B","C");
        //斐波那契数列
        int count=6;
        for(int i=0;i<count;i++){
        	System.out.print(fibonacci(i)+" ");
        }
        //阶乘
        System.out.println("阶乘:"+factorial(3));
        //方法覆盖
        figure f1=new figure(10,5);
        rectangle r1=new rectangle(11,5);
        figure f2;
        f2=f1;
        System.out.println(f2.result());
        f2=r1;
        System.out.println(f2.result());
        //instanceOf 关键字用法
        System.out.println((r1 instanceof figure));
        //break 关键字用法
        int t=0;
        for(int i=0;i<6;i++){
        	if(i==4){
        		break;
        	}
        	t+=i;
        }
        System.out.println("break:"+t);
        //continue 关键字用法
        int tt=0;
        for(int i=0;i<6;i++){
        	if(i==4){
        		continue;
        	}
        	tt+=i;
        }
        System.out.println("break:"+tt);
        //标签(Label)
        
        //enum 和 switch 语句使用
        //Enum（枚举）构造函数及方法的使用
        Car car;
        car=Car.a;
        switch(car){
        case a:
        	System.out.println("choose a price:"+car.getprice());
        	break;
        case b:
        	System.out.println("choose b");
        	break;
        default:
        	System.out.println("choose default");
        	break;
        }        
        //for 和 foreach循环使用
        //Varargs 可变参数使用
        printint(new int[]{1,2,3});
        //重载(overloading)方法中使用 Varargs
        printint(new String[]{"a","b","c"});
	}

}
enum Car{
	a(1),b(2),c(3),d(4);
	private int price;
	Car(int t){
		price=t;
	}
	int getprice(){
		return price;
	}
}
class figure{
	int dim1;
	int dim2;
	figure(int a,int b){
		dim1=a;
		dim2=b;
	}
	int result(){
		System.out.println("it's figure");
		return (dim1*dim2);
	}
}
class rectangle extends figure{

	rectangle(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}
	int result(){
		System.out.println("it's rectangle");
		return (dim1*dim2);
	}
}
