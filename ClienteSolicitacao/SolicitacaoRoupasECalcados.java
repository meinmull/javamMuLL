package ClienteSolicitacao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import beansCliente.cDisponibilidade;
import beansCliente.cMull;
import daoCliente.cDAOdisponibilidade;
import daoCliente.cDAOmull;
import login.menulogin;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class SolicitacaoRoupasECalcados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	cDAOmull CdaoMULL = new cDAOmull();
	cDAOdisponibilidade CdaoDISPONIBILIDADE = new cDAOdisponibilidade();
	cDisponibilidade cDISPONIBILIDADE = new cDisponibilidade();
	cMull Cmull = new cMull();

	JLabel lblPesoAproximado = new JLabel();
	private JPanel contentPane;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField txtPecas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitacaoRoupasECalcados frame = new SolicitacaoRoupasECalcados();
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
	public SolicitacaoRoupasECalcados() {
		
		setTitle("Solicitar Coleta -Seletiva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1280, 670);

		setResizable(false);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});

		panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setBounds(0, 42, 912, 233);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		JLabel Tipo = new JLabel("Tipo");
		Tipo.setBounds(27, 40, 33, 16);
		panel_6.add(Tipo);
		Tipo.setFont(new Font("Roboto", Font.PLAIN, 15));
		Tipo.setForeground(Color.WHITE);
		Tipo.setBackground(Color.DARK_GRAY);
		CdaoMULL.cbxDescricao.setBounds(151, 40, 191, 22);
		panel_6.add(CdaoMULL.cbxDescricao);
		CdaoMULL.cbxDescricao.setForeground(Color.WHITE);
		CdaoMULL.cbxDescricao.setBackground(Color.DARK_GRAY);
		CdaoMULL.cbxDescricao.setFont(new Font("Roboto", Font.PLAIN, 15));
		CdaoMULL.cbxDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoMULL.QUERYGeneroCOMBOBOX();
				CdaoMULL.QUERYfaixaEtariaCOMBOBOX();

			}
		});

		CdaoMULL.cbxDescricao.setModel(new DefaultComboBoxModel(new String[] { "", "Roupas", "Calcados", "Roupas de Cama/Mesa/Banho" }));
		lblPesoAproximado.setBounds(27, 83, 115, 14);
		panel_6.add(lblPesoAproximado);
		lblPesoAproximado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPesoAproximado.setForeground(Color.WHITE);
		lblPesoAproximado.setBackground(Color.DARK_GRAY);
		CdaoMULL.cbxPeso.setBounds(151, 83,  191, 22);
		panel_6.add(CdaoMULL.cbxPeso);
		CdaoMULL.cbxPeso.setForeground(Color.WHITE);
		CdaoMULL.cbxPeso.setBackground(Color.DARK_GRAY);
		CdaoMULL.cbxPeso.setModel(new DefaultComboBoxModel(new String[] { "",}));

		CdaoMULL.txtObs = new JTextArea();
		CdaoMULL.txtObs.setBounds(482, 40, 405, 176);
		panel_6.add(CdaoMULL.txtObs);
		CdaoMULL.txtObs.setColumns(10);

		JLabel lblPeas = new JLabel("Pe\u00E7as");
		lblPeas.setBounds(27, 132, 59, 14);
		panel_6.add(lblPeas);
		lblPeas.setForeground(Color.WHITE);
		lblPeas.setFont(new Font("Roboto", Font.PLAIN, 15));

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(365, 40, 94, 16);
		panel_6.add(lblObservaes);
		lblObservaes.setForeground(Color.WHITE);
		lblObservaes.setFont(new Font("Tahoma", Font.BOLD, 14));

		CdaoMULL.txtPecas = new JTextField();
		CdaoMULL.txtPecas.setBounds(151, 132,  191, 22);
		panel_6.add(CdaoMULL.txtPecas);
		
		 CdaoMULL.cbxFaixaEtaria = new JComboBox();
		 CdaoMULL.cbxFaixaEtaria.setForeground(Color.WHITE);
		 CdaoMULL.cbxFaixaEtaria.setFont(new Font("Roboto", Font.PLAIN, 15));
		 CdaoMULL.cbxFaixaEtaria.setBackground(Color.DARK_GRAY);
		 CdaoMULL.cbxFaixaEtaria.setBounds(151, 169,  191, 22);
		panel_6.add(CdaoMULL.cbxFaixaEtaria);
		
		JLabel lblFaixaEtria = new JLabel("Faixa Et\u00E1ria");
		lblFaixaEtria.setForeground(Color.WHITE);
		lblFaixaEtria.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblFaixaEtria.setBounds(27, 173, 191, 22);
		panel_6.add(lblFaixaEtria);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblGnero.setBounds(27, 211, 191, 22);
		panel_6.add(lblGnero);
		
		CdaoMULL.cbxGenero = new JComboBox();
		CdaoMULL.cbxGenero.setFont(new Font("Roboto", Font.PLAIN, 15));
		CdaoMULL.cbxGenero.setForeground(Color.WHITE);
		CdaoMULL.cbxGenero.setBackground(Color.DARK_GRAY);
		CdaoMULL.cbxGenero.setBounds(151, 206,  191, 22);
		panel_6.add(CdaoMULL.cbxGenero);
		
		JLabel lblPeso = new JLabel("Peso ");
		lblPeso.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setBounds(27, 95, 56, 16);
		panel_6.add(lblPeso);
		CdaoMULL.txtPecas.setColumns(10);
		CdaoMULL.cbxPeso.setVisible(false);
		CdaoMULL.cbxPeso.setVisible(true);
		lblPesoAproximado.setVisible(false);

		lblPesoAproximado.setVisible(true);
		
		btnVoltar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		contentPane.add(btnVoltar);

		JButton btnConcluir = new JButton("");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoDISPONIBILIDADE.horarioColetaSegunda(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaTerca(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaQuarta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaQuinta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaSexta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaSabado(cDISPONIBILIDADE);
				CdaoMULL.CODVERIFICADORPARAINSERT(Cmull);
				CdaoMULL.InsertNEWROUPASCALCADOS(Cmull);
				CdaoMULL.QUERYNEWROUPASCALCADOS(Cmull);
				
				CdaoMULL.InsertROUPASCALCADOS_TO_mMuLL(Cmull);;
				CdaoMULL.QUERY_COD_mMuLLRC(Cmull);
				cDISPONIBILIDADE.setCOD_MULL(Cmull.getCOD_MULL());
				
				CdaoDISPONIBILIDADE.InsertHorarioColetaSegunda(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.InsertHorarioColetaTerca(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.InsertHorarioColetaQuarta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.InsertHorarioColetaQuinta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.InsertHorarioColetaSexta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.InsertHorarioColetaSabado(cDISPONIBILIDADE);
				
				JOptionPane.showMessageDialog(null, "Solicitação efetuada com Sucesso.");
				dispose();
			}
		});
		btnConcluir.setBounds(954, 538, 320, 45);
		contentPane.add(btnConcluir);
		btnConcluir.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConfirmarSolicitacao.jpg")));
		

		panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(0, 324, 912, 353);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblDiasDaSemana = new JLabel("Dias da Semana");
		lblDiasDaSemana.setBounds(41, 26, 111, 16);
		panel_5.add(lblDiasDaSemana);
		lblDiasDaSemana.setForeground(Color.WHITE);
		lblDiasDaSemana.setFont(new Font("Tahoma", Font.BOLD, 13));

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(31, 66, 145, 260);
		panel_5.add(panel_4);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setLayout(null);
		CdaoDISPONIBILIDADE.chckSeg.setBounds(26, 19, 133, 25);
		panel_4.add(CdaoDISPONIBILIDADE.chckSeg);
		CdaoDISPONIBILIDADE.chckSeg.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckSeg.setFont(new Font("Tahoma", Font.BOLD, 13));
		CdaoDISPONIBILIDADE.chckSeg.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckTer.setBounds(26, 58, 111, 25);
		panel_4.add(CdaoDISPONIBILIDADE.chckTer);
		CdaoDISPONIBILIDADE.chckTer.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckTer.setFont(new Font("Tahoma", Font.BOLD, 13));
		CdaoDISPONIBILIDADE.chckTer.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckQua.setBounds(26, 97, 111, 25);
		panel_4.add(CdaoDISPONIBILIDADE.chckQua);
		CdaoDISPONIBILIDADE.chckQua.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckQua.setFont(new Font("Tahoma", Font.BOLD, 13));
		CdaoDISPONIBILIDADE.chckQua.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckQui.setBounds(26, 136, 111, 25);
		panel_4.add(CdaoDISPONIBILIDADE.chckQui);
		CdaoDISPONIBILIDADE.chckQui.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckQui.setFont(new Font("Tahoma", Font.BOLD, 13));
		CdaoDISPONIBILIDADE.chckQui.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckSex.setBounds(26, 175, 111, 25);
		panel_4.add(CdaoDISPONIBILIDADE.chckSex);
		CdaoDISPONIBILIDADE.chckSex.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckSex.setFont(new Font("Tahoma", Font.BOLD, 13));
		CdaoDISPONIBILIDADE.chckSex.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckSab.setBounds(26, 210, 111, 25);
		panel_4.add(CdaoDISPONIBILIDADE.chckSab);
		CdaoDISPONIBILIDADE.chckSab.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckSab.setFont(new Font("Tahoma", Font.BOLD, 13));
		CdaoDISPONIBILIDADE.chckSab.setForeground(Color.WHITE);

		JLabel lblPeriodoMatutino = new JLabel("Periodo Matutino");
		lblPeriodoMatutino.setBounds(229, 26, 111, 16);
		panel_5.add(lblPeriodoMatutino);
		lblPeriodoMatutino.setForeground(Color.WHITE);
		lblPeriodoMatutino.setFont(new Font("Tahoma", Font.BOLD, 13));
		CdaoDISPONIBILIDADE.SEGMI = new JTextField();
		CdaoDISPONIBILIDADE.TERMI = new JTextField();
		CdaoDISPONIBILIDADE.QUAMI = new JTextField();
		CdaoDISPONIBILIDADE.QUIMI = new JTextField();
		CdaoDISPONIBILIDADE.SEXMI = new JTextField();
		CdaoDISPONIBILIDADE.SABMI = new JTextField();
		CdaoDISPONIBILIDADE.SEXAI = new JTextField();
		CdaoDISPONIBILIDADE.QUIAF = new JTextField();
		CdaoDISPONIBILIDADE.QUIAI = new JTextField();
		CdaoDISPONIBILIDADE.QUAAF = new JTextField();
		CdaoDISPONIBILIDADE.QUAAI = new JTextField();
		CdaoDISPONIBILIDADE.TERAF = new JTextField();
		CdaoDISPONIBILIDADE.TERAI = new JTextField();
		CdaoDISPONIBILIDADE.SEGAF = new JTextField();
		CdaoDISPONIBILIDADE.SEGAI = new JTextField();
		CdaoDISPONIBILIDADE.SABMF = new JTextField();
		CdaoDISPONIBILIDADE.SEXMF = new JTextField();
		CdaoDISPONIBILIDADE.QUIMF = new JTextField();
		CdaoDISPONIBILIDADE.QUAMF = new JTextField();
		CdaoDISPONIBILIDADE.TERMF = new JTextField();
		CdaoDISPONIBILIDADE.SEGMF = new JTextField();
		CdaoDISPONIBILIDADE.SABNI = new JTextField();
		CdaoDISPONIBILIDADE.SABNF = new JTextField();
		CdaoDISPONIBILIDADE.SEXNF = new JTextField();
		CdaoDISPONIBILIDADE.SEXNI = new JTextField();
		CdaoDISPONIBILIDADE.QUINF = new JTextField();
		CdaoDISPONIBILIDADE.QUINI = new JTextField();
		CdaoDISPONIBILIDADE.QUANF = new JTextField();
		CdaoDISPONIBILIDADE.QUANI = new JTextField();
		CdaoDISPONIBILIDADE.TERNF = new JTextField();
		CdaoDISPONIBILIDADE.TERNI = new JTextField();
		CdaoDISPONIBILIDADE.SEGNF = new JTextField();
		CdaoDISPONIBILIDADE.SEGNI = new JTextField();
		CdaoDISPONIBILIDADE.SABVF = new JTextField();
		CdaoDISPONIBILIDADE.SABVI = new JTextField();
		CdaoDISPONIBILIDADE.SEXVF = new JTextField();
		CdaoDISPONIBILIDADE.SEXVI = new JTextField();
		CdaoDISPONIBILIDADE.QUIVF = new JTextField();
		CdaoDISPONIBILIDADE.QUIVI = new JTextField();
		CdaoDISPONIBILIDADE.QUAVF = new JTextField();
		CdaoDISPONIBILIDADE.QUAVI = new JTextField();
		CdaoDISPONIBILIDADE.TERVF = new JTextField();
		CdaoDISPONIBILIDADE.TERVI = new JTextField();
		CdaoDISPONIBILIDADE.SEGVF = new JTextField();
		CdaoDISPONIBILIDADE.SEGVI = new JTextField();
		CdaoDISPONIBILIDADE.SABAF = new JTextField();
		CdaoDISPONIBILIDADE.SABAI = new JTextField();
		CdaoDISPONIBILIDADE.SEXAF = new JTextField();

		JPanel panel = new JPanel();
		panel.setBounds(207, 68, 145, 257);
		panel_5.add(panel);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);

		CdaoDISPONIBILIDADE.SEGMI.setBounds(12, 17, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.SEGMI);
		CdaoDISPONIBILIDADE.SEGMI.setColumns(10);

		CdaoDISPONIBILIDADE.SEGMF.setBounds(63, 17, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.SEGMF);
		CdaoDISPONIBILIDADE.SEGMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKSEGMAT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEGMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();

			}
		});

		CdaoDISPONIBILIDADE.CKSEGMAT.setBounds(116, 16, 21, 25);
		panel.add(CdaoDISPONIBILIDADE.CKSEGMAT);

		CdaoDISPONIBILIDADE.TERMI.setBounds(12, 56, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.TERMI);
		CdaoDISPONIBILIDADE.TERMI.setColumns(10);

		CdaoDISPONIBILIDADE.TERMF.setBounds(63, 56, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.TERMF);
		CdaoDISPONIBILIDADE.TERMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKTERMAT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKTERMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();

			}
		});

		CdaoDISPONIBILIDADE.CKTERMAT.setBounds(116, 55, 21, 25);
		panel.add(CdaoDISPONIBILIDADE.CKTERMAT);

		CdaoDISPONIBILIDADE.QUAMI.setBounds(12, 95, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.QUAMI);
		CdaoDISPONIBILIDADE.QUAMI.setColumns(10);

		CdaoDISPONIBILIDADE.QUAMF.setBounds(63, 95, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.QUAMF);
		CdaoDISPONIBILIDADE.QUAMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKQUAMAT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUAMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUAMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUAMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();

			}
		});

		CdaoDISPONIBILIDADE.CKQUAMAT.setBounds(116, 94, 21, 25);
		panel.add(CdaoDISPONIBILIDADE.CKQUAMAT);

		CdaoDISPONIBILIDADE.QUIMI.setBounds(12, 134, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.QUIMI);
		CdaoDISPONIBILIDADE.QUIMI.setColumns(10);

		CdaoDISPONIBILIDADE.QUIMF.setBounds(63, 134, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.QUIMF);
		CdaoDISPONIBILIDADE.QUIMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKQUIMAT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUIMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUIMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUIMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUIMAT.setBounds(116, 133, 21, 25);
		panel.add(CdaoDISPONIBILIDADE.CKQUIMAT);

		CdaoDISPONIBILIDADE.SEXMI.setBounds(12, 173, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.SEXMI);
		CdaoDISPONIBILIDADE.SEXMI.setColumns(10);

		CdaoDISPONIBILIDADE.SEXMF.setBounds(63, 173, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.SEXMF);
		CdaoDISPONIBILIDADE.SEXMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKSEXMAT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEXMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXMAT.setBounds(116, 172, 21, 25);
		panel.add(CdaoDISPONIBILIDADE.CKSEXMAT);

		CdaoDISPONIBILIDADE.SABMI.setBounds(12, 208, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.SABMI);
		CdaoDISPONIBILIDADE.SABMI.setColumns(10);

		CdaoDISPONIBILIDADE.SABMF.setBounds(63, 208, 45, 22);
		panel.add(CdaoDISPONIBILIDADE.SABMF);
		CdaoDISPONIBILIDADE.SABMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKSABMAT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSABMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABMAT.setBounds(116, 207, 21, 25);
		panel.add(CdaoDISPONIBILIDADE.CKSABMAT);

		JLabel lblPeriodoAlmoco = new JLabel("Periodo Almoco");
		lblPeriodoAlmoco.setBounds(413, 26, 115, 16);
		panel_5.add(lblPeriodoAlmoco);
		lblPeriodoAlmoco.setForeground(Color.WHITE);
		lblPeriodoAlmoco.setFont(new Font("Tahoma", Font.BOLD, 13));
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(383, 68, 145, 257);
		panel_5.add(panel_1);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);

		CdaoDISPONIBILIDADE.SEGAI.setColumns(10);
		CdaoDISPONIBILIDADE.SEGAI.setBounds(12, 17, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.SEGAI);

		CdaoDISPONIBILIDADE.SEGAF.setColumns(10);
		CdaoDISPONIBILIDADE.SEGAF.setBounds(69, 17, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.SEGAF);
		CdaoDISPONIBILIDADE.CKSEGALM.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEGALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEGALM.setBounds(116, 15, 21, 25);
		panel_1.add(CdaoDISPONIBILIDADE.CKSEGALM);

		CdaoDISPONIBILIDADE.TERAI.setColumns(10);
		CdaoDISPONIBILIDADE.TERAI.setBounds(12, 56, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.TERAI);

		CdaoDISPONIBILIDADE.TERAF.setColumns(10);
		CdaoDISPONIBILIDADE.TERAF.setBounds(69, 56, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.TERAF);
		CdaoDISPONIBILIDADE.CKTERALM.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKTERALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKTERALM.setBounds(116, 55, 21, 25);
		panel_1.add(CdaoDISPONIBILIDADE.CKTERALM);
		CdaoDISPONIBILIDADE.QUAAI.setColumns(10);
		CdaoDISPONIBILIDADE.QUAAI.setBounds(12, 95, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.QUAAI);
		CdaoDISPONIBILIDADE.QUAAF.setColumns(10);
		CdaoDISPONIBILIDADE.QUAAF.setBounds(69, 95, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.QUAAF);
		CdaoDISPONIBILIDADE.CKQUAALM.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUAALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUAALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUAALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUAALM.setBounds(116, 95, 21, 25);
		panel_1.add(CdaoDISPONIBILIDADE.CKQUAALM);

		CdaoDISPONIBILIDADE.QUIAI.setColumns(10);
		CdaoDISPONIBILIDADE.QUIAI.setBounds(12, 134, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.QUIAI);

		CdaoDISPONIBILIDADE.QUIAF.setColumns(10);
		CdaoDISPONIBILIDADE.QUIAF.setBounds(69, 134, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.QUIAF);
		CdaoDISPONIBILIDADE.CKQUIALM.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUIALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUIALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUIALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUIALM.setBounds(116, 135, 21, 25);
		panel_1.add(CdaoDISPONIBILIDADE.CKQUIALM);

		CdaoDISPONIBILIDADE.SEXAI.setColumns(10);
		CdaoDISPONIBILIDADE.SEXAI.setBounds(12, 173, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.SEXAI);

		CdaoDISPONIBILIDADE.SEXAF.setColumns(10);
		CdaoDISPONIBILIDADE.SEXAF.setBounds(69, 173, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.SEXAF);
		CdaoDISPONIBILIDADE.CKSEXALM.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEXALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXALM.setBounds(116, 175, 21, 25);
		panel_1.add(CdaoDISPONIBILIDADE.CKSEXALM);

		CdaoDISPONIBILIDADE.SABAI.setColumns(10);
		CdaoDISPONIBILIDADE.SABAI.setBounds(12, 212, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.SABAI);

		CdaoDISPONIBILIDADE.SABAF.setColumns(10);
		CdaoDISPONIBILIDADE.SABAF.setBounds(69, 212, 45, 22);
		panel_1.add(CdaoDISPONIBILIDADE.SABAF);
		CdaoDISPONIBILIDADE.CKSABALM.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSABALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABALM.setBounds(116, 215, 21, 25);
		panel_1.add(CdaoDISPONIBILIDADE.CKSABALM);

		JLabel lblPeriodoVespertino = new JLabel("Periodo Vespertino");
		lblPeriodoVespertino.setBounds(591, 26, 133, 16);
		panel_5.add(lblPeriodoVespertino);
		lblPeriodoVespertino.setForeground(Color.WHITE);
		lblPeriodoVespertino.setFont(new Font("Tahoma", Font.BOLD, 13));
		

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(559, 68, 145, 257);
		panel_5.add(panel_2);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setLayout(null);

		CdaoDISPONIBILIDADE.SEGVI.setColumns(10);
		CdaoDISPONIBILIDADE.SEGVI.setBounds(12, 17, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.SEGVI);

		CdaoDISPONIBILIDADE.SEGVF.setColumns(10);
		CdaoDISPONIBILIDADE.SEGVF.setBounds(69, 17, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.SEGVF);
		CdaoDISPONIBILIDADE.CKSEGVES.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEGVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEGVES.setBounds(116, 15, 21, 25);
		panel_2.add(CdaoDISPONIBILIDADE.CKSEGVES);

		CdaoDISPONIBILIDADE.TERVI.setColumns(10);
		CdaoDISPONIBILIDADE.TERVI.setBounds(12, 56, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.TERVI);

		CdaoDISPONIBILIDADE.TERVF.setColumns(10);
		CdaoDISPONIBILIDADE.TERVF.setBounds(69, 56, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.TERVF);
		CdaoDISPONIBILIDADE.CKTERVES.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKTERVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKTERVES.setBounds(116, 55, 21, 25);
		panel_2.add(CdaoDISPONIBILIDADE.CKTERVES);

		CdaoDISPONIBILIDADE.QUAVI.setColumns(10);
		CdaoDISPONIBILIDADE.QUAVI.setBounds(12, 95, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.QUAVI);

		CdaoDISPONIBILIDADE.QUAVF.setColumns(10);
		CdaoDISPONIBILIDADE.QUAVF.setBounds(69, 95, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.QUAVF);
		CdaoDISPONIBILIDADE.CKQUAVES.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUAVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUAVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUAVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUAVES.setBounds(116, 95, 21, 25);
		panel_2.add(CdaoDISPONIBILIDADE.CKQUAVES);

		CdaoDISPONIBILIDADE.QUIVI.setColumns(10);
		CdaoDISPONIBILIDADE.QUIVI.setBounds(12, 134, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.QUIVI);

		CdaoDISPONIBILIDADE.QUIVF.setColumns(10);
		CdaoDISPONIBILIDADE.QUIVF.setBounds(69, 134, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.QUIVF);
		CdaoDISPONIBILIDADE.CKQUIVES.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUIVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUIVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUIVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUIVES.setBounds(116, 135, 21, 25);
		panel_2.add(CdaoDISPONIBILIDADE.CKQUIVES);

		CdaoDISPONIBILIDADE.SEXVI.setColumns(10);
		CdaoDISPONIBILIDADE.SEXVI.setBounds(12, 173, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.SEXVI);

		CdaoDISPONIBILIDADE.SEXVF.setColumns(10);
		CdaoDISPONIBILIDADE.SEXVF.setBounds(69, 173, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.SEXVF);
		CdaoDISPONIBILIDADE.CKSEXVES.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEXVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXVES.setBounds(116, 175, 21, 25);
		panel_2.add(CdaoDISPONIBILIDADE.CKSEXVES);

		CdaoDISPONIBILIDADE.SABVI.setColumns(10);
		CdaoDISPONIBILIDADE.SABVI.setBounds(12, 212, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.SABVI);

		CdaoDISPONIBILIDADE.SABVF.setColumns(10);
		CdaoDISPONIBILIDADE.SABVF.setBounds(69, 212, 45, 22);
		panel_2.add(CdaoDISPONIBILIDADE.SABVF);
		CdaoDISPONIBILIDADE.CKSABVES.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSABVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABVES.setBounds(116, 215, 21, 25);
		panel_2.add(CdaoDISPONIBILIDADE.CKSABVES);

		JLabel lblPeriodoNoturno = new JLabel("Periodo Noturno");
		lblPeriodoNoturno.setBounds(755, 26, 115, 16);
		panel_5.add(lblPeriodoNoturno);
		lblPeriodoNoturno.setForeground(Color.WHITE);
		lblPeriodoNoturno.setFont(new Font("Tahoma", Font.BOLD, 13));
		

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(735, 68, 145, 257);
		panel_5.add(panel_3);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setLayout(null);
		btnVoltar.setBounds(954, 596, 320, 45);
		CdaoDISPONIBILIDADE.SEGNI.setColumns(10);
		CdaoDISPONIBILIDADE.SEGNI.setBounds(12, 17, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.SEGNI);

		CdaoDISPONIBILIDADE.SEGNF.setColumns(10);
		CdaoDISPONIBILIDADE.SEGNF.setBounds(69, 17, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.SEGNF);
		CdaoDISPONIBILIDADE.CKSEGNOT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEGNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEGNOT.setBounds(116, 15, 21, 25);
		panel_3.add(CdaoDISPONIBILIDADE.CKSEGNOT);

		CdaoDISPONIBILIDADE.TERNI.setColumns(10);
		CdaoDISPONIBILIDADE.TERNI.setBounds(12, 56, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.TERNI);

		CdaoDISPONIBILIDADE.TERNF.setColumns(10);
		CdaoDISPONIBILIDADE.TERNF.setBounds(69, 56, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.TERNF);
		CdaoDISPONIBILIDADE.CKTERNOT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKTERNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKTERNOT.setBounds(116, 55, 21, 25);
		panel_3.add(CdaoDISPONIBILIDADE.CKTERNOT);

		CdaoDISPONIBILIDADE.QUANI.setColumns(10);
		CdaoDISPONIBILIDADE.QUANI.setBounds(12, 95, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.QUANI);

		CdaoDISPONIBILIDADE.QUANF.setColumns(10);
		CdaoDISPONIBILIDADE.QUANF.setBounds(69, 95, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.QUANF);
		CdaoDISPONIBILIDADE.CKQUANOT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUANOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUANOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUANOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUANOT.setBounds(116, 95, 21, 25);
		panel_3.add(CdaoDISPONIBILIDADE.CKQUANOT);

		CdaoDISPONIBILIDADE.QUINI.setColumns(10);
		CdaoDISPONIBILIDADE.QUINI.setBounds(12, 134, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.QUINI);

		CdaoDISPONIBILIDADE.QUINF.setColumns(10);
		CdaoDISPONIBILIDADE.QUINF.setBounds(69, 134, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.QUINF);
		CdaoDISPONIBILIDADE.CKQUINOT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKQUINOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUINOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUINOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUINOT.setBounds(116, 135, 21, 25);
		panel_3.add(CdaoDISPONIBILIDADE.CKQUINOT);

		CdaoDISPONIBILIDADE.SEXNI.setColumns(10);
		CdaoDISPONIBILIDADE.SEXNI.setBounds(12, 173, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.SEXNI);

		CdaoDISPONIBILIDADE.SEXNF.setColumns(10);
		CdaoDISPONIBILIDADE.SEXNF.setBounds(69, 173, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.SEXNF);
		CdaoDISPONIBILIDADE.CKSEXNOT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSEXNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXNOT.setBounds(116, 175, 21, 25);
		panel_3.add(CdaoDISPONIBILIDADE.CKSEXNOT);

		CdaoDISPONIBILIDADE.SABNI.setColumns(10);
		CdaoDISPONIBILIDADE.SABNI.setBounds(12, 212, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.SABNI);

		CdaoDISPONIBILIDADE.SABNF.setColumns(10);
		CdaoDISPONIBILIDADE.SABNF.setBounds(69, 212, 45, 22);
		panel_3.add(CdaoDISPONIBILIDADE.SABNF);
		CdaoDISPONIBILIDADE.CKSABNOT.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.CKSABNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABNOT.setBounds(116, 215, 21, 25);
		panel_3.add(CdaoDISPONIBILIDADE.CKSABNOT);

		JLabel lblNewLabel = new JLabel("Disponibilidade para Coleta:");
		lblNewLabel.setBounds(371, 0, 248, 16);
		panel_5.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		CdaoDISPONIBILIDADE.chckSab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.sabadochck();
			}
		});
		CdaoDISPONIBILIDADE.chckSex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.sextachck();
			}
		});
		CdaoDISPONIBILIDADE.chckQui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.quintachck();
			}
		});
		CdaoDISPONIBILIDADE.chckQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.quartachck();
			}
		});
		CdaoDISPONIBILIDADE.chckTer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.tercachck();
			}
		});
		CdaoDISPONIBILIDADE.chckSeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.segungachck();
			}
		});
		

		JLabel frame = new JLabel("");
		frame.setBounds(0, 0, 1280, 720);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/testefundo3.jpg")));
		contentPane.add(frame);
		CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
			
		CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
		 
		 CdaoMULL.QUERYNEWROUPASCALCADOS(Cmull);

		 
	}
}