package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;
import Aconexao.conexao;
import beansCliente.cUsuario;

public class cDAOcount {
	public JTextField txtCountmMuLL;
	public JTextField txtCOLAGENDADAS;
	public JTextField txtCOLCANCELADAS;
	public JTextField txtCOLEMANDAMENTO;
	public JTextField txtCOLPENDENTES;
	public JTextField txtCOLFINALIZADA;
	public JTextField txtCOLNAO;
	public JTextField txtDIA_COL;
	public JTextField txtnroAgendamentos;
	public JTextField txtAGENDAMENTOIDCOLETA;
	
	public void showColetas() { 
	  CountColetas();
	  CountCOD_mMuLL(); 
	  CountColetasCanceladas(); 
	  CountColetasAconfirmar();
	  CountColetasEMANDAMENTO(); 
	  CountColetasFINALIZADAS();
	  CountColetasNaoAcatadas();
	  //CountCOD_COLETA_AGENDAMENTO();
	  
	  }
	
	

	public void CountCOD_mMuLL() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_mMuLL)";
			q += " FROM mmull WHERE COD_USUARIO = " + cUsuario.getCOD_Usuario();

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCountmMuLL.setText(rs.getString("count(COD_mmull)"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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

	public void CountColetas() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_COLETA)";
			q += " FROM coleta  col";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL =col.COD_MMULL";
			q += " WHERE mm.COD_USUARIO = " + cUsuario.getCOD_Usuario();

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCOLAGENDADAS.setText(rs.getString("count(COD_COLETA)"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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

	public void CountColetasCanceladas() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_COLETA)";
			q += " FROM coleta  col";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL =col.COD_MMULL";
			q += " WHERE mm.COD_USUARIO = " + cUsuario.getCOD_Usuario() + " AND SIT_COLETA = 'CANCELADA'";

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCOLCANCELADAS.setText(rs.getString("count(COD_COLETA)"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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

	public void CountColetasAconfirmar() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_COLETA)";
			q += " FROM coleta  col";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL =col.COD_MMULL";
			q += " WHERE mm.COD_USUARIO = " + cUsuario.getCOD_Usuario() + " AND SIT_COLETA = 'NÃO CONFIRMADA'";

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCOLPENDENTES.setText(rs.getString("count(COD_COLETA)"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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

	public void CountColetasEMANDAMENTO() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_COLETA)";
			q += " FROM coleta  col";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL =col.COD_MMULL";
			q += " WHERE mm.COD_USUARIO = " + cUsuario.getCOD_Usuario() + " AND SIT_COLETA = 'CONFIRMADA'";

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCOLEMANDAMENTO.setText(rs.getString("count(COD_COLETA)"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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

	public void CountColetasFINALIZADAS() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_COLETA)";
			q += " FROM coleta  col";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL =col.COD_MMULL";
			q += " WHERE mm.COD_USUARIO = " + cUsuario.getCOD_Usuario() + " AND SIT_COLETA = 'COLETADA'or SIT_COLETA = 'FINALIZADA'  " ;

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCOLFINALIZADA.setText(rs.getString("count(COD_COLETA)"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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

	public void CountColetasNaoAcatadas() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_mMuLL)";
			q += " FROM mmull";
			q += " WHERE COD_USUARIO = " + cUsuario.getCOD_Usuario() + " AND COL_AGENDADA LIKE '%não%'";

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCOLNAO.setText(rs.getString("count(COD_mMuLL)"));

			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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
	/*public void CountCOD_COLETA_AGENDAMENTO() {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT count(COD_MMULL)";
			q += " FROM mmull";
			q += " WHERE COD_USUARIO = " + cUsuario.getCOD_Usuario() ;

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtCOLAGENDADAS.setText(rs.getString("count(COD_MMULL)"));
				
				
			}

		} catch (Exception ex) {
			System.err.println("Falha na BUSCA ");
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
