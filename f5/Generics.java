package f5;
import java.util.*;

public class Generics {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        String[] names = {"Eva","Gunnar","Axel","Inger"};
        
        for(int i=0; i<names.length; i++)
            list.add(new Person(names[i]));
        
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getName());  // Ej typkonvertering
        }
        
//        list.add("Hoppsan");  // Kompilatorn kontrollerar typ
//        String str = (String)list.get(2); // Kompilatorn kontrollerar typ
    }
}
