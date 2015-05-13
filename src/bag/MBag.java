package bag;

import java.util.Iterator;
import java.util.Map;

/**
 * **********************************************************************
 * > File Name: MBag.java
 * > Author: yeqianfeng
 * > Mail: yeqianfeng911@gmail.com
 * > Created Time: Wed 13 May 2015 10:47:48 AM CST
 * **********************************************************************
 */
public class MBag<T> implements Iterable<T> {
    private Node first;
    private int N;

    public MBag() {
        first = null;
        N = 0;
    }

    public static void main(String[] args) {
        MBag<String> b = new MBag<>();
        String a = "Hello ";
        String s = "I am ";
        String c = "yeqianfeng";
        b.addItem(a);
        b.addItem(s);
        b.addItem(c);
        Iterator<String> iter = b.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return N;
    }

    public void addItem(T t) {
        Node oldfirst = first;
        first = new Node();
        first.item = t;
        first.next = oldfirst;
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new IterListen();
    }

    private class IterListen implements Iterator<T> {
        private Node temp;

        public IterListen() {
            temp = first;
        }

        public boolean hasNext() {
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
