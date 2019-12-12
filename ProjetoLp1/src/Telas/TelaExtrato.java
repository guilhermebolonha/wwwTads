package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import LP.Conta;

import javax.swing.AbstractListModel;

public class TelaExtrato {

	public JFrame frmTelaExtrato;
	private static Conta continha;

	/**
	 * Launch the application.
	 */
	public static void extrato(Conta conta) {
		continha = conta;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExtrato window = new TelaExtrato();
					window.frmTelaExtrato.setVisible(true);
					window.frmTelaExtrato.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExtrato() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaExtrato = new JFrame();
		frmTelaExtrato.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frmTelaExtrato.setTitle("Tela Extrato");
		frmTelaExtrato.getContentPane().setBackground(Color.WHITE);
		frmTelaExtrato.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTelaExtrato.setVisible(false);
				TelaCliente tela = new TelaCliente();
				tela.iniciar(continha);			}
		});
		button.setIcon(new ImageIcon(TelaExtrato.class.getResource("/Imagens/iconVoltar.png")));
		button.setBounds(29, 27, 49, 23);
		frmTelaExtrato.getContentPane().add(button);
		
		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {continha.extrato()};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		//Falta Instanciar A Lista COm o Extrato Do Cliente
		
		
		list.setBounds(10, 73, 232, 145);
		frmTelaExtrato.getContentPane().add(list);
		frmTelaExtrato.setBounds(100, 100, 450, 300);
		frmTelaExtrato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
