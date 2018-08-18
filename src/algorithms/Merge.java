package algorithms;
/**
 * 算法2.4
 * 自顶向下的归并排序
 * 归并：将两个不同的数组归并到第三个数组中
 * @author Administrator
 *
 */
public class Merge extends Example {

	// 归并所需的排序数组
	private static Comparable[] aux;
	
	public static void sort (Comparable[] a) {
		//一次性分配空间
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	// 将数组a[lo..hi]排序
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		//将左半边排序
		sort(a, lo, mid);
		//将右半边排序
		sort(a, mid +1, hi);
		//归并结果
		merge(a, lo, mid, hi);
	}
	
	/**
	 * 原地归并的抽象方法
	 * 将a[lo..mid]和a[mid+1..hi]归并
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		// 将a[lo..mid]复制到a[mid+1..hi]中去
		for(int k = lo; k <= hi; k++) aux[k] = a[k];
		// 归并回到a[lo..mid]
		for(int k = lo; k <= hi; k++){
			if(i > mid) a[k] = aux[j++];
			else if(j > mid) aux[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}
	
}
