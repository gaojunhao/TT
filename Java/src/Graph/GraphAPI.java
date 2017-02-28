package Graph;

public class GraphAPI {

	public Graph G;
	public GraphAPI(Graph G){
		this.G=G;
	}
	//顶点ｖ的度数即其他顶点个数
	public int degree(int v){
		int degree=0;
		for(int w:G.adj(v)) degree++;
		return degree;
	}
	//图中顶点的最大度
	public int maxDegree(){
		int max=0;
		for(int i=0;i<G.V();i++){
			max=Math.max(max, degree(i));
		}
		return max;
	}
	//图的平均度
	public int avgDegree(){
		return 2*G.E()/G.V();
	}
	//自环个数
	public int numberOfSelfLoops(){
		int count=0;
		for(int v=0;v<G.V();v++){
			for(int w:G.adj(v)){
				if(v==w) count++;
			}
		}
		return count/2;
	}
	//图的表示
	public String toString(){
		String s=G.V()+" vertices\t"+G.E()+" edges\n";
		for(int v=0;v<G.V();v++){
			s+=v+": ";
			for(int w:G.adj(v)){
				s+=w+" ";
			}
			s+="\n";
		}
		return s;
	}
	
	
}
