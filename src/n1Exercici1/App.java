package n1Exercici1;

import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args)  {

	
		PideDatos pideDatos = new PideDatos();
		Venta carrito=new Venta();
		

		boolean estarComprando = true;

		while (estarComprando) {

			Producte compra1=new Producte(pideDatos.pideString("Nombre del Producto"),
					pideDatos.pideDouble("Precio del Producto"));
			
			carrito.setProductoCarrito(compra1);
			

			if (pideDatos.pideString("Pulsa 0 para finalizar la compra y calcular total carrito o INTRO para seguir")
					.equals("0")) {

			
					try {
						carrito.calcularCarrito(carrito);
					} catch (VendaBuidaException e) {
						
						System.out.println(e.getMessage());
					}
				

				estarComprando = false;

			} else if (pideDatos.pideString("Pulsa 0 para vaciar el carrito o INTRO para seguir").equals("0")) {

				List<Producte> listaProductoSeleccionados = carrito.getProductosCarrito().stream()
						.collect(Collectors.toList());
				carrito.getProductosCarrito().removeAll(listaProductoSeleccionados);

				try {
				carrito.calcularCarrito(carrito);
				} catch (VendaBuidaException e) {
					
					System.out.println(e.getMessage());
				}
			}
		}
	}
}