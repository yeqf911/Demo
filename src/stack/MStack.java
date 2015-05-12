package stack;

import java.util.Iterator;

/**
 * Created by yeqianfeng on 5/12/15.
 */
public class MStack<T> implements Iterable<T> {

    private int N;
    private Node first;

    public MStack() {
        first = null;
        N = 0;

    }

    public static void main(String[] args) {
        MStack<String> s = new MStack<String>();
        String a = "yeqianfeng";
        String b = "I am ";
        String c = "Hello ";
        s.push(a);
        s.push(b);
        s.push(c);
        System.out.print(s.pop() + s.pop() + s.pop());
        System.out.print("a");
    }

    public boolean ifEmpty() {
        return first == null;

    }

    public int size() {
        return N;

    }

    public void push(T t) {
        Node oldfirst = first;
        first = new Node();
        first.item = t;
        N++;
        first.next = oldfirst;
    }

    public T pop() {
        T t = first.item;
        first = first.next;
        N--;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new IterLisner();
    }

    private class Node {
        private T item;
        private Node next;
    }

    private class IterLisner implements Iterator<T> {
        private Node temp;

        public IterLisner() {
            temp = first;
        }

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {
            T t = temp.item;
            temp = temp.next;
            return t;
        }
    }
}
