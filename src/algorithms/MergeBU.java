package algorithms;
/**
 * 调用算法2.4
 * 自底向上的归并排序
 * @author Administrator
 *
 */
public class MergeBU {

	// 归并所需的辅助数组
	private static Comparable[] aux;
	
	// 进行lgN次两两归并
	public static void sort(Comparable[] a){
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz <N; sz = sz + sz){
			for(int lo = 0; lo < N - sz; lo += sz + sz) 
				Merge.merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
		}
	}
}
