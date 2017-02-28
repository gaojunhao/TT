package WeightedGraph;

public class PrimMST {
private Edge[] edgeTo;//距离树最近的边
private int[] distTo;//distTo[v]=edgeTo[v].weght()
private boolean[] marked;//点在树中
private IndexMinPQ<Integer> pq;//有效的横切边
public PrimMST(EdgeWeightedGraph EWG){
	edgeTo=new Edge[EWG.V()];
	distTo=new int[EWG.V()];
	marked=new boolean[EWG.V()];
	pq=new IndexMinPQ<Integer>(EWG.V());
	for(int v=0;v<EWG.V();v++){
		distTo[v]=Integer.MAX_VALUE;
	}
	distTo[0]=0; 
	pq.insert(0,0);
	while(!pq.isEmpty()){
		visit(EWG,pq.delMin());
	}
}
public void visit(EdgeWeightedGraph EWG,int v){
	marked[v]=true;
	for(Edge e:EWG.adj(v)){
		int w=e.other(v);
		if(marked[w]) continue;
		if(e.weight()<distTo[w]){
			edgeTo[w]=e;
			distTo[w]=e.weight();
			if(pq.contains(w)) pq.changeKey(w, distTo[w]);
			else pq.insert(w, distTo[w]);
		}
	}
}
public Edge[] edges(){
	Edge[] edge = new Edge[edgeTo.length-1];
	for(int i=0;i<edgeTo.length-1;i++){
		edge[i]=edgeTo[i+1];
	}
	return edge;
}
public int weight(){
	int weight=0;
	for(Edge e:edges()){
		weight+=e.weight();
	}
	return weight;
}
}
