package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import LP.Cliente;
import LP.HandlerCliente;

public class TelaAddCLiente {

	public static JFrame frmNewClient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	Cliente clientinho = new Cliente();
	String nome, CPF, endereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddCLiente window = new TelaAddCLiente();
					window.frmNewClient.setVisible(true);
					window.frmNewClient.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAddCLiente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewClient = new JFrame();
		frmNewClient.getContentPane().setBackground(Color.WHITE);
		frmNewClient.setTitle("New Client");
		frmNewClient
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Desktop\\iconBank.png"));
		frmNewClient.setBounds(100, 100, 311, 491);
		frmNewClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewClient.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(90, 162, 160, 20);
		frmNewClient.getContentPane().add(textField);
		textField.setColumns(10);
		

		textField_1 = new JTextField();
		textField_1.setBounds(90, 193, 160, 20);
		frmNewClient.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		textField_2 = new JTextField();
		textField_2.setBounds(90, 224, 160, 20);
		frmNewClient.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	

		textField_3 = new JTextField();
		textField_3.setBounds(90, 313, 136, 20);
		frmNewClient.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewClient.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Desktop\\iconVoltar.png"));
		btnNewButton.setBounds(23, 23, 46, 23);
		frmNewClient.getContentPane().add(btnNewButton);
		
		
		nome = textField.getText();
		clientinho.setNome(nome);
		CPF = textField_1.getText();
		clientinho.setCpf(CPF);
		endereco= textField_2.getText();
		clientinho.setEndereco(endereco);

		JButton btnNewButton_1 = new JButton("ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(nome + CPF + endereco);
				if(HandlerCliente.cadastrarCliente(clientinho))
					 System.out.println("Cliente cadastrado com sucesso!");
					else
					System.out.println("Cliente não cadastrado.");
				

				frmNewClient.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(102, 391, 85, 23);
		frmNewClient.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("nome");
		lblNewLabel.setBounds(23, 165, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cpf");
		lblNewLabel_1.setBounds(23, 196, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("endere\u00E7o");
		lblNewLabel_2.setBounds(23, 227, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setBounds(23, 316, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("senha");
		lblNewLabel_4.setBounds(23, 347, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBounds(90, 344, 136, 20);
		frmNewClient.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Desktop\\iconAddPerson.png"));
		label.setBounds(114, 53, 75, 75);
		frmNewClient.getContentPane().add(label);
	}
}
