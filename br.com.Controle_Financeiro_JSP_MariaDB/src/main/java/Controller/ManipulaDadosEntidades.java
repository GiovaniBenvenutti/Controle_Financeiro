package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.Entidade;
import driver.ConnectionMariaDB;

public class ManipulaDadosEntidades {
	
	static Scanner scan = new Scanner(System.in);
	
	public void criarEstruturaSeNaoExistirEntidade() throws Exception {
		try {
			//Verificar se a tabela existe. Caso não existir, criar e inserir um usuário padrão.
			if (!tabelaExiste()) {
			
				//Iniciando a conexão com o banco de dados
				Connection connection = ConnectionMariaDB.conectar();
				
				//Comando de criar a tabela
				String comandoSql = "CREATE TABLE IF NOT EXISTS controlefinanceirobd.entidade ("
										+ "idEntidade INT (20) AUTO_INCREMENT NOT NULL,"
										+ "razaoSocial VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
										+ "setor VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
										+ "dre VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
										+ "balanco VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
										+ "presumido VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"	
										+ "parcelas INT (20) NOT NULL,"
										+ "prazo INT (20) NOT NULL,"
									    + "mensal BOOLEAN NOT NULL,"
									    + "PRIMARY KEY (idEntidade))";
				
				//Preparando e executando o comando SQL
				Statement statement = connection.createStatement();
				statement.execute(comandoSql);
	
				//Fechando a conexão com o banco de dados. Nunca esquecer de fazer isso após terminar de utilizar a conexão.
				connection.close();
				
				//Inserindo um usuário padrão para poder entrar no sistema
				
				Entidade entidade = new Entidade();
				entidade.setRazaoSocial("Piante Modas LTDA");
				entidade.setSetor("Matriz");
				entidade.setDre("Lucro");
				entidade.setBalanco("Riquesa");
				entidade.setPresumido("Sucesso");
				entidade.setParcelas(1);
				entidade.setPrazo(1);
				entidade.setMensal(true);
				
				inserir(entidade);
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao criar tabela: " + e.getMessage());
		}

	}
	
	public static void inserirEntidade() {		
		
		System.out.println("Razão Social: ");
		String razaoSocial = scan.next();
		System.out.println("Setor: ");
		String setor = scan.next();
		System.out.println("Dre: ");
		String dre = scan.next();
		System.out.println("Balanço: ");
		String balanco = scan.next();
		System.out.println("Presumi-se: ");
		String presumido = scan.next();
		System.out.println("parcelas: ");
		int parcelas = scan.nextInt();
		System.out.println("Prazo entre parcelas: ");
		int prazo = scan.nextInt();
		System.out.println("Mensal: ");
		boolean mensal = scan.nextBoolean();
		
		Entidade entidade = new Entidade(razaoSocial, setor, dre, balanco, presumido, parcelas, prazo, mensal);
		entidade.setRazaoSocial(razaoSocial);
		entidade.setSetor(setor);
		entidade.setDre(dre);
		entidade.setBalanco(balanco);
		entidade.setPresumido(presumido);
		entidade.setParcelas(parcelas);
		entidade.setPrazo(prazo);
		entidade.setMensal(mensal);
		inserir(entidade);
	}	
	
	public static void inserir(Entidade entidade) {

	//	ConnectionMariaDB conexaoMariaDB = new ConnectionMariaDB();
		try {
			Connection connection = ConnectionMariaDB.conectar();
			String comandoSql = "insert into controlefinanceirobd.entidade " + " (idEntidade, razaoSocial, setor, dre, balanco, presumido, parcelas, prazo, mensal) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement ps = connection.prepareStatement(comandoSql);
			ps.setInt(1, entidade.getIdEntidade());
			ps.setString(2, entidade.getRazaoSocial());
			ps.setString(3, entidade.getSetor());
			ps.setString(4, entidade.getDre());
			ps.setString(5, entidade.getBalanco());
			ps.setString(6, entidade.getPresumido());
			ps.setInt(7, entidade.getParcelas());
			ps.setInt(8, entidade.getPrazo());
			ps.setBoolean(9, entidade.isMensal());

			if (!ps.execute()) {
				System.out.println("Entidade inerida com sucesso");
			}

			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir entidade " + e.getMessage());
		}
	}
	
	public static void listarTodasEntidades() {

	//	ConnectionMariaDB connectionMariaDB = new ConnectionMariaDB();
		try {
			Connection connection = ConnectionMariaDB.conectar();
			String comandoSql = "select idEntidade, razaoSocial, setor, dre, balanco, presumido, parcelas, prazo, mensal "
					+ " from controlefinanceirobd.entidade order by idEntidade";

			PreparedStatement ps = connection.prepareStatement(comandoSql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println("  idEntidade: " + rs.getInt("idEntidade") 
					+ "  razaoSocial: " + rs.getString("razaoSocial") 
					+ "  setor: "	+ rs.getString("setor") 
					+ "  dre: " + rs.getString("dre") 
					+ "  balanco: " + rs.getString("balanco")
					+ "  presumido: " + rs.getString("presumido")
					+ "  parcelas: " + rs.getInt("parcelas") 
					+ "  prazo: " + rs.getInt("prazo")
					+ "  mensal: " + rs.getBoolean("mensal"));
			}			

			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar entidades " + e.getMessage());
		}
	}	
	
	public static void editarEntidade() {

		listarTodasEntidades();		
		System.out.print("\ninforme Id da Entidade: \n");
		int idEntidade = scan.nextInt();
		Entidade entidade = montaEntidade();
		
	//	ConnectionMariaDB conexaoMariaDB = new ConnectionMariaDB();
		try {
			Connection connection = ConnectionMariaDB.conectar();
			
			String comandoSql = "UPDATE controlefinanceirobd.entidade\r\n"
					+ "			SET razaoSocial = ?, setor = ?, dre = ?, balanco = ?, presumido = ?, parcelas = ?, prazo = ?, mensal = ?\r\n"
					+ "			WHERE idEntidade = ?;";
			
			PreparedStatement ps = connection.prepareStatement(comandoSql);
	//		ps.setInt(1, entidade.getIdEntidade());
			ps.setString(1, entidade.getRazaoSocial());
			ps.setString(2, entidade.getSetor());
			ps.setString(3, entidade.getDre());
			ps.setString(4, entidade.getBalanco());
			ps.setString(5, entidade.getPresumido());
			ps.setInt(6, entidade.getParcelas());
			ps.setInt(7, entidade.getPrazo());
			ps.setBoolean(8, entidade.isMensal());
			ps.setInt(9, idEntidade);

			if (!ps.execute()) {
				System.out.println("Entidade editada com sucesso.");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao editar entidade " + e.getMessage());
		}

	}
	
	public static Entidade montaEntidade() {		
		
		System.out.println("Razão Social: ");
		String razaoSocial = scan.next();
		System.out.println("Setor: ");
		String setor = scan.next();
		System.out.println("Dre: ");
		String dre = scan.next();
		System.out.println("Balanço: ");
		String balanco = scan.next();
		System.out.println("Presumi-se: ");
		String presumido = scan.next();
		System.out.println("parcelas: ");
		int parcelas = scan.nextInt();
		System.out.println("Prazo entre parcelas: ");
		int prazo = scan.nextInt();
		System.out.println("Mensal: ");
		boolean mensal = scan.nextBoolean();
		
		Entidade entidade = new Entidade(razaoSocial, setor, dre, balanco, presumido, parcelas, prazo, mensal);
		entidade.setRazaoSocial(razaoSocial);
		entidade.setSetor(setor);
		entidade.setDre(dre);
		entidade.setBalanco(balanco);
		entidade.setPresumido(presumido);
		entidade.setParcelas(parcelas);
		entidade.setPrazo(prazo);
		entidade.setMensal(mensal);
		return entidade;
	}
	
	public static void excluirEntidade() {

		System.out.print("informe Id da Entidade: ");
		int idEntidade = scan.nextInt();
		
		//	ConnectionMariaDB conexaoMariaDB = new ConnectionMariaDB();
			try {
				Connection connection = ConnectionMariaDB.conectar();

				String comandoSql = "delete from controlefinanceirobd.entidade" + " where idEntidade = ?";

				PreparedStatement ps = connection.prepareStatement(comandoSql);
				ps.setInt(1, idEntidade);

				if (!ps.execute()) {
					System.out.println("Entidade excluida com sucesso.");
				}

			} catch (SQLException e) {
				System.out.println("Erro ao excluir entidade " + e.getMessage());
			}

		}
	
	
	
	
	
	
	
	
	// ====================================================================================================


	
	
	
	

	

	private static boolean tabelaExiste() throws SQLException {
		boolean achou = false;
		
		//Iniciando a conexão com o banco de dados
		Connection connection = ConnectionMariaDB.conectar();
		
		String comandoSql = "SELECT table_name"
							+ " FROM information_schema.tables"
							+ " WHERE table_schema = 'exercicioBD'"
							+ " AND table_name = 'usuario'";
		
		//Preparando o comando SQL
		PreparedStatement ps = connection.prepareStatement(comandoSql);
		
		//Executando o comando SQL
		ResultSet rs = ps.executeQuery();
		
		achou = rs.next();

		//Fechando a conexão com o banco de dados. Nunca esquecer de fazer isso após terminar de utilizar a conexão.
		connection.close();
			
		return achou;
	}
	
	


	public static String chamaLista() {

		String lista = "";

		ConnectionMariaDB connectionMariaDB = new ConnectionMariaDB();
		try {
			Connection connection = connectionMariaDB.conectar();
			String comandoSql =  "select idEntidade, razaoSocial, setor, dre, balanco, presumido, parcelas, prazo, mensal "
					+ " from controlefinanceirobd.entidade order by id";
			
			PreparedStatement ps = connection.prepareStatement(comandoSql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				lista += ("idEntidade: " + rs.getInt("idEntidade") 
				+ "razaoSocial: " + rs.getString("razaoSocial") 
				+ "setor: "	+ rs.getString("setor") 
				+ "dre: " + rs.getString("dre") 
				+ "balanco: " + rs.getString("balanco")
				+ "presumido: " + rs.getString("presumido")
				+ "parcelas: " + rs.getInt("parcelas") 
				+ "prazo: " + rs.getInt("prazo")
				+ "mensal: " + rs.getBoolean("mensal")
				);
			}

			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar Entidades " + e.getMessage());
		}

		return lista;
	}

	

}
