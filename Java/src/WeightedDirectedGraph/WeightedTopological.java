package WeightedDirectedGraph;

import java.util.Stack;

public class WeightedTopological {
	private Stack<Integer> order;
	public WeightedTopological(EdgeWeightedDigraph EWD){
		WeightedDirectedCycle WDC=new WeightedDirectedCycle(EWD);
		if(!WDC.hasCycle()){
			WeightedDepthFirstOrder WDFO=new WeightedDepthFirstOrder(EWD);
			order=WDFO.reversePost();
		}
	}
	public Stack<Integer> order(){
		return order;
	}
	public boolean isDAG(){
		return order!=null;
	}
}
