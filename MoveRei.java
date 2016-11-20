package Movimentos;

import Pecas.Peca;
import Pecas.Quadrado;


public class MoveRei implements Movimento{


	@Override
	public boolean mover(Peca[][] t, int xAtual, int yAtual, int xPara, int yPara) {

		int x = xAtual;
		int y = yAtual;
		if(x-1==xPara && y-1==yPara){
			x--;
			y--;
			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x+1==xPara && y+1==yPara){
			x++;
			y++;
			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) )){
					return true;
				}

				return false;
			}
		}
		if(x-1==xPara && y+1==yPara){
			x--;
			y++;
			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x+1==xPara && y-1==yPara){
			x++;
			y--;
			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x-1==xPara && y==yPara){
			x--;

			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x+1==xPara && y==yPara){
			x++;
			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x==xPara && y-1==yPara){
			y--;
			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x==xPara && y+1==yPara){
			y++;
			if(t[x][y] instanceof Quadrado){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		else{

			return false;
		}
	}


}
