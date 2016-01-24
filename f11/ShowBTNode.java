package f11;
import javax.swing.*;
import java.awt.*;

public class ShowBTNode<V> extends JLabel {
    private BTNode<V> node;
    
    public ShowBTNode( BTNode<V> node, int width, int height ) {
        this.node = node;
        this.setPreferredSize( new Dimension( width, height ) ); // beräknas avseende höjd
    }
    
    public void setNode( BTNode<V> node ) {
        this.node = node;
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(node!=null) {
            int levels = node.depth();
            if(levels >= 0) {
                int width = (this.getWidth()-40)/(int)Math.pow(2,levels);
                int height = this.getHeight()/(levels+1);
                int x = this.getWidth()/2 - width/2;
                showNodes(g,node,1,x,0,width,height,(this.getWidth()-40)/4,x+width/2);
            }
        }
    }
    
    public void showNodes(Graphics g, BTNode<V> node, int level, int x, int y, int width, int height, int dx, int lineX) {
        if(node!=null) {
            showNodes(g,node.getLeft(),level+1,x-dx,y+height,width,height,dx/2,x+width/2);
            showNode( g, node, x+width/8 ,y+height/8 ,width-width/4 ,height-height/4 );
            if(level>=1) {
                g.drawLine(x+width/2,y+height/8,lineX,y-height/8);
            }
            showNodes(g,node.getRight(),level+1,x+dx,y+height,width,height,dx/2,x+width/2);
        }
    }
    
    public void showNode(Graphics g, BTNode<V> node, int x, int y, int width, int height) {
        g.setFont(new Font("SansSerif",Font.BOLD,12));
        g.setColor(Color.cyan);
        g.fillRect(x,y,width,height);
        g.setColor(Color.black);
        g.drawRect(x,y,width,height);
        g.drawString(node.getValue().toString(),x+4,y+height/2+4);
    }
}
