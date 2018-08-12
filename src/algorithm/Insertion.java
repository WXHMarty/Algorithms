package algorithm;
/**
 * 算法2.2
 * 插入排序
 * 为了给要插入的元素腾出空间，需要其余的元素再插入前都向右移动一位
 * @author Administrator
 *
 */
public class Insertion extends Example {

	// 将a[]按升序排序
	public static void sort(Comparable a[]){
		int N = a.length;
		for(int i = 1; i < N; i++)
			for(int j = i; j > 0 && less(a[j], a[j-1]); j--) exch(a, j, j-1);
	}
}
