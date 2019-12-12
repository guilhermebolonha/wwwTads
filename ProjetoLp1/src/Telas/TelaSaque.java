package Telas;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import LP.Conta;
import LP.Saque;

public class TelaSaque {

	private JFrame frmSaque;
	private JTextField textSaque;
	private static Conta continha;


	/**
	 * Launch the application.
	 */
	public static void sacar(Conta conta) {
		continha = conta;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSaque window = new TelaSaque();
					window.frmSaque.setVisible(true);
					window.frmSaque.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaSaque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSaque = new JFrame();
		frmSaque.setResizable(false);
		frmSaque.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Desktop\\iconBank.png"));
		frmSaque.setTitle("Saque");
		frmSaque.getContentPane().setBackground(Color.WHITE);
		frmSaque.setBounds(100, 100, 298, 287);
		frmSaque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaque.getContentPane().setLayout(null);
		
		JButton btnSacar = new JButton("ok");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Saque operacao = new Saque(continha, Integer.valueOf(textSaque.getText()));

				if (operacao.efetuar()) {

					System.out.println("Efetuado com sucesso");
					frmSaque.setVisible(false);
					TelaCliente.frmTelaCliente.setVisible(true);

				}else {
					System.err.println("Não foi possivel realizar");
				}
				
				
			}
		});
		btnSacar.setBounds(90, 187, 89, 23);
		frmSaque.getContentPane().add(btnSacar);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frmSaque.setVisible(false);
				TelaCliente.frmTelaCliente.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconVoltar.png"));
		btnVoltar.setBounds(26, 11, 37, 23);
		frmSaque.getContentPane().add(btnVoltar);
		
		textSaque = new JTextField();
		textSaque.setBounds(118, 125, 97, 20);
		frmSaque.getContentPane().add(textSaque);
		textSaque.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Valor a sacar");
		lblNewLabel.setBounds(31, 120, 128, 30);
		frmSaque.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo Atual: R$" + continha.getSaldo() );//Adiciponar Saldo Atual do Cliente
		lblNewLabel_1.setBounds(31, 74, 77, 30);
		frmSaque.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Desktop\\images.png"));
		label.setBounds(154, 21, 75, 75);
		frmSaque.getContentPane().add(label);
	}
}
