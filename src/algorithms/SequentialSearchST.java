package algorithms;
/**
 * 无序链表的顺序查找(基于无序链表)
 * @author Administrator
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {
	// 链表首结点
	private Node first;
	
	// 链表的总结点数
	private int N = 0;
	
	// 链表的键的数组
	private Key[] keys = (Key[]) new Comparable[0];
	
	// 根据给定的键，查找返回关联的值
	public Value get(Key key) {
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.key)) return x.val;
		return null;
	}
	
	// 查找给定的键，找到则更新其值，没有找到则新建结点
	public void put(Key key, Value val) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) x.val = val; return;
		}
		first = new Node(key, val, first);
		resize(++N);
		keys[N-1] = key;
	}
	
	// 返回keys
	public Key[] keys() { return this.keys; }
	
	// 返回列表的结点数
	public int size() { return this.N; }

	// 删除key结点
	public void delete(Key key) {
		System.out.println("该方法还没有实现");
	}
	
	// keys数组的移动
	private void resize(int max) {
		Key[] temp = (Key[]) new Comparable[max];
		for(int i = 0; i < N; i++) temp[i] = keys[i];
		keys = temp;
	}
	
	// 链表的结点定义
	private class Node {
		
		private Key key;
		
		private Value val;
		
		private Node next;
		
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
}
