package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractDao {
	
	public static boolean objetosRecuperados = false;
	
	public static void commit() {
		try {
			FileOutputStream arquivo = new FileOutputStream("Objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(arquivo);

			DaoAutomovel daoAutomovel = new DaoAutomovel();
			oos.writeObject( daoAutomovel.consultarTodos() );

			DaoMarca daoMarca = new DaoMarca();
			oos.writeObject( daoMarca.consultarTodos() );
			
			DaoModeloVersao daoModeloVersao = new DaoModeloVersao();
			oos.writeObject(daoModeloVersao.consultarTodos() );
			
			oos.close();
		} catch (ModelException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo de persistência não foi encontrado! " + e.getMessage());			
		} catch (IOException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		}
	}

	public static void recuperarObjetos() {
		// TODO Auto-generated method stub
		if(AbstractDao.objetosRecuperados)
			return;
		try {
			FileInputStream arquivo = new FileInputStream("Objetos.bin");
			ObjectInputStream ois = new ObjectInputStream(arquivo);
			
			DaoAutomovel daoAutomovel = new DaoAutomovel();
			daoAutomovel.setLista( (Automovel[]) ois.readObject() );
			
			DaoMarca daoMarca = new DaoMarca();
			daoMarca.setLista( (Marca[]) ois.readObject() );
			
			DaoModeloVersao daoModeloVersao = new DaoModeloVersao();
			Object obj = ois.readObject();
			daoModeloVersao.setLista(  (ModeloVersao[])obj );
			
			ois.close();
			AbstractDao.objetosRecuperados = true;
		}
		catch (ModelException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (FileNotFoundException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (ClassNotFoundException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (IOException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		}
	
	}
	
	abstract public Object[] consultarTodos() throws ModelException;

}
