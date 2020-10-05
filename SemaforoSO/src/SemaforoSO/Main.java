package SemaforoSO;

public class Main {

	public static void main(String[] args) {
		int numGarfos = 5;
		Mesa mesa = new MesaMonitor(numGarfos);
		
		System.out.println("Solução com Monitores");
		for(int i = 0; i < numGarfos; i++) {
			new Filosofo(i, mesa).start();
		}
		
//		System.out.println("Solução com Semaforos");
//		mesa = new MesaSemaforo(numGarfos);
//		for(int i = 0; i < numGarfos; i++) {
//			new Filosofo(i, mesa).start();
//		}
	}

}
