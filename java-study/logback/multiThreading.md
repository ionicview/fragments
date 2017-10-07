# logback


package ch.qos.logback.core.util;

A GC-free lock-free thread-safe implementation of the {@link List} interface for use cases where iterations over the list vastly out-number modifications on the list.

it wraps an instance of {@link CopyOnWriteArrayList} and exposes a copy of the array used by that instance.


<p>If the list is not modified, then repetitive calls to {@link #asTypedArray()}, {@link #toArray()} and
{@link #toArray(Object[])} are guaranteed to be GC-free. Note that iterating over the list using
{@link COWArrayList#iterator()} and {@link COWArrayList#listIterator()} are <b>not</b> GC-free.</p>

---
![#1589F0](https://placehold.it/15/1589F0/000000?text=+)
just like CopyOnWriteList
Thus we can use logger in multiThreading access shared variable
