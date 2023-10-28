package n2Exercici2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Entrada {

	public static byte llegirByte(String txt) throws InputMismatchException {

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

	public static int llegirInt(String txt) throws InputMismatchException {

		System.out.println(txt);
		int num = 0;

		try {

			num = new Scanner(System.in).nextInt();
			if (num<0) {
				num=-1*num;
			}

		} catch (InputMismatchException e) {

			System.out.println("El valor introducido no es un número entero");
		}

		return num;

	}

	public static float llegirFloat(String txt) throws InputMismatchException {

		System.out.println(txt);
		float num = 0;

		try {

			num = new Scanner(System.in).nextFloat();

		} catch (InputMismatchException e) {

			System.out.println("El valor introducido no es un número float para Java");

		}

		return num;
	}

	public static double llegirDouble(String txt) throws InputMismatchException {

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

		try {

			String candidatoChar = new Scanner(System.in).next();
			
			if (candidatoChar.length() > 1) {
				entradaChar=candidatoChar.charAt(-1);
				
			} else {
				entradaChar=candidatoChar.charAt(0);
			
			}
		} catch (Exception e) {

			System.out.println("El valor introducido no es un caracter");

		}

		return entradaChar;

	}
	
	public static String llegirString(String txt) throws Exception {

		System.out.println(txt);
		String entradaString = null;

		try {

			entradaString = new Scanner(System.in).nextLine();

			if (entradaString.isEmpty()) {

				throw new Exception();

			}

		} catch (Exception e) {

			System.out.println("El valor introducido no es un String");

		}

		return entradaString;

	}

	public static boolean llegirBoolean(String txt) throws Exception {
		// si usuario pone s(true) si usuario pone n(false)

		System.out.println(txt);
		boolean siOno = false;
		char entradaBoolean = 'n';

		try {
			String candidatoBoolean = new Scanner(System.in).next();

			if (candidatoBoolean.length() > 1) {
				entradaBoolean = candidatoBoolean.charAt(-1);

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

		} catch (Exception e) {
			System.out.println("El valor introducido no lo poedemos hacer boolean");
		}
		return siOno;

	}
}