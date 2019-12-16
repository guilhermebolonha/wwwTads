package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import LP.Agencia;
import LP.Gerente;
import LP.HandlerArquivo;
import LP.Principal;

public class TelaInicial {

	
//	public static Agencia agencia;
	
	public static Agencia agencia = new Agencia("Santa Teresa");

	public static Gerente gerente = new Gerente("1234", agencia);

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		
		
//		Principal.listaAgencia = HandlerArquivo.lerObj("agencia");
//		Principal.listaGerente = HandlerArquivo.lerObj("gerente");
//		Principal.listaCliente = HandlerArquivo.lerObj("cliente");
//		Principal.listaFuncionario = HandlerArquivo.lerObj("funcionario");
//		
//		agencia = Principal.listaAgencia.get(0);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/Imagens/iconBank.png")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel lblIconbankpng = new JLabel("");
		lblIconbankpng.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/iconBank.png")));
		lblIconbankpng.setBounds(20, 40, 128, 128);
		frame.getContentPane().add(lblIconbankpng);

		JLabel lblBemVindoAo = new JLabel("Bem Vindo Ao BanQuinho");
		lblBemVindoAo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 32));
		lblBemVindoAo.setBounds(158, 40, 318, 32);
		frame.getContentPane().add(lblBemVindoAo);

		JButton btnNewButton = new JButton("Gerente");
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLoginGerente.iniciar();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(192, 305, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JTextPane txtpnGerarSoluesFinanceiras = new JTextPane();
		txtpnGerarSoluesFinanceiras.setFont(new Font("Vijaya", Font.PLAIN, 15));
		txtpnGerarSoluesFinanceiras.setText(
				"Miss\u00E3o: Gerar solu\u00E7\u00F5es financeiras por meio do cooperativismo, \u00E0 todos associados e clientes.");
		txtpnGerarSoluesFinanceiras.setBounds(192, 83, 174, 61);
		frame.getContentPane().add(txtpnGerarSoluesFinanceiras);

		JTextPane txtpnTransparnciaComprometimentoRespeito = new JTextPane();
		txtpnTransparnciaComprometimentoRespeito.setFont(new Font("Vijaya", Font.PLAIN, 15));
		txtpnTransparnciaComprometimentoRespeito.setText(
		"Valores: Transparencia\nComprometimento\nRespeito\nEtica\nSolidariedade\nResponsabilidade");
		txtpnTransparnciaComprometimentoRespeito.setBounds(192, 153, 135, 119);
		frame.getContentPane().add(txtpnTransparnciaComprometimentoRespeito);

		JTextPane txtpnRuaTal = new JTextPane();
		txtpnRuaTal
				.setText("Rua Tal\nnumero tal\nCEp Tal\nTel:(00) 9000-000\nEmail: banquinho@bmail.com\nAgencia-" + agencia.getNome());
		txtpnRuaTal.setBounds(26, 197, 156, 131);
		frame.getContentPane().add(txtpnRuaTal);

		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPreLogin.iniciar();
				frame.setVisible(false);

			}
		});
		btnCliente.setBounds(310, 305, 89, 23);
		frame.getContentPane().add(btnCliente);

		JLabel label = new JLabel();
		label.setBounds(20, 290, 122, 38);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 559, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
