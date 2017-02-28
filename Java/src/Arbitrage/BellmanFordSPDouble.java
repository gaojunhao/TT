package Arbitrage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BellmanFordSPDouble {
	private double[] distTo;
	private DoubleDirectedEdge[] edgeTo;
	private boolean[] onQ;
	private Queue<Integer> queue;
	private int cost;
	private Stack<DoubleDirectedEdge> cycle;
	public BellmanFordSPDouble(EdgeWeightedDigraphDouble EWD,int s){
		distTo=new double[EWD.V()];
		edgeTo=new DoubleDirectedEdge[EWD.V()];
		onQ=new boolean[EWD.V()];
	    queue=new LinkedList<Integer>();
	    for(int v=0;v<EWD.V();v++){
	    	distTo[v]=Integer.MAX_VALUE;
	    }
	    distTo[s]=0;
	    queue.offer(s);
	    onQ[s]=true;
	    while(!queue.isEmpty()&&!this.hasNegativeCycle()){
	    	int v=queue.poll();
	    	onQ[v]=false;
	    	relax(EWD,v);
	    }
	}
	public void relax(EdgeWeightedDigraphDouble EWD,int v){
		for(DoubleDirectedEdge e:EWD.adj(v)){
		int w=e.to();
		if(distTo[w]>distTo[v]+e.weight()){
			distTo[w]=distTo[v]+e.weight();
			edgeTo[w]=e;
		}
		if(!onQ[w]){
			queue.offer(w);
			onQ[w]=true;
		}
		}
		if(cost++%EWD.V()==0){
			findNegativeCycle();
			if(hasNegativeCycle()) return;
		}
	}
	private void findNegativeCycle(){
		int V=edgeTo.length;
		EdgeWeightedDigraphDouble spt=new EdgeWeightedDigraphDouble(V);
		for(int v=0;v<spt.V();v++){
			if(edgeTo[v]!=null){
				spt.addEdge(edgeTo[v]);
			}
		}
		WeightedDirectedCycleDouble cf=new WeightedDirectedCycleDouble(spt);
		cycle=cf.cycle();
	}
	public boolean hasNegativeCycle(){
		return cycle!=null;
	}
	public Stack<DoubleDirectedEdge> negativeCycle(){
		return cycle;
	}
	public boolean hasPathTo(int v){
		return distTo[v]<Integer.MAX_VALUE;
	}
	public Stack<DoubleDirectedEdge> pathTo(int v){
		if(hasNegativeCycle()){
			throw new UnsupportedOperationException("Negative Cycle exists");
		}
		if(!hasPathTo(v)){
			return null;
		}
		Stack<DoubleDirectedEdge> path=new Stack<DoubleDirectedEdge>();
		for(DoubleDirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
}
