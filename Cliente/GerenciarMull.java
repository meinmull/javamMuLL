package Cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import ClienteEditarMull.EditarEletronico;
import ClienteEditarMull.EditarMetal;
import ClienteEditarMull.EditarRoupasEcalcados;
import ClienteEditarMull.EditarSeletiva;
import ClienteEditarMull.EditarVidro;
import beansCliente.cColeta;
import beansCliente.cDisponibilidade;
import beansCliente.cMensagem;
import beansCliente.cMull;
import daoCliente.cDAOcoleta;
import daoCliente.cDAOcount;
import daoCliente.cDAOdisponibilidade;
import daoCliente.cDAOmensagem;
import daoCliente.cDAOmull;
import login.menulogin;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GerenciarMull extends JFrame {

	cDAOmull CdaoMULL = new cDAOmull();
	cDAOcoleta CdaoCOLETA = new cDAOcoleta();
	cMull Cmull = new cMull();
	cColeta cCOLETA = new cColeta();
	cDisponibilidade cDISPONIBILIDADE = new cDisponibilidade();
	cDAOdisponibilidade CdaoDISPONIBILIDADE = new cDAOdisponibilidade();
	cDAOmensagem CdaoMENSAGEM = new cDAOmensagem();
	cMensagem Cmensagem = new cMensagem();
	cDAOcount CdaoCOUNT = new cDAOcount();
	
	JCheckBox cbx1 = new JCheckBox("");
	private JPanel contentPane;

	JButton btnConfirmarColeta = new JButton("");
	JButton btnCancelarMmll = new JButton("");
	JButton btnCancelarColeta = new JButton("");
	JButton btnEditar = new JButton("");
	JButton btnColetaSucedida = new JButton("");
	JButton btnColetaNoSucedida = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarMull frame = new GerenciarMull();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public GerenciarMull() {

		
		setTitle("Procurar Novas Coletas - Todas as Categorias");
		ImageIcon ImageIcon = new ImageIcon("src/resources/icone.png");
		Image Image = ImageIcon.getImage();
		this.setIconImage(Image);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 30, 912, 257);
		contentPane.add(panel_2);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 13, 255, 228);
		panel_2.add(scrollPane_2);

		CdaoMULL.tablemMuLL = new JTable();
		scrollPane_2.setViewportView(CdaoMULL.tablemMuLL);
		CdaoMULL.tablemMuLL.setFont(new Font("Roboto Light", Font.BOLD, 13));

		JLabel lblIdMll = new JLabel("ID M\u00FCll");
		lblIdMll.setForeground(Color.WHITE);
		lblIdMll.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblIdMll.setBounds(279, 14, 56, 16);
		panel_2.add(lblIdMll);

		CdaoMULL.txtCodMull = new JTextField();
		CdaoMULL.txtCodMull.setBounds(404, 8, 142, 22);
		CdaoMULL.txtCodMull.setFont(new Font("Roboto Light", Font.BOLD, 13));
		panel_2.add(CdaoMULL.txtCodMull);
		CdaoMULL.txtCodMull.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblDescrio.setBounds(279, 44, 89, 16);
		panel_2.add(lblDescrio);

		CdaoMULL.txtDescricao = new JTextField();
		CdaoMULL.txtDescricao.setBounds(404, 38, 142, 22);
		CdaoMULL.txtDescricao.setFont(new Font("Roboto Light", Font.BOLD, 13));
		panel_2.add(CdaoMULL.txtDescricao);
		CdaoMULL.txtDescricao.setColumns(10);

		JLabel lblDataSolicitao = new JLabel("Data solicita\u00E7\u00E3o");
		lblDataSolicitao.setForeground(Color.WHITE);
		lblDataSolicitao.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblDataSolicitao.setBounds(279, 74, 121, 16);
		panel_2.add(lblDataSolicitao);

		CdaoMULL.txtSolicitacao = new JTextField();
		CdaoMULL.txtSolicitacao.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoMULL.txtSolicitacao.setBounds(404, 68, 142, 22);
		panel_2.add(CdaoMULL.txtSolicitacao);
		CdaoMULL.txtSolicitacao.setColumns(10);

		JLabel lblAgendada = new JLabel("Agendada");
		lblAgendada.setForeground(Color.WHITE);
		lblAgendada.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblAgendada.setBounds(279, 104, 89, 16);
		panel_2.add(lblAgendada);

		CdaoMULL.txtSIT_Mull = new JTextField();
		CdaoMULL.txtSIT_Mull.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoMULL.txtSIT_Mull.setBounds(404, 98, 142, 22);
		panel_2.add(CdaoMULL.txtSIT_Mull);
		CdaoMULL.txtSIT_Mull.setColumns(10);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblPeso.setBounds(279, 134, 89, 16);
		panel_2.add(lblPeso);

		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio_1.setForeground(Color.WHITE);
		lblDescrio_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblDescrio_1.setBounds(279, 164, 89, 16);
		panel_2.add(lblDescrio_1);

		JLabel lblPeas = new JLabel("Pe\u00E7as");
		lblPeas.setForeground(Color.WHITE);
		lblPeas.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblPeas.setBounds(279, 194, 56, 16);
		panel_2.add(lblPeas);

		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setForeground(Color.WHITE);
		lblObservao.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblObservao.setBounds(578, 134, 94, 16);
		panel_2.add(lblObservao);

		CdaoMULL.txtPeso = new JTextField();
		CdaoMULL.txtPeso.setBounds(404, 128, 142, 22);
		panel_2.add(CdaoMULL.txtPeso);
		CdaoMULL.txtPeso.setColumns(10);

		CdaoMULL.txtDescricaom = new JTextField();
		CdaoMULL.txtDescricaom.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoMULL.txtDescricaom.setBounds(404, 158, 142, 22);
		panel_2.add(CdaoMULL.txtDescricaom);
		CdaoMULL.txtDescricaom.setColumns(10);

		CdaoMULL.txtPecas = new JTextField();
		CdaoMULL.txtPecas.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoMULL.txtPecas.setBounds(404, 188, 142, 22);
		panel_2.add(CdaoMULL.txtPecas);
		CdaoMULL.txtPecas.setColumns(10);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(578, 160, 320, 69);
		panel_2.add(scrollPane_3);

		CdaoMULL.txtObs = new JTextArea();
		CdaoMULL.txtObs.setFont(new Font("Roboto Light", Font.BOLD, 13));
		scrollPane_3.setViewportView(CdaoMULL.txtObs);
		btnEditar.setBounds(578, 13, 320, 45);
		panel_2.add(btnEditar);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnEditar.jpg")));

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDadosMull();
				EditarMull();
				System.out.println(Cmull.getCOD_MULL());
				cDISPONIBILIDADE.setCOD_MULL(Cmull.getCOD_MULL());
				
				
				
				/*
				 * Vars.COD_mMuLL_MINHASSOLICITACOES = solus.COD_mMuLL;
				 * emp.COD_mMuLL = solus.COD_mMuLL;
				 * 
				 * EditarMull();
				 */

			}
		});
		btnEditar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnEditar.jpg")));
		btnCancelarMmll.setBounds(578, 74, 320, 45);
		panel_2.add(btnCancelarMmll);
		btnCancelarMmll.setBackground(Color.WHITE);

		btnCancelarMmll.setEnabled(false);
		btnCancelarMmll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CdaoMULL.CancelarmMull(Cmull); 
				cCOLETA.setCOD_MULL(Cmull.getCOD_MULL());
				cCOLETA.setCOD_COLETA(CdaoCOLETA.txtCOD_COL.getText());
				CdaoCOLETA.CancelarColeta(cCOLETA); 
				CdaoMULL.QuerymMuLL();
				CdaoCOLETA.QuerymMuLLColetas(cCOLETA); 
				
				 

			}
		});
		btnCancelarMmll.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnExcluirMull.jpg")));

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBounds(0, 300, 912, 375);
		contentPane.add(panel_3);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setLayout(null);

		CdaoCOUNT.txtnroAgendamentos = new JTextField();
		CdaoCOUNT.txtnroAgendamentos.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtnroAgendamentos.setForeground(Color.WHITE);
		CdaoCOUNT.txtnroAgendamentos.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtnroAgendamentos.setEnabled(false);
		CdaoCOUNT.txtnroAgendamentos.setColumns(10);
		CdaoCOUNT.txtnroAgendamentos.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtnroAgendamentos.setBounds(605, 310, 281, 22);
		panel_3.add(CdaoCOUNT.txtnroAgendamentos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(352, 13, 534, 118);
		panel_3.add(scrollPane);

		CdaoCOLETA.tblConsulta = new JTable();
		CdaoCOLETA.tblConsulta.setFont(new Font("Roboto Light", Font.BOLD, 13));
		scrollPane.setViewportView(CdaoCOLETA.tblConsulta);

		JLabel lblIdColeta_1 = new JLabel("Id Coleta");
		lblIdColeta_1.setForeground(Color.WHITE);
		lblIdColeta_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblIdColeta_1.setBounds(352, 175, 177, 16);
		panel_3.add(lblIdColeta_1);

		JLabel lbldiacoleta = new JLabel("Dia");
		lbldiacoleta.setForeground(Color.WHITE);
		lbldiacoleta.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lbldiacoleta.setBounds(352, 205, 177, 16);
		panel_3.add(lbldiacoleta);

		JLabel lblDataAgendada = new JLabel("Data agendada");
		lblDataAgendada.setForeground(Color.WHITE);
		lblDataAgendada.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblDataAgendada.setBounds(352, 235, 177, 16);
		panel_3.add(lblDataAgendada);

		JLabel lblNomeEmpresa = new JLabel("Nome empresa");
		lblNomeEmpresa.setForeground(Color.WHITE);
		lblNomeEmpresa.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblNomeEmpresa.setBounds(352, 265, 177, 16);
		panel_3.add(lblNomeEmpresa);

		JLabel lblPeridoAgendado = new JLabel("Perido agendado");
		lblPeridoAgendado.setForeground(Color.WHITE);
		lblPeridoAgendado.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblPeridoAgendado.setBounds(352, 295, 177, 16);
		panel_3.add(lblPeridoAgendado);

		JLabel lblSituaoColeta = new JLabel("Situa\u00E7\u00E3o  da coleta");
		lblSituaoColeta.setForeground(Color.WHITE);
		lblSituaoColeta.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblSituaoColeta.setBounds(352, 145, 177, 16);
		panel_3.add(lblSituaoColeta);

		CdaoCOLETA.txtSIT_COL = new JTextField();
		CdaoCOLETA.txtSIT_COL.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOLETA.txtSIT_COL.setForeground(Color.BLACK);
		CdaoCOLETA.txtSIT_COL.setBackground(Color.WHITE);
		CdaoCOLETA.txtSIT_COL.setBounds(605, 144, 281, 22);
		panel_3.add(CdaoCOLETA.txtSIT_COL);
		CdaoCOLETA.txtSIT_COL.setColumns(10);

		CdaoCOLETA.txtCOD_COL = new JTextField();
		CdaoCOLETA.txtCOD_COL.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOLETA.txtCOD_COL.setForeground(Color.BLACK);
		CdaoCOLETA.txtCOD_COL.setBackground(Color.WHITE);
		CdaoCOLETA.txtCOD_COL.setBounds(605, 172, 109, 22);
		panel_3.add(CdaoCOLETA.txtCOD_COL);
		CdaoCOLETA.txtCOD_COL.setColumns(10);

		CdaoCOUNT.txtDIA_COL = new JTextField();
		CdaoCOUNT.txtDIA_COL.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtDIA_COL.setForeground(Color.WHITE);
		CdaoCOUNT.txtDIA_COL.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtDIA_COL.setColumns(10);
		CdaoCOUNT.txtDIA_COL.setBounds(605, 202, 281, 22);
		panel_3.add(CdaoCOUNT.txtDIA_COL);

		CdaoCOLETA.txtDAT_COL = new JTextField();
		CdaoCOLETA.txtDAT_COL.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOLETA.txtDAT_COL.setForeground(Color.BLACK);
		CdaoCOLETA.txtDAT_COL.setBackground(Color.WHITE);
		CdaoCOLETA.txtDAT_COL.setColumns(10);
		CdaoCOLETA.txtDAT_COL.setBounds(605, 234, 281, 22);
		panel_3.add(CdaoCOLETA.txtDAT_COL);

		CdaoCOLETA.txtNOM_EMPRESA = new JTextField();
		CdaoCOLETA.txtNOM_EMPRESA.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOLETA.txtNOM_EMPRESA.setForeground(Color.BLACK);
		CdaoCOLETA.txtNOM_EMPRESA.setBackground(Color.WHITE);
		CdaoCOLETA.txtNOM_EMPRESA.setColumns(10);
		CdaoCOLETA.txtNOM_EMPRESA.setBounds(605, 262, 281, 22);
		panel_3.add(CdaoCOLETA.txtNOM_EMPRESA);

		CdaoCOLETA.txtPER_COLETA = new JTextField();
		CdaoCOLETA.txtPER_COLETA.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOLETA.txtPER_COLETA.setForeground(Color.BLACK);
		CdaoCOLETA.txtPER_COLETA.setBackground(Color.WHITE);
		CdaoCOLETA.txtPER_COLETA.setColumns(10);
		CdaoCOLETA.txtPER_COLETA.setBounds(605, 294, 281, 22);
		panel_3.add(CdaoCOLETA.txtPER_COLETA);
		btnColetaNoSucedida.setBounds(12, 275, 320, 45);
		panel_3.add(btnColetaNoSucedida);

		btnColetaNoSucedida.setBackground(Color.WHITE);
		btnColetaNoSucedida.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnColetaNaoEfetuada.jpg")));
		btnColetaNoSucedida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cCOLETA.setCOD_MULL(Cmull.getCOD_MULL());
				cCOLETA.setCOD_COLETA(CdaoCOLETA.txtCOD_COL.getText());
				  CdaoCOLETA.FinalizarColetaNAO(cCOLETA); 
				  CdaoMULL.FinalizarMullNAO(Cmull);
				  getDadosMensagem();
				  CdaoMENSAGEM.EnviarMensagemEmpresaColetaNaoColetada(Cmensagem); 
				  CdaoMULL.QuerymMuLL();
				  CdaoCOLETA.QuerymMuLLColetas(cCOLETA);
				
				 
			}
		});

		btnColetaNoSucedida.setEnabled(false);
		btnColetaSucedida.setBounds(12, 195, 320, 45);
		panel_3.add(btnColetaSucedida);
		btnColetaSucedida.setBackground(Color.WHITE);
		btnColetaSucedida.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnColetaColetada.jpg")));
		btnColetaSucedida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cCOLETA.setCOD_MULL(Cmull.getCOD_MULL());
				cCOLETA.setCOD_COLETA(CdaoCOLETA.txtCOD_COL.getText());
				  CdaoCOLETA.FinalizarColeta(cCOLETA); 
				  CdaoMULL.FinalizarMull(Cmull); 
				  CdaoMULL.QuerymMuLL();
				  CdaoCOLETA.QuerymMuLLColetas(cCOLETA);
				  
				 
			}
		});
		btnColetaSucedida.setEnabled(false);
		btnConfirmarColeta.setBounds(12, 35, 320, 45);
		panel_3.add(btnConfirmarColeta);
		btnConfirmarColeta.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConfirmarColeta.jpg")));
		btnConfirmarColeta.setBackground(Color.WHITE);
		btnConfirmarColeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cCOLETA.setCOD_MULL(Cmull.getCOD_MULL());
				cCOLETA.setCOD_COLETA(CdaoCOLETA.txtCOD_COL.getText());
				
				CdaoCOLETA.ConfirmarColeta(cCOLETA);
				CdaoMULL.QuerymMuLL();
				CdaoCOLETA.QuerymMuLLColetas(cCOLETA);
				

			}
		});
		btnConfirmarColeta.setEnabled(false);
		btnCancelarColeta.setBounds(12, 115, 320, 45);
		panel_3.add(btnCancelarColeta);
		btnCancelarColeta.setEnabled(false);
		btnCancelarColeta.setBackground(Color.WHITE);
		btnCancelarColeta.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnCancelarColeta.jpg")));

		JLabel lblIdEmpresa = new JLabel("ID Empresa :");
		lblIdEmpresa.setForeground(Color.WHITE);
		lblIdEmpresa.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblIdEmpresa.setBounds(726, 175, 96, 16);
		panel_3.add(lblIdEmpresa);

		CdaoCOLETA.txtCOD_EMPRESA = new JTextField();
		CdaoCOLETA.txtCOD_EMPRESA.setBounds(822, 172, 64, 22);
		panel_3.add(CdaoCOLETA.txtCOD_EMPRESA);

		CdaoCOLETA.txtCOD_EMPRESA.setColumns(10);
		btnCancelarColeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getDadosMensagem();
				CdaoMENSAGEM.EnviarMensagemEmpresaCancelamento(Cmensagem);
				cCOLETA.setCOD_COLETA(CdaoCOLETA.txtCOD_COL.getText());
				CdaoCOLETA.CancelarColeta(cCOLETA); 
				CdaoMULL.CancelarColetaUpdatemMull(Cmull);
				CdaoMULL.QuerymMuLL(); 
				CdaoCOLETA.QuerymMuLLColetas(cCOLETA);
				 

			}
		});
		CdaoCOLETA.tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getDadosColeta();
				CdaoCOLETA.SetDadosColeta(cCOLETA);
				verificacaoBotao();

			}
		});
		CdaoMULL.tablemMuLL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ApagaCamposMull();
				ApagaCamposColeta();
				getDadosMull();
				CdaoMULL.SetDadosmMuLL(Cmull);
				cDISPONIBILIDADE.setCOD_MULL(Cmull.getCOD_MULL());
				cCOLETA.setCOD_MULL(Cmull.getCOD_MULL());
				CdaoCOLETA.QuerymMuLLColetas(cCOLETA);
				CdaoCOLETA.tblConsulta.setRowSelectionInterval(0, 0);
				btnEnableFalse();

			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setOpaque(true);
		panel.setBounds(952, 96, 320, 484);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAConfirmar = new JLabel("A confirmar:");
		lblAConfirmar.setBounds(12, 34, 100, 30);
		panel.add(lblAConfirmar);
		lblAConfirmar.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblAConfirmar.setForeground(Color.WHITE);

		CdaoCOUNT.txtCOLPENDENTES = new JTextField();
		CdaoCOUNT.txtCOLPENDENTES.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtCOLPENDENTES.setBounds(235, 34, 85, 30);
		panel.add(CdaoCOUNT.txtCOLPENDENTES);
		CdaoCOUNT.txtCOLPENDENTES.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtCOLPENDENTES.setForeground(Color.WHITE);
		CdaoCOUNT.txtCOLPENDENTES.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtCOLPENDENTES.setEnabled(false);
		CdaoCOUNT.txtCOLPENDENTES.setColumns(10);

		JLabel lblColetasFinalizadas = new JLabel("Total de coletas Agendadas");
		lblColetasFinalizadas.setBounds(12, 98, 216, 30);
		panel.add(lblColetasFinalizadas);
		lblColetasFinalizadas.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblColetasFinalizadas.setForeground(Color.WHITE);

		CdaoCOUNT.txtCOLAGENDADAS = new JTextField();
		CdaoCOUNT.txtCOLAGENDADAS.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtCOLAGENDADAS.setBounds(235, 98, 85, 30);
		panel.add(CdaoCOUNT.txtCOLAGENDADAS);
		CdaoCOUNT.txtCOLAGENDADAS.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtCOLAGENDADAS.setForeground(Color.WHITE);
		CdaoCOUNT.txtCOLAGENDADAS.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtCOLAGENDADAS.setEnabled(false);
		CdaoCOUNT.txtCOLAGENDADAS.setColumns(10);

		JLabel lblTotalSolicitaes = new JLabel("Total mMuLL:");
		lblTotalSolicitaes.setBounds(12, 162, 109, 30);
		panel.add(lblTotalSolicitaes);
		lblTotalSolicitaes.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblTotalSolicitaes.setForeground(Color.WHITE);

		CdaoCOUNT.txtCountmMuLL = new JTextField();
		CdaoCOUNT.txtCountmMuLL.setBounds(235, 162, 85, 30);
		panel.add(CdaoCOUNT.txtCountmMuLL);
		CdaoCOUNT.txtCountmMuLL.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtCountmMuLL.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtCountmMuLL.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtCountmMuLL.setForeground(Color.WHITE);
		CdaoCOUNT.txtCountmMuLL.setEnabled(false);
		CdaoCOUNT.txtCountmMuLL.setColumns(10);

		JLabel lblPendentes_1 = new JLabel("Pendentes:");
		lblPendentes_1.setBounds(12, 226, 100, 30);
		panel.add(lblPendentes_1);
		lblPendentes_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblPendentes_1.setForeground(Color.WHITE);

		CdaoCOUNT.txtCOLNAO = new JTextField();
		CdaoCOUNT.txtCOLNAO.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtCOLNAO.setBounds(235, 226, 85, 30);
		panel.add(CdaoCOUNT.txtCOLNAO);
		CdaoCOUNT.txtCOLNAO.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtCOLNAO.setForeground(Color.WHITE);
		CdaoCOUNT.txtCOLNAO.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtCOLNAO.setEnabled(false);
		CdaoCOUNT.txtCOLNAO.setColumns(10);

		JLabel lblCanceladas = new JLabel("Canceladas:");
		lblCanceladas.setBounds(12, 290, 100, 30);
		panel.add(lblCanceladas);
		lblCanceladas.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblCanceladas.setForeground(Color.WHITE);

		CdaoCOUNT.txtCOLCANCELADAS = new JTextField();
		CdaoCOUNT.txtCOLCANCELADAS.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtCOLCANCELADAS.setBounds(235, 290, 85, 30);
		panel.add(CdaoCOUNT.txtCOLCANCELADAS);
		CdaoCOUNT.txtCOLCANCELADAS.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtCOLCANCELADAS.setForeground(Color.WHITE);
		CdaoCOUNT.txtCOLCANCELADAS.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtCOLCANCELADAS.setEnabled(false);
		CdaoCOUNT.txtCOLCANCELADAS.setColumns(10);

		CdaoCOUNT.txtCOLAGENDADAS.setText("");
		
		JLabel lblPendentes = new JLabel("Em Andamento:");
		lblPendentes.setBounds(12, 354, 127, 30);
		panel.add(lblPendentes);
		lblPendentes.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblPendentes.setForeground(Color.WHITE);

		CdaoCOUNT.txtCOLEMANDAMENTO = new JTextField();
		CdaoCOUNT.txtCOLEMANDAMENTO.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtCOLEMANDAMENTO.setBounds(235, 354, 85, 30);
		panel.add(CdaoCOUNT.txtCOLEMANDAMENTO);
		CdaoCOUNT.txtCOLEMANDAMENTO.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtCOLEMANDAMENTO.setForeground(Color.WHITE);
		CdaoCOUNT.txtCOLEMANDAMENTO.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtCOLEMANDAMENTO.setEnabled(false);
		CdaoCOUNT.txtCOLEMANDAMENTO.setColumns(10);

		JLabel lblFinalizadas = new JLabel("Finalizadas:");
		lblFinalizadas.setBounds(12, 418, 109, 30);
		panel.add(lblFinalizadas);
		lblFinalizadas.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblFinalizadas.setForeground(Color.WHITE);

		CdaoCOUNT.txtCOLFINALIZADA = new JTextField();
		CdaoCOUNT.txtCOLFINALIZADA.setFont(new Font("Roboto Light", Font.BOLD, 13));
		CdaoCOUNT.txtCOLFINALIZADA.setBounds(235, 418, 85, 30);
		panel.add(CdaoCOUNT.txtCOLFINALIZADA);
		
		CdaoCOUNT.txtAGENDAMENTOIDCOLETA = new JTextField();
		CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setBounds(243, 102, 77, 22);
		panel.add(CdaoCOUNT.txtAGENDAMENTOIDCOLETA);
		CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setColumns(10);
		
		CdaoCOUNT.txtCOLFINALIZADA.setHorizontalAlignment(SwingConstants.CENTER);
		CdaoCOUNT.txtCOLFINALIZADA.setForeground(Color.WHITE);
		CdaoCOUNT.txtCOLFINALIZADA.setBackground(Color.DARK_GRAY);
		CdaoCOUNT.txtCOLFINALIZADA.setEnabled(false);
		CdaoCOUNT.txtCOLFINALIZADA.setColumns(10);

		JButton btnSair = new JButton("");
		btnSair.setBounds(952, 593, 320, 45);
		contentPane.add(btnSair);
		btnSair.setBackground(Color.WHITE);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharLogin.jpg")));

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 173, 87, -118);
		contentPane.add(scrollPane_1);

		contentPane.add(cbx1);

		JLabel frame = new JLabel("");
		frame.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.setForeground(Color.WHITE);
		frame.setBounds(0, 0, 1280, 670);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/testefundo5.jpg")));
		contentPane.add(frame);
		CdaoMULL.QuerymMuLL();
		CdaoCOUNT.showColetas();
		metodo();

	}

	
	
	

	public void ApagaCamposColeta() {
		CdaoCOLETA.txtCOD_COL.setText("");
		CdaoCOLETA.txtCOD_EMPRESA.setText("");
		CdaoCOLETA.txtDAT_COL.setText("");
		CdaoCOLETA.txtNOM_EMPRESA.setText("");
		CdaoCOLETA.txtPER_COLETA.setText("");
		CdaoCOLETA.txtSIT_COL.setText("");
	}

	public void getDadosColeta() {
		int a = 0;
		int b = 0;
		a = CdaoCOLETA.tblConsulta.getSelectedRow();
		cCOLETA.setCOD_COLETA((String) CdaoCOLETA.tblConsulta.getValueAt(a, 0));
		cCOLETA.setSIT_COL((String) CdaoCOLETA.tblConsulta.getValueAt(a, 2));
	}

	public void getDadosMull() {
		int a = 0;
		int b = 0;
		a = CdaoMULL.tablemMuLL.getSelectedRow();
		Cmull.setCOD_MULL((String) CdaoMULL.tablemMuLL.getValueAt(a, 0));
		Cmull.setDES_TAB((String) CdaoMULL.tablemMuLL.getValueAt(a, 1));
		CdaoMULL.txtDescricao.setText(Cmull.getDES_TAB());
		CdaoMULL.txtCodMull.setText(Cmull.getCOD_MULL());

	}

	public void verificacaoBotao() {
		btnEditarVERIFICACAO();
		btnCancelarVERIFICACAO();
		btnColetaNaoSucedidaVERIFICACAO();
		btnColetaSucedidaVERIFICACAO();
		btnCancelarColetaVERIFICACAO();
		btnConfirmarColetaVERIFICACAO();
	}

	public void btnConfirmarColetaVERIFICACAO() {
		if (cCOLETA.getSIT_COL().equalsIgnoreCase("NÃO CONFIRMADA")) {
			btnConfirmarColeta.setEnabled(true);

		} else
			btnConfirmarColeta.setEnabled(false);
	}

	public void btnCancelarColetaVERIFICACAO() {
		if (cCOLETA.getSIT_COL().equalsIgnoreCase("CANCELADA")
				|| cCOLETA.getSIT_COL().equalsIgnoreCase("NÃO COLETADA")
				|| cCOLETA.getSIT_COL().equalsIgnoreCase("CANCELADA PELA EMPRESA")){
			btnCancelarColeta.setEnabled(false);
		} else if (Cmull.getCOL_AGENDADA().equalsIgnoreCase("SIM") || Cmull.getCOL_AGENDADA().equalsIgnoreCase("NÃO")
				|| Cmull.getCOL_AGENDADA().equalsIgnoreCase("'NÃO'")
				|| cCOLETA.getSIT_COL().equalsIgnoreCase("NÃO CONFIRMADA")
				|| cCOLETA.getSIT_COL().equalsIgnoreCase("CONFIRMADA")) {
			btnCancelarColeta.setEnabled(true);
		} else if (cCOLETA.getSIT_COL().equalsIgnoreCase("CANCELADA")
				|| cCOLETA.getSIT_COL().equalsIgnoreCase("COLETADA"))
		{
			btnCancelarColeta.setEnabled(false);
		} else
			btnCancelarColeta.setEnabled(false);
	}

	public void btnColetaSucedidaVERIFICACAO() {
		if (cCOLETA.getSIT_COL().equalsIgnoreCase("COLETADA")) {
			btnColetaSucedida.setEnabled(true);
		} else
			btnColetaSucedida.setEnabled(false);
	}

	public void btnColetaNaoSucedidaVERIFICACAO() {
	if (cCOLETA.getSIT_COL().equalsIgnoreCase("CANCELADA")||cCOLETA.getSIT_COL().equalsIgnoreCase("NÃO COLETADA")){
		btnColetaNoSucedida.setEnabled(false);
	}
		else if (Cmull.getCOL_AGENDADA().equalsIgnoreCase("COLETADA")) {
			btnColetaNoSucedida.setEnabled(true);
		} else
			btnColetaNoSucedida.setEnabled(false);
	}

	public void btnEditarVERIFICACAO() {
		if (Cmull.getCOL_AGENDADA().equalsIgnoreCase("'NÃO'") || Cmull.getCOL_AGENDADA().equalsIgnoreCase("NÃO")) {
			btnEditar.setEnabled(true);

		} else
			btnEditar.setEnabled(false);
	}

	public void btnCancelarVERIFICACAO() {
		if (Cmull.getCOL_AGENDADA().equalsIgnoreCase("NÃO") || Cmull.getCOL_AGENDADA().equalsIgnoreCase("'NÃO'")
				|| Cmull.getCOL_AGENDADA().equalsIgnoreCase("SIM")
				|| cCOLETA.getSIT_COL().equalsIgnoreCase("CONFIRMADA")
				|| cCOLETA.getSIT_COL().equalsIgnoreCase("NÃO CONFIRMADA")) {
			btnCancelarMmll.setEnabled(true);
		}else if(cCOLETA.getSIT_COL().equalsIgnoreCase("CANCELADA")||cCOLETA.getSIT_COL().equalsIgnoreCase("COLETADA")||cCOLETA.getSIT_COL().equalsIgnoreCase("FINALIZADA")){
			btnCancelarMmll.setEnabled(false);
		}
		  else
			btnCancelarMmll.setEnabled(false);
	}

	public void btnEnableFalse() {
		btnConfirmarColeta.setEnabled(false);
		btnCancelarColeta.setEnabled(false);
		btnColetaSucedida.setEnabled(false);
		btnColetaNoSucedida.setEnabled(false);
		btnEditar.setEnabled(false);
		btnCancelarMmll.setEnabled(false);
	}

	public void EditarMull() {
		if (Cmull.getDES_TAB().equalsIgnoreCase("ELETRONICO")) {
			EditarEletronico frame = new EditarEletronico();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			
			
			
		} else if (Cmull.getDES_TAB().equalsIgnoreCase("METAL")) {
			EditarMetal frame = new EditarMetal();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);

		} else if (Cmull.getDES_TAB().equalsIgnoreCase("VIDRO")) {
			EditarVidro frame = new EditarVidro();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} else if (Cmull.getDES_TAB().equalsIgnoreCase("ROUPAS E CALCADOS")) {
			EditarRoupasEcalcados frame = new EditarRoupasEcalcados();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);

		} else if (Cmull.getDES_TAB().equalsIgnoreCase("SELETIVA")) {
			EditarSeletiva frame = new EditarSeletiva();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} else if (Cmull.getDES_TAB().equalsIgnoreCase("PAPEL")) {
		}
	}
public void ApagaCamposMull(){
	
	CdaoMULL.txtDescricao.setText("");
	CdaoMULL.txtDescricaom.setText("");
	CdaoMULL.txtObs.setText("");
	CdaoMULL.txtPecas.setText("");
	CdaoMULL.txtPeso.setText("");
	CdaoMULL.txtSIT_Mull.setText("");
	CdaoMULL.txtSolicitacao.setText("");
	
	
}

public void getDadosMensagem(){
	 Cmensagem.setCOD_mMuLL(cCOLETA.getCOD_MULL()); 
	 Cmensagem.setDES_TAB(Cmull.getDES_TAB());
	 Cmensagem.setDataColeta(CdaoCOLETA.txtDAT_COL.getText()); 
	 Cmensagem.setHORA_COLETA(CdaoCOLETA.txtPER_COLETA.getText());
	 Cmensagem.setDES_TAB(CdaoMULL.txtDescricao.getText());
	 Cmensagem.setCOD_EMPRESA(CdaoCOLETA.txtCOD_EMPRESA.getText());
	 
	
	 
}
public void metodo(){
	CdaoCOUNT.txtCountmMuLL.setEnabled(true);
	CdaoCOUNT.txtCOLAGENDADAS.setEnabled(true);
	CdaoCOUNT.txtCOLCANCELADAS.setEnabled(true);
	CdaoCOUNT.txtCOLEMANDAMENTO.setEnabled(true);
	CdaoCOUNT.txtCOLPENDENTES.setEnabled(true);
	CdaoCOUNT.txtCOLFINALIZADA.setEnabled(true);
	CdaoCOUNT.txtCOLNAO.setEnabled(true);
	CdaoCOUNT.txtDIA_COL.setEnabled(true);
	CdaoCOUNT.txtnroAgendamentos.setEnabled(true);
	CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setEnabled(true);
	
	CdaoCOUNT.txtCountmMuLL.setEditable(false);
	CdaoCOUNT.txtCOLAGENDADAS.setEditable(false);
	CdaoCOUNT.txtCOLCANCELADAS.setEditable(false);
	CdaoCOUNT.txtCOLEMANDAMENTO.setEditable(false);
	CdaoCOUNT.txtCOLPENDENTES.setEditable(false);
	CdaoCOUNT.txtCOLFINALIZADA.setEditable(false);
	CdaoCOUNT.txtCOLNAO.setEditable(false);
	CdaoCOUNT.txtDIA_COL.setEditable(false);
	CdaoCOUNT.txtnroAgendamentos.setEditable(false);
	CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setEditable(false);
	
	CdaoCOUNT.txtCountmMuLL.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtCOLAGENDADAS.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtCOLCANCELADAS.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtCOLEMANDAMENTO.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtCOLPENDENTES.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtCOLFINALIZADA.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtCOLNAO.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtDIA_COL.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtnroAgendamentos.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setFont(new Font("Roboto Light", Font.BOLD, 17));
	CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setForeground(Color.WHITE);
	CdaoCOUNT.txtCountmMuLL.setOpaque(false);
	CdaoCOUNT.txtCOLAGENDADAS.setOpaque(false);
	CdaoCOUNT.txtCOLCANCELADAS.setOpaque(false);
	CdaoCOUNT.txtCOLEMANDAMENTO.setOpaque(false);
	CdaoCOUNT.txtCOLPENDENTES.setOpaque(false);
	CdaoCOUNT.txtCOLFINALIZADA.setOpaque(false);
	CdaoCOUNT.txtCOLNAO.setOpaque(false);
	CdaoCOUNT.txtDIA_COL.setOpaque(false);
	CdaoCOUNT.txtnroAgendamentos.setOpaque(false);
	CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setOpaque(false);
	
	CdaoCOUNT.txtCountmMuLL.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtCOLAGENDADAS.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtCOLCANCELADAS.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtCOLEMANDAMENTO.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtCOLPENDENTES.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtCOLFINALIZADA.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtCOLNAO.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtDIA_COL.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtnroAgendamentos.setBorder(BorderFactory.createEmptyBorder());
	CdaoCOUNT.txtAGENDAMENTOIDCOLETA.setBorder(BorderFactory.createEmptyBorder());
	
}
	

	

}
