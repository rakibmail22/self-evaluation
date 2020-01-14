package com.rakibmail22.datastructure;

/**
 * @author bashir
 * @since 11/1/20.
 */
public interface Queue<T> {

    Queue<T> enQueue(T t);

    Queue<T> deQueue();

    T head();

    boolean isEmpty();
}