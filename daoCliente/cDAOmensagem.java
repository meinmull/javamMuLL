package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Aconexao.conexao;
import abstractTableModel.ModeloTabela;
import beansCliente.cMensagem;
import beansCliente.cUsuario;

public class cDAOmensagem {
	
	
	public static JTextField txtRemetente;
	public static JTextField txtAssunto;
	public static JTextField txtDAtAMSG;
	public static JTextField txtHoraMSG;
	public static JTextField txtID_mMULL;
	public static JTextField txtDESCRICAOmMULL;
	public static JTextField txtDATAminhaSOlicitacao;
	public static JTextField txtHoraMinhaSOlicitacao;
	public static JTextField txtResposta;
	public static JTextArea txtObs;
	public static JTextArea txtMsg;
	public static JTextField txtPcs;
	public static JTextField txtFaixaEtaria;
	public static JTextField txtGenero;
	public static JTextField txtDescricao;
	public static JTextField txtPeso;
	public static JTable tblConsulta =  new JTable();
	
	
	public void UpdateMensagensCXexclusao(cMensagem Cmensagem){
		
		Cmensagem.setCX_MENSAGENS(Cmensagem.getCX_MENSAGENS()-1);
		
		if(Cmensagem.getCX_MENSAGENS()>0){
		
		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			q += " UPDATE mensagenscaixa";
			q += " SET";
			q += " NRO_MENSAGENS="+Cmensagem.getCX_MENSAGENS();
			q += " WHERE COD_USUARIO = "+cUsuario.getCOD_Usuario();
			

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("public void UpdateMensagensCX(cMensagem Cmensagem)");
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

		
	}}
	
	
	public void UpdateMensagensCX(cMensagem Cmensagem){
		
		
	

	
	conexao c = new conexao();// import conexão
	try {

		Statement comando = c.conn.createStatement(); // java.sql em
		String q = "";
		q += " UPDATE mensagenscaixa";
		q += " SET";
		q += " NRO_MENSAGENS= "+Cmensagem.getCX_MENSAGENS();
		q += " WHERE COD_USUARIO = "+cUsuario.getCOD_Usuario();
		

		comando.executeUpdate(q);

	} catch (Exception ex) {
		System.err.println("public void UpdateMensagensCX(cMensagem Cmensagem)");
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
	
	
	
	public void selectMensagensAntes(cMensagem Cmensagem){
		
		
				conexao c = new conexao();
		try {

			String q = "";

			q += " SELECT NRO_MENSAGENS";
			q += " FROM mensagenscaixa";
			q += " WHERE COD_USUARIO = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());
		
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmensagem.setNRO_MENSAGENS(rs.getInt("NRO_MENSAGENS"));
			}

		} catch (Exception ex) {
			System.err.println("falha na Cancelamento de Mensagem.");
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
	
	public void SelectNROmensagens(cMensagem Cmensagem) {

		conexao c = new conexao();
		try {

			String q = "";

			q += " SELECT count(COD_MENSAGEM)";
			q += " FROM mensagemempresa";
			q += " WHERE COD_USUARIO = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());
		
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmensagem.setCX_MENSAGENS(rs.getInt("count(COD_MENSAGEM)"));
				
			}

		} catch (Exception ex) {
			System.err.println("falha na Cancelamento de Mensagem.");
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
	
	 
	
	public void EnviarMensagemEmpresaCancelamento(cMensagem Cmensagem) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "	INSERT INTO mensagemcliente";
			q += "	(COD_MENSAGEM, ";
			q += "	COD_USUARIO, ";
			q += "	COD_MMULL, ";
			q += "	STA_MENSAGEM,";
			q += "	DAT_MENSAGEM,";
			q += "	MSG_MENSAGEM, ";
			q += "	COD_EMPRESA)";
			q += "	VALUES (NULL,";
			q += "	" + cUsuario.getCOD_Usuario() + ",";
			q += "	" + Cmensagem.getCOD_mMuLL() + ",";
			q += "	'NÃO LIDA',";
			q += "	NOW(),";
			q += "	'A COLETA do mMuLL numero " + Cmensagem.getCOD_mMuLL() + ", \nDa categoria : " + Cmensagem.getDES_TAB()
					+ ". \nNão pode ser efetuada na data : " + Cmensagem.getDataColeta() + ". \nNo periodo das "
					+ Cmensagem.getHORA_COLETA();
			q += "  \n" + Cmensagem.getDES_TAB() + " de ID :" + Cmensagem.getCOD_mMuLL()
					+ " 	estara disponivel para uma nova solicitção de coleta.	'	,";
			q += "	" + Cmensagem.getCOD_EMPRESA() + ")";

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("falha na Cancelamento de Mensagem.");
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
	public void EnviarMensagemEmpresaColetaNaoColetada(cMensagem Cmensagem) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "	INSERT INTO mensagemcliente";
			q += "	(COD_MENSAGEM, ";
			q += "	COD_USUARIO, ";
			q += "	COD_MMULL, ";
			q += "	STA_MENSAGEM,";
			q += "	DAT_MENSAGEM,";
			q += "	MSG_MENSAGEM, ";
			q += "	COD_EMPRESA)";
			q += "	VALUES (NULL,";
			q += "	" + cUsuario.getCOD_Usuario() + ",";
			q += "	" + Cmensagem.getCOD_mMuLL() + ",";
			q += "	'COLETA NÃO EFETUADA',";
			q += "	NOW(),";
			q += "	'A COLETA do mMuLL numero " + Cmensagem.getCOD_COLETA() + ", \nDa categoria : " + Cmensagem.getDES_TAB()
					+ ". \nNão foi coletada na : " + Cmensagem.getDataColeta() + ". \nNo periodo das " + Cmensagem.getHORA_COLETA();
			q += "  \n" + Cmensagem.getDES_TAB() + " de ID :" + Cmensagem.getCOD_mMuLL()
					+ " 	estara disponivel para uma nova solicitção de coleta.	'	,";
			q += "	" + Cmensagem.getCOD_EMPRESA() + ")";

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("falha EnviarMensagemEmpresaColetaNaoColetada().");
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
	
	public void QueryMensagensCliente() {
		
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Empresa", "Assunto", "Data Mensagem" , "Status Mensagem", "COD mENSAGEM" ,  "COD EMPRESA" , "COD MULL" };
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT dem.NOM_EMPRESA, mm.DES_TAB , DATE(DAT_MENSAGEM),STA_MENSAGEM,";
			q += " msgemp.COD_MENSAGEM,  emp.COD_EMPRESA , mm.COD_mMuLL";
			q += " FROM mensagemempresa msgemp";
			q += " INNER JOIN empresa emp ON emp.COD_Empresa = msgemp.COD_EMPRESA";
			q += " INNER JOIN dados_empresa dem ON dem.COD_DADOS_EMPRESA = emp.COD_DADOS_EMPRESA";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL = msgemp.COD_MMULL";
			q += " WHERE msgemp.COD_USUARIO = ? ";
			q += " Order by DAT_MENSAGEM desc ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());

			ResultSet rs = comando.executeQuery();

			ModeloTabela modelo = new ModeloTabela(dados, colunas);
			tblConsulta.setModel(modelo);
			tblConsulta.setShowGrid(false);
			tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(220);
			tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(200);
			tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(200);
			tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(70);
			tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(80);
			tblConsulta.getColumnModel().getColumn(5).setPreferredWidth(80);
			tblConsulta.getColumnModel().getColumn(6).setPreferredWidth(80);
			

			tblConsulta.getTableHeader().setReorderingAllowed(false);
			tblConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			while (rs.next()) {

				dados.add(new Object[] { rs.getString("dem.NOM_EMPRESA"),
						("COLETA  :  " + rs.getString("mm.DES_TAB")), rs.getString("DATE(DAT_MENSAGEM)"),
						rs.getString("STA_MENSAGEM"), rs.getString("msgemp.COD_MENSAGEM"),
						rs.getString("emp.COD_EMPRESA"),rs.getString("mm.COD_mMuLL") });
			
// 
			}
			

			
		} catch (Exception ex) {
			System.err.println("FALHA NA BUSCA DO CODIGO mMuLL");
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

	

	public void getCODMensagem(cMensagem Cmensagem) {
		int a;
		a = tblConsulta.getSelectedRow();

		Cmensagem.setCOD_MENSAGEM_USUARIO((String) (tblConsulta.getValueAt(a, 4)));
		Cmensagem.setData_Recebimento_Mensagem((String) (tblConsulta.getValueAt(a, 2)));
		
		Cmensagem.setCOD_mMuLL ((String) (tblConsulta.getValueAt(a, 6)));
		Cmensagem.setCOD_Empresa((String) (tblConsulta.getValueAt(a, 5)));
		
	}

	public void QueryMensagensgetTextCliente(cMensagem Cmensagem) {

		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT ";
			q += " dem.NOM_EMPRESA,   mm.DES_TAB        , date_format(mm.SOL_USUARIO,'%d/%m/%Y') , TIME(mm.SOL_USUARIO),";
			q += " msgemp.COD_MMULL, msgemp.MSG_MENSAGEM , DATE_format(msgemp.DAT_MENSAGEM,'%d/%m/%Y') , TIME(msgemp.DAT_MENSAGEM),";
			q += " (date(Now())-date(mm.SOL_USUARIO)),col.COD_COLETA";
			q += " FROM mensagemempresa msgemp";
			q += " INNER JOIN empresa emp ON emp.COD_Empresa = msgemp.COD_EMPRESA";
			q += " INNER JOIN coleta col ON col.COD_MMULL = msgemp.COD_mMuLL";
			q += " INNER JOIN dados_empresa dem ON dem.COD_DADOS_EMPRESA = emp.COD_DADOS_EMPRESA";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL = msgemp.COD_MMULL";
			q += " WHERE msgemp.COD_MENSAGEM = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmensagem.getCOD_MENSAGEM_USUARIO());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtHoraMSG.setText(rs.getString("TIME(msgemp.DAT_MENSAGEM)"));
				txtDAtAMSG.setText(rs.getString("DATE_format(msgemp.DAT_MENSAGEM,'%d/%m/%Y')"));
				txtRemetente.setText(rs.getString("dem.NOM_EMPRESA"));
				txtMsg.setText(rs.getString("msgemp.MSG_MENSAGEM"));
				txtID_mMULL.setText(rs.getString("msgemp.COD_MMULL"));
				txtDATAminhaSOlicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
				txtHoraMinhaSOlicitacao.setText(rs.getString("TIME(mm.SOL_USUARIO)"));
				txtAssunto.setText("COLETA  : " + rs.getString("mm.DES_TAB"));
				txtDESCRICAOmMULL.setText(rs.getString("mm.DES_TAB"));
				System.out.println(rs.getString("TIME(msgemp.DAT_MENSAGEM)"));

			}
		} catch (Exception ex) {
			System.err.println("FALHA NA BUSCA DO CODIGO mMuLL");
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
	

	public void SelectCodEmpresaEnvioMensagem(cMensagem Cmensagem) {

		conexao c = new conexao();
		try {

			String q = "";

			q += " SELECT COD_EMPRESA FROM coleta WHERE COD_MMULL = ? and COD_COLETA = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmensagem.getCOD_mMuLL());
			comando.setString(2, Cmensagem.getCOD_COLETA());
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmensagem.setCOD_Empresa(rs.getString("COD_EMPRESA"));
			}

		} catch (Exception ex) {
			System.err.println("falha na Cancelamento de Mensagem.");
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

	public void SelectRespostaMensagem(cMensagem Cmensagem) {
		conexao c = new conexao();
		try {

			String q = "";

			q += " SELECT c.SIT_COLETA ";
			q += " FROM coleta c";
			q += " inner join mensagemempresa msgemp on msgemp.COD_MMULL = c.COD_MMULL";
			q += " where msgemp.COD_MENSAGEM =?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1 ,Cmensagem.getCOD_MENSAGEM_USUARIO());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtResposta.setText(rs.getString("c.SIT_COLETA"));
			}
		} catch (Exception ex) {
			System.err.println("falha na Cancelamento de Mensagem.");
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

	public void ExcluirMensagem(cMensagem Cmensagem) {
		int a ;
		a = tblConsulta.getSelectedRow();

	Cmensagem.setCOD_MENSAGEM_USUARIO ((String) (tblConsulta.getValueAt(a, 4)));

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "DELETE FROM mensagemempresa WHERE COD_MENSAGEM=" + Cmensagem.getCOD_MENSAGEM_USUARIO();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("falha na Cancelamento de Mensagem.");
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

	
	public void SelectInformaçoesMensagem(cMensagem Cmensagem) {
		conexao c = new conexao();
		try {

			String q = "";

			q += " SELECT  col.DATA_COLETA , col.PER_COLETA, mm.DES_TAB";
			q += " FROM coleta col";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL = col.COD_MMULL";
			q += " WHERE col.COD_COLETA =?";
			q += " and col.COD_MMULL= ?";
			q += " and col.COD_EMPRESA = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmensagem.getCOD_COLETA());
			comando.setString(2, Cmensagem.getCOD_mMuLL());
			comando.setString(3, Cmensagem.getCOD_Empresa());
			ResultSet rs = comando.executeQuery();
			if (rs.next()) {

				Cmensagem.setDES_TAB(rs.getString("mm.DES_TAB"));
				Cmensagem.setDataColeta( rs.getString("col.DATA_COLETA"));
				Cmensagem.setHoraColeta(rs.getString("col.PER_COLETA"));

			}

			if (rs.next()) {
				txtResposta.setText(rs.getString("c.SIT_COLETA"));
			}
		} catch (Exception ex) {
			System.err.println("falha na Cancelamento de Mensagem.");
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
