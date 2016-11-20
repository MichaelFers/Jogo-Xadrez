package Jogador;
import java.util.ArrayList;
import java.util.List;
import Pecas.*;


public class Jogador {

	private List<Peca> pecas;
	private List<Peca> pecasMorta;
	private String nome;
	private boolean vez;

	public Jogador(String nome){
		this.pecas = new ArrayList();
		this.pecasMorta = new ArrayList();
		this.nome = nome;
		this.vez = true;
	}

	public void addPeca(Peca p){
		this.pecas.add(p);
	}
	public void removePeca(Peca p){
		pecasMorta.add(p);
		pecas.remove(p);
	}
	
	public void removePeca(int x, int y){
		for(Peca a: this.pecas){
			if(a.getPosicaoX()== x && a.getPosicaoY()==y){
				pecasMorta.add(a);
				pecas.remove(a);
				break;
			}
		}
	}

	public List<Peca> getPecasMortas(){
		return this.pecasMorta;
	}

	public List<Peca> getPecas(){
		return this.pecas;
	}

	public String getNome(){
		return this.nome;
	}

	public void passaVez(){
		if(this.vez){
			this.vez = false;
		}else{
			this.vez = true;
		}
	}

	public boolean getVez(){
		return this.vez;
	}
	public Peca getPeca(int x, int y){
		for(Peca p: this.pecas){
			if(p.getPosicaoX() == x && p.getPosicaoY() == y){
				return p;
			}
		}
		return null;
	}

	public boolean verificaSeExistePeca(int x, int y){
		
		for(Peca p: this.pecas){
			if(p.getPosicaoX() == x && p.getPosicaoY() == y){
				return true;
			}
		}
		
		return false;
	}
	public Peca getRei(){
		
		for(Peca p: this.pecas){
			if(p instanceof Rei){
				return p;
			}
		}
		return null;
	}
	

}
