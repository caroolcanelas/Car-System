package model;

public class DaoAutomovel extends AbstractDao {

	final public static int NUM_MAX_AUTOMOVEIS = 10;
	
	private static Automovel[] listaAutomoveis = new Automovel[Automovel.NUM_MAX_AUTOMOVEIS];
	private static int numAutomoveis = 0;
	
	public void setLista(Object[] novaLista) throws ModelException {
		// TODO Auto-generated method stub
		numAutomoveis = 0;
		for(int i = 0; i < novaLista.length; i++) {	
			if(novaLista[i] == null)
				break;
			if(!(novaLista[i] instanceof Automovel) )
				throw new ModelException("Há a presença de um objeto que não é Automovel na lista");
			Automovel a = (Automovel)novaLista[i];
			DaoAutomovel.listaAutomoveis[numAutomoveis++] = a;
			System.out.println("Automovel: " + a);
		}
	}
		
	public static int getNumAutomovel() {
		return DaoAutomovel.numAutomoveis;
	}
	
	public void incluir(Object novo) throws ModelException {
		if(! (novo instanceof Automovel) )
			throw new ModelException("Você solicitou a persistência de um objeto que não é Automovel");
		DaoAutomovel.listaAutomoveis[ DaoAutomovel.numAutomoveis++ ] = (Automovel)novo;
	}
	
	public void alterar(Object obj) throws ModelException {
		if(! (obj instanceof Automovel) )
			throw new ModelException("Você solicitou a alteração de um objeto que não é Automovel");
		boolean achei = false;
		for(int i = 0; i < DaoAutomovel.numAutomoveis; i++) {
			if(DaoAutomovel.listaAutomoveis[i] == obj) {
				achei = true;
				break;
			}				
		}
		if(!achei)
			throw new ModelException("Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");		
	}

	public void excluir(Object obj) throws ModelException {
		if(! (obj instanceof Automovel) )
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Automovel");
		int pos = -1;
		for(int i = 0; i < DaoAutomovel.numAutomoveis; i++) {
			if(DaoAutomovel.listaAutomoveis[i] == obj) {
				pos = i;
				break;
			}				
		}
		if(pos == -1)
			throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de alunos");		
		for(int i = pos; i < DaoAutomovel.numAutomoveis; i++) {
			DaoAutomovel.listaAutomoveis[i] = DaoAutomovel.listaAutomoveis[i+1];
		}
		DaoAutomovel.numAutomoveis--;
	}

	public Object[] consultarTodos() throws ModelException {		
		Automovel[] copia = new Automovel[DaoAutomovel.NUM_MAX_AUTOMOVEIS];
		System.arraycopy(DaoAutomovel.listaAutomoveis, 0, copia, 0, NUM_MAX_AUTOMOVEIS);
		
		return copia;		
	}

	public Automovel consultarPorPlaca(String placa) throws ModelException {
		for(int i = 0; i < DaoAutomovel.numAutomoveis; i++) {						
			Automovel a = DaoAutomovel.listaAutomoveis[i];			
			if(a.getPlaca().equals(placa)) {
				return a;
			}				
		}	
		return null;	
	
	}

}
