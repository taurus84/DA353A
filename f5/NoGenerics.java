package f5;
import java.util.*;

public class NoGenerics {
    public static void main(String[] args) {
        List list = new ArrayList();
        String[] names = {"Eva","Gunnar","Axel","Inger"};
        Person person;
        
        for(int i=0; i<names.length; i++)
            list.add(new Person(names[i]));
        
        for(int i=0; i<list.size(); i++) {
            person = (Person)list.get(i);  // Nödvändigt med typkonvertering
            System.out.println(person.getName());
        }
        
//        list.add("Hoppsan");  // Ett String-objekt bland Person-objekt
        for(int i=0; i<list.size(); i++) {
            person = (Person)list.get(i); // ClassCastException kan inträffa        
            System.out.println(person.getName()); 
        }
//        String str = (String)list.get(0); // ClassCastException kan inträffa
    }
}
