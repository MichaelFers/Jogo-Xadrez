package Pecas;


import Movimentos.MoveCavalo;

public class Cavalo extends Peca{

	public Cavalo(int x, int y, String cor){
		super(x, y, cor);
		super.movimento.add(new MoveCavalo()); 
	}

	@Override
	public String toString() {
		//return " \u2657 ";
		return super.getCor().equals("Branco") ? "   ♘   ": "   ♞   ";
	}

	

}
