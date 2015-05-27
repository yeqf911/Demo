package queue;

import java.util.Iterator;

/**
 * Created by yeqf on 5/12/15.
 */
public class MQueue<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int N;

    public MQueue() {
        head = tail = null;
        N = 0;
    }

    public static void main(String[] args) {
        MQueue<String> q = new MQueue<String>();
        String a = "Hello ";
        String b = "I am ";
        String c = "yeqianfeng";
        q.enQueue(a);
        q.enQueue(b);
        System.out.println("-------"+q.size());
        System.out.println(q.deQueue());
        System.out.println("-------"+q.size());
        q.enQueue(c);
        System.out.println("-------"+q.size());
        Iterator<String> iter = q.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return N;
    }

    public void enQueue(T t) {
        Node oldtail = tail;
        tail = new Node();
        tail.item = t;
        tail.next = null;
        if (isEmpty())
            head = tail;
        else oldtail.next = tail;
        N++;
    }

    public T deQueue() {
        T t = head.item;
        head = head.next;
        N--;
        if (isEmpty())
            tail = head;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new IterListen();
    }

    private class Node {
        T item;
        Node next;
    }

    private class IterListen implements Iterator<T> {
        private Node temp;
        //private int i;

        public IterListen() {
            temp = head;
            //i = N;
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
