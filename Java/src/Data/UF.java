package Data;
//http://blog.csdn.net/dm_vincent/article/details/7655764
public class UF {
    private int[] id;
    private int[] sz;
    private int count;
    public UF(int N){
    	count=N;
    	id=new int[N];
    	sz=new int[N];
    	for(int i=0;i<N;i++){
    		id[i]=i;
    		sz[i]=1;
    	}
    }
	public int count(){
		return count;
	}
	public int find(int t){
		while(t!=id[t]) {
			//将子节点的父节点设置为爷爷节点，使数更加扁平化
			id[t]=id[id[t]];
			t=id[t]; 
		}
		return t;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	public void union(int p,int q){
		int pid=find(p);
		int qid=find(q);
		if(pid==qid){
			return;
		}else{
		    if(sz[p]<sz[q]){
		    	id[p]=q;
		    	sz[q]+=sz[p];
		    }else{
		    	id[q]=p;
		    	sz[p]+=sz[q];
		    }
		    count--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        UF uf=new UF(10);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(1, 3);
        System.out.println("count:"+uf.count());
        System.out.println("connect info:"+uf.connected(1, 4));
	}

}
