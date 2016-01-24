package p1;

import java.io.IOException;

import readWrite.Person;
import readWrite.ReadWriteLines;

public class TEST {
	public static void main(String[] args) {
		ReadWriteLines rw = new ReadWriteLines();

//		try {
//			rw.Write("src/p1/test.txt");
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}

		
		String[] arr = null;
		try {
			arr = rw.OpenFile("src/p1/test.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		String[] p = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			String[] splitter = arr[i].split(","); // Splitta upp varje
														// element till enskilda
														// str�ngar (mellan
														// space)

			p[i] = splitter[i];
		}

		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}
}