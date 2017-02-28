package WeightedGraph;

import java.io.IOException;
import java.util.LinkedList;

import Graph.ReadText;

public class EdgeWeightedGraph {
	//顶点数目
	public int V;
	//边的数目
	public int E;
	//邻接表
	public LinkedList<Edge>[] adj;
	public EdgeWeightedGraph(final int V){
		this.V=V;this.E=0;
		adj=(LinkedList<Edge>[]) new LinkedList[V];
		for(int v=0;v<V;v++){
			adj[v]=new LinkedList<Edge>();
		}
	}
	public EdgeWeightedGraph(ReadText in) throws IOException{
		this(in.next());
		int e=in.next();
		for(int i=0;i<e;i++){
			int v=in.next();
			int w=in.next();
			int weight=in.next();
			Edge edge=new Edge(v,w,weight);
			addEdge(edge);
		}
	}
	public int V(){ return V;}
	public int E(){ return E;}
	public void addEdge(Edge e){
		int v=e.either();
		int w=e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public LinkedList<Edge> adj(int v){
		return adj[v];
	}
	public LinkedList<Edge> edges(){
		LinkedList<Edge> b=new LinkedList<Edge>();
		for(int v=0;v<V;v++){
			for(Edge e:adj(v)){
				if(e.other(v)>v) b.add(e);
			}
		}
		return b;
	}
}
