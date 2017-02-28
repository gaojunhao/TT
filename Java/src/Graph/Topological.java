package Graph;

import java.util.Stack;

public class Topological {
private Stack<Integer> order;
public Topological(Digraph DG){
	DirectedCycle DC=new DirectedCycle(DG);
	if(!DC.hasCycle()){
		DepthFirstOrder DFO=new DepthFirstOrder(DG);
		order=DFO.reversePost();
	}
}
public Stack<Integer> order(){
	return order;
}
public boolean isDAG(){
	return order!=null;
}
}
