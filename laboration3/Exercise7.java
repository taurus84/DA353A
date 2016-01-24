package laboration3;

public class Exercise7 {
	
	public int indexOf( Object[] array, Object obj) {
	
		int pos = -1;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(obj)) {
				pos = i;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		Exercise7 prog = new Exercise7();
		Exercise5o6 e56 = new Exercise5o6();
		
		String[] array = {"hej", "david", "dator", "mobil"};
		System.out.println(prog.indexOf(array, "dator"));
		
		int size = 100;
		RealNbr[] array2 = new RealNbr[size];
		array2 = e56.getRealNbrArray(size);
		System.out.println(prog.indexOf(array2, new RealNbr(55)));
		
	}
}

