package algorithms;
/**
 * 算法2.1 
 * 选择排序
 * 过程描述：首先，找到数组中最小的那个元素，
 * 其次，将它和素组中的第一个元素交换位置(如果第一个元素就是最小的元素那么它就和自己交换)，
 * 再次，剩下的子元素中找到最小的元素，将它与第二小的元素交换位置，如此反复，知道将整个数组排序
 * @author Administrator
 *
 */
public class Selection extends Example {

	//将a[]升序排列
	public static void sort(Comparable[] a){
		// 数组长度
		int N = a.length;
		// 将a[i]和a[i+1..N]中最小的元素排序
		for(int i = 0; i < N; i++){
			int min = i;
			for(int j = i + 1; j < N; j++)
				if(less(a[j], a[min])) min = j;
			exch(a, i, min);
		}
	}
}
