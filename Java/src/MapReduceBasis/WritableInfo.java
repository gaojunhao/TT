package MapReduceBasis;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Comparator;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.util.StringUtils;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat; 

public class WritableInfo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Writable类型
		//BooleanWritable(1) IntWritable(4) VIntWritable(1-5) FloatWritable(4) LongWritable(8) DoubleWritable(8)
//		IntWritable intwritable= new IntWritable(163);
		//intwritable.set(163);
//		IntWritable intwritable2= new IntWritable(162);
//		LongWritable longwritable= new LongWritable(777);
//        byte[] data=serialize(intwritable);
        //序列化
//        assertThat(data.length,is(4));//整数用四个字节
//        assertThat(StringUtils.byteToHexString(data),is("000000a3"));//十六进制
        //反序列化
//        IntWritable newintwritable=new IntWritable();
//        deserialize(data,newintwritable);
//        assertThat(newintwritable.get(),is(163));
        //比较Intwritable对象
//        RawComparator<IntWritable> comparator=WritableComparator.get(IntWritable.class);
//        assertThat(comparator.compare(intwritable,intwritable2),greaterThan(0));
        //比较序列化后的对象
//        byte[] byte1=serialize(intwritable);
//        byte[] byte2=serialize(intwritable2);
//        assertThat(comparator.compare(byte1,0,byte1.length,byte2,0,byte2.length),greaterThan(0));
		
		//Text
//		TextInfo();
		//String
//		StringInfo();
		//TextIterator
//		TextIterator();
		
		//BytesWritable
//		BytesWritable b=new BytesWritable(new byte[]{3,5});
//		BytesWritable b1=new BytesWritable(new byte[]{1,3,5});
//		byte[] bytes=serialize(b);
//		byte[] bytes1=serialize(b1);
//		assertThat(StringUtils.byteToHexString(bytes),is("000000020305"));//序列化　长度为２值为３和５
//		assertThat(StringUtils.byteToHexString(bytes1),is("00000003010305"));//序列化　长度为３值为1,３和５
		//NullWritable
//		byte[] bytes2=serialize(NullWritable.get());
//		assertThat(StringUtils.byteToHexString(bytes2),is(""));
		
	}
    public static byte[] serialize(Writable writable) throws IOException{
    	ByteArrayOutputStream out=new ByteArrayOutputStream();
    	DataOutputStream dataout=new DataOutputStream(out);
    	writable.write(dataout);
    	dataout.close();
    	out.close();
    	return out.toByteArray();
    }
    public static byte[] deserialize(byte[] bytes,Writable writable) throws IOException{
    	ByteArrayInputStream in=new ByteArrayInputStream(bytes);
    	DataInputStream datain=new DataInputStream(in);
    	writable.readFields(datain);
    	datain.close();
    	in.close();
    	return bytes;
    }
    public static void TextInfo() throws IOException{
    	Text t=new Text();
    	t.set("hadoop");
    	assertThat(t.getLength(),is(6));
    	assertThat(t.getBytes().length,is(6));
    	assertThat(t.charAt(2),is((int)'d'));
    	assertThat("out of bounds",t.charAt(7),is(-1));
    	assertThat(t.find("d",1),is(2));//从postion1及之后开始查找
    	
    	Text t1=new Text("\u0041\u00DF\u6771\uD801\uDC00");
    	assertThat(t1.getLength(),is(10));//字节个数1+2+3+4
    	assertThat(t1.getBytes().length,is(11));//长度根据getLength()
    	assertThat(t1.find("\u00DF"),is(1));//按字节偏移
    	assertThat(t1.find("\u6771"),is(3));
    	assertThat(t1.charAt(1),is(0x00DF));
    	assertThat(t1.charAt(3),is(0x6771));
    	
    	assertThat(new Text("hadoop").toString(),is("hadoop"));//Text转String
    }
    public static void StringInfo() throws IOException{
//    	String s="abcd";
    	String s="\u0041\u00DF\u6771\uD801\uDC00";//unicode第41号字符
    	assertThat(s.indexOf("\u00DF",0),is(1));//按字符偏移
    	assertThat(s.indexOf("\u6771",0),is(2));
    	assertThat(s.length(),is(5));//字符个数
    	assertThat(s.getBytes("UTF-8").length,is(10));//字节个数
    	assertThat(s.codePointAt(1),is(0x00DF));
    }
    //遍历Text对象中的字符
    public static void TextIterator() throws IOException{
    	Text t=new Text("\u0041\u00DF\u6771\uD801\uDC00");
    	ByteBuffer buf=ByteBuffer.wrap(t.getBytes(),0,t.getLength());
    	int cp;
    	while(buf.hasRemaining()&&(cp=Text.bytesToCodePoint(buf))!=-1){
    		System.out.print(Integer.toHexString(cp)+"\n");//int转16进制字符串
    	}
    }
    //实现一个ArrayWritable类的派生类
    public static class TextArrayWritable extends ArrayWritable{
    	public TextArrayWritable(){
    		super(Text.class);
    	}
    	public TextArrayWritable(String[] strings){
    		super(Text.class);
    		Text[] texts=new Text[strings.length];
    		for(int i=0;i<strings.length;i++){
    			texts[i]=new Text(strings[i]);
    		}
    		set(texts);
    	}
    }
//    public class A{
//    	int x;
//    	public A(){
//    		System.out.print("x="+x);
//    	}
//    }
//    public class B extends A{
//    	int x=100;
//    	public B(int x){
//    		super();
//    		System.out.print("x="+x);
//    	}
//    }
}
