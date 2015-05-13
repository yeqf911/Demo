package bag;

import java.util.Iterator;

/*************************************************************************
    > File Name: MBag.java
    > Author: yeqianfeng
    > Mail: yeqianfeng911@gmail.com 
    > Created Time: Wed 13 May 2015 10:47:48 AM CST
 ************************************************************************/
public class MBag<T> implements Iterable<T> {
	private Node first;
	private int N;

	public MBag(){
		first = null;
		N = 0;
	}

	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}

	public void addItem(T t) {
		Node oldfirst = first;
		first = new Node();
		first.item = t;
		oldfirst.next = first;
		N++;
	}

	@Override
	public Iterator<T> iterator(){
		return new IterListen();
	}

	private class IterListen implements Iterator<T> {
		private Node temp;

		public IterListen(){
			temp = first;
		}
		
		public boolean hasNext(){
			return temp != null;
		}

		public T next() {
			T t = temp.item;
			temp = temp.next;
			return t;
		}
	}

	private class Node {
		T item;
		Node next;
	}
}
