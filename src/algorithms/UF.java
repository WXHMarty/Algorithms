package algorithms;
/**
 * 算法1.5 
 * union-union的实现
 * @author Administrator
 *
 */
public class UF {
	// 分量id(以触点作为索引)
	private int[] id;
	
	// (由触点索引的)各个节点所对应的的分量的大小
	private int[] sz;
	
	// 分量数量
	private int count;
	
	//初始化分量id数组
	public UF(int N) {
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++) id[i] = i;
		sz = new int[N];
		for(int i = 0; i < N; i++) sz[i] = 1;
	}
	
	public int count() { return count; }
	
	public boolean connected(int p, int q) { return find(p) == find(q); }
	
	// 跟随连接找到根节点
	public int find(int p) {
		while (p != id[p]) p = id[p];
		return p;
	}
	
	//
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		// 将小树的根节点连接到大树的根节点
		if(sz[i] < sz[i]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
}
