package laboration1;

public class Exercise3o4 {

	public void mystery1(int n) {
		if (n > 0) {
			System.out.println(n);
			mystery1(n - 2);
		}
	}

	public void mystery2(int a, int b) {
		if (a <= b) {
			System.out.println(a + " + " + b + " = " + (a + b));
			mystery2(a + 1, b - 1);
		}
	}

	public static void main(String[] args) {
		Exercise3o4 prog = new Exercise3o4();
		prog.mystery1(10);				 // Resultat: 10 8 6 4 2 Ny rad efter varje tecken
		prog.mystery2(10, 20);			//10 + 20 = 30
										//11 + 19 = 30
										//12 + 18 = 30
										//13 + 17 = 30
										//14 + 16 = 30
										//15 + 15 = 30
	}
}
