package laboration3;

import java.util.Random;

public class Exercise5o6 {
	
	public RealNbr[] getRealNbrArray( int n ) {
		RealNbr[] realNbr = new RealNbr[n];			//skapa en RealNbr array med n element
		Random rand = new Random();
		
		//fyll arrayen med RealNbr objekt
		for(int i = 0; i < realNbr.length; i++) {				
			realNbr[i] = new RealNbr(rand.nextInt(100));
		}
		Exercise4.shuffle(realNbr);			//blanda arrayen
		return realNbr;
	}
	
	public int indexOf( RealNbr[] array, RealNbr value) {
	
		int pos = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i].getValue() == value.getValue()) {
				pos = i;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		Exercise5o6 prog = new Exercise5o6();
		int size = 100;
		RealNbr[] array = new RealNbr[size];
		array = prog.getRealNbrArray(size);
		System.out.println(prog.indexOf(array, new RealNbr(40)));
			
	}
}
