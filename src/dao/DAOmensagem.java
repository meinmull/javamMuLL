package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Aconexao.conexao;
import abstractTableModel.ModeloTabela;
import beans.Mensagem;
import beans.Usuario;


public class DAOmensagem {
	
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
	
	
Mensagem mensagem = new Mensagem();
	

public void UpdateMensagensCXexclusao(Mensagem mensagem){
	
	mensagem.setCX_MENSAGENS(mensagem.getCX_MENSAGENS()-1);
	
	if(mensagem.getCX_MENSAGENS()>0){
	
	conexao c = new conexao();// import conexão
	try {

		Statement comando = c.conn.createStatement(); // java.sql em
		String q = "";
		q += " UPDATE mensagenscaixaei";
		q += " SET";
		q += " NRO_MENSAGENS="+mensagem.getCX_MENSAGENS();
		q += " WHERE COD_EMPRESA = "+Usuario.getCOD_USUARIO();
		

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


public void UpdateMensagensCX(Mensagem mensagem){
	
	



conexao c = new conexao();// import conexão
try {

	Statement comando = c.conn.createStatement(); // java.sql em
	String q = "";
	q += " UPDATE mensagenscaixaei";
	q += " SET";
	q += " NRO_MENSAGENS= "+mensagem.getCX_MENSAGENS();
	q += " WHERE COD_EMPRESA = "+Usuario.getCOD_USUARIO();
	
	

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



public void selectMensagensAntes(Mensagem mensagem){
	
	
			conexao c = new conexao();
	try {

		String q = "";

		q += " SELECT NRO_MENSAGENS";
		q += " FROM mensagenscaixaei";
		q += " WHERE COD_EMPRESA = ? ";

		PreparedStatement comando = c.conn.prepareStatement(q);
		comando.setString(1, Usuario.getCOD_USUARIO());
	
		ResultSet rs = comando.executeQuery();

		if (rs.next()) {
			mensagem.setNRO_MENSAGENS(rs.getInt("NRO_MENSAGENS"));
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

public void SelectNROmensagens(Mensagem mensagem) {

	conexao c = new conexao();
	try {

		String q = "";

		q += " SELECT count(COD_MENSAGEM)";
		q += " FROM mensagemcliente";
		q += " WHERE COD_EMPRESA = ? ";

		PreparedStatement comando = c.conn.prepareStatement(q);
		comando.setString(1, Usuario.getCOD_USUARIO());
	
		ResultSet rs = comando.executeQuery();

		if (rs.next()) {
			mensagem.setCX_MENSAGENS(rs.getInt("count(COD_MENSAGEM)"));
			
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

	public void ExcluirMensagemCaixadeEntradaEmpresaInstituicao(Mensagem mensagem) {

		

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql em
			String q = "";

			q += "DELETE FROM mensagemcliente WHERE COD_MENSAGEM= " + mensagem.getCOD_MENSAGEM();

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

	public void QuerygetTextMensagensEmpresa(Mensagem mensagem) {

		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT TIME(msg.DAT_MENSAGEM), DATE_format(msg.DAT_MENSAGEM,'%d/%m/%Y') , msg.MSG_MENSAGEM,mm.DES_TAB,msg.COD_MMULL, ";
			q += " date_format(mm.SOL_USUARIO,'%d/%m/%Y'),TIME(mm.SOL_USUARIO)";
			q += " from mensagemcliente msg  ";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL = msg.COD_MMULL";
			q += " WHERE msg.COD_MENSAGEM = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, mensagem.getCOD_MENSAGEM());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtHoraMSG.setText(rs.getString("TIME(msg.DAT_MENSAGEM)"));
				txtDAtAMSG.setText(rs.getString("DATE_format(msg.DAT_MENSAGEM,'%d/%m/%Y')"));
				txtRemetente.setText("Usuario  Müll");
				txtMsg.setText(rs.getString("msg.MSG_MENSAGEM"));
				txtID_mMULL.setText(rs.getString("msg.COD_MMULL"));
				txtDATAminhaSOlicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
				txtHoraMinhaSOlicitacao.setText(rs.getString("TIME(mm.SOL_USUARIO)"));
				txtAssunto.setText("COLETA  : " + rs.getString("mm.DES_TAB"));
				txtDESCRICAOmMULL.setText(rs.getString("mm.DES_TAB"));
				mensagem.setDES_TAB(rs.getString("mm.DES_TAB"));
				mensagem.setCOD_mMuLL(rs.getString("msg.COD_MMULL"));
				System.out.println(rs.getString("msg.MSG_MENSAGEM"));
				
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
	
	
	public void QuerygetTextMensagensRoupasEcalcados(Mensagem mensagem) {

		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT TIME(msg.DAT_MENSAGEM), DATE_format(msg.DAT_MENSAGEM,'%d/%m/%Y') , msg.MSG_MENSAGEM,mm.DES_TAB,msg.COD_MMULL, ";
			q += " rpc.TIP_ROUPASCALCADOS, rpc.GEN_ROUPASCALCADOS, rpc.FAI_ROUPASCALCADOS ,";
			q += " rpc.OBS_ROUPASCALCADOS, rpc.PCS_ROUPASCALCADOS,date_format(mm.SOL_USUARIO,'%d/%m/%Y'),TIME(mm.SOL_USUARIO)";
			q += " from mensagemcliente msg  ";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL = msg.COD_MMULL";
			q += " INNER JOIN roupascalcados rpc ON rpc.COD_ROUPASCALCADOS = mm.COD_ROUPASCALCADOS";
			q += " WHERE msg.COD_MENSAGEM = ?";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, mensagem.getCOD_MENSAGEM());

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				txtHoraMSG.setText(rs.getString("TIME(msg.DAT_MENSAGEM)"));
				txtDAtAMSG.setText(rs.getString("DATE_format(msg.DAT_MENSAGEM,'%d/%m/%Y')"));
				txtRemetente.setText("Usuario  Müll");
				txtMsg.setText(rs.getString("msg.MSG_MENSAGEM"));
				txtID_mMULL.setText(rs.getString("msg.COD_MMULL"));
				txtDATAminhaSOlicitacao.setText(rs.getString("date_format(mm.SOL_USUARIO,'%d/%m/%Y')"));
				txtHoraMinhaSOlicitacao.setText(rs.getString("TIME(mm.SOL_USUARIO)"));
				txtAssunto.setText("COLETA  : " + rs.getString("mm.DES_TAB"));
				txtDESCRICAOmMULL.setText(rs.getString("mm.DES_TAB"));
				txtPcs.setText(rs.getString("rpc.PCS_ROUPASCALCADOS"));
				txtFaixaEtaria.setText(rs.getString("rpc.FAI_ROUPASCALCADOS"));
				txtGenero.setText(rs.getString("rpc.GEN_ROUPASCALCADOS"));
				txtDescricao.setText(rs.getString("rpc.TIP_ROUPASCALCADOS"));
				txtObs.setText(rs.getString("rpc.OBS_ROUPASCALCADOS"));
				System.out.println(rs.getString("msg.MSG_MENSAGEM"));
				
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
	public void QueryCaixadeEntradaMensagensInstituicao(Mensagem mensagem) {
		
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[] { "idMensagem", "iDMüll", "Data Mensagem" , "Descrição" ,  "Cidade" , "Bairro" };
		conexao c = new conexao();// import conexão
		try {

			String q = "";
			q += " SELECT msg.COD_MENSAGEM, msg.COD_MMULL,";
			q += " DATE(msg.DAT_MENSAGEM),mm.DES_TAB, c.DES_CIDADE , b.DES_BAIRRO";
			q += " FROM mensagemcliente msg";
			q += " INNER JOIN mmull mm ON mm.COD_mMuLL = msg.COD_MMULL ";
			q += " INNER JOIN usuario us ON us.COD_Usuario = mm.COD_USUARIO";
			q += " INNER JOIN dados_usuario dus ON dus.COD_DADOS = us.COD_DADOS";
			q += " INNER JOIN endereco en ON en.COD_ENDERECO = dus.COD_ENDERECO";
			q += " INNER JOIN bairro b ON b.COD_BAIRRO = en.COD_BAIRRO";
			q += " INNER JOIN cidade c ON c.COD_CIDADE = b.COD_CIDADE";
			q += " WHERE msg.COD_EMPRESA = ?";
			q += " Order by DAT_MENSAGEM desc";

			PreparedStatement comando = c.conn.prepareStatement(q);
			comando.setString(1, Usuario.getCOD_USUARIO());

			ResultSet rs = comando.executeQuery();

			ModeloTabela modelo = new ModeloTabela(dados, colunas);
			tblConsulta.setModel(modelo);
			tblConsulta.setShowGrid(false);
			tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(80);
			tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(80);
			tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(120);
			tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(200);
			tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(200);
			tblConsulta.getColumnModel().getColumn(5).setPreferredWidth(200);
			
			

			tblConsulta.getTableHeader().setReorderingAllowed(false);
			tblConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			while (rs.next()) {

				dados.add(new Object[] { rs.getString("msg.COD_MENSAGEM"),
						rs.getString("msg.COD_MMULL"), rs.getString("DATE(msg.DAT_MENSAGEM)"),
						rs.getString("mm.DES_TAB"), rs.getString("c.DES_CIDADE"),
						rs.getString("b.DES_BAIRRO")});
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

	
	
	public void EnviarMensagemUsuario(Mensagem mensagem){

		conexao c = new conexao();
		try {

			Statement comando =  c.conn.createStatement(); 
			String q = "";

		q +=" INSERT INTO mensagemempresa";
		q +=" (COD_MENSAGEM, COD_MMULL, COD_EMPRESA, STA_MENSAGEM, DAT_MENSAGEM, MSG_MENSAGEM, COD_USUARIO)";
		q +=" VALUES (NULL , ";
		q += mensagem.getCOD_mMuLL()+", ";
		q += Usuario.getCOD_USUARIO()+", ";
		q += "'COLETA EFETUADA', ";
		q +=" NOW(),";
		q +="'Olá Somos da empresa "+Usuario.getNOM_USUARIO()+".";
		q +="\nSua Coleta de número: "+mensagem.getCOD_mMuLL()+". ";
		q +="\nCategoria : "+mensagem.getDES_TAB()+" foi coletada:";
		q +="\nDia : "+mensagem.getDATACOLETA();
		q +="\nNo Horario: "+mensagem.getHORARIO_JTABLE()+".Agradecemos sua colaboração.', "; 
		q += mensagem.getCOD_USUARIO_ENVIOMENSAGEM()+")";  
		
		
		 comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FAlha EnviarMensagemUsuario()");
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
	
	public void EnviarMensagemUsuarioCOLETANAOEFETUADA(Mensagem mensagem){

		conexao c = new conexao();
		try {

			Statement comando =  c.conn.createStatement(); // java.sql
															// em
			String q = "";

		q +=" INSERT INTO mensagemempresa";
		q +=" (COD_MENSAGEM, COD_MMULL, COD_EMPRESA, STA_MENSAGEM, DAT_MENSAGEM, MSG_MENSAGEM, COD_USUARIO)";
		q +=" VALUES (NULL , ";
		q += mensagem.getCOD_mMuLL()+", ";
		q += Usuario.getCOD_USUARIO()+", ";
		q += "'NÃO LIDA - COLETA CANCELADA', ";
		q +=" NOW(),";
		q +="'Olá Somos da empresa "+Usuario.getNOM_USUARIO()+".";
		q +="\nSua Coleta de número: "+mensagem.getCOD_mMuLL()+". ";
		q +="\nCategoria : "+mensagem.getDES_TAB()+" não foi coletada , sua solicitação retornou para um novo agendamento:";
		q +="\nDia : "+mensagem.getDATACOLETA();
		q +="\nNo Horario: "+mensagem.getHORARIO_JTABLE()+". Agradecemos sua colaboração.', "; 
		q += mensagem.getCOD_USUARIO_ENVIOMENSAGEM()+")";  
		
		
		 comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FAlha EnviarMensagemUsuario()");
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
	public void EnviarMensagemParaUsuario(Mensagem mensagem) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql
															// em
			String q = "";

			q += " INSERT INTO mensagemempresa";
			q += " (COD_MENSAGEM, COD_MMULL, COD_EMPRESA, STA_MENSAGEM, DAT_MENSAGEM, MSG_MENSAGEM, COD_USUARIO)";
			q += " VALUES (NULL , ";
			q += mensagem.getCOD_mMuLL() + ", ";
			q += Usuario.getCOD_USUARIO() + ", ";
			q += "'NÃO LIDA', ";
			q += " NOW(),";
			q += "'Olá Somos da empresa " + mensagem.getNOM_EMPRESA() + ".";
			q += "\nSua Coleta de número: " + mensagem.getCOD_mMuLL() + ". ";
			q += "\nCategoria : " + mensagem.getDES_TAB() + " foi agendada para:";
			q += "\nDia : " + mensagem.getDATACOLETA() + " " + mensagem.getStringDia();
			q += "\nEntre o Horario : " + mensagem.getHORARIO_JTABLE() +"\nAguardamos sua confirmação.Vá ate o menu Müll-> Gerenciar müll. Escolha a opção Confirmar coleta/ cancelar coleta" +"', ";
			q += mensagem.getCOD_USUARIO_ENVIOMENSAGEM() + ")";

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FAlha no Envio da Mensagem.");
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
	public void EnviarMensagemParaUsuarioCancelarColeta(Mensagem mensagem) {

		conexao c = new conexao();// import conexão
		try {

			Statement comando = c.conn.createStatement(); // java.sql
															// em
			String q = "";

			q += " INSERT INTO mensagemempresa";
			q += " (COD_MENSAGEM, COD_MMULL, COD_EMPRESA, STA_MENSAGEM, DAT_MENSAGEM, MSG_MENSAGEM, COD_USUARIO)";
			q += " VALUES (NULL , ";
			q += mensagem.getCOD_mMuLL() + ", ";
			q += Usuario.getCOD_USUARIO() + ", ";
			q += "'NÃO LIDA', ";
			q += " NOW(),";
			q += "'Olá Somos da empresa " + mensagem.getNOM_EMPRESA() + ".";
			q += "\nSua Coleta de número: " + mensagem.getCOD_mMuLL() + ". ";
			q += "\nCategoria : " + mensagem.getDES_TAB() + " não pode ser coleta :";
			q += "\nDia : " + mensagem.getDATACOLETA() + " " + mensagem.getStringDia();
			q += "\nEntre o Horario : " + mensagem.getHORARIO_JTABLE() +".\n Seu pedido voltará para o menu müll e estará disponível para outro agendamento.\n Desde já agradecemos sua colaboração." +"', ";
			q += mensagem.getCOD_USUARIO_ENVIOMENSAGEM() + ")";

			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.err.println("FAlha no Envio da Mensagem.");
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
