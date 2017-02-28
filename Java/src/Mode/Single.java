package Mode;

public class Single {
//延迟加载
	private static Single instance=null;
//方法私有，防止实例化
	private Single(){}
//初始化锁住,多线程保护
	public static synchronized void sysInit(){
		if(instance==null){
			instance=new Single();
		}
	}
//获取单例
	public static Single getInstance(){
		if(instance==null){
			sysInit();
		}
			return instance;
	} 
}
