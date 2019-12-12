package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LP.Conta;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaCliente {

	public static JFrame frmTelaCliente;
	private static Conta continha;

	/**
	 * Launch the application.
	 */
	public static void iniciar(Conta conta) {
		continha = conta;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente window = new TelaCliente();
					window.frmTelaCliente.setVisible(true);
					window.frmTelaCliente.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCliente = new JFrame();
		frmTelaCliente.setResizable(false);
		frmTelaCliente.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaCliente.setTitle("Tela Cliente");
		frmTelaCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frmTelaCliente.setBounds(100, 100, 384, 362);
		frmTelaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCliente.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Saque");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSaque.sacar(continha);
				frmTelaCliente.setVisible(false);
			}
		});
		btnNewButton.setBounds(215, 40, 107, 23);
		frmTelaCliente.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Transferencia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTransferencia.transferir();
				frmTelaCliente.setVisible(false);

			}
		});
		btnNewButton_1.setBounds(215, 74, 107, 23);
		frmTelaCliente.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Deposito");
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaDeposito.depositar();
				frmTelaCliente.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(215, 108, 107, 23);
		frmTelaCliente.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Extrato");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExtrato.extrato();
				frmTelaCliente.setVisible(false);

			}
		});
		btnNewButton_3.setBounds(215, 142, 107, 23);
		frmTelaCliente.getContentPane().add(btnNewButton_3);

		JLabel lblNomeCliente = new JLabel("Nome Cliente" + continha.getCliente().getNome()); 
		lblNomeCliente.setBounds(22, 215, 89, 14);
		frmTelaCliente.getContentPane().add(lblNomeCliente);

		JLabel lblSaldo = new JLabel("Saldo: R$" + continha.getSaldo());
		lblSaldo.setBounds(22, 234, 96, 14);
		frmTelaCliente.getContentPane().add(lblSaldo);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Desktop\\iconPerson.png"));
		label.setBounds(34, 63, 125, 125);
		frmTelaCliente.getContentPane().add(label);

		JButton btnSairDaConta = new JButton("Sair da Conta");
		btnSairDaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTelaCliente.dispose();
				Login.frame.setVisible(true);
			}
		});
		btnSairDaConta.setBounds(197, 255, 125, 23);
		frmTelaCliente.getContentPane().add(btnSairDaConta);
	}
}
