package SemaforoSO;

import java.util.Random;

public class Filosofo extends Thread{
	
	private int id;
	private Mesa mesa;
	
	public Filosofo(int id, Mesa mesa) {
		this.id = id;
		this.mesa = mesa;
	}
	
	public void pensar() {
		Random gerador = new Random();
		int temp = gerador.nextInt(3000);
		try {
			System.out.println("O filosofo " + this.id  + " esta pensando.");
			sleep(temp);
			System.out.println("O filosofo " + this.id  + " parou de pensar.");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void comer() {
		Random gerador = new Random();
		int temp = gerador.nextInt(3000);
		try {
			
			System.out.println("O filosofo " + this.id  + " esta comendo.");
			sleep(temp);
			System.out.println("O filosofo " + this.id  + " parou de comer.");
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pegarGarfo() {
		mesa.pegarGarfo(this.id);
	}
	
	public void soltarGarfo() {
		mesa.soltarGarfo(this.id);
	}
	
	public void run() {
		
		while(true) {
			pensar();
			pegarGarfo();
			comer();
			soltarGarfo();
		}
		
	}
}
