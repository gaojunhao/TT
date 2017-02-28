package Graph;

import java.io.IOException;
import java.util.LinkedList;

public class Digraph {
	//顶点数目
	public int V;
	//边的数目
	public int E;
	//邻接表
	public LinkedList<Integer>[] adj;
	public Digraph(final int V){
		this.V=V;this.E=0;
		adj=(LinkedList<Integer>[]) new LinkedList[V];
		for(int v=0;v<V;v++){
			adj[v]=new LinkedList<Integer>();
		}
	}
	public Digraph(ReadText in) throws IOException{
		this(in.next());
		int e=in.next();
		for(int i=0;i<e;i++){
			int v=in.next();
			int w=in.next();
			addEdge(v,w);
		}
	}
	public int V(){ return V;}
	public int E(){ return E;}
	public void addEdge(int v,int w){
		adj[v].add(w);
		E++;
	}
	public LinkedList<Integer> adj(int v){
		return adj[v];
	}
	public Digraph reverse(){
		Digraph R=new Digraph(V);
		for(int v=0;v<V;v++){
			for(int w:adj(v)){
				R.addEdge(w, v);
			}
		}
		return R;
	}
}
