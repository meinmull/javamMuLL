package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Aconexao.conexao;
import Cliente.InicioCliente;
import Empresa.InicioEmpresa;
import Instituicao.InicioInstituicao;
import beans.Login;
import beans.Usuario;
import beansCliente.cUsuario;


public class DAOlogin {
	
	
	Login login = new Login();
	Usuario usuario = new Usuario();
	
	
	public void LoginUSUARIO(Login login){

		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT us.COD_Usuario, us.EMA_USUARIO, us.SEN_USUARIO, us.COD_DADOS,";
			q += " dus.NOM_DADOS , dus.SOB_NOM_DADOS , dus.CPF_DADOS";
			q += " FROM usuario us";
			q += " INNER JOIN dados_usuario dus ON dus.COD_DADOS = us.COD_DADOS";
			q += " WHERE us.EMA_USUARIO = ?";
		

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, login.getEMA_USUARIO());

			

			ResultSet rs = comando.executeQuery(); 
		
			

			if (rs.next()) {
			login.setSEN_USUARIO(rs.getString("us.SEN_USUARIO"));
			
			
			if(login.getSEN_DIGITADA().equals(login.getSEN_USUARIO())){
				
				
				cUsuario.setCOD_Usuario(rs.getString("COD_Usuario"));
				cUsuario.setEMA_USUARIO(rs.getString("us.EMA_USUARIO"));
				cUsuario.setCOD_DADOS(rs.getString("us.COD_DADOS"));
				cUsuario.setNOM_DADOS(rs.getString("dus.NOM_DADOS")+"  "+rs.getString("dus.SOB_NOM_DADOS"));
				cUsuario.setCPF_DADOS(rs.getString("dus.CPF_DADOS"));
				InicioCliente frame = new InicioCliente();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
			
			}
			
		} catch (Exception ex) {
			System.err.println("Falha na exclusão");
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
	/*public void LoginADM(){

		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT COD_ADM, Login, Senha FROM admmull";
			q += " WHERE Login = ?";
		

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, txtUsuario.getText());

			

			ResultSet rs = comando.executeQuery(); 
		
			

			if (rs.next()) {
			acesso.setSEN_USUARIO(rs.getString("Senha"));
			acesso.setCOD_USUARIO(rs.getString("COD_ADM"));
			
			
			if(txtSenha.getText().equals(acesso.getSEN_USUARIO())){
				mMuLLadm frame = new mMuLLadm();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
			
			}
			
		} catch (Exception ex) {
			System.err.println("Falha na exclusão");
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

		
	}*/
	
	public void LoginEmpresa(Login login){

		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT em.COD_Empresa, em.EMA_EMPRESA,em.SEN_EMPRESA,";
			q += " em.COD_DADOS_EMPRESA, dem.CNPJ_EMPRESA, dem.NOM_EMPRESA,em.IST_CARIDADE";
			q += " FROM empresa em ";
			q += " INNER JOIN dados_empresa dem ON dem.COD_DADOS_EMPRESA = em.COD_DADOS_EMPRESA";
			q += " WHERE em.EMA_EMPRESA =  ?";
		

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, ""+login.getEMA_USUARIO()+"");

			

			ResultSet rs = comando.executeQuery(); 
		
			

			if (rs.next()) {
				login.setSEN_USUARIO(rs.getString("em.SEN_EMPRESA"));
				
				
				if(login.getSEN_DIGITADA().equals(login.getSEN_USUARIO())){
					Usuario.setCOD_USUARIO(rs.getString("em.COD_Empresa"));
					Usuario.setEMA_USUARIO(rs.getString("em.EMA_EMPRESA"));
					Usuario.setCOD_DADOS_USUARIO(rs.getString("em.COD_DADOS_EMPRESA"));
					Usuario.setNOM_USUARIO(rs.getString("dem.NOM_EMPRESA"));
					Usuario.setDOC_USUARIO(rs.getString("dem.CNPJ_EMPRESA"));
					login.setIST_USUARIO(rs.getString("em.IST_CARIDADE"));
					Usuario.setIST_USUARIO(rs.getString("em.IST_CARIDADE"));
					if (login.getIST_USUARIO().equalsIgnoreCase("SIM")){
						InicioInstituicao frame = new InicioInstituicao();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					}else if(login.getIST_USUARIO().equalsIgnoreCase("NÃO")){
						InicioEmpresa frame = new InicioEmpresa();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					}
				}
				
				}
			
		} catch (Exception ex) {
			System.err.println("Falha na exclusão");
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
	

	public void login(){
		LoginEmpresa(login);
		LoginUSUARIO(login);
	}

}
