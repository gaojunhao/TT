package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestFeatureCache <K,V>{

	/**
	 * @param args
	 */
	private final ConcurrentHashMap<K,Future<V>> cachemap=new ConcurrentHashMap<K,Future<V>>();
	
	public Object getCache(K key,String threadName) throws InterruptedException, ExecutionException{
		Future<V> value=null;
		value=cachemap.get(key);
		if(value==null){
			value=putCache(key,threadName);
			return value.get();
		}
		return value.get();
	}
	public Future<V> putCache(K key,final String threadName){
		Future<V> value=null;
		Callable<V> callable=new Callable<V>(){

			public V call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("database transaction "+threadName);
				return (V) "dataValue";
			}
			
		};
		FutureTask<V> futuretask=new FutureTask<V>(callable);
		value=cachemap.putIfAbsent(key, futuretask);
		if(value==null){
			value=futuretask;
			futuretask.run();
		}
		return value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(Runtime.getRuntime().availableProcessors());
		final TestFeatureCache<String,String> test=new TestFeatureCache<String,String>();
		Thread thread1=new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("T1======start========");  
                Object value=null;
				try {
					value = test.getCache("key1","T1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                System.out.println("T1 value=============="+value);  
                System.out.println("T1======end========");  
			}});
		Thread thread2=new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("T2======start========");  
                Object value=null;
				try {
					value = test.getCache("key1","T1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                System.out.println("T2 value=============="+value);  
                System.out.println("T2======end========");  
			}});
		Thread thread3=new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("T3======start========");  
                Object value=null;
				try {
					value = test.getCache("key3","T3");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                System.out.println("T3 value=============="+value);  
                System.out.println("T3======end========");  
			}});
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
