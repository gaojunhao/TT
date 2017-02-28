package WeightedDirectedGraph;

import java.util.Stack;

public class DijkstraAllPairsSP {
private DijkstraSP[] all;
public DijkstraAllPairsSP(EdgeWeightedDigraph EWG){
	all=new DijkstraSP[EWG.V()];
	for(int v=0;v<EWG.V();v++){
		all[v]=new DijkstraSP(EWG,v);
	}
}
public Stack<DirectedEdge> path(int s,int t){
	return all[s].pathTo(t);
}
}
