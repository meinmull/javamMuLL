package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Aconexao.conexao;

import beansCliente.cUsuario;

public class cDAOCADASTRO {

	cUsuario Cusuario = new cUsuario(); 
	
	
	@SuppressWarnings("static-access")
	public void QUERYCOD_USUARIO(cUsuario Cusuario) {

		conexao c = new conexao();// import conexão

		try {

			String q = "";
			q += " SELECT COD_Usuario";
			q += " FROM usuario"; 
			q += " WHERE EMA_USUARIO = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			
			comando.setString(1, Cusuario.getEMA_USUARIO());
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cusuario.setCOD_Usuario(rs.getString("COD_Usuario"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA COD ENDERECO ");
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
	
	public void InsertNewDados(cUsuario Cusuario) {
		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO dados_usuario";
			q += "(COD_DADOS, TEL_DADOS, CEL_DADOS, CPF_DADOS, COD_ENDERECO, NOM_DADOS, SOB_NOM_DADOS)";
			q += "VALUES (NULL, '"+Cusuario.getTEL_DADOS()+"', '"+Cusuario.getCEL_DADOS()+"', '"+Cusuario.getCPF_DADOS()+"', "+Cusuario.getCOD_ENDERECO_USUARIO()+", '"+Cusuario.getNOM_DADOS()+"', '"+Cusuario.getSOB_NOM_DADOS()+"')";
			
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO dados_usuario ");
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
	//verificar CodEndereço
//END  Insert Cadastro
	public void InsertDadosUsuario(cUsuario Cusuario) {
		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO usuario";
			q += " (COD_Usuario, EMA_USUARIO, SEN_USUARIO, COD_DADOS)";
			q += " VALUES (NULL, '"+Cusuario.getEMA_USUARIO()+"', '"+Cusuario.getSEN()+"', "+Cusuario.getCOD_DADOS()+")";
			
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO LOGIN USUARIO ");
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
	@SuppressWarnings("static-access")
	public void QueryCOD_DADOS(cUsuario Cusuario) {

		conexao c = new conexao();// import conexão
		try {

			String q = "";

			q += "SELECT COD_DADOS FROM dados_usuario WHERE CPF_DADOS =  ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cusuario.getCPF_DADOS());
			

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cusuario.setCOD_DADOS(rs.getString("COD_DADOS"));
				

			}
		} catch (Exception ex) {
			System.err.println("Falha na BUSCA do COD_Bairro ");
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
