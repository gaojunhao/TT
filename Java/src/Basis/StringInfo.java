package Basis;
import java.util.Locale;


public class StringInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1=new String("j-a-v-a");
		String str2="Hello JAVA";
		char[] chars={'h','e','l','l','o',' ','j','a','v','a'};
		String str3=new String(chars);
//		System.out.println(str1+"\n"+str2+"\n"+str3);
		System.out.println();
        //字符串比较
		System.out.println(str2.compareTo(str3));
		System.out.println(str2.compareToIgnoreCase(str3));
		//查找字符串最后一次出现的位置
		System.out.println(str3.lastIndexOf(str1));
		//删除字符串中的一个字符
		System.out.println(str1.substring(0, 1)+str1.substring(2,4));
		//字符串替换
		System.out.println(str1.replace('a','A'));
		//字符串反转
		StringBuffer strb=new StringBuffer(str1);
		System.out.println(strb.reverse().toString());
		//字符串查找
		System.out.println(str1.indexOf('v'));
		System.out.println(str1.indexOf('c'));
		//字符串分割
		String[] spliter;
		spliter=str1.split("-");
		for(String x:spliter){
			System.out.println(x);
		}
		//字符串小写转大写
		System.out.println(str1.toUpperCase());
		//测试两个字符串区域是否相等
		System.out.println(str2.regionMatches(false, 6, str3, 6, 4));
		//字符串性能比较测试
		long startime=System.currentTimeMillis();
		long endime=System.currentTimeMillis();
		System.out.println(startime-endime);
		//字符串优化
		str1.intern();
		//字符串格式化
		double e=Math.PI;
		System.out.format("%f%n",e);
		System.out.format(Locale.CHINA, "%-10.4f%n%n", e);
		//连接字符串
		System.out.println(str1+str2);
		System.out.println(str1.concat(str2));
	}

}
