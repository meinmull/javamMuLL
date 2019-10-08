package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Aconexao.conexao;
import abstractTableModel.ModeloTabela;
import beansCliente.cMull;
import beansCliente.cUsuario;

public class cDAOmull {

	cMull Cmull = new cMull();
	public JTable tablemMuLL = new JTable();

	public JTextField txtCodMull;
	public JTextField txtDescricao;
	public JTextField txtSIT_Mull;
	public JTextField txtPeso;
	public JTextField txtDescricaom;
	public JTextField txtPecas;
	public JTextField txtSolicitacao;
	public JTextField txtCOD_MULL;
	public JTextArea txtObs = new JTextArea();
	@SuppressWarnings("rawtypes")
	public JComboBox cbxDescricao = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox cbxPeso = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox cbxGenero = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox cbxFaixaEtaria = new JComboBox();

	// roupas e calcados
	public void InsertNEWVIDRO(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " INSERT INTO vidro";
			q += "(COD_Vidro, COD_VERIFICADOR_VIDRO, COD_Usuario, PES_VIDRO, OBS_VIDRO)";
			q += " VALUES (NULL, '" + Cmull.getCOD_VERIFICADOR() + "', " + cUsuario.getCOD_Usuario() + ", '"
					+ cbxPeso.getSelectedItem() + "', '" + txtObs.getText() + "')";

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO VIDRO ");
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

	public void InsertVidro_TO_mMuLLVIDRO(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO mmull";
			q += "(COD_mMuLL, COD_VIDRO, COD_USUARIO, DES_TAB, SOL_USUARIO)";
			q += " VALUES (NULL, " + Cmull.getCOD_VIDRO() + ", " + cUsuario.getCOD_Usuario() + ", 'VIDRO', NOW())";

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

	public void CODVERIFICADORPARAINSERTVIDRO(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT SUM(COD_Vidro) FROM vidro WHERE COD_Usuario = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_VERIFICADOR(rs.getInt("SUM(COD_Vidro)")+1);

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERY_COD_mMuLLVidro(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT COD_mMuLL FROM mmull mm";
			q += " INNER JOIN vidro v ON v.COD_Vidro = mm.COD_VIDRO";
			q += " WHERE v.COD_Vidro = ?  AND v.COD_VERIFICADOR_VIDRO =  ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_VIDRO());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_MULL(rs.getString("COD_mMuLL"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERYNEWVIDRO(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";

			q += "SELECT COD_Vidro FROM vidro WHERE COD_Usuario = ? AND COD_VERIFICADOR_VIDRO = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);

			comando.setString(1, cUsuario.getCOD_Usuario());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_VIDRO(rs.getString("COD_Vidro"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void InsertNEWSeletiva(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO seletiva";
			q += " (COD_SELETIVA, COD_VERIFICADOR_SELETIVA, COD_Usuario, PES_SELETIVA, OBS_SELETIVA, TIP_SELETIVA)";
			q += " VALUES (NULL, '" + Cmull.getCOD_VERIFICADOR() + "', " + cUsuario.getCOD_Usuario() + ", '"
					+ cbxPeso.getSelectedItem() + "', '" + txtObs.getText() + "', '" + cbxDescricao.getSelectedItem()
					+ "')";
			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO Seletiva ");
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

	public void InsertSeletiva_TO_mMuLL(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO mmull";
			q += " (COD_mMuLL, COD_SELETIVA, COD_USUARIO, DES_TAB, SOL_USUARIO)";
			q += " VALUES (NULL, " + Cmull.getCOD_SELETIVA() + ", " + cUsuario.getCOD_Usuario()
					+ ", 'SELETIVA', NOW())";
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

	public void CODVERIFICADORPARAINSERTSELETIVA(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT SUM(COD_SELETIVA)";
			q += " FROM seletiva";
			q += " WHERE COD_Usuario = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_VERIFICADOR(rs.getInt("SUM(COD_SELETIVA)")+1);

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERY_COD_mMuLLSeletiva(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT COD_mMuLL FROM mmull mm";
			q += " INNER JOIN seletiva s ON s.COD_SELETIVA = mm.COD_SELETIVA";
			q += " WHERE s.COD_SELETIVA = ?  AND s.COD_VERIFICADOR_SELETIVA =  ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_SELETIVA());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_MULL(rs.getString("COD_mMuLL"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERYNEWSELETIVA(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";

			q += "SELECT COD_SELETIVA FROM seletiva WHERE COD_Usuario = ? AND COD_VERIFICADOR_SELETIVA = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);

			comando.setString(1, cUsuario.getCOD_Usuario());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_SELETIVA(rs.getString("COD_SELETIVA"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void InsertNEWMetal(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO metal";
			q += "(COD_Metal, COD_Usuario, COD_VERIFICADOR_METAL, PES_METAL, OBS_METAL)";
			q += " VALUES (NULL, " + cUsuario.getCOD_Usuario() + ", '" + Cmull.getCOD_VERIFICADOR() + "', '"
					+ cbxPeso.getSelectedItem() + "', '" + txtObs.getText() + "')";
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

	public void InsertMetal_TO_mMuLL(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO mmull";
			q += " (COD_mMuLL, COD_METAL, COD_USUARIO , DES_TAB, SOL_USUARIO)";
			q += " VALUES (NULL, " + Cmull.getCOD_METAL() + ", " + cUsuario.getCOD_Usuario() + ",'Metal', NOW())";
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

	public void CODVERIFICADORPARAINSERTMETAL(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT SUM(COD_Metal)";
			q += " FROM metal";
			q += " WHERE COD_Usuario = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_VERIFICADOR(rs.getInt("SUM(COD_Metal)")+1);

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERY_COD_mMuLLMETAL(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT COD_mMuLL FROM mmull mm";
			q += " INNER JOIN metal m ON m.COD_Metal = mm.COD_METAL";
			q += " WHERE m.COD_Metal = ?  AND m.COD_VERIFICADOR_METAL=  ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_METAL());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_MULL(rs.getString("COD_mMuLL"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERYNEWMETAL(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";

			q += "SELECT COD_Metal FROM metal WHERE COD_Usuario = ? AND COD_VERIFICADOR_METAL = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);

			comando.setString(1, cUsuario.getCOD_Usuario());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_METAL(rs.getString("COD_Metal"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERYNEWROUPASCALCADOS(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";

			q += "SELECT COD_ROUPASCALCADOS FROM roupascalcados WHERE COD_Usuario = ? AND COD_VERIFICADOR_ROUPASCALCADOS = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);

			comando.setString(1, cUsuario.getCOD_Usuario());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_ROUPASCALCADOS(rs.getString("COD_ROUPASCALCADOS"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERY_COD_mMuLLRC(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT COD_mMuLL FROM mmull mm";
			q += " INNER JOIN roupascalcados rc ON rc.COD_ROUPASCALCADOS = mm.COD_ROUPASCALCADOS";
			q += " WHERE rc.COD_ROUPASCALCADOS = ?  AND rc.COD_VERIFICADOR_ROUPASCALCADOS =  ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_ROUPASCALCADOS());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_MULL(rs.getString("COD_mMuLL"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void CODVERIFICADORPARAINSERTRPC(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT SUM(COD_ROUPASCALCADOS) FROM roupascalcados WHERE COD_Usuario = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_VERIFICADOR(rs.getInt("SUM(COD_ROUPASCALCADOS)")+1);

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void InsertNEWROUPASCALCADOS(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO roupascalcados";
			q += " (COD_ROUPASCALCADOS, COD_Usuario, COD_VERIFICADOR_ROUPASCALCADOS, TIP_ROUPASCALCADOS, GEN_ROUPASCALCADOS, FAI_ROUPASCALCADOS, OBS_ROUPASCALCADOS, PCS_ROUPASCALCADOS)";
			q += " VALUES (NULL, " + cUsuario.getCOD_Usuario() + ", '" + Cmull.getCOD_VERIFICADOR() + "', '"
					+ cbxDescricao.getSelectedItem() + "', '" + cbxGenero.getSelectedItem() + "', '"
					+ cbxFaixaEtaria.getSelectedItem() + "', '" + txtObs.getText() + "', '" + txtPecas.getText() + "')";

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO ROUPAS CALCADOS ");
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

	public void InsertROUPASCALCADOS_TO_mMuLL(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO mmull (COD_mMuLL, COD_ROUPASCALCADOS, COD_USUARIO, DES_TAB , SOL_USUARIO)";
			q += " VALUES (NULL, " + Cmull.getCOD_ROUPASCALCADOS() + ", " + cUsuario.getCOD_Usuario()
					+ " , 'ROUPAS E CALCADOS', NOW())";

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO mMuLL ");
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

	public void CODVERIFICADORPARAINSERTRC(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT SUM(COD_ROUPASCALCADOS) FROM roupascalcados WHERE COD_Usuario = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_VERIFICADOR(rs.getInt("SUM(COD_ROUPASCALCADOS)")+1);

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERY_COD_mMuLLEL(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT COD_mMuLL FROM mmull mm";
			q += " INNER JOIN `eletrônico` e ON e.COD_ELETRONICO = mm.COD_ELETRONICO";
			q += " WHERE e.COD_ELETRONICO = ?  AND e.COD_VERIFICADOR_ELETRONICO =  ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_ELETRONICO());
			comando.setInt(2, Cmull.getCOD_VERIFICADOR());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_MULL(rs.getString("COD_mMuLL"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void QUERYNEWELETRONICO(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";

			q += "SELECT COD_ELETRONICO FROM `eletrônico` WHERE COD_Usuario = ? AND COD_VERIFICADOR_ELETRONICO = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);

			comando.setString(1, cUsuario.getCOD_Usuario());
			comando.setString(2, "" + Cmull.getCOD_VERIFICADOR() + "");
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_ELETRONICO(rs.getString("COD_ELETRONICO"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void InsertNEWELETRONICO(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO `eletrônico`";
			q += " (COD_ELETRONICO, COD_Usuario, DES_ELETRONICO, PES_ELETRONICO, COD_VERIFICADOR_ELETRONICO, OBS_ELETRONICO,PCS_ELETRONICO)";
			q += " VALUES (NULL, " + cUsuario.getCOD_Usuario() + ", '" + cbxDescricao.getSelectedItem() + "', '"
					+ cbxPeso.getSelectedItem() + "', '" + Cmull.getCOD_VERIFICADOR() + "', '" + txtObs.getText()
					+ "','" + txtPecas.getText() + "')";

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO ROUPAS CALCADOS ");
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

	public void InsertELETRONICO_INTO_mMuLL(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "INSERT INTO mmull (COD_mMuLL, COD_ELETRONICO, COD_USUARIO , DES_TAB, SOL_USUARIO) VALUES";
			q += "(NULL, " + Cmull.getCOD_ELETRONICO() + ", " + cUsuario.getCOD_Usuario() + ", 'ELETRONICO', NOW())";

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha INSERT INTO mMuLL ");
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

	public void CODVERIFICADORPARAINSERT(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT SUM(COD_ELETRONICO) FROM `eletrônico` WHERE COD_Usuario = ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, cUsuario.getCOD_Usuario());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_VERIFICADOR(rs.getInt("SUM(COD_ELETRONICO)" )+ 1);

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO COD VERIFICADOR");
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

	public void uPDATESELETIVA(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE seletiva";
			q += " SET";
			q += " PES_SELETIVA='" + cbxPeso.getSelectedItem() + "',";
			q += " OBS_SELETIVA='" + txtObs.getText() + "',";
			q += " TIP_SELETIVA='" + cbxDescricao.getSelectedItem() + "'";
			q += " WHERE COD_SELETIVA = " + Cmull.getCOD_SELETIVA();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  NO UPDATE ROUPAS E CALCADOS ");
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

	public void QUERY_mMuLL_SELETIVA(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT s.PES_SELETIVA, s.OBS_SELETIVA, s.TIP_SELETIVA";
			q += " FROM mmull mm";
			q += " INNER JOIN seletiva s on s.COD_SELETIVA = mm.COD_SELETIVA";
			q += " WHERE COD_mMuLL = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				cbxDescricao.setSelectedItem(rs.getString("s.TIP_SELETIVA"));
				cbxPeso.setSelectedItem(rs.getString("PES_SELETIVA"));
				txtObs.setText(rs.getString("s.OBS_SELETIVA"));

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

	public void QUERY_COD_SELETIVA(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT s.COD_SELETIVA";
			q += " FROM mmull mm";
			q += " INNER JOIN seletiva s on s.COD_SELETIVA = mm.COD_SELETIVA";
			q += " WHERE COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				Cmull.setCOD_SELETIVA(rs.getString("s.COD_SELETIVA"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA BUSCA DO CODIGO SELETIVA mMuLL");
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

	public void uPDATEMETAL(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " UPDATE metal SET PES_METAL='" + cbxPeso.getSelectedItem() + "', OBS_METAL='" + txtObs.getText()
					+ "' WHERE COD_Metal = " + Cmull.getCOD_METAL();

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

	public void QUERY_mMuLL_METAL(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT m.COD_METAL, m.PES_METAL , m.OBS_METAL";
			q += " FROM mmull mm";
			q += " INNER JOIN metal m ON m.COD_Metal = mm.COD_METAL";
			q += " WHERE COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				cbxPeso.setSelectedItem(rs.getString("m.PES_METAL"));
				txtObs.setText(rs.getString("m.OBS_METAL"));

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

	public void QUERY_COD_METAL(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT m.COD_METAL";
			q += " FROM mmull mm";
			q += " INNER JOIN metal m  on m.COD_METAL = mm.COD_METAL";
			q += " where mm.COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_METAL(rs.getString("m.COD_METAL"));

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

	public void QUERY_mMuLL_VIDRO(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT v.PES_VIDRO, v.DES_VIDRO, v.OBS_VIDRO";
			q += " FROM mmull mm";
			q += " INNER JOIN vidro v ON v.COD_Vidro = mm.COD_VIDRO";
			q += " WHERE mm.COD_mMuLL = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				cbxPeso.setSelectedItem(rs.getString("v.PES_VIDRO"));
				txtObs.setText(rs.getString("v.OBS_VIDRO"));
				txtCOD_MULL.setText(Cmull.getCOD_MULL());

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

	public void uPDATEVIDRO(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += " UPDATE vidro";
			q += " SET";
			q += " PES_VIDRO='" + cbxPeso.getSelectedItem() + "',";
			q += " OBS_VIDRO='" + txtObs.getText() + "'";
			q += " WHERE COD_Vidro =" + Cmull.getCOD_VIDRO();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  NO UPDATE Vidro ");
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

	public void QUERY_COD_VIDRO(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT v.COD_VIDRO";
			q += " FROM mmull mm";
			q += " INNER JOIN vidro v ON v.COD_Vidro = mm.COD_VIDRO";
			q += " WHERE mm.COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				Cmull.setCOD_VIDRO(rs.getString("v.COD_VIDRO"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA BUSCA DO CODIGO vidro mMuLL");
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

	public void QUERY_mMuLL_ROUPASCALCADOS(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT mm.COD_mMuLL ,rc.TIP_ROUPASCALCADOS, rc.GEN_ROUPASCALCADOS, rc.FAI_ROUPASCALCADOS, rc.OBS_ROUPASCALCADOS, rc.PCS_ROUPASCALCADOS";
			q += " FROM mmull mm";
			q += " INNER JOIN roupascalcados rc ON rc.COD_ROUPASCALCADOS = mm.COD_ROUPASCALCADOS";
			q += " WHERE mm.COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				cbxDescricao.setSelectedItem(rs.getString("rc.TIP_ROUPASCALCADOS"));
				cbxGenero.setSelectedItem(rs.getString("rc.GEN_ROUPASCALCADOS"));
				cbxFaixaEtaria.setSelectedItem(rs.getString("rc.FAI_ROUPASCALCADOS"));
				txtCOD_MULL.setText(rs.getString("mm.COD_mMuLL"));
				txtPecas.setText(rs.getString("rc.PCS_ROUPASCALCADOS"));
				txtObs.setText(rs.getString("rc.OBS_ROUPASCALCADOS"));

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA BUSCA e insercao pelo CODIGO mMuLL");
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

	@SuppressWarnings("unchecked")
	public void QUERYGeneroCOMBOBOX() {
		conexao c = new conexao();// import conexão
		cbxGenero.removeAllItems();
		cbxFaixaEtaria.removeAllItems();
		try {

			String q = "";
			if (cbxDescricao.getSelectedItem().equals("Roupas")) {

				q += "SELECT DES_GENERO FROM genero  ";

			} else if (cbxDescricao.getSelectedItem().equals("Calcados")) {
				q += "SELECT DES_GENERO FROM genero";

			}

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				cbxGenero.addItem(rs.getString("DES_GENERO"));

				if (cbxDescricao.getSelectedItem().equals("Roupas de Cama/Mesa/Banho")) {
					q += "SELECT DES_GENERO FROM genero";

					cbxFaixaEtaria.removeAllItems();
					cbxGenero.removeAllItems();

				}

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO GENERO ");
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

	@SuppressWarnings("unchecked")
	public void QUERYfaixaEtariaCOMBOBOX() {
		conexao c = new conexao();// import conexão

		try {

			String q = "";
			if (cbxDescricao.getSelectedItem().equals("Roupas")) {

				q += "SELECT DES_FaixaEtaria FROM faixaetaria ";
			} else if (cbxDescricao.getSelectedItem().equals("Calcados")) {
				q += "SELECT DES_FaixaEtaria FROM faixaetaria ";

			}

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				cbxFaixaEtaria.addItem(rs.getString("DES_FaixaEtaria"));

				if (cbxDescricao.getSelectedItem().equals("Roupas de Cama/Mesa/Banho")) {
					q += "SELECT DES_FaixaEtaria FROM faixaetaria ";
					cbxFaixaEtaria.removeAllItems();
					cbxGenero.removeAllItems();

				}

			}

		} catch (Exception ex) {
			System.err.println("FALHA NA INSERÇÃO DO FAIXA ETARIA ");
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

	public void uPDATEROUPASCALCADOS(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "UPDATE roupascalcados";
			q += " SET";
			q += " TIP_ROUPASCALCADOS='" + cbxDescricao.getSelectedItem() + "',";
			q += " GEN_ROUPASCALCADOS='" + cbxGenero.getSelectedItem() + "',";
			q += " FAI_ROUPASCALCADOS='" + cbxFaixaEtaria.getSelectedItem() + "',";
			q += " OBS_ROUPASCALCADOS='" + txtObs.getText() + "',";
			q += " PCS_ROUPASCALCADOS='" + txtPecas.getText() + "'";
			q += " WHERE  COD_ROUPASCALCADOS = " + Cmull.getCOD_ROUPASCALCADOS();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  NO UPDATE ROUPAS E CALCADOS ");
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

	public void QUERY_COD_ROUPASCALCADOS(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT  rc.COD_ROUPASCALCADOS";
			q += " FROM mmull mm";
			q += " INNER JOIN roupascalcados rc ON rc.COD_ROUPASCALCADOS = mm.COD_ROUPASCALCADOS";
			q += " WHERE mm.COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				Cmull.setCOD_ROUPASCALCADOS(rs.getString("rc.COD_ROUPASCALCADOS"));

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
	// roupase e calcados

	// eletronico
	public void uPDATEeLETRONICO(cMull Cmull) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement();
			String q = "";

			q += "UPDATE `eletrônico`";
			q += " SET";
			q += " DES_ELETRONICO='" + cbxDescricao.getSelectedItem() + "',";
			q += " PES_ELETRONICO='" + cbxPeso.getSelectedItem() + "',";
			q += " OBS_ELETRONICO='" + txtObs.getText() + "',";
			q += " PCS_ELETRONICO='" + txtPecas.getText() + "'";
			q += " WHERE COD_ELETRONICO=" + Cmull.getCOD_ELETRONICO();

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

	public void DELETELETRONICO_SOLICITACAOCOLETA() {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "DELETE FROM solicitarcoleta WHERE COD_mMuLL = " + Cmull.getCOD_MULL();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  DELETE solicitacaocoletameta segunda ");
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

	public void DELETELETRONICO() {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "DELETE FROM `eletrônico` WHERE COD_ELETRONICO= " + Cmull.getCOD_ELETRONICO();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  DELETE ELETRONICO  ");
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

	public void DELETELETRONICO_DE_MMuLL() {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "DELETE FROM mmull WHERE COD_mMuLL=" + Cmull.getCOD_MULL();

			comando.executeUpdate(q);

			;

		} catch (Exception ex) {
			System.err.println("Falha  DELETE ELETRONICO DE mMuLL ");
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

	public void QUERY_mMuLL_ELETRONICO(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT e.COD_ELETRONICO, e.DES_ELETRONICO, e.PES_ELETRONICO, e.OBS_ELETRONICO, e.PCS_ELETRONICO";
			q += " FROM mmull mm";
			q += " INNER JOIN `eletrônico` e on e.COD_ELETRONICO = mm.COD_ELETRONICO";
			q += " where mm.COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				cbxPeso.setSelectedItem(rs.getString("e.PES_ELETRONICO"));
				cbxDescricao.setSelectedItem(rs.getString("e.DES_ELETRONICO"));
				txtObs.setText(rs.getString("e.OBS_ELETRONICO"));

				txtCOD_MULL.setText("" + Cmull.getCOD_MULL());
				txtPecas.setText(rs.getString("PCS_ELETRONICO"));

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

	public void QUERY_COD_ELETRONICO(cMull Cmull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT e.COD_ELETRONICO";
			q += " FROM mmull mm";
			q += " INNER JOIN `eletrônico` e on e.COD_ELETRONICO = mm.COD_ELETRONICO";
			q += " where mm.COD_mMuLL = ?";
			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Cmull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				Cmull.setCOD_ELETRONICO((rs.getString("e.COD_ELETRONICO")));

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

	// fim eletronico

	public void QuerymMuLL() {
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[] { "ID mMüLL", "Descricão", };

		conexao c = new conexao();
		try {

			String q = "";
			q += " SELECT COD_mMuLL, DES_TAB, COL_AGENDADA";
			q += " FROM mmull where COD_USUARIO = " + cUsuario.getCOD_Usuario();
			q += " order by COD_mMuLL desc";

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			ModeloTabela modelo1 = new ModeloTabela(dados, colunas);

			tablemMuLL.setModel(modelo1);
			tablemMuLL.getColumnModel().getColumn(0).setPreferredWidth(80);
			tablemMuLL.getColumnModel().getColumn(1).setPreferredWidth(170);

			tablemMuLL.setShowGrid(false);
			tablemMuLL.getTableHeader().setReorderingAllowed(false);
			tablemMuLL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			while (rs.next()) {

				dados.add(new Object[] { rs.getString("COD_mMuLL"), rs.getString("DES_TAB") });
				System.out.println(rs.getString("COD_mMuLL"));

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

	public void SetDadosmMuLL(cMull Cmull) {
		if (Cmull.getDES_TAB().equalsIgnoreCase("METAL")) {
			Cmull.setSELECTmull(
					"SELECT mm.COL_AGENDADA, date_format(mm.SOL_USUARIO,'%d/%m/%Y'), m.PES_METAL, m.OBS_METAL FROM metal m  INNER JOIN mmull mm ON mm.COD_METAL = m.COD_Metal  ");

		} else if (Cmull.getDES_TAB().equalsIgnoreCase("ELETRONICO")) {
			Cmull.setSELECTmull(
					"SELECT mm.COL_AGENDADA, date_format(mm.SOL_USUARIO,'%d/%m/%Y') ,e.DES_ELETRONICO, e.PES_ELETRONICO, e.OBS_ELETRONICO, e.PCS_ELETRONICO FROM `eletrônico` e INNER JOIN mmull mm ON mm.COD_ELETRONICO = e.COD_ELETRONICO  ");

		} else if (Cmull.getDES_TAB().equalsIgnoreCase("VIDRO")) {
			Cmull.setSELECTmull(
					"SELECT mm.COL_AGENDADA, date_format(mm.SOL_USUARIO,'%d/%m/%Y'),v.PES_VIDRO, v.DES_VIDRO, v.OBS_VIDRO FROM vidro v INNER JOIN mmull mm ON mm.COD_VIDRO = v.COD_Vidro");
		} else if (Cmull.getDES_TAB().equalsIgnoreCase("SELETIVA")) {
			Cmull.setSELECTmull(
					"SELECT mm.COL_AGENDADA, date_format(mm.SOL_USUARIO,'%d/%m/%Y'),s.PES_SELETIVA, s.OBS_SELETIVA, s.TIP_SELETIVA FROM seletiva s INNER JOIN mmull mm ON mm.COD_SELETIVA = s.COD_SELETIVA");
		} else if (Cmull.getDES_TAB().equalsIgnoreCase("ROUPAS E CALCADOS")) {
			Cmull.setSELECTmull(
					"SELECT mm.COL_AGENDADA, date_format(mm.SOL_USUARIO,'%d/%m/%Y'),rc.TIP_ROUPASCALCADOS, rc.GEN_ROUPASCALCADOS, rc.FAI_ROUPASCALCADOS, rc.OBS_ROUPASCALCADOS, rc.PCS_ROUPASCALCADOS FROM roupascalcados rc INNER JOIN mmull mm ON mm.COD_ROUPASCALCADOS = rc.COD_ROUPASCALCADOS");
		}

		conexao c = new conexao();
		try {
			System.out.println(Cmull.getSELECTmull());
			String q = "";
			q += Cmull.getSELECTmull();
			q += " WHERE mm.COD_mMuLL =" + Cmull.getCOD_MULL();

			PreparedStatement ps = c.conn.prepareStatement(q);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (Cmull.getDES_TAB().equalsIgnoreCase("METAL")) {

					txtPeso.setText(rs.getString("m.PES_METAL"));
					txtDescricaom.setText("");
					txtPecas.setText("");
					txtObs.setText(rs.getString("m.OBS_METAL"));
					txtSolicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
					txtSIT_Mull.setText(rs.getString("mm.COL_AGENDADA"));
					Cmull.setCOL_AGENDADA(rs.getString("mm.COL_AGENDADA"));
				}

				else if (Cmull.getDES_TAB().equalsIgnoreCase("ELETRONICO")) {

					txtPeso.setText(rs.getString("e.PES_ELETRONICO"));
					txtDescricaom.setText(rs.getString("e.DES_ELETRONICO"));
					txtPecas.setText(rs.getString("e.PCS_ELETRONICO"));
					txtObs.setText(rs.getString("e.OBS_ELETRONICO"));
					txtSolicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
					txtSIT_Mull.setText(rs.getString("mm.COL_AGENDADA"));
					Cmull.setCOL_AGENDADA(rs.getString("mm.COL_AGENDADA"));
				}

				else if (Cmull.getDES_TAB().equalsIgnoreCase("SELETIVA")) {

					txtPeso.setText(rs.getString("s.PES_SELETIVA"));
					txtDescricaom.setText(rs.getString("s.TIP_SELETIVA"));
					txtPecas.setText("");
					txtObs.setText(rs.getString("s.OBS_SELETIVA"));
					txtSolicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
					txtSIT_Mull.setText(rs.getString("mm.COL_AGENDADA"));
					Cmull.setCOL_AGENDADA(rs.getString("mm.COL_AGENDADA"));
				}

				else if (Cmull.getDES_TAB().equalsIgnoreCase("VIDRO")) {

					txtPeso.setText(rs.getString("v.PES_VIDRO"));
					txtDescricaom.setText(rs.getString("v.DES_VIDRO"));
					txtPecas.setText("");
					txtObs.setText(rs.getString("v.OBS_VIDRO"));
					txtSolicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
					txtSIT_Mull.setText(rs.getString("mm.COL_AGENDADA"));
					Cmull.setCOL_AGENDADA(rs.getString("mm.COL_AGENDADA"));
				}

				else if (Cmull.getDES_TAB().equalsIgnoreCase("ROUPAS E CALCADOS")) {

					txtPeso.setText("");
					txtDescricaom.setText(rs.getString("rc.TIP_ROUPASCALCADOS"));
					txtPecas.setText(rs.getString("rc.PCS_ROUPASCALCADOS"));
					txtObs.setText("  Gênero :  " + rs.getString("rc.GEN_ROUPASCALCADOS") + "  FAIXA ETÁRIA : "
							+ rs.getString("rc.FAI_ROUPASCALCADOS") + "  " + rs.getString("rc.OBS_ROUPASCALCADOS"));
					txtSolicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
					txtSIT_Mull.setText(rs.getString("mm.COL_AGENDADA"));
					Cmull.setCOL_AGENDADA(rs.getString("mm.COL_AGENDADA"));
				}

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

	public void CancelarmMull(cMull Cmull) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql
															// em
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " 	COL_AGENDADA='CANCELADA'";
			q += " WHERE  COD_mMuLL =" + Cmull.getCOD_MULL();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("CancelarmMull()");
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

	public void FinalizarMull(cMull Cmull) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement();
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " 	COL_AGENDADA='FINALIZADA'";
			q += " WHERE  COD_mMuLL =" + Cmull.getCOD_MULL();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FinalizarMull()");
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

	public void FinalizarMullNAO(cMull cMull) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement();
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " 	COL_AGENDADA='NÃO'";
			q += " WHERE  COD_mMuLL =" + Cmull.getCOD_MULL();

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FinalizarMull()");
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

	public void CancelarColetaUpdatemMull(cMull Cmull) {
		conexao c = new conexao();
		try {

			Statement comando = c.conn.createStatement(); // java.sql
															// em
			String q = "";

			q += " UPDATE mmull";
			q += " SET";
			q += " COL_AGENDADA='NÃO'";
			q += " WHERE COD_mMuLL = " + Cmull.getCOD_MULL();

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

}
