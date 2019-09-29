package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;

import Aconexao.conexao;
import abstractTableModel.ModeloTabela;
import beansCliente.cColeta;
import beansCliente.cUsuario;

public class cDAOcoleta {
	
	cColeta cCOLETA = new cColeta();
	 
	public JTable tblConsulta = new JTable();
	
	public JTextField txtCOD_COL;
	public JTextField txtSIT_COL;
	public JTextField txtDAT_COL;
	public JTextField txtPER_COLETA;
	public JTextField txtNOM_EMPRESA;
	public JTextField txtCOD_EMPRESA;
	
	
	public void SetDadosColeta(cColeta cCOLETA){
		System.out.println("SetDadosColeta(cColeta cCOLETA) - cCOLETA.getCOD_MULL() :"+ cCOLETA.getCOD_MULL());
		
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT  col.COD_COLETA , ";
			q += " col.SIT_COLETA,";
			q += " date_format(col.DATA_COLETA,'%d/%m/%Y') ,dem.NOM_EMPRESA,col.PER_COLETA, em.COD_EMPRESA";
			q += " FROM mmull mm ";
			q += " INNER JOIN usuario us on us.COD_Usuario = mm.COD_USUARIO";
			q += " left outer join coleta col on col.COD_MMULL = mm.COD_mMuLL";
			q += " left outer join empresa em on em.COD_Empresa = col.COD_EMPRESA";
			q += " left outer join dados_empresa dem on dem.COD_DADOS_EMPRESA = em.COD_DADOS_EMPRESA";
			q += " where mm.COD_mMuLL = " + cCOLETA.getCOD_MULL() +" AND col.COD_COLETA =" +cCOLETA.getCOD_COLETA();
			

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			
			if (rs.next()) {

				
				 System.out.println("Resultado da query COD_COLETA : "+rs.getString("col.COD_COLETA"));
				txtCOD_COL.setText(rs.getString("col.COD_COLETA"));
				txtSIT_COL.setText(rs.getString("col.SIT_COLETA"));
				
				 txtDAT_COL.setText(rs.getString("date_format(col.DATA_COLETA,'%d/%m/%Y')"));
				 txtPER_COLETA.setText(rs.getString("col.PER_COLETA"));
				 txtNOM_EMPRESA.setText(rs.getString("dem.NOM_EMPRESA"));
				 txtCOD_EMPRESA.setText(rs.getString("em.COD_EMPRESA"));
				
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
		
	
	
	public void QuerymMuLLColetas(cColeta cCOLETA) {
		@SuppressWarnings("rawtypes")
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Nºcol", "Solicitação", " Situação da Coleta", "Data Coleta", "Horário", };

		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT  col.COD_COLETA , ";
			q += " date_format(mm.SOL_USUARIO,'%d/%m/%Y') ,col.SIT_COLETA,";
			q += " date_format(col.DATA_COLETA,'%d/%m/%Y') ,dem.NOM_EMPRESA,col.PER_COLETA, em.COD_EMPRESA";
			q += " FROM mmull mm ";
			q += " INNER JOIN usuario us on us.COD_Usuario = mm.COD_USUARIO";
			q += " left outer join coleta col on col.COD_MMULL = mm.COD_mMuLL";
			q += " left outer join empresa em on em.COD_Empresa = col.COD_EMPRESA";
			q += " left outer join dados_empresa dem on dem.COD_DADOS_EMPRESA = em.COD_DADOS_EMPRESA";
			q += " where mm.COD_mMuLL = " + cCOLETA.getCOD_MULL();
			q += " order BY  col.COD_COLETA desc";

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			ModeloTabela modelo = new ModeloTabela(dados, colunas);
			tblConsulta.setModel(modelo);
			tblConsulta.setShowGrid(false);
			tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(60);
			tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(90);
			tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(165);
			tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(95);
			tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(120);
			
			tblConsulta.getTableHeader().setReorderingAllowed(false);
			tblConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			while (rs.next()) {

				dados.add(new Object[] { rs.getString("col.COD_COLETA"),
						rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"), rs.getString("col.SIT_COLETA"),
						rs.getString("date_format(col.DATA_COLETA,'%d/%m/%Y')"), rs.getString("col.PER_COLETA"),
						 });
				 
				
				
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
	public void ConfirmarColeta(cColeta cCOLETA) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql
															// em
			String q = "";

			q += " UPDATE coleta";
			q += " SET ";
			q += " 	SIT_COLETA='CONFIRMADA'";
			q += " WHERE COD_COLETA = " + cCOLETA.getCOD_COLETA();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FAlha ConfirmarColeta()");
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
	public void CancelarColeta(cColeta cCOLETA) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql
															// em
			String q = "";

			q += " UPDATE coleta";
			q += " SET ";
			q += " 	SIT_COLETA='CANCELADA'";
			q += " WHERE COD_COLETA = " + cCOLETA.getCOD_COLETA();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FAlha CancelarColeta()");
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
	
	public void FinalizarColetaNAO(cColeta cCOLETA) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement();
			String q = "";

			q += " UPDATE coleta";
			q += " SET";
			q += " SIT_COLETA='NÃO COLETADA'";
			q += " WHERE COD_MMULL = " + cCOLETA.getCOD_MULL() + "  AND COD_COLETA = " + cCOLETA.getCOD_COLETA();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FinalizarColeta()");
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
	public void FinalizarColeta(cColeta cCOLETA) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement();
			String q = "";

			q += " UPDATE coleta";
			q += " SET";
			q += " SIT_COLETA='FINALIZADA'";
			q += " WHERE COD_MMULL = " + cCOLETA.getCOD_MULL() + "  AND COD_COLETA = " + cCOLETA.getCOD_COLETA();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FinalizarColeta()");
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
