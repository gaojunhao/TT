package Basis;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //格式化时间（SimpleDateFormat）
		Date date=new Date();
		String strTimeFormat="yyyy-MM-dd hh-mm-ss";
		SimpleDateFormat dateformat=new SimpleDateFormat(strTimeFormat);
		System.out.println(dateformat.format(date));
		//获取当前时间  
		SimpleDateFormat sdf=new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd hh-mm-ss");
		System.out.println(sdf.format(date));
		//获取年份、月份等
		Calendar cal=Calendar.getInstance();
		System.out.println("当前时间:"+cal.getTime());
		System.out.println("日期:"+cal.get(Calendar.DATE));
		System.out.println("月份:"+cal.get(Calendar.MONTH));
		System.out.println("年份:"+cal.get(Calendar.YEAR));
		System.out.println("一周的第几天:"+cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("一月的第几天:"+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("一年的第几天:"+cal.get(Calendar.DAY_OF_YEAR));
		//时间戳转换成时间
		Long timeStamp=System.currentTimeMillis();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		System.out.println(sdf1.format(new Date(Long.parseLong(String.valueOf(timeStamp)))));
	}

}
