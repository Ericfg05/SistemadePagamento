package gui;

import java.awt.EventQueue;
import dao.DaoUsuario;
import dao.DaoUsuario;
import model.Usuario;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UsuarioGui {

	private JFrame frame;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGui window = new UsuarioGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UsuarioGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ericf\\Downloads\\Pacote de Icones\\icons 1\\user.png"));
		lblNewLabel.setBounds(31, 69, 95, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setIcon(new ImageIcon("C:\\Users\\ericf\\Downloads\\Pacote de Icones\\icons 1\\key.png"));
		lblSenha.setBounds(31, 131, 95, 16);
		frame.getContentPane().add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(94, 91, 122, 28);
		frame.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(94, 145, 122, 28);
		frame.getContentPane().add(pfSenha);
		DaoUsuario  usuario = new DaoUsuario();
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
				
				
			}
		});
		btnNewButton.setBounds(264, 199, 90, 28);
		frame.getContentPane().add(btnNewButton);
	}
	private void logar() {
		try {
			String usuario = tfUsuario.getText();
			String senha = pfSenha.getText();
			Usuario user = new Usuario(0,usuario,senha);
			DaoUsuario usuarioDao = new DaoUsuario();
			
			ResultSet rsUsuarioDao = usuarioDao.autenticarUsuario(user);
			if (rsUsuarioDao.next()) {
			//Caso der certo chamarar uma tela que eu quero abrir;	
				/*EmprestimoGui emprestimo = new EmprestimoGui();
				emprestimo.setVisible(true);
				dispose();*/
				
			//COLOCAR NOME DA TELA EMPRESTIMO
				
				
				
			}else {
			//Caso der erro tela encorreto (usuario e senha incorreto)	
			JOptionPane.showMessageDialog(null, "Usuario ou senha Incorreto!");	
			
			}
			
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		}
	}
}
