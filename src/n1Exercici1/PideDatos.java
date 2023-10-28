package n1Exercici1;

import java.util.Scanner;

public class PideDatos {

	// PEDIR DATOS
	static int pideInt(String txt) {

		Scanner sc = new Scanner(System.in);
		System.out.println(txt);
		int num = sc.nextInt();

		return num;
	}

	static double pideDouble(String txt) {

		Scanner sc = new Scanner(System.in);
		System.out.println(txt);
		double numD = sc.nextDouble();

		return numD;
	}

	static String pideString(String txt) {

		Scanner sc = new Scanner(System.in);
		System.out.println(txt);

		String str = sc.nextLine();

		return str;

	}

	// MENSAJES
	static void pideMensaje(String txt) {
		System.out.println(txt);
	}

}
