package laboration1;

public class Exercise23 {
	
	public long fib2( int n ) {
        return fib2( n, 1, 1);
	}
	
	private long fib2(int n, int n1, int n2) {
		if(n <= 2) {
			return n2;
		} else {
			return fib2(n - 1, n2, n1 + n2);
		}
	}
	
	public static void main(String[] args) {
		Exercise23 prog = new Exercise23();
		long starttid = System.currentTimeMillis();
		
		for(int i = 0; i < 10000000; i++) {
			prog.fib2(30);
		}
		long stopptid = System.currentTimeMillis(); 
		System.out.println( stopptid - starttid );	
		
	}
}
		

