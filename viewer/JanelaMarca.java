package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DaoMarca;
import model.Marca;

public class JanelaMarca extends JFrame {

	private JPanel contentPane;
	private JTextField txtCnpj;
	private JTextField txtNome;

	/**
	 * Create the frame.
	 */
	public JanelaMarca() {
		setTitle("Marca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CNPJ");
		lblNewLabel.setBounds(51, 47, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(51, 105, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(194, 44, 86, 20);
		contentPane.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(194, 102, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnpj = txtCnpj.getText();
				String nome = txtNome.getText();
				
				try {
					Marca m = new Marca(cnpj, nome);
					JOptionPane.showMessageDialog(btSalvar, "Deu bom! " + m);
					setVisible(false);
					DaoMarca dao = new DaoMarca();
					dao.incluir(m);
					dao.commit();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btSalvar, "Erro: " + e1.getMessage());
					e1.printStackTrace();
					return;
				}		
			}
		});
		btSalvar.setBounds(89, 177, 89, 23);
		contentPane.add(btSalvar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(270, 177, 89, 23);
		contentPane.add(btCancelar);
	}

}
