package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;

import LP.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.AbstractListModel;

public class TelaListaClientes {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void listar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaClientes window = new TelaListaClientes();
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
	public TelaListaClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\20181tadst0330\\Documents\\wwwTads-dev\\wwwTads-dev\\ProjetoLp1\\src\\imagens\\iconBank.png"));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerente.frmTelaGerente.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaListaClientes.class.getResource("/Imagens/iconVoltar.png")));
		btnNewButton.setBounds(22, 11, 49, 23);
		frame.getContentPane().add(btnNewButton);

		JList<Object> list = new JList<Object>();
		list.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {Principal.listaCliente.toString()};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(70, 73, 277, 178);
		frame.getContentPane().add(list);

		// lISTAR OS CLIENTES DA AGENCIA

	}

}
