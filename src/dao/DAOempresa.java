package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Aconexao.conexao;
import beans.Empresa;



public class DAOempresa {
	
	
	//-------------------------------------INSERTS----------------------------------------------
	
	public void cadastrarEmpresa(Empresa empresa) {

		conexao c = new conexao();
		try {
				Statement comando = c.conn.createStatement(); // java.sql em
				String q = "";
				q += " INSERT INTO dados_empresa";
				q += " (COD_DADOS_EMPRESA, IE_EMPRESA, CNPJ_EMPRESA, NOM_EMPRESA, TEL_EMPRESA, COD_ENDERECO)";
				q += " VALUES (NULL, '"+empresa.getIE_EMPRESA()+"', '"+empresa.getCNPJ_EMPRESA()+"', '"+empresa.getNOM_EMPRESA()+"', '"+empresa.getTEL_EMPRESA()+"', "+empresa.getCOD_ENDERECO()+")";
				
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
				}}}
			
			
	public void InsertLOGINinstituição(Empresa empresa) {

		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			q += " INSERT INTO empresa";
			q += " (COD_Empresa, EMA_EMPRESA, SEN_EMPRESA, COD_DADOS_EMPRESA, IST_CARIDADE)";
			q += " VALUES (NULL, '"+empresa.getEMA_EMPRESA()+"', '"+empresa.getSEN_EMPRESA()+"','"+empresa.getCOD_DADOS_EMPRESA()+"', 'SIM')";
			comando.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso. Bem vindo ao mMüLL");

		} catch (Exception ex) {
			System.err.println("Falha na inserção LOGIN EMPRESA");
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
	public void InsertLOGINEmpresa(Empresa empresa) {

		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			q += " INSERT INTO empresa";
			q += " (COD_Empresa, EMA_EMPRESA, SEN_EMPRESA, COD_DADOS_EMPRESA, IST_CARIDADE)";
			q += " VALUES (NULL, '"+empresa.getEMA_EMPRESA()+"', '"+empresa.getSEN_EMPRESA()+"','"+empresa.getCOD_DADOS_EMPRESA()+"', 'NÃO')";
			comando.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso. Bem vindo ao mMüLL");

		} catch (Exception ex) {
			System.err.println("Falha na inserção LOGIN EMPRESA");
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


	
	//-------------------------------------FIMINSERTS-------------------------------------------
	
	
	
	//QUERY INICI0-------------------------------------------------------------------------------
	
	
	
	
	public void QUERYCOD_EMPRESA_DADOS(Empresa empresa) {

		conexao c = new conexao();// import conexão

		try {

			String q = "";
			q += " SELECT COD_DADOS_EMPRESA";
			q += " FROM dados_empresa";
			q += " WHERE CNPJ_EMPRESA = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			
			comando.setString(1, empresa.getCNPJ_EMPRESA());
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				empresa.setCOD_DADOS_EMPRESA(rs.getString("COD_DADOS_EMPRESA"));

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
	public void QUERYCOD_EMPRESA(Empresa empresa) {

		conexao c = new conexao();// import conexão

		try {

			String q = "";
			q += " SELECT COD_Empresa";
			q+=  " FROM empresa"; 
			q+=  " WHERE EMA_EMPRESA = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			
			comando.setString(1, empresa.getEMA_EMPRESA());
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				empresa.setCOD_Empresa(rs.getString("COD_Empresa"));

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
	
	}
//-------------------------------------------------------------------------------------QUERYFINAL