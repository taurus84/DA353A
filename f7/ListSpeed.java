package f7;
import java.util.*;

public class ListSpeed {
  private Vector<Integer> vList = new Vector<Integer>();
  private java.util.ArrayList<Integer> aList = new java.util.ArrayList<Integer>();
  private java.util.LinkedList<Integer> lList = new java.util.LinkedList<Integer>();
  private static final int FIRST=0,MIDDLE=1,LAST=2;
  private static final String[] position = {"First","Middle","Last"};
  private StopWatch watch = new StopWatch();
  private Integer[] numbers = new Integer[10000];

  private int getIndex(java.util.List<Integer> list, int pos) {
    if(pos==FIRST)
      return 0;
    else if(pos==MIDDLE)
      return (int)(list.size()/2);  // Prova även med 4,8,1.5
    else
      return Math.max(list.size()-1,0);
  }

  public void clear() {
    vList.clear();
    aList.clear();
    lList.clear();
  }

  private long timeAddElements(java.util.List<Integer> list, int n, int pos) {
    watch.start();
    for(int i=0; i<n; i++)
      list.add(getIndex(list,pos),numbers[i]);
    watch.stopp();
    return watch.getMilliSeconds();
  }

  private long timeRemoveElements(java.util.List<Integer> list, int n, int pos) {
    watch.start();
    for(int i=0; i<n; i++)
      list.remove(getIndex(list,pos));
    watch.stopp();
    return watch.getMilliSeconds();
  }

  public void addElements(int antal, int pos) {
    long vTid,aTid,lTid;
    vTid = timeAddElements(vList,antal,pos);
    aTid = timeAddElements(aList,antal,pos);
    lTid = timeAddElements(lList,antal,pos);
    System.out.println("Lägg till "+position[pos]+":  Vector="+vTid+"  ArrayList="+aTid+"  LinkedList="+lTid);
  }

  public void removeElements(int antal, int pos) {
    long vTid,aTid,lTid;
    vTid = timeRemoveElements(vList,antal,pos);
    aTid = timeRemoveElements(aList,antal,pos);
    lTid = timeRemoveElements(lList,antal,pos);
    System.out.println("Ta bort "+position[pos]+":  Vector="+vTid+"  ArrayList="+aTid+"  LinkedList="+lTid);
  }

  public ListSpeed() {
    for(int i=0; i<numbers.length; i++)
      numbers[i] = new Integer(i);
  }

  public static void main(String[] args) {
    ListSpeed speed = new ListSpeed();

    speed.addElements(10000,FIRST);
    speed.removeElements(10000,FIRST);
    speed.clear();
    speed.addElements(10000,MIDDLE);
    speed.removeElements(10000,MIDDLE);
    speed.clear();
    speed.addElements(10000,LAST);
    speed.removeElements(10000,LAST);
  }
}
