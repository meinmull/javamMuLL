package Instituicao;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InstituicaoProcurarColetas extends JFrame {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstituicaoProcurarColetas frame = new InstituicaoProcurarColetas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InstituicaoProcurarColetas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setTitle("Instituição - Procurar Novas Coletas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 670);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(true);
		contentPane.setBackground(Color.DARK_GRAY);
		JButton btnConsultar = new JButton("");
		btnConsultar.setBounds(20, 586, 309, 45);
		contentPane.add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConsultar.jpg")));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QueryCompleta();
				InformacoesParaColetaLimpar();

			}
		});

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(358, 576, 884, 55);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(513, 11, 304, 42);
		panel_5.add(btnSair);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		btnColetar.setBounds(104, 11, 304, 42);
		panel_5.add(btnColetar);
		btnColetar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnColetar.jpg")));

		// --------------------------------------------COLETAR-------------------------------------

		btnColetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtHorarioColeta.getText().equalsIgnoreCase("08:00 - 12:00")||txtHorarioColeta.getText().equalsIgnoreCase("12:00 - 13:30")
						||txtHorarioColeta.getText().equalsIgnoreCase("13:30 - 18:30")||txtHorarioColeta.getText().equalsIgnoreCase("18:30 - 22:00")){
				getCOD_mMuLL();

				daoCOLETA.AGENDARCOLETA(coleta);
				daoCOLETA.INFORMACOESCOLETA(coleta);
				daoCOLETA.UPDATEMMULL_COL_AGENDADA(coleta);
				mull.setCOD_MULL(coleta.getCOD_mMuLL());
				daoMULL.BuscaDadosmMuLL(mull);

				converteDADOS();
				daoMENSAGEM.EnviarMensagemParaUsuario(mensagem);
				QueryCompleta();
				InformacoesParaColetaLimpar();

			}
				else{JOptionPane.setRootFrame(null);
				JOptionPane.showMessageDialog(null, "Você deve selecionar um horário, Clique em um Horário, na linha da coleta desejada e defina o Horário no botão.  ");;}

		}}
		);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(10, 376, 328, 255);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(23, -15, 134, 221);
		panel_2.add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		panel.add(DAOdisponibilidade.ckSeg);
		panel.add(DAOdisponibilidade.ckTer);
		panel.add(DAOdisponibilidade.ckQua);
		panel.add(DAOdisponibilidade.ckQui);
		panel.add(DAOdisponibilidade.ckSex);
		panel.add(DAOdisponibilidade.ckSab);
		panel.add(DAOdisponibilidade.ckTod);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(180, 0, 138, 206);
		panel_2.add(panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		panel_1.add(DAOdisponibilidade.ckMat);
		panel_1.add(DAOdisponibilidade.ckAlm);
		panel_1.add(DAOdisponibilidade.ckVes);
		panel_1.add(DAOdisponibilidade.ckNot);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 40, 849, 306);
		contentPane.add(scrollPane);
		contentPane.add(DAOdisponibilidade.cbx1);

		DAOcoleta.tblConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		DAOcoleta.tblConsulta.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		DAOcoleta.tblConsulta.setOpaque(false);
		DAOcoleta.tblConsulta.setShowGrid(false);

		scrollPane.setViewportView(DAOcoleta.tblConsulta);
		buttonGroup_1.add(DAOdisponibilidade.ckSeg);
		DAOdisponibilidade.ckSeg.setForeground(Color.WHITE);
		DAOdisponibilidade.ckSeg.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckSeg.setBounds(0, 50, 75, 25);
		DAOdisponibilidade.ckSeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		buttonGroup_1.add(DAOdisponibilidade.ckTer);
		DAOdisponibilidade.ckTer.setForeground(Color.WHITE);
		DAOdisponibilidade.ckTer.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckTer.setBounds(0, 78, 59, 25);
		DAOdisponibilidade.ckTer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		buttonGroup_1.add(DAOdisponibilidade.ckQua);
		DAOdisponibilidade.ckQua.setForeground(Color.WHITE);
		DAOdisponibilidade.ckQua.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckQua.setBounds(0, 106, 65, 25);
		buttonGroup_1.add(DAOdisponibilidade.ckQui);
		DAOdisponibilidade.ckQui.setForeground(Color.WHITE);
		DAOdisponibilidade.ckQui.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckQui.setBounds(0, 134, 63, 25);
		buttonGroup_1.add(DAOdisponibilidade.ckSex);
		DAOdisponibilidade.ckSex.setForeground(Color.WHITE);
		DAOdisponibilidade.ckSex.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckSex.setBounds(0, 162, 75, 25);
		buttonGroup_1.add(DAOdisponibilidade.ckSab);
		DAOdisponibilidade.ckSab.setForeground(Color.WHITE);
		DAOdisponibilidade.ckSab.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckSab.setBounds(0, 190, 69, 25);

		buttonGroup_1.add(DAOdisponibilidade.ckTod);
		DAOdisponibilidade.ckTod.setForeground(Color.WHITE);
		DAOdisponibilidade.ckTod.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckTod.setBounds(0, 22, 111, 25);
		DAOdisponibilidade.ckMat.setForeground(Color.WHITE);
		DAOdisponibilidade.ckMat.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckMat.setBounds(0, 49, 75, 25);
		DAOdisponibilidade.ckAlm.setForeground(Color.WHITE);
		DAOdisponibilidade.ckAlm.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckAlm.setBounds(0, 79, 75, 25);
		DAOdisponibilidade.ckVes.setForeground(Color.WHITE);
		DAOdisponibilidade.ckVes.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckVes.setBounds(0, 109, 87, 25);
		DAOdisponibilidade.ckNot.setForeground(Color.WHITE);
		DAOdisponibilidade.ckNot.setBackground(Color.DARK_GRAY);
		DAOdisponibilidade.ckNot.setBounds(0, 139, 71, 25);
		DAOendereco.cbxEstado.setForeground(Color.WHITE);
		DAOendereco.cbxEstado.setBackground(Color.DARK_GRAY);
		DAOendereco.cbxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAOendereco.carregarCIDADE();
				DAOendereco.cbxCidade.setSelectedItem("SELECIONE");
			}
		});

		DAOendereco.cbxEstado.setBounds(25, 253, 298, 20);
		contentPane.add(DAOendereco.cbxEstado);
		DAOendereco.cbxCidade.setForeground(Color.WHITE);
		DAOendereco.cbxCidade.setBackground(Color.DARK_GRAY);
		DAOendereco.cbxCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAOendereco.carregarBairro();
				DAOendereco.cbxBairro.setSelectedItem("SELECIONE");
			}
		});

		DAOendereco.cbxCidade.setBounds(25, 284, 298, 20);
		contentPane.add(DAOendereco.cbxCidade);
		DAOendereco.cbxBairro.setForeground(Color.WHITE);
		DAOendereco.cbxBairro.setBackground(Color.DARK_GRAY);

		DAOendereco.cbxBairro.setBounds(25, 316, 298, 20);
		contentPane.add(DAOendereco.cbxBairro);
		DAOdisponibilidade.ckMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		DAOendereco.carregarESTADO();
		DAOendereco.cbxEstado.setSelectedItem("SELECIONE");
		DAOendereco.cbxCidade.setSelectedItem("SELECIONE");
		DAOendereco.cbxBairro.setSelectedItem("SELECIONE");
		DAOmull.cbxmMuLL.setForeground(Color.WHITE);
		DAOmull.cbxmMuLL.setBackground(Color.DARK_GRAY);

		DAOmull.cbxmMuLL.setModel(new DefaultComboBoxModel(
				new String[] { "SELECIONE", "ROUPAS", "CALÇADOS", "ROUPAS DE BANHO E CAMA", }));
		DAOmull.cbxmMuLL.setBounds(25, 147, 298, 20);
		contentPane.add(DAOmull.cbxmMuLL);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(388, 348, 849, 226);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		DAOcoleta.txtComplemento = new JTextField();
		DAOcoleta.txtComplemento.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtComplemento.setEditable(false);
		DAOcoleta.txtComplemento.setBounds(645, 52, 204, 20);
		panel_3.add(DAOcoleta.txtComplemento);
		DAOcoleta.txtComplemento.setColumns(10);

		DAOcoleta.txtCep = new JTextField();
		DAOcoleta.txtCep.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtCep.setEditable(false);
		DAOcoleta.txtCep.setBounds(699, 21, 150, 20);
		panel_3.add(DAOcoleta.txtCep);
		DAOcoleta.txtCep.setColumns(10);

		DAOcoleta.txtEndereco = new JTextField();
		DAOcoleta.txtEndereco.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtEndereco.setEditable(false);
		DAOcoleta.txtEndereco.setBounds(123, 52, 409, 20);
		panel_3.add(DAOcoleta.txtEndereco);
		DAOcoleta.txtEndereco.setColumns(10);

		DAOcoleta.txtBairo = new JTextField();
		DAOcoleta.txtBairo.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtBairo.setEditable(false);
		DAOcoleta.txtBairo.setBounds(350, 21, 283, 20);
		panel_3.add(DAOcoleta.txtBairo);
		DAOcoleta.txtBairo.setColumns(10);

		DAOcoleta.txtCidade = new JTextField();
		DAOcoleta.txtCidade.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtCidade.setEditable(false);
		DAOcoleta.txtCidade.setBounds(123, 21, 150, 20);
		panel_3.add(DAOcoleta.txtCidade);
		DAOcoleta.txtCidade.setColumns(10);

		DAOcoleta.txtDescricao = new JTextField();
		DAOcoleta.txtDescricao.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtDescricao.setEditable(false);
		DAOcoleta.txtDescricao.setBounds(123, 114, 150, 20);
		panel_3.add(DAOcoleta.txtDescricao);
		DAOcoleta.txtDescricao.setColumns(10);

		DAOcoleta.txtDataSolicitacao = new JTextField();
		DAOcoleta.txtDataSolicitacao.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtDataSolicitacao.setEditable(false);
		DAOcoleta.txtDataSolicitacao.setBounds(123, 83, 150, 20);
		panel_3.add(DAOcoleta.txtDataSolicitacao);
		DAOcoleta.txtDataSolicitacao.setColumns(10);

		DAOcoleta.txtGenero = new JTextField();
		DAOcoleta.txtGenero.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtGenero.setEditable(false);
		DAOcoleta.txtGenero.setBounds(350, 83, 182, 20);
		panel_3.add(DAOcoleta.txtGenero);
		DAOcoleta.txtGenero.setColumns(10);

		DAOcoleta.txtFaixaEtaria = new JTextField();
		DAOcoleta.txtFaixaEtaria.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtFaixaEtaria.setEditable(false);
		DAOcoleta.txtFaixaEtaria.setBounds(645, 86, 204, 20);
		panel_3.add(DAOcoleta.txtFaixaEtaria);
		DAOcoleta.txtFaixaEtaria.setColumns(10);

		DAOcoleta.txtPcs = new JTextField();
		DAOcoleta.txtPcs.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtPcs.setEditable(false);
		DAOcoleta.txtPcs.setBounds(350, 114, 55, 20);
		panel_3.add(DAOcoleta.txtPcs);
		DAOcoleta.txtPcs.setColumns(10);

		DAOcoleta.txtCODmMuLL = new JTextField();
		DAOcoleta.txtCODmMuLL.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtCODmMuLL.setEditable(false);
		DAOcoleta.txtCODmMuLL.setBounds(471, 114, 61, 20);
		panel_3.add(DAOcoleta.txtCODmMuLL);
		DAOcoleta.txtCODmMuLL.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblCidade.setBounds(21, 24, 46, 14);
		panel_3.add(lblCidade);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblBairro.setBounds(294, 24, 46, 14);
		panel_3.add(lblBairro);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblEndereo.setBounds(21, 58, 81, 14);
		panel_3.add(lblEndereo);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblCep.setBounds(645, 24, 46, 14);
		panel_3.add(lblCep);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblComplemento.setBounds(543, 55, 104, 14);
		panel_3.add(lblComplemento);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblDescrio.setBounds(21, 117, 92, 14);
		panel_3.add(lblDescrio);

		JLabel lblSolicitaoUsurio = new JLabel("Solicita\u00E7\u00E3o ");
		lblSolicitaoUsurio.setForeground(Color.WHITE);
		lblSolicitaoUsurio.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblSolicitaoUsurio.setBounds(21, 89, 109, 14);
		panel_3.add(lblSolicitaoUsurio);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblGnero.setBounds(294, 86, 65, 14);
		panel_3.add(lblGnero);

		JLabel lblNewLabel = new JLabel("Faixa et\u00E1ria");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblNewLabel.setBounds(543, 89, 81, 14);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(123, 143, 408, 56);
		panel_3.add(scrollPane_1);

		DAOcoleta.txtObs = new JTextArea();
		scrollPane_1.setViewportView(DAOcoleta.txtObs);
		DAOcoleta.txtObs.setFont(new Font("Roboto", Font.PLAIN, 12));
		DAOcoleta.txtObs.setEditable(false);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setForeground(Color.WHITE);
		lblObservaes.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblObservaes.setBounds(21, 159, 138, 14);
		panel_3.add(lblObservaes);

		JLabel lblIdMll = new JLabel("ID M\u00FCll");
		lblIdMll.setForeground(Color.WHITE);
		lblIdMll.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblIdMll.setBounds(413, 117, 61, 14);
		panel_3.add(lblIdMll);

		JLabel lblPeas = new JLabel("Pe\u00E7as");
		lblPeas.setForeground(Color.WHITE);
		lblPeas.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblPeas.setBounds(294, 117, 46, 14);
		panel_3.add(lblPeas);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(543, 113, 306, 111);
		panel_3.add(panel_4);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setLayout(null);
		txtIdmMuLL = new JTextField();
		txtIdmMuLL.setBounds(58, 2, 59, 22);
		panel_4.add(txtIdmMuLL);
		txtIdmMuLL.setEnabled(false);
		txtIdmMuLL.setColumns(10);
		txtDiaColeta = new JTextField();
		txtDiaColeta.setBounds(175, 2, 130, 22);
		panel_4.add(txtDiaColeta);
		txtDiaColeta.setEnabled(false);
		txtDiaColeta.setColumns(10);
		txtHorarioColeta = new JTextField();
		txtHorarioColeta.setBounds(66, 73, 249, 22);
		panel_4.add(txtHorarioColeta);
		txtHorarioColeta.setEnabled(false);
		txtHorarioColeta.setColumns(10);
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(0, 29, 304, 42);
		panel_4.add(btnSelecionar);
		btnSelecionar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnDefinirHorario.jpg")));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getCOD_mMuLL();
				txtIdmMuLL.setText(coleta.getCOD_mMuLL());
				daoCOLETA.QuerymMuLLViewDetalhesRoupasEcalcados(coleta);
				DAOcoleta.txtCODmMuLL.setText(coleta.getCOD_mMuLL());
				txtDiaColeta.setText(coleta.getStringDia());
				InformacoesParaColeta();
			}
		});
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 9));

		JLabel lblIdMll_1 = new JLabel("ID M\u00FCll");
		lblIdMll_1.setForeground(Color.WHITE);
		lblIdMll_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblIdMll_1.setBounds(0, 6, 46, 14);
		panel_4.add(lblIdMll_1);

		JLabel lblDia = new JLabel("Dia");
		lblDia.setForeground(Color.WHITE);
		lblDia.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblDia.setBounds(123, 6, 46, 14);
		panel_4.add(lblDia);

		JLabel lblHorrio = new JLabel("Hor\u00E1rio");
		lblHorrio.setForeground(Color.WHITE);
		lblHorrio.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblHorrio.setBounds(0, 77, 68, 14);
		panel_4.add(lblHorrio);
		JLabel frame2 = new JLabel("");
		frame2.setBounds(0, 0, 1280, 670);
		contentPane.add(frame2);
		frame2.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/testePaginaConsultaTodos.jpg")));
		JLabel lblSelecionarDataE = new JLabel("Selecionar Data e Periodo");
		lblSelecionarDataE.setBounds(25, 161, 167, 16);
		contentPane.add(lblSelecionarDataE);
		lblSelecionarDataE.setForeground(Color.WHITE);
		lblSelecionarDataE.setFont(new Font("Tahoma", Font.BOLD, 13));
		daoMULL.SelectTotalmMullDisponivelparaColeta(mull);
		DAOcoleta.tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getCOD_mMuLL();
				txtIdmMuLL.setText(coleta.getCOD_mMuLL());
				daoCOLETA.QuerymMuLLViewDetalhesRoupasEcalcados(coleta);
				DAOcoleta.txtCODmMuLL.setText(coleta.getCOD_mMuLL());
				txtDiaColeta.setText(coleta.getStringDia());

			}
		});

		QueryCompleta();
		// ----------------------------------------------END----------------------------------------
	}

	public JTextField txtHorarioColeta;
	public JTextField txtDiaColeta;
	public JTextField txtIdmMuLL;

	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	@SuppressWarnings("unused")
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final JButton btnColetar = new JButton("Coletar");

	private JPanel panel_3;

	// CBX -INICIO------------------------------

	// CBX - FIM ---------------------------

	public void getCOD_mMuLL() {
		int a = 0;
		int b = 0;
		a = DAOcoleta.tblConsulta.getSelectedRow();
		b = DAOcoleta.tblConsulta.getSelectedColumn();

		coleta.setCOD_mMuLL((String) DAOcoleta.tblConsulta.getValueAt(a, 0));
		coleta.setDES_TAB((String) DAOcoleta.tblConsulta.getValueAt(a, 1));
		coleta.setStringDia((String) DAOcoleta.tblConsulta.getValueAt(a, 3));
		coleta.setHORARIO_JTABLE((String) DAOcoleta.tblConsulta.getValueAt(a, b));
		disponibilidade.setStringDia(coleta.getStringDia());
		daoDISPONIBILIDADE.METODOCODDIA(disponibilidade);
		daoDISPONIBILIDADE.SELECTPROXIMADATADISPONIVEL(disponibilidade);
		daoDISPONIBILIDADE.SELECTPROXIMADATADISPONIVELFINAL(disponibilidade);
		coleta.setDATACOLETA(disponibilidade.getDATACOLETA());
	}

	public void InformacoesParaColeta() {
		txtHorarioColeta.setText(coleta.getHORARIO_JTABLE());
		txtIdmMuLL.setText(coleta.getCOD_mMuLL());
		txtDiaColeta.setText(coleta.getStringDia());

	}

	public void InformacoesParaColetaLimpar() {
		txtHorarioColeta.setText("");
		txtIdmMuLL.setText("");
		txtDiaColeta.setText("");
	}

	public void QueryCompleta() {

		daoDISPONIBILIDADE.SelectDiasmMuLL();
		daoDISPONIBILIDADE.SelectPeriodomMuLL();
		daoDISPONIBILIDADE.SelectDiasmMuLL();
		daoENDERECO.SelectCidadeEBairro();
		daoMULL.SelectmMuLL();
		daoCOLETA.QuerymMuLLROUPASeCalcados();

	}

	public void converteDADOS() {

		mensagem.setNOM_EMPRESA(Usuario.getNOM_USUARIO());
		mensagem.setCOD_mMuLL(coleta.getCOD_mMuLL());
		mensagem.setDES_TAB(coleta.getDES_TAB());
		mensagem.setDATACOLETA(coleta.getDATACOLETA());
		mensagem.setHORARIO_JTABLE(coleta.getHORARIO_JTABLE());
		mensagem.setCOD_USUARIO_ENVIOMENSAGEM(mull.getCOD_USUARIO());

	}
}
