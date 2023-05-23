package model;

public class DaoModeloVersao extends AbstractDao {

	final public static int NUM_MAX_MODELO_VERSAO = 10;
	
	private static ModeloVersao[] listaModeloVersao = new ModeloVersao[ModeloVersao.NUM_MAX_MODELO_VERSAO];
	private static int numModeloVersao = 0;
	
	public void setLista(Object[] novaLista) throws ModelException {
		// TODO Auto-generated method stub
		numModeloVersao = 0;
		for(int i = 0; i < novaLista.length; i++) {	
			if(novaLista[i] == null)
				break;
			if(!(novaLista[i] instanceof ModeloVersao) )
				throw new ModelException("Há a presença de um objeto que não é ModeloVersao na lista");
			ModeloVersao a = (ModeloVersao)novaLista[i];
			DaoModeloVersao.listaModeloVersao[numModeloVersao++] = a;
			System.out.println("ModeloVersao: " + a);
		}
	}
		
	public static int getNumModeloVersao() {
		return DaoModeloVersao.numModeloVersao;
	}
	
	public void incluir(Object novo) throws ModelException {
		if(! (novo instanceof ModeloVersao) )
			throw new ModelException("Você solicitou a persistência de um objeto que não é ModeloVersao");
		DaoModeloVersao.listaModeloVersao[ DaoModeloVersao.numModeloVersao++ ] = (ModeloVersao)novo;
	}
	
	public void alterar(Object obj) throws ModelException {
		if(! (obj instanceof Marca) )
			throw new ModelException("Você solicitou a alteração de um objeto que não é ModeloVersao");
		boolean achei = false;
		for(int i = 0; i < DaoModeloVersao.numModeloVersao; i++) {
			if(DaoModeloVersao.listaModeloVersao[i] == obj) {
				achei = true;
				break;
			}				
		}
		if(!achei)
			throw new ModelException("Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");		
	}

	public void excluir(Object obj) throws ModelException {
		if(! (obj instanceof ModeloVersao) )
			throw new ModelException("Você solicitou a exclusão de um objeto que não é ModeloVersao");
		int pos = -1;
		for(int i = 0; i < DaoModeloVersao.numModeloVersao; i++) {
			if(DaoModeloVersao.listaModeloVersao[i] == obj) {
				pos = i;
				break;
			}				
		}
		if(pos == -1)
			throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de alunos");		
		for(int i = pos; i < DaoModeloVersao.numModeloVersao; i++) {
			DaoModeloVersao.listaModeloVersao[i] = DaoModeloVersao.listaModeloVersao[i+1];
		}
		DaoModeloVersao.numModeloVersao--;
	}

	public Object[] consultarTodos() throws ModelException {		
		ModeloVersao[] copia = new ModeloVersao[DaoModeloVersao.NUM_MAX_MODELO_VERSAO];
		System.arraycopy(DaoModeloVersao.listaModeloVersao, 0, copia, 0, NUM_MAX_MODELO_VERSAO);
		
		return copia;		
	}

	public ModeloVersao consultarPeloModeloVersao(String nomeVersao) throws ModelException {
		for(int i = 0; i < DaoModeloVersao.numModeloVersao; i++) {						
			ModeloVersao a = DaoModeloVersao.listaModeloVersao[i];			
			if(a.getNomeVersao().equals(nomeVersao)) {
				return a;
			}				
		}	
		return null;	
	
	}


}
