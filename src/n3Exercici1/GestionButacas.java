package n3Exercici1;

import java.util.ArrayList;

public class GestionButacas {

	private ArrayList<Butaca> butacas = new ArrayList<Butaca>();

	// constructor
	public GestionButacas() {

	}

	// getters & setters
	public ArrayList<Butaca> getButacas() {
		return butacas;
	}

	// metodos clase
	public void añadirButaca(Butaca butaca, ArrayList<Butaca> butacas, int buscarButaca) throws ExcepcionButacaOcupada {

		if (buscarButaca >= 0) {
			throw new ExcepcionButacaOcupada("Butaca Ocupada");
		} else if (buscarButaca == -2) {
			throw new ExcepcionButacaOcupada("Butaca no reservada, error en los datos");

		} else {

			butacas.add(butaca);
			System.out.println("Butaca reservada");

		}
	}

	public void eliminarButaca(int numFila, int numAsiento, ArrayList<Butaca> butacas, int buscarButaca)
			throws ExcepcionButacaLibre {

		if (buscarButaca > -1) {

			System.out.println("Hemos anulado la reserva de la Fila " + butacas.get(buscarButaca).getFila()
					+ " y Asiento " + butacas.get(buscarButaca).getAsiento());
			butacas.remove(buscarButaca);
		} else if (buscarButaca == -2) {

			throw new ExcepcionButacaLibre("Butaca inexistente");
		} else {

			throw new ExcepcionButacaLibre("Butaca Libre");
		}

	}

	public int buscarButaca(int numFila, int numAsiento, String nomPersona, ArrayList<Butaca> butacas) {

		int posicion = -1;
		int posicionIguales = -1;
		int numNomPersona = 1;
		if (nomPersona.equalsIgnoreCase("0")) {
			numNomPersona = Integer.parseInt(nomPersona);
		}

		Butaca butaca = new Butaca(nomPersona, numFila, numAsiento);

		if (numFila == 0 || numAsiento == 0 || numNomPersona == 0) {
			// butaca no existente o no creada por error en los datos
			posicion = -2;

		} else if (butacas.isEmpty()) {

			// vacio, posible butaca
			posicion = -3;

		} else {

			for (int i = 0; i < butacas.size(); i++) {

				// en rango e iguales
				if (butaca.equals(butacas.get(i))) {
					posicionIguales = i;

					// en rango y diferentes
				} else {
					posicion = -3;
				}

			}
			if (posicionIguales != -1) {
				posicion = posicionIguales;
			}
		}
		return posicion;

	}

}