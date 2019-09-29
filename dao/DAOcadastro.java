package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Aconexao.conexao;
import beans.Cadastro;
import beans.Empresa;

public class DAOcadastro {
	

	Cadastro CADASTRO = new Cadastro();
	
	public void InsertCaixadeMensagensUsuario(Cadastro CADASTRO){
		
		

		conexao c = new conexao();
		try {
				Statement comando = c.conn.createStatement(); // java.sql em
				String q = "";
				q += " INSERT INTO mensagenscaixa";
				q += " (COD_USUARIO, NRO_MENSAGENS)";
				q += " VALUES ("+CADASTRO.getCOD_USUARIO()+", 0)";
				
				comando.executeUpdate(q);
				
		
			} catch (Exception ex) {
				System.err.println("Falha na inserção InsertCaixadeMensagensUsuario");
				ex.printStackTrace();
			} finally {
				if (c.conn != null) {
					try {
						c.conn.close();
					} catch (Exception ex) {
						System.err.println("Error in conection terminal");
					}
				}}
			
	
	
}
	
	
	public void InsertCaixadeMensagens(Cadastro CADASTRO){
		
		

			conexao c = new conexao();
			try {
					Statement comando = c.conn.createStatement(); // java.sql em
					String q = "";
					q += " INSERT INTO mensagenscaixaei";
					q += " (COD_EMPRESA, NRO_MENSAGENS)";
					q += " VALUES ("+CADASTRO.getCOD_USUARIO()+", 0)";
					
					comando.executeUpdate(q);
					
			
				} catch (Exception ex) {
					System.err.println("Falha na inserção DADOS EMPRESA");
					ex.printStackTrace();
				} finally {
					if (c.conn != null) {
						try {
							c.conn.close();
						} catch (Exception ex) {
							System.err.println("Error in conection terminal");
						}
					}}
				
		
		
	}
	
	public void VerificacaoEmailEmpresa(Cadastro CADASTRO){
		
		
		conexao c = new conexao();
		try {

			String q = "";
			q+=" SELECT EMA_EMPRESA";
			q+=" FROM empresa";
			q+=" WHERE EMA_EMPRESA = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1,""+CADASTRO.getEmail_digitado()+"");
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				CADASTRO.setEmail(rs.getString("EMA_EMPRESA"));
;

				
			
				
				
			}
		} catch (Exception ex) {
			System.err.println("QuerymMuLLViewDetalhesEmpresa(Coleta coleta)");
			ex.printStackTrace();

		} finally {
			if (c.conn != null) {
				try {
					c.conn.close();
				} catch (Exception ex) {
					System.err.println("Error in conection terminal");
				}
			}
		}

	
}
public void VerificacaoEmailUsuario(Cadastro CADASTRO){
		
		
		conexao c = new conexao();
		try {

			String q = "";
			q+=" SELECT EMA_USUARIO";
			q+=" FROM usuario";
			q+=" WHERE EMA_USUARIO = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1,""+CADASTRO.getEmail_digitado()+"");
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				CADASTRO.setEmail(rs.getString("EMA_USUARIO"));


				
			
				
				
			}
		} catch (Exception ex) {
			System.err.println("QuerymMuLLViewDetalhesEmpresa(Coleta coleta)");
			ex.printStackTrace();

		} finally {
			if (c.conn != null) {
				try {
					c.conn.close();
				} catch (Exception ex) {
					System.err.println("Error in conection terminal");
				}
			}
		}

	
}
	
}
