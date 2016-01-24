package laboration1;

public class Exercise6 {

	public void print(String txt, int pos) {
		if(pos >= 0 && pos < txt.length()) {
			System.out.print(txt.charAt(pos));
			print(txt, pos+1);
		}
		
	}
	
	public static void main(String[] args) {
		Exercise6 prog = new Exercise6();
		prog.print("Student", 0);			// Resultat: Student
		System.out.println();
		prog.print( "Student" , 3);			// Resultat: dent
		System.out.println();
		prog.print( "Malmö högskola!" , 6); // Resultat: högskola!
		System.out.println();
		prog.print( "Hubert" , 10);	 		// Resultat:
		System.out.println();
		prog.print( "Negativ position" , -6); // Resultat:
		
	}
}
