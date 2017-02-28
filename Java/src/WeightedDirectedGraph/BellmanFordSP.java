package WeightedDirectedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.apache.hadoop.hdfs.server.namenode.UnsupportedActionException;

public class BellmanFordSP{

	private int[] distTo;
	private DirectedEdge[] edgeTo;
	private boolean[] onQ;
	private Queue<Integer> queue;
	private int cost;
	private Stack<DirectedEdge> cycle;
	public BellmanFordSP(EdgeWeightedDigraph EWD,int s){
		distTo=new int[EWD.V()];
		edgeTo=new DirectedEdge[EWD.V()];
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
	public void relax(EdgeWeightedDigraph EWD,int v){
		for(DirectedEdge e:EWD.adj(v)){
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
		}
	}
	private void findNegativeCycle(){
		int V=edgeTo.length;
		EdgeWeightedDigraph spt=new EdgeWeightedDigraph(V);
		for(int v=0;v<spt.V();v++){
			if(edgeTo[v]!=null){
				spt.addEdge(edgeTo[v]);
			}
		}
		WeightedDirectedCycle cf=new WeightedDirectedCycle(spt);
		cycle=cf.cycle();
	}
	public boolean hasNegativeCycle(){
		return cycle!=null;
	}
	public Stack<DirectedEdge> negativeCycle(){
		return cycle;
	}
	public boolean hasPathTo(int v){
		return distTo[v]<Integer.MAX_VALUE;
	}
	public Stack<DirectedEdge> pathTo(int v){
		if(hasNegativeCycle()){
			throw new UnsupportedOperationException("Negative Cycle exists");
		}
		if(!hasPathTo(v)){
			return null;
		}
		Stack<DirectedEdge> path=new Stack<DirectedEdge>();
		for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
}
