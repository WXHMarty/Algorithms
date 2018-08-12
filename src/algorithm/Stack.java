package algorithm;

import java.util.Iterator;

/**
 * 算法1.2
 * 下压栈堆
 * 由链表实现
 * @author Administrator
 *
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {

	// 栈顶(最近添加的元素)
	private Node first;
	
	// 元素数量
	private int N;
	
	public boolean isEmpty () { return first == null; }
	
	public int size () { return N; }
	
	// 向栈顶添加元素
	public void push (T t) {
		Node oldfirst = first;
		first = new Node();
		first.t = t;
		first.next = oldfirst;
		N++;
	}
	
	// 从栈顶删除元素
	public T pop () {
		T t = first.t;
		first = first.next;
		N--;
		return t;
	}
	
	// 实现iterator
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 定义节点嵌套类
	private class Node {
		T t;
		Node next;
	}

}
