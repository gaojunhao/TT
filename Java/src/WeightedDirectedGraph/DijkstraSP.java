package WeightedDirectedGraph;

import java.util.Stack;

import WeightedGraph.IndexMinPQ;

public class DijkstraSP {
	private DirectedEdge[] edgeTo;//距离树最近的边
	private int[] distTo;//distTo[v]=edgeTo[v].weght()
	private boolean[] marked;//点在树中
	private IndexMinPQ<Integer> pq;//有效的横切边
	public DijkstraSP(EdgeWeightedDigraph EWD,int s){
		edgeTo=new DirectedEdge[EWD.V()];
		distTo=new int[EWD.V()];
		marked=new boolean[EWD.V()];
		pq=new IndexMinPQ<Integer>(EWD.V());
		for(int v=0;v<EWD.V();v++){
			distTo[v]=Integer.MAX_VALUE;
		}
		distTo[0]=0; 
		pq.insert(s,0);
		while(!pq.isEmpty()){
			relax(EWD,pq.delMin());
		}
	}
	public void relax(EdgeWeightedDigraph EWD,int v){
		marked[v]=true;
		for(DirectedEdge e:EWD.adj(v)){
			int w=e.to();
			if(distTo[w]>e.weight()+distTo[v]){
				distTo[w]=e.weight()+distTo[v];
				edgeTo[w]=e;
				if(pq.contains(w)) pq.changeKey(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
	}
	public DirectedEdge[] edges(){
		DirectedEdge[] edge = new DirectedEdge[edgeTo.length-1];
		for(int i=0;i<edgeTo.length-1;i++){
			edge[i]=edgeTo[i+1];
		}
		return edge;
	}
	public int weight(){
		int weight=0;
		for(DirectedEdge e:edges()){
			weight+=e.weight();
		}
		return weight;
	}
	public int distTo(int v){
		return distTo[v];
	}
	public boolean hasPathTo(int v){
		return distTo[v]<Integer.MAX_VALUE;
	}
	public Stack<DirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path=new Stack<DirectedEdge>();
		for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
}
