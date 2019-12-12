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
		
		
//		listaAgencia = HandlerArquivo.lerObj("agencia");
//		listaGerente = HandlerArquivo.lerObj("gerente");
//		listaCliente = HandlerArquivo.lerObj("cliente");
//		listaFuncionario = HandlerArquivo.lerObj("funcionario");
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel lblIconbankpng = new JLabel("");
		lblIconbankpng.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/iconBank.png")));
		lblIconbankpng.setBounds(20, 40, 128, 128);
		frame.getContentPane().add(lblIconbankpng);

		JLabel lblBemVindoAo = new JLabel("Bem Vindo Ao BanQuinho");
		lblBemVindoAo.setFont(new Font("Vijaya", Font.PLAIN, 30));
		lblBemVindoAo.setBounds(158, 40, 266, 32);
		frame.getContentPane().add(lblBemVindoAo);

		JButton btnNewButton = new JButton("Gerente");
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaGerente.iniciar();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(192, 305, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JTextPane txtpnGerarSoluesFinanceiras = new JTextPane();
		txtpnGerarSoluesFinanceiras.setFont(new Font("Vijaya", Font.PLAIN, 15));
		txtpnGerarSoluesFinanceiras.setText(
				"Miss\u00E3o: Gerar solu\u00E7\u00F5es financeiras por meio do cooperativismo, \u00E0 todos associados e clientes.");
		txtpnGerarSoluesFinanceiras.setBounds(192, 83, 207, 61);
		frame.getContentPane().add(txtpnGerarSoluesFinanceiras);

		JTextPane txtpnTransparnciaComprometimentoRespeito = new JTextPane();
		txtpnTransparnciaComprometimentoRespeito.setFont(new Font("Vijaya", Font.PLAIN, 15));
		txtpnTransparnciaComprometimentoRespeito.setText(
				"Valores: Transpar\u00EAncia Comprometimento Respeito           \u00C9tica        Solidariedade Responsabilidade");
		txtpnTransparnciaComprometimentoRespeito.setBounds(192, 141, 102, 119);
		frame.getContentPane().add(txtpnTransparnciaComprometimentoRespeito);

		JTextPane txtpnRuaTal = new JTextPane();
		txtpnRuaTal
				.setText("Rua Tal numero tal    CEp Tal                 Tel:(00) 9000-000  Email: banquinho@bmail.com");
		txtpnRuaTal.setBounds(26, 197, 122, 89);
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
		frame.setBounds(100, 100, 469, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
