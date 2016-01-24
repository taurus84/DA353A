package f5;
import java.util.EmptyStackException;

public class ObjectStack {
    private Object[] elements;
    private int size=0;
    
    public ObjectStack(int capacity) {
        elements = new Object[capacity];
    }

    public void push(Object element) {
    	if(size>=elements.length)
    		throw new StackOverflowError();
        elements[ size ] = element;
        size++;
    }

    public Object pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public Object peek() {
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
        ObjectStack stack = new ObjectStack(20);
        Integer elem;
        for(int i=30; i<40; i++) {
            stack.push(new Integer(i));
        }
        while(!stack.empty()) {
            elem = (Integer)stack.pop();
            System.out.print(elem + " ");
        }
        
        System.out.println("\n----------------------------");
        for( int i = 50; i < 55; i++ )
            stack.push( new Integer( i ) );
        System.out.println( "Size = " + stack.size() );
        System.out.println( "Första element = " + stack.peek() );
        while( !stack.empty() )
            System.out.println( "Element = " + stack.pop() +", size = " + stack.size() );
    }
}
