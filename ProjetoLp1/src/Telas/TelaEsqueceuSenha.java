package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaEsqueceuSenha {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEsqueceuSenha window = new TelaEsqueceuSenha();
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
	public TelaEsqueceuSenha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// conferir e confirmar a atualisaçao de senha e login

				frame.setVisible(false);
				Login.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(147, 246, 89, 23);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(147, 201, 124, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNovaSenha = new JLabel("Nova Senha");
		lblNovaSenha.setBounds(52, 204, 67, 14);
		frame.getContentPane().add(lblNovaSenha);

		// Conferir e confirmar a nova senha

		JLabel lblLoginDeUsuario = new JLabel("Login de Usuario");
		lblLoginDeUsuario.setBounds(52, 175, 89, 14);
		frame.getContentPane().add(lblLoginDeUsuario);

		// Conferir e confirmar o novo Usuario

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 170, 124, 20);
		frame.getContentPane().add(textField_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Desktop\\iconPerson.png"));
		label.setBounds(147, 26, 125, 125);
		frame.getContentPane().add(label);

		JLabel lblLoginAntigo = new JLabel("Login Antigo" + ""); // Mostrar o Login Antido do Cliente
		lblLoginAntigo.setBounds(52, 103, 85, 14);
		frame.getContentPane().add(lblLoginAntigo);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login.frame.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(
				"C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconVoltar.png"));
		button.setBounds(10, 11, 47, 23);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 328, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
