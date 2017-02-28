package Arbitrage;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Arbitrage {

	public static void main(String[] arg0) throws NumberFormatException, IOException{
		String filePath="/home/here/Downloads/test/rates.txt";
		BufferedReader in=new BufferedReader(new FileReader(filePath));
		int V=Integer.parseInt(in.readLine());
		EdgeWeightedDigraphDouble EWD=new EdgeWeightedDigraphDouble(V);
		String[] name=new String[V];
		for(int v=0;v<V;v++){
			String[] a=in.readLine().split(" ");
			name[v]=a[0];
			for(int w=1;w<a.length;w++){
				DoubleDirectedEdge e=new DoubleDirectedEdge(v,w-1,-Math.log(Double.parseDouble(a[w])));
				EWD.addEdge(e);
			}
		}
		BellmanFordSPDouble BF=new BellmanFordSPDouble(EWD,0);
		if(BF.hasNegativeCycle()){
			double stake=1000.00;
			while(!BF.negativeCycle().isEmpty()){
				DoubleDirectedEdge e=BF.negativeCycle().pop();
				System.out.printf("%10.5f %s",stake,name[e.from()]);
				stake*=Math.exp(-e.weight());
				System.out.printf("=%10.5f %s\n",stake,name[e.to()]);
			}
		}else{
			System.out.println("no arbitrage opportunity");
		}
	}
}
