package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DaoModeloVersao;
import model.ModeloVersao;

public class JanelaModeloVersao extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeModelo;
	private JTextField txtNomeVersao;
	private JTextField txtCilindradas;
	private JTextField txtNumeroValvulas;
	private JButton btSalvar;
	private JButton btCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaModeloVersao frame = new JanelaModeloVersao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaModeloVersao() {
		setTitle("Modelo e versao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Modelo");
		lblNewLabel.setBounds(32, 31, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Vers\u00E3o");
		lblNewLabel_1.setBounds(32, 76, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cilindradas");
		lblNewLabel_2.setBounds(32, 121, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero Valvulas");
		lblNewLabel_3.setBounds(32, 165, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNomeModelo = new JTextField();
		txtNomeModelo.setBounds(168, 28, 86, 20);
		contentPane.add(txtNomeModelo);
		txtNomeModelo.setColumns(10);
		
		txtNomeVersao = new JTextField();
		txtNomeVersao.setBounds(168, 73, 86, 20);
		contentPane.add(txtNomeVersao);
		txtNomeVersao.setColumns(10);
		
		txtCilindradas = new JTextField();
		txtCilindradas.setBounds(168, 118, 86, 20);
		contentPane.add(txtCilindradas);
		txtCilindradas.setColumns(10);
		
		txtNumeroValvulas = new JTextField();
		txtNumeroValvulas.setBounds(168, 162, 86, 20);
		contentPane.add(txtNumeroValvulas);
		txtNumeroValvulas.setColumns(10);
		
		btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeModelo = txtNomeModelo.getText();
				String nomeVersao = txtNomeVersao.getText();
				String auxNumValvulas = txtNumeroValvulas.getText();
				String cilindradas = null;
				int numValvulas;
				
				try {
					numValvulas = Integer.parseInt(auxNumValvulas);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btSalvar, "Ano Inv�lido: " + auxNumValvulas);
					return;
				}
				
				try {
					ModeloVersao mv = new ModeloVersao(nomeModelo, nomeVersao, cilindradas, numValvulas);
					JOptionPane.showMessageDialog(btSalvar, "Deu bom! " + mv);
					setVisible(false);
					DaoModeloVersao dao = new DaoModeloVersao();
					dao.incluir(mv);
					dao.commit();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btSalvar, "Erro: " + e1.getMessage());
					e1.printStackTrace();
					return;
				}				
			
			}
		});
		btSalvar.setBounds(70, 208, 89, 23);
		contentPane.add(btSalvar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(280, 208, 89, 23);
		contentPane.add(btCancelar);
	}

}
