package WeightedDirectedGraph;

import java.util.Stack;

public class WeightedDirectedCycle {
	private boolean[] marked;
	private DirectedEdge[] edgeTo;
	private Stack<DirectedEdge> cycle;
	private boolean[] onStack;
	public WeightedDirectedCycle(EdgeWeightedDigraph EWD){
		marked=new boolean[EWD.V()];
		edgeTo=new DirectedEdge[EWD.V()];
		onStack=new boolean[EWD.V()];
		for(int v=0;v<EWD.V();v++){
			if(!marked[v]) dfs(EWD,v);
		}
	}
	public void dfs(EdgeWeightedDigraph EWD,int v){
		marked[v]=true;
		onStack[v]=true;
		for(DirectedEdge e:EWD.adj(v)){
			int w=e.to();
			if(this.hasCycle()) return;
			else if(!marked[w]){
				edgeTo[w]=e;
				dfs(EWD,w);
			}else if(onStack[w]){
				cycle=new Stack<DirectedEdge>();
				while(e.from()!=w){
					cycle.push(e);
					e=edgeTo[e.from()];
				}
			}
		}
		onStack[v]=false;
	}
	public boolean hasCycle(){
		return cycle!=null;
	}
	public Stack<DirectedEdge> cycle(){
		return cycle;
	}
}
