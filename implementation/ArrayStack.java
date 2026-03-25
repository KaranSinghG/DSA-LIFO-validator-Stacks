package implementation;

import exception.EmptyStackException;
import interfaces.MyStack;

public class ArrayStack<T> implements MyStack<T>{

    private T[] stack;
    private int top = -1;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        int intialCapacity = capacity > 0 ? capacity : 2;
        stack = (T[]) new Object[intialCapacity];
    }

    public ArrayStack() {
        this(2);
    }

    @Override
    public void push(T value) {
        if  (stack.length == size()) {
            resize();
        }
        stack[++top] = value;
    }

    @SuppressWarnings("unchecked")
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
        if (isEmpty()) throw new EmptyStackException();
        T value = stack[top];
        stack[top--] = null;
        return value;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
    
}
