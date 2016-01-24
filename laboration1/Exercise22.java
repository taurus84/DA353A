package laboration1;

public class Exercise22 {
	
	public static void main(String[] args) {
		Exercise21 prog = new Exercise21();
		long starttid = System.currentTimeMillis();
		
		for(int i = 0; i < 1000; i++) {
			prog.fib(30);
		}
		long stopptid = System.currentTimeMillis(); 
		System.out.println( stopptid - starttid );			
	}
	
	/*
	 *  Det tar ca 4700 ms
	 */

}
