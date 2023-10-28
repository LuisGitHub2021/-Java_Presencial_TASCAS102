package n2Exercici3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

// metodos interaccion con la aplicacion
public class Cine {

	private static int numFilas;
	private static int numAsientos;
	private static GestionButacas gestionButacas;

	// constructor
	public Cine() {

		gestionButacas = new GestionButacas();
		numFilas = solicitarDatosIniciales("Número de Filas");
		numAsientos = solicitarDatosIniciales("Número de Asientos");

	}

	// getters & setters
	public static int getNumFilas() {
		return numFilas;
	}

	public static int getNumAsientos() {
		return numAsientos;
	}

	// metodos de clase
	public void iniciar() throws InputMismatchException, Exception, ExcepcionFilaIncorrecta, ExcepcionAsientoIncorrecto,
			ExcepcionNombrePersonaIncorrecto, ExcepcionButacaLibre {

		System.out.println("\nMENU\n1. Mostrar butacas reservadas\n2. Mostrar butacas reservadas por persona"
				+ "\n3. Reservar una butaca\n4. Anular una butaca\n5. Anular todas las reservas de una persona\n0. Salir");

		int opcion = Entrada.llegirInt("Numero de la OPCION que desea realizar");

		while (opcion > 0) {

			switch (opcion) {

			case 1:
				// MOSTRAR BUTACAS RESERVADAS
				mostarButacas();
				break;
			case 2:
				// MOSTRAR BUTACAS RESERVADAS POR PERSONA
				mostrarButacasPersona();
				break;
			case 3:
				// RESERVAR UNA BUTACA
				reservaButaca();
				break;
			case 4:
				// ANULAR UNA BUTACA
				anularReserva();
				break;
			case 5:
				// ANULAR TODAS LAS RESERVAS DE UNA PERSONA
				anularReservaPersona();
				break;
			default:
				System.out.println("Opción no válida, vuelve a intentarlo");
				System.out.println("\nMENU\n1. Mostrar butacas reservadas\n2. Mostrar butacas reservadas por persona"
						+ "\n3. Reservar una butaca\n4. Anular una butaca\n5. Anular todas las reservas de una persona\n0. Salir");
				opcion = Entrada.llegirInt("Numero de la OPCION que desea realizar");

			}
			System.out.println("\nMENU\n1. Mostrar butacas reservadas\n2. Mostrar butacas reservadas por persona"
					+ "\n3. Reservar una butaca\n4. Anular una butaca\n5. Anular todas las reservas de una persona\n0. Salir");
			opcion = Entrada.llegirInt("Numero de la OPCION que desea realizar");

		}

		System.out.println("Hasta la próxima. Gracias!");

	}

	static void mostarButacas() {
		// todas las reservadas

		if (gestionButacas.getButacas().isEmpty()) {
			System.out.println("No hay butacas todavía");
		} else {

			ArrayList<Butaca> listaPosiblesButacas = crearSala();
			ArrayList<Butaca> listaButacasReservadas = (ArrayList<Butaca>) gestionButacas.getButacas().clone();

			ordenaByFila(listaButacasReservadas);

			for (int i = 0; i < listaPosiblesButacas.size(); i++) {
				if (listaPosiblesButacas.get(i).getAsiento() == 1) {
					System.out.println("");
				}
				if (listaButacasReservadas.isEmpty()) {
					Butaca butaca = new Butaca(null, 0, 0);
					listaButacasReservadas.add(butaca);
				}

				Butaca butaca = listaButacasReservadas.get(0);
				if (listaPosiblesButacas.get(i).equals(butaca)) {
					System.out.print("\tR");
					listaButacasReservadas.remove(0);

				} else {
					System.out.print("\t*");
				}
			}

		}
	}

	static void mostrarButacasPersona() throws Exception {
		// pide nombre persona y muestra todas las butacas de esa persona
		String nomPersonaCandidato = Entrada.llegirString("Nombre reserva a buscar");

		int contador = 0;

		if (gestionButacas.getButacas().isEmpty()) {
			System.out.println("No hay butacas todavía");
		} else {

			ArrayList<Butaca> listaPosiblesButacas = crearSala();
			ArrayList<Butaca> listaButacasReservadasPersona = new ArrayList<Butaca>();

			for (Butaca butaca : gestionButacas.getButacas()) {
				if (butaca.getNomPersona().equalsIgnoreCase(nomPersonaCandidato)) {
					listaButacasReservadasPersona.add(butaca);
					contador++;
				}
			}

			ArrayList<Butaca> listaButacasReservadasPersonaMostrar = (ArrayList<Butaca>) listaButacasReservadasPersona
					.clone();
			ordenaByFila(listaButacasReservadasPersonaMostrar);

			if (contador == 0) {
				System.out.println("No tenemos reservas con este nombre");

			} else if (contador > 0) {
				System.out.println("Estas son las reservas con este nombre");
			}

			for (int i = 0; i < listaPosiblesButacas.size(); i++) {
				if (listaPosiblesButacas.get(i).getAsiento() == 1) {
					System.out.println("");
				}

				if (listaButacasReservadasPersonaMostrar.isEmpty()) {
					Butaca butaca = new Butaca(null, 0, 0);
					listaButacasReservadasPersonaMostrar.add(butaca);
				}

				Butaca butaca = listaButacasReservadasPersonaMostrar.get(0);

				if (listaPosiblesButacas.get(i).equals(butaca)) {
					System.out.print("\tR " + butaca.getNomPersona());
					listaButacasReservadasPersonaMostrar.remove(0);

				} else {
					System.out.print("\t*");
				}
			}

		}
	}

	static void reservaButaca() throws InputMismatchException, ExcepcionFilaIncorrecta, ExcepcionAsientoIncorrecto,
			Exception, ExcepcionNombrePersonaIncorrecto {
		// pide numfila y llama a INTRODUCIR FILA //pide numAsiento y llama a INTRODUCIR
		// ASIENTO
		// pide nombre person y llama a INTRODUCIR PERSONA // RESERVA LA BUTACA

		String nomPersona = introducirNombrePersona("Nombre para la reserva");
		int fila = introducirFila("Fila para la reserva");
		int asiento = introducirAsiento("Asiento para la reserva");

		Butaca butaca = new Butaca(nomPersona, fila, asiento);

		gestionButacas.añadirButaca(butaca, gestionButacas.getButacas(),
				gestionButacas.buscarButaca(fila, asiento, nomPersona, gestionButacas.getButacas()));

	}

	static void anularReserva() throws Exception, ExcepcionNombrePersonaIncorrecto, InputMismatchException,
			ExcepcionFilaIncorrecta, ExcepcionAsientoIncorrecto, ExcepcionButacaLibre {
		// pide numfila INTRODUCIR FILA pide numAsiento INTRODUCIR ASIENTO
		// ELIMINA RESERVA DE LA BUTACA

		String nomPersona = introducirNombrePersona("Nombre para la reserva");
		int fila = introducirFila("Fila de la reserva anular");
		int asiento = introducirAsiento("Asiento de la reserva anular");

		gestionButacas.eliminarButaca(fila, asiento, gestionButacas.getButacas(),
				gestionButacas.buscarButaca(fila, asiento, nomPersona, gestionButacas.getButacas()));

	}

	static void anularReservaPersona() throws ExcepcionNombrePersonaIncorrecto, Exception {
		// pide nombre persona INTRODUCIR PERSONA
		// ELIMINA BUTACA RESERVA PERSONA

		String nomPersona = introducirNombrePersona("Nombre de la reserva");
		int contador = 0;

		for (int i = 0; i < gestionButacas.getButacas().size(); i++) {

			if (gestionButacas.getButacas().get(i).getNomPersona().equalsIgnoreCase(nomPersona)) {

				gestionButacas.getButacas().remove(i);
				System.out.println("Ok, queda anulada");
				i--;
				contador++;

			}

		}

		if (contador == 0) {
			System.out.println("No hemos encontrado ninguna reserva con este nombre. Gracias!");
		} else {
			System.out.println("Han quedado anuladas todas las reservas de " + nomPersona);
		}

	}

	static String introducirNombrePersona(String txt) throws Exception, ExcepcionNombrePersonaIncorrecto {
		// solicita nombre persona
		// comprueba que no tenga numeros. Retorna si es correcto
		String nomPersona = Entrada.llegirString(txt);

		try {
			for (int i = 0; i < nomPersona.length(); i++) {
				char a = nomPersona.charAt(i);
				if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7'
						|| a == '8' || a == '9') {
					nomPersona = "0";
					throw new ExcepcionNombrePersonaIncorrecto("Nombre de Persona Incorrecto contiene números");
				}
			}

		} catch (ExcepcionNombrePersonaIncorrecto e) {
			System.out.println(e.getMessage());
		}
		return nomPersona;
	}

	static int solicitarDatosIniciales(String txt) throws InputMismatchException {

		int num = Entrada.llegirInt(txt);

		return num;
	}

	static int introducirFila(String txt) throws InputMismatchException, ExcepcionFilaIncorrecta {
		// si esta entre el 1 y el numero de filas totales lo devuelve
		// si no retorna ExcepcionFilaIncorrecta
		int fila = Entrada.llegirInt(txt);

		try {

			if (fila > numFilas || fila <= 0) {
				fila = 0;
				throw new ExcepcionFilaIncorrecta("Fila incorecta");

			}
		} catch (ExcepcionFilaIncorrecta e) {
			System.out.println(e.getMessage());
		}

		return fila;

	}

	static int introducirAsiento(String txt) throws InputMismatchException, ExcepcionAsientoIncorrecto {
		// si esta enttre el 1 y el numero de asientos totales lo devuelve
		// si no retorna ExcepcionAsientoIncorrecto

		int asiento = Entrada.llegirInt(txt);
		try {
			if (asiento > numAsientos || asiento <= 0) {
				asiento = 0;
				throw new ExcepcionAsientoIncorrecto("Asiento incorecto");

			}
		} catch (ExcepcionAsientoIncorrecto e) {
			System.out.println(e.getMessage());
		}

		return asiento;
	}

	static void ordenaByFila(List<Butaca> butaca) {
		// Comparator to sort by age ascending
		Comparator<Butaca> filaComparator = (Butaca s1, Butaca s2) -> {
			return s1.getFila() - s2.getFila();
		};
		butaca.sort(filaComparator);
	}

	static ArrayList<Butaca> crearSala() {

		ArrayList<Butaca> listaPosiblesButacas = new ArrayList<Butaca>();

		for (int i = 1; i <= numFilas; i++) {
			for (int j = 1; j <= numAsientos; j++) {
				Butaca butaca = new Butaca(null, i, j);
				listaPosiblesButacas.add(butaca);
			}
		}
		return listaPosiblesButacas;
	}

}

class ExcepcionNombrePersonaIncorrecto extends Exception {

	public ExcepcionNombrePersonaIncorrecto() {

	}

	public ExcepcionNombrePersonaIncorrecto(String mensaje) {
		super(mensaje);

	}

}

class ExcepcionFilaIncorrecta extends Exception {

	public ExcepcionFilaIncorrecta() {

	}

	public ExcepcionFilaIncorrecta(String mensaje) {
		super(mensaje);

	}

}

class ExcepcionAsientoIncorrecto extends Exception {

	public ExcepcionAsientoIncorrecto() {

	}

	public ExcepcionAsientoIncorrecto(String mensaje) {
		super(mensaje);

	}

}