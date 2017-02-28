package Graph;

import java.util.Stack;

public class DirectedCycle {
private boolean[] marked;
private int[] edgeTo;
private Stack<Integer> cycle;
private boolean[] onStack;
public DirectedCycle(Digraph DG){
	marked=new boolean[DG.V()];
	edgeTo=new int[DG.V()];
	onStack=new boolean[DG.V()];
	for(int v=0;v<DG.V();v++){
		if(!marked[v]) dfs(DG,v);
	}
}
public void dfs(Digraph DG,int v){
	marked[v]=true;
	onStack[v]=true;
	for(int w:DG.adj(v)){
		if(this.hasCycle()) return;
		else if(!marked[w]){
			edgeTo[w]=v;
			dfs(DG,w);
		}else if(onStack[w]){
			cycle=new Stack<Integer>();
			for(int x=v;x!=w;x=edgeTo[x]){
				cycle.push(x);
			}
			cycle.push(w);
			cycle.push(v);
		}
	}
	onStack[v]=false;
}
public boolean hasCycle(){
	return cycle!=null;
}
public Stack<Integer> cycle(){
	return cycle;
}
}
