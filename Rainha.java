package Pecas;

import Movimentos.MoveBispo;
import Movimentos.MoveTorre;

public class Rainha extends Peca{

	

	public Rainha(int x, int y, String crcP) {
		super(x, y, crcP);
		super.movimento.add(new MoveBispo());
		super.movimento.add(new MoveTorre());
		
	}

	@Override
	public String toString() {
		
		return super.getCor().equals("Branco") ? "   ♕   ":"   ♛   ";
	}

}
