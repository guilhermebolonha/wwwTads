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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import LP.Cliente;
import LP.HandlerCliente;

public class TelaAddCLiente {

	public static JFrame frmNewClient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JFrame f;

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
				.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAddCLiente.class.getResource("/Imagens/iconBank.png")));
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

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewClient.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaAddCLiente.class.getResource("/Imagens/iconVoltar.png")));
		btnNewButton.setBounds(23, 23, 46, 23);
		frmNewClient.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = textField.getText();
				clientinho.setNome(nome);
				CPF = textField_1.getText();
				clientinho.setCpf(CPF);
				endereco = textField_2.getText();
				clientinho.setEndereco(endereco);
				
				System.out.println(nome+"    " + CPF+ "     " + endereco);
				if (HandlerCliente.cadastrarCliente(nome, CPF, endereco)) {
					System.out.println("Cliente cadastrado com sucesso!");
					f=new JFrame();  
				    JOptionPane.showMessageDialog(f,"Cliente cadastrado com sucesso!");  
				    frmNewClient.setVisible(false);
				    TelaGerente.frmTelaGerente.setVisible(true);
				}else {
					System.out.println("Cliente não cadastrado.");
				}


			}
		});
		btnNewButton_1.setBounds(114, 311, 85, 23);
		frmNewClient.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(23, 165, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(23, 196, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setBounds(10, 227, 46, 14);
		frmNewClient.getContentPane().add(lblNewLabel_2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaAddCLiente.class.getResource("/Imagens/iconAddPerson.png")));
		label.setBounds(114, 53, 75, 75);
		frmNewClient.getContentPane().add(label);
	}
}
