package f5;
import java.util.*;

public class IteratorEx {
    public static void main( String[] args ) {
        Collection<Person> list = new ArrayList<Person>();
        String[] names = {"Eva","Gunnar","Axel","Inger"};
        Person person;
        
        for(int i=0; i<names.length; i++)
            list.add(new Person(names[i]));
        
        System.out.println("-------------------------");
        Iterator<Person> iter1 = list.iterator();
        while( iter1.hasNext() ) {
            person = iter1.next();
            System.out.println( person.getName() );
        }        
        System.out.println("-------------------------");    
        for( Iterator<Person> iter2 = list.iterator(); iter2.hasNext(); ) {
            System.out.println( iter2.next().getName() );
        }
        System.out.println("-------------------------");
    }
}
