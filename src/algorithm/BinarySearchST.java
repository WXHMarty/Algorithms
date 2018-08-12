package algorithm;
/**
 * 有序数组的二分查找
 * @author Administrator
 *
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

	// 键
	private Key[] keys;
	
	// 值
	private Value[] vals;
	
	// 总数
	private int N;
	
	// 构造函数
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	// 返回数组长度是否为0
	private boolean isEmpty() { return N == 0; }
	
	// 返回数组的长度
	public int size() { return N; }
	
	// 根据key返回相应的val
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i<N && keys[i].compareTo(key)==0) return vals[i];
		else return null;
	}
	
	// 插入(更新)元素:查找键，找到则更新，否则创建新的元素
	public void put(Key key, Value val) {
		int i = rank(key);
		if(i<N && keys[i].compareTo(key)==0){
			vals[i] = val;
			return;
		}
		
		for(int j=N; j>i; j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	// 删除元素
	public void delete(Key key) {
		
	}
	
	// 基于有序数数组的二分查找(迭代)
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) hi = mid - 1;
			else if(cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	
	// 获取最小的key(即keys[0])
	public Key min() { return keys[0]; }
	
	// 获取最大的key(即keys[N-1])
	public Key max() { return keys[N-1]; }
	
	// 查找key
	public Key select(int k) { return keys[k]; }
	
	// 根据key查找key
	public Key ceiling(Key key) { return keys[rank(key)]; }
	
	public Key floor(Key key) { return null; }
	
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> q = new Queue<Key>();
		for(int i = rank(lo); i < rank(hi); i++) q.enqueue(keys[i]);
		if(contains(hi)) q.enqueue(keys[rank(hi)]);
		return q;
	}
	
	public boolean contains(Key key) {
		return key.compareTo(keys[rank(key)])==0;
	}
}
