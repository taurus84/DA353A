package f4;
import java.util.Comparator;

public class PriceDescending implements Comparator<Commodity> {
    public int compare( Commodity com1, Commodity com2 ) {
        double res = com1.getPrice() - com2.getPrice();
        if( res < 0 )
            return 1;
        else if( res == 0 )
            return 0;
        else
            return -1; 
    }
}
