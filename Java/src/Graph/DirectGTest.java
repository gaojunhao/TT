package Graph;

import java.io.IOException;
import java.util.ArrayList;

public class DirectGTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ReadText in=new ReadText("/home/here/Downloads/test/Graph.txt");
		Digraph DG=new Digraph(in);
		DGraphAPI DAPI=new DGraphAPI(DG);
		System.out.println(DAPI.toString());
		
		ArrayList<Integer> sources=new ArrayList<Integer>();
		sources.add(5);
		sources.add(1);
		DirectedDFS reachable=new DirectedDFS(DG,sources);
		for(int v=0;v<DG.V();v++){
			if(reachable.marked(v)) System.out.print(v+" ");
		}
		//深度搜索-数字
		System.out.println();
		int s=2;
		DepthFirstDirectedPaths depth=new DepthFirstDirectedPaths(DG,s);
		for(int v=0;v<DG.V();v++){
			System.out.print(s+" to "+v+":");
			if(depth.hasPathTo(v)){
			for(int w:depth.pathTo(v)){
				if(w==s) System.out.print(s);
				else System.out.print(w+"-");
			}
			}
			System.out.println();
		}
		//广度搜索－数字
		System.out.println();
		int t=2;
		BreadthFirstDirectedPaths breadth=new BreadthFirstDirectedPaths(DG,t);
		for(int v=0;v<DG.V();v++){
			System.out.print(t+" to "+v+":");
			if(breadth.hasPathTo(v)){
			for(int w:breadth.pathTo(v)){
				if(w==t) System.out.print(t);
				else System.out.print(w+"-");
			}
			}
			System.out.println();
		}
		//符号表形式
		SymbolDigraph SymG=new SymbolDigraph("/home/here/Downloads/test/SymbolGraph.txt"," ");
		SymbolDigraphAPI SymGAPI=new SymbolDigraphAPI(SymG);
		System.out.println(SymGAPI.toString());
		//深度搜索-字符串
		System.out.println();
		int d=SymG.getIndex("cc");
		DepthFirstDirectedPaths depthString=new DepthFirstDirectedPaths(SymG.G(),d);
		for(int v=0;v<SymG.G().V();v++){
			System.out.print(SymG.getName(d)+" to "+SymG.getName(v)+":");
			if(depthString.hasPathTo(v)){
			for(int w:depthString.pathTo(v)){
				if(w==d) System.out.print(SymG.getName(d));
				else System.out.print(SymG.getName(w)+"-");
			}
			}
			System.out.println();
		}
		//广度搜索－字符串
		System.out.println();
		int g=SymG.getIndex("cc");
		BreadthFirstDirectedPaths breadthString=new BreadthFirstDirectedPaths(SymG.G(),g);
		for(int v=0;v<SymG.G().V();v++){
			System.out.print(SymG.getName(g)+" to "+SymG.getName(v)+":");
			if(breadthString.hasPathTo(v)){
			for(int w:breadthString.pathTo(v)){
				if(w==g) System.out.print(SymG.getName(g));
				else System.out.print(SymG.getName(w)+"-");
			}
			}
			System.out.println();
		}
		//寻找有向环
		DirectedCycle cycle=new DirectedCycle(DG);
		System.out.println(cycle.cycle().toString());
		//有向图中基于深度搜索的顶点排序
		ReadText depthin=new ReadText("/home/here/Downloads/test/DepthFirstOrder.txt");
		Digraph depthDG=new Digraph(depthin);
		DepthFirstOrder DFO=new DepthFirstOrder(depthDG);
		System.out.println(DFO.pre());
		System.out.println(DFO.post());
		System.out.println(DFO.reversePost());
		//拓扑排序
		SymbolDigraph TopoG=new SymbolDigraph("/home/here/Downloads/test/Topological.txt"," ");
		Topological top=new Topological(TopoG.G());
		for(int w:top.order()){
			System.out.println(TopoG.getName(w));
		}
	}

}
