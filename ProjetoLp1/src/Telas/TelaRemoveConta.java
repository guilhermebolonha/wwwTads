package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import LP.HandlerConta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaRemoveConta {

	private JFrame frame;
	private JTextField textField;
	
	int numConta;

	/**
	 * Launch the application.
	 */
	public static void remover() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoveConta window = new TelaRemoveConta();
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
	public TelaRemoveConta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaRemoveConta.class.getResource("/Imagens/iconRemove.png")));
		label.setBounds(183, 38, 75, 75);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(183, 174, 119, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta a Remover");
		lblNumeroDaConta.setBounds(22, 177, 140, 14);
		frame.getContentPane().add(lblNumeroDaConta);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Verificar a conta a remover e removela
				
				if(HandlerConta.removeConta())
					System.out.println("Conta removida");
				else
					System.out.println("Conta não removida");
				
				frame.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);
			}
		});
		btnRemover.setBounds(95, 289, 89, 23);
		frame.getContentPane().add(btnRemover);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(TelaRemoveConta.class.getResource("/Imagens/iconVoltar.png")));
		button.setBounds(31, 38, 45, 23);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 391, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
