package Pecas;

import Movimentos.MoveBispo;
import Movimentos.MovePeao;
import Movimentos.MoveTorre;

public class Peao extends Peca{

	boolean virouRainha = false;
	public Peao(int x, int y, String cor) {
		super(x, y, cor);
		super.movimento.add( new MovePeao());

	}

	@Override
	public String toString() {
		verificaPeaoVirouRainha();
		if(virouRainha){
			return super.getCor().equals("Branco") ? "   ♕   ":"   ♛   ";
		}else{
			return super.getCor().equals("Branco") ? "    ♙  ":"    ♟  ";
		}
	}
	public void verificaPeaoVirouRainha(){
		if((super.getCor().equals("Branco") && super.getPosicaoX()==0) ||
				(super.getCor().equals("Preto") && super.getPosicaoX()==7)){
			this.virouRainha = true;
			this.movimento.clear();
			this.movimento.add(new MoveTorre());
			this.movimento.add(new MoveBispo());
		}
	}

}
