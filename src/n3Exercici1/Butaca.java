package n3Exercici1;

import java.util.Objects;

public class Butaca {

	private int fila;
	private int asiento;
	private String nomPersona;

	// constructor
	public Butaca(String nomPersona, int fila, int asiento) {
		this.fila = fila;
		this.asiento = asiento;
		this.nomPersona = nomPersona;

	}

	// getters & setters
	public int getFila() {
		return fila;
	}

	public int getAsiento() {
		return asiento;
	}

	public String getNomPersona() {
		return nomPersona;
	}

	// sobrescritos
	@Override
	public int hashCode() {
		return Objects.hash(asiento, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Butaca other = (Butaca) obj;
		return asiento == other.asiento && fila == other.fila;
	}

	@Override
	public String toString() {
		return "Butaca [Fila: " + fila + ", Asiento: " + asiento + ", Persona: " + nomPersona + "]";
	}

}