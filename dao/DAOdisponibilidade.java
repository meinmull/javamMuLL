package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JCheckBox;
import Aconexao.conexao;
import beans.Disponibilidade;

public class DAOdisponibilidade {
	public static JCheckBox ckTod = new JCheckBox("TODOS");
	public static JCheckBox ckNot = new JCheckBox("Noturno");
	public static JCheckBox ckAlm = new JCheckBox("Almoco");
	public static JCheckBox ckVes = new JCheckBox("Vespertino");
	public static JCheckBox ckMat = new JCheckBox("Matutino");
	public static JCheckBox ckSab = new JCheckBox("S\u00E1bado");
	public static JCheckBox ckSex = new JCheckBox("Sexta");
	public static JCheckBox ckQui = new JCheckBox("Quinta");
	public static JCheckBox ckQua = new JCheckBox("Quarta");
	public static JCheckBox ckTer = new JCheckBox("Ter\u00E7a");
	public static JCheckBox ckSeg = new JCheckBox("Segunda");
	public static JCheckBox cbx1 = new JCheckBox("");

	static Disponibilidade disponibilidade = new Disponibilidade();

	public void SelecttimeNowString(Disponibilidade disponibilidade) {

		conexao c = new conexao();

		try {

			String q = "select time_format(now(),'%H:%i')";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();
			if (rs.next()) {
				disponibilidade.setPeriodos(rs.getString(1));
				
						  			
			

		} }catch (Exception ex) {
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
	
	public void SelectDateNowString(Disponibilidade disponibilidade) {

		conexao c = new conexao();

		try {

			String q = "SELECT date_format(NOW(),'%d/%m/%Y')";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();
			if (rs.next()) {
				disponibilidade.setDATACOLETA(rs.getString(1));
			
				
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
	
	
	public void SelectTimeNow(Disponibilidade disponibilidade) {

		conexao c = new conexao();

		try {

			String q = "select time_format(now(),'%H.%i')";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();
			if (rs.next()) {
				disponibilidade.setHOR_COLETA(rs.getDouble("time_format(now(),'%H.%i')"));
				 if ((disponibilidade.getHOR_COLETA()>=8)&&(disponibilidade.getHOR_COLETA()<=12)){
					 disponibilidade.setPeriodos(" AND col.PER_COLETA LIKE '%08:00 - 12:00%'"); 
				 }else if((disponibilidade.getHOR_COLETA()>=12)&&(disponibilidade.getHOR_COLETA()<=13.50)){ 
							  disponibilidade.setPeriodos(" AND col.PER_COLETA LIKE '%12:00 - 13:30%'");
				}else if ((disponibilidade.getHOR_COLETA()>=13.5)&&(disponibilidade.getHOR_COLETA()<18.5)){ 
					 disponibilidade.setPeriodos(" AND col.PER_COLETA like '%13:30 - 18:30%'"); 
				}else if((disponibilidade.getHOR_COLETA()>=18.3)&&(disponibilidade.getHOR_COLETA()<=22)){ 
					 disponibilidade.setPeriodos(" AND col.PER_COLETA like '%18:30 - 22:00%'"); }
				else {  disponibilidade.setPeriodos(" AND col.PER_COLETA like '%%'");
						  
						  
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

	public void SelectPeriodomMuLL() {

		if ((ckMat.isSelected() && (ckAlm.isSelected() && (ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" and th.COD_COL_DIS_HOR LIKE '%%'");
		} else if ((ckMat.isSelected() && (ckAlm.isSelected() && (ckVes.isSelected() && (!ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(
					" AND ( th.HOR_MATUTINO = '08:00 - 12:00' or th.HOR_ALMOCO = '12:00 - 13:30' or th.HOR_VESPERTINO = '13:30 - 18:30')");
		} else if ((ckMat.isSelected() && (!ckAlm.isSelected() && (ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(
					" AND ( th.HOR_MATUTINO = '08:00 - 12:00' or  th.HOR_VESPERTINO = '13:30 - 18:30'OR th.HOR_NOTURNO = '18:30 - 22:00' )");
		} else if ((ckMat.isSelected() && (ckAlm.isSelected() && (!ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(
					" AND ( th.HOR_MATUTINO = '08:00 - 12:00' or  th.HOR_ALMOCO = '12:00 - 13:30'OR th.HOR_NOTURNO = '18:30 - 22:00' )");
		} else if ((!ckMat.isSelected() && (ckAlm.isSelected() && (ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(
					" AND (  th.HOR_ALMOCO = '12:00 - 13:30'OR th.HOR_VESPERTINO = '13:30 - 18:30' OR th.HOR_NOTURNO = '18:30 - 22:00' )");
		} else if ((ckMat.isSelected() && (ckAlm.isSelected() && (!ckVes.isSelected() && (!ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" AND ( th.HOR_MATUTINO = '08:00 - 12:00' or th.HOR_ALMOCO = '12:00 - 13:30')");
		} else if ((ckMat.isSelected() && (!ckAlm.isSelected() && (!ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade
					.setPeriodos(" AND (  th.HOR_MATUTINO = '08:00 - 12:00' or th.HOR_NOTURNO = '18:30 - 22:00')");
		} else if ((!ckMat.isSelected() && (ckAlm.isSelected() && (ckVes.isSelected() && (!ckNot.isSelected()))))) {
			disponibilidade
					.setPeriodos(" AND (  th.HOR_ALMOCO = '12:00 - 13:30' or th.HOR_VESPERTINO = '13:30 - 18:30')");
		} else if ((!ckMat.isSelected() && (ckAlm.isSelected() && (!ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" AND (  th.HOR_ALMOCO = '12:00 - 13:30' or th.HOR_NOTURNO = '18:30 - 22:00')");
		} else if ((!ckMat.isSelected() && (!ckAlm.isSelected() && (ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade
					.setPeriodos(" AND (  th.HOR_VESPERTINO = '13:30 - 18:30' or th.HOR_NOTURNO = '18:30 - 22:00')");
		} else if ((ckMat.isSelected() && (!ckAlm.isSelected() && (!ckVes.isSelected() && (!ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" AND th.HOR_MATUTINO = '08:00 - 12:00'");
		} else if ((!ckMat.isSelected() && (ckAlm.isSelected() && (!ckVes.isSelected() && (!ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" AND th.HOR_ALMOCO = '12:00 - 13:30'");
		} else if ((!ckMat.isSelected() && (!ckAlm.isSelected() && (ckVes.isSelected() && (!ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" AND th.HOR_VESPERTINO = '13:30 - 18:30'");
		} else if ((!ckMat.isSelected() && (!ckAlm.isSelected() && (!ckVes.isSelected() && (ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" AND th.HOR_NOTURNO = '18:30 - 22:00'");
		} else if ((!ckMat.isSelected() && (!ckAlm.isSelected() && (!ckVes.isSelected() && (!ckNot.isSelected()))))) {
			disponibilidade.setPeriodos(" and th.COD_COL_DIS_HOR LIKE '%%'");
		}
	}

	public void PERIODO_MV() {
		disponibilidade
				.setPeriodos(" AND (  th.HOR_MATUTINO = '08:00 - 12:00' or th.HOR_VESPERTINO = '13:30 - 18:30')");
	}

	public void SelectDiasmMuLL() {
		if (ckSeg.isSelected()) {
			disponibilidade.setDias(" AND td.DIA_COL = 'Segunda-feira'");
		} else if (ckTer.isSelected()) {
			disponibilidade.setDias(" AND td.DIA_COL = 'Terça-feira'");
		} else if (ckQua.isSelected()) {
			disponibilidade.setDias(" AND td.DIA_COL = 'Quarta-feira'");
		} else if (ckQui.isSelected()) {
			disponibilidade.setDias(" AND td.DIA_COL = 'Quinta-Feira'");
		} else if (ckSex.isSelected()) {
			disponibilidade.setDias(" AND td.DIA_COL = 'Sexta-feira'");
		} else if (ckSab.isSelected()) {
			disponibilidade.setDias(" AND td.DIA_COL = 'Sabado'");
		} else if (ckTod.isSelected()) {
			disponibilidade.setDias("AND td.DIA_COL like '%%'");
		} else if (!ckTod.isSelected() && (!ckSeg.isSelected()) && (!ckTer.isSelected()) && (!ckQua.isSelected())
				&& (!ckQui.isSelected()) && (!ckSex.isSelected()) && (!ckSab.isSelected())) {
			disponibilidade.setDias("AND td.DIA_COL like '%%'");
		}
	}

	public void METODOCODDIA(Disponibilidade disponibilidade) {
		if (disponibilidade.getStringDia().equalsIgnoreCase("Segunda-feira")) {
			disponibilidade.setDIADASEMANA(2);
			disponibilidade.setCOD_DIA(1);
		} else if (disponibilidade.getStringDia().equalsIgnoreCase("Terça-feira")) {
			disponibilidade.setDIADASEMANA(3);
			disponibilidade.setCOD_DIA(2);
		} else if (disponibilidade.getStringDia().equalsIgnoreCase("Quarta-feira")) {
			disponibilidade.setDIADASEMANA(4);
			disponibilidade.setCOD_DIA(3);
		} else if (disponibilidade.getStringDia().equalsIgnoreCase("Quinta-feira")) {
			disponibilidade.setDIADASEMANA(5);
			disponibilidade.setCOD_DIA(4);
		} else if (disponibilidade.getStringDia().equalsIgnoreCase("Sexta-Feira")) {
			disponibilidade.setDIADASEMANA(6);
			disponibilidade.setCOD_DIA(5);
		} else if (disponibilidade.getStringDia().equalsIgnoreCase("Sabado")) {
			disponibilidade.setDIADASEMANA(7);
			disponibilidade.setCOD_DIA(6);
		}

	}

	public void SELECTPROXIMADATADISPONIVEL(Disponibilidade disponibilidade) {
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += "SELECT DAYOFWEEK(NOW())";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				disponibilidade.setDIADEHOJE(rs.getInt(1));
				disponibilidade.setRESULTADODIACOLETA(disponibilidade.getDIADEHOJE() - disponibilidade.getDIADASEMANA()
						- disponibilidade.getTOTALSEMANA());

				if (disponibilidade.getRESULTADODIACOLETA() < 0) {
					disponibilidade.setRESULTADODIACOLETA(disponibilidade.getRESULTADODIACOLETA() * (-1));
				}

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

	public void SELECTPROXIMADATADISPONIVELFINAL(Disponibilidade disponibilidade) {
		conexao c = new conexao();
		try {

			String q = "";
			q += "SELECT DATE_ADD(DATE(NOW()), INTERVAL " + disponibilidade.getRESULTADODIACOLETA() + " DAY);";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				disponibilidade.setDATACOLETA(rs.getString(1));

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

}
