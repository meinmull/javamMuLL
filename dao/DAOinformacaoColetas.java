package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Aconexao.conexao;

public class DAOinformacaoColetas {

	/*public void respostasDivergentes() {

		conexao c = new conexao();// import conexão

		try {

			String q =""; 
				q += " SELECT count(COD_COLETA)";
				q += " FROM coleta ";
				q += " WHERE SIT_COLETA = 'COLETA NÃO EFETUADA'";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtColetasNaoAtendidas.setText(rs.getString("COUNT(COD_COLETA)"));
				
				
			}

		} catch (Exception ex) {
			System.err.println("Falha TOTALCOLETAS() ");
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
	
	
	public void TOTALCOLETAS() {

		conexao c = new conexao();// import conexão

		try {

			String q =""; 
				q += " SELECT COUNT(COD_COLETA)";
				q += " FROM coleta";
				q += " WHERE COD_EMPRESA = "+emp.COD_EMPRESA;

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtTotalcol.setText(rs.getString("COUNT(COD_COLETA)"));
				
				
			}

		} catch (Exception ex) {
			System.err.println("Falha TOTALCOLETAS() ");
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
	public void TOTALCOLETASCOLETAS() {

			conexao c = new conexao();// import conexão

			try {

				String q =""; 
					q += " SELECT COUNT(COD_COLETA)";
					q += " FROM coleta "; 
					q += " WHERE COD_EMPRESA = "+emp.COD_EMPRESA+" AND SIT_COLETA = 'COLETADA'";

				PreparedStatement comando = c.conn.prepareStatement(q);

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {
					txtTotalcolEfetuadas.setText(rs.getString("COUNT(COD_COLETA)"));
					
					
				}

			} catch (Exception ex) {
				System.err.println("Falha TOTALCOLETAS() ");
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
	public void TOTALCOLETAScanceladas() {

			conexao c = new conexao();// import conexão

			try {

				String q =""; 
					q += " SELECT COUNT(COD_COLETA)";
					q += " FROM coleta";
					q += " WHERE COD_EMPRESA = "+emp.COD_EMPRESA+" AND SIT_COLETA = 'CANCELADA' ";

				PreparedStatement comando = c.conn.prepareStatement(q);

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {
					txtTotalcanceladas.setText(rs.getString("COUNT(COD_COLETA)"));
					
					
				}

			} catch (Exception ex) {
				System.err.println("Falha TOTALCOLETAS() ");
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
	public void TOTALCOLETASaColetar() {

			conexao c = new conexao();// import conexão

			try {

				String q =""; 
					q += " SELECT COUNT(COD_COLETA)";
					q += " FROM coleta";
					q += " WHERE COD_EMPRESA = "+emp.COD_EMPRESA+" AND SIT_COLETA = 'CONFIRMADA'";

				PreparedStatement comando = c.conn.prepareStatement(q);

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {
					txtColAcoletar.setText(rs.getString("COUNT(COD_COLETA)"));
					
					
				}

			} catch (Exception ex) {
				System.err.println("Falha TOTALCOLETAS() ");
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
	public void TOTALCOLETASnaoConfirmadasColetar() {

		conexao c = new conexao();// import conexão

		try {

			String q =""; 
				q += " SELECT COUNT(COD_COLETA)";
				q += " FROM coleta";
				q += " WHERE COD_EMPRESA = "+emp.COD_EMPRESA+" AND SIT_COLETA = 'NÃO CONFIRMADA'";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtColNaoConfirmadas.setText(rs.getString("COUNT(COD_COLETA)"));
				
				
			}

		} catch (Exception ex) {
			System.err.println("Falha TOTALCOLETAS() ");
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
	public void TOTALCOLETASHOJE() {

		conexao c = new conexao();// import conexão

		try {

			String q =""; 
				q += " SELECT COUNT(COD_COLETA)";
				q += " FROM coleta";
				q += " WHERE COD_EMPRESA = "+emp.COD_EMPRESA+" AND SIT_COLETA = 'CONFIRMADA' AND (date(DATA_COLETA)=DATE(NOW()))";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtColHoje.setText(rs.getString("COUNT(COD_COLETA)"));
				
				
			}

		} catch (Exception ex) {
			System.err.println("Falha TOTALCOLETAS() ");
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
}
