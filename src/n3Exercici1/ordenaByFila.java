package n3Exercici1;

import java.util.Comparator;

public class ordenaByFila implements Comparator<Butaca> {

	@Override
	public int compare(Butaca b1, Butaca b2) {
		return b1.getFila() - b2.getFila();
	}
}