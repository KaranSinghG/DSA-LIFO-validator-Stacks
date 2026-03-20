package interfaces;
 
public interface MyStack<T> {
    
    void push(T value);
    T pop() throws exception.EmptyStackException;
    T peek() throws exception.EmptyStackException;
    boolean isEmpty();
    int size();
}
