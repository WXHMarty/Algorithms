package algorithm;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序
 * @author Administrator
 *
 */
public class Quick extends Example {
	
	public static void sort(Comparable[] a){
		// 打乱数组
		StdRandom.shuffle(a);
		
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo) return;
		
		// 切分
		int j = partition(a, lo, hi);
		
		// 将左半部分排序
		sort(a, lo, j-1);
		
		// 将体验版部分排序
		sort(a, j+1, hi);
	}
	
	// 切分 将数组且分为a[lo..i-1] a[i] a[i+1..hi]
	private static int partition (Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		
		// 切分元素
		Comparable v = a[lo];
		
		// 扫描左右， 检查扫描是否结束并交换元素
		while (true) {
			while (less(a[++i], v)) if(i == hi) break;
			while (less(v, a[--j])) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
}
