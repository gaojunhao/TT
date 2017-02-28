package Arbitrage;

public class DoubleDirectedEdge {
	private final int v;//起点
	private final int w;//终点
	private double weight;//权重
	public DoubleDirectedEdge(int v,int w,double weight){
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public double weight(){
		return weight;
	}
	public int from(){
		return v;
	}
	public int to(){
		return w;
	}
	public String toString(){
		return String.format("%d->%d %f",v,w,weight);
	}
}
