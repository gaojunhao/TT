package Graph;

import java.io.IOException;

public class GTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//符号表形式
		SymbolGraph SymG=new SymbolGraph("/home/here/Downloads/test/SymbolGraph.txt"," ");
		SymbolGraphAPI SymGAPI=new SymbolGraphAPI(SymG);
		System.out.println(SymGAPI.toString());
		//深度搜索-数字
		ReadText in=new ReadText("/home/here/Downloads/test/Graph.txt");
		Graph G=new Graph(in);
		int s=2;
		DepthFirstPaths depth=new DepthFirstPaths(G,s);
		for(int v=0;v<G.V();v++){
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
		BreadthFirstPaths breadth=new BreadthFirstPaths(G,t);
		for(int v=0;v<G.V();v++){
			System.out.print(t+" to "+v+":");
			if(breadth.hasPathTo(v)){
			for(int w:breadth.pathTo(v)){
				if(w==t) System.out.print(t);
				else System.out.print(w+"-");
			}
			}
			System.out.println();
		}
		//深度搜索-字符串,字符串按照输入的字符串的顺序决定Map里的位置
		System.out.println();
		int d=SymG.getIndex("cc");
		DepthFirstPaths depthString=new DepthFirstPaths(SymG.G(),d);
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
		BreadthFirstPaths breadthString=new BreadthFirstPaths(SymG.G(),g);
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
	}

}
