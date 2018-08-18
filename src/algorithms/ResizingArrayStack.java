package algorithms;

import java.util.Iterator;
/**
 * 算法1.1 下压(LIFO)栈
 * 能够动态调用数组大小的实现
 * @author Administrator
 *
 * @param <T>
 */
public class ResizingArrayStack<T> implements Iterable<T> {
	
	public T[] a = (T[]) new Object[1];
	private int N = 0;
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }

	// 将栈移动到一个大小为max的新数组中
	private void resize(int max){
		T[] t = (T[]) new Object[max];
		for(int i = 0; i < N; i++) t[i] = a[i];
		a = t;
	}
	
	// 将元素添加到栈顶
	public void push(T t){
		if(N == a.length) resize(2 * a.length);
		a[N++] = t;
	}
	
	// 从栈顶删除元素
	public T pop () {
		T t = a[--N];
		a[N] = null; // 避免对象游离
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return t;
	}
	
	@Override
	public Iterator<T> iterator () { return new ReverseArrayIterator(); }
	
	// 支持后进先出的迭代
	private class ReverseArrayIterator implements Iterator<T>{
		private int i = N;
		
		public boolean hasNext(){ return i > 0; }
		public T next() { return a[--i]; }
		public void remove() {}
	}
}
