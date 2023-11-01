package n2Exercici1;

public class App {

	public static void main(String[] args) {

		Entrada.llegirByte("Introduce un numero byte para Java");
		Entrada.llegirInt("Introduce un numero entero");
		Entrada.llegirFloat("Introduce un numero float para Java");
		Entrada.llegirDouble("Introduce un numero double para Java");
		try {
			Entrada.llegirChar("Introduce un caracter char para Java");
		} catch (Exception e) {
			System.out.println("El valor introducido no es un caracter");
		}

		try {
			Entrada.llegirString("Introduce un string");
		} catch (Exception e) {
			System.out.println("El valor introducido no es un String");
		}

		try {
			Entrada.llegirBoolean("Introduce un valor 's' o 'n' para devolver un Boolean");
		} catch (Exception e) {
			System.out.println("El valor introducido no lo podemos hacer boolean");
		}

	}

}