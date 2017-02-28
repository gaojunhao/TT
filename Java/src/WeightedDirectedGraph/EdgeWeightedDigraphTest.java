package WeightedDirectedGraph;

import java.io.IOException;

import Graph.ReadText;

public class EdgeWeightedDigraphTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//有方向有权重的最小生成树
		ReadText in=new ReadText("/home/here/Downloads/test/AcyclicSP.txt");
		EdgeWeightedDigraph EWG=new EdgeWeightedDigraph(in);
		DijkstraSP DSP=new DijkstraSP(EWG,0);
		for(DirectedEdge DEdge:DSP.edges()){
			System.out.println(DEdge);
		}
		//从设置的起点到终点的路径
		System.out.println();
		DijkstraAllPairsSP DAPSP=new DijkstraAllPairsSP(EWG);
		for(DirectedEdge DAPEdge:DAPSP.path(5, 6)){
			System.out.println(DAPEdge);
		}
		//无环加权有向图中的最短路径算法
		System.out.println();
		ReadText Ain=new ReadText("/home/here/Downloads/test/AcyclicSP.txt");
		EdgeWeightedDigraph AEWG=new EdgeWeightedDigraph(Ain);
		//拓扑排序的第一个节点
		int s=5;
		AcyclicSP ASP=new AcyclicSP(AEWG,s);
		for(int v=0;v<AEWG.V();v++){
			System.out.print(s+" to "+v+" :");
			for(DirectedEdge e:ASP.pathTo(v)){
			System.out.print(e+" ");
			}
			System.out.println();
		}
		//无环加权有向图中的最长路径算法
		System.out.println();
		int source=5;
		AcyclicSPMAX ASPMAX=new AcyclicSPMAX(AEWG,source);
		for(int v=0;v<AEWG.V();v++){
			System.out.print(s+" to "+v+" :");
			for(DirectedEdge e:ASPMAX.pathTo(v)){
			System.out.print(e+" ");
			}
			System.out.println();
		}
		//优先级限制下的并行任务调度问题的关键路径方法
		System.out.println();
		CPM cpm=new CPM("/home/here/Downloads/test/CPM.txt");
		cpm.keyPath();
		//Bellman-Ford算法，负重有向环检测
		System.out.println();
		ReadText BFin=new ReadText("/home/here/Downloads/test/BF.txt");
		EdgeWeightedDigraph EWDG=new EdgeWeightedDigraph(BFin);
		int sour=0;
		BellmanFordSP BF=new BellmanFordSP(EWDG,sour);
		if(BF.hasNegativeCycle()){
			for(DirectedEdge e:BF.negativeCycle()){
				System.out.println("Negative Cycle:"+e);
			}
		}else{
			for(int v=0;v<EWDG.V();v++){
				if(BF.hasPathTo(v)){
				System.out.print(sour+" to "+v+" : ");
				for(DirectedEdge e:BF.pathTo(v)){
					System.out.print(e+" ");
				}
				System.out.println();
				}else{
					System.out.println(sour+" to "+v+" no paths");
				}
			}
		}
	}

}
