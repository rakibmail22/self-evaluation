package com.rakibmail22.datastructure;

/**
 * @author bashir
 * @since 12/1/20.
 */
public interface Stack<E> {
    Stack<E> push(E item);

    Stack<E> pop();

    E peek();

    int size();

    boolean isEmpty();

    Stack<E> reverse();
}