package Pecas;

public class Quadrado extends Peca{ 

	public Quadrado(int x, int y, String cor) {
		super(x, y, cor);
		super.movimento = null;
	}

	@Override
	public String toString() {
		String a = super.getPosicaoY() >4 ? "  ": " "; 
		return super.getCor().equals("Branco") ? "          " : "     ."+a+"   ";
	}

}
