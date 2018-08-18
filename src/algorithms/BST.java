package algorithms;
/**
 * 算法3.3
 * 基于二叉查找树的符号表
 * 一棵二叉查找树(BST)是一棵二叉树，
 * 其中每个结点都含有一个Comparable的键(以及相关联的值)，
 * 且每个结点的键都大于其左子树中的任意结点的键而小于右子树的任意结点的键
 * @author Administrator
 *
 */
public class BST<Key extends Comparable<Key>, Value> {

	// 根结点
	private Node root;
	
	public int size() { return size(root); }
	// 返回结点的数量
	private int size(Node x) { return x==null ? 0 : x.N; }
	
	public Value get(Key key) { return get(root, key); }
	// 在以x为根结点的子树中查找并返回key所对应的值，如果找不到则返回null
	private Value get(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return get(x.left, key);
		else if(cmp > 0) return get(x.right, key);
		else return x.val;
	}
	
	public void put(Key key, Value val) { root = put(root, key, val); }
	// 查找key,找到则更新它，否则为其创建一个新的结点
	private Node put(Node x, Key key, Value val) {
		if(x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = put(x.left, key, val);
		else if(cmp > 0) x.right = put(x.right, key, val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min() { return min(root).key; }
	// 返回最小的key
	private Node min(Node x) { return x.left == null ? x : min(x.left); }
	
	public Key max() { return max(root).key; }
	// 返回最大的key
	private Node max(Node x) { return x.right == null ? x : max(x.right); }
	
	public Key floor(Key key) {
		Node x = floor(root, key);
		return x == null ? null : x.key;
	}
	// 返回树中小于等于key的最大key
	private Node floor(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;
	}
	
	public Key select(int k) { return select(root, k).key; }
	// 返回排名为k的结点
	private Node select(Node x, int k) {
		if(x == null) return null;
		int t = size(x.left);
		if(t > k) return select(x.left, k);
		else if(t < k) return select(x.right, k-t-1);
		else return x;
	}
	
	public int rank(Key key) { return rank(key, root); }
	// 返回以x为根结点的子树中小于x.key的键的数量
	private int rank(Key key, Node x) {
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(key, x.left);
		else if(cmp > 0) return 1 + size(x.left) + rank(key, x.right);
		else return size(x.left);
	}
	
	public void deleteMin() { root = deleteMin(root); }
	
	private Node deleteMin(Node x){
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key) { root = delete(root, key); }
	// 删除指定的结点
	private Node delete(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left, key);
		else if(cmp > 0) x.right = delete(x.right, key);
		else {
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Iterable<Key> keys() { return keys(min(), max()); }
	
	private Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if(x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo < 0) keys(x.left, queue, lo, hi);
		if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if(cmphi > 0) keys(x.right, queue, lo, hi);
	}
	
	private class Node{
		// 键
		private Key key;
		// 值
		private Value val;
		// 指向子树的链接
		private Node left, right;
		// 以该结点为根节点的结点总数
		private int N;
		
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
}
