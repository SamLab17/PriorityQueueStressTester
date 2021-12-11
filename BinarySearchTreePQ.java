import java.util.NoSuchElementException;

public class BinarySearchTreePQ<E extends Comparable<? super E>> implements PQ<E> {

    private BSTNode<E> root;
    private int size = 0;

    public boolean isEmpty() { return size == 0; }

    public E front() {
        if(size == 0) throw new NoSuchElementException("queue empty.");
        BSTNode<E> cur = root;
        while(cur.left != null)
            cur = cur.left;
        return cur.data;
    }

    public int size() { return size; }

    public void enqueue(E newValue) {
        root = addHelp(root, newValue);
    }

    private BSTNode<E> addHelp(BSTNode<E> cur, E data) {
        if(cur == null) { 
            size++;
            return new BSTNode<>(data); 
        }

        int dir = data.compareTo(cur.data);
        if(dir < 0)
            cur.left = addHelp(cur.left, data);
        else if(dir > 0)
            cur.right = addHelp(cur.right, data);
        return cur;
    }

    private E removed; // gack...i know
    public E dequeue() {
        // Remove minimum element in BST, easy!
        root = dequeueHelp(root);
        return removed;
    }

    private BSTNode<E> dequeueHelp(BSTNode<E> cur) {
        if(cur == null) {
            return null;
        }
        else if(cur.left == null) {
            // cur is the minimum
            size--;
            removed = cur.data;
            return cur.right;
        } else {
            // Keep going down to the left.
            cur.left = dequeueHelp(cur.left);
            return cur;
        }
    }

    private class BSTNode<E> {
        BSTNode<E> left, right;
        E data;
        public BSTNode(E data) {
            this.data = data;
        }
    }
}
