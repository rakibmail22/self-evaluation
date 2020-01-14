# Immutable Queue Implementation
This project contains Immutable Queue implementation with help of two
Immutable Stack with some performance improvement. 

This implementation approaches the immutable problem with structure
sharing. Multiple Queue can share same underlying Stack structure
and reference but no reference is mutated as a result of any
operation on the queue.

The enqueue operation is O(1) and the dequeue operation is O(n) with
a performance tuning that enables the subsequent dequeue to perform
as a O(1) till it reaches the last element when the dequeue operation
took a O(n) time.

