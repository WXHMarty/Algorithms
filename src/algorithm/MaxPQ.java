package algorithm;
/**
 * 堆 优先队列 ， 主要支持两种操作：删除最大元素和插入元素
 * 使用二叉树来表示
 * 插入元素：将新元素加到数组末尾，增加堆的大小并让这个元素上浮到合适的位置
 * 删除最大元素：从数组的顶端删除最大的元素，并将数组的最后一个元素放到顶端，
 * 			    减小堆的大小并让这个元素下沉到合适的位置
 * @author Administrator
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
	// 基于堆的完全二叉树
	private Key[] pq;
	
	// 存储于pq[1..N]中，pq[0]没有使用
	private int N = 0;
	
	// 构造函数 初始化类
	public MaxPQ(int maxN) { pq = (Key[]) new Comparable[maxN + 1]; }
	
	// 判断是否为空
	public boolean isEmpty() { return N == 0; }
	
	// 返回数组大小
	public int size() { return N; }

	// 堆元素的比较
	private boolean less(int i, int j) { return pq[i].compareTo(pq[j]) < 0; }

	// 堆元素的交换
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	// 由下至上的堆有序化(上浮)
	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}

	// 由上至下的堆有序化(下沉)
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2 * k;
			if(j < N && less(j, j+1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	// 插入元素
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	// 删除最大元素
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}

}
