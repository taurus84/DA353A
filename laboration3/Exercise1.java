package laboration3;

public class Exercise1 {
	
	public int indexOf( double[] array, double value) {
	
		int pos = -1;
		
		for(int i = 0; i < array.length; i++) {
			if( array[i] == value) {
				pos = i;
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		Exercise1 prog = new Exercise1();
		double[] array = { 1,2,3,4,5,6,7,8,9,10 };
		System.out.println(prog.indexOf(array, 10));
	}
}
		

