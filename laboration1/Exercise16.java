package laboration1;

public class Exercise16 {
	
	public void printString(String txt, int pos, int n) {
		if(pos < txt.length() && pos >= 0) {
			System.out.print(txt.charAt(pos));
			printString(txt, pos + n, n);
		}
	}

	public static void main(String[] args) {
		Exercise16 prog = new Exercise16();
		
		prog.printString( "Student", 0 , 2); // Resultat: Suet 
		System.out.println();
		prog.printString( "Student", 3 , -1); // Resultat: dutS 
		System.out.println();
		prog.printString( "du", 0 , 2); // Resultat: d 
		System.out.println();
		prog.printString( "Malmö högskola! ", -2 , 1); // Resultat: 
		System.out.println();
		prog.printString( "Hubert", 10 , 0); // Resultat:
	}
}
