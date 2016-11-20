package Main;

import java.io.IOException;

import javax.swing.JOptionPane;

import Excecoes.MovimentoIndefinidoException;
import Excecoes.MovimentoNaoPermitidoException;
import Excecoes.PecaNaoEncontradaException;
import GerenciadorDeArquivos.GerenciaArquivos;
import Jogador.Jogador;
import Tabuleiro.Tabuleiro;
import Threads.Temporizador;

public class MainXadrezNovaIdeia {

	public static void main(String[] args){

		JOptionPane.showMessageDialog(null, "Bem-vindo ao Jogo de Xadrez!\nPara começar, por favor digite o nome dos Jogadores");
		JOptionPane.showMessageDialog(null, "Desenvolvedores: \nMichael Fernandes\nIvonaldo Filho\nEllen Barbosa");
		Temporizador tem = new Temporizador();
		Thread thread = new Thread(tem);

		Tabuleiro t = inicializaTabuleiro();
		dicasMovimento();
		thread.start();
		
		while(!t.getXeque()){

			try {

				String jogadaVezMovimento = JOptionPane.showInputDialog("Vez do: "+t.vezJogador()+"\n \n"+t.verTabuleiroJOptionPane()+"\n");
				
				if(jogadaVezMovimento.equals("sair")){
					thread.interrupt();
					break;
				}if(jogadaVezMovimento.equals("lista vencedor")){
					arquivos(null,null);
				}if(tem.getSegundo()>=30){
					JOptionPane.showMessageDialog(null, t.vezJogador()+" perdeu a vez! :(");
					t.passarVez();
					tem.inicializaSegundo();
					continue;
				}if(jogadaVezMovimento==null){
					continue;
				}
				else{
					t.Movimento(t.vezJogador(), jogadaVezMovimento);
					tem.inicializaSegundo();
				}
			} catch (MovimentoIndefinidoException | MovimentoNaoPermitidoException | PecaNaoEncontradaException e) {
				//NullPointerException
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		thread.interrupt();
		if(t.getNomeJogador1().equals(t.vezJogador())){
			arquivos(t.getNomeJogador1(),t.getNomeJogador2());
		}else{
			arquivos(t.getNomeJogador2(),t.getNomeJogador1());
		}
		
	}

	public static Tabuleiro inicializaTabuleiro(){

		String nomeP1 = JOptionPane.showInputDialog("Informe o Nome do Jogador 1:");
		String nomeP2 = JOptionPane.showInputDialog("Informe o Nome do Jogador 2:");
		String confirmar = JOptionPane.showInputDialog("Confirmar nomes dos jogadores? sim / não");

		if(confirmar == null){
			return inicializaTabuleiro();
		}
		
		if(confirmar.toLowerCase().equals("sim")){
			return new Tabuleiro(new Jogador(nomeP1),new Jogador(nomeP2));
		}else{
			return inicializaTabuleiro();
		}
	}

	public static void arquivos(String vencedor, String perdedor){

		GerenciaArquivos g = new GerenciaArquivos();
		try{
			if(vencedor==null){
				JOptionPane.showMessageDialog(null, g.leitorDeArquivo("listaXadrez"));
			}else{
				g.gravadorDeArquivo(vencedor+" venceu "+ perdedor, "listaXadrez");
			}

		}catch(IOException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public static void dicasMovimento(){
		JOptionPane.showMessageDialog(null, "Antes de começar, saiba como jogar: \nCada jogador usa um movimente representado com a posição da sua peça e para o local onde quer ir\nExemplo: 67 57 a posição 67 se encontra uma peça peão ♙ e o número 57 representa a casa a cima que desejo ir. \nObs: Peças de cor branco começam primeiro. Para sair escreve sair, para visualizar lista de vencedores de outra partida digite: 'lista vercedor'. \nBoa sorte e bom Jogo :)");
	}
}
