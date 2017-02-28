package Graph;

public class DirectedDFS {
private boolean[] marked;
public DirectedDFS(Digraph DG,int s){
	marked=new boolean[DG.V()];
	dfs(DG,s);
}
public DirectedDFS(Digraph DG,Iterable<Integer> sources){
	marked=new boolean[DG.V()];
	for(int s:sources){
		if(!marked[s]) dfs(DG,s);
	}
}
public void dfs(Digraph DG,int v){
	marked[v]=true;
	for(int w:DG.adj(v)){
		if(!marked[w]) dfs(DG,w);
	}
}
public boolean marked(int v){
	return marked[v];
}
}
