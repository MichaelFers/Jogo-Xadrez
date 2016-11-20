package Pecas;

import java.util.ArrayList;
import java.util.List;

import Movimentos.Movimento;

public abstract class Peca{

	private int x, y;
	protected List<Movimento> movimento;
	private String cor;

	public Peca(int x, int y,String cor){
		this.x = x;
		this.y = y;
		this.cor = cor;
		this.movimento = new ArrayList();
	}

	public String toString(){
		return " ";
	}

	public int getPosicaoX(){
		return this.x;
	}
	public int getPosicaoY(){
		return this.y;
	}

	public String getCor(){
		return this.cor;
	}

	public void setPosicao(int x, int y){
		this.x = x;
		this.y = y;
	}

	

	public boolean moverPeca(Peca[][] t, int x, int y, int xPara, int yPara){
		
		for(Movimento m : movimento){
			if(m.mover(t, x, y, xPara, yPara)){
				if(t[xPara][yPara] instanceof Rei && (!t[xPara][yPara].getCor().equals(t[x][y]))){
					return true;
				}
				return true;
			}
		}

		return false;
		

	}

}
