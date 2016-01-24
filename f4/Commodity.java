package f4;

public class Commodity implements Comparable<Commodity> {
    private String name;
    private double price;
    
    public Commodity( String name, double price ) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() { 
        return price;
    }
    
    public String toString() {
        return name + ": " + price;
    }
    
    public int compareTo( Commodity c ) {
        if( this.price < c.price )
            return -1;
        else if( this.price == c.price )
            return 0;
        else
            return 1;
    }
}
