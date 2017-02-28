package Arbitrage;

import java.io.IOException;
import java.util.LinkedList;

import Graph.ReadText;

public class EdgeWeightedDigraphDouble {
	//顶点数目
	public int V;
	//边的数目
	public int E;
	//邻接表
	public LinkedList<DoubleDirectedEdge>[] adj;
	public EdgeWeightedDigraphDouble(final int V){
		this.V=V;this.E=0;
		adj=(LinkedList<DoubleDirectedEdge>[]) new LinkedList[V];
		for(int v=0;v<V;v++){
			adj[v]=new LinkedList<DoubleDirectedEdge>();
		}
	}
	public EdgeWeightedDigraphDouble(ReadText in) throws IOException{
		this(in.next());
		int e=in.next();
		for(int i=0;i<e;i++){
			int v=in.next();
			int w=in.next();
			double weight=in.next();
			DoubleDirectedEdge edge=new DoubleDirectedEdge(v,w,weight);
			addEdge(edge);
		}
	}
	public int V(){ return V;}
	public int E(){ return E;}
	public void addEdge(DoubleDirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}
	public LinkedList<DoubleDirectedEdge> adj(int v){
		return adj[v];
	}
	public LinkedList<DoubleDirectedEdge> edges(){
		LinkedList<DoubleDirectedEdge> b=new LinkedList<DoubleDirectedEdge>();
		for(int v=0;v<V;v++){
			for(DoubleDirectedEdge e:adj(v)){
				b.add(e);
			}
		}
		return b;
	}
}
