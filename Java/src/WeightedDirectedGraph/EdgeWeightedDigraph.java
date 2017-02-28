package WeightedDirectedGraph;

import java.io.IOException;
import java.util.LinkedList;

import Graph.ReadText;

public class EdgeWeightedDigraph {
	//顶点数目
	public int V;
	//边的数目
	public int E;
	//邻接表
	public LinkedList<DirectedEdge>[] adj;
	public EdgeWeightedDigraph(final int V){
		this.V=V;this.E=0;
		adj=(LinkedList<DirectedEdge>[]) new LinkedList[V];
		for(int v=0;v<V;v++){
			adj[v]=new LinkedList<DirectedEdge>();
		}
	}
	public EdgeWeightedDigraph(ReadText in) throws IOException{
		this(in.next());
		int e=in.next();
		for(int i=0;i<e;i++){
			int v=in.next();
			int w=in.next();
			int weight=in.next();
			DirectedEdge edge=new DirectedEdge(v,w,weight);
			addEdge(edge);
		}
	}
	public int V(){ return V;}
	public int E(){ return E;}
	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}
	public LinkedList<DirectedEdge> adj(int v){
		return adj[v];
	}
	public LinkedList<DirectedEdge> edges(){
		LinkedList<DirectedEdge> b=new LinkedList<DirectedEdge>();
		for(int v=0;v<V;v++){
			for(DirectedEdge e:adj(v)){
				b.add(e);
			}
		}
		return b;
	}
}
