package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;

import Aconexao.conexao;
import beans.Endereco;

public class DAOendereco {
	public static JComboBox<String> cbxBairro = new JComboBox<String>();
	public static JComboBox<String> cbxCidade = new JComboBox<String>();
	public static JComboBox<String> cbxEstado = new JComboBox<String>();
	static Endereco endereco =  new Endereco();
	//INSERTINCIO-----------------------------------------------------------------
	public void cadastrarendereco( ) {

		conexao c = new conexao();

		try {

			String q = "";
			q += " INSERT INTO endereco";
			q += " (COD_ENDERECO, END_ENDERECO, CEP_ENDERECO, COM_ENDERECO, COD_BAIRRO)";
			q += " VALUES (NULL, ?, ?, ?, ?)";
			PreparedStatement pstmt = c.conn.prepareStatement(q);
			pstmt.setString(1, endereco.getEND_ENDERECO());
			pstmt.setString(2, endereco.getCEP_ENDERECO());
			pstmt.setString(3, endereco.getCOM_ENDERECO());
			pstmt.setString(4, endereco.getCOD_BAIRRO());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("FALHA cadastrarendereco(endereco end)");
		}

	}

//INSERTFINAL---------------------------------------------------------------------
	
	
	//QUERYINICIO-----------------------------------------------------------------
		public void SelectCOD_ENDERECO( ) {

		

			
			conexao c = new conexao();// import conexão
			try {

				String q = "";

				q += " SELECT COD_ENDERECO";
				q += " FROM endereco where END_ENDERECO = ? and CEP_ENDERECO = ? and COM_ENDERECO = ?  and COD_BAIRRO = ?";

				PreparedStatement comando = c.conn.prepareStatement(q);
				comando.setString(1, ""+endereco.getEND_ENDERECO()+"" );
				comando.setString(2, ""+endereco.getCEP_ENDERECO()+"" );
				comando.setString(3, ""+endereco.getCOM_ENDERECO()+"" );
				comando.setString(4, endereco.getCOD_BAIRRO() );
				ResultSet rs = comando.executeQuery();
				if (rs.next()) {
					endereco.setCOD_ENDERECO(rs.getString("COD_ENDERECO"));
				}
			} catch (Exception ex) {
				System.err.println("QueryCOD_BAIRRO()");
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
		
		public void QueryCOD_BAIRRO( ) {

			conexao c = new conexao();// import conexão
			try {

				String q = "";

				q += "SELECT COD_BAIRRO FROM bairro WHERE DES_BAIRRO = ?";

				PreparedStatement comando = c.conn.prepareStatement(q);
				comando.setString(1, "" + cbxBairro.getSelectedItem());

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {
					endereco.setCOD_BAIRRO(rs.getString("COD_BAIRRO"));

				}
			} catch (Exception ex) {
				System.err.println("QueryCOD_BAIRRO()");
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


	
	
	
	//--------------------------------------------------------------------QUERYFINAL
	
	//COMBOXIMPORTSINICIO----------------------------------------------------------- 
	public static void carregarBairro() {

		conexao c = new conexao();

		try {
			cbxBairro.removeAllItems();
			String q = "";
			q += "SELECT b.DES_BAIRRO, b.COD_CIDADE FROM bairro b";
			q += " INNER JOIN cidade c ON c.COD_CIDADE= b.COD_CIDADE";
			q += " WHERE c.DES_CIDADE = '" + cbxCidade.getSelectedItem() + "'";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				cbxBairro.addItem(rs.getString("DES_BAIRRO"));
				//

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

	@SuppressWarnings({})
	public static void carregarCIDADE() {

		conexao c = new conexao();

		try {

			String q = "";
			q += "SELECT c.DES_CIDADE FROM cidade c";
			q += " INNER JOIN estado e ON e.COD_ESTADO=c.COD_ESTADO";
			q += " WHERE e.DES_ESTADO = " + "'" + cbxEstado.getSelectedItem() + "'";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				cbxCidade.addItem(rs.getString("DES_CIDADE"));
				//

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

	public static void carregarESTADO() {

		conexao c = new conexao();

		try {

			String q = "SELECT DES_ESTADO FROM estado ORDER BY COD_ESTADO ";

			PreparedStatement comando = c.conn.prepareStatement(q);

			ResultSet rs = comando.executeQuery();
			while (rs.next()) {
				cbxEstado.addItem(rs.getString("DES_ESTADO"));
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
	public void SelectCidadeEBairro( ) {
		if ((!cbxCidade.getSelectedItem().equals("SELECIONE")) && (cbxBairro.getSelectedItem().equals("SELECIONE"))) {
			endereco.setLOCAL(" AND c.DES_CIDADE LIKE '%" + cbxCidade.getSelectedItem() + "%'");

		} else if ((!cbxCidade.getSelectedItem().equals("SELECIONE"))
				&& (!cbxBairro.getSelectedItem().equals("SELECIONE"))) {
			endereco.setLOCAL(" AND b.DES_BAIRRO LIKE '%" + cbxBairro.getSelectedItem() + "%'");

		} else if ((cbxCidade.getSelectedItem().equals("SELECIONE"))
				&& (cbxBairro.getSelectedItem().equals("SELECIONE"))) {
			endereco.setLOCAL( " AND b.DES_BAIRRO LIKE '%%'");

		}
	}
	
	public static JComboBox<String> getCbxBairro() {
		return cbxBairro;
	}

	public static JComboBox<String> getCbxCidade() {
		return cbxCidade;
	}

	public static JComboBox<String> getCbxEstado() {
		return cbxEstado;
	}

	//------------------------------------------------------------COMBOBOXIMPORFINAL
	
}
