package com.codecool.dynamicArrayDojo;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class MyStack<E> {

    private int size;
    private int top;
    private E[] stack;

    public MyStack(Class<E> cls, int size) {
        this.top = -1;
        this.size = size;
        @SuppressWarnings("unchecked")
        final E[] stack = (E[]) Array.newInstance(cls, size);
        this.stack = stack;
    }

    public int getSize() {
        return size;
    }

    public void push(E data) throws StackOverflowError {
        checkAvailableSpace();
        stack[++top] = data;
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    public E peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    public int checkAvailableSpace() throws StackOverflowError {
        int availableSpace = size - (top + 1);
        if (availableSpace == 0) throw new StackOverflowError();
        return availableSpace;
    }

    private boolean isEmpty() {
        return top == -1;
    }
}
