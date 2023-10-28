package n1Exercici1;

public class Producte {

	private String nom;
	private double preu;

	// constructor
	public Producte(String nom, double preu) {
		this.nom = nom;
		this.preu = preu;
	}

	// getters & setters
	public double getPreu() {
		return preu;
	}

	// metodos de clase
	static Producte seleccionarProducto(String nom, double preu) {

		return new Producte(nom, preu);

	}

}