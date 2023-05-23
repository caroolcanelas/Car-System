package model;

import java.io.Serializable;

public class Marca implements Serializable {

	final public static int NUM_MAX_MARCA = 10;
	final public static int NUM_MAX_NOME = 15;
	final public static int TAM_CNPJ = 18;
	private static Marca[] listaMarca = new Marca[Marca.NUM_MAX_MARCA];
	private static int numMarca = 0;
	
	private String cnpj;
	private String nome;
	
	public Marca (String c, String n) throws ModelException  {
		this.setCnpj(c);
		this.setNome(n);

		Marca.listaMarca[Marca.numMarca++] = this;
	}

	public static int getNumMarca() {
		return Marca.numMarca;
	}
	
	public static Marca[] getListaMarca() {
		return Marca.listaMarca;
	}
	
	public static void setListaMarca(Marca[] novaLista) {
		Marca.listaMarca = novaLista;
		
		for(int i = 0; i < Marca.NUM_MAX_MARCA; i++) {
			if(Marca.listaMarca[i] != null)
				System.out.println(Marca.listaMarca[i]);
			else {
				Marca.numMarca = i;
				break;
			}
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
	private void setNome(String n) throws ModelException  {
		// TODO Auto-generated method stub
		Marca.validarNome(n);
		this.nome = n;
	}
	
	private static void validarNome(String n) throws ModelException  {
		// TODO Auto-generated method stub
		if(n == null || n.length() == 0)
			throw new ModelException ("O nome da marca n�o pode ser nula!");
		if(n.length() > NUM_MAX_NOME)
			throw new ModelException ("O nome da marca n�o pode ter mais que " + NUM_MAX_NOME + " caracteres!");
	}

	public String getCnpj() {
		return this.cnpj;
	}

	private void setCnpj(String c) throws ModelException  {
		// TODO Auto-generated method stub
		Marca.validarCnpj(c);
		this.cnpj = c;
	}

	private static void validarCnpj(String c) throws ModelException  {
		// TODO Auto-generated method stub
		if (c == null)
			throw new ModelException ("O CNPJ n�o pode ser nulo!");
		if (c.length() != TAM_CNPJ)
			throw new ModelException ("O CNPJ deve ter " + TAM_CNPJ + " caracteres no formato XX.XXX.XXX/000X-XX!");
		for (int i = 0; i < TAM_CNPJ; i++) {
			char ch = c.charAt(i);
			switch(i) {
				case  2:
				case  6: 
					if(ch != '.') 
						throw new ModelException ("Na posi��o " + (i+1) + " deve constar '.', pois o CNPJ deve ter 18 caracteres no formato XX.XXX.XXX/000X-XX!");
					break;
				case 10: 
					if(ch != '/') 
						throw new ModelException ("Na posi��o " + (i+1) + " deve constar '/', pois o CNPJ deve ter 18 caracteres no formato XX.XXX.XXX/000X-XX!");
					break;
				case 11:
				case 12:
				case 13:
					if(ch != '0'&& ch !='1' ) 
						throw new ModelException ("Na posi��o " + (i+1) + " deve constar 0, pois o CNPJ deve ter 18 caracteres no formato XX.XXX.XXX/000X-XX!");
					break;
				case 15: 
					if(ch != '-') 
						throw new ModelException ("Na posi��o " + (i+1) + " deve constar '-', pois o CNPJ deve ter 18 caracteres no formato XX.XXX.XXX/000X-XX!");
					break;
				default: 
					if(!Character.isDigit(ch)) 
						throw new ModelException ("Na posi��o " + (i+1) + " deve ter um d�gito!"); 
			}
		}
	}	
	
}
