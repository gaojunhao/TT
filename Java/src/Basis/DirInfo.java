package Basis;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;


public class DirInfo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	//打印目录结构
	public static void showDirs(int t,File file){
		for(int i=0;i<t;i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++){
				showDirs(t+4,files[i]);
			}
		}
	}
	//遍历指定目录下的所有目录（包括子目录）,并显示目录结构
	public static void showAllDir(int indent,File file){
		for(int i=0;i<indent;i++){
			System.out.print("-");
		}
			System.out.println(file.getName());
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++){
				if(files[i].isDirectory()){
					showAllDir(indent+4,files[i]);
				}
	
			}
	}
	public static void showAllDirs(File file){
		File[] files=file.listFiles();
		for(File t:files){
			if(t.isDirectory()){
				System.out.println(t.getName());
				showAllDirs(t);
			}
		}
	}
	public static void showDirs(File file){
		FileFilter filefilter=new FileFilter(){
			public boolean accept(File file){
				return file.isDirectory();
			}
		};
		File[] files=file.listFiles(filefilter);
		if(files.length==0){
			System.out.println("no dir");
		}else{
			for(File f:files){
				System.out.println(f.toString());
			}
		}
	}
	//遍历指定目录下以及分目录下的所有文件
	public static void showAllFiles(File file){
		File[] files=file.listFiles();
		for(File t:files){
			if(t.isFile()){
				System.out.println(t.getName());
			}else{
				showAllFiles(t);
			}
		}
	}
	//在指定目录中查找文件
	public static void showOneFile(File file){
		FilenameFilter filenamefilter=new FilenameFilter(){

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.startsWith("s");
			}
		};
		File[] files=file.listFiles(filenamefilter);
		if(files.length==0){
			System.out.println("no such file");
		}else{
			for(File f:files){
				System.out.println(f.toString());
			}
		}
	}
	//遍历系统根目录
	public static void showroot(){
		File[] files=File.listRoots();
		for(File f:files){
			System.out.println(f.toString());
		}
	}
	//遍历目录
	public static void showOneDir(File file){
		File[] files=file.listFiles();
		for(File t:files){
			if(t.isFile()){
				System.out.println(t.getPath());
			}else{
//				System.out.println(t.getPath());
				showOneDir(t);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//递归创建目录
		File dir=new File("/home/here/Downloads/dir/subdir");
		dir.mkdirs();
		//删除目录
//		dir.delete();
		//判断目录是否为空
		System.out.println(dir.list().length);
		//判断文件是否隐藏
		System.out.println(dir.isHidden());
		//获取目录大小
		System.out.println(FileUtils.sizeOfDirectory(dir));
		//在指定目录中查找文件
		File file=File.createTempFile("temp", ".suffix", dir);
		for(String child:dir.list()){
			System.out.println(child);
		}
		//获取文件的上级目录
		System.out.println(dir.getParent());
		//获取目录最后修改时间
		Date date=new Date(dir.lastModified());
		System.out.println(date.toString());
		//打印目录结构
//		showDirs(1,new File("/home/here/Downloads"));
		//遍历指定目录下的所有目录
//		showAllDir(1,new File("/home/here/Downloads"));
//		showAllDirs(new File("/home/here/Downloads"));
//		showDirs(new File("/home/here/Downloads"));
		//遍历指定目录下的所有文件
//		showAllFiles(new File("/home/here/Downloads"));
		//在指定目录中查找文件
//		showOneFile(new File("/home/here/Downloads"));
		//遍历系统根目录
		showroot();
		//查看当前工作目录
//		System.out.println("当前目录:"+System.getProperty("user.dir"));
		//遍历目录
		showOneDir(new File("/home/here/Downloads"));
	}

}
