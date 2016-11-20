package Movimentos;

import Pecas.Peca;

public interface Movimento {

	public abstract boolean mover(Peca[][] t, int x, int y, int xPara, int yPara);
	
}
