package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classe.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewListar extends JFrame {
	
	
	DefaultTableModel dtm; 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListar frame = new ViewListar(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewListar(ArrayList<Cliente> clientes) {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeClientes = new JLabel("Lista de Clientes");
		lblListaDeClientes.setForeground(new Color(0, 0, 128));
		lblListaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListaDeClientes.setBounds(116, 0, 220, 45);
		contentPane.add(lblListaDeClientes);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		dtm  = (DefaultTableModel) table.getModel();

		dtm.addColumn("ID");
		dtm.addColumn("Nome");
		dtm.addColumn("E-mail");
		
		for (int i = 0; i < clientes.size(); i++) {
			dtm.addRow(new String[] {
				String.valueOf(clientes.get(i).getId()), clientes.get(i).getNome(), clientes.get(i).getEmail() 
			});
		}
		
		
		
	//	dtm.setNumRows(clientes.size());
		
		
		
		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"ID", "Nome", "E-mail"
//			}
//		));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.setBounds(10, 82, 414, 179);
		contentPane.add(table);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(10, 51, 62, 20);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNome.setBounds(106, 51, 62, 19);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(264, 51, 72, 19);
		contentPane.add(lblEmail);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			dtm.removeRow(table.getSelectedRow());
				
			}
		});
		btnExcluir.setBackground(new Color(255, 0, 0));
		btnExcluir.setForeground(new Color(240, 248, 255));
		btnExcluir.setBounds(264, 272, 89, 23);
		contentPane.add(btnExcluir);
	}
}
