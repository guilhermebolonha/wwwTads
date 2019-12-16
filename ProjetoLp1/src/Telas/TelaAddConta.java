package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import LP.Agencia;
import LP.Cliente;
import LP.ContaCorrente;
import LP.ContaPoupanca;
import LP.HandlerAgencia;
import LP.HandlerCliente;
import LP.Principal;
import LP.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaAddConta {

	private JFrame frmNewConta;
	private JTextField saldoIni;
	private JTextField cpf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField senha;
	JFrame f;
	
	 

	/**
	 * Launch the application.
	 */
	public static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddConta window = new TelaAddConta();
					window.frmNewConta.setVisible(true);
					window.frmNewConta.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAddConta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewConta = new JFrame();
		frmNewConta.setResizable(false);
		frmNewConta.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAddConta.class.getResource("/Imagens/iconBank.png")));
		frmNewConta.getContentPane().setBackground(Color.WHITE);
		frmNewConta.setTitle("New Conta");
		frmNewConta.setBounds(100, 100, 288, 316);
		frmNewConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewConta.getContentPane().setLayout(null);
		
		saldoIni = new JTextField();
		saldoIni.setBounds(118, 185, 86, 20);
		frmNewConta.getContentPane().add(saldoIni);
		saldoIni.setColumns(10);
		
		JLabel lblSaldoInicial = new JLabel("Saldo Inicial");
		lblSaldoInicial.setBounds(49, 185, 78, 20);
		frmNewConta.getContentPane().add(lblSaldoInicial);
		
		JLabel lblNewLabel = new JLabel("Tipo de Conta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 40, 169, 27);
		frmNewConta.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnContaPoupana = new JRadioButton("Conta Poupan\u00E7a");
		buttonGroup.add(rdbtnContaPoupana);
		rdbtnContaPoupana.setBounds(18, 74, 109, 23);
		frmNewConta.getContentPane().add(rdbtnContaPoupana);
		
		JRadioButton rdbtnContaCorrente = new JRadioButton("Conta Corrente");
		buttonGroup.add(rdbtnContaCorrente);
		rdbtnContaCorrente.setBounds(18, 100, 109, 23);
		frmNewConta.getContentPane().add(rdbtnContaCorrente);
		if (rdbtnContaCorrente.isSelected()) {
			TelaGerente.iniciar();
			frmNewConta.setVisible(false);
		}
		
		
		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente");
		lblCpfDoCliente.setBounds(36, 147, 91, 27);
		frmNewConta.getContentPane().add(lblCpfDoCliente);
		
		cpf = new JTextField();
		cpf.setBounds(118, 150, 109, 20);
		frmNewConta.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaAddConta.class.getResource("/Imagens/iconAdd.png")));
		lblNewLabel_1.setBounds(162, 25, 75, 75);
		frmNewConta.getContentPane().add(lblNewLabel_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Verificar e salvar a nova Conta 
				
				if(rdbtnContaPoupana.isSelected()) {
					if (!Principal.listaCliente.isEmpty()) {

						Cliente cliente = HandlerCliente.consultarCliente(cpf.getText());
						Agencia agencia = TelaInicial.agencia;

						if (cliente != null && agencia != null) {

							ContaPoupanca contaAux = new ContaPoupanca(Double.valueOf(saldoIni.getText()), 0.05, cliente, senha.getText());

							agencia.inserirConta(contaAux);

							System.out.println(agencia.lstContas.toString());
							
							f=new JFrame();  
						    JOptionPane.showMessageDialog(f,"Conta cadastrada com sucesso!");
							
							TelaGerente.frmTelaGerente.setVisible(true);
							frmNewConta.setVisible(false);
						}
					}
				}else if(rdbtnContaCorrente.isSelected()) {
					
					if (!Principal.listaCliente.isEmpty()) {

						Cliente cliente = HandlerCliente.consultarCliente(cpf.getText());
						Agencia agencia = TelaInicial.agencia;

						if (cliente != null && agencia != null) {

							ContaCorrente contaAux = new ContaCorrente(Double.valueOf(saldoIni.getText()), 150, cliente, senha.getText());

							agencia.inserirConta(contaAux);
							System.out.println("Conta Criada\n");
							
							f=new JFrame();  
						    JOptionPane.showMessageDialog(f,"Conta cadastrada com sucesso!");
							
							TelaGerente.frmTelaGerente.setVisible(true);
							frmNewConta.setVisible(false);

						}
					}

					
				}
				
				
				
				
			}
		});
		btnOk.setBounds(83, 247, 89, 23);
		frmNewConta.getContentPane().add(btnOk);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaGerente.frmTelaGerente.setVisible(true);
				frmNewConta.setVisible(false);
				
			}
		});
		button.setIcon(new ImageIcon(TelaAddConta.class.getResource("/Imagens/iconVoltar.png")));
		button.setBounds(26, 11, 45, 23);
		frmNewConta.getContentPane().add(button);
		
		senha = new JTextField();
		senha.setBounds(118, 216, 86, 20);
		frmNewConta.getContentPane().add(senha);
		senha.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(73, 216, 78, 20);
		frmNewConta.getContentPane().add(lblSenha);
	}
}
