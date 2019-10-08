package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Aconexao.conexao;
import abstractTableModel.ModeloTabela;
import beans.Coleta;
import beans.Disponibilidade;
import beans.Endereco;
import beans.Mull;
import beans.Usuario;



public class DAOcoleta {
	public static JTextField txtCidade;
	public static JTextField txtBairo;
	public static JTextField txtEndereco;
	public static JTextField txtCep;
	public static JTextField txtComplemento;
	public static JTextField txtDescricao;
	public static JTextField txtDataSolicitacao;
	public static JTextField txtGenero;
	public static JTextArea txtObs = new JTextArea();
	public static JTextField txtFaixaEtaria;
	public static JTextField txtPcs;
	public static JTable tblConsulta =  new JTable();
	public static JTextField txtCODmMuLL;
	public static JTextField txtPeriodo;
	public static JTextField txtDia;
	public static JTextField txtData;
	public static JTextField txtPeso;
	public static JTextField txtDescricaom;
	Disponibilidade disponibilidade =  new Disponibilidade();
	DAOendereco daoENDERECO =  new DAOendereco();
	DAOmull daoMULL =  new DAOmull();
	DAOdisponibilidade daoDISPONIBILIDADE =  new DAOdisponibilidade();
	Endereco endereco = new Endereco();
	Mull mull = new Mull();
	Coleta coleta = new Coleta();
	
	//INSERT TABELA COLETA---------------------------------------------------------
	
	public void resetVAR(){
		coleta.setCOD_mMuLL("");
		coleta.setDES_TAB("");
		coleta.setDES_BAIRRO("");
		coleta.setDIA_COL("");
		coleta.setHOR_MATUTINO("");
		coleta.setHOR_ALMOCO("");
		coleta.setHOR_VESPERTINO("");
		coleta.setHOR_NOTURNO("");
		coleta.setStringDia("");
		coleta.setCOD_EMPRESA("");
		coleta.setDATACOLETA("");
		coleta.setHORARIO_JTABLE("");
		coleta.setPER_COLETA("");
		coleta.setCOD_COLETA("");
		coleta.setCOD_USUARIO_MULL("");
		coleta.setHOR_COLETA("");
	}
	
	public void ApagaCampostexto(){
		txtDescricaom.setText("");
		txtPeso.setText("");
		txtPcs.setText("");
		txtObs.setText("");
		txtCidade.setText("");
		txtBairo.setText("");
		txtCep.setText("");
		txtEndereco.setText("");
		txtComplemento.setText("");
		txtDescricao.setText("");
		txtDataSolicitacao.setText("");
		
	}
	
	
	public void AGENDARCOLETA(Coleta coleta) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " INSERT INTO coleta";
			q += " (COD_COLETA, DIA_COLETA, COD_MMULL, COD_EMPRESA, DATA_COLETA, PER_COLETA, SIT_COLETA)";
			q += " VALUES (NULL, '" + coleta.getStringDia() + "', " + coleta.getCOD_mMuLL() + ", " + Usuario.getCOD_USUARIO() + ",'"
					+ coleta.getDATACOLETA() + "', '" + coleta.getHORARIO_JTABLE() + "', 'NÃO CONFIRMADA')";
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO endereco ");
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
	//-----------------------------------------------------FIM-INSERT-TABELA-COLETA	
	public void QuerymMuLLEmpresa() {
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[] { "ID mMüLL", "Descricão", " Bairro: ","DIA","HORARIO","HORARIO","HORARIO","HORARIO" };
		
		
		conexao c = new conexao();
		
		try {
			
			String q = "";
			
			q += " SELECT mm.COD_mMuLL, mm.DES_TAB,b.DES_BAIRRO,";
			q += " td.DIA_COL ,th.HOR_MATUTINO, th.HOR_ALMOCO, th.HOR_VESPERTINO, th.HOR_NOTURNO ";
			q += " FROM mmull mm";
			q += " inner join solicitarcoleta sc on sc.COD_mMuLL = mm.COD_mMuLL";
			q += " inner join tabela_horarios th on th.COD_COL_DIS_HOR = sc.COD_COL_DIS_HOR";
			q += " inner join tabela_dias td on td.COD_COL_DIS_DIA = sc.COL_COL_DIS_DIA";
			q += " INNER JOIN usuario u on mm.COD_USUARIO  = u.COD_Usuario";
			q += " inner join dados_usuario dus on dus.COD_DADOS = u.COD_DADOS";
			q += " inner join endereco e on e.COD_ENDERECO = dus.COD_ENDERECO";
			q += " inner join bairro b on b.COD_BAIRRO = e.COD_BAIRRO";
			q += " INNER JOIN cidade c ON c.COD_CIDADE =  b.COD_CIDADE";
			q += " INNER JOIN estado uf ON uf.COD_ESTADO = c.COD_ESTADO ";
			q += " WHERE mm.COL_AGENDADA LIKE '%NÃO%' AND th.COD_COL_DIS_HOR <> (16) ";
			q +=  DAOdisponibilidade.disponibilidade.getDias();
			q +=  DAOendereco.endereco.getLOCAL();
			q +=  DAOmull.mull.getmMull();
			q +=  DAOdisponibilidade.disponibilidade.getPeriodos();
			q += " ORDER BY td.COD_COL_DIS_DIA , e.CEP_ENDERECO , b.DES_BAIRRO , mm.DES_TAB";
			System.out.println(DAOdisponibilidade.disponibilidade.getDias());
			System.out.println(DAOendereco.endereco.getLOCAL());
			System.out.println(DAOmull.mull.getmMull());
			System.out.println(DAOdisponibilidade.disponibilidade.getPeriodos());
			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

				ModeloTabela modelo = new ModeloTabela(dados, colunas);
				tblConsulta.setModel(modelo);
				tblConsulta.setModel(modelo);
				tblConsulta.setShowGrid(false);
				tblConsulta.getTableHeader().setReorderingAllowed(false);
				
				while (rs.next()) {

					dados.add(new Object[] { rs.getString("mm.COD_mMuLL"),rs.getString("mm.DES_TAB"),
							rs.getString("b.DES_BAIRRO"),rs.getString("td.DIA_COL"),rs.getString("th.HOR_MATUTINO"),
							rs.getString("th.HOR_ALMOCO"),rs.getString("th.HOR_VESPERTINO"),rs.getString("th.HOR_NOTURNO")});
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
	
	
	public void QuerymMuLLViewDetalhesEmpresa(Coleta coleta) {
		
		conexao c = new conexao();
		try {

			String q = "";
			q+= "SELECT cid.DES_CIDADE , bai.DES_BAIRRO , e.CEP_ENDERECO , e.END_ENDERECO , e.COM_ENDERECO, mm.DES_TAB ,mm.SOL_USUARIO ";
			q += " FROM mmull mm";
			q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";
			q += " INNER JOIN dados_usuario dus ON dus.COD_DADOS = us.COD_DADOS";
			q += " INNER JOIN endereco e ON e.COD_ENDERECO = dus.COD_ENDERECO";
			q += " INNER JOIN bairro bai ON bai.COD_BAIRRO = e.COD_BAIRRO";
			q += " INNER JOIN cidade cid  ON cid.COD_CIDADE = bai.COD_CIDADE";
			q += " WHERE mm.COD_mMuLL = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1,coleta.getCOD_mMuLL());
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				System.out.println("QuerymMuLLViewDetalhesEmpresa"+coleta.getCOD_mMuLL()); 
				txtCidade.setText(rs.getString("cid.DES_CIDADE"));
				txtBairo.setText(rs.getString("bai.DES_BAIRRO"));
				txtCep.setText(rs.getString("e.CEP_ENDERECO"));
				txtEndereco.setText(rs.getString("e.END_ENDERECO"));
				txtComplemento.setText(rs.getString("e.COM_ENDERECO"));
				txtDescricao.setText(rs.getString("mm.DES_TAB"));
				txtDataSolicitacao.setText(rs.getString("mm.SOL_USUARIO"));
				coleta.setDES_TAB(rs.getString("mm.DES_TAB"));
			
				
				
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
	
	public void QueryColetasAgendadasEmpresa() {
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[] { "DATA AGENDADA", "EM ", " DIA", " PERIODO ",
			"BAIRRO", " TIPO", "STATUS", "ID mMüLL", "COD COLETA",  };
		conexao c = new conexao();
		
		try {
			
			String q = "";
			q += " SELECT  col.DATA_COLETA,col.DIA_COLETA,col.PER_COLETA,b.DES_BAIRRO,";
			q += " mm.DES_TAB ,col.SIT_COLETA,col.COD_MMULL, (DATE(col.DATA_COLETA)-DATE(NOW())), col.COD_COLETA";
			q += " FROM coleta col";
			q += " INNER JOIN mmull mm  ON mm.COD_mMuLL = col.COD_MMULL";
			q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";
			q += " INNER JOIN dados_usuario dus ON dus.COD_DADOS = us.COD_DADOS";
			q += " INNER JOIN endereco en ON en.COD_ENDERECO = dus.COD_ENDERECO";
			q += " INNER JOIN bairro b ON b.COD_BAIRRO = en.COD_BAIRRO";
			q += " INNER JOIN cidade c ON c.COD_CIDADE= b.COD_CIDADE";
			q += " WHERE col.SIT_COLETA LIKE '%confirmada%' AND (DATE (col.DATA_COLETA))>=DATE(NOW())";
			q += " AND col.COD_EMPRESA = ? ";
			q +=  DAOendereco.endereco.getLOCAL();
			q +=  DAOmull.mull.getmMull();
			q += " ORDER BY (DATE(col.DATA_COLETA)-DATE(NOW())) , col.DIA_COLETA , en.COD_BAIRRO, en.CEP_ENDERECO,en.END_ENDERECO";

			

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Usuario.getCOD_USUARIO());
			ResultSet rs = comando.executeQuery();
			ModeloTabela modelo = new ModeloTabela(dados, colunas);
			tblConsulta.setModel(modelo);
			
			tblConsulta.setShowGrid(false);
			
			
			while (rs.next()) {

				dados.add(new Object[] { rs.getString("col.DATA_COLETA"),
						rs.getString("(DATE(col.DATA_COLETA)-DATE(NOW()))") + " DIAS ", 
						rs.getString("col.DIA_COLETA"), 
						rs.getString("col.PER_COLETA"),
						rs.getString("b.DES_BAIRRO"), 
						rs.getString("mm.DES_TAB"), 
						rs.getString("col.SIT_COLETA"), 
						rs.getString("col.COD_MMULL"), 
						rs.getString("col.COD_COLETA"),});
				
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

	//INICIO-QUERYS-PRINCIPAIS---------ROUPAS E CALÇADOS----------------------------
	public void IniciarColetasQuerymMuLL() {
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[] { "iDColeta", " idMüll", "Situação",
				"Horário", " Cidade", "Bairro", "CEP", };
		
		conexao c = new conexao();
			try {

				String q = "";
				q += " SELECT col.COD_COLETA,col.COD_MMULL, col.SIT_COLETA,col.PER_COLETA,ci.DES_CIDADE,";
				q += " ba.DES_BAIRRO,en.CEP_ENDERECO ";
				q += " FROM coleta col";
				q += " INNER JOIN mmull mm ON mm.COD_mMuLL = col.COD_MMULL";
				q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";
				q += " INNER JOIN dados_usuario dus ON dus.COD_DADOS = us.COD_DADOS";
				q += " INNER JOIN endereco en ON en.COD_ENDERECO = dus.COD_ENDERECO";
				q += " INNER JOIN bairro ba ON ba.COD_BAIRRO = en.COD_BAIRRO";
				q += " INNER JOIN cidade ci ON ci.COD_CIDADE = ba.COD_CIDADE";
				q += " WHERE SIT_COLETA = 'CONFIRMADA' AND ";
				q += " DATE(col.DATA_COLETA)= DATE(NOW()) AND col.COD_EMPRESA = ?";
				/*q += periodos;
				q += mMull;
				q +=  local;*/
				q += " ORDER BY ci.DES_CIDADE,en.COD_BAIRRO,en.CEP_ENDERECO";
				
				
				
				//
				
				PreparedStatement comando = c.conn.prepareStatement(q);
				comando.setString(1, Usuario.getCOD_USUARIO());
				ResultSet rs = comando.executeQuery();
				
				ModeloTabela modelo = new ModeloTabela(dados, colunas);
				tblConsulta.setModel(modelo);
				tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(50);
				tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(50);
				tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(120);
				tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(101);
				tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(101);
				tblConsulta.getColumnModel().getColumn(5).setPreferredWidth(120);
				tblConsulta.getColumnModel().getColumn(6).setPreferredWidth(101);
				
				tblConsulta.setShowGrid(false);
				
				while (rs.next()) {
					
					dados.add(new Object[] { 
							
							rs.getString("col.COD_COLETA"),
							rs.getString("col.COD_MMULL"), 
							rs.getString("col.SIT_COLETA"), 
							rs.getString("col.PER_COLETA"), 
							rs.getString("ci.DES_CIDADE"), 
							rs.getString("ba.DES_BAIRRO"), 
							 rs.getString("en.CEP_ENDERECO")
							});	

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
	
	public void QueryColetasAgendadasRoupasEcalcados() {
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[] { "DATA AGENDADA", "EM ", " DIA", " PERIODO ",
			"BAIRRO", " TIPO", "STATUS", "ID mMüLL", "COD COLETA"  };
		conexao c = new conexao();
		
		try {
			
			String q = "";
			q += " SELECT  col.DATA_COLETA,col.DIA_COLETA,col.PER_COLETA,b.DES_BAIRRO,";
			q += " rpc.TIP_ROUPASCALCADOS ,col.SIT_COLETA,col.COD_MMULL, (DATE(col.DATA_COLETA)-DATE(NOW())), col.COD_COLETA";
			q += " FROM coleta col";
			q += " INNER JOIN mmull mm  ON mm.COD_mMuLL = col.COD_MMULL";
			q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";
			q += " INNER JOIN dados_usuario dus ON dus.COD_DADOS = us.COD_DADOS";
			q += " INNER JOIN endereco en ON en.COD_ENDERECO = dus.COD_ENDERECO";
			q += " INNER JOIN roupascalcados rpc ON rpc.COD_ROUPASCALCADOS= mm.COD_ROUPASCALCADOS";
			q += " INNER JOIN bairro b ON b.COD_BAIRRO = en.COD_BAIRRO";
			q += " INNER JOIN cidade c ON c.COD_CIDADE= b.COD_CIDADE";
			q += " WHERE col.SIT_COLETA LIKE '%confirmada%' AND (DATE (col.DATA_COLETA))>=DATE(NOW())";
			q += " AND col.COD_EMPRESA = ? ";
			q +=  DAOendereco.endereco.getLOCAL();
			q +=  DAOmull.mull.getmMull();
			q += " ORDER BY (DATE(col.DATA_COLETA)-DATE(NOW())) , col.DIA_COLETA , en.COD_BAIRRO, en.CEP_ENDERECO,en.END_ENDERECO";

			

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Usuario.getCOD_USUARIO());
			ResultSet rs = comando.executeQuery();
			ModeloTabela modelo = new ModeloTabela(dados, colunas);
			tblConsulta.setModel(modelo);
			
			tblConsulta.setShowGrid(false);
			
			
			while (rs.next()) {

				dados.add(new Object[] { rs.getString("col.DATA_COLETA"),
						rs.getString("(DATE(col.DATA_COLETA)-DATE(NOW()))") + " DIAS ", 
						rs.getString("col.DIA_COLETA"), 
						rs.getString("col.PER_COLETA"),
						rs.getString("b.DES_BAIRRO"), 
						rs.getString("rpc.TIP_ROUPASCALCADOS"), 
						rs.getString("col.SIT_COLETA"), 
						rs.getString("col.COD_MMULL"), 
						rs.getString("col.COD_COLETA"),});
				
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
	
	public void QuerymMuLLROUPASeCalcados() {
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[] { "ID mMüLL", "Descricão", " Bairro: ","DIA","HORARIO","HORARIO","HORARIO","HORARIO" };
		
		
		conexao c = new conexao();
		
		try {
			
			String q = "";
			q += " SELECT mm.COD_mMuLL, rpc.TIP_ROUPASCALCADOS,b.DES_BAIRRO,";
			q += " td.DIA_COL ,th.HOR_MATUTINO, th.HOR_ALMOCO, th.HOR_VESPERTINO, th.HOR_NOTURNO ";
			q += " FROM mmull mm";
			q += " inner join solicitarcoleta sc on sc.COD_mMuLL = mm.COD_mMuLL";
			q += " inner join tabela_horarios th on th.COD_COL_DIS_HOR = sc.COD_COL_DIS_HOR";
			q += " inner join tabela_dias td on td.COD_COL_DIS_DIA = sc.COL_COL_DIS_DIA";
			q += " INNER JOIN usuario u on mm.COD_USUARIO  = u.COD_Usuario";
			q += " inner join dados_usuario dus on dus.COD_DADOS = u.COD_DADOS";
			q += " inner join endereco e on e.COD_ENDERECO = dus.COD_ENDERECO";
			q += " inner join bairro b on b.COD_BAIRRO = e.COD_BAIRRO";
			q += " INNER JOIN roupascalcados rpc ON rpc.COD_ROUPASCALCADOS= mm.COD_ROUPASCALCADOS";
			q += " INNER JOIN cidade c ON c.COD_CIDADE =  b.COD_CIDADE";
			q += " INNER JOIN estado uf ON uf.COD_ESTADO = c.COD_ESTADO ";
			q += " WHERE mm.COL_AGENDADA LIKE '%NÃO%' AND th.COD_COL_DIS_HOR <> (16) ";
			q +=  DAOdisponibilidade.disponibilidade.getDias();
			q +=  DAOendereco.endereco.getLOCAL();
			q +=  DAOmull.mull.getmMull();
			q +=  DAOdisponibilidade.disponibilidade.getPeriodos();
			q += " ORDER BY td.COD_COL_DIS_DIA , e.CEP_ENDERECO , b.DES_BAIRRO , mm.DES_TAB";
			System.out.println(DAOdisponibilidade.disponibilidade.getDias());
			System.out.println(DAOendereco.endereco.getLOCAL());
			System.out.println(DAOmull.mull.getmMull());
			System.out.println(DAOdisponibilidade.disponibilidade.getPeriodos());
			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

				ModeloTabela modelo = new ModeloTabela(dados, colunas);
				tblConsulta.setModel(modelo);
				tblConsulta.setModel(modelo);
				tblConsulta.setShowGrid(false);
				tblConsulta.getTableHeader().setReorderingAllowed(false);
				
				while (rs.next()) {

					dados.add(new Object[] { rs.getString("mm.COD_mMuLL"),rs.getString("rpc.TIP_ROUPASCALCADOS"),
							rs.getString("b.DES_BAIRRO"),rs.getString("td.DIA_COL"),rs.getString("th.HOR_MATUTINO"),
							rs.getString("th.HOR_ALMOCO"),rs.getString("th.HOR_VESPERTINO"),rs.getString("th.HOR_NOTURNO"),0});
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
	
	public void QueryCOLETAfinalizarColeta(Coleta coleta){ 
		
		conexao c = new conexao();

	try {
		
		String q = "";
		q += " SELECT col.DATA_COLETA ,TIME(NOW()) , us.COD_Usuario";
		q += " FROM coleta col ";
		q += " INNER JOIN empresa em ON em.COD_Empresa = col.COD_EMPRESA";
		q += " INNER JOIN mmull mm ON mm.COD_mMuLL = col.COD_mMuLL";
		q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";
		q += " WHERE col.COD_COLETA = ? AND col.COD_EMPRESA = ?  ";

		PreparedStatement comando = c.conn.prepareStatement(q);
		comando.setString(1, coleta.getCOD_COLETA());
		comando.setString(2, Usuario.getCOD_USUARIO());
		
		ResultSet rs = comando.executeQuery();

		if (rs.next()) {
			coleta.setDATACOLETA(rs.getString("col.DATA_COLETA"));
			coleta.setHOR_COLETA(rs.getString("TIME(NOW())"));
			coleta.setCOD_USUARIO_MULL(rs.getString("us.COD_Usuario"));
		}

	} catch (Exception ex) {
		System.err.println("Falha gedCOD_Coleta() ");
		ex.printStackTrace();

	} finally {
		if (c.conn != null) {
			try {
				c.conn.close();
			} catch (Exception ex) {
				System.err.println("Error in conection terminal");
			}
		}}}
	
	public void QueryCodColeta(Coleta coleta) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT col.COD_COLETA , us.COD_Usuario , col.COD_COLETA";
			q += " FROM coleta col";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL = col.COD_MMULL";
			q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";

			q += " WHERE col.COD_MMULL = ? AND col.COD_EMPRESA = ? and col.COD_COLETA = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, coleta.getCOD_mMuLL());
			comando.setString(2, Usuario.getCOD_USUARIO());
			comando.setString(3, coleta.getCOD_COLETA());
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				coleta.setCOD_USUARIO_MULL(rs.getString("us.COD_Usuario"));
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
	
	public void QuerymMuLLViewDetalhesRoupasEcalcados(Coleta coleta) {
		
		conexao c = new conexao();
		try {

			String q = "";
			q+= "SELECT cid.DES_CIDADE , bai.DES_BAIRRO , e.CEP_ENDERECO , e.END_ENDERECO , e.COM_ENDERECO, mm.DES_TAB ,mm.SOL_USUARIO , rc.PCS_ROUPASCALCADOS , rc.OBS_ROUPASCALCADOS , rc.FAI_ROUPASCALCADOS , rc.GEN_ROUPASCALCADOS ,rc.TIP_ROUPASCALCADOS";
			q += " FROM mmull mm";
			q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";
			q += " INNER JOIN dados_usuario dus ON dus.COD_DADOS = us.COD_DADOS";
			q += " INNER JOIN endereco e ON e.COD_ENDERECO = dus.COD_ENDERECO";
			q += " INNER JOIN bairro bai ON bai.COD_BAIRRO = e.COD_BAIRRO";
			q += " INNER JOIN roupascalcados rc on rc.COD_ROUPASCALCADOS = mm.COD_ROUPASCALCADOS ";
			q += " INNER JOIN cidade cid  ON cid.COD_CIDADE = bai.COD_CIDADE";
			q += " WHERE mm.COD_mMuLL = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1,coleta.getCOD_mMuLL());
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				 
				txtCidade.setText(rs.getString("cid.DES_CIDADE"));
				txtBairo.setText(rs.getString("bai.DES_BAIRRO"));
				txtCep.setText(rs.getString("e.CEP_ENDERECO"));
				txtEndereco.setText(rs.getString("e.END_ENDERECO"));
				txtComplemento.setText(rs.getString("e.COM_ENDERECO"));
				txtDescricao.setText(rs.getString("rc.TIP_ROUPASCALCADOS"));
				txtDataSolicitacao.setText(rs.getString("mm.SOL_USUARIO"));
				txtObs.setText(rs.getString("rc.OBS_ROUPASCALCADOS"));
				txtPcs.setText(rs.getString("rc.PCS_ROUPASCALCADOS"));
				txtFaixaEtaria.setText(rs.getString("rc.FAI_ROUPASCALCADOS"));
				txtGenero.setText(rs.getString("rc.GEN_ROUPASCALCADOS"));
				
				
			}
		} catch (Exception ex) {
			System.err.println("FALHA NA inserção dos dados");
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
	
	//------------------------ROUPAS-E-CALCADOS-------------------------FIM-QUERYS-PRINCIPAIS
	
	
	
	
	//INICIO-UPDATE-COLETA-TABELA-COLETA--------------------------------------------
	public void UpdateCOLETA_NAO_COLETADA(Coleta coleta){
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " UPDATE coleta";
			q += " SET";
			q += " PER_COLETA='"+coleta.getHOR_COLETA()+"',";
			q += " SIT_COLETA='CANCELADA'";
			q += " WHERE COD_COLETA = "+coleta.getCOD_COLETA()+"  AND COD_EMPRESA = "+Usuario.getCOD_USUARIO();
			
				comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha UpdateCOLETA_NAO_COLETADA()");
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
	
	public void UpdateCOLETA_COLETADA(Coleta coleta){
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); 
			String q = "";

			q += " UPDATE coleta";
			q += " SET";
			q += " PER_COLETA='"+coleta.getHOR_COLETA()+"',";
			q += " SIT_COLETA='COLETADA'";
			q += " WHERE COD_COLETA = "+coleta.getCOD_COLETA()+"  AND COD_EMPRESA = "+Usuario.getCOD_USUARIO();
			
				comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha UpdateCOLETA_COLETADA()");
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
	
	public void Cancelar_COL_AGENDADA(Coleta coleta) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " UPDATE coleta";
			q += " SET";

			q += " 	DIA_COLETA='" + coleta.getStringDia() + "',";
			q += " 	COD_MMULL=" + coleta.getCOD_mMuLL() + ",";
			q += " 	COD_EMPRESA=" + Usuario.getCOD_USUARIO() + ",";
			q += " 	DATA_COLETA='" + coleta.getDATACOLETA() + "',";
			q += " 	PER_COLETA='" + coleta.getHORARIO_JTABLE() + "',";
			q += " 	SIT_COLETA='CANCELADA PELA EMPRESA'";
			q += " WHERE COD_COLETA= " + coleta.getCOD_COLETA();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha Cancelar_COL_AGENDADA");
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
	//-------------------------------------------------------FIM-UPDATE-TABELA-COLETA
	
	
	
	//INICIO-UPDATE-TABELA-MMULL-----------------------------------------------------
	public void UpdatemMuLLcoletaAgendadaNAO(Coleta coleta) {

		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql
															// em
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " 	COL_AGENDADA = 'NÃO'";
			q += " WHERE COD_mMuLL = " + coleta.getCOD_mMuLL();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FAlha UpdatemMuLLcoletaAgendadaNAO");
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

	public void UpdatemMuLL_NAO_COLETADA(Coleta coleta){
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " COL_AGENDADA='NÃO'";
			q += " WHERE COD_mMuLL = "+coleta.getCOD_mMuLL();
			
				comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha UpdateCOLETA_NAO_COLETADA()");
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
	
	public void UpdatemMullCOLETADA(Coleta coleta){
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " COL_AGENDADA='COLETADA'";
			q += " WHERE COD_mMuLL = "+coleta.getCOD_mMuLL();
			
				comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha UpdateCOLETA_COLETADA()");
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
	
	public void UPDATEMMULL_COL_AGENDADA(Coleta coleta) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " COL_AGENDADA='SIM'";
			q += " WHERE COD_mMuLL = " + coleta.getCOD_mMuLL();
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha UPDATE COD_MMUL COLETA AGENDADA SIM ");
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
	
	//----------------------------------------------------------FIM-UPDATE-TABELA-MMULL
	public void INFORMACOESCOLETA(Coleta coleta) {
		JOptionPane.showMessageDialog(null, "Coleta agendada para a data : " + coleta.getDATACOLETA()
				+ " - No período :  " + coleta.getHORARIO_JTABLE());
	}
	
	public void INFORMACOESCOLETASOLICITADA(Coleta coleta) {
		JOptionPane.showMessageDialog(null, "Coleta Solicitada na data : " + coleta.getDATACOLETA()
				+ " - para o período :  " + coleta.getHORARIO_JTABLE());
	}

	public void APAGAQuerymMuLLViewDetalhesRoupasEcalcados(){
	txtCidade.setText("");
	txtBairo.setText("");
	txtCep.setText("");
	txtEndereco.setText("");
	txtComplemento.setText("");
	txtDescricao.setText("");
	txtDataSolicitacao.setText("");
	txtObs.setText("");
	txtPcs.setText("");
	txtFaixaEtaria.setText("");
	txtGenero.setText("");
	}
	public void APAGAQuerymMuLLViewDetalhesEmpresatexto(){
		txtCidade.setText("");
		txtBairo.setText("");
		txtCep.setText("");
		txtEndereco.setText("");
		txtComplemento.setText("");
		txtDescricao.setText("");
		txtDataSolicitacao.setText("");
		txtObs.setText("");
		txtPcs.setText("");
		txtFaixaEtaria.setText("");
		txtGenero.setText("");
		}
	public void ApagaCampotexto(){
		txtCidade.setText("");
		txtBairo.setText("");
		txtEndereco.setText("");
		txtCep.setText("");
		txtComplemento.setText("");
		txtDescricao.setText("");
		txtDataSolicitacao.setText("");
		txtGenero.setText("");
		txtObs .setText("");
		txtFaixaEtaria.setText("");
		txtPcs.setText("");
		
		txtCODmMuLL.setText("");
		txtPeriodo.setText("");
		txtDia.setText("");
		txtData.setText("");
		txtPeso.setText("");
		txtDescricaom.setText("");
	}
	}
