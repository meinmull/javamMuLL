package Empresa;


import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import beans.Coleta;
import beans.Disponibilidade;
import beans.Endereco;
import beans.Mensagem;
import beans.Mull;
import beans.Usuario;
import dao.DAOcoleta;
import dao.DAOdisponibilidade;
import dao.DAOendereco;
import dao.DAOmensagem;
import dao.DAOmull;
import login.menulogin;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JInternalFrame;
import java.awt.Color;

@SuppressWarnings("unused")
public class EmpresaPesquisaColetasAgendadas extends JFrame {

	
	private static final long serialVersionUID = 1L;
	DAOcoleta daoCOLETA = new DAOcoleta();
	DAOendereco daoENDERECO = new DAOendereco();
	DAOmull daoMULL = new DAOmull();
	DAOdisponibilidade daoDISPONIBILIDADE = new DAOdisponibilidade();
	Disponibilidade disponibilidade = new Disponibilidade();
	Mull mull = new Mull();
	Coleta coleta = new Coleta();
	DAOmensagem daoMENSAGEM = new DAOmensagem();
	Mensagem mensagem = new Mensagem();
	Endereco endereco = new Endereco();

	
	
	
	
	
	
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaPesquisaColetasAgendadas frame = new EmpresaPesquisaColetasAgendadas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EmpresaPesquisaColetasAgendadas() {
		setTitle("Empresa - Coletas Agendadas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);

		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.DARK_GRAY);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 dispose();
				 
			}
		});
		
				JButton btnConsultar = new JButton("");
				btnConsultar.setBounds(12, 467, 320, 45);
				contentPane.add(btnConsultar);
				btnConsultar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConsultar.jpg")));
				btnConsultar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						QueryCompletaPesquisa();
						

					}
				});

		JInternalFrame iFrame = new JInternalFrame("Cancelar Coleta");
		iFrame.setBounds(443, 186, 378, 259);
		contentPane.add(iFrame);
		iFrame.getContentPane().setLayout(null);
		iFrame.setVisible(false);
		JButton btnCancelarColeta_iFrame = new JButton("");
		btnCancelarColeta_iFrame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnIFRAMEcancelarColeta.jpg")));
		btnCancelarColeta_iFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getCOD_mMuLL();
				CancelarColeta();
				iFrame.setVisible(false);
			}
		});
		btnCancelarColeta_iFrame.setBounds(148, 180, 227, 37);
		iFrame.getContentPane().add(btnCancelarColeta_iFrame);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				iFrame.setVisible(false);

			}
		});
		btnNewButton.setBounds(24, 180, 124, 37);
		iFrame.getContentPane().add(btnNewButton);

		txtInternalFrameData = new JTextField();
		txtInternalFrameData.setEnabled(false);
		txtInternalFrameData.setBounds(166, 131, 116, 22);
		iFrame.getContentPane().add(txtInternalFrameData);
		txtInternalFrameData.setColumns(10);

		txtIdinternalFrame = new JTextField();
		txtIdinternalFrame.setEnabled(false);
		txtIdinternalFrame.setBounds(166, 61, 116, 22);
		iFrame.getContentPane().add(txtIdinternalFrame);
		txtIdinternalFrame.setColumns(10);

		txtInternalFrameDescricao = new JTextField();
		txtInternalFrameDescricao.setEnabled(false);
		txtInternalFrameDescricao.setBounds(166, 96, 116, 22);
		iFrame.getContentPane().add(txtInternalFrameDescricao);
		txtInternalFrameDescricao.setColumns(10);
		iframe2.setBounds(0, 0, 375, 230);
		iframe2.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/IFRAMECANCELARCOLETA.jpg")));
		iFrame.getContentPane().add(iframe2);

		JLabel lblData = new JLabel("Data Coleta:");
		lblData.setBounds(87, 113, 74, 16);
		iFrame.getContentPane().add(lblData);

		iFrame.setVisible(true);

		iFrame.setVisible(false);
		btnSair.setBounds(12, 543, 320, 45);
		contentPane.add(btnSair);

		contentPane.add(DAOdisponibilidade.cbx1);
		
		DAOendereco.cbxEstado.setForeground(Color.WHITE);
		DAOendereco.cbxEstado.setBackground(Color.DARK_GRAY);
		DAOendereco.cbxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAOendereco.carregarCIDADE();
				DAOendereco.cbxCidade.setSelectedItem("SELECIONE");
			}
		});

		
		contentPane.add(DAOendereco.cbxEstado);
		DAOendereco.cbxCidade.setForeground(Color.WHITE);
		DAOendereco.cbxCidade.setBackground(Color.DARK_GRAY);
		DAOendereco.cbxCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAOendereco.carregarBairro();
				DAOendereco.cbxBairro.setSelectedItem("SELECIONE");
			}
		});

		
		contentPane.add(DAOendereco.cbxCidade);
		DAOendereco.cbxBairro.setForeground(Color.WHITE);
		DAOendereco.cbxBairro.setBackground(Color.DARK_GRAY);

		
		contentPane.add(DAOendereco.cbxBairro);
		DAOdisponibilidade.ckMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		DAOendereco.carregarESTADO();
		
		DAOmull.cbxmMuLL.setForeground(Color.WHITE);
		DAOmull.cbxmMuLL.setBackground(Color.DARK_GRAY);

		DAOmull.cbxmMuLL.setModel(new DefaultComboBoxModel(
				new String[] { "SELECIONE", "ROUPAS", "CALÇADOS", "ROUPAS DE BANHO E CAMA", }));
		
		contentPane.add(DAOmull.cbxmMuLL);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(367, 36, 838, 259);
		contentPane.add(scrollPane);

		DAOcoleta.tblConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		DAOcoleta.tblConsulta.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		DAOcoleta.tblConsulta.setOpaque(false);
		DAOcoleta.tblConsulta.setShowGrid(false);
		scrollPane.setViewportView(DAOcoleta.tblConsulta);

		JPanel panelInf = new JPanel();
		panelInf.setLayout(null);
		panelInf.setBackground(Color.DARK_GRAY);
		panelInf.setBounds(367, 308, 838, 329);
		contentPane.add(panelInf);

		DAOcoleta.txtBairo = new JTextField();
		DAOcoleta.txtBairo.setEditable(false);
		DAOcoleta.txtBairo.setBounds(359, 37, 209, 22);
		panelInf.add(DAOcoleta.txtBairo);
		DAOcoleta.txtBairo.setColumns(10);

		DAOcoleta.txtCidade = new JTextField();
		DAOcoleta.txtCidade.setEditable(false);
		DAOcoleta.txtCidade.setBounds(107, 37, 174, 22);
		panelInf.add(DAOcoleta.txtCidade);
		DAOcoleta.txtCidade.setColumns(10);

		DAOcoleta.txtCep = new JTextField();
		DAOcoleta.txtCep.setEditable(false);
		DAOcoleta.txtCep.setBounds(635, 37, 193, 22);
		panelInf.add(DAOcoleta.txtCep);
		DAOcoleta.txtCep.setColumns(10);

		DAOcoleta.txtDescricao = new JTextField();
		DAOcoleta.txtDescricao.setEditable(false);
		DAOcoleta.txtDescricao.setBounds(101, 137, 180, 22);
		panelInf.add(DAOcoleta.txtDescricao);
		DAOcoleta.txtDescricao.setColumns(10);

		DAOcoleta.txtComplemento = new JTextField();
		DAOcoleta.txtComplemento.setEditable(false);
		DAOcoleta.txtComplemento.setBounds(578, 66, 250, 22);
		panelInf.add(DAOcoleta.txtComplemento);
		DAOcoleta.txtComplemento.setColumns(10);

		DAOcoleta.txtEndereco = new JTextField();
		DAOcoleta.txtEndereco.setEditable(false);
		DAOcoleta.txtEndereco.setBounds(107, 66, 369, 22);
		panelInf.add(DAOcoleta.txtEndereco);
		DAOcoleta.txtEndereco.setColumns(10);

		DAOcoleta.txtDataSolicitacao = new JTextField();
		DAOcoleta.txtDataSolicitacao.setEditable(false);
		DAOcoleta.txtDataSolicitacao.setBounds(101, 170, 180, 22);
		panelInf.add(DAOcoleta.txtDataSolicitacao);
		DAOcoleta.txtDataSolicitacao.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Roboto", Font.BOLD, 13));
		lblBairro.setBounds(299, 39, 56, 16);
		panelInf.add(lblBairro);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Roboto", Font.BOLD, 13));
		lblCep.setBounds(578, 39, 41, 16);
		panelInf.add(lblCep);

		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Roboto", Font.BOLD, 13));
		lblEndereco.setBounds(12, 68, 73, 16);
		panelInf.add(lblEndereco);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("Roboto", Font.BOLD, 13));
		lblComplemento.setBounds(486, 70, 82, 16);
		panelInf.add(lblComplemento);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o ");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Roboto", Font.BOLD, 13));
		lblDescrio.setBounds(12, 139, 116, 16);
		panelInf.add(lblDescrio);

		JLabel lblDataSolicitao = new JLabel("Solicita\u00E7\u00E3o ");
		lblDataSolicitao.setForeground(Color.WHITE);
		lblDataSolicitao.setFont(new Font("Roboto", Font.BOLD, 13));
		lblDataSolicitao.setBounds(12, 172, 144, 16);
		panelInf.add(lblDataSolicitao);

		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o ");
		lblObservao.setForeground(Color.WHITE);
		lblObservao.setFont(new Font("Roboto", Font.BOLD, 13));
		lblObservao.setBounds(12, 223, 108, 16);
		panelInf.add(lblObservao);

		JLabel lblNmeroDePeas = new JLabel("Pe\u00E7as ");
		lblNmeroDePeas.setForeground(Color.WHITE);
		lblNmeroDePeas.setFont(new Font("Roboto", Font.BOLD, 13));
		lblNmeroDePeas.setBounds(293, 172, 65, 16);
		panelInf.add(lblNmeroDePeas);

		JLabel lblFaixaEtria = new JLabel("Descri\u00E7\u00E3o M\u00FCll");
		lblFaixaEtria.setForeground(Color.WHITE);
		lblFaixaEtria.setFont(new Font("Roboto", Font.BOLD, 13));
		lblFaixaEtria.setBounds(552, 139, 96, 16);
		panelInf.add(lblFaixaEtria);

		JLabel lblGenero = new JLabel("Peso");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Roboto", Font.BOLD, 13));
		lblGenero.setBounds(293, 139, 65, 16);
		panelInf.add(lblGenero);

		DAOcoleta.txtDescricaom = new JTextField();
		DAOcoleta.txtDescricaom.setEditable(false);
		DAOcoleta.txtDescricaom.setColumns(10);
		DAOcoleta.txtDescricaom.setBounds(635, 137, 193, 22);
		panelInf.add(DAOcoleta.txtDescricaom);

		DAOcoleta.txtPeso = new JTextField();
		DAOcoleta.txtPeso.setEditable(false);
		DAOcoleta.txtPeso.setColumns(10);
		DAOcoleta.txtPeso.setBounds(359, 137, 183, 22);
		panelInf.add(DAOcoleta.txtPeso);

		DAOcoleta.txtPcs = new JTextField();
		DAOcoleta.txtPcs.setEditable(false);
		DAOcoleta.txtPcs.setBounds(359, 170, 183, 22);
		panelInf.add(DAOcoleta.txtPcs);
		DAOcoleta.txtPcs.setColumns(10);

		DAOcoleta.txtObs = new JTextArea();
		DAOcoleta.txtObs.setEditable(false);
		DAOcoleta.txtObs.setBounds(107, 222, 721, 57);
		panelInf.add(DAOcoleta.txtObs);
		DAOcoleta.txtObs.setColumns(10);

		JLabel lblTipo = new JLabel("Cidade:");
		lblTipo.setBounds(12, 39, 56, 16);
		panelInf.add(lblTipo);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Roboto", Font.BOLD, 13));
		
		JLabel lblIdMll = new JLabel("ID M\u00FCll");
		lblIdMll.setFont(new Font("Roboto", Font.BOLD, 13));
		lblIdMll.setForeground(Color.WHITE);
		lblIdMll.setBounds(552, 173, 46, 14);
		panelInf.add(lblIdMll);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(635, 171, 193, 20);
		panelInf.add(txtID);
		
		
		txtID.setColumns(10);
		btnCancelarColeta.setBounds(259, 284, 320, 45);
		panelInf.add(btnCancelarColeta);
		btnCancelarColeta.setToolTipText("Voc\u00EA deve selecionar a coluna do Horario desejado para proseguir");
		btnCancelarColeta.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnCancelarColeta.jpg")));
		btnCancelarColeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//getDADOS();
				System.out.println("cancelar coleta");
				getCOD_mMuLL();
				txtInternalFrameData.setText(coleta.getDATACOLETA());
				txtInternalFrameDescricao.setText(coleta.getDES_TAB());
				txtIdinternalFrame.setText(coleta.getCOD_mMuLL());
				iFrame.setVisible(true);

			}
		});
		DAOmull.cbxmMuLL.setBounds	   (10, 138, 320, 24);
		DAOendereco.cbxBairro.setBounds(10, 400, 320, 24);
		DAOendereco.cbxCidade.setBounds(10, 363, 320, 24);
		DAOendereco.cbxEstado.setBounds(10, 326, 320, 24);
	
		
		JLabel frame = new JLabel("");
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/ConsultacoletasAgendadas.jpg")));
		frame.setBounds(0, 0, 1280, 670);
		contentPane.add(frame);
		DAOcoleta.tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getCOD_mMuLL();
				getDADOS();

			}
		});
		DAOendereco.cbxEstado.setSelectedItem("SELECIONE");
		DAOendereco.cbxCidade.setSelectedItem("SELECIONE");
		DAOendereco.cbxBairro.setSelectedItem("SELECIONE");
		QueryCompletaPesquisa();
		daoCOLETA.resetVAR();
		// ----------------------------------------------END----------------------------------------
	}

	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final JButton btnCancelarColeta = new JButton("");
	
	private JTextField txtInternalFrameData;
	private JTextField txtIdinternalFrame;
	private JTextField txtInternalFrameDescricao;
	private final JLabel iframe2 = new JLabel("");
	private JTextField txtID;
	
	

	// CBX -INICIO------------------------------

	public void getCOD_mMuLL( ) {
		int a= 0;
		int b= 0;
		a = DAOcoleta.tblConsulta.getSelectedRow();
		b = DAOcoleta.tblConsulta.getSelectedColumn();
		
		
		
		coleta.setDATACOLETA((String) (DAOcoleta.tblConsulta.getValueAt(a, 0)));
		coleta.setCOD_mMuLL((String) (DAOcoleta.tblConsulta.getValueAt(a, 7)));
		coleta.setDES_TAB((String) (DAOcoleta.tblConsulta.getValueAt(a, 5)));
		coleta.setStringDia((String) (DAOcoleta.tblConsulta.getValueAt(a, 2)));
		coleta.setHORARIO_JTABLE((String) (DAOcoleta.tblConsulta.getValueAt(a, 3)));
		coleta.setCOD_COLETA((String) (DAOcoleta.tblConsulta.getValueAt(a, 8)));
		disponibilidade.setStringDia(coleta.getStringDia());
		daoDISPONIBILIDADE.METODOCODDIA(disponibilidade);
		daoDISPONIBILIDADE.SELECTPROXIMADATADISPONIVEL(disponibilidade);
		daoDISPONIBILIDADE.SELECTPROXIMADATADISPONIVELFINAL(disponibilidade);
		coleta.setDATACOLETA(disponibilidade.getDATACOLETA());
		daoCOLETA.QueryCodColeta(coleta);
	}

	public void QueryCompletaPesquisa() {
		daoDISPONIBILIDADE.SelectDiasmMuLL();
		daoDISPONIBILIDADE.SelectPeriodomMuLL();
		daoDISPONIBILIDADE.SelectDiasmMuLL();
		daoENDERECO.SelectCidadeEBairro();
		daoMULL.SelectmMuLL();
		daoCOLETA.QueryColetasAgendadasEmpresa();
	}
public void CancelarColeta(){
	daoCOLETA.Cancelar_COL_AGENDADA(coleta);
	mensagem.setCOD_mMuLL(coleta.getCOD_mMuLL());
	mensagem.setCOD_USUARIO(Usuario.getCOD_USUARIO());
	mensagem.setNOM_EMPRESA(Usuario.getNOM_USUARIO()); 
	mensagem.setDES_TAB(coleta.getDES_TAB()); 
	mensagem.setDATACOLETA(coleta.getDATACOLETA()) ;
	mensagem.setStringDia(coleta.getStringDia());
	mensagem.setHORARIO_JTABLE(coleta.getHORARIO_JTABLE());
	daoCOLETA.QueryCodColeta(coleta);
	mensagem.setCOD_USUARIO_ENVIOMENSAGEM(coleta.getCOD_USUARIO_MULL());
	daoMENSAGEM.EnviarMensagemParaUsuarioCancelarColeta(mensagem);
	daoCOLETA.UpdatemMuLLcoletaAgendadaNAO(coleta);
	QueryCompletaPesquisa();
	
}

public void getDADOS(){
	
	getCOD_mMuLL();
	
	txtID.setText(coleta.getCOD_mMuLL());
	daoCOLETA.QuerymMuLLViewDetalhesEmpresa(coleta);
	DAOcoleta.txtCODmMuLL.setText(coleta.getCOD_mMuLL());
	mull.setDES_TAB(coleta.getDES_TAB());
	mull.setCOD_MULL(coleta.getCOD_mMuLL());
	daoMULL.QuerymMuLLViewDetalhesEmpresaMull(mull);
	daoMULL.outro(mull);
	DAOcoleta.txtDescricaom.setText(mull.getTxtDescrição());
	DAOcoleta.txtPeso.setText(mull.getTxtPeso());
	DAOcoleta.txtPcs.setText(mull.getTxtPeças());
	DAOcoleta.txtObs.setText(mull.getTxtobservacao());
}
	
}
