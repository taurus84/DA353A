package f5;
import java.util.EmptyStackException;

public class IntStack {
    private int[] elements;
    private int size=0;
    
    public IntStack(int capacity) {
        elements = new int[capacity];
    }

    public void push(int element) {
    	if(size>=elements.length)
    		throw new StackOverflowError();
        elements[ size ] = element;
        size++;
    }

    public int pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public int peek() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return elements[size-1];
    }

    public boolean empty() {
        return (size==0);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        IntStack stack = new IntStack(20);
        int elem;
        for(int i=30; i<40; i++) {
            stack.push(i); 
        }
        while(!stack.empty()) {
            elem = stack.pop();
            System.out.print(elem + " ");
        }
    }
}
