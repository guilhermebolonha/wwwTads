package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaPreLogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPreLogin window = new TelaPreLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPreLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnContaCorrente = new JButton("Conta Corrente");
		btnContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.iniciar(1);
				frame.setVisible(false);

			}
		});
		btnContaCorrente.setBounds(89, 136, 116, 23);
		frame.getContentPane().add(btnContaCorrente);
		
		JButton btnContaPoupana = new JButton("Conta Poupan\u00E7a");
		btnContaPoupana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.iniciar(2);
				frame.setVisible(false);

			}
		});
		btnContaPoupana.setBounds(223, 136, 111, 23);
		frame.getContentPane().add(btnContaPoupana);
		
		JTextPane txtpnTipoDeConta = new JTextPane();
		txtpnTipoDeConta.setBackground(Color.LIGHT_GRAY);
		txtpnTipoDeConta.setText("Tipo de Conta:");
		txtpnTipoDeConta.setBounds(171, 97, 98, 20);
		frame.getContentPane().add(txtpnTipoDeConta);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(TelaPreLogin.class.getResource("/Imagens/iconVoltar.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TelaInicial.frame.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 35, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
