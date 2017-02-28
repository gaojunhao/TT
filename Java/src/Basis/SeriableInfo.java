package Basis;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SeriableInfo implements java.io.Serializable{

	public String name;
	public int age;
	public transient int SSN;//属性是短暂的，该值没有被发送到输出流,反序列化后 Employee 对象的 SSN 属性为 0。
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//序列化
//		SeriableInfo student=new SeriableInfo();
//		student.name="Andy";
//		student.age=18;
//		File file=new File("/home/here/Downloads/stu.ser");
//		FileOutputStream stuout=new FileOutputStream(file);
//		ObjectOutputStream output=new ObjectOutputStream(stuout);
//		output.writeObject(student);
//        stuout.close();
//        output.close();
        //反序列化
//		File file=new File("/home/here/Downloads/stu.ser");
//		FileInputStream filein=new FileInputStream(file);
//		ObjectInputStream input=new ObjectInputStream(filein);
//		SeriableInfo e=(SeriableInfo) input.readObject();
//		filein.close();
//		input.close();
//		System.out.print("name:"+e.name+"\n");
//		System.out.print("age:"+e.age);
	}

}
