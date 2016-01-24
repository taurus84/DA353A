package laboration1;

public class Exercise14 {

	public int mystery5(int n, int res) {
		if (n == 1)
			return res;
		else
			return mystery5(n - 1, n * res);
	}
	
	public static void main(String[] args) {
		Exercise14 prog = new Exercise14();
		System.out.println( prog.mystery5( 4, 1 ) );	//4,1 > 3,4 > 2,12 > 1,24 -> return 24
	}
}

