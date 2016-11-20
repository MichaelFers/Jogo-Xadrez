package Pecas;

import Movimentos.MoveTorre;

public class Torre extends Peca{

	

	public Torre(int x, int y, String crcP) {
		super(x, y, crcP);
		super.movimento.add(new MoveTorre());
		
	}

	@Override
	public String toString() {
		
		return super.getCor().equals("Branco") ? "   ♖   ":"   ♜   ";
	}

	
}
