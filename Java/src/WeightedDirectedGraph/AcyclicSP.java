package WeightedDirectedGraph;

import java.util.Stack;

public class AcyclicSP {
	private DirectedEdge[] edgeTo;
	private int[] distTo;
	public AcyclicSP(EdgeWeightedDigraph EWD,int s){
		distTo=new int[EWD.V()];
		edgeTo=new DirectedEdge[EWD.V()];
		for(int v=0;v<EWD.V();v++){
			distTo[v]=Integer.MAX_VALUE;
		}
		distTo[s]=0;
		WeightedTopological wtop=new WeightedTopological(EWD);
		for(int v=wtop.order().pop();wtop.order().size()!=0;v=wtop.order().pop()){
			relax(EWD,v);
		}
	}
	public void relax(EdgeWeightedDigraph EWD,int v){
		for(DirectedEdge e:EWD.adj(v)){
			int w=e.to();
			if(distTo[w]>e.weight()+distTo[v]){
				distTo[w]=e.weight()+distTo[v];
				edgeTo[w]=e;
			}
		}
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
