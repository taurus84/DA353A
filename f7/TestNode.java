package f7;
import java.awt.*;

public class TestNode {
    public void demo1() {
        ObjectNode n4 = new ObjectNode( new Person( "Bo", 53 ), null );
        ObjectNode n3 = new ObjectNode( new Person( "Ann", 34 ), n4 );
        ObjectNode n2 = new ObjectNode( new Person( "Gunilla", 55 ), n3 );
        ObjectNode n1 = new ObjectNode( new Person( "Eva", 52 ), n2 );
        ObjectNode list = new ObjectNode( new Person( "Henry", 67 ), n1 );
        
        System.out.println( list );
    }
    
    public void demo2() {
        ObjectNode n4 = new ObjectNode( new Color( 129, 32, 192 ), null );
        ObjectNode n3 = new ObjectNode( "Hej alla studenter!", n4 );
        ObjectNode n2 = new ObjectNode( new Person( "Gunilla", 55 ), n3 );
        ObjectNode n1 = new ObjectNode( new Point( -12, 7 ), n2 );
        ObjectNode list = new ObjectNode( new Long( 19266 ), n1 );
//        Node list = new Node( new Long( 19266 ), new Node( new Point( -12, 7 ), new Node( new Person( "Gunilla", 55 ), new Node( "Hej alla studenter!", new Node( new Color( 129, 32, 192 ), null ) ) ) ) );
        
        System.out.println( list );
    }
    
    public static void main(String[] args) {
        TestNode tn = new TestNode();
        tn.demo2();
    }
}

