package controller;

import model.AbstractDao;
import viewer.JanelaPrincipal;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Automovel;
import model.Marca;
import model.ModeloVersao;
import viewer.JanelaPrincipal;

public class Programa {
	
	public static void main(String[] args) {
		
		AbstractDao.recuperarObjetos();
		JanelaPrincipal janela = new JanelaPrincipal ();
		janela.setVisible(true);
			
//		Programa.recuperarObjetos();
//		JanelaPrincipal janela = new JanelaPrincipal();
//		janela.setVisible(true);
	}
	
//	public static void salvarObjetos() {		
//		try {
//			FileOutputStream   fos = new FileOutputStream("Objetos.bin");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(Automovel.getListaAutomoveis() );
//			oos.writeObject(Marca.getListaMarca());
//			oos.writeObject(ModeloVersao.getListaModeloVersao());
//			oos.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("Deu ruim: " + e.getMessage());
//		} catch (IOException e) {
//			System.out.println("Deu ruim: " + e.getMessage());
//		}				
//	}
//
//	public static void recuperarObjetos() {		
//		try {
//			FileInputStream   fis = new FileInputStream("Objetos.bin");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			Automovel.setListaAutomoveis( (Automovel[]) ois.readObject() );
//			Marca.setListaMarca((Marca[]) ois.readObject());
//			ModeloVersao.setListaModeloVersao((ModeloVersao[]) ois.readObject());
//			ois.close();
//		} catch (ClassNotFoundException e) {
//			System.out.println("Deu ruim: " + e.getMessage());
//		} catch (FileNotFoundException e) {
//			System.out.println("Deu ruim: " + e.getMessage());
//		} catch (IOException e) {
//			System.out.println("Deu ruim: " + e.getMessage());
//		}				
//	}

}

		

