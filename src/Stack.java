import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node first;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        first = new Node(item, first);
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls pop() with empty stack");
        }
        Item res = first.item;
        first = first.next;
        size--;
        return res;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls peek() with empty stack");
        }
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node p = first;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("calls next() with empty stack");
            }
            Item res = p.item;
            p = p.next;
            return res;
        }

        @Override
        public void remove() {}
    }

}
