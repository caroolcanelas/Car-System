package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Programa;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btAutomovel = new JButton("Automovel");
		btAutomovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaAutomovel ja = new JanelaAutomovel();
				ja.setVisible(true);
			}
		});
		btAutomovel.setBounds(55, 42, 89, 23);
		contentPane.add(btAutomovel);
		
		JButton btModeloVersao = new JButton("Modelo e Versao");
		btModeloVersao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaModeloVersao jmv = new JanelaModeloVersao();
				jmv.setVisible(true);
			}
		});
		btModeloVersao.setBounds(138, 95, 163, 23);
		contentPane.add(btModeloVersao);
		
		JButton btMarca = new JButton("Marca");
		btMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaMarca jm = new JanelaMarca();
				jm.setVisible(true);
			}
			
		});
		btMarca.setBounds(293, 42, 89, 23);
		contentPane.add(btMarca);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btCancelar.setBounds(173, 185, 89, 23);
		contentPane.add(btCancelar);
	}
}
