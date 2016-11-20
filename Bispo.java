package Pecas;

import java.util.ArrayList;

import Movimentos.MoveBispo;

public class Bispo extends Peca{


	public Bispo(int x, int y, String crcP) {
		super(x, y, crcP);
		super.movimento.add(new MoveBispo());
	}

	@Override
	public String toString() {
		return super.getCor().equals("Branco") ? "   ♗   ": "   ♝   ";
	}

}
