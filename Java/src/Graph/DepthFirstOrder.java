package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	public DepthFirstOrder(Digraph DG){
		marked=new boolean[DG.V()];
		pre=new LinkedList<Integer>();
		post=new  LinkedList<Integer>();
		reversePost=new Stack<Integer>();
		for(int v=0;v<DG.V();v++){
			if(!marked[v]) dfs(DG,v);	
		}
	}
	public void dfs(Digraph DG,int v){
		pre.offer(v);
		marked[v]=true;
		for(int w:DG.adj(v)){
			if(!marked[w]) dfs(DG,w);
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
