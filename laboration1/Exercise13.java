package laboration1;

public class Exercise13 {
	
	public String reverse( String str ) { 
		
		if(str.length() == 1) {
			return str;
		} else {
		return reverse(str.substring(1)) + str.charAt(0);
		}
		
	}
	
	public static void main(String[] args) {
		Exercise13 prog = new Exercise13();
		System.out.println( prog.reverse( "Student" ) ); // Resultat: tnedutS
	}

}
