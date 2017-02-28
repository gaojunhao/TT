package WeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MiniPQ {
	private PriorityQueue<Edge> PQ;
	public MiniPQ(){
		this.PQ=new PriorityQueue<Edge>();
	}
	public MiniPQ(LinkedList<Edge> e){
		this();
		PQ.addAll(e);
	}
	public void insert(Edge e){
		PQ.add(e);
	}
	public Edge delMin(){
		return PQ.poll();
	}
	public boolean isEmpty(){
		return PQ.size()==0;
	}
	public String toString(){
		return String.valueOf(PQ.size());
	}
}
