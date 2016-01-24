package f14;
import java.util.*;

public class Speed {
	  private HashMap<String,Test> hash = new HashMap<String,Test>(1000);
	  private TreeMap<String,Test> tree = new TreeMap<String,Test>();
	  private ArrayList<Test> list1 = new ArrayList<Test>();
	  private ArrayList<Test> list2 = new ArrayList<Test>();
	  private Test[] test = new Test[100000];
	  private StopWatch watch = new StopWatch();

	  public Speed() {
	    for(int i=0; i<test.length; i++) {
	      test[i] = new Test(String.valueOf(1000000+i*10));
	    }
	    for(int i=0; i<test.length; i++)
	      swap(test,(int)(Math.random()*test.length),(int)(Math.random()*test.length));
	  }

	  public void testa(int n) {
	    long hashGet,treeGet,list1Get,list2Get;

	    hash.clear();
	    tree.clear();
	    list1.clear();
	    list2.clear();
	    for(int i=0; i<n; i++) {
	      hash.put(test[i].getText(),test[i]);
	      tree.put(test[i].getText(),test[i]);
	      list1.add(test[i]);
	      list2.add(test[i]);
	    }
	    Collections.sort(list2);

	    watch.start();
	    for(int i=0; i<100000; i++)
	      hash.get(test[i%n].getText());
	    watch.stop();
	    hashGet = watch.getMilliseconds();

	    watch.start();
	    for(int i=0; i<100000; i++)
	      tree.get(test[i%n].getText());
	    watch.stop();
	    treeGet = watch.getMilliseconds();

	    watch.start();
	    for(int i=0; i<10000; i++) {
	      list1.indexOf(test[i*10%n]);
	    }
	    watch.stop();
	    list1Get = watch.getMilliseconds()*10;

	    watch.start();
	    for(int i=0; i<100000; i++) {
	      Collections.binarySearch(list2,test[i%n]);
	    }
	    watch.stop();
	    list2Get = watch.getMilliseconds();

	    System.out.println(n+"  hashMap: get="+hashGet+"    treeMap: get="+treeGet+
        "    osort="+list1Get+"    sort="+list2Get);
	  }

	  private void swap(Test[] arr, int a,  int b) {
	    Test temp = arr[a];
	    arr[a]=arr[b];
	    arr[b]=temp;
	  }

	  public static void main(String[] args) {
	    Speed speed = new Speed();
	    speed.testa(1000);
	    speed.testa(10000);
	    speed.testa(100000);

	  }

	  private class Test implements Comparable<Test> {
	    private String text;

	    public Test(String txt) {
	      this.text = txt;
	    }

	    public String getText() {
	      return text;
	    }

	    public int compareTo(Test obj) {
	      return text.compareTo(obj.getText());
	    }
	  }
	}