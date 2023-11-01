package n3Exercici1;

import java.util.ArrayList;
import java.util.Collections;

// metodos interaccion con la aplicacion
public class Cine {

	// static se queda en la clase y en conseuencia aplicará en todas las instancias
	private int numFilas;
	private int numAsientos;
	private GestionButacas gestionButacas;

	// constructor
	public Cine() {

		gestionButacas = new GestionButacas();
		numFilas = solicitarDatosIniciales("Número de Filas");
		numAsientos = solicitarDatosIniciales("Número de Asientos");

	}

	// getters & setters
	public int getNumFilas() {
		return numFilas;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public GestionButacas getGestionButacas() {
		return gestionButacas;
	}

	// metodos de clase
	public void iniciar() throws Exception, ExcepcionFilaIncorrecta, ExcepcionAsientoIncorrecto,
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

	public void mostarButacas() {
		// todas las reservadas

		if (gestionButacas.getButacas().isEmpty()) {
			System.out.println("No hay butacas todavía");
		} else {

			ArrayList<Butaca> listaPosiblesButacas = crearSala();
			ArrayList<Butaca> listaButacasReservadas = (ArrayList<Butaca>) gestionButacas.getButacas().clone();

			Collections.sort(listaButacasReservadas, new ordenaByFila());

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

	public void mostrarButacasPersona() throws Exception {
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
			Collections.sort(listaButacasReservadasPersonaMostrar, new ordenaByFila());

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

	public void reservaButaca() {
		// pide numfila y llama a INTRODUCIR FILA //pide numAsiento y llama a INTRODUCIR
		// ASIENTO
		// pide nombre person y llama a INTRODUCIR PERSONA // RESERVA LA BUTACA

		try {
			String nomPersona = introducirNombrePersona("Nombre para la reserva");
			int fila = introducirFila("Fila para la reserva");
			int asiento = introducirAsiento("Asiento para la reserva");

			Butaca butaca = new Butaca(nomPersona, fila, asiento);

			gestionButacas.añadirButaca(butaca, gestionButacas.getButacas(),
					gestionButacas.buscarButaca(fila, asiento, nomPersona, gestionButacas.getButacas()));

		} catch (ExcepcionNombrePersonaIncorrecto e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionFilaIncorrecta e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionAsientoIncorrecto e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionButacaOcupada e) {
			System.out.println(e.getMessage());
		}

	}

	public void anularReserva() {
		// pide numfila INTRODUCIR FILA pide numAsiento INTRODUCIR ASIENTO
		// ELIMINA RESERVA DE LA BUTACA

		try {
			String nomPersona = introducirNombrePersona("Nombre para la reserva");
			int fila = introducirFila("Fila de la reserva anular");
			int asiento = introducirAsiento("Asiento de la reserva anular");

			gestionButacas.eliminarButaca(fila, asiento, gestionButacas.getButacas(),
					gestionButacas.buscarButaca(fila, asiento, nomPersona, gestionButacas.getButacas()));

		} catch (ExcepcionNombrePersonaIncorrecto e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionFilaIncorrecta e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionAsientoIncorrecto e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionButacaLibre e) {
			System.out.println(e.getMessage());
		}
	}

	public void anularReservaPersona() {
		// pide nombre persona INTRODUCIR PERSONA
		// ELIMINA BUTACA RESERVA PERSONA

		try {
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
		} catch (ExcepcionNombrePersonaIncorrecto e) {
			System.out.println(e.getMessage());
		}
	}

	public String introducirNombrePersona(String txt) throws ExcepcionNombrePersonaIncorrecto {
		// solicita nombre persona
		// comprueba que no tenga numeros. Retorna si es correcto
		String nomPersona = Entrada.llegirString(txt);

		for (int i = 0; i < nomPersona.length(); i++) {
			char a = nomPersona.charAt(i);
			if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8'
					|| a == '9') {
				nomPersona = "0";
				throw new ExcepcionNombrePersonaIncorrecto("Nombre de Persona Incorrecto contiene números");
			}
		}
		return nomPersona;
	}

	public int solicitarDatosIniciales(String txt) {

		int num = Entrada.llegirInt(txt);

		return num;
	}

	public int introducirFila(String txt) throws ExcepcionFilaIncorrecta {
		// si esta entre el 1 y el numero de filas totales lo devuelve
		// si no retorna ExcepcionFilaIncorrecta
		int fila = Entrada.llegirInt(txt);

		if (fila > numFilas || fila <= 0) {
			fila = 0;
			throw new ExcepcionFilaIncorrecta("Fila incorecta");

		}

		return fila;

	}

	public int introducirAsiento(String txt) throws ExcepcionAsientoIncorrecto {
		// si esta enttre el 1 y el numero de asientos totales lo devuelve
		// si no retorna ExcepcionAsientoIncorrecto

		int asiento = Entrada.llegirInt(txt);

		if (asiento > numAsientos || asiento <= 0) {
			asiento = 0;
			throw new ExcepcionAsientoIncorrecto("Asiento incorecto");

		}

		return asiento;
	}

	public ArrayList<Butaca> crearSala() {

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