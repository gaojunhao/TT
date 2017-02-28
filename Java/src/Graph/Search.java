package Graph;

import Data.UF;

public class Search {
	
	public UF uf;
	public int s;
	public int V;

	public Search(Graph G,int s){
		this.s=s;
		this.V=G.V();
		uf=new UF(V);
		for(int v=0;v<G.V();v++){
			for(int w:G.adj(v)){
				uf.union(w, v);
			}
		}
	}
	public boolean marked(int v){
		return uf.connected(v, s);
	}
	public int count(){
		int count=0;
		for(int i=0;i<V;i++){
			if(marked(i)) count++;
		}
		return count;
	}
}
