package model;

import java.io.Serializable;

public class ModeloVersao implements Serializable {
	
	final public static int NUM_MAX_MODELO_VERSAO = 10;
	final public static int NUM_MAX_NOME_MODELO_VERSAO = 15;
	final public static int NUM_MAX_CILINDRADAS = 7;
	
	private static ModeloVersao[] listaModeloVersao = new ModeloVersao[ModeloVersao.NUM_MAX_MODELO_VERSAO];
	private static int numModeloVersao = 0;
	
	private String nomeModelo;
	private String nomeVersao;
	private String cilindradas; 
	private int numValvulas;
	
	public ModeloVersao (String nm, String nv, String cilindradas2, int numv) throws ModelException  {
		this.setNomeModelo(nm);
		this.setNomeVersao(nv);
		this.setCilindradas(cilindradas2);
		this.setNumValvulas(numv);

		ModeloVersao.listaModeloVersao[ModeloVersao.numModeloVersao++] = this;
	}
	

	public static int getNumModeloVersao() {
		return ModeloVersao.numModeloVersao;
	}
	
	public static ModeloVersao[] getListaModeloVersao() {
		return ModeloVersao.listaModeloVersao;
	}
	
	public static void setListaModeloVersao(ModeloVersao[] novaLista) {
		ModeloVersao.listaModeloVersao = novaLista;
		
		for(int i = 0; i < ModeloVersao.NUM_MAX_MODELO_VERSAO; i++) {
			if(ModeloVersao.listaModeloVersao[i] != null)
				System.out.println(ModeloVersao.listaModeloVersao[i]);
			else {
				ModeloVersao.numModeloVersao = i;
				break;
			}
		}
	}
	
	public int getNumValvulas() {
		return this.numValvulas;
	}
	
	private void setNumValvulas(int numv) throws ModelException  {
		// TODO Auto-generated method stub
		ModeloVersao.validarNumValvulas(numv);
		this.numValvulas = numv;
		
	}

	private static void validarNumValvulas(int numv) throws ModelException  {
		// TODO Auto-generated method stub
		if(numv % 2 != 0)
			throw new ModelException ("O n�mero de v�lvulas deve ser par!");
		if(numv < 8)
			throw new ModelException ("O n�mero de v�lvulas deve ser maior ou igual a 8!");
	}


	public String getCilindradas() {
		return this.cilindradas;
	}
	
	private void setCilindradas(String c) throws ModelException  {
		// TODO Auto-generated method stub
		ModeloVersao.validarCilindradas(c);
		this.cilindradas = c;
	}
	
	private static void validarCilindradas(String c) throws ModelException  {
		// TODO Auto-generated method stub
		if (c == null)
			throw new ModelException ("As cilindradas n�o podem ser nulas!");
		if (c.length() != NUM_MAX_CILINDRADAS)
			throw new ModelException ("A cilindrada deve ter " + NUM_MAX_CILINDRADAS + " caracteres no formato 1111 cc!");
		for(int i=0; i<NUM_MAX_CILINDRADAS; i++) {
			char ch = c.charAt(i);
			switch(i) {
				case 0:
				case 1:
				case 2:
				case 3:
					if(!Character.isDigit(ch)) 
						throw new ModelException ("Na posi��o " + (i+1) + " deve ter um d�gito!");
					break;
				case 4:
					if(ch != ' ') 
						throw new ModelException ("Na posi��o " + (i+1) + " deve constar ' ' ");
					break;
				case 5:
				case 6:
					if(ch != 'c')
						throw new ModelException ("Na posiçao " + (i+1) + "deve constar o carácter c ");	
				}
			}
		}


	public String getNomeVersao() {
		return this.nomeVersao;
	}

	private void setNomeVersao(String nv) throws ModelException  {
		// TODO Auto-generated method stub
		ModeloVersao.validarNomeVersao(nv);
		this.nomeVersao = nv;
	}
	
	private static void validarNomeVersao(String nv) throws ModelException  {
		// TODO Auto-generated method stub
		if(nv == null || nv.length() == 0)
			throw new ModelException ("O nome da vers�o n�o pode ser nula!");
		if(nv.length() > NUM_MAX_NOME_MODELO_VERSAO)
			throw new ModelException ("O nome da vers�o n�o pode ter mais que " + NUM_MAX_NOME_MODELO_VERSAO + " caracteres!");
	}


	public String getNomeModelo() {
		return this.nomeModelo;
	}

	private void setNomeModelo(String nm) throws ModelException  {
		// TODO Auto-generated method stub
		ModeloVersao.validarNomeModelo(nm);
		this.nomeModelo = nm;
	}


	private static void validarNomeModelo(String nm) throws ModelException  {
		// TODO Auto-generated method stub
		if(nm == null || nm.length() == 0)
			throw new ModelException ("O nome do modelo n�o pode ser nula!");
		if(nm.length() > NUM_MAX_NOME_MODELO_VERSAO)
			throw new ModelException ("O nome do modelo n�o pode ter mais que " + NUM_MAX_NOME_MODELO_VERSAO + " caracteres!");
	}
	public String toString() {
		String resultado = "O nome do modelo � " + this.nomeModelo + " nome da vers�o " + this.nomeVersao + " com cilindradas sendo " + this.cilindradas + " e v�lvulas sendo " + this.numValvulas; 
		return resultado;
	}
	
}
