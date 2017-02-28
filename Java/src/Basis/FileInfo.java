package Basis;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;


public class FileInfo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//文件写入
		BufferedWriter out=new BufferedWriter(new FileWriter("/home/here/Downloads/tt.txt"));
		out.write("qqq\nwww");
		out.close();
		//读取文件内容
		BufferedReader in=new BufferedReader(new FileReader("/home/here/Downloads/tt.txt"));
		String str;
		while((str=in.readLine())!=null){
			System.out.println(str);	
		}
		in.close();
		//删除文件
		File file=new File("/home/here/Downloads/file.txt");
		if(file.isFile()&&file.exists()){
			file.delete();
		}
		//将文件内容复制到另一个文件
		InputStream in1=new FileInputStream(new File("/home/here/Downloads/tt.txt"));
		OutputStream outfile=new FileOutputStream(new File("/home/here/Downloads/vv.txt"));
		byte[] bytes=new byte[1024];
		int len;
		while((len=in1.read(bytes))>0){
			outfile.write(bytes, 0, len);
		}
		in1.close();
		outfile.close();
		//向文件中追加数据
		out=new BufferedWriter(new FileWriter("/home/here/Downloads/tt.txt",true));
		out.write("eee");
		out.close();
		//创建临时文件
		File temp=File.createTempFile("/home/here/Downloads/temp", ".suffix");
		temp.deleteOnExit();
		BufferedWriter buf=new BufferedWriter(new FileWriter(temp));
		buf.write("rrr");
		buf.close();
		//修改文件最后的修改日期
		File filechangetime=new File("/home/here/Downloads/oo.txt");
		filechangetime.createNewFile();
		Date datetime=new Date(filechangetime.lastModified());
		System.out.println(datetime.toString());
		System.out.println(filechangetime.setLastModified(System.currentTimeMillis()));
		datetime=new Date(filechangetime.lastModified());
		System.out.println(datetime.toString());
		//获取文件大小
		File newfile=new File("/home/here/Downloads/tt.txt");
		System.out.println("文件大小:"+newfile.length());
		//文件重命名
		File newfile1=new File("/home/here/Downloads/xx.txt");
		newfile.renameTo(newfile1);
		//设置文件只读
		newfile1.setWritable(false);
		newfile1.setReadable(false);
		//检测文件是否存在
		System.out.println("file exists or not: "+newfile1.exists());
		//在指定目录中创建文件
		File file1=null;
		File dir=new File("/home/here/Downloads/");
		file1=File.createTempFile("tpyy", ".temp", dir);
		//获取文件修改时间
		System.out.println(datetime.toString());
		//创建文件
		System.out.println(file1.createNewFile());
		//文件路径比较
		System.out.println((file1.compareTo(file)==0));
		
	}

}
