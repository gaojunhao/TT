package WeightedDirectedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class WeightedDepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	public WeightedDepthFirstOrder(EdgeWeightedDigraph EWD){
		marked=new boolean[EWD.V()];
		pre=new LinkedList<Integer>();
		post=new  LinkedList<Integer>();
		reversePost=new Stack<Integer>();
		for(int v=0;v<EWD.V();v++){
			if(!marked[v]) dfs(EWD,v);	
		}
	}
	public void dfs(EdgeWeightedDigraph EWD,int v){
		pre.offer(v);
		marked[v]=true;
		for(DirectedEdge e:EWD.adj(v)){
			int w=e.to();
			if(!marked[w]) dfs(EWD,w);
		}
		post.offer(v);
		reversePost.push(v);
	}
    public Queue<Integer> pre(){
    	return pre;
    }
    public Queue<Integer> post(){
    	return post;
    }
    public Stack<Integer> reversePost(){
    	return reversePost;
    }
}
