package com.rakibmail22.datastructure.immutable;

import com.rakibmail22.datastructure.Stack;

import java.io.Serializable;

/**
 * @author bashir
 * @since 12/1/20.
 */
public class ImmutableStack<E> implements Serializable, Stack<E> {

    private static final long serialVersionUID = 112123321L;

    private final E head;

    private final Stack<E> tail;

    public final int size;

    public ImmutableStack(E head) {
        this.head = head;
        this.tail = new EmptyStack<E>();
        this.size = 1;
    }

    private ImmutableStack(E head, ImmutableStack<E> tail) {
        this.head = head;
        this.tail = tail;
        this.size = tail.size + 1;
    }

    @Override
    public ImmutableStack<E> push(E item) {
        return new ImmutableStack<>(item, this);
    }

    @Override
    public Stack<E> pop() {
        return this.tail;
    }

    @Override
    public E peek() {
        return this.head;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Stack<E> reverse() {
        if (this.isEmpty()) {
            return new EmptyStack<>();
        }

        Stack<E> reversedStack = new ImmutableStack<>(this.peek());
        Stack<E> currentStack = this.pop();
        while (!currentStack.isEmpty()) {
            reversedStack = reversedStack.push(currentStack.peek());
            currentStack = currentStack.pop();
        }

        return reversedStack;
    }

    private static class EmptyStack<E> implements Stack<E>, Serializable {

        private static final long serialVersionUID = 112123322L;

        @Override
        public Stack<E> push(E item) {
            throw new UnsupportedOperationException("Cannot add elements to empty stack");
        }

        @Override
        public Stack<E> pop() {
            throw new UnsupportedOperationException("Cannot pop from an empty stack");
        }

        @Override
        public E peek() {
            throw new UnsupportedOperationException("Cannot peek an empty stack");
        }

        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }

        @Override
        public Stack<E> reverse() {
            throw new UnsupportedOperationException("Cannot reverse an empty stack");
        }
    }
}