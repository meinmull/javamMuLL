package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import Aconexao.conexao;
import beansCliente.cDisponibilidade;
import beansCliente.cMull;

public class cDAOdisponibilidade {
	public JTextField SEGMI;
	public JTextField TERMI;
	public JTextField QUAMI;
	public JTextField QUIMI;
	public JTextField SEXMI;
	public JTextField SABMI;
	public JTextField SEXAI;
	public JTextField QUIAF;
	public JTextField QUIAI;
	public JTextField QUAAF;
	public JTextField QUAAI;
	public JTextField TERAF;
	public JTextField TERAI;
	public JTextField SEGAF;
	public JTextField SEGAI;
	public JTextField SABMF;
	public JTextField SEXMF;
	public JTextField QUIMF;
	public JTextField QUAMF;
	public JTextField TERMF;
	public JTextField SEGMF;
	public JTextField SABNI;
	public JTextField SABNF;
	public JTextField SEXNF;
	public JTextField SEXNI;
	public JTextField QUINF;
	public JTextField QUINI;
	public JTextField QUANF;
	public JTextField QUANI;
	public JTextField TERNF;
	public JTextField TERNI;
	public JTextField SEGNF;
	public JTextField SEGNI;
	public JTextField SABVF;
	public JTextField SABVI;
	public JTextField SEXVF;
	public JTextField SEXVI;
	public JTextField QUIVF;
	public JTextField QUIVI;
	public JTextField QUAVF;
	public JTextField QUAVI;
	public JTextField TERVF;
	public JTextField TERVI;
	public JTextField SEGVF;
	public JTextField SEGVI;
	public JTextField SABAF;
	public JTextField SABAI;
	public JTextField SEXAF;
	
	public static JTextField txtCOD_MULL;
	public JCheckBox chckSab = new JCheckBox("S\u00E1bado");
	public JCheckBox chckSex = new JCheckBox("Sexta-feira");
	public JCheckBox chckQui = new JCheckBox("Quinta-feira");
	public JCheckBox chckQua = new JCheckBox("Quarta-feira");
	public JCheckBox chckSeg = new JCheckBox("Segunda-feira");
	public JCheckBox chckTer = new JCheckBox("Ter\u00E7a-feira");
	public JCheckBox CKSABMAT = new JCheckBox("");
	public JCheckBox CKSEXMAT = new JCheckBox("");
	public JCheckBox CKQUAMAT = new JCheckBox("");
	public JCheckBox CKTERMAT = new JCheckBox("");
	public JCheckBox CKSEGMAT = new JCheckBox("");
	public JCheckBox CKQUIALM = new JCheckBox("");
	public JCheckBox CKQUAALM = new JCheckBox("");
	public JCheckBox CKTERALM = new JCheckBox("");
	public JCheckBox CKSEGALM = new JCheckBox("");
	public JCheckBox CKSEXALM = new JCheckBox("");
	public JCheckBox CKSABALM = new JCheckBox("");
	public JCheckBox CKSEGVES = new JCheckBox("");
	public JCheckBox CKSABVES = new JCheckBox("");
	public JCheckBox CKSEGNOT = new JCheckBox("");
	public JCheckBox CKTERVES = new JCheckBox("");
	public JCheckBox CKQUIVES = new JCheckBox("");
	public JCheckBox CKQUAVES = new JCheckBox("");
	public JCheckBox CKSEXVES = new JCheckBox("");
	public JCheckBox CKTERNOT = new JCheckBox("");
	public JCheckBox CKQUANOT = new JCheckBox("");
	public JCheckBox CKQUINOT = new JCheckBox("");
	public JCheckBox CKSEXNOT = new JCheckBox("");
	public JCheckBox CKSABNOT = new JCheckBox("");
	public JCheckBox CKQUIMAT = new JCheckBox("");
	
	public void txtcDAOeditableFALSE(){
	SEGMI.setEditable(false); 
	TERMI.setEditable(false); 
	QUAMI.setEditable(false);
	QUIMI.setEditable(false);
	SEXMI.setEditable(false);
	SABMI.setEditable(false);
	SEXAI.setEditable(false);
	QUIAF.setEditable(false);
	QUIAI.setEditable(false);
	QUAAF.setEditable(false);
	QUAAI.setEditable(false);
	TERAF.setEditable(false);
	TERAI.setEditable(false);
	SEGAF.setEditable(false);
	SEGAI.setEditable(false);
	SABMF.setEditable(false);
	SEXMF.setEditable(false);
	QUIMF.setEditable(false);
	QUAMF.setEditable(false);
	TERMF.setEditable(false);
	SEGMF.setEditable(false);
	SABNI.setEditable(false);
	SABNF.setEditable(false); 
	SEXNF.setEditable(false); 
	SEXNI.setEditable(false); 
	QUINF.setEditable(false); 
	QUINI.setEditable(false); 
	QUANF.setEditable(false); 
	QUANI.setEditable(false); 
	TERNF.setEditable(false); 
	TERNI.setEditable(false); 
	SEGNF.setEditable(false);
	SEGNI.setEditable(false); 
	SABVF.setEditable(false);
	SABVI.setEditable(false);
	SEXVF.setEditable(false);
	SEXVI.setEditable(false);
	QUIVF.setEditable(false);
	QUIVI.setEditable(false);
	QUAVF.setEditable(false); 
	QUAVI.setEditable(false); 
	TERVF.setEditable(false); 
	TERVI.setEditable(false); 
	SEGVF.setEditable(false); 
	SEGVI.setEditable(false); 
	SABAF.setEditable(false); 
	SABAI.setEditable(false); 
	SEXAF.setEditable(false);
	}
	
	
	
	cDisponibilidade cDISPONIBILIDADE = new cDisponibilidade();

	public void QueryDisponibilidadeDias(cDisponibilidade cDISPONIBILIDADE) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT COL_COL_DIS_DIA, COD_COL_DIS_HOR";
			q += " FROM solicitarcoleta";
			q += " WHERE COD_mMuLL = ? ";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cDISPONIBILIDADE.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				cDISPONIBILIDADE.setDias(rs.getString("COL_COL_DIS_DIA"));
				cDISPONIBILIDADE.setHorario((rs.getString("COD_COL_DIS_HOR")));

				if (cDISPONIBILIDADE.getDias().equals("1")) {
					chckSeg.setSelected(true);
					horarioColetaSegundaREPOSICAO(cDISPONIBILIDADE);
				}
				if (cDISPONIBILIDADE.getDias().equals("2")) {
					chckTer.setSelected(true);
					horarioColetaTerREPOSICAO(cDISPONIBILIDADE);
				}
				if (cDISPONIBILIDADE.getDias().equals("3")) {
					chckQua.setSelected(true);
					horarioColetaQUAREPOSICAO(cDISPONIBILIDADE);
				}
				if (cDISPONIBILIDADE.getDias().equals("4")) {
					chckQui.setSelected(true);
					horarioColetaQUIREPOSICAO(cDISPONIBILIDADE);
				}
				if (cDISPONIBILIDADE.getDias().equals("5")) {
					chckSex.setSelected(true);
					horarioColetaSEXREPOSICAO(cDISPONIBILIDADE);
				}
				if (cDISPONIBILIDADE.getDias().equals("6")) {
					chckSab.setSelected(true);
					horarioColetaSABREPOSICAO(cDISPONIBILIDADE);
				}

				DisponibilidadeColetaMatutino();
				DisponibilidadeColetaALMOCO();
				DisponibilidadeColetaVespertino();
				DisponibilidadeColetaNOTURNO();
				DisponibilidadeColetaMatutinoNON();
				DisponibilidadeColetaALMOCONON();
				DisponibilidadeColetaVespertinoNON();
				DisponibilidadeColetaNOTURNONON();
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
	
	public void uPDATEHorarioColetaSegunda(cDisponibilidade cDISPONIBILIDADE) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE solicitarcoleta SET COD_COL_DIS_HOR = " + cDISPONIBILIDADE.getCOD_HOR_SEG()
					+ " WHERE COL_COL_DIS_DIA= 1 AND COD_mMuLL = " + cDISPONIBILIDADE.getCOD_MULL();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  INSERT INTO solicitacaocoletameta segunda ");
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

	public void uPDATEHorarioColetaTerca(cDisponibilidade cDISPONIBILIDADE) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE solicitarcoleta SET COD_COL_DIS_HOR = " + cDISPONIBILIDADE.getCOD_HOR_TER()
					+ " WHERE COL_COL_DIS_DIA= 2 AND COD_mMuLL = " + cDISPONIBILIDADE.getCOD_MULL();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO solicitacaocoletametal terca ");
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

	public void uPDATEHorarioColetaQuarta(cDisponibilidade cDISPONIBILIDADE) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE solicitarcoleta SET COD_COL_DIS_HOR = " + cDISPONIBILIDADE.getCOD_HOR_QUA()
					+ " WHERE COL_COL_DIS_DIA= 3 AND COD_mMuLL = " + cDISPONIBILIDADE.getCOD_MULL();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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

	public void uPDATEHorarioColetaQuinta(cDisponibilidade cDISPONIBILIDADE) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE solicitarcoleta SET COD_COL_DIS_HOR = " + cDISPONIBILIDADE.getCOD_HOR_QUI()
					+ " WHERE COL_COL_DIS_DIA= 4 AND COD_mMuLL = " + cDISPONIBILIDADE.getCOD_MULL();
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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

	public void uPDATEHorarioColetaSexta(cDisponibilidade cDISPONIBILIDADE) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE solicitarcoleta SET COD_COL_DIS_HOR = " + cDISPONIBILIDADE.getCOD_HOR_SEX()
					+ " WHERE COL_COL_DIS_DIA= 5 AND COD_mMuLL = " + cDISPONIBILIDADE.getCOD_MULL();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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

	public void uPDATEHorarioColetaSabado(cDisponibilidade cDISPONIBILIDADE) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE solicitarcoleta SET COD_COL_DIS_HOR = " + cDISPONIBILIDADE.getCOD_HOR_SAB()
					+ " WHERE COL_COL_DIS_DIA= 6 AND COD_mMuLL = " + cDISPONIBILIDADE.getCOD_MULL();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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

	public void horarioColetaSegundaREPOSICAO(cDisponibilidade cDISPONIBILIDADE) {

		if (cDISPONIBILIDADE.getHorario().equals("1")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("2")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("3")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(false);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("4")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("5")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(false);
			CKSEGNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("6")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(false);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("7")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("8")) {
			CKSEGMAT.setSelected(false);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("9")) {
			CKSEGMAT.setSelected(false);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("10")) {
			CKSEGMAT.setSelected(false);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(false);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("11")) {
			CKSEGMAT.setSelected(false);
			CKSEGALM.setSelected(true);
			CKSEGVES.setSelected(false);
			CKSEGNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("12")) {
			CKSEGMAT.setSelected(false);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("13")) {
			CKSEGMAT.setSelected(false);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(false);
			CKSEGNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("14")) {
			CKSEGMAT.setSelected(false);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(true);
			CKSEGNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("15")) {
			CKSEGMAT.setSelected(true);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(false);
			CKSEGNOT.setSelected(false);
		}
	}

	public void horarioColetaTerREPOSICAO(cDisponibilidade cDISPONIBILIDADE) {

		if (cDISPONIBILIDADE.getHorario().equals("1")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("2")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("3")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(false);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("4")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("5")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(false);
			CKTERNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("6")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(false);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("7")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("8")) {
			CKTERMAT.setSelected(false);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("9")) {
			CKTERMAT.setSelected(false);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("10")) {
			CKTERMAT.setSelected(false);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(false);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("11")) {
			CKTERMAT.setSelected(false);
			CKTERALM.setSelected(true);
			CKTERVES.setSelected(false);
			CKTERNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("12")) {
			CKTERMAT.setSelected(false);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("13")) {
			CKTERMAT.setSelected(false);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(false);
			CKTERNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("14")) {
			CKTERMAT.setSelected(false);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(true);
			CKTERNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("15")) {
			CKTERMAT.setSelected(true);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(false);
			CKTERNOT.setSelected(false);
		}
	}

	public void horarioColetaQUAREPOSICAO(cDisponibilidade cDISPONIBILIDADE) {

		if (cDISPONIBILIDADE.getHorario().equals("1")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("2")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("3")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(false);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("4")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("5")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(false);
			CKQUANOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("6")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(false);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("7")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("8")) {
			CKQUAMAT.setSelected(false);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("9")) {
			CKQUAMAT.setSelected(false);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("10")) {
			CKQUAMAT.setSelected(false);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(false);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("11")) {
			CKQUAMAT.setSelected(false);
			CKQUAALM.setSelected(true);
			CKQUAVES.setSelected(false);
			CKQUANOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("12")) {
			CKQUAMAT.setSelected(false);
			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("13")) {
			CKQUAMAT.setSelected(false);
			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(false);
			CKQUANOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("14")) {
			CKQUAMAT.setSelected(false);
			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(true);
			CKQUANOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("15")) {
			CKQUAMAT.setSelected(true);
			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(false);
			CKQUANOT.setSelected(false);
		}
	}

	public void horarioColetaQUIREPOSICAO(cDisponibilidade cDISPONIBILIDADE) {

		if (cDISPONIBILIDADE.getHorario().equals("1")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("2")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("3")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(false);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("4")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("5")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(false);
			CKQUINOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("6")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(false);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("7")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("8")) {
			CKQUIMAT.setSelected(false);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("9")) {
			CKQUIMAT.setSelected(false);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("10")) {
			CKQUIMAT.setSelected(false);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(false);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("11")) {
			CKQUIMAT.setSelected(false);
			CKQUIALM.setSelected(true);
			CKQUIVES.setSelected(false);
			CKQUINOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("12")) {
			CKQUIMAT.setSelected(false);
			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("13")) {
			CKQUIMAT.setSelected(false);
			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(false);
			CKQUINOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("14")) {
			CKQUIMAT.setSelected(false);
			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(true);
			CKQUINOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("15")) {
			CKQUIMAT.setSelected(true);
			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(false);
			CKQUINOT.setSelected(false);
		}
	}

	public void horarioColetaSEXREPOSICAO(cDisponibilidade cDISPONIBILIDADE) {

		if (cDISPONIBILIDADE.getHorario().equals("1")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("2")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(false);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("3")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(false);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("4")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("5")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(false);
			CKSEXNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("6")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(false);
			CKSEXVES.setSelected(false);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("7")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(false);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("8")) {
			CKSEXMAT.setSelected(false);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("9")) {
			CKSEXMAT.setSelected(false);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("10")) {
			CKSEXMAT.setSelected(false);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(false);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("11")) {
			CKSEXMAT.setSelected(false);
			CKSEXALM.setSelected(true);
			CKSEXVES.setSelected(false);
			CKSEXNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("12")) {
			CKSEXMAT.setSelected(false);
			CKSEXALM.setSelected(false);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("13")) {
			CKSEXMAT.setSelected(false);
			CKSEXALM.setSelected(false);
			CKSEXVES.setSelected(false);
			CKSEXNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("14")) {
			CKSEXMAT.setSelected(false);
			CKSEXALM.setSelected(false);
			CKSEXVES.setSelected(true);
			CKSEXNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("15")) {
			CKSEXMAT.setSelected(true);
			CKSEXALM.setSelected(false);
			CKSEXVES.setSelected(false);
			CKSEXNOT.setSelected(false);
		}
	}

	public void horarioColetaSABREPOSICAO(cDisponibilidade cDISPONIBILIDADE) {

		if (cDISPONIBILIDADE.getHorario().equals("1")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("2")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(false);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("3")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(false);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("4")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("5")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(false);
			CKSABNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("6")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(false);
			CKSABVES.setSelected(false);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("7")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(false);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("8")) {
			CKSABMAT.setSelected(false);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("9")) {
			CKSABMAT.setSelected(false);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("10")) {
			CKSABMAT.setSelected(false);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(false);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("11")) {
			CKSABMAT.setSelected(false);
			CKSABALM.setSelected(true);
			CKSABVES.setSelected(false);
			CKSABNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("12")) {
			CKSABMAT.setSelected(false);
			CKSABALM.setSelected(false);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("13")) {
			CKSABMAT.setSelected(false);
			CKSABALM.setSelected(false);
			CKSABVES.setSelected(false);
			CKSABNOT.setSelected(true);
		} else if (cDISPONIBILIDADE.getHorario().equals("14")) {
			CKSABMAT.setSelected(false);
			CKSABALM.setSelected(false);
			CKSABVES.setSelected(true);
			CKSABNOT.setSelected(false);
		} else if (cDISPONIBILIDADE.getHorario().equals("15")) {
			CKSABMAT.setSelected(true);
			CKSABALM.setSelected(false);
			CKSABVES.setSelected(false);
			CKSABNOT.setSelected(false);
		}
	}

	public void horarioColetaSegunda(cDisponibilidade cDISPONIBILIDADE) {
		if ((CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (CKSEGVES.isSelected()) && (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("1");

		} else if ((CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (CKSEGVES.isSelected())
				&& (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("2");
		} else if ((CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("3");
		} else if ((CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("4");
		} else if ((CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("5");
		} else if ((CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("6");
		} else if ((CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("7");
		} else if ((!CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (CKSEGVES.isSelected())
				&& (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("8");
		} else if ((!CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("9");
		} else if ((!CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("10");
		} else if ((!CKSEGMAT.isSelected()) && (CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("11");
		} else if ((!CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (CKSEGVES.isSelected())
				&& (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("12");
		} else if ((!CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("13");
		} else if ((!CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("14");
		} else if ((CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEG("15");
		} else if ((!CKSEGMAT.isSelected()) && (!CKSEGALM.isSelected()) && (!CKSEGVES.isSelected())
				&& (!CKSEGNOT.isSelected()))
			cDISPONIBILIDADE.setCOD_HOR_SEG("16");
		else
			cDISPONIBILIDADE.setCOD_HOR_SEG("16");

	}

	public void horarioColetaTerca(cDisponibilidade cDISPONIBILIDADE) {
		if ((CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (CKTERVES.isSelected()) && (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("1");

		} else if ((CKSEGMAT.isSelected()) && (!CKTERALM.isSelected()) && (CKTERVES.isSelected())
				&& (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("2");
		} else if ((CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("3");
		} else if ((CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("4");
		} else if ((CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("5");
		} else if ((CKTERMAT.isSelected()) && (!CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("6");
		} else if ((CKTERMAT.isSelected()) && (!CKTERALM.isSelected()) && (CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("7");
		} else if ((!CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (CKTERVES.isSelected())
				&& (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("8");
		} else if ((!CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("9");
		} else if ((!CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("10");
		} else if ((!CKTERMAT.isSelected()) && (CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("11");
		} else if ((!CKTERMAT.isSelected()) && (!CKTERALM.isSelected()) && (CKTERVES.isSelected())
				&& (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("12");
		} else if ((!CKTERMAT.isSelected()) && (!CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("13");
		} else if ((!CKTERMAT.isSelected()) && (!CKTERALM.isSelected()) && (CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("14");
		} else if ((CKTERMAT.isSelected()) && (!CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("15");
		} else if ((!CKTERMAT.isSelected()) && (!CKTERALM.isSelected()) && (!CKTERVES.isSelected())
				&& (!CKTERNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_TER("16");
		} else
			cDISPONIBILIDADE.setCOD_HOR_TER("16");

	}

	public void horarioColetaQuarta(cDisponibilidade cDISPONIBILIDADE) {
		if ((CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (CKQUAVES.isSelected()) && (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("1");

		} else if ((CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (CKQUAVES.isSelected())
				&& (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("2");
		} else if ((CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("3");
		} else if ((CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("4");
		} else if ((CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("5");
		} else if ((CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("6");
		} else if ((CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("7");
		} else if ((!CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (CKQUAVES.isSelected())
				&& (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("8");
		} else if ((!CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("9");
		} else if ((!CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("10");
		} else if ((!CKQUAMAT.isSelected()) && (CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("11");
		} else if ((!CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (CKQUAVES.isSelected())
				&& (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("12");
		} else if ((!CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("13");
		} else if ((!CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("14");
		} else if ((CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("15");
		} else if ((!CKQUAMAT.isSelected()) && (!CKQUAALM.isSelected()) && (!CKQUAVES.isSelected())
				&& (!CKQUANOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUA("16");
		} else
			cDISPONIBILIDADE.setCOD_HOR_QUA("16");

	}

	public void horarioColetaQuinta(cDisponibilidade cDISPONIBILIDADE) {
		if ((CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (CKQUIVES.isSelected()) && (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("1");

		} else if ((CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (CKQUIVES.isSelected())
				&& (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("2");
		} else if ((CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("3");
		} else if ((CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("4");
		} else if ((CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("5");
		} else if ((CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("6");
		} else if ((CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("7");
		} else if ((!CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (CKQUIVES.isSelected())
				&& (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("8");
		} else if ((!CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("9");
		} else if ((!CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("10");
		} else if ((!CKQUIMAT.isSelected()) && (CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("11");
		} else if ((!CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (CKQUIVES.isSelected())
				&& (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("12");
		} else if ((!CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("13");
		} else if ((!CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("14");
		} else if ((CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("15");
		} else if ((!CKQUIMAT.isSelected()) && (!CKQUIALM.isSelected()) && (!CKQUIVES.isSelected())
				&& (!CKQUINOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_QUI("16");
		} else
			cDISPONIBILIDADE.setCOD_HOR_QUI("16");
	}

	public void horarioColetaSexta(cDisponibilidade cDISPONIBILIDADE) {
		if ((CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (CKSEXVES.isSelected()) && (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("1");

		} else if ((CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (CKSEXVES.isSelected())
				&& (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("2");
		} else if ((CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("3");
		} else if ((CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("4");
		} else if ((CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("5");
		} else if ((CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("6");
		} else if ((CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("7");
		} else if ((!CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (CKSEXVES.isSelected())
				&& (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("8");
		} else if ((!CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("9");
		} else if ((!CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("10");
		} else if ((!CKSEXMAT.isSelected()) && (CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("11");
		} else if ((!CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (CKSEXVES.isSelected())
				&& (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("12");
		} else if ((!CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("13");
		} else if ((!CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("14");
		} else if ((CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("15");
		} else if ((CKSEXMAT.isSelected()) && (!CKSEXALM.isSelected()) && (!CKSEXVES.isSelected())
				&& (!CKSEXNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SEX("16");
		} else
			cDISPONIBILIDADE.setCOD_HOR_SEX("16");

	}

	public void horarioColetaSabado(cDisponibilidade cDISPONIBILIDADE) {
		if ((CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (CKSABVES.isSelected()) && (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("1");

		} else if ((CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (CKSABVES.isSelected())
				&& (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("2");
		} else if ((CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("3");
		} else if ((CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("4");
		} else if ((CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("5");
		} else if ((CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("6");
		} else if ((CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("7");
		} else if ((!CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (CKSABVES.isSelected())
				&& (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("8");
		} else if ((!CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("9");
		} else if ((!CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("10");
		} else if ((!CKSABMAT.isSelected()) && (CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("11");
		} else if ((!CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (CKSABVES.isSelected())
				&& (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("12");
		} else if ((!CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("13");
		} else if ((!CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("14");
		} else if ((CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("15");
		} else if ((CKSABMAT.isSelected()) && (!CKSABALM.isSelected()) && (!CKSABVES.isSelected())
				&& (!CKSABNOT.isSelected())) {
			cDISPONIBILIDADE.setCOD_HOR_SAB("16");
		} else
			cDISPONIBILIDADE.setCOD_HOR_SAB("16");

	}

	public void DisponibilidadeColetaMatutino() {
		if (CKSEGMAT.isSelected()) {
			SEGMI.setText("08:00");
			SEGMF.setText("12:00");
		}

		if (CKTERMAT.isSelected()) {
			TERMI.setText("08:00");
			TERMF.setText("12:00");
		}
		if (CKQUAMAT.isSelected()) {
			QUAMI.setText("08:00");
			QUAMF.setText("12:00");
		}
		if (CKQUIMAT.isSelected()) {
			QUIMI.setText("08:00");
			QUIMF.setText("12:00");
		}
		if (CKSEXMAT.isSelected()) {
			SEXMI.setText("08:00");
			SEXMF.setText("12:00");
		}
		if (CKSABMAT.isSelected()) {
			SABMI.setText("08:00");
			SABMF.setText("12:00");
		}
	}

	public void DisponibilidadeColetaMatutinoNON() {
		if (!CKSEGMAT.isSelected()) {
			SEGMI.setText("");
			SEGMF.setText("");
		}

		if (!CKTERMAT.isSelected()) {
			TERMI.setText("");
			TERMF.setText("");
		}
		if (!CKQUAMAT.isSelected()) {
			QUAMI.setText("");
			QUAMF.setText("");
		}
		if (!CKQUIMAT.isSelected()) {
			QUIMI.setText("");
			QUIMF.setText("");
		}
		if (!CKSEXMAT.isSelected()) {
			SEXMI.setText("");
			SEXMF.setText("");
		}
		if (!CKSABMAT.isSelected()) {
			SABMI.setText("");
			SABMF.setText("");
		}
	}

	public void DisponibilidadeColetaVespertino() {
		if (CKSEGVES.isSelected()) {
			SEGVI.setText("13:30");
			SEGVF.setText("18:30");
		}

		if (CKTERVES.isSelected()) {
			TERVI.setText("13:30");
			TERVF.setText("18:30");
		}
		if (CKQUAVES.isSelected()) {
			QUAVI.setText("13:30");
			QUAVF.setText("18:30");
		}
		if (CKQUIVES.isSelected()) {
			QUIVI.setText("13:30");
			QUIVF.setText("18:30");
		}
		if (CKSEXVES.isSelected()) {
			SEXVI.setText("13:30");
			SEXVF.setText("18:30");
		}
		if (CKSABVES.isSelected()) {
			SABVI.setText("13:30");
			SABVF.setText("18:30");
		}
	}

	public void DisponibilidadeColetaVespertinoNON() {
		if (!CKSEGVES.isSelected()) {
			SEGVI.setText("");
			SEGVF.setText("");
		}

		if (!CKTERVES.isSelected()) {
			TERVI.setText("");
			TERVF.setText("");
		}
		if (!CKQUAVES.isSelected()) {
			QUAVI.setText("");
			QUAVF.setText("");
		}
		if (!CKQUIVES.isSelected()) {
			QUIVI.setText("");
			QUIVF.setText("");
		}
		if (!CKSEXVES.isSelected()) {
			SEXVI.setText("");
			SEXVF.setText("");
		}
		if (!CKSABVES.isSelected()) {
			SABVI.setText("");
			SABVF.setText("");
		}
	}

	public void DisponibilidadeColetaALMOCO() {
		if (CKSEGALM.isSelected()) {
			SEGAI.setText("12:00");
			SEGAF.setText("13:30");
		}

		if (CKTERALM.isSelected()) {
			TERAI.setText("12:00");
			TERAF.setText("13:30");
		}
		if (CKQUAALM.isSelected()) {
			QUAAI.setText("12:00");
			QUAAF.setText("13:30");
		}
		if (CKQUIALM.isSelected()) {
			QUIAI.setText("12:00");
			QUIAF.setText("13:30");
		}
		if (CKSEXALM.isSelected()) {
			SEXAI.setText("12:00");
			SEXAF.setText("13:30");
		}
		if (CKSABALM.isSelected()) {
			SABAI.setText("12:00");
			SABAF.setText("13:30");
		}
	}

	public void DisponibilidadeColetaALMOCONON() {
		if (!CKSEGALM.isSelected()) {
			SEGAI.setText("");
			SEGAF.setText("");
		}

		if (!CKTERALM.isSelected()) {
			TERAI.setText("");
			TERAF.setText("");
		}
		if (!CKQUAALM.isSelected()) {
			QUAAI.setText("");
			QUAAF.setText("");
		}
		if (!CKQUIALM.isSelected()) {
			QUIAI.setText("");
			QUIAF.setText("");
		}
		if (!CKSEXALM.isSelected()) {
			SEXAI.setText("");
			SEXAF.setText("");
		}
		if (!CKSABALM.isSelected()) {
			SABAI.setText("");
			SABAF.setText("");
		}
	}

	public void DisponibilidadeColetaNOTURNO() {
		if (CKSEGNOT.isSelected()) {
			SEGNI.setText("18:30");
			SEGNF.setText("22:00");
		}

		if (CKTERNOT.isSelected()) {
			TERNI.setText("18:30");
			TERNF.setText("22:00");
		}
		if (CKQUANOT.isSelected()) {
			QUANI.setText("18:30");
			QUANF.setText("22:00");
		}
		if (CKQUINOT.isSelected()) {
			QUINI.setText("18:30");
			QUINF.setText("22:00");
		}
		if (CKSEXNOT.isSelected()) {
			SEXNI.setText("18:30");
			SEXNF.setText("22:00");
		}
		if (CKSABNOT.isSelected()) {
			SABNI.setText("18:30");
			SABNF.setText("22:00");
		}
	}

	public void DisponibilidadeColetaNOTURNONON() {
		if (!CKSEGNOT.isSelected()) {
			SEGNI.setText("");
			SEGNF.setText("");
		}

		if (!CKTERNOT.isSelected()) {
			TERNI.setText("");
			TERNF.setText("");
		}
		if (!CKQUANOT.isSelected()) {
			QUANI.setText("");
			QUANF.setText("");
		}
		if (!CKQUINOT.isSelected()) {
			QUINI.setText("");
			QUINF.setText("");
		}
		if (!CKSEXNOT.isSelected()) {
			SEXNI.setText("");
			SEXNF.setText("");
		}
		if (!CKSABNOT.isSelected()) {
			SABNI.setText("");
			SABNF.setText("");
		}
	}
	// SETAR TEXTO TXT POR CHECKBOX -
	// -------------------------------------------------FIM
	// SETAR TEXTO TXT POR CHECKBOX -
	// -----------------------------------------------------------FIM

	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// HABILITAR E DESABILITAR CHECKBOX------------------- COMEÇO
	// HABILITAR E DESABILITAR CHECKBOX--------------------------------- COMEÇO
	public void DiasDAsemana(cDisponibilidade cDISPONIBILIDADE) {
		if (chckSeg.isSelected()) {
			CKSEGALM.setEnabled(true);

			CKSEGMAT.setEnabled(true);
			CKSEGNOT.setEnabled(true);
			CKSEGVES.setEnabled(true);

		}
		if (chckTer.isSelected()) {
			CKTERALM.setEnabled(true);

			CKTERMAT.setEnabled(true);
			CKTERNOT.setEnabled(true);
			CKTERVES.setEnabled(true);
		}
		if (chckQua.isSelected()) {
			CKQUAALM.setEnabled(true);
			CKQUAVES.setEnabled(true);
			CKQUAMAT.setEnabled(true);
			CKQUANOT.setEnabled(true);

		}
		if (chckQui.isSelected()) {
			CKQUIALM.setEnabled(true);
			CKQUIVES.setEnabled(true);
			CKQUIMAT.setEnabled(true);
			CKQUINOT.setEnabled(true);

		}
		if (chckSex.isSelected()) {
			CKSEXALM.setEnabled(true);
			CKSEXVES.setEnabled(true);
			CKSEXMAT.setEnabled(true);
			CKSEXNOT.setEnabled(true);

		}
		if (chckSab.isSelected()) {
			CKSABALM.setEnabled(true);
			CKSABVES.setEnabled(true);
			CKSABMAT.setEnabled(true);
			CKSABNOT.setEnabled(true);

		}

	}

	public void segungachck() {
		if (!chckSeg.isSelected()) {
			CKSEGALM.setEnabled(false);

			CKSEGMAT.setEnabled(false);
			CKSEGNOT.setEnabled(false);
			CKSEGVES.setEnabled(false);
			CKSEGALM.setSelected(false);
			CKSEGVES.setSelected(false);
			CKSEGMAT.setSelected(false);
			CKSEGNOT.setSelected(false);

			SEGNI.setText("");
			SEGNF.setText("");
			SEGAI.setText("");
			SEGAF.setText("");
			SEGVI.setText("");
			SEGVF.setText("");
			SEGMI.setText("");
			SEGMF.setText("");

		}
	}

	public void tercachck() {
		if (!chckTer.isSelected()) {
			CKTERALM.setEnabled(false);

			CKTERMAT.setEnabled(false);
			CKTERNOT.setEnabled(false);
			CKTERVES.setEnabled(false);
			CKTERALM.setSelected(false);
			CKTERVES.setSelected(false);
			CKTERMAT.setSelected(false);
			CKTERNOT.setSelected(false);

			TERNI.setText("");
			TERNF.setText("");
			TERAI.setText("");
			TERAF.setText("");
			TERVI.setText("");
			TERVF.setText("");
			TERMI.setText("");
			TERMF.setText("");
		}
	}

	public void quartachck() {
		if (!chckQua.isSelected()) {
			CKQUAALM.setEnabled(false);
			CKQUAVES.setEnabled(false);
			CKQUAMAT.setEnabled(false);
			CKQUANOT.setEnabled(false);

			CKQUAALM.setSelected(false);
			CKQUAVES.setSelected(false);
			CKQUAMAT.setSelected(false);
			CKQUANOT.setSelected(false);

			QUANI.setText("");
			QUANF.setText("");
			QUAAI.setText("");
			QUAAF.setText("");
			QUAVI.setText("");
			QUAVF.setText("");
			QUAMI.setText("");
			QUAMF.setText("");
		}
	}

	public void quintachck() {
		if (!chckQui.isSelected()) {
			CKQUIALM.setEnabled(false);
			CKQUIVES.setEnabled(false);
			CKQUIMAT.setEnabled(false);
			CKQUINOT.setEnabled(false);

			CKQUIALM.setSelected(false);
			CKQUIVES.setSelected(false);
			CKQUIMAT.setSelected(false);
			CKQUINOT.setSelected(false);

			QUINI.setText("");
			QUINF.setText("");
			QUIAI.setText("");
			QUIAF.setText("");
			QUIVI.setText("");
			QUIVF.setText("");
			QUIMI.setText("");
			QUIMF.setText("");
		}
	}

	public void sextachck() {
		if (!chckSex.isSelected()) {
			CKSEXALM.setEnabled(false);
			CKSEXVES.setEnabled(false);
			CKSEXMAT.setEnabled(false);
			CKSEXNOT.setEnabled(false);

			CKSABALM.setSelected(false);
			CKSEXVES.setSelected(false);
			CKSEXMAT.setSelected(false);
			CKSEXNOT.setSelected(false);

			SEXNI.setText("");
			SEXNF.setText("");
			SEXAI.setText("");
			SEXAF.setText("");
			SEXVI.setText("");
			SEXVF.setText("");
			SEXMI.setText("");
			SEXMF.setText("");

		}
	}

	public void sabadochck() {
		if (!chckSab.isSelected()) {
			CKSABALM.setEnabled(false);
			CKSABVES.setEnabled(false);
			CKSABMAT.setEnabled(false);
			CKSABNOT.setEnabled(false);

			CKSABALM.setSelected(false);
			CKSABVES.setSelected(false);
			CKSABMAT.setSelected(false);
			CKSABNOT.setSelected(false);

			SABNI.setText("");
			SABNF.setText("");
			SABAI.setText("");
			SABAF.setText("");
			SABVI.setText("");
			SABVF.setText("");
			SABMI.setText("");
			SABMF.setText("");
		}

	}
public void InsertHorarioColetaSegunda(cDisponibilidade cDISPONIBILIDADE) {
		
		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			if (chckSeg.isSelected()){
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+", "+cDISPONIBILIDADE.getCOD_HOR_SEG()+", 1)";
			}else {
				q+="INSERT INTO solicitarcoleta";
				q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
				q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+",16 , 1)";}
			
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  INSERT INTO solicitacaocoletameta segunda ");
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
	public void InsertHorarioColetaTerca(cDisponibilidade cDISPONIBILIDADE) {
		
		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			if (chckTer.isSelected()){
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+", "+cDISPONIBILIDADE.getCOD_HOR_TER()+", 2)";
			}
			else {
				q+="INSERT INTO solicitarcoleta";
				q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
				q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+",16 , 2)";}
			comando.executeUpdate(q);
		
		
			

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO solicitacaocoletametal terca ");
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
	public void InsertHorarioColetaQuarta(cDisponibilidade cDISPONIBILIDADE) {
		
		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			if (chckQua.isSelected()){
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+", "+cDISPONIBILIDADE.getCOD_HOR_QUA()+", 3)";}
			
			else {
				q+="INSERT INTO solicitarcoleta";
				q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
				q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+",16 , 3)";}
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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
	public void InsertHorarioColetaQuinta(cDisponibilidade cDISPONIBILIDADE) {
		
		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			if (chckQui.isSelected()){
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+", "+cDISPONIBILIDADE.getCOD_HOR_QUI()+", 4)";
			}else {
				q+="INSERT INTO solicitarcoleta";
				q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
				q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+",16 , 4)";}
			
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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
	public void InsertHorarioColetaSexta(cDisponibilidade cDISPONIBILIDADE) {
		
		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			if (chckSex.isSelected()){
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+", "+cDISPONIBILIDADE.getCOD_HOR_SEX()+", 5)";
		}else {
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+",16 , 5)";}

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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
	public void InsertHorarioColetaSabado(cDisponibilidade cDISPONIBILIDADE) {
		
		conexao c = new conexao();// import conexão
		try {
			
			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";
			if (chckSab.isSelected()){	
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+", "+cDISPONIBILIDADE.getCOD_HOR_SAB()+", 6)";
		}else {
			q+="INSERT INTO solicitarcoleta";
			q+=" (COD_mMuLL, COD_COL_DIS_HOR, COL_COL_DIS_DIA)";
			q+=" VALUES ("+cDISPONIBILIDADE.getCOD_MULL()+",16 , 6)";}
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO metal ");
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

	public void teste(){
	cDISPONIBILIDADE.setCOD_HOR_SEX("");
	}
}
