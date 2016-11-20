package Movimentos;

import Pecas.Peca;
import Pecas.Quadrado;

public class MovePeao implements Movimento{

	@Override
	public boolean mover(Peca[][] t, int x, int y, int xPara, int yPara) {
		if(t[x][y].getCor().equals("Branco")){

			if(x==6 && x-2==xPara && y+2==yPara && (!(t[x-1][y+1] instanceof Quadrado))){
				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}
				else{
					if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

						return true;
					}
				}
			}
			if(x==6 && x-2==xPara && y-2==yPara && (!(t[x-1][y-1] instanceof Quadrado))){

				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}
				else{
					if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

						return true;
					}
				}
			}
			if(x==6 && x-2==xPara && y==yPara && t[x-1][y] instanceof Quadrado){
				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}
				else{
					return false;
				}
			}
			if(x-1==xPara && y==yPara){
				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}else{
					return false;
				}
			}
			if((x-1==xPara && y+1==yPara) || (x-1==xPara && y-1==yPara) ){

				if((!(t[xPara][yPara] instanceof Quadrado)) && (!t[xPara][yPara].getCor().equals(t[x][y].getCor()))){

					return true;
				}

				else{
					return false;
				}
			}
			else{

				return false;
			}
		}
		if(t[x][y].getCor().equals("Preto")){

			if(x==1 && x+2==xPara && y+2==yPara && (!(t[x+1][y+1] instanceof Quadrado))){
				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}
				else{
					if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

						return true;
					}
				}
			}
			if(x==1 && x+2==xPara && y-2==yPara && (!(t[x+1][y-1] instanceof Quadrado))){

				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}
				else{
					if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

						return true;
					}
				}
			}
			if(x==1 && x+2==xPara && y==yPara && t[x+1][y] instanceof Quadrado){
				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}
				else{
					return false;
				}
			}

			if(x+1==xPara && y==yPara){
				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}else{
					return false;
				}
			}
			if((x+1==xPara && y+1==yPara) || (x+1==xPara && y-1==yPara)){

				if((!(t[xPara][yPara] instanceof Quadrado)) && (!t[xPara][yPara].getCor().equals(t[x][y].getCor()))){

					return true;
				}
				if(t[xPara][yPara] instanceof Quadrado){

					return true;
				}

				else{
					return false;
				}
			}else{

				return false;
			}
		}else{

			return false;
		}
	}
}
