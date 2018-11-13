package View;

//import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import Classe.Cliente;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class ViewCadastrar extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textEmail;
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewCadastrar frame = new ViewCadastrar();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ViewCadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("Tela de Cadastro de Cliente");
		setSize(450, 250);
		setLocation(400, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setBounds(97, 11, 241, 40);
		lblCadastrarCliente.setForeground(new Color(0, 0, 128));
		lblCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCadastrarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCadastrarCliente);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(23, 73, 66, 19);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 17));
		getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(23, 109, 66, 21);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		getContentPane().add(lblEmail);
		
		textNome = new JTextField();
		textNome.setBounds(92, 75, 284, 20);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(92, 112, 284, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(92, 148, 111, 33);
		btnCadastrar.addActionListener(arg0 -> {
			
			String nome = textNome.getText();
			String email = textEmail.getText();
			
			if(textNome.getText().trim().isEmpty()) {
				textNome.setText(null);
				textNome.requestFocus();
				JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
				
			}else if(textEmail.getText().trim().isEmpty()) {
				textEmail.setText(null);
				textEmail.requestFocus();
				JOptionPane.showMessageDialog(null, "Preencha o E-mail do Cliente");
			
			}else {
				Cliente cliente = new Cliente(nome, email);
				clientes.add(cliente);
				
				JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " cadastrado com sucesso");
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(btnCadastrar);
		
		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ViewListar mViewListar = new ViewListar(clientes);
				
				
				mViewListar.setVisible(true);
				
				
				
				
			}
		});
		btnListarClientes.setBounds(213, 148, 163, 33);
		btnListarClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(btnListarClientes);
		
	
		

		

	}
}
