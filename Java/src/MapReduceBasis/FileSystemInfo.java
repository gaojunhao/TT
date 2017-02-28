package MapReduceBasis;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
public class FileSystemInfo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//查看文件内容以及属性以及通过buffer查看，FileSystem.get(Path(new String()),conf)
//		cat(args);
		//查看文件内容　FileSystem.get(URI.create(uri),conf)
//		catfile(args);
		//通过url查看
//		urlcat(args);
		//创建文件
//		create("hdfs://172.17.0.2:9000/user/root/in/createfile/file1.txt",{1,2,3,4});
		//上传文件
//		uploadFile("/home/here/Downloads/uploadfile/2.txt","hdfs://172.17.0.2:9000/user/root/in/createfile/file2.txt");
		//删除文件fs.deleteonexit()
//	    delete("hdfs://172.17.0.2:9000/user/root/in/createfile/file1.txt");
		//创建目录
//		mkdir("hdfs://172.17.0.2:9000/user/root/in/mkdir");
		//重命名文件
//		rename("hdfs://172.17.0.2:9000/user/root/in/createfile/file2.txt","hdfs://172.17.0.2:9000/user/root/in/createfile/file1.txt");
		//下载文件
//	    download("hdfs://172.17.0.2:9000/user/root/in/file.txt","/home/here/Downloads/uploadfile/4.txt");
		//复制文件并带进度
//	    copywithprogress("/home/here/Downloads/file1.txt","hdfs://172.17.0.2:9000/user/root/in/file1.txt");
		//缓存中按字节读取
//		ByteBufferRead(args);
		//文件属性
//		fileStatusForFile(args);
		//目录属性
//		fileStatusForDir(args);
		//按模式匹配文件
//		FilePattern();
		//删除文件 delete(new Path(),true)
//		DeleteFile(args);
	}
	public static void create(String dst,byte[] contents) throws IOException{
//		String dst="hdfs://172.17.0.2:9000/user/root/in/createfile/file1.txt";
//		byte[] contents={1,2,3,4};
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		Path dstPath=new Path(dst);
		FSDataOutputStream outputStream=fs.create(dstPath);//输出流
		outputStream.write(contents);
		outputStream.close();
		fs.close();
	}
	public static void uploadFile(String src,String dst) throws IOException{
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		Path srcPath=new Path(src);
		Path dstPath=new Path(dst);
		fs.copyFromLocalFile(false, srcPath, dstPath);
		FileStatus[] filestatus=fs.listStatus(dstPath);
		for(FileStatus file:filestatus){
			System.out.print(file.getPath());
		}
		fs.close();
	}
	public static void delete(String arg) throws IOException{
		Path filePath=new Path(arg);
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		boolean isok=fs.deleteOnExit(filePath);
		if(isok){
			System.out.print("Delete Sucess");
		}
		else{
			System.out.print("Delete Failure");
		}
	}
	public static void mkdir(String arg) throws IOException{
		Path dirPath=new Path(arg);
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		boolean isok=fs.mkdirs(dirPath);
		if(isok){
			System.out.print("Mkdir Sucess");
		}else{
			System.out.print("Mkdir Failure");
		}
	}
	public static void rename(String oldname,String newname) throws IOException{
		Path oldfilepath=new Path(oldname);
		Path newfilepath=new Path(newname);
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		boolean isok=fs.rename(oldfilepath,newfilepath);
		if(isok){
			System.out.print("Rename Sucess");
		}else{
			System.out.print("Rename Failure");
		}
	}
    public static void cat(String[] args) throws IOException{
    	String filePath=args[0]+"/2.txt";
		Path srcPath=new Path(filePath);
		Configuration conf=new Configuration();//该类封装了服务器的配置
		FileSystem fs=FileSystem.get(conf);//通过FileSystem的静态方法get获取该对象
		FileStatus[] list=fs.listStatus(srcPath);
		Path[] listedpaths=FileUtil.stat2Paths(list);
		for(Path p:listedpaths){//查看所有文件所在路径
			System.out.print(p);
		}
		for(FileStatus f:list){//查看文件属性
			System.out.printf("%s,%s,%s\n",f.getLen(),f.getPath(),f.isDirectory());
		}
		FSDataInputStream in=null;//输入流
		byte buffer[]=new byte[20];//缓存大小
		byte buffer1[]=new byte[20];//缓存1大小
		try{
			in=fs.open(srcPath);
			IOUtils.copyBytes(in, System.out,4096,false);//print
//			in.seek(0);//seek移到文件中任意位置，开销较大
			long offset=in.getPos()-13;
			System.out.print(offset+"\n");//针对流的偏移量
//			in.readFully(offset, buffer,2,13);
//			System.out.print(new String(buffer));//readFully不能超过fs.getLen()大小
			in.read(offset,buffer1,0,50);//read读取全部
			in.read(offset,buffer,1,10);//read读取全部,此时1+19<=20(buffer大小)
			for(byte b:buffer){
				if(b==0){
			    System.out.print("-");
				}else{
				System.out.print((char)b);
			}
			}
			System.out.print("\n");
				for(byte b1:buffer1){
					if(b1==0){
				    System.out.print("-");
					}else{
					System.out.print((char)b1);
				}
			}
			System.out.print(new String(buffer1));//buffer必须从流的开头开始，为０不能为其他数
			IOUtils.copyBytes(in, System.out,4096,false);
		} finally{
			IOUtils.closeStream(in);
		}
    }
    public static void ByteBufferRead(String[] args) throws IOException{
    	Path filepath=new Path(args[0]+"/2.txt");
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	FSDataInputStream in=fs.open(filepath);
    	ByteBuffer buf=ByteBuffer.allocate(256); // 创建一个capacity为256的ByteBuffer 
    	while(true){
    		int c=in.read();//read一个个字节读取
    		if(c==-1){
    			break;
    		}
            buf.put((byte) c);//一个一个字节放入缓存
            if(c=='\n'){
            	System.out.printf("postion:%s,limit:%s\n",buf.position(),buf.limit());
            	buf.flip();// 调用flip()使limit变为当前的position的值,position变为0,由写转入读
            	System.out.printf("postion:%s,limit:%s\n",buf.position(),buf.limit());
//            	byte[] content=new byte[buf.limit()];
            	byte[] content=new byte[3];
//                buf.get(content);// 从ByteBuffer中读取数据到byte数组中 
                buf.get(content,0,content.length);// 从ByteBuffer中读取数据到byte数组中 
                System.out.printf("postion:%s,limit:%s\n",buf.position(),buf.limit());
                buf.mark();
                buf.get();
                buf.get();
                System.out.printf("postion:%s,limit:%s\n",buf.position(),buf.limit());
                buf.reset();//从未开始读取的字节处开始读取,content.lenth+1处开始
                System.out.printf("postion:%s,limit:%s\n",buf.position(),buf.limit());
//                buf.rewind();//将position设回0，所以你可以重读Buffer中的所有数据
//                System.out.printf("postion:%s,limit:%s\n",buf.position(),buf.limit());
                buf.compact();//将未读取的放至到postion=0位置处
                System.out.print((char) buf.get(0));
                System.out.print(new String(content));
                buf.clear();// 调用clear()使position变为0,limit变为capacity的值
            }
    	}
    }
    public static void catfile(String[] args) throws IOException{
    	String uri=args[0]+"/1.txt";
    	Configuration conf= new Configuration();
    	FileSystem fs=FileSystem.get(URI.create(uri),conf);
    	FSDataInputStream in=null;
    	try{
    		in=fs.open(new Path(uri));
    		IOUtils.copyBytes(in,System.out,4096,false);
    	}finally{
    		IOUtils.closeStream(in);
    	}
//    	fs.close();//可有可无
    }
    public static void urlcat(String[] args) throws IOException{
    	URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    	InputStream in=null;
    	try{
    		in=new URL(args[0]+"/1.txt").openStream();
    		IOUtils.copyBytes(in, System.out, 4096,false);
    	}finally{
    		IOUtils.closeStream(in);
    	}
    }
    public static void download(String src,String dst) throws IOException{
    	Path srcpath=new Path(src);
    	Path dstpath=new Path(dst);
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	FileSystem localfs=FileSystem.getLocal(conf);//获取本地文件系统
    	if(!fs.exists(srcpath)){
    		fs.close();
    		return;
    	}
    	fs.copyToLocalFile(false,srcpath,dstpath);
    	if(!localfs.exists(dstpath)){
    		System.out.print("文件不存在");
    		fs.close();
    		return;
    	}
    	FileStatus[] filestatus=localfs.listStatus(dstpath);//此处fs指的是localfs
    	for(FileStatus file:filestatus)
    		System.out.print(file.getPath());
        fs.close();   
    }
    public static void copywithprogress(String src,String dst) throws IOException{
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	InputStream in=new BufferedInputStream(new FileInputStream(src));
    	OutputStream out=fs.create(new Path(dst),new Progressable(){
    		public void progress(){
    			System.out.print(".");
    		}
    	});
    	IOUtils.copyBytes(in, out, 4096, true);
    	}
    public static void DeleteFile(String[] args) throws IOException{
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	Path filepath=new Path(args[0]+"/2.txt");
    	boolean isok=fs.delete(filepath,true);
    	if(isok){
    		System.out.print("Delete Sucess");    	
    	}else{
    		System.out.print("Delete Failure");    
    		}
    	}
    public static void fileStatusForFile(String[] args) throws IOException{
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	Path filepath=new Path(args[0]+"/2.txt");
    	FileStatus stat=fs.getFileStatus(filepath);
    	System.out.printf("%s\n%s\n%s\n%s",stat.getPath(),stat.getLen(),stat.getOwner(),stat.getGroup());
    }
    public static void fileStatusForDir(String[] args) throws IOException{
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	Path filepath=new Path(args[0]);
    	FileStatus stat=fs.getFileStatus(filepath);
    	System.out.printf("%s\n%s\n%s\n%s",stat.getPath(),stat.getLen(),stat.getOwner(),stat.getGroup());
    }
    public static void FilePattern() throws IOException{//globStatus()方法返回匹配文件模式的多个文件的FileStatus数组（以Path排序）
    	Configuration conf=new Configuration();
        FileSystem fs=FileSystem.get(conf);
        FileStatus[] stats=fs.globStatus(new Path("/u*"));
        Path[] paths=FileUtil.stat2Paths(stats);
        for(Path p:paths){
        	System.out.print(p+"\n");
        }
//        return paths;
    }
    public static byte[] getBytes(char[] chars){//将字符转为字节(编码)
    	Charset cs=Charset.forName("UTF-8");
    	CharBuffer cb=CharBuffer.allocate(chars.length);
    	cb.put(chars);
    	cb.flip();
    	ByteBuffer bb=cs.encode(cb);
    	return bb.array();
    }
    public static char[] getchars(byte[] bytes){// 将字节转为字符(解码) 
    	Charset cs=Charset.forName("UTF-8");
    	ByteBuffer bb=ByteBuffer.allocate(bytes.length);
    	bb.put(bytes);
    	bb.flip();
    	CharBuffer cb=cs.decode(bb);
    	return cb.array();
    }
}
