package n1Exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Venta {

	private ArrayList<Producte> productosCarrito;
	private double preuTotal;

	// constructor
	public Venta(ArrayList<Producte> productosCarrito, double preuTotal) {
		this.productosCarrito = productosCarrito;
		this.preuTotal = preuTotal;

	}

	// getters & setters
	public ArrayList<Producte> getProductosCarrito() {
		return productosCarrito;
	}

	// metodos de clase
	static Venta crearCarrito(ArrayList<Producte> productosCarrito, double preuTotal) {

		return new Venta(productosCarrito, preuTotal);

	}

	static void introducirProductoCarrito(Producte productoSeleccionado, Venta carrito) {

		carrito.productosCarrito.add(productoSeleccionado);

	}

	static void calcularCarrito(Venta carrito) throws VendaBuidaException {

		try {
			if (carrito.productosCarrito.size() > 0) {

				List<Producte> listaProductoSeleccionados = carrito.productosCarrito.stream()
						.collect(Collectors.toList());
				for (Producte productoSeleccionado : listaProductoSeleccionados) {
					carrito.preuTotal += productoSeleccionado.getPreu();

				}

				System.out.println("El carrito suma: " + carrito.preuTotal + " €");

			} else {

				throw new VendaBuidaException("Per fer una venda has d'afegir productes");

			}
		} catch (VendaBuidaException e) {
			System.out.println(e.getMessage());
		}

	}
}

// herramientas anexas
class VendaBuidaException extends Exception {

	public VendaBuidaException() {

	}

	public VendaBuidaException(String mensaje) {
		super(mensaje);

	}

}