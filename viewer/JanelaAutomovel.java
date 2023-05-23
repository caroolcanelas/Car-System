package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Automovel;
import model.DaoAutomovel;
import model.Marca;
import model.ModeloVersao;

public class JanelaAutomovel extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtCor;
	private JTextField txtAno;
	private JTextField txtKilometragem;
	private JTextField txtCombustivel;
	private JComboBox cbMarca;
	private JComboBox cbModeloVersao;

	/**
	 * Create the frame.
	 */
	public JanelaAutomovel() {
		setTitle("Autom\u00F3vel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setBounds(27, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cor");
		lblNewLabel_1.setBounds(27, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ano");
		lblNewLabel_2.setBounds(27, 107, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kilometragem");
		lblNewLabel_3.setBounds(27, 146, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Combustivel");
		lblNewLabel_4.setBounds(27, 181, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(129, 24, 86, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(129, 66, 86, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(129, 105, 86, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		txtKilometragem = new JTextField();
		txtKilometragem.setBounds(129, 143, 86, 20);
		contentPane.add(txtKilometragem);
		txtKilometragem.setColumns(10);
		
		txtCombustivel = new JTextField();
		txtCombustivel.setBounds(129, 178, 86, 20);
		contentPane.add(txtCombustivel);
		txtCombustivel.setColumns(10);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String placa = txtPlaca.getText();
				String cor = txtCor.getText();
				String aux = txtAno.getText();
				String auxKilometragem = txtKilometragem.getText();
				String combustivel = txtCombustivel.getText();
				int kilometragem;
				int ano;
				Marca marca = null;
				ModeloVersao modeloMarca = null;
				
				try {
					ano = Integer.parseInt(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btSalvar, "Ano Inv�lido: " + aux);
					return;
				}
				
				try {
					kilometragem = Integer.parseInt(auxKilometragem);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btSalvar, "Kilometragem Inv�lido: " + auxKilometragem);
					return;
				}
				
				try {
					Automovel a = new Automovel(placa, cor, combustivel, ano, kilometragem, marca, modeloMarca);
					JOptionPane.showMessageDialog(btSalvar, "Deu bom! " + a);
					setVisible(false);
					DaoAutomovel dao = new DaoAutomovel();
					dao.incluir(a);
					dao.commit();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btSalvar, "Erro: " + e1.getMessage());
					e1.printStackTrace();
					return;
				}				
			}
			
		});
		btSalvar.setBounds(73, 227, 89, 23);
		contentPane.add(btSalvar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(286, 227, 89, 23);
		contentPane.add(btCancelar);
		
		cbMarca = new JComboBox();
		cbMarca.setBounds(286, 65, 122, 22);
		contentPane.add(cbMarca);
		
		Marca[] listaMarca = Marca.getListaMarca();
		for (int i=0; i< Marca.getNumMarca(); i++)
			cbMarca.addItem(listaMarca);
		
		JLabel lblNewLabel_5 = new JLabel("Marca");
		lblNewLabel_5.setBounds(286, 40, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Modelo e Versão");
		lblNewLabel_6.setBounds(286, 126, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		cbModeloVersao = new JComboBox();
		cbModeloVersao.setBounds(286, 151, 122, 22);
		contentPane.add(cbModeloVersao);
		
		ModeloVersao[] listaModeloVersao = ModeloVersao.getListaModeloVersao();
		for (int i=0; i< ModeloVersao.getNumModeloVersao(); i++)
			cbModeloVersao.addItem(listaModeloVersao);
	}
}
