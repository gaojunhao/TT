package Graph;

public class SymbolDigraphAPI {
	private SymbolDigraph SymG;
	public SymbolDigraphAPI(SymbolDigraph SymG){
		this.SymG=SymG;
	}
	public String toString(){
		String s=SymG.G().V()+" vertices\t"+SymG.G().E()+" edges\n";
		for(int v=0;v<SymG.G().V();v++){
			s+=SymG.getName(v)+": ";
			for(int w:SymG.G().adj(v)){
				s+=SymG.getName(w)+" ";
			}
			s+="\n";
		}
		return s;
	}
}
