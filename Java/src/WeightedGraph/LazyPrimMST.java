package WeightedGraph;

import java.util.LinkedList;
import java.util.Queue;

public class LazyPrimMST {
private boolean[] marked;//v在树中为true
private Queue<Edge> mst;//最小生成树
private MiniPQ pq;//包含失效和有效的横切边
public LazyPrimMST(EdgeWeightedGraph EWG){
	pq=new MiniPQ();
	mst=new LinkedList<Edge>();
	marked=new boolean[EWG.V()];
	visit(EWG,0);
	while(!pq.isEmpty()){
		Edge e=pq.delMin();
		int v=e.either();int w=e.other(v);
		if(marked[v]&&marked[w]) continue;
		mst.offer(e);
		if(!marked[v]) visit(EWG,v);
		if(!marked[w]) visit(EWG,w);
	}
}
public void visit(EdgeWeightedGraph EWG,int v){
	marked[v]=true;
	for(Edge e:EWG.adj(v)){
		if(!marked[e.other(v)]) pq.insert(e);
	}
}
public Queue<Edge> edges(){
	return mst;
}
public int weight(){
	int weight=0;
	for(Edge e:mst){
		weight+=e.weight();
	}
	return weight;
}
}
