package Movimentos;

import Pecas.Peca;
import Pecas.Quadrado;

public class MoveBispo implements Movimento{

	@Override
	public boolean mover(Peca[][] t, int xAtual, int yAtual, int xPara, int yPara) {
		int x = xAtual;
		int y = yAtual;

		if(xAtual<xPara && yAtual<yPara){

			while(true){
				y++;
				x++;
				if(t[x][y] instanceof Quadrado){
					if(y==yPara && x==xPara){
						
						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && (y==yPara && x==xPara))){

						return true;
					}

					return false;
				}

			}
		}
		if(xAtual<xPara && yAtual>yPara){

			while(true){
				y--;
				x++;
				if(y>=0 && t[x][y] instanceof Quadrado){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && (y==yPara && x==xPara))){

						return true;
					}

					return false;
				}

			}
		}
		if(xAtual>xPara && yAtual<yPara){

			while(true){
				y++;
				x--;
				if(t[x][y] instanceof Quadrado){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else {
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && y==yPara && x==xPara)){

						return true;
					}else{

						return false;
					}

				}
			}
		}
		if(xAtual>xPara && yAtual>yPara){

			while(true){
				y--;
				x--;
				if(t[x][y] instanceof Quadrado){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && (y==yPara && x==xPara))){

						return true;
					}else{

						return false;
					}

				}
			}
		}else{

			return false;
		}
	}
}



