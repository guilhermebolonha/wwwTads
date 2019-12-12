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

public class TelaGerente {

	public static JFrame frmTelaGerente;

	/**
	 * Launch the application.
	 */
	public static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerente window = new TelaGerente();
					window.frmTelaGerente.setVisible(true);
					window.frmTelaGerente.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaGerente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaGerente = new JFrame();
		frmTelaGerente.setResizable(false);
		frmTelaGerente.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaGerente.setTitle("Tela Gerente");
		frmTelaGerente.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frmTelaGerente.setBounds(100, 100, 409, 654);
		frmTelaGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaGerente.getContentPane().setLayout(null);
		
		JButton btnAddClient = new JButton("add Cliente");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAddCLiente tela = new TelaAddCLiente();
				tela.main(null);
				frmTelaGerente.setVisible(false);
				
			}
		});
		btnAddClient.setBounds(44, 166, 105, 23);
		frmTelaGerente.getContentPane().add(btnAddClient);
		
		JButton btnAddContas = new JButton("add Contas");
		btnAddContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAddConta tela = new TelaAddConta();
				tela.iniciar();
				frmTelaGerente.setVisible(false);
			}
		});
		btnAddContas.setBounds(217, 166, 105, 23);
		frmTelaGerente.getContentPane().add(btnAddContas);
		
		JButton btnRemoveCliente = new JButton("remove Cliente");
		btnRemoveCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoveCliente.remover();
				frmTelaGerente.setVisible(false);
			}
		});
		btnRemoveCliente.setIcon(null);
		btnRemoveCliente.setBounds(44, 292, 105, 23);
		frmTelaGerente.getContentPane().add(btnRemoveCliente);
		
		JButton btnNewButton = new JButton("remove Conta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoveConta.remover();
				frmTelaGerente.setVisible(false);
			}
		});
		btnNewButton.setBounds(217, 292, 105, 23);
		frmTelaGerente.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Carregar Dados");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Carregar os DAdos 
				
			}
		});
		btnUpdate.setBounds(112, 563, 131, 23);
		frmTelaGerente.getContentPane().add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconAddPerson.png"));
		label.setBounds(54, 83, 75, 75);
		frmTelaGerente.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconAdd.png"));
		label_1.setBounds(227, 83, 75, 75);
		frmTelaGerente.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconRemovePerson.png"));
		label_2.setBounds(54, 206, 75, 75);
		frmTelaGerente.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconRemove.png"));
		label_3.setBounds(227, 206, 75, 75);
		frmTelaGerente.getContentPane().add(label_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTelaGerente.setVisible(false);
				TelaInicial.frame.setVisible(true);
			}
		});
		btnNewButton_1.setSelectedIcon(null);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(TelaGerente.class.getResource("/Imagens/iconVoltar.png")));
		btnNewButton_1.setBounds(10, 11, 41, 23);
		frmTelaGerente.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("listar Clientes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaClientes.listar();
				frmTelaGerente.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(44, 447, 105, 23);
		frmTelaGerente.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("listar Contas");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaContas.listar();
				frmTelaGerente.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(217, 447, 105, 23);
		frmTelaGerente.getContentPane().add(btnNewButton_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconListarPerson.png"));
		label_4.setBounds(54, 361, 75, 75);
		frmTelaGerente.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconListarContas.png"));
		label_5.setBounds(227, 361, 75, 75);
		frmTelaGerente.getContentPane().add(label_5);
		
		JButton btnSalvarDados = new JButton("Salvar Dados");
		btnSalvarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Salvar os Dados
			}
		});
		btnSalvarDados.setBounds(112, 529, 131, 23);
		frmTelaGerente.getContentPane().add(btnSalvarDados);
	}

}
