package aula20190607.repository;

import java.sql.Connection;
import java.util.List;

public class App {
	
	
	
	public static void main(String[] args) {
		Cor verde = new Cor(1, "Verde");
		Cor rosa = new Cor(2, "Rosa");
		
		Connection conn = null; //DriverManager.getConnection...

		//CorRepository repo = new CorRepositoryJDBC(conn); //usar a conex�o para persistir os dados.
		CorRepository repo = new CorRepositoryMem�ria(); //manter  os dados em uma cole��o.
		//CorRepository repo = null;
		
		repo.inserir(verde);
		repo.inserir(rosa);
		repo.inserir(new Cor(3, "Azul"));	
		repo.inserir(new Cor(4, "Lil�s"));
		
		
		verde = new Cor(1, "Verde Musgo");
		repo.alterar(verde);
		
		//repo.excluir(rosa.getId());

		List<Cor> cores = repo.obterTodas();
		
		System.out.println("Listando as cores...");
		for (Cor cor : cores) {
			System.out.println("  " + cor.getNome());
		}
		System.out.println("Fim da listagem.");
		
	}

}
