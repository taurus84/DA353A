package readWrite;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		ReadWriteLines rw = new ReadWriteLines();

		try {
			rw.Write("C:/temp/skrivafil.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		String[] arr = null;
		try {
			arr = rw.OpenFile("C:/temp/fil.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Person[] p = new Person[arr.length];

		for (int i = 0; i < arr.length; i++) {
			String[] splitter = arr[i].split("\\s+"); // Splitta upp varje
														// element till enskilda
														// strängar (mellan
														// space)

			p[i] = new Person(splitter[0], Integer.parseInt(splitter[1]),
					Float.parseFloat(splitter[2]), splitter[3]);
		}

		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}
}
