package SemaforoSO;

import java.util.concurrent.Semaphore;;
public class MesaSemaforo extends Mesa{
	
	private Semaphore[] garfos;
	
	public MesaSemaforo(int numGarfos) {
		super(numGarfos);
		
		this.garfos = new Semaphore[numGarfos];
		
		for(int i = 0; i < numGarfos; i++) {
			this.garfos[i] = new Semaphore(1);
		}
	}
	
	@Override
	public void pegarGarfo(int id) {
		
		int garfoEsquerdo = id;
		int garfoDireito = (id + 1) % this.getNumGarfos();
		
        if(garfoEsquerdo > garfoDireito){
        	int aux = garfoDireito;
        	garfoDireito = garfoEsquerdo;
        	garfoEsquerdo = aux;
        }
        
		try {
			
			garfos[garfoEsquerdo].acquire();
            garfos[garfoDireito].acquire();
			System.out.println("Filosofo " + id + " pegou os garfos.");
			
		}catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void soltarGarfo(int id) {

		int garfoEsquerdo = id;
		int garfoDireito = (id + 1) % this.getNumGarfos();
		
        garfos[garfoEsquerdo].release();
        garfos[garfoDireito].release();
		System.out.println("Filosofo " + id + " deixou os garfos de volta na mesa.");
	}
    
}
