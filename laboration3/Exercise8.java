package laboration3;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise8 {

	public void action() {
		Laboration3 l3 = new Laboration3();
		ArrayList<Integer> listInt = l3.fillInteger(10000, 10000, 50000);
		
		ArrayList<RealNbr> listReal = new ArrayList<RealNbr> ();
		
		for(int i = 0; i < listInt.size(); i++) {
			listReal.add(new RealNbr(listInt.get(i)));
		}
		
		Collections.sort(listReal);
		
		System.out.println(Collections.binarySearch( listReal, new RealNbr(10000000)));
		
		
		
	}
	
	public static void main(String[] args) {
		Exercise8 prog = new Exercise8();
		prog.action();
	}
}
