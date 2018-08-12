package algorithm;

import java.util.Iterator;

/**
 * 算法1.4
 * @author Administrator
 *
 * @param <T>
 */
public class Bag<T> implements Iterable<T> {
	//链表的首节点
	private Node first;
	
	public void add (T t) {
		Node oldfirst = first;
		first = new Node();
		first.t = t;
		first.next = oldfirst;
	}
	
	// Itorator的实现
	@Override
	public Iterator<T> iterator () { return new ListIterator(); }
	
	private class ListIterator implements Iterator<T> {

		private Node current = first;
		
		@Override
		public boolean hasNext() { return current != null; }

		@Override
		public T next() {
			T t = current.t;
			current = current.next;
			return t;
		}
		
		public void remove () {}
	}

	// 定义节点嵌套类
	private class Node {
		T t;
		Node next;
	}
 
}
