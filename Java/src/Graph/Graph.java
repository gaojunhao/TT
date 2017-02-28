package Graph;

import java.io.IOException;
import java.util.LinkedList;


public class Graph {

	//顶点数目
	public int V;
	//边的数目
	public int E;
	//邻接表
	public LinkedList<Integer>[] adj;
	public Graph(final int V){
		this.V=V;this.E=0;
		adj=(LinkedList<Integer>[]) new LinkedList[V];
		for(int v=0;v<V;v++){
			adj[v]=new LinkedList<Integer>();
		}
	}
	public Graph(ReadText in) throws IOException{
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
		adj[w].add(v);
		E++;
	}
	public LinkedList<Integer> adj(int v){
		return adj[v];
	}
}
