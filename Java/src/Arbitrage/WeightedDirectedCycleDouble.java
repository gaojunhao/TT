package Arbitrage;

import java.util.Stack;

public class WeightedDirectedCycleDouble {
	private boolean[] marked;
	private DoubleDirectedEdge[] edgeTo;
	private Stack<DoubleDirectedEdge> cycle;
	private boolean[] onStack;
	public WeightedDirectedCycleDouble(EdgeWeightedDigraphDouble EWD){
		marked=new boolean[EWD.V()];
		edgeTo=new DoubleDirectedEdge[EWD.V()];
		onStack=new boolean[EWD.V()];
		for(int v=0;v<EWD.V();v++){
			if(!marked[v]) dfs(EWD,v);
		}
	}
	public void dfs(EdgeWeightedDigraphDouble EWD,int v){
		marked[v]=true;
		onStack[v]=true;
		for(DoubleDirectedEdge e:EWD.adj(v)){
			int w=e.to();
			if(this.hasCycle()) return;
			if(!marked[w]){
				edgeTo[w]=e;
				dfs(EWD,w);
			}else if(onStack[w]){
				cycle=new Stack<DoubleDirectedEdge>();
				while(e.from()!=w){
					cycle.push(e);
					e=edgeTo[e.from()];
				}
				cycle.push(e);
				return;
			}
		}
		onStack[v]=false;
	}
	public boolean hasCycle(){
		return cycle!=null;
	}
	public Stack<DoubleDirectedEdge> cycle(){
		return cycle;
	}
}
