package n1Exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Venta {

	private ArrayList<Producte> productosCarrito=new ArrayList<Producte>();
	private double preuTotal;

	// constructor
	public Venta() {
		
	}
	
	public Venta(ArrayList<Producte> productosCarrito, double preuTotal) {
		this.productosCarrito =productosCarrito; 
		this.preuTotal = preuTotal;

	}

	// getters & setters
	public ArrayList<Producte> getProductosCarrito() {
		return productosCarrito;
	}


	public double getPreuTotal() {
		return preuTotal;
	}

	public void setPreuTotal(double preuTotal) {
		this.preuTotal = preuTotal;
	}

	
	// metodos de clase
	public Venta crearCarrito(ArrayList<Producte> productosCarrito, double preuTotal) {

		return new Venta(productosCarrito, preuTotal);

	}

	

	public void setProductoCarrito(Producte productoSeleccionado) {
		
		productosCarrito.add(productoSeleccionado);

	}

	public void calcularCarrito(Venta carrito) throws VendaBuidaException{

	
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
		

	}
}