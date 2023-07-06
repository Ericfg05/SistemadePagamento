package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexão.Conexao;
import model.Usuario;

public class DaoUsuario {
		private static Connection conexao = Conexao.getConexao();

		public static Usuario inserir( Usuario usuario) {


			String sql = "INSERT INTO Usuario (usuario,senha) VALUES (?,?)";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getSenha());
				stmt.execute();
				
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next();
				usuario.setId(rs.getInt(1));
				
				stmt.close();
				return usuario;
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		public ResultSet autenticarUsuario(Usuario usuario) {
			try {
				String sql = "SELECT * FROM Usuario WHERE nome = ? and senha = ?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1,usuario.getNome());
				stmt.setString(2, usuario.getSenha()); 
				ResultSet rs = stmt.executeQuery();
				
				
				return rs;
			}catch (SQLException erro) {
				JOptionPane.showMessageDialog(null,"DaoUsuario: " + erro);
			}
			return null;
			}
		
		public Usuario buscarPorId(int id) {
			String sql = "SELECT * FROM Usuario WHERE id = ?";
			
			try {
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1,id);
				
				ResultSet rs = stmt.executeQuery();
				
				rs.next();
				
				Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"),rs.getString("senha"));
				
				return usuario;	
			}catch (Exception e) {
				
				throw new RuntimeException();
			}
			
			}
			

		public static ArrayList<Usuario> listarTodos() {
			String sql = "SELECT * FROM Usuario";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				ArrayList<Usuario> usuarios = new ArrayList<>();
				while (rs.next()) {
					Usuario a = new Usuario(rs.getInt("id"), rs.getString("nome"),rs.getString("senha"));
					usuarios.add(a);
				}
				stmt.close();
				return usuarios;
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
	}



