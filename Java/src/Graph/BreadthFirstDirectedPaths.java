package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstDirectedPaths {
	public boolean[] marked;
	public int[] edgeTo;
	public final int s;
	public BreadthFirstDirectedPaths(Digraph G,int s){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		bfs(G,s);
	}
	public void bfs(Digraph G,int s){
		Queue<Integer> queue=new LinkedList<Integer>();
		marked[s]=true;
		queue.offer(s);
		while(!queue.isEmpty()){
			int v=queue.poll();
			for(int w:G.adj(v)){
				if(!marked[w]){
					edgeTo[w]=v;
					marked[w]=true;
					queue.offer(w);
				}
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Stack<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
