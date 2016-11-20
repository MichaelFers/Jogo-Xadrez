package Threads;

import javax.swing.JOptionPane;

public class Temporizador implements Runnable{

	int segundo;
	public Temporizador(){
		segundo = 0;
	}

	@Override
	public void run() {

		try {
			while(true){
				segundo++;
				System.out.print(segundo);
				Thread.sleep(1000);
				if(segundo==20){
					JOptionPane.showMessageDialog(null, "10 segundos restante.");										
				}
			}
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	public int getSegundo(){
		return this.segundo;
	}
	public void inicializaSegundo(){
		this.segundo = 0;
	}
}


