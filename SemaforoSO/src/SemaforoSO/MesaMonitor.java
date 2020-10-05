package SemaforoSO;

public class MesaMonitor extends Mesa{
	
	private boolean[] garfos;
	
	public MesaMonitor(int numGarfos) {
		super(numGarfos);
		
		garfos = new boolean[numGarfos];
		
		for (int i = 0; i < numGarfos; i++) {
			garfos[i] = true;
		}
	}
	
	@Override
	public synchronized void pegarGarfo(int id) {

		int garfoEsquerdo = id;
		int garfoDireito = (id + 1) % this.getNumGarfos();

		while (garfos[garfoEsquerdo] == false || garfos[garfoDireito] == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		garfos[garfoEsquerdo] = false;
		garfos[garfoDireito] = false;
		
		System.out.println("Filosofo " + id + " pegou os garfos.");
	}

	@Override
	public synchronized void soltarGarfo(int id) {

		int garfoEsquerdo = id;
		int garfoDireito = (id + 1) % this.getNumGarfos();
		
		garfos[garfoEsquerdo] = true;
		garfos[garfoDireito] = true;
		
		System.out.println("Filosofo " + id + " deixou os garfos de volta na mesa.");
		notifyAll();
	}

}
