package WeightedDirectedGraph;

public class DirectedEdge {
private final int v;//起点
private final int w;//终点
private int weight;//权重
public DirectedEdge(int v,int w,int weight){
	this.v=v;
	this.w=w;
	this.weight=weight;
}
public int weight(){
	return weight;
}
public int from(){
	return v;
}
public int to(){
	return w;
}
public String toString(){
	return String.format("%d->%d %d",v,w,weight);
}
}
