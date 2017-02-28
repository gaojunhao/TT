package Thread;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWMap<K,V> {

	private final Map<K,V> map;
	private final ReadWriteLock lock=new ReentrantReadWriteLock();
	private final Lock r=lock.readLock();
	private final Lock w=lock.writeLock();
	
	public RWMap(Map<K,V> map){
		this.map=map;
	}
	
	public V get(Object key){
		r.lock();
		try{
		return map.get(key);
		}finally{
		r.unlock();
		}
	}
	public V put(K key,V value){
		w.lock();
		try{
			return map.put(key, value);
		}finally{
			w.unlock();
		}
	}
}
