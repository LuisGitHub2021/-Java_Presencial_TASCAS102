package n1Exercici1;

import java.util.Scanner;

public class PideDatos {
	
	
	// PEDIR DATOS
	public int pideInt(String txt) {

		Scanner sc = new Scanner(System.in);
		System.out.println(txt);
		int num = sc.nextInt();

		return num;
	}

	public double pideDouble(String txt) {

		Scanner sc = new Scanner(System.in);
		System.out.println(txt);
		double numD = sc.nextDouble();

		return numD;
	}
	public String pideString(String txt) {

		Scanner sc = new Scanner(System.in);
		System.out.println(txt);

		String str = sc.nextLine();

		return str;

	}

	// MENSAJES
	public void pideMensaje(String txt) {
		System.out.println(txt);
	}

}
