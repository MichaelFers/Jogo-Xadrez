package Movimentos;

import Pecas.Peca;
import Pecas.*;

public class MoveCavalo implements Movimento{

	@Override
	public boolean mover(Peca[][] t, int xAtual, int yAtual, int xPara, int yPara) {
		int x = xAtual;
		int y = yAtual;
		if(x+2==xPara && y-1==yPara){
			if(t[xPara][yPara] instanceof Quadrado){
				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}	
		if(x+2==xPara && y+1==yPara){
			if(t[xPara][yPara] instanceof Quadrado){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x-2==xPara && y+1==yPara){
			if(t[xPara][yPara] instanceof Quadrado){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x-2==xPara && y-1==yPara){
			if(t[xPara][yPara] instanceof Quadrado){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x+1==xPara && y+2==yPara){
			if(t[xPara][yPara] instanceof Quadrado){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}	
		if(x-1==xPara && y+2==yPara){
			if(t[xPara][yPara] instanceof Quadrado){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x-1==xPara && y-2==yPara){
			if(t[xPara][yPara] instanceof Quadrado){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x+1==xPara && y-2==yPara){
			if(t[xPara][yPara] instanceof Quadrado){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}else{

			return false;
		}
	}
}
