package Thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafe {
private final List<String> list=new ArrayList<String>();
public void addList(String st){
	list.add(st);
}
public void removeList(String st){
	list.remove(st);
}
}
