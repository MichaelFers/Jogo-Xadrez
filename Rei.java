package Pecas;

import Movimentos.MoveRei;

public class Rei extends Peca{

	

	public Rei(int x, int y, String cor) {
		super(x, y, cor);
		super.movimento.add(new MoveRei());
	}

	@Override
	public String toString() {
		
		return super.getCor().equals("Branco") ? "   ♔   ":"   ♚   ";
	}

}
