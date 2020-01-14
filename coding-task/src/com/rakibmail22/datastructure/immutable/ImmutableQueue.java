package com.rakibmail22.datastructure.immutable;

import com.rakibmail22.datastructure.Queue;
import com.rakibmail22.datastructure.Stack;

import java.io.Serializable;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author bashir
 * @since 11/1/20.
 */
public class ImmutableQueue<T> implements Queue<T>, Serializable {

    private static final long serialVersionUID = 232423421L;

    private final Stack<T> front;
    private final Stack<T> back;

    public ImmutableQueue() {
        front = null;
        back = null;
    }

    private ImmutableQueue(Stack<T> front, Stack<T> back) {
        this.front = front;
        this.back = back;
    }

    @Override
    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<>(this.front, isNull(this.back) ? new ImmutableStack<>(t) : this.back.push(t));
    }

    @Override
    public Queue<T> deQueue() {
        if (isStackEmpty(this.back) && isStackEmpty(this.front)) {
            throw new IndexOutOfBoundsException("-1");
        }

        if (isStackEmpty(this.front)) {
            return new ImmutableQueue<>(nonNull(this.back) ? this.back.reverse().pop() : null, null);
        }

        return new ImmutableQueue<>(this.front.pop(), this.back);
    }

    @Override
    public T head() {
        if (nonNull(this.front) && !this.front.isEmpty()) {
            return this.front.peek();
        }

        if (nonNull(this.back)) {
            return this.back.reverse().peek();
        }

        throw new UnsupportedOperationException("Cannot peek an empty queue");
    }

    @Override
    public boolean isEmpty() {
        return isStackEmpty(this.front) && isStackEmpty(this.back);
    }

    private boolean isStackEmpty(Stack<T> stack) {
        return isNull(stack) || stack.isEmpty();
    }
}