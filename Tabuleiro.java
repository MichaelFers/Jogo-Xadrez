package Tabuleiro;

import java.util.List;

import javax.swing.JOptionPane;

import Excecoes.MovimentoIndefinidoException;
import Excecoes.MovimentoNaoPermitidoException;
import Excecoes.PecaNaoEncontradaException;
import Jogador.Jogador;
import Pecas.*;

public class Tabuleiro {

	private static Peca[][] tabuleiro;
	private Jogador p1;
	private Jogador p2;
	private boolean xeque;
	
	public Tabuleiro(Jogador p1, Jogador p2){
		this.p1 = p1;
		this.p2 = p2;
		tabuleiro = new Peca[8][8];
		xeque = false;
		inicializaTabuleiro();
	}
	
	public Tabuleiro(){}
	
	public void passarVez(){
		if(p1.getNome().equals(this.vezJogador())){
			p1.passaVez();
		}else{
			p1.passaVez();
			p2.passaVez();
		}
	}
	
	public Peca[][] getTabuleiro(){
		return tabuleiro;
	}
	
	public boolean getXeque(){
		return this.xeque;
	}
	
	public String getNomeJogador1(){
		return this.p1.getNome();
	}
	public String getNomeJogador2(){
		return this.p2.getNome();
	}
	
	private void inicializaTabuleiro(){
		
		//player 2
		
		for(int x=0; x<tabuleiro[1].length; x++){
			p2.addPeca(new Peao(1,x,"Preto"));
		}
		
		p2.addPeca(new Torre(0,0,"Preto"));
		p2.addPeca(new Cavalo(0,1,"Preto"));
		p2.addPeca(new Bispo(0,2,"Preto"));
		p2.addPeca(new Rainha(0,3,"Preto"));
		p2.addPeca(new Rei(0,4,"Preto"));
		p2.addPeca(new Bispo(0,5,"Preto"));
		p2.addPeca(new Cavalo(0,6,"Preto"));
		p2.addPeca(new Torre(0,7,"Preto"));
		
		for(Peca p: p2.getPecas()){
			tabuleiro[p.getPosicaoX()][p.getPosicaoY()] = p;
		}
		
		//player 1
		
		for(int x=0; x<tabuleiro[6].length; x++){
			p1.addPeca(new Peao(6,x,"Branco"));
		}
		
		p1.addPeca(new Torre(7,0,"Branco"));
		p1.addPeca(new Cavalo(7,1,"Branco"));
		p1.addPeca(new Bispo(7,2,"Branco"));
		p1.addPeca(new Rainha(7,3,"Branco"));
		p1.addPeca(new Rei(7,4,"Branco"));
		p1.addPeca(new Bispo(7,5,"Branco"));
		p1.addPeca(new Cavalo(7,6,"Branco"));
		p1.addPeca(new Torre(7,7,"Branco"));

		for(Peca p: p1.getPecas()){
			tabuleiro[p.getPosicaoX()][p.getPosicaoY()] = p;
		}
		
		preencheTabuleiro();
		
	}
	
	
	private void preencheTabuleiro(){

		for(int x=0; x< tabuleiro.length; x++){
		
			for(int y=0; y<tabuleiro[x].length;y++){
				
				if(tabuleiro[x][y]==null){
					
					tabuleiro[x][y] = tabuleiroPecaQuadrado(x, y);			
				}
			}
		}
	}
	
	public String verTabuleiroJOptionPane(){
		
		String ta = "";
		for(int x=0; x< tabuleiro.length; x++){
			ta+= x==0 ? "         0         1         2         3         4         5         6         7                 ":"";
			ta += x==0 ? "\n    _______________________________________\n":"";
			ta+=x+"  ";
			for(int y=0; y<tabuleiro[x].length;y++){
				
				int xx = tabuleiro[x][y].getPosicaoX();
				int yy = tabuleiro[x][y].getPosicaoY();
				tabuleiro[xx][yy] = tabuleiro[x][y];
				
				String b = y == tabuleiro[x].length-1 ? "|": "";
				ta+=("|"+tabuleiro[x][y]+b);
				
			}
			
			ta+="\n    | ____| ____| ____| ____| ____| ____| ____| ____|\n";
			
		}
		
		return ta;
	}
	
	public String vezJogador(){

		if(p1.getVez()){
			return p1.getNome();
		}
		else{
			return p2.getNome();
		}		
	}
	
	public void Movimento(String nome,String ne) throws MovimentoIndefinidoException, MovimentoNaoPermitidoException, PecaNaoEncontradaException{
		
		String[] spl;
		int xAtual;
		int yAtual;
		int x;
		int y;
		
		try{
		
		spl = ne.split(" ");

		xAtual = Integer.parseInt(spl[0].substring(0, 1));
		yAtual = Integer.parseInt(spl[0].substring(1, 2));
	
		x = Integer.parseInt(spl[1].substring(0, 1));
		y = Integer.parseInt(spl[1].substring(1, 2));
		
		}catch(NullPointerException | NumberFormatException | StringIndexOutOfBoundsException e){
			throw new MovimentoIndefinidoException("Erro: Movimento indefinido.");
		}
		if(spl.length<2){
			throw new MovimentoIndefinidoException("Erro: argumento insuficiente.");
		}else{
		
			if(p1.getNome().equals(nome) && p1.verificaSeExistePeca(xAtual, yAtual)){
				
				Peca pec = p1.getPeca(xAtual, yAtual);
				
				if(pec.moverPeca(tabuleiro, xAtual, yAtual, x, y)){
					if(p2.getPeca(x, y) != null){
						p2.removePeca(x, y);
					}
					pec.setPosicao(x, y);
					
					this.verTabuleiroJOptionPane();
					this.verificaXeque(nome);
					
					p1.passaVez();
				}else{
					throw new MovimentoNaoPermitidoException("Erro: Movimento não permitido.");
				}

			}else if(p2.getNome().equals(nome) && p2.verificaSeExistePeca(xAtual, yAtual)){
				
				Peca pec = p2.getPeca(xAtual, yAtual);
				
				if(pec.moverPeca(tabuleiro, xAtual, yAtual, x, y)){
					if(p1.getPeca(x, y) != null){
						p1.removePeca(x, y);
					}
					pec.setPosicao(x, y);
					
					this.verTabuleiroJOptionPane();
					this.verificaXeque(nome);
					
					p1.passaVez();
					p2.passaVez();
				}else{
					throw new MovimentoNaoPermitidoException("Erro: Movimento não permitido.");
				}

			}else{
				throw new MovimentoNaoPermitidoException("Erro: Movimento não permitido");
			}
			
			tabuleiro[xAtual][yAtual] = tabuleiroPecaQuadrado(xAtual, yAtual);
		}
	}
	public Peca tabuleiroPecaQuadrado(int xx, int yy){
		
		for(int x=0; x< tabuleiro.length; x++){
			
			for(int y=0; y<tabuleiro[x].length;y++){
				
				if(tabuleiro[x][y]==null || (x==xx && y==yy)){
					
					//Coluna 1
					if(x==0 && y==0)
						return new Quadrado(x, y, "Preto");
					if(x==0 && y==1)
						return  new Quadrado(x, y,"Branco");
					if(x==0 && y==2)
						return   new Quadrado(x, y, "Preto");
					if(x==0 && y==3)
						return   new Quadrado(x, y,"Branco");
					if(x==0 && y==4)
						return  new Quadrado(x, y, "Preto");
					if(x==0 && y==5)
						return new Quadrado(x, y,"Branco");
					if(x==0 && y==6)
						return new Quadrado(x, y, "Preto");
					if(x==0 && y==7)
						return new Quadrado(x, y,"Branco");
					//Coluna 2
					
					if(x==1 && y==0)
						return new Quadrado(x, y, "Branco");
					if(x==1 && y==1)
						return  new Quadrado(x, y, "Preto");
					if(x==1 && y==2)
						return  new Quadrado(x, y, "Branco");
					if(x==1 && y==3)
						return  new Quadrado(x, y, "Preto");
					if(x==1 && y==4)
						return  new Quadrado(x, y,"Branco");
					if(x==1 && y==5)
						return  new Quadrado(x, y, "Preto");
					if(x==1 && y==6)
						return new Quadrado(x, y, "Branco");
					if(x==1 && y==7)
						return  new Quadrado(x, y, "Preto");
					//Coluna 3
					
					if(x==2 && y==0)
						return new Quadrado(x, y, "Preto");
					if(x==2 && y==1)
						return new Quadrado(x, y,"Branco");
					if(x==2 && y==2)
						return new Quadrado(x, y, "Preto");
					if(x==2 && y==3)
						return new Quadrado(x, y,"Branco");
					if(x==2 && y==4)
						return new Quadrado(x, y, "Preto");
					if(x==2 && y==5)
						return new Quadrado(x, y,"Branco");
					if(x==2 && y==6)
						return new Quadrado(x, y, "Preto");
					if(x==2 && y==7)
						return new Quadrado(x, y,"Branco");
					
					//Coluna 4
					
					if(x==3 && y==0)
						return new Quadrado(x, y, "Branco");
					if(x==3 && y==1)
						return new Quadrado(x, y, "Preto");
					if(x==3 && y==2)
						return new Quadrado(x, y, "Branco");
					if(x==3 && y==3)
						return new Quadrado(x, y, "Preto");
					if(x==3 && y==4)
						return new Quadrado(x, y,"Branco");
					if(x==3 && y==5)
						return new Quadrado(x, y, "Preto");
					if(x==3 && y==6)
						return new Quadrado(x, y, "Branco");
					if(x==3 && y==7)
						return new Quadrado(x, y, "Preto");
					
					//Coluna 5
					
					if(x==4 && y==0)
						return new Quadrado(x, y, "Preto");
					if(x==4 && y==1)
						return new Quadrado(x, y,"Branco");
					if(x==4 && y==2)
						return new Quadrado(x, y, "Preto");
					if(x==4 && y==3)
						return new Quadrado(x, y,"Branco");
					if(x==4 && y==4)
						return new Quadrado(x, y, "Preto");
					if(x==4 && y==5)
						return new Quadrado(x, y,"Branco");
					if(x==4 && y==6)
						return new Quadrado(x, y, "Preto");
					if(x==4 && y==7)
						return new Quadrado(x, y,"Branco");
					
					//Coluna 6
					
					if(x==5 && y==0)
						return new Quadrado(x, y, "Branco");
					if(x==5 && y==1)
						return new Quadrado(x, y, "Preto");
					if(x==5 && y==2)
						return new Quadrado(x, y, "Branco");
					if(x==5 && y==3)
						return new Quadrado(x, y, "Preto");
					if(x==5 && y==4)
						return new Quadrado(x, y,"Branco");
					if(x==5 && y==5)
						return new Quadrado(x, y, "Preto");
					if(x==5 && y==6)
						return new Quadrado(x, y, "Branco");
					if(x==5 && y==7)
						return new Quadrado(x, y, "Preto");
					
					//Coluna 7
					
					if(x==6 && y==0)
						return new Quadrado(x, y, "Preto");
					if(x==6 && y==1)
						return new Quadrado(x, y,"Branco");
					if(x==6 && y==2)
						return new Quadrado(x, y, "Preto");
					if(x==6 && y==3)
						return new Quadrado(x, y,"Branco");
					if(x==6 && y==4)
						return new Quadrado(x, y, "Preto");
					if(x==6 && y==5)
						return new Quadrado(x, y,"Branco");
					if(x==6 && y==6)
						return new Quadrado(x, y, "Preto");
					if(x==6 && y==7)
						return new Quadrado(x, y,"Branco");

					//Coluna 8
					
					if(x==7 && y==0)
						return new Quadrado(x, y, "Branco");
					if(x==7 && y==1)
						return new Quadrado(x, y, "Preto");
					if(x==7 && y==2)
						return new Quadrado(x, y, "Branco");
					if(x==7 && y==3)
						return new Quadrado(x, y, "Preto");
					if(x==7 && y==4)
						return new Quadrado(x, y,"Branco");
					if(x==7 && y==5)
						return new Quadrado(x, y, "Preto");
					if(x==7 && y==6)
						return new Quadrado(x, y, "Branco");
					if(x==7 && y==7)
						return new Quadrado(x, y, "Preto");					
				}	
			}
		}
		return null;
	}
	
	public void verificaXeque(String nome){
		
		this.verTabuleiroJOptionPane();
		
		if(p1.getNome().equals(nome)){
			Peca rei = p2.getRei();
			if(rei == null){
				JOptionPane.showMessageDialog(null, p1.getNome()+": Xeque-Mate!");
				xeque = true;
			}
			
			List<Peca> pecaa = this.p1.getPecas();

			for(Peca p: pecaa){
				if(p.moverPeca(tabuleiro, p.getPosicaoX(), p.getPosicaoY(), rei.getPosicaoX(), rei.getPosicaoY())){
					JOptionPane.showMessageDialog(null, this.vezJogador()+": Xeque!");
					break;
				}
				
			}
		}if(p2.getNome().equals(nome)){
			Peca rei = p1.getRei();
			if(rei == null){
				JOptionPane.showMessageDialog(null, p2.getNome()+": Xeque-Mate!");
				xeque = true;
			}
			List<Peca> pecaa = this.p2.getPecas();

			for(Peca p: pecaa){
				if(p.moverPeca(tabuleiro, p.getPosicaoX(), p.getPosicaoY(), rei.getPosicaoX(), rei.getPosicaoY())){
					JOptionPane.showMessageDialog(null, this.vezJogador()+": Xeque!");
					break;
				}
			}
		}		
	}	
}
