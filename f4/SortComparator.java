package f4;
import java.util.*;

import laboration4.Sorting;

public class SortComparator {
    public void compare1() {
        Commodity c1 = new Commodity("D", 12.25);
        Commodity c2 = new Commodity("B", 8.90);
        PriceDescending pd = new PriceDescending();
        
        int res = pd.compare( c1, c2 );
        if( res == -1 )
            System.out.println( c1 + "\n" + c2);
        else if( res == 0 )
            System.out.println("Lika stora");
        else
            System.out.println( c2 + "\n" + c1);
    } 
    
    public void compare2() {
        Commodity c1 = new Commodity("D", 12.25); 
        Commodity c2 = new Commodity("B", 8.90);
        Comparator<Commodity> comp = new PriceDescending();
        
        int res = comp.compare( c1, c2 );
        if( res == -1 )
            System.out.println( c1 + "\n" + c2);
        else if( res == 0 )
            System.out.println("Lika stora");
        else
            System.out.println( c2 + "\n" + c1);
    }
    
    public void sort1() {
        Commodity[] commodities = { new Commodity("D", 12.25), new Commodity("B", 8.90), new Commodity("M", 10.00), new Commodity("F", 9.95),
        		new Commodity("Q", 14.25), new Commodity("W", 8.10), new Commodity("E", 10.05), new Commodity("R", 9.05)};
        Sorting.bubblesort( commodities, new PriceDescending() );
        for( int i = 0; i < commodities.length; i++ )
            System.out.println(commodities[ i ]);
    }
    
    public static void main(String[] args) {
        SortComparator sv = new SortComparator();
        sv.compare1();
//        sv.compare2();
//        sv.sort1();
    }
}
