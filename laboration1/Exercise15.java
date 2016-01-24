package laboration1;

public class Exercise15 {
	
	public void everySecond(String str, int min, int max) {
		if (min >= 0 && min <= max && max < str.length()) {
			System.out.print(str.charAt(min));
			everySecond(str, min + 1, max);
		}
	}
	
	public static void main(String[] args) {
		Exercise15 prog = new Exercise15();
		prog.everySecond( "Student", 0, 6 ); // Resultat: Student 
		System.out.println();
		prog.everySecond( "Student", 3, 5 ); // Resultat: den 
		System.out.println();
		prog.everySecond( "Malmö högskola!", -4, 6 ); // Resultat: 
		System.out.println();
		prog.everySecond( "Hubert", 2, 10 ); // Resultat: 
		System.out.println();
//		prog.everySecond( "Hubert", 5, 2 ); // Resultat:
	}

}
