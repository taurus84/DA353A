package laboration3;

public class Exercise2 {

	public int indexOf( String[] array, String value) {
	
		int pos = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(value)) {
				pos = i;
			}
		}
		return pos;
		
	}
	public static void main(String[] args) {
		Exercise2 prog = new Exercise2();
		String[] array = {"hej", "david", "dator", "mobil"};
		System.out.println(prog.indexOf(array, "dator"));
		
		
	}
}
