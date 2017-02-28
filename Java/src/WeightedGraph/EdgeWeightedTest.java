package WeightedGraph;

import java.io.IOException;

import Graph.ReadText;

public class EdgeWeightedTest {
public static void main(String[] arg0) throws IOException{
ReadText in=new ReadText("/home/here/Downloads/test/EdgeWeightedGraph.txt");
EdgeWeightedGraph EWG=new EdgeWeightedGraph(in);
for(Edge e:EWG.edges()){
	System.out.println(e);
}
//MiniPQ mp=new MiniPQ();
//for(Edge e:EWG.edges()){
//	mp.insert(e);
//}
System.out.println();
//延迟Prim算法--最小生成树
LazyPrimMST LPM=new LazyPrimMST(EWG);
for(Edge e:LPM.edges()){
	System.out.println(e);
}
System.out.println(LPM.weight());
//即时Prim算法--最小生成树
System.out.println();
PrimMST PM=new PrimMST(EWG);
for(Edge e:PM.edges()){
	System.out.println(e);
}
System.out.println(PM.weight());
//Kruskal算法--最小生成树
System.out.println();
Kruskal k=new Kruskal(EWG);
for(Edge e:k.edges()){
	System.out.println(e);
}
}
}
