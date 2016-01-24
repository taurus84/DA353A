package laboration1;

public class Exercise19 {
	
	public int digits( String str ) { 
		
		if(str.length() > 0) {
			if(str.charAt(0) >= '0' && str.charAt(0) <='9') {
				return 1 + digits(str.substring(1));
			} else
				return 0 + digits(str.substring(1));
		}
		return 0;
	}

	public static void main(String[] args) {
		Exercise19 prog = new Exercise19();
//		System.out.println( prog.digits( "Student" ) ); // Resultat: 0 
//		System.out.println( prog.digits( "RDS 435" ) ); // Resultat: 3 
		System.out.println( prog.digits( "Pw TT54W41" ) ); // Resultat: 4
	}
}
