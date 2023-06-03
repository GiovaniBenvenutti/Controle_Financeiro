package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Entidade;
import Model.Lancamento;
import driver.ConnectionMariaDB;

public class ManipulaDadosLancamentos {
	
	static Scanner scan = new Scanner(System.in);
	
	public void criarEstruturaSeNaoExistirEntidade() throws Exception {
		try {
			//Verificar se a tabela existe. Caso não existir, criar e inserir um usuário padrão.
			if (!tabelaExiste()) {
			
				//Iniciando a conexão com o banco de dados
				Connection connection = ConnectionMariaDB.conectar();
				
				
				//Comando de criar a tabela
				String comandoSql = "CREATE TABLE IF NOT EXISTS controlefinanceirobd.lancamento ("
									    + "idLancamento INT(20) AUTO_INCREMENT NOT NULL,"
									    + "credor VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
									    + "numeroNfe VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"									  
									    + "setor VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
									    + "dre VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
									    + "balanco VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
									    + "parcelas INT(20) NOT NULL,"
									    + "valorOriginal DOUBLE(20) NOT NULL,"
									    + "valorPago DOUBLE(20) NOT NULL,"
									    + "emissao DATE NOT NULL,"
									    + "vencimento DATE NOT NULL,"
									    + "pagamento DATE NOT NULL,"
									    + "situacao VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
									    + "observacoes VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
									    + "juros DOUBLE(20) NOT NULL,"
									    + "presumido VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,"
									    + "prazo INT(20) NOT NULL,"
									    + "PRIMARY KEY (idLancamento))";						
						
									
				//Preparando e executando o comando SQL
				Statement statement = connection.createStatement();
				statement.execute(comandoSql);
	
				//Fechando a conexão com o banco de dados. Nunca esquecer de fazer isso após terminar de utilizar a conexão.
				connection.close();
				
				//Inserindo um usuário padrão para poder entrar no sistema
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Lancamento lancamento = new Lancamento();				
				
				lancamento.setCredor("LogHaus");
				lancamento.setNumeroNfe("001-1");
				lancamento.setSetor("Matriz");
				lancamento.setDre("Lucro");
				lancamento.setBalanco("Riquesa");
				lancamento.setParcelas(1);
				lancamento.setValorOriginal(10.00);
				lancamento.setValorPago(10.00);
				lancamento.setEmissao(dateFormat.parse("01/01/2023"));
				lancamento.setVencimento(dateFormat.parse("01/04/2023"));
				lancamento.setPagamento(dateFormat.parse("01/03/2023"));
				lancamento.setSituacao("aberto");
				lancamento.setObservacoes("confiavel");
				lancamento.setJuros(1.2);
				lancamento.setPresumido("sempre compra");
				lancamento.setPrazo(90);
				
				inserir(lancamento);
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao criar tabela: " + e.getMessage());
		}

	}
	
	public static void inserirLancamento() throws ParseException {		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Lancamento lancamento = new Lancamento();
				
		System.out.println("Credor: ");
		lancamento.setCredor(scan.next());
		System.out.println("Nf-e de origem: ");
		lancamento.setNumeroNfe(scan.next());
		System.out.println("Setor: ");
		lancamento.setSetor(scan.next());
		System.out.println("Dre: ");
		lancamento.setDre(scan.next());
		System.out.println("Balanço: ");
		lancamento.setBalanco(scan.next());		
		System.out.println("parcelas: ");
		lancamento.setParcelas(scan.nextInt());
		System.out.println("Valor original: ");
		lancamento.setValorOriginal(scan.nextDouble());
		System.out.println("Valor pago: ");
		lancamento.setValorPago(scan.nextDouble());
		System.out.println("Emissão: ");
		lancamento.setEmissao(dateFormat.parse(scan.next()));
		System.out.println("vencimento: ");
		lancamento.setVencimento(dateFormat.parse(scan.next()));
		System.out.println("pagamento: ");
		lancamento.setPagamento(dateFormat.parse(scan.next()));
		System.out.println("situacao: ");
		lancamento.setSituacao(scan.next());
		System.out.println("observacoes: ");
		lancamento.setObservacoes(scan.next());
		System.out.println("Valor juros: ");
		lancamento.setJuros(scan.nextDouble());
		System.out.println("presumido: ");
		lancamento.setPresumido(scan.next());
		System.out.println("prazo: ");
		lancamento.setPrazo(scan.nextInt());
						
		inserir(lancamento);
				
	}	
	
	public static void inserir(Lancamento lancamento) {

	//	ConnectionMariaDB conexaoMariaDB = new ConnectionMariaDB();
		try {
	//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Connection connection = ConnectionMariaDB.conectar();
				
			String comandoSql = "INSERT INTO controlefinanceirobd.lancamento" + "(credor, numeroNfe, setor, dre, balanco, parcelas,"
				    	   + "valorOriginal, valorPago, emissao, vencimento, pagamento, situacao, observacoes, juros, presumido, prazo)"
				    	   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
;
			PreparedStatement ps = connection.prepareStatement(comandoSql);
			ps.setString(1, lancamento.getCredor());
			ps.setString(2, lancamento.getNumeroNfe());
			ps.setString(3, lancamento.getSetor());
			ps.setString(4, lancamento.getDre());
			ps.setString(5, lancamento.getBalanco());
			ps.setInt(6, lancamento.getParcelas());
			ps.setDouble(7, lancamento.getValorOriginal());
			ps.setDouble(8, lancamento.getValorPago());
			ps.setDate(9, (java.sql.Date) lancamento.getEmissao());
			ps.setDate(10, (java.sql.Date) lancamento.getVencimento());
			ps.setDate(11, (java.sql.Date) lancamento.getPagamento());
			ps.setString(12, lancamento.getSituacao());
			ps.setString(13, lancamento.getObservacoes());
			ps.setDouble(14, lancamento.getJuros());
			ps.setString(6, lancamento.getPresumido());		
			ps.setInt(8, lancamento.getPrazo());
			
			if (!ps.execute()) {
				System.out.println("Lançamento inerida com sucesso");
			}

			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir lançamento " + e.getMessage());
		}
	}
	
	public static void listarTodosLancamentos() {

	//	ConnectionMariaDB connectionMariaDB = new ConnectionMariaDB();
			
		try {
			Connection connection = ConnectionMariaDB.conectar();
			String comandoSql = "select idLancamento, credor, numeroNfe, setor, dre, balanco, parcelas, valorOriginal, valorPago, emissao,"
					+ " vencimento, pagamento, situacao, observacoes, juros, presumido, prazo "
					+ " from controlefinanceirobd.lancamento order by idLancamento";

			PreparedStatement ps = connection.prepareStatement(comandoSql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				
				
				
				//  PAREI AQUI ?
				
				
				

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
