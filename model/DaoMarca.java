package model;

public class DaoMarca extends AbstractDao {
	
	final public static int NUM_MAX_MARCA = 10;
	
	private static Marca[] listaMarca = new Marca[Marca.NUM_MAX_MARCA];
	private static int numMarca = 0;
	
	public void setLista(Object[] novaLista) throws ModelException {
		// TODO Auto-generated method stub
		numMarca = 0;
		for(int i = 0; i < novaLista.length; i++) {	
			if(novaLista[i] == null)
				break;
			if(!(novaLista[i] instanceof Marca) )
				throw new ModelException("Há a presença de um objeto que não é Marca na lista");
			Marca a = (Marca)novaLista[i];
			DaoMarca.listaMarca[numMarca++] = a;
			System.out.println("Marca: " + a);
		}
	}
		
	public static int getNumMarca() {
		return DaoMarca.numMarca;
	}
	
	public void incluir(Object novo) throws ModelException {
		if(! (novo instanceof Marca) )
			throw new ModelException("Você solicitou a persistência de um objeto que não é Marca");
		DaoMarca.listaMarca[ DaoMarca.numMarca++ ] = (Marca)novo;
	}
	
	public void alterar(Object obj) throws ModelException {
		if(! (obj instanceof Marca) )
			throw new ModelException("Você solicitou a alteração de um objeto que não é Marca");
		boolean achei = false;
		for(int i = 0; i < DaoMarca.numMarca; i++) {
			if(DaoMarca.listaMarca[i] == obj) {
				achei = true;
				break;
			}				
		}
		if(!achei)
			throw new ModelException("Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");		
	}

	public void excluir(Object obj) throws ModelException {
		if(! (obj instanceof Marca) )
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Marca");
		int pos = -1;
		for(int i = 0; i < DaoMarca.numMarca; i++) {
			if(DaoMarca.listaMarca[i] == obj) {
				pos = i;
				break;
			}				
		}
		if(pos == -1)
			throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de alunos");		
		for(int i = pos; i < DaoMarca.numMarca; i++) {
			DaoMarca.listaMarca[i] = DaoMarca.listaMarca[i+1];
		}
		DaoMarca.numMarca--;
	}

	public Object[] consultarTodos() throws ModelException {		
		Marca[] copia = new Marca[DaoMarca.NUM_MAX_MARCA];
		System.arraycopy(DaoMarca.listaMarca, 0, copia, 0, NUM_MAX_MARCA);
		
		return copia;		
	}

	public Marca consultarPeloNome(String nome) throws ModelException {
		for(int i = 0; i < DaoMarca.numMarca; i++) {						
			Marca a = DaoMarca.listaMarca[i];			
			if(a.getNome().equals(nome)) {
				return a;
			}				
		}	
		return null;	
	
	}

}
