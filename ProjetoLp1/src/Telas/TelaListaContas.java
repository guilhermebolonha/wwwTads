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

import LP.Principal;

import javax.swing.AbstractListModel;

public class TelaListaContas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void listar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaContas window = new TelaListaContas();
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
	public TelaListaContas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaContas.class.getResource("/Imagens/iconBank.png")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TelaGerente.frmTelaGerente.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(TelaListaContas.class.getResource("/Imagens/iconVoltar.png")));
		button.setBounds(34, 35, 46, 23);
		frame.getContentPane().add(button);

		JList<Object> list = new JList<Object>();
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {TelaInicial.agencia.lstContas.toString()};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(75, 111, 255, 359);
		frame.getContentPane().add(list);
		// Listar  as contas da agencia


		frame.setBounds(100, 100, 450, 591);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
