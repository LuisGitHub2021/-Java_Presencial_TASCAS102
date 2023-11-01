package n1Exercici1;

public class Producte {

	private String nom;
	private double preu;

	// constructor
	public Producte(String nom, double preu) {
		this.nom = nom;
		this.preu = preu;
	}

	public Producte() {
	
	}

	// getters & setters
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public double getPreu() {
		return this.preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}
	
	@Override
	public String toString() {
		return "Producte [nom=" + nom + ", preu=" + preu + "]";
	}
}