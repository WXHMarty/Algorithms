package algorithm;
/**
 * 排序算法类的模板
 * 实现排序算法类的基本通用的接口
 * 后面的算法可以继承此类
 * 避免重复开发相同的方法
 * @author Administrator
 *
 */
public class Example {

	// 如果v<w返回true 否则返回false
	protected static boolean less (Comparable v, Comparable w){
		// v>w返回1 v<w返回-1 v=w返回0
		return v.compareTo(w) < 0;
	}

	protected static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	// 在单行中打印数组
	protected static void show(Comparable[] a){
		for(int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
		System.out.println();
	}
	
	// 测试数组是否有序
	protected static boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++)
			if(less(a[i], a[i+1])) return false;
		return true;
	}
}
