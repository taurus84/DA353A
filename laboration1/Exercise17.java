package laboration1;

public class Exercise17 {
	
	public void mystery6(int a) {
		if (a >= 0) {
			System.out.println("a=" + a);
			mystery6(a - 4);
			mystery6(a - 3);
		}
	}
	
	public static void main(String[] args) {
		Exercise17 prog = new Exercise17();
		prog.mystery6(10);
	} 
	
	/*	UTSKRIFT
	 * 	a=10
		a=6
		a=2
		a=3
		a=0
		a=7
		a=3
		a=0
		a=4
		a=0
		a=1
	 */

}
