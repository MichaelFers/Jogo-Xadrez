package GerenciadorDeArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GerenciaArquivos {
	
	public String leitorDeArquivo(String nomeArquivo) throws IOException{
		
		BufferedReader leitor = null;
		String retorno="";
		try{

			leitor = new BufferedReader(new FileReader(nomeArquivo+".txt"));
			String texto = null;
	
			do{
				
				texto = leitor.readLine();
				if(texto !=null){
					retorno +=texto+"\n";
				}
			
			}while(texto !=null);
		
		
		}finally{
				leitor.close();
		}
		return retorno;
		
	}
	
	public void gravadorDeArquivo(String conteudo,String nomeArquivo) throws IOException{

		BufferedWriter gravador = null;
		
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo+".txt"));
			gravador.write(conteudo+"\n");
		}finally{
				gravador.close();
		}
		
	}
}
