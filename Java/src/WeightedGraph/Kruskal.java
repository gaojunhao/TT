package WeightedGraph;

import java.util.LinkedList;
import java.util.Queue;

import Data.UF;

public class Kruskal {
private Queue<Edge> mst;
public Kruskal(EdgeWeightedGraph EWG){
	mst=new LinkedList<Edge>();
	MiniPQ mpq=new MiniPQ(EWG.edges());
	UF uf=new UF(EWG.V());
	while(!mpq.isEmpty()&&mst.size()<EWG.V()-1){
		Edge e=mpq.delMin();
		int v=e.either();int w=e.other(v);
		if(uf.connected(v, w)) continue;
		uf.union(v, w);
		mst.offer(e);
	}
}
public Queue<Edge> edges(){
	return mst;
}
}
