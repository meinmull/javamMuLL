package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import Aconexao.conexao;
import beans.Mull;
import beans.Usuario;

public class DAOmull {
	public static JComboBox<?> cbxmMuLL = new JComboBox<Object>();
	static Mull mull = new Mull();

	public void SelectmMuLL() {
		if (cbxmMuLL.getSelectedItem().equals("ROUPAS")) {
			mull.setmMull(" AND TIP_ROUPASCALCADOS = 'Roupas'");

		} else if (cbxmMuLL.getSelectedItem().equals("CALÇADOS")) {
			mull.setmMull(" AND TIP_ROUPASCALCADOS = 'Calcados'");

		} else if (cbxmMuLL.getSelectedItem().equals("ROUPAS DE BANHO E CAMA")) {
			mull.setmMull(" AND TIP_ROUPASCALCADOS = 'Roupas de Cama/Mesa/Banho'");

		} else if (cbxmMuLL.getSelectedItem().equals("SELECIONE") && (Usuario.getIST_USUARIO().equals("SIM"))) {
			mull.setmMull(" AND TIP_ROUPASCALCADOS LIKE '%%'");

		} else if (cbxmMuLL.getSelectedItem().equals("SELECIONE") && (Usuario.getIST_USUARIO().equals("NÃO"))) {
			mull.setmMull(
					" AND (mm.DES_TAB = 'vidro' OR mm.DES_TAB = 'metal' OR mm.DES_TAB = 'Seletiva' OR mm.DES_TAB = 'ELETRONICO')");

		} else if (cbxmMuLL.getSelectedItem().equals("SELETIVA")) {
			mull.setmMull(" AND mm.DES_TAB = 'Seletiva'");

		} else if (cbxmMuLL.getSelectedItem().equals("METAL")) {
			mull.setmMull(" AND mm.DES_TAB = 'metal'");

		} else if (cbxmMuLL.getSelectedItem().equals("VIDRO")) {
			mull.setmMull(" AND mm.DES_TAB = 'vidro'");

		} else if (cbxmMuLL.getSelectedItem().equals("PLASTICO")) {
			mull.setmMull(" AND mm.DES_TAB LIKE '%%'");

		} else if (cbxmMuLL.getSelectedItem().equals("PAPEL")) {
			mull.setmMull(" AND mm.DES_TAB LIKE '%%'");

		} else if (cbxmMuLL.getSelectedItem().equals("ELETRÔNICO")) {
			mull.setmMull(" AND mm.DES_TAB = 'ELETRONICO'");

		}

	}

	public void BuscaDadosmMuLL(Mull mull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT COD_USUARIO, DES_TAB, SOL_USUARIO";
			q += " FROM mmull WHERE COD_mMuLL = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, mull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				mull.setCOD_USUARIO(rs.getString("COD_USUARIO"));
				mull.setDES_TAB(rs.getString("DES_TAB"));
				mull.setSOL_USUARIO(rs.getString("SOL_USUARIO"));

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

	public void SelectTotalmMullDisponivelparaColeta(Mull mull) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT (COUNT(COD_mMuLL))-(COUNT(COD_ROUPASCALCADOS)),COUNT(COD_VIDRO),COUNT(COD_METAL),COUNT(COD_ELETRONICO),COUNT(COD_SELETIVA)";
			q += "FROM mmull WHERE COL_AGENDADA LIKE '%não%'";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				mull.setTotalmMuLL(rs.getString("(COUNT(COD_mMuLL))-(COUNT(COD_ROUPASCALCADOS))"));
				mull.setTotalVidro(rs.getString("COUNT(COD_VIDRO)"));
				mull.setTotalMetal(rs.getString("COUNT(COD_METAL)"));
				mull.setTotalEletrônico(rs.getString("COUNT(COD_ELETRONICO)"));
				mull.setTotalSeletiva(rs.getString("COUNT(COD_SELETIVA)"));

			}
		} catch (Exception ex) {
			System.err.println("FALHA NA BUSCA SELECT DAYOFWEEK(NOW())");
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

	public void QuerymMuLLViewDetalhesEmpresaMull(Mull mull) {

		if (mull.getDES_TAB().equalsIgnoreCase("METAL")) {
			mull.setQuerySelect(
					"SELECT PES_METAL, OBS_METAL FROM metal m INNER JOIN mmull mm  ON mm.COD_METAL = m.COD_Metal WHERE mmull.COD_mMuLL = ");

		}

		else if (mull.getDES_TAB().equalsIgnoreCase("VIDRO")) {
			mull.setQuerySelect(
					"SELECT PES_VIDRO, DES_VIDRO, OBS_VIDRO FROM vidro v inner join mmull mm on mm.COD_VIDRO = v.COD_Vidro where mm.COD_mMuLL = ");

		}

		else if (mull.getDES_TAB().equalsIgnoreCase("SELETIVA")) {
			mull.setQuerySelect(
					"SELECT PES_SELETIVA, OBS_SELETIVA, TIP_SELETIVA FROM seletiva s INNER JOIN mmull mm on mm.COD_SELETIVA = s.COD_SELETIVA  where mm.COD_mMuLL = ");

		}

		else if (mull.getDES_TAB().equalsIgnoreCase("ELETRONICO")) {
			mull.setQuerySelect(
					"SELECT DES_ELETRONICO, PES_ELETRONICO, OBS_ELETRONICO, PCS_ELETRONICO FROM `eletrônico` e inner join mmull mm on mm.COD_ELETRONICO = e.COD_ELETRONICO where mm.COD_mMuLL = ");

		}

		System.out.println(mull.getQuerySelect());

	}

	public void outro(Mull mull) {
		conexao c = new conexao();
		try {

			String q = "";
			q += mull.getQuerySelect();
			q += " ? ";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, mull.getCOD_MULL());

			ResultSet rs = comando.executeQuery();
			if (mull.getDES_TAB().equalsIgnoreCase("METAL")) {
				if (rs.next()) {
					mull.setTxtDescrição("");
					mull.setTxtobservacao(rs.getString("OBS_METAL"));
					mull.setTxtPeso(rs.getString("PES_METAL"));
					mull.setTxtPeças("");
					System.out.println(mull.getTxtDescrição());
					System.out.println(mull.getTxtobservacao());
					System.out.println(mull.getTxtPeso());
					System.out.println(mull.getTxtPeças());
				}
			}

			else if (mull.getDES_TAB().equalsIgnoreCase("VIDRO")) {
				if (rs.next()) {
					mull.setTxtDescrição(rs.getString("DES_VIDRO"));
					mull.setTxtobservacao(rs.getString("OBS_VIDRO"));
					mull.setTxtPeso(rs.getString("PES_VIDRO"));
					mull.setTxtPeças("");
					System.out.println(mull.getTxtDescrição());
					System.out.println(mull.getTxtobservacao());
					System.out.println(mull.getTxtPeso());
					System.out.println(mull.getTxtPeças());
				}
			}

			else if (mull.getDES_TAB().equalsIgnoreCase("SELETIVA")) {
				if (rs.next()) {
					mull.setTxtDescrição(rs.getString("TIP_SELETIVA"));
					mull.setTxtobservacao(rs.getString("OBS_SELETIVA"));
					mull.setTxtPeso(rs.getString("PES_SELETIVA"));
					mull.setTxtPeças("");
					System.out.println(mull.getTxtDescrição());
					System.out.println(mull.getTxtobservacao());
					System.out.println(mull.getTxtPeso());
					System.out.println("");
				}
			}

			else if (mull.getDES_TAB().equalsIgnoreCase("ELETRONICO")) {
				if (rs.next()) {
					mull.setTxtDescrição(rs.getString("DES_ELETRONICO"));
					mull.setTxtobservacao(rs.getString("OBS_ELETRONICO"));
					mull.setTxtPeso(rs.getString("PES_ELETRONICO"));
					mull.setTxtPeças(rs.getString("PCS_ELETRONICO"));
					System.out.println(mull.getTxtDescrição());
					System.out.println(mull.getTxtobservacao());
					System.out.println(mull.getTxtPeso());
					System.out.println(mull.getTxtPeças());
				}
			}

		} catch (Exception ex) {
			System.err.println("QuerymMuLLViewDetalhesEmpresaMull(Coleta coleta)");
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
