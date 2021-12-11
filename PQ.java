public interface PQ<E extends Comparable<? super E>> {
    public boolean isEmpty();

    public E front();

    public int size();

    public void enqueue(E newValue);

    public E dequeue();
}
