package model;

import java.io.Serializable;

public class Automovel implements Serializable{
	
	final public static int NUM_MAX_AUTOMOVEIS = 10;
	final public static int TAM_PLACA = 7;
	final public static int TAM_COR = 15;
	final public static int VALOR_ANO = 1970;
	
	private Marca marca;
	private ModeloVersao modeloVersao;
	
	private static Automovel[] listaAutomoveis = new Automovel[Automovel.NUM_MAX_AUTOMOVEIS];
	private static int numAutomoveis = 0;
	
	private String placa;
	private String cor;
	private int ano; 
	private int kilometragem;
	private String combustivel;
	
	
	public Automovel (String p, String c, String comb, int a, int k, Marca m, ModeloVersao mv) throws ModelException {
		this.setPlaca(p);
		this.setCor(c);
		this.setAno(a);
		this.setKilometragem(k);
		this.setCombustivel(comb);
		this.setMarca(m);
		this.setModeloVersao(mv);
		
		Automovel.listaAutomoveis[Automovel.numAutomoveis++] = this;
	}
	
	public ModeloVersao getModeloVersao() {
		return this.modeloVersao;
		// TODO Auto-generated method stub
		
	}
	
	private void setModeloVersao(ModeloVersao mv) throws ModelException {
		// TODO Auto-generated method stub
		Automovel.validarModeloVersao(mv);
		this.modeloVersao=mv;
		
	}

	private static void validarModeloVersao(ModeloVersao mv) throws ModelException {
		// TODO Auto-generated method stub
		if(mv == null)
			throw new ModelException("O modelo não foi indicado");
	}

	public Marca getMarca() {
		return this.marca;
		// TODO Auto-generated method stub
		
	}
	
	public void setMarca(Marca m) throws ModelException{
		// TODO Auto-generated method stub
		Automovel.validarMarca(m);
		this.marca=m;
	}

	public static void validarMarca(Marca m) throws ModelException {
		// TODO Auto-generated method stub
		if(m == null)
			throw new ModelException("A marca não foi indicado");
	}

	public static int getNumAutomoveis() {
		return Automovel.numAutomoveis;
	}
	
	public static Automovel[] getListaAutomoveis() {
		return Automovel.listaAutomoveis;
	}
	
	public static void setListaAutomoveis(Automovel[] novaLista) {
		Automovel.listaAutomoveis = novaLista;
		
		for(int i = 0; i < Automovel.NUM_MAX_AUTOMOVEIS; i++) {
			if(Automovel.listaAutomoveis[i] != null)
				System.out.println(Automovel.listaAutomoveis[i]);
			else {
				Automovel.numAutomoveis = i;
				break;
			}
		}
	}


	public String getCombustivel() {
		return this.combustivel;
	}

	private void setCombustivel(String comb) throws ModelException {
		// TODO Auto-generated method stub
		Automovel.validarCombustivel(comb);
		this.combustivel = comb;
	}
	
	private static void validarCombustivel(String comb) throws ModelException{
		// TODO Auto-generated method stub
		String gasolina = "Gasolina";
		String alcool = "�lcool";
		String diesel = "Diesel";
		String flex = "Flex";
		if(!(comb.equals(gasolina) || comb.equals(alcool) || comb.equals(diesel) || comb.equals(flex) ))
			throw new ModelException ("A palavra digitada n�o corresponde a um combust�vel v�lido");
	}

	public int getKilometragem() {
		return this.kilometragem;
	}


	private void setKilometragem(int k) throws ModelException {
		// TODO Auto-generated method stub
		Automovel.validarKilometragem(k);
		this.kilometragem = k;
	}

	private static void validarKilometragem(int k) throws ModelException{
		// TODO Auto-generated method stub
		if(k < 0) {
			throw new ModelException ("A kilometragem n�o pode ser negativa");
		}
	}

	public int getAno() {
		return this.ano;
	}

	private void setAno(int a) throws ModelException{
		// TODO Auto-generated method stub
		Automovel.validarAno(a);
		this.ano = a;
	}
	
	private static void validarAno(int a) throws ModelException{
		// TODO Auto-generated method stub
		if(a < VALOR_ANO) {
			throw new ModelException ("O ano deve ser superior a " + VALOR_ANO);
		}
	}

	public String getCor() {
		return this.cor;
	}


	private void setCor(String c) throws ModelException{
		// TODO Auto-generated method stub
		Automovel.validarCor(c);
		this.cor = c;
	}

	private static void validarCor(String c)throws ModelException {
		// TODO Auto-generated method stub
		if(c == null || c.length() == 0)
			throw new ModelException("A cor n�o pode ser nula!");
		if(c.length() > TAM_COR)
			throw new ModelException("A cor n�o pode ter mais que " + TAM_COR + " caracteres!");
	}

	public String getPlaca() {
		return this.placa;
	}

	private void setPlaca(String p) throws ModelException{
		// TODO Auto-generated method stub
		Automovel.validarPlaca(p);
		this.placa = p;
	}

	private static void validarPlaca(String p) throws ModelException{
		// TODO Auto-generated method stub
		if(p == null || p.length() == 0)
			throw new ModelException("A placa n�o pode ser nula!");
		if(p.length() != TAM_PLACA)
			throw new ModelException("A placa deve ter" + TAM_PLACA + " caracteres!");
		for(int i=0; i< TAM_PLACA; i++) {
			char c = p.charAt(i);
			if(i == 0 || i == 1 || i== 2) 
					if(Character.isDigit(c))
						throw new ModelException("Os 3 primeiros d�gitos devem ser letras! ");
			if(i == 3)
				if(Character.isAlphabetic(c))
					throw new ModelException("O quarto d�gito deve ser num�rico! ");
			if (i == 5 || i == 6)
				if(Character.isAlphabetic(c))
					throw new ModelException("Os dois �ltimos d�gitos devem ser num�ricos! "); 
		}
	}
	
	public String toString() {
		String resultado = "A placa do carro � " + this.placa + " de cor " + this.cor + " do ano " + this.ano + " com " + this.kilometragem + " kilometros rodados e com combust�vel " + this.combustivel; 
		return resultado;
	}
}
