package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class TelaPreLogin {

	private JFrame frmTelaTipoDe;

	/**
	 * Launch the application.
	 */
	public static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPreLogin window = new TelaPreLogin();
					window.frmTelaTipoDe.setVisible(true);
					window.frmTelaTipoDe.setLocationRelativeTo(null);
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
		frmTelaTipoDe = new JFrame();
		frmTelaTipoDe.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPreLogin.class.getResource("/Imagens/iconBank.png")));
		frmTelaTipoDe.setTitle("Tela Tipo de Conta");
		frmTelaTipoDe.getContentPane().setBackground(Color.WHITE);
		frmTelaTipoDe.setBounds(100, 100, 339, 300);
		frmTelaTipoDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaTipoDe.getContentPane().setLayout(null);
		
		JButton btnContaCorrente = new JButton("Conta Corrente");
		btnContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.iniciar(1);
				frmTelaTipoDe.setVisible(false);

			}
		});
		btnContaCorrente.setBounds(20, 105, 135, 23);
		frmTelaTipoDe.getContentPane().add(btnContaCorrente);
		
		JButton btnContaPoupana = new JButton("Conta Poupan\u00E7a");
		btnContaPoupana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.iniciar(2);
				frmTelaTipoDe.setVisible(false);

			}
		});
		btnContaPoupana.setBounds(20, 157, 135, 23);
		frmTelaTipoDe.getContentPane().add(btnContaPoupana);
		
		JTextPane txtpnTipoDeConta = new JTextPane();
		txtpnTipoDeConta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtpnTipoDeConta.setBackground(Color.WHITE);
		txtpnTipoDeConta.setText("Tipo de Conta:");
		txtpnTipoDeConta.setBounds(62, 45, 174, 49);
		frmTelaTipoDe.getContentPane().add(txtpnTipoDeConta);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(TelaPreLogin.class.getResource("/Imagens/iconVoltar.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTelaTipoDe.setVisible(false);
				TelaInicial.frame.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 35, 23);
		frmTelaTipoDe.getContentPane().add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaPreLogin.class.getResource("/Imagens/iconListarContas.png")));
		label.setBounds(206, 105, 75, 75);
		frmTelaTipoDe.getContentPane().add(label);
	}
}
