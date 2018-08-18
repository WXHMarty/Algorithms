package algorithms;

import java.util.Iterator;

/**
 * 算法1.3
 * 先进先出队列
 * @author Administrator
 *
 * @param <T>
 */
public class Queue<T> implements Iterable<T> {
	// 指向最早添加的借点链接
	private Node first;
	
	// 指向最近添加的节点链接
	private Node last;
	
	// 队列中的元素数量
	private int N;
	
	public boolean isEmpty () { return first == null; }
	
	public int size () { return N; }
	
	// 向表尾添加元素
	public void enqueue (T t) {
		Node oldlast = last;
		last = new Node();
		last.t = t;
		last.next = null;
		if (isEmpty()) first = last;
		else last.next = oldlast;
		N++;
	}
	
	// 从表头删除元素
	public T dequeue () {
		T t = first.t;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return t;
	}
	
	// Iterator实现
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
