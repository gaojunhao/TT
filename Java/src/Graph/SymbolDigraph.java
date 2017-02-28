package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SymbolDigraph {
	private Map<String,Integer> st;
	private String[] keys;
	private Digraph G;
	public SymbolDigraph(String fileName,String sp) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader(fileName));
		String lineContext;
		st=new HashMap<String,Integer>();
		while((lineContext=in.readLine())!=null){
			String[] a=lineContext.split(sp);
			for(int i=0;i<a.length;i++){
				if(!st.containsKey(a[i]))
				st.put(a[i], st.size());
			}
		}
		keys=new String[st.size()];
		for(String name:st.keySet()){
			keys[st.get(name)]=name;
		}
		G=new Digraph(st.size());
		in=new BufferedReader(new FileReader(fileName));
		String line;
		while((line=in.readLine())!=null){
			String[] a=line.split(sp);
			int v=st.get(a[0]);
			for(int i=1;i<a.length;i++){
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	public String getName(int i){
		return keys[i];
	}
	public int getIndex(String name){
		return st.get(name);
	}
	public Digraph G(){return G;}
}
