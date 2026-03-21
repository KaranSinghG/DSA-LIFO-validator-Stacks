package implementation;

import exception.EmptyStackException;
import interfaces.MyStack;

public class ArrayStack<T> implements MyStack<T>{

    private T[] stack;
    private int top = -1;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        stack = (T[]) new Object[capacity];
    }

    @Override
    public void push(T value) {
        if  (stack.length == size()) {
            resize();
        }
        stack[++top] = value;
    }

    private void resize() {
        T[] newStack = (T[]) new Object[stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        System.out.println("Resizing stack to capacity: " + newStack.length);
        stack = newStack;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = stack[top];
        stack[top--] = null;
        return value;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return top + 1;
    }
    
}
