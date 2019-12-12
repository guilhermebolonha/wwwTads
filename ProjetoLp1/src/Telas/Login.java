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
import javax.swing.JTextField;

import LP.Conta;

public class Login {

	public static JFrame frame;
	private JTextField num_conta;
	private JTextField num_senha;
	private static int vldConta;

	/**
	 * Launch the application.
	 */
	public static void iniciar(int vldC) {
		vldConta = vldC;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setForeground(new Color(255, 153, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frame.setBounds(100, 100, 387, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton entrar = new JButton("entrar");
		entrar.setBounds(113, 273, 89, 23);
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				switch (vldConta) {
				case 1:
					Conta contaAux1 = LP.Util.consultaContaCSW(TelaInicial.agencia, Integer.valueOf(num_conta.getText()));
					if(contaAux1 != null) {
						TelaCliente telaCliente = new TelaCliente();
						telaCliente.iniciar(contaAux1);
						frame.setVisible(false);
					}
					break;
				case 2:
					Conta contaAux2 = LP.Util.consultaContaPSW(TelaInicial.agencia, Integer.valueOf(num_conta.getText()));
					if(contaAux2 != null) {
						TelaCliente telaCliente = new TelaCliente();
						telaCliente.iniciar(contaAux2);
						frame.setVisible(false);
					}
					break;
				}
				
			}	
		});
		
		JLabel lblConta = new JLabel("conta");
		lblConta.setBounds(58, 187, 46, 14);
		//Conferir a Conta Do Cliente
		
		JLabel lblSenha = new JLabel("senha");
		lblSenha.setBounds(58, 228, 46, 14);
		
		//Conferir a Senha Do Cliente

		//Para entao entrar (Linha 58) nao Conta 
		
		num_conta = new JTextField();
		num_conta.setBounds(113, 184, 195, 20);
		num_conta.setColumns(10);
		
		num_senha = new JTextField();
		num_senha.setBounds(114, 225, 194, 20);
		num_senha.setColumns(10);
		
		JButton esqueceu_senha = new JButton("esqueceu a senha");
		esqueceu_senha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEsqueceuSenha tela = new TelaEsqueceuSenha();
				tela.iniciar();
				frame.setVisible(false);
			}
		});
		esqueceu_senha.setFont(new Font("Trebuchet MS", Font.PLAIN, 9));
		esqueceu_senha.setBounds(113, 325, 136, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(entrar);
		frame.getContentPane().add(lblConta);
		frame.getContentPane().add(lblSenha);
		frame.getContentPane().add(num_conta);
		frame.getContentPane().add(num_senha);
		frame.getContentPane().add(esqueceu_senha);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Imagens/iconPerson.png")));
		label.setBounds(124, 29, 125, 124);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TelaInicial.frame.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/Imagens/iconVoltar.png")));
		btnNewButton.setBounds(25, 26, 46, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
