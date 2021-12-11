import java.util.Random;
import java.util.function.Supplier;

public class PQStressTester {

    private static Random rand = new Random();

    public static void main(String[] args) {
        runTest(PQStressTester::randomValuesTest, "Random Values Enqueue/Dequeue", new int[]{50_000, 100_000, 200_000, 400_000});
        runTest(PQStressTester::sortedValuesTest, "Sorted Values Enqueue/Dequeue", new int[]{4000, 8000, 16000});
    }

    private static void randomValuesTest(PQ<Integer> pq, int n) {
        for(int i = 0; i < n; i++)
            pq.enqueue(rand.nextInt());
        
        while(!pq.isEmpty())
            pq.dequeue();
    }

    private static void sortedValuesTest(PQ<Integer> pq, int n) {
        for(int i = 0; i < n; i++)
            pq.enqueue(i);
        
        while(!pq.isEmpty())
            pq.dequeue();
    }


    private static void runTest(StressTest test, String testName, int[] nValues) {
        Supplier<PQ<Integer>>[] queues = (Supplier<PQ<Integer>>[]) new Supplier[]{
            () -> new HeapPQ<Integer>(), 
            () -> new BinarySearchTreePQ<Integer>(), 
            () -> new TreeSetPQ<Integer>()
        };
        String[] queueNames = {"Heap", "BST", "TreeSet (red black tree)"};

        System.out.println("~~~ " + testName + " ~~~");
        for (int i = 0; i < queues.length; i++) {
            System.out.println("  " + queueNames[i]);
            for(int n : nValues) {
                long before = System.currentTimeMillis();
                test.run(queues[i].get(), n);
                long after = System.currentTimeMillis();
                System.out.printf("N = %7d : %7d ms\n", n, after - before);
            }
            System.out.println();
        }
    }
}
