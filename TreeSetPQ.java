import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetPQ<E extends Comparable<? super E>> implements PQ<E> {
    private TreeSet<E> pq;

    public TreeSetPQ() {
        pq = new TreeSet<>();
    }

    public boolean isEmpty() { return pq.isEmpty(); }

    public E front() { return pq.first(); }

    public int size() { return pq.size(); }

    public void enqueue(E newValue) { pq.add(newValue); }

    public E dequeue() { 
        // E remove = pq.first();
        // pq.remove(remove); 
        // return remove;

        Iterator<E> it = pq.iterator();
        E removed = it.next();
        it.remove();
        return removed;
    }
}
