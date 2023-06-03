package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import driver.ConnectionMariaDB;

public class Main {

	public static void main(String[] args) {

		try {
			Connection connection = ConnectionMariaDB.conectar();
			System.out.println("Conectado com sucesso");

			connection.close();
		} catch (SQLException e) {
			System.out.println("Falha ao tentar conexão" + e.getMessage());
		}

		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("  -- Entidade --  ");
			System.out.println("    1 - inserir Entidade");
			System.out.println("    2 - listar Entidades");
			System.out.println("    3 - editar Entidade");
			System.out.println("    4 - excluir Entidade");
			System.out.println("    0 - sair         ");
			System.out.println("                     ");
			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				ManipulaDadosEntidades.inserirEntidade();
				break;
			case 2:
				ManipulaDadosEntidades.listarTodasEntidades();
				break;
			case 3:				
				ManipulaDadosEntidades.editarEntidade();
				break;
			case 4:
				
				ManipulaDadosEntidades.excluirEntidade();
				break;
			}
		} while (opcao != 0);
		scan.close();
	}

}
