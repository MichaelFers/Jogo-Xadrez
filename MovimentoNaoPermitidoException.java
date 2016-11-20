package Excecoes;

public class MovimentoNaoPermitidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public MovimentoNaoPermitidoException(String msg){
		super(msg);
	}
}
