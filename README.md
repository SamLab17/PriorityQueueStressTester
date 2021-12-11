# Priority Queue Stress Tester

Sample Output:

```
~~~ Random Values Enqueue/Dequeue ~~~
  Heap
N =   50000 :      19 ms
N =  100000 :      24 ms
N =  200000 :      45 ms
N =  400000 :      83 ms

  BST
N =   50000 :      16 ms
N =  100000 :      24 ms
N =  200000 :      47 ms
N =  400000 :     119 ms

  TreeSet (red black tree)
N =   50000 :      24 ms
N =  100000 :      27 ms
N =  200000 :      57 ms
N =  400000 :     115 ms

~~~ Sorted Values Enqueue/Dequeue ~~~
  Heap
N =    4000 :       0 ms
N =    8000 :       1 ms
N =   16000 :       3 ms

  BST
N =    4000 :      48 ms
N =    8000 :     184 ms
N =   16000 :     785 ms

  TreeSet (red black tree)
N =    4000 :       1 ms
N =    8000 :       1 ms
N =   16000 :       1 ms
```