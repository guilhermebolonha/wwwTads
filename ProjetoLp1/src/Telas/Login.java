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

public class Login {

	private JFrame frame;
	private JTextField num_conta;
	private JTextField num_senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setForeground(new Color(255, 153, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Desktop\\sacodinheiro.png"));
		frame.setBounds(100, 100, 387, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton entrar = new JButton("entrar");
		entrar.setBounds(113, 256, 89, 23);
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblConta = new JLabel("conta");
		lblConta.setBounds(58, 187, 46, 14);
		
		JLabel lblSenha = new JLabel("senha");
		lblSenha.setBounds(58, 228, 46, 14);
		
		num_conta = new JTextField();
		num_conta.setBounds(113, 184, 195, 20);
		num_conta.setColumns(10);
		
		num_senha = new JTextField();
		num_senha.setBounds(114, 225, 194, 20);
		num_senha.setColumns(10);
		
		JButton esqueceu_senha = new JButton("esqueceu a senha");
		esqueceu_senha.setFont(new Font("Trebuchet MS", Font.PLAIN, 9));
		esqueceu_senha.setBounds(113, 318, 136, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(entrar);
		frame.getContentPane().add(lblConta);
		frame.getContentPane().add(lblSenha);
		frame.getContentPane().add(num_conta);
		frame.getContentPane().add(num_senha);
		frame.getContentPane().add(esqueceu_senha);
		
		JLabel label = new JLabel("");
		label.setBounds(137, 137, 96, -75);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(163, 78, 46, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(58, 42, 104, 93);
		frame.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Login.class.getResource("/imagens/login.png")));
		label_3.setBounds(133, 48, 100, 100);
		frame.getContentPane().add(label_3);
	}
}