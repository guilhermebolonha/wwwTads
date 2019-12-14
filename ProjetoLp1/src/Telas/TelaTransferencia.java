package Telas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import LP.Conta;
import LP.Transferencia;
import LP.Util;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaTransferencia {

	private JFrame frame;
	private JTextField codContaDestino;
	private JTextField valor;
	private static Conta continha;
	JFrame f;

	/**
	 * Launch the application.
	 */
	public static void transferir(Conta conta) {
		continha = conta;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTransferencia window = new TelaTransferencia();
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
	public TelaTransferencia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 297, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblInsiraAConta = new JLabel("Insira a conta para transfer\u00EAncia");
		
		codContaDestino = new JTextField();
		codContaDestino.setColumns(10);
		
		JLabel lblInsiraOValor = new JLabel("Insira o valor para deposito");
		
		valor = new JTextField();
		valor.setColumns(10);
		
		JLabel lblR = new JLabel("R$");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Conta contaAux3;
				contaAux3 = LP.Util.consultaContaCCSW(TelaInicial.agencia, Integer.valueOf(codContaDestino.getText()));
				if (contaAux3 == null) {					
					contaAux3 = LP.Util.consultaContaPPSW(TelaInicial.agencia, Integer.valueOf(codContaDestino.getText()));
				}

				if (contaAux3 != null) {

					Transferencia operacao3 = new Transferencia(Integer.valueOf(valor.getText()), continha, contaAux3);

					if (operacao3.efetuar()) {
						System.out.println("Efetuado com sucesso");
						f=new JFrame();  
					    JOptionPane.showMessageDialog(f,"Transferência realizada com sucesso!");
						
						frame.setVisible(false);
						TelaCliente tela = new TelaCliente();
						tela.iniciar(continha);
					} else {
						System.err.println("Não foi possivel realizar");
					}

				}
				// Falta Alterar saldo das Contas.
				
			}
		});
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TelaCliente.frmTelaCliente.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(TelaTransferencia.class.getResource("/Imagens/iconVoltar.png")));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInsiraOValor)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(codContaDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblInsiraAConta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(217)))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addComponent(lblR)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(269, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(btnNewButton)
					.addContainerGap(280, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblInsiraAConta)
							.addGap(11)
					.addComponent(codContaDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblInsiraOValor)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblR)
						.addComponent(valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
