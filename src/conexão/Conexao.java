package conexão;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public static final String SERVIDOR = "jdbc:mariadb://localhost:3307/Pagamento";
	public static final String USUARIO = "root";
	public static final String SENHA = "123";

	public static Connection getConexao() {
		try {
			return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
}
