package Instituicao;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import beans.Coleta;
import beans.Disponibilidade;
import beans.Endereco;
import beans.Mensagem;
import beans.Mull;
import dao.DAOcoleta;
import dao.DAOdisponibilidade;
import dao.DAOendereco;
import dao.DAOmensagem;
import dao.DAOmull;
import login.menulogin;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextArea;

@SuppressWarnings("unused")
public class InstituicaoParceiroIniciarColetas extends JFrame {
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
	
	JInternalFrame iFrameConfirmar = new JInternalFrame("Verifica\u00E7\u00E3o");
	JButton btnIFRAMEConfirmarColeta = new JButton("Confirmar Coleta");
	JButton btnIFRAMENoColetado = new JButton("N\u00E3o Coletado");
	private JPanel contentPane;
	private JTable tblConsulta;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstituicaoParceiroIniciarColetas frame = new InstituicaoParceiroIniciarColetas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
	public InstituicaoParceiroIniciarColetas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));	
		setTitle("Institui��o - Iniciar Coletas  ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(true);
		contentPane.setBackground(Color.DARK_GRAY);
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		contentPane.add(DAOdisponibilidade.cbx1);
		iFrameConfirmar.getContentPane().setLayout(null);
		
				JPanel panel_4 = new JPanel();
				panel_4.setBounds(12, 34, 368, 22);
				iFrameConfirmar.getContentPane().add(panel_4);
				panel_4.setLayout(null);
				
						JLabel lblIdMmll = new JLabel("Id mM\u00FCLL:");
						lblIdMmll.setFont(new Font("Roboto Thin", Font.BOLD, 12));
						lblIdMmll.setBounds(0, 3, 65, 16);
						panel_4.add(lblIdMmll);
						
								txtIFRAME_ID_mMuLL = new JTextField();
								txtIFRAME_ID_mMuLL.setBounds(64, 0, 65, 22);
								panel_4.add(txtIFRAME_ID_mMuLL);
								txtIFRAME_ID_mMuLL.setEnabled(false);
								txtIFRAME_ID_mMuLL.setColumns(10);
								
										JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
										lblDescrio.setFont(new Font("Roboto Thin", Font.BOLD, 12));
										lblDescrio.setBounds(141, 3, 65, 16);
										panel_4.add(lblDescrio);
										
												txtIFRAME_DES_TAB = new JTextField();
												txtIFRAME_DES_TAB.setBounds(237, 0, 131, 22);
												panel_4.add(txtIFRAME_DES_TAB);
												txtIFRAME_DES_TAB.setEnabled(false);
												txtIFRAME_DES_TAB.setColumns(10);
												
														JPanel panel_5 = new JPanel();
														panel_5.setBounds(12, 194, 368, 22);
														iFrameConfirmar.getContentPane().add(panel_5);
														panel_5.setLayout(null);
														
																JLabel Data = new JLabel("Data:");
																Data.setFont(new Font("Roboto Thin", Font.BOLD, 12));
																Data.setBounds(0, 3, 31, 16);
																panel_5.add(Data);
																
																		txtIFRAME_HORARIO_COL = new JTextField();
																		txtIFRAME_HORARIO_COL.setBounds(271, 0, 97, 22);
																		panel_5.add(txtIFRAME_HORARIO_COL);
																		txtIFRAME_HORARIO_COL.setEnabled(false);
																		txtIFRAME_HORARIO_COL.setColumns(10);
																		
																				JLabel lblPeso = new JLabel("Hor\u00E1rio");
																				lblPeso.setFont(new Font("Roboto Thin", Font.BOLD, 12));
																				lblPeso.setBounds(201, 3, 49, 16);
																				panel_5.add(lblPeso);
																				
																						txtIFRAME_DATA_COL = new JTextField();
																						txtIFRAME_DATA_COL.setBounds(43, 0, 116, 22);
																						panel_5.add(txtIFRAME_DATA_COL);
																						txtIFRAME_DATA_COL.setEnabled(false);
																						txtIFRAME_DATA_COL.setColumns(10);
																						btnIFRAMEConfirmarColeta.setFont(new Font("Roboto Thin", Font.BOLD, 12));
																						
																								btnIFRAMEConfirmarColeta.addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent arg0) {
																										BotaoConfirmarColetaIFRAME();
																						
																									}
																								});
																								btnIFRAMEConfirmarColeta.setBounds(112, 267, 168, 25);
																								iFrameConfirmar.getContentPane().add(btnIFRAMEConfirmarColeta);
																								
																										JButton btnVoltar = new JButton("Voltar");
																										btnVoltar.setFont(new Font("Roboto Thin", Font.BOLD, 12));
																										btnVoltar.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												BotaoVoltarColetaIFRAME();
																											}
																										});
																										btnVoltar.setBounds(112, 229, 168, 25);
																										iFrameConfirmar.getContentPane().add(btnVoltar);
																										
																												JPanel panel_1 = new JPanel();
																												panel_1.setBounds(93, 69, 206, 22);
																												iFrameConfirmar.getContentPane().add(panel_1);
																												panel_1.setLayout(null);
																												
																														JLabel lblCidade = new JLabel("Cidade:");
																														lblCidade.setFont(new Font("Roboto Thin", Font.BOLD, 12));
																														lblCidade.setBounds(0, 3, 56, 16);
																														panel_1.add(lblCidade);
																														
																																txtIFRAME_CIDADE = new JTextField();
																																txtIFRAME_CIDADE.setEnabled(false);
																																txtIFRAME_CIDADE.setBounds(64, 0, 142, 22);
																																panel_1.add(txtIFRAME_CIDADE);
																																txtIFRAME_CIDADE.setColumns(10);
																																
																																		JPanel panel_3 = new JPanel();
																																		panel_3.setBounds(106, 98, 180, 22);
																																		iFrameConfirmar.getContentPane().add(panel_3);
																																		panel_3.setLayout(null);
																																		
																																				JLabel lblBairro = new JLabel("Bairro:");
																																				lblBairro.setFont(new Font("Roboto Thin", Font.BOLD, 12));
																																				lblBairro.setBounds(0, 3, 56, 16);
																																				panel_3.add(lblBairro);
																																				
																																						txtIFRAME_BAIRRO = new JTextField();
																																						txtIFRAME_BAIRRO.setEnabled(false);
																																						txtIFRAME_BAIRRO.setBounds(49, 0, 131, 22);
																																						panel_3.add(txtIFRAME_BAIRRO);
																																						txtIFRAME_BAIRRO.setColumns(10);
																																						
																																								JPanel panel_6 = new JPanel();
																																								panel_6.setBounds(53, 159, 290, 22);
																																								iFrameConfirmar.getContentPane().add(panel_6);
																																								panel_6.setLayout(null);
																																								
																																										JLabel lblEndereo = new JLabel("Endere\u00E7o:");
																																										lblEndereo.setFont(new Font("Roboto Thin", Font.BOLD, 12));
																																										lblEndereo.setBounds(0, 3, 80, 16);
																																										panel_6.add(lblEndereo);
																																										txtIFRAME_ENDERECO = new JTextField();
																																										txtIFRAME_ENDERECO.setEnabled(false);
																																										txtIFRAME_ENDERECO.setBounds(92, 0, 222, 22);
																																										panel_6.add(txtIFRAME_ENDERECO);
																																										txtIFRAME_ENDERECO.setColumns(10);
																																										
																																												btnIFRAMENoColetado.addActionListener(new ActionListener() {
																																													public void actionPerformed(ActionEvent e) {
																																														BOTAOColetanaoEfetuada();
																																													}
																																												});
																																												btnIFRAMENoColetado.setBounds(131, 267, 131, 25);
																																												iFrameConfirmar.getContentPane().add(btnIFRAMENoColetado);
																																												iFrameConfirmar.getContentPane().setBackground(Color.DARK_GRAY);
																																												iFrameConfirmar.setBounds(437, 151, 398, 336);
																																												contentPane.add(iFrameConfirmar);
																																												iFrameConfirmar.setVisible(true);
																																												
																																														
																																														
																																														
																																														iFrameConfirmar.setVisible(false);
		btnSair.setBounds(10, 597, 310, 41);
		contentPane.add(btnSair);

		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConsultar.jpg")));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				daoDISPONIBILIDADE.SelectTimeNow(disponibilidade);

				atualizacaoPag();

			}
		});
		btnConsultar.setBounds(10, 543, 308, 41);
		contentPane.add(btnConsultar);

		btnColetado.setBounds(906, 593, 320, 45);
		btnColetado.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConfirmarColeta.jpg")));
		contentPane.add(btnColetado);
		btnNaoColetado.setToolTipText("Voc\u00EA deve selecionar a coluna do Horario desejado para proseguir");
		btnNaoColetado.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnCancelarColeta.jpg")));
		btnNaoColetado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getCOD_Coleta();
				SetDadosIFRAMEconfirmarCOLETA();
				btnIFRAMEConfirmarColeta.setVisible(false);
				btnIFRAMENoColetado.setVisible(true);
				iFrameConfirmar.setVisible(true);

			}
		});
		btnNaoColetado.setBounds(399, 593, 320, 45);

		contentPane.add(btnNaoColetado);
		DAOendereco.cbxEstado.setForeground(Color.WHITE);
		DAOendereco.cbxEstado.setBackground(Color.DARK_GRAY);
		DAOendereco.cbxEstado.setFont(new Font("Roboto Light", Font.BOLD, 13));
		DAOendereco.cbxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAOendereco.carregarCIDADE();
				DAOendereco.cbxCidade.setSelectedItem("SELECIONE");
			}
		});

		
		contentPane.add(DAOendereco.cbxEstado);
		DAOendereco.cbxCidade.setForeground(Color.WHITE);
		DAOendereco.cbxCidade.setBackground(Color.DARK_GRAY);
		DAOendereco.cbxCidade.setFont(new Font("Roboto Light", Font.BOLD, 13));
		DAOendereco.cbxCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				daoENDERECO.carregarBairro();
				daoENDERECO.cbxBairro.setSelectedItem("SELECIONE");
			}
		});

		
		contentPane.add(DAOendereco.cbxCidade);
		DAOendereco.cbxBairro.setForeground(Color.WHITE);
		DAOendereco.cbxBairro.setBackground(Color.DARK_GRAY);
		DAOendereco.cbxBairro.setFont(new Font("Roboto Light", Font.BOLD, 13));
		DAOmull.cbxmMuLL.setBounds(10, 218, 320, 24);
		DAOendereco.cbxBairro.setBounds(10, 500, 294, 24);
		DAOendereco.cbxCidade.setBounds(10, 463, 294, 24);
		DAOendereco.cbxEstado.setBounds(10, 426, 294, 24);
		contentPane.add(DAOendereco.cbxBairro);

		// --------------------------------------------COLETAR-------------------------------------

		btnColetado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotaoConfirmarColeta();

			}
		});
		daoENDERECO.carregarESTADO();
		DAOendereco.cbxEstado.setSelectedItem("SELECIONE");
		DAOendereco.cbxCidade.setSelectedItem("SELECIONE");
		DAOendereco.cbxBairro.setSelectedItem("SELECIONE");
		DAOmull.cbxmMuLL.setForeground(Color.WHITE);
		DAOmull.cbxmMuLL.setBackground(Color.DARK_GRAY);
		DAOmull.cbxmMuLL.setFont(new Font("Roboto Light", Font.BOLD, 13));
		DAOmull.cbxmMuLL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizacaoPag();
			}
		});

		DAOmull.cbxmMuLL.setModel(new DefaultComboBoxModel(
				new String[] { "SELECIONE", "ROUPAS", "CAL�ADOS", "ROUPAS DE BANHO E CAMA", }));
		
		contentPane.add(DAOmull.cbxmMuLL);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 68, 827, 248);
		contentPane.add(scrollPane);
		
		
		

		

		JPanel panel = new JPanel();

		panel.setBackground(Color.DARK_GRAY);
		panel.setOpaque(true);
		panel.setBorder(BorderFactory.createEmptyBorder());
		panel.setBounds(399, 316, 835, 262);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCidade_1 = new JLabel("Cidade");
		lblCidade_1.setBounds(1, 22, 67, 16);
		panel.add(lblCidade_1);
		lblCidade_1.setFont(new Font("Roboto Light", Font.BOLD, 14));
		lblCidade_1.setForeground(Color.WHITE);

		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(1, 60, 80, 16);
		panel.add(lblEndereco);
		lblEndereco.setFont(new Font("Roboto Light", Font.BOLD, 14));
		lblEndereco.setForeground(Color.WHITE);

		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio_1.setBounds(1, 98, 80, 16);
		panel.add(lblDescrio_1);
		lblDescrio_1.setForeground(Color.WHITE);
		lblDescrio_1.setFont(new Font("Roboto Light", Font.BOLD, 14));

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(1, 136, 80, 16);
		panel.add(lblGenero);
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Roboto Light", Font.BOLD, 14));

		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setBounds(1, 174, 99, 16);
		panel.add(lblObservao);
		lblObservao.setForeground(Color.WHITE);
		lblObservao.setFont(new Font("Roboto Light", Font.BOLD, 14));

		JLabel lblBairro_1 = new JLabel("Bairro");
		lblBairro_1.setBounds(322, 22, 80, 16);
		panel.add(lblBairro_1);
		lblBairro_1.setFont(new Font("Roboto Light", Font.BOLD, 14));
		lblBairro_1.setForeground(Color.WHITE);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(573, 22, 38, 16);
		panel.add(lblCep);
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Roboto Light", Font.BOLD, 14));

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(573, 60, 99, 16);
		panel.add(lblComplemento);
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("Roboto Light", Font.BOLD, 14));

		JLabel lblFaixaEtria = new JLabel("Faixa Et\u00E1ria");
		lblFaixaEtria.setBounds(573, 98, 103, 16);
		panel.add(lblFaixaEtria);
		lblFaixaEtria.setForeground(Color.WHITE);
		lblFaixaEtria.setFont(new Font("Roboto Light", Font.BOLD, 14));

		JLabel lblPeas = new JLabel("Pe\u00E7as");
		lblPeas.setBounds(366, 98, 62, 16);
		panel.add(lblPeas);
		lblPeas.setForeground(Color.WHITE);
		lblPeas.setFont(new Font("Roboto Light", Font.BOLD, 14));

		DAOcoleta.txtCep = new JTextField();
		DAOcoleta.txtCep.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtCep.setBackground(Color.WHITE);
		DAOcoleta.txtCep.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtCep.setBounds(695, 20, 138, 22);
		panel.add(DAOcoleta.txtCep);
		DAOcoleta.txtCep.setEditable(false);
		DAOcoleta.txtCep.setColumns(10);
		DAOcoleta.txtCep.setBorder(BorderFactory.createEmptyBorder());
		DAOcoleta.txtComplemento = new JTextField();
		DAOcoleta.txtComplemento.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtComplemento.setBackground(Color.WHITE);
		DAOcoleta.txtComplemento.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtComplemento.setBounds(695, 60, 138, 22);
		panel.add(DAOcoleta.txtComplemento);
		DAOcoleta.txtComplemento.setEditable(false);
		DAOcoleta.txtComplemento.setColumns(10);
		DAOcoleta.txtComplemento.setOpaque(true);
		DAOcoleta.txtComplemento.setBorder(BorderFactory.createEmptyBorder());

		DAOcoleta.txtEndereco = new JTextField();
		DAOcoleta.txtEndereco.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtEndereco.setBackground(Color.WHITE);
		DAOcoleta.txtEndereco.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtEndereco.setBounds(92, 58, 469, 22);
		panel.add(DAOcoleta.txtEndereco);
		DAOcoleta.txtEndereco.setEditable(false);
		DAOcoleta.txtEndereco.setColumns(10);
		DAOcoleta.txtEndereco.setBorder(BorderFactory.createEmptyBorder());
		DAOcoleta.txtFaixaEtaria = new JTextField();
		DAOcoleta.txtFaixaEtaria.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtFaixaEtaria.setBackground(Color.WHITE);
		DAOcoleta.txtFaixaEtaria.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtFaixaEtaria.setBounds(695, 96, 138, 22);
		panel.add(DAOcoleta.txtFaixaEtaria);
		DAOcoleta.txtFaixaEtaria.setEditable(false);
		DAOcoleta.txtFaixaEtaria.setColumns(10);

		DAOcoleta.txtPcs = new JTextField();
		DAOcoleta.txtPcs.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtPcs.setBackground(Color.WHITE);
		DAOcoleta.txtPcs.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtPcs.setBounds(440, 96, 121, 22);
		panel.add(DAOcoleta.txtPcs);
		DAOcoleta.txtPcs.setEditable(false);
		DAOcoleta.txtPcs.setColumns(10);
		DAOcoleta.txtPcs.setBorder(BorderFactory.createEmptyBorder());
		DAOcoleta.txtGenero = new JTextField();
		DAOcoleta.txtGenero.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtGenero.setBackground(Color.WHITE);
		DAOcoleta.txtGenero.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtGenero.setBounds(92, 134, 251, 22);
		panel.add(DAOcoleta.txtGenero);
		DAOcoleta.txtGenero.setEditable(false);
		DAOcoleta.txtGenero.setColumns(10);
		DAOcoleta.txtGenero.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(92, 174, 741, 41);
		panel.add(scrollPane_1);

		JTextArea txtObs_1 = new JTextArea();
		txtObs_1.setForeground(Color.WHITE);
		scrollPane_1.setViewportView(txtObs_1);
		txtObs_1.setBackground(Color.WHITE);
		txtObs_1.setFont(new Font("Roboto Light", Font.BOLD, 11));
		txtObs_1.setEditable(false);

		DAOcoleta.txtCidade = new JTextField();
		DAOcoleta.txtCidade.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtCidade.setBackground(Color.WHITE);
		DAOcoleta.txtCidade.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtCidade.setBounds(92, 20, 207, 22);
		panel.add(DAOcoleta.txtCidade);
		DAOcoleta.txtCidade.setEditable(false);
		DAOcoleta.txtCidade.setColumns(10);
		DAOcoleta.txtCidade.setBorder(BorderFactory.createEmptyBorder());
		DAOcoleta.txtDescricao = new JTextField();
		DAOcoleta.txtDescricao.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtDescricao.setBackground(Color.WHITE);
		DAOcoleta.txtDescricao.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtDescricao.setBounds(92, 96, 251, 22);
		DAOcoleta.txtDescricao.setBorder(BorderFactory.createEmptyBorder());
		panel.add(DAOcoleta.txtDescricao);
		DAOcoleta.txtDescricao.setEditable(false);
		DAOcoleta.txtDescricao.setColumns(10);

		DAOcoleta.txtBairo = new JTextField();
		DAOcoleta.txtBairo.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtBairo.setBackground(Color.WHITE);
		DAOcoleta.txtBairo.setFont(new Font("Roboto Light", Font.BOLD, 11));
		DAOcoleta.txtBairo.setBounds(391, 20, 170, 22);
		DAOcoleta.txtBairo.setBorder(BorderFactory.createEmptyBorder());
		panel.add(DAOcoleta.txtBairo);
		DAOcoleta.txtBairo.setEditable(false);
		DAOcoleta.txtBairo.setColumns(10);

		JLabel lblSolicitaoUsuario = new JLabel("Solicita\u00E7\u00E3o Usuario");
		lblSolicitaoUsuario.setBounds(366, 136, 155, 16);
		panel.add(lblSolicitaoUsuario);
		lblSolicitaoUsuario.setForeground(Color.WHITE);
		lblSolicitaoUsuario.setFont(new Font("Roboto Light", Font.BOLD, 14));

		DAOcoleta.txtDataSolicitacao = new JTextField();
		DAOcoleta.txtDataSolicitacao.setForeground(Color.DARK_GRAY);
		DAOcoleta.txtDataSolicitacao.setBounds(533, 134, 300, 22);
		panel.add(DAOcoleta.txtDataSolicitacao);
		DAOcoleta.txtDataSolicitacao.setBackground(Color.WHITE);
		DAOcoleta.txtDataSolicitacao.setFont(new Font("Roboto Light", Font.BOLD, 12));
		DAOcoleta.txtDataSolicitacao.setEditable(false);
		DAOcoleta.txtDataSolicitacao.setColumns(10);
		DAOcoleta.txtDataSolicitacao.setBorder(BorderFactory.createEmptyBorder());
		DAOcoleta.txtObs.setBorder(BorderFactory.createEmptyBorder());
		DAOcoleta.txtFaixaEtaria.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		scrollPane.setRowHeaderView(DAOcoleta.tblConsulta);
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		JLabel frame = new JLabel("");
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/testefundo1.jpg")));
		frame.setBounds(0, 0, 1280, 700);
		contentPane.add(frame);
		
		scrollPane.setViewportView(DAOcoleta.tblConsulta);
		DAOcoleta.tblConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		DAOcoleta.tblConsulta.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		DAOcoleta.tblConsulta.setOpaque(false);
		DAOcoleta.tblConsulta.setShowGrid(false);
		DAOcoleta.tblConsulta.setShowGrid(false);
		DAOcoleta.tblConsulta.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				daoCOLETA.APAGAQuerymMuLLViewDetalhesRoupasEcalcados();
				getCOD_Coleta();
				daoCOLETA.QuerymMuLLViewDetalhesRoupasEcalcados(coleta);

			}
		});

		 atualizacaoPag();
		// ----------------------------------------------END----------------------------------------
	}

	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final JButton btnColetado = new JButton("");
	private final JButton btnNaoColetado = new JButton("");

	private JTextField txtIFRAME_ID_mMuLL;
	private JTextField txtIFRAME_HORARIO_COL;
	private JTextField txtIFRAME_DATA_COL;
	private JTextField txtIFRAME_DES_TAB;
	private JTextField txtIFRAME_CIDADE;
	private JTextField txtIFRAME_BAIRRO;
	private JTextField txtIFRAME_ENDERECO;
	

	public void getCOD_Coleta() {
		int a = 0;
		a = DAOcoleta.tblConsulta.getSelectedRow();
		DAOcoleta.tblConsulta.getSelectedColumn();
		coleta.setCOD_COLETA((String) DAOcoleta.tblConsulta.getValueAt(a, 0));
		coleta.setCOD_mMuLL((String) DAOcoleta.tblConsulta.getValueAt(a, 1));
		endereco.setDES_CIDADE((String) DAOcoleta.tblConsulta.getValueAt(a, 4));
		endereco.setDES_BAIRRO((String) DAOcoleta.tblConsulta.getValueAt(a, 5));

	}

	public void SetDadosIFRAMEconfirmarCOLETA() {
		daoDISPONIBILIDADE.SelecttimeNowString(disponibilidade);
		coleta.setHOR_COLETA(disponibilidade.getPeriodos());
		daoDISPONIBILIDADE.SelectDateNowString(disponibilidade);
		coleta.setDATACOLETA(disponibilidade.getDATACOLETA());
		endereco.setDES_CIDADE(DAOcoleta.txtCidade.getText());
		endereco.setDES_BAIRRO(DAOcoleta.txtBairo.getText());
		endereco.setDES_ENDERECO(DAOcoleta.txtEndereco.getText());
		txtIFRAME_DATA_COL.setText(coleta.getDATACOLETA());
		txtIFRAME_DES_TAB.setText(coleta.getDES_TAB());
		txtIFRAME_ID_mMuLL.setText(coleta.getCOD_mMuLL());
		txtIFRAME_HORARIO_COL.setText(coleta.getHOR_COLETA());
		txtIFRAME_CIDADE.setText(endereco.getDES_CIDADE());
		txtIFRAME_BAIRRO.setText(endereco.getDES_BAIRRO());
		txtIFRAME_ENDERECO.setText(endereco.getDES_ENDERECO());
		mensagem.setCOD_mMuLL(coleta.getCOD_mMuLL());
		mensagem.setDES_TAB(DAOcoleta.txtDescricao.getText());
		daoCOLETA.QueryCOLETAfinalizarColeta(coleta);
		mensagem.setDATACOLETA(coleta.getDATACOLETA());
		mensagem.setHORARIO_JTABLE(coleta.getHOR_COLETA());
		mensagem.setCOD_USUARIO_ENVIOMENSAGEM(coleta.getCOD_USUARIO_MULL());
	}
	// FUNCAO COLETA EFETUADA --- INICIO

	public void BotaoConfirmarColeta() {
		getCOD_Coleta();

		SetDadosIFRAMEconfirmarCOLETA();
		iFrameConfirmar.setVisible(true);
		btnIFRAMENoColetado.setVisible(false);
		btnIFRAMEConfirmarColeta.setVisible(true);

	}

	public void BotaoConfirmarColetaIFRAME() {

		daoCOLETA.UpdateCOLETA_COLETADA(coleta);
		daoCOLETA.UpdatemMullCOLETADA(coleta);
		daoMENSAGEM.EnviarMensagemUsuario(mensagem);
		iFrameConfirmar.setVisible(false);
		JOptionPane.showMessageDialog(null, "Coleta Efetuada.");
		atualizacaoPag();
	}
	// FUNCAO COLETA EFETUADA FIM------------------------------------

	// FUNCAO COLETA NAO EFETUADA INICIO ----------------------

	public void BOTAOColetanaoEfetuada() {

		daoCOLETA.UpdateCOLETA_NAO_COLETADA(coleta);
		daoCOLETA.UpdatemMuLL_NAO_COLETADA(coleta);
		daoMENSAGEM.EnviarMensagemUsuarioCOLETANAOEFETUADA(mensagem);
		BotaoVoltarColetaIFRAME();
		atualizacaoPag();
	}

	public void BotaoVoltarColetaIFRAME() {
		txtIFRAME_DATA_COL.setText("");
		txtIFRAME_DES_TAB.setText("");
		txtIFRAME_ID_mMuLL.setText("");
		txtIFRAME_HORARIO_COL.setText("");
		txtIFRAME_CIDADE.setText("");
		txtIFRAME_BAIRRO.setText("");
		txtIFRAME_ENDERECO.setText("");
		iFrameConfirmar.setVisible(false);

		atualizacaoPag();

	}

	public void atualizacaoPag() {
		daoENDERECO.SelectCidadeEBairro();
		daoMULL.SelectmMuLL();
		daoCOLETA.IniciarColetasQuerymMuLL();
	}
}
