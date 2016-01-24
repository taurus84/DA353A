package f4;

import laboration4.Sorting;

public class SortComparable {
    public void compare1() {
        Commodity c1 = new Commodity("D", 12.25);
        Commodity c2 = new Commodity("B", 8.90);
        
        Comparable<Commodity> comp = ( Comparable<Commodity> )c1;
        int res = comp.compareTo( c2 );
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
        
        int res = ( ( Comparable<Commodity> ) c1 ).compareTo( c2 );
        if( res == -1 )
            System.out.println( c1 + "\n" + c2);
        else if( res == 0 )
            System.out.println("Lika stora");
        else
            System.out.println( c2 + "\n" + c1);
    }

    public void compare3() {
        Commodity c1 = new Commodity("D", 12.25);
        Commodity c2 = new Commodity("B", 8.90);
        
        if( ( ( Comparable<Commodity> ) c1 ).compareTo( c2 ) > 0)
            System.out.println("c1 är större än c2, BYT PLATS");
        if( ( ( Comparable<Commodity> ) c2 ).compareTo( c1 ) > 0)
            System.out.println("c2 är större än c1, BYT PLATS");
    }

    public void sort1() {
        Commodity[] commodities = { new Commodity("D", 12.25), new Commodity("B", 8.90), new Commodity("M", 10.00), new Commodity("F", 9.95),
        		new Commodity("Q", 14.25), new Commodity("W", 8.10), new Commodity("E", 10.05), new Commodity("R", 9.05)};
        Sorting.insertionsort1( commodities );
        for( int i = 0; i < commodities.length; i++ )
            System.out.println(commodities[ i ]); 
    }
    
    public static void main(String[] args) {
        SortComparable sv = new SortComparable();
        sv.compare1();
//        sv.sort1();
    }
}
