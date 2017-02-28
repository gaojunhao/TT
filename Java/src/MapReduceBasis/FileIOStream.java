package MapReduceBasis;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.hadoop.io.IOUtils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.util.ReflectionUtils;


public class FileIOStream {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	//org.apache.hadoop.io.compress.GzipCodec gz
	//org.apache.hadoop.io.compress.BZip2Codec bz2
	//org.apache.hadoop.io.compress.DefaultCodec deflate
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub  
//        compressstream("/home/here/Downloads/uploadfile/1.txt",args[0],"org.apache.hadoop.io.compress.GzipCodec","gz");
//        uncompresslocalstream("/home/here/Downloads/uploadfile/10.gz","/home/here/Downloads/uploadfile/10.txt","org.apache.hadoop.io.compress.GzipCodec","gz");
//        uncompressstream("hdfs://172.17.0.2:9000/user/root/in/1.txt.gz","/home/here/Downloads/uploadfile/11.txt","org.apache.hadoop.io.compress.GzipCodec","gz");
		  uncompressbyname("hdfs://172.17.0.2:9000/user/root/in/1.txt.gz");
	}
    public static void compressstream(String src,String dst,String codecClassName,String compressway) throws IOException, ClassNotFoundException{
    	Configuration conf=new Configuration();
    	InputStream in=new BufferedInputStream(new FileInputStream(src));
    	String outfile=dst+"/1.txt."+compressway;
    	System.out.print(outfile);
    	FileSystem fs=FileSystem.get(URI.create(outfile),conf);
    	CompressionCodec codec=(CompressionCodec) ReflectionUtils.newInstance(Class.forName(codecClassName),conf);
    	OutputStream out=codec.createOutputStream(fs.create(new Path(outfile)));
    	try{
    		IOUtils.copyBytes(in, out, conf);
    	}finally{
    		IOUtils.closeStream(in);
    		IOUtils.closeStream(out);
    	}
    }
    public static void uncompresslocalstream(String src,String dst,String codeClassName,String compressway) throws IOException, ClassNotFoundException{
    	Configuration conf=new Configuration();
    	String outfile=dst;
    	FileSystem fs=FileSystem.getLocal(conf);
//    	FileSystem hdfs=FileSystem.get(URI.create(src),conf);
//    	InputStream hdin=hdfs.open(new Path(src));
    	CompressionCodec codec=(CompressionCodec) ReflectionUtils.newInstance(Class.forName(codeClassName),conf);
    	InputStream in=codec.createInputStream(fs.open(new Path(src)));
    	OutputStream out=fs.create(new Path(outfile));
    	try{
    		IOUtils.copyBytes(in, out, conf);
    	}finally{
    		IOUtils.closeStream(in);
    		IOUtils.closeStream(out);
    	}
    }
    public static void uncompressstream(String src,String dst,String codeClassName,String compressway) throws IOException, ClassNotFoundException{
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	FileSystem localfs=FileSystem.getLocal(conf);
    	CompressionCodec codec=(CompressionCodec) ReflectionUtils.newInstance(Class.forName(codeClassName),conf);
    	FSDataInputStream inputstream=fs.open(new Path(src));
    	InputStream in=codec.createInputStream(inputstream);
    	OutputStream out=localfs.create(new Path(dst));
    	try{
    		IOUtils.copyBytes(in, out, conf);
    	}finally{
    		IOUtils.closeStream(in);
    		IOUtils.closeStream(out);
    	}
    }
    public static void uncompressbyname(String src) throws IOException{
    	Configuration conf=new Configuration();
    	FileSystem fs=FileSystem.get(conf);
    	CompressionCodecFactory factory=new CompressionCodecFactory(conf);
    	CompressionCodec codec=factory.getCodec(new Path(src));
    	String outfilepath=CompressionCodecFactory.removeSuffix(src, codec.getDefaultExtension());
    	System.out.print(outfilepath);
    	InputStream in=null;
    	OutputStream out=null;
    	try{
    		in=codec.createInputStream(fs.open(new Path(src)));
    		out=fs.create(new Path(outfilepath));
    		IOUtils.copyBytes(in, out, conf);
    	}finally{
    		IOUtils.closeStream(in);
    		IOUtils.closeStream(out);
    	}
    }
}
