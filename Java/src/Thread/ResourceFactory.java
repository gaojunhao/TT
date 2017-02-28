package Thread;

public class ResourceFactory {

	//延长初始化占位类模式，当需要的时候初始化该类．这种模式只是在初始化单例时有用-单例模式，但对于读写操作时需要加锁
	private static class ResourceHolder{
		public static Resource resource=new Resource();
	}
	public Resource getInstance(){
		return ResourceHolder.resource;
	}
}
