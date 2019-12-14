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

import LP.HandlerAgencia;
import LP.HandlerArquivo;
import LP.Principal;

public class TelaGerente {

	public static JFrame frmTelaGerente;
	JFrame f;  

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
		frmTelaGerente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerente.class.getResource("/Imagens/iconBank.png")));
		frmTelaGerente.setBounds(100, 100, 409, 654);
		frmTelaGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAddClient = new JButton("Add Cliente");
		btnAddClient.setBounds(44, 166, 105, 23);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAddCLiente tela = new TelaAddCLiente();
				tela.main(null);
				frmTelaGerente.setVisible(false);
				
			}
		});
		frmTelaGerente.getContentPane().setLayout(null);
		frmTelaGerente.getContentPane().add(btnAddClient);
		
		JButton btnAddContas = new JButton("Add Contas");
		btnAddContas.setBounds(217, 166, 105, 23);
		btnAddContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAddConta tela = new TelaAddConta();
				tela.iniciar();
				frmTelaGerente.setVisible(false);
			}
		});
		frmTelaGerente.getContentPane().add(btnAddContas);
		
		JButton btnRemoveCliente = new JButton("Remover Cliente");
		btnRemoveCliente.setBounds(44, 292, 127, 23);
		btnRemoveCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoveCliente.remover();
				frmTelaGerente.setVisible(false);
			}
		});
		btnRemoveCliente.setIcon(null);
		frmTelaGerente.getContentPane().add(btnRemoveCliente);
		
		JButton btnNewButton = new JButton("Remover Conta");
		btnNewButton.setBounds(217, 292, 127, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoveConta.remover();
				frmTelaGerente.setVisible(false);
			}
		});
		frmTelaGerente.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(54, 83, 75, 75);
		label.setIcon(new ImageIcon(TelaGerente.class.getResource("/Imagens/iconAddPerson.png")));
		frmTelaGerente.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(227, 83, 75, 75);
		label_1.setIcon(new ImageIcon("C:\\Users\\Hiago Brazzali\\Documents\\wwwTads\\ProjetoLp1\\src\\Imagens\\iconAdd.png"));
		frmTelaGerente.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(54, 206, 75, 75);
		label_2.setIcon(new ImageIcon(TelaGerente.class.getResource("/Imagens/iconRemovePerson.png")));
		frmTelaGerente.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(227, 206, 75, 75);
		label_3.setIcon(new ImageIcon(TelaGerente.class.getResource("/Imagens/iconRemove.png")));
		frmTelaGerente.getContentPane().add(label_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(10, 11, 41, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HandlerArquivo.gravaObj(TelaInicial.agencia.lstContas, "agencia");
				HandlerArquivo.gravaObj(Principal.listaGerente, "gerente");
				HandlerArquivo.gravaObj(Principal.listaCliente, "cliente");
				HandlerArquivo.gravaObj(Principal.listaFuncionario, "funcionario");
				
				frmTelaGerente.setVisible(false);
				TelaInicial.frame.setVisible(true);
			}
		});
		btnNewButton_1.setSelectedIcon(null);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(TelaGerente.class.getResource("/Imagens/iconVoltar.png")));
		frmTelaGerente.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listar Clientes");
		btnNewButton_2.setBounds(54, 447, 105, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaClientes.listar();
				frmTelaGerente.setVisible(false);
			}
		});
		frmTelaGerente.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Listar Contas");
		btnNewButton_3.setBounds(227, 447, 105, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaContas.listar();
				frmTelaGerente.setVisible(false);
				
			}
		});
		frmTelaGerente.getContentPane().add(btnNewButton_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(54, 361, 75, 75);
		label_4.setIcon(new ImageIcon(TelaGerente.class.getResource("/Imagens/iconListarPerson.png")));
		frmTelaGerente.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(227, 361, 75, 75);
		label_5.setIcon(new ImageIcon(TelaGerente.class.getResource("/Imagens/iconListarContas.png")));
		frmTelaGerente.getContentPane().add(label_5);
		
		JButton btnVirarOMs = new JButton("Virar o M\u00EAs");
		btnVirarOMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HandlerAgencia.aplicaViraMes(TelaInicial.agencia);
				
				f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Mês virado com sucesso!");  
			}
		});
		btnVirarOMs.setBounds(145, 533, 105, 23);
		frmTelaGerente.getContentPane().add(btnVirarOMs);
	}
}
