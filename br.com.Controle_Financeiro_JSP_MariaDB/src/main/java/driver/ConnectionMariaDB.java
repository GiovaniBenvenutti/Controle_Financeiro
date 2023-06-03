package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// se ta dando erro nos import tem que ir no BUILD PATH emudar a versão do JAVA pra 1.8  ! ! ! 


public class ConnectionMariaDB {

	private static String serverName = "localHost"; // se o banco fosse em outra maquina o nome do server 
								// seria o IP da maquina servidor.
	
	private static String dataBase = "controlefinanceirobd";  // colocar aqui o nome do banco de dados 
	private static String url = "jdbc:mariadb://" + serverName + "/" + dataBase;
	private static String userName = "root";
	private static String passWord = "1723";

	public static Connection conectar() throws SQLException {

		try {
			String driverName = "org.mariadb.jdbc.Driver";
			Class.forName(driverName);
			Connection retornoConexao = DriverManager.getConnection(url, userName, passWord);
			return retornoConexao;

		} catch (ClassNotFoundException e) {
			System.out.println("O driver especifico não foi encontrado.");
		}
		return null;
	}
}
