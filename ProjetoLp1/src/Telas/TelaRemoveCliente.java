package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoveCliente {

	private JFrame frmRemoveCliente;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void remover() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoveCliente window = new TelaRemoveCliente();
					window.frmRemoveCliente.setVisible(true);
					window.frmRemoveCliente.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoveCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRemoveCliente = new JFrame();
		frmRemoveCliente.setTitle("Remove Cliente");
		frmRemoveCliente.getContentPane().setBackground(Color.WHITE);
		frmRemoveCliente.getContentPane().setLayout(null);

		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente");
		lblCpfDoCliente.setBounds(27, 169, 89, 14);
		frmRemoveCliente.getContentPane().add(lblCpfDoCliente);

		textField = new JTextField();
		textField.setBounds(126, 166, 120, 20);
		frmRemoveCliente.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\20181tadst0330\\Desktop\\iconRemovePerson.png"));
		label.setBounds(104, 49, 75, 75);
		frmRemoveCliente.getContentPane().add(label);

		JButton btnK = new JButton("ok");
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar o cliente a remover e removelo

				frmRemoveCliente.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);
			}
		});
		btnK.setBounds(90, 216, 89, 23);
		frmRemoveCliente.getContentPane().add(btnK);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRemoveCliente.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(
				"C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconVoltar.png"));
		button.setBounds(24, 11, 47, 23);
		frmRemoveCliente.getContentPane().add(button);
		frmRemoveCliente
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20181tadst0330\\Desktop\\iconBank.png"));
		frmRemoveCliente.setBounds(100, 100, 295, 316);
		frmRemoveCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
