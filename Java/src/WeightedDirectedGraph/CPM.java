package WeightedDirectedGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CPM {
private String filePath;
public CPM(String filePath){
	this.filePath=filePath;
}
public void keyPath() throws NumberFormatException, IOException{
	BufferedReader in=new BufferedReader(new FileReader(filePath));
	int N=Integer.parseInt(in.readLine());
	EdgeWeightedDigraph EWD=new EdgeWeightedDigraph(2*N+2);//2N+2个顶点
	int s=2*N;int t=2*N+1;
	for(int i=0;i<N;i++){
		String[] a=in.readLine().split(" ");
		int duration=Integer.parseInt(a[0]);
		EWD.addEdge(new DirectedEdge(i,i+N,duration));
		EWD.addEdge(new DirectedEdge(s,i,0));
		EWD.addEdge(new DirectedEdge(i+N,t,0));
		for(int j=1;j<a.length;j++){
			int successor=Integer.parseInt(a[j]);
			EWD.addEdge(new DirectedEdge(i+N,successor,0));
		}
	}
	AcyclicSPMAX max=new AcyclicSPMAX(EWD,s);
	System.out.println("Starting Time:");
	for(int i=0;i<N;i++){
		System.out.println(String.format("%d : %d",i,max.distTo(i)));
	}
	System.out.println("Finishing Time:"+max.distTo(t));
}
}
