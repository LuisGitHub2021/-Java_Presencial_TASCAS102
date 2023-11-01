package n2Exercici1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Entrada {

	public static byte llegirByte(String txt) {

		System.out.println(txt);
		byte num = 0;

		try {

			num = new Scanner(System.in).nextByte();

		} catch (InputMismatchException e) {
			System.out.println(
					"El valor introducido no es un Byte para lenguaje Java. Debe estar en -128 y 127 ambos incluidos");
		}

		return num;

	}

	public static int llegirInt(String txt) {

		System.out.println(txt);
		int num = 0;

		try {

			num = new Scanner(System.in).nextInt();
			if (num < 0) {
				num = -1 * num;
			}

		} catch (InputMismatchException e) {

			System.out.println("El valor introducido no es un número entero");
		}

		return num;

	}

	public static float llegirFloat(String txt) {

		System.out.println(txt);
		float num = 0;

		try {

			num = new Scanner(System.in).nextFloat();

		} catch (InputMismatchException e) {

			System.out.println("El valor introducido no es un número float para Java");

		}

		return num;
	}

	public static double llegirDouble(String txt) {

		System.out.println(txt);
		double num = 0;

		try {

			num = new Scanner(System.in).nextDouble();

		} catch (InputMismatchException e) {

			System.out.println("El valor introducido no es un número double para Java");

		}
		return num;
	}

	public static char llegirChar(String txt) throws Exception {

		System.out.println(txt);
		char entradaChar = '0';

		String candidatoChar = new Scanner(System.in).next();

		if (candidatoChar.length() > 1) {
			throw new Exception();
		} else {
			entradaChar = candidatoChar.charAt(0);
		}
		return entradaChar;

	}

	public static String llegirString(String txt) throws Exception {

		System.out.println(txt);
		String entradaString = null;

		entradaString = new Scanner(System.in).nextLine();

		if (entradaString.isEmpty()) {

			throw new Exception();

		}

		return entradaString;

	}

	public static boolean llegirBoolean(String txt) throws Exception {
		// si usuario pone s(true) si usuario pone n(false)

		System.out.println(txt);
		boolean siOno = false;
		char entradaBoolean = 'n';

		String candidatoBoolean = new Scanner(System.in).next();

		if (candidatoBoolean.length() > 1) {
			throw new Exception();

		} else {
			entradaBoolean = candidatoBoolean.charAt(0);
			if (entradaBoolean == 's') {
				siOno = true;
			} else if (entradaBoolean == 'n') {
				siOno = false;
			} else {
				throw new Exception();
			}
		}

		return siOno;

	}
}