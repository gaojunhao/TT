package Graph;

public class SymbolGraphAPI {
private SymbolGraph SymG;
public SymbolGraphAPI(SymbolGraph SymG){
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
