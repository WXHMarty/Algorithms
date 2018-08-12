package algorithm;
/**
 * 算法2.3
 * 希尔排序
 * @author Administrator
 *
 */
public class Shell extends Example {

	public static void sort(Comparable[] a){
		// 将a[]按升序排列
		int N = a.length;
		int h = 1;
		while (h < N/3) h = 3 * h + 1;
		// 将数组变为h有序
		while (h >= 1) {
			// 将a[i]插入a[i-h],a[i-2h],a[i-3h]到当中
			for(int i = h; i <= N; i++)
				for(int j = i; j >=h && less(a[j], a[j-h]); j -= h) exch(a, j, j-h);
			h = h/3;
		}
	}
	
}
