package n2Exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		ArrayList<Producte> productosCarrito = new ArrayList<Producte>();
		Venta carrito = Venta.crearCarrito(productosCarrito, 0);

		boolean estarComprando = true;

		while (estarComprando) {

			Venta.introducirProductoCarrito(Producte.seleccionarProducto(PideDatos.pideString("Nombre del Producto"),
					PideDatos.pideDouble("Precio del Producto")), carrito);

			if (PideDatos.pideString("Pulsa 0 para finalizar la compra y calcular total carrito o INTRO para seguir")
					.equals("0")) {

				try {
					Venta.calcularCarrito(carrito);
				} catch (VendaBuidaException e) {

					System.out.println(e.getMessage());
				}
				estarComprando = false;

			} else if (PideDatos.pideString("Pulsa 0 para vaciar el carrito o INTRO para seguir").equals("0")) {

				List<Producte> listaProductoSeleccionados = carrito.getProductosCarrito().stream()
						.collect(Collectors.toList());
				carrito.getProductosCarrito().removeAll(listaProductoSeleccionados);
				try {
					Venta.calcularCarrito(carrito);
				} catch (VendaBuidaException e) {
					System.out.println(e.getMessage());

				}

			}
		}
	}

}