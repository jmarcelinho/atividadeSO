package SemaforoSO;

public abstract class Mesa {
	
	private int numGarfos;
	
	public Mesa(int numGarfos) {
		this.numGarfos = numGarfos;
	}
	
	public void pegarGarfo(int id) {
		
	}
	
	public void soltarGarfo(int id) {
		
	}

	public int getNumGarfos() {
		return numGarfos;
	}
	
	
}
