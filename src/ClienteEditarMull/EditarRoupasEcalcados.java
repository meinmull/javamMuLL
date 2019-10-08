package ClienteEditarMull;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;


public class EditarRoupasEcalcados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	cDAOdisponibilidade CdaoDISPONIBILIDADE = new cDAOdisponibilidade();
	cMull Cmull = new cMull();
	cDisponibilidade cDISPONIBILIDADE = new cDisponibilidade();
	cDAOmull CdaoMULL = new cDAOmull();
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JTextField txtObs;

	private JLabel label;
	@SuppressWarnings("unused")
	private JTextField txtPecas;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarRoupasEcalcados frame = new EditarRoupasEcalcados();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EditarRoupasEcalcados() {
		
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

		
		CdaoDISPONIBILIDADE.txtcDAOeditableFALSE();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cliente - Editar solicitação roupas e calcados.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setBounds(100, 100, 1280, 670);

		setResizable(true);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		JButton btnVoltar = new JButton("");

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});

		btnVoltar.setBounds(954, 574, 320, 45);
		contentPane.add(btnVoltar);
		btnVoltar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharLogin.jpg")));

		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConfirmarAlteracao.jpg")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoMULL.QUERY_COD_ROUPASCALCADOS(Cmull);
				CdaoMULL.uPDATEROUPASCALCADOS(Cmull);
				

				CdaoDISPONIBILIDADE.horarioColetaSegunda(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaTerca(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaQuarta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaQuinta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaSexta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.horarioColetaSabado(cDISPONIBILIDADE);

				CdaoDISPONIBILIDADE.uPDATEHorarioColetaSegunda(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.uPDATEHorarioColetaTerca(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.uPDATEHorarioColetaQuarta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.uPDATEHorarioColetaQuinta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.uPDATEHorarioColetaSexta(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.uPDATEHorarioColetaSabado(cDISPONIBILIDADE);

				dispose();

			}
		});
		btnAlterar.setBounds(954, 422, 320, 45);
		contentPane.add(btnAlterar);

		CdaoDISPONIBILIDADE.chckSeg.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckSeg.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckSeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.segungachck();
			}
		});

		CdaoDISPONIBILIDADE.chckSeg.setBounds(17, 15, 111, 25);

		CdaoDISPONIBILIDADE.chckTer.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckTer.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckTer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.tercachck();
			}
		});

		CdaoDISPONIBILIDADE.chckTer.setBounds(17, 55, 111, 25);

		CdaoDISPONIBILIDADE.chckQua.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckQua.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.quartachck();
			}
		});

		CdaoDISPONIBILIDADE.chckQua.setBounds(17, 95, 111, 25);

		CdaoDISPONIBILIDADE.chckQui.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckQui.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckQui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.quintachck();
			}
		});

		CdaoDISPONIBILIDADE.chckQui.setBounds(17, 135, 111, 25);

		CdaoDISPONIBILIDADE.chckSex.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckSex.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckSex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.sextachck();
			}
		});

		CdaoDISPONIBILIDADE.chckSex.setBounds(17, 175, 111, 25);
		CdaoDISPONIBILIDADE.chckSab.setForeground(Color.WHITE);
		CdaoDISPONIBILIDADE.chckSab.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.chckSab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
				CdaoDISPONIBILIDADE.sabadochck();
			}
		});

		CdaoDISPONIBILIDADE.chckSab.setBounds(17, 215, 111, 25);

		CdaoDISPONIBILIDADE.SEGMI.setBounds(12, 17, 45, 22);
		CdaoDISPONIBILIDADE.SEGMI.setColumns(10);

		CdaoDISPONIBILIDADE.SEGMF.setBounds(63, 17, 45, 22);
		CdaoDISPONIBILIDADE.SEGMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKSEGMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();

			}
		});

		CdaoDISPONIBILIDADE.CKSEGMAT.setBounds(116, 16, 21, 25);

		CdaoDISPONIBILIDADE.TERMI.setBounds(12, 56, 45, 22);
		CdaoDISPONIBILIDADE.TERMI.setColumns(10);

		CdaoDISPONIBILIDADE.TERMF.setBounds(63, 56, 45, 22);
		CdaoDISPONIBILIDADE.TERMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKTERMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();

			}
		});

		CdaoDISPONIBILIDADE.CKTERMAT.setBounds(116, 55, 21, 25);

		CdaoDISPONIBILIDADE.QUAMI.setBounds(12, 95, 45, 22);
		CdaoDISPONIBILIDADE.QUAMI.setColumns(10);

		CdaoDISPONIBILIDADE.QUAMF.setBounds(63, 95, 45, 22);
		CdaoDISPONIBILIDADE.QUAMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKQUAMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUAMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUAMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();

			}
		});

		CdaoDISPONIBILIDADE.CKQUAMAT.setBounds(116, 94, 21, 25);

		CdaoDISPONIBILIDADE.QUIMI.setBounds(12, 134, 45, 22);
		CdaoDISPONIBILIDADE.QUIMI.setColumns(10);

		CdaoDISPONIBILIDADE.QUIMF.setBounds(63, 134, 45, 22);
		CdaoDISPONIBILIDADE.QUIMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKQUIMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUIMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUIMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUIMAT.setBounds(116, 133, 21, 25);

		CdaoDISPONIBILIDADE.SEXMI.setBounds(12, 173, 45, 22);
		CdaoDISPONIBILIDADE.SEXMI.setColumns(10);

		CdaoDISPONIBILIDADE.SEXMF.setBounds(63, 173, 45, 22);
		CdaoDISPONIBILIDADE.SEXMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKSEXMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXMAT.setBounds(116, 172, 21, 25);

		CdaoDISPONIBILIDADE.SABMI.setBounds(12, 208, 45, 22);
		CdaoDISPONIBILIDADE.SABMI.setColumns(10);

		CdaoDISPONIBILIDADE.SABMF.setBounds(63, 208, 45, 22);
		CdaoDISPONIBILIDADE.SABMF.setColumns(10);
		CdaoDISPONIBILIDADE.CKSABMAT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABMAT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABMAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABMAT.setBounds(116, 207, 21, 25);

		CdaoDISPONIBILIDADE.SEGAI.setColumns(10);
		CdaoDISPONIBILIDADE.SEGAI.setBounds(12, 17, 45, 22);

		CdaoDISPONIBILIDADE.SEGAF.setColumns(10);
		CdaoDISPONIBILIDADE.SEGAF.setBounds(69, 17, 45, 22);
		CdaoDISPONIBILIDADE.CKSEGALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEGALM.setBounds(116, 15, 21, 25);

		CdaoDISPONIBILIDADE.TERAI.setColumns(10);
		CdaoDISPONIBILIDADE.TERAI.setBounds(12, 56, 45, 22);

		CdaoDISPONIBILIDADE.TERAF.setColumns(10);
		CdaoDISPONIBILIDADE.TERAF.setBounds(69, 56, 45, 22);
		CdaoDISPONIBILIDADE.CKTERALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKTERALM.setBounds(116, 55, 21, 25);
		CdaoDISPONIBILIDADE.QUAAI.setColumns(10);
		CdaoDISPONIBILIDADE.QUAAI.setBounds(12, 95, 45, 22);
		CdaoDISPONIBILIDADE.QUAAF.setColumns(10);
		CdaoDISPONIBILIDADE.QUAAF.setBounds(69, 95, 45, 22);
		CdaoDISPONIBILIDADE.CKQUAALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUAALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUAALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUAALM.setBounds(116, 95, 21, 25);

		CdaoDISPONIBILIDADE.QUIAI.setColumns(10);
		CdaoDISPONIBILIDADE.QUIAI.setBounds(12, 134, 45, 22);

		CdaoDISPONIBILIDADE.QUIAF.setColumns(10);
		CdaoDISPONIBILIDADE.QUIAF.setBounds(69, 134, 45, 22);
		CdaoDISPONIBILIDADE.CKQUIALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUIALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUIALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUIALM.setBounds(116, 135, 21, 25);

		CdaoDISPONIBILIDADE.SEXAI.setColumns(10);
		CdaoDISPONIBILIDADE.SEXAI.setBounds(12, 173, 45, 22);

		CdaoDISPONIBILIDADE.SEXAF.setColumns(10);
		CdaoDISPONIBILIDADE.SEXAF.setBounds(69, 173, 45, 22);
		CdaoDISPONIBILIDADE.CKSEXALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXALM.setBounds(116, 175, 21, 25);

		CdaoDISPONIBILIDADE.SABAI.setColumns(10);
		CdaoDISPONIBILIDADE.SABAI.setBounds(12, 212, 45, 22);

		CdaoDISPONIBILIDADE.SABAF.setColumns(10);
		CdaoDISPONIBILIDADE.SABAF.setBounds(69, 212, 45, 22);
		CdaoDISPONIBILIDADE.CKSABALM.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABALM.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABALM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABALM.setBounds(116, 215, 21, 25);

		CdaoDISPONIBILIDADE.SEGVI.setColumns(10);
		CdaoDISPONIBILIDADE.SEGVI.setBounds(12, 17, 45, 22);

		CdaoDISPONIBILIDADE.SEGVF.setColumns(10);
		CdaoDISPONIBILIDADE.SEGVF.setBounds(69, 17, 45, 22);
		CdaoDISPONIBILIDADE.CKSEGVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEGVES.setBounds(116, 15, 21, 25);

		CdaoDISPONIBILIDADE.TERVI.setColumns(10);
		CdaoDISPONIBILIDADE.TERVI.setBounds(12, 56, 45, 22);

		CdaoDISPONIBILIDADE.TERVF.setColumns(10);
		CdaoDISPONIBILIDADE.TERVF.setBounds(69, 56, 45, 22);
		CdaoDISPONIBILIDADE.CKTERVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKTERVES.setBounds(116, 55, 21, 25);

		CdaoDISPONIBILIDADE.QUAVI.setColumns(10);
		CdaoDISPONIBILIDADE.QUAVI.setBounds(12, 95, 45, 22);

		CdaoDISPONIBILIDADE.QUAVF.setColumns(10);
		CdaoDISPONIBILIDADE.QUAVF.setBounds(69, 95, 45, 22);
		CdaoDISPONIBILIDADE.CKQUAVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUAVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUAVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUAVES.setBounds(116, 95, 21, 25);

		CdaoDISPONIBILIDADE.QUIVI.setColumns(10);
		CdaoDISPONIBILIDADE.QUIVI.setBounds(12, 134, 45, 22);

		CdaoDISPONIBILIDADE.QUIVF.setColumns(10);
		CdaoDISPONIBILIDADE.QUIVF.setBounds(69, 134, 45, 22);
		CdaoDISPONIBILIDADE.CKQUIVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUIVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUIVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUIVES.setBounds(116, 135, 21, 25);

		CdaoDISPONIBILIDADE.SEXVI.setColumns(10);
		CdaoDISPONIBILIDADE.SEXVI.setBounds(12, 173, 45, 22);

		CdaoDISPONIBILIDADE.SEXVF.setColumns(10);
		CdaoDISPONIBILIDADE.SEXVF.setBounds(69, 173, 45, 22);
		CdaoDISPONIBILIDADE.CKSEXVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXVES.setBounds(116, 175, 21, 25);

		CdaoDISPONIBILIDADE.SABVI.setColumns(10);
		CdaoDISPONIBILIDADE.SABVI.setBounds(12, 212, 45, 22);

		CdaoDISPONIBILIDADE.SABVF.setColumns(10);
		CdaoDISPONIBILIDADE.SABVF.setBounds(69, 212, 45, 22);
		CdaoDISPONIBILIDADE.CKSABVES.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABVES.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABVES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABVES.setBounds(116, 215, 21, 25);

		CdaoDISPONIBILIDADE.SEGNI.setColumns(10);
		CdaoDISPONIBILIDADE.SEGNI.setBounds(12, 17, 45, 22);

		CdaoDISPONIBILIDADE.SEGNF.setColumns(10);
		CdaoDISPONIBILIDADE.SEGNF.setBounds(69, 17, 45, 22);
		CdaoDISPONIBILIDADE.CKSEGNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEGNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEGNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEGNOT.setBounds(116, 15, 21, 25);

		CdaoDISPONIBILIDADE.TERNI.setColumns(10);
		CdaoDISPONIBILIDADE.TERNI.setBounds(12, 56, 45, 22);

		CdaoDISPONIBILIDADE.TERNF.setColumns(10);
		CdaoDISPONIBILIDADE.TERNF.setBounds(69, 56, 45, 22);
		CdaoDISPONIBILIDADE.CKTERNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKTERNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKTERNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKTERNOT.setBounds(116, 55, 21, 25);

		CdaoDISPONIBILIDADE.QUANI.setColumns(10);
		CdaoDISPONIBILIDADE.QUANI.setBounds(12, 95, 45, 22);

		CdaoDISPONIBILIDADE.QUANF.setColumns(10);
		CdaoDISPONIBILIDADE.QUANF.setBounds(69, 95, 45, 22);
		CdaoDISPONIBILIDADE.CKQUANOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUANOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUANOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUANOT.setBounds(116, 95, 21, 25);

		CdaoDISPONIBILIDADE.QUINI.setColumns(10);
		CdaoDISPONIBILIDADE.QUINI.setBounds(12, 134, 45, 22);

		CdaoDISPONIBILIDADE.QUINF.setColumns(10);
		CdaoDISPONIBILIDADE.QUINF.setBounds(69, 134, 45, 22);
		CdaoDISPONIBILIDADE.CKQUINOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKQUINOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKQUINOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKQUINOT.setBounds(116, 135, 21, 25);

		CdaoDISPONIBILIDADE.SEXNI.setColumns(10);
		CdaoDISPONIBILIDADE.SEXNI.setBounds(12, 173, 45, 22);

		CdaoDISPONIBILIDADE.SEXNF.setColumns(10);
		CdaoDISPONIBILIDADE.SEXNF.setBounds(69, 173, 45, 22);
		CdaoDISPONIBILIDADE.CKSEXNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSEXNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSEXNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSEXNOT.setBounds(116, 175, 21, 25);

		CdaoDISPONIBILIDADE.SABNI.setColumns(10);
		CdaoDISPONIBILIDADE.SABNI.setBounds(12, 212, 45, 22);

		CdaoDISPONIBILIDADE.SABNF.setColumns(10);
		CdaoDISPONIBILIDADE.SABNF.setBounds(69, 212, 45, 22);
		CdaoDISPONIBILIDADE.CKSABNOT.setBackground(Color.DARK_GRAY);
		CdaoDISPONIBILIDADE.CKSABNOT.setEnabled(false);
		CdaoDISPONIBILIDADE.CKSABNOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
				CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
			}
		});

		CdaoDISPONIBILIDADE.CKSABNOT.setBounds(116, 215, 21, 25);

		JButton btnCancelarPedido = new JButton("");

		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CdaoMULL.QUERY_COD_ELETRONICO(Cmull);
				CdaoMULL.DELETELETRONICO_SOLICITACAOCOLETA();
				CdaoMULL.DELETELETRONICO_DE_MMuLL();
				CdaoMULL.DELETELETRONICO();

				dispose();

			}
		});
		
		btnCancelarPedido.setBounds(954, 502, 320, 45);
		contentPane.add(btnCancelarPedido);
		btnCancelarPedido.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnExcluirMull.jpg")));

		CdaoDISPONIBILIDADE.chckTer.setEnabled(true);
		;

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(0, 330, 916, 347);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(31, 53, 145, 257);
		panel_5.add(panel_4);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setLayout(null);
		panel_4.add(CdaoDISPONIBILIDADE.chckSeg);
		panel_4.add(CdaoDISPONIBILIDADE.chckTer);
		panel_4.add(CdaoDISPONIBILIDADE.chckQua);
		panel_4.add(CdaoDISPONIBILIDADE.chckQui);
		panel_4.add(CdaoDISPONIBILIDADE.chckSex);
		panel_4.add(CdaoDISPONIBILIDADE.chckSab);

		JLabel lblDiasDaSemana = new JLabel("Dias da Semana");
		lblDiasDaSemana.setBounds(44, 35, 111, 16);
		panel_5.add(lblDiasDaSemana);
		lblDiasDaSemana.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiasDaSemana.setForeground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBounds(207, 53, 145, 257);
		panel_5.add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		panel.add(CdaoDISPONIBILIDADE.SEGMI);
		panel.add(CdaoDISPONIBILIDADE.SEGMF);
		panel.add(CdaoDISPONIBILIDADE.CKSEGMAT);
		panel.add(CdaoDISPONIBILIDADE.TERMI);
		panel.add(CdaoDISPONIBILIDADE.TERMF);
		panel.add(CdaoDISPONIBILIDADE.CKTERMAT);
		panel.add(CdaoDISPONIBILIDADE.QUAMI);
		panel.add(CdaoDISPONIBILIDADE.QUAMF);
		panel.add(CdaoDISPONIBILIDADE.CKQUAMAT);
		panel.add(CdaoDISPONIBILIDADE.QUIMI);
		panel.add(CdaoDISPONIBILIDADE.QUIMF);
		panel.add(CdaoDISPONIBILIDADE.CKQUIMAT);
		panel.add(CdaoDISPONIBILIDADE.SEXMI);
		panel.add(CdaoDISPONIBILIDADE.SEXMF);
		panel.add(CdaoDISPONIBILIDADE.CKSEXMAT);
		panel.add(CdaoDISPONIBILIDADE.SABMI);
		panel.add(CdaoDISPONIBILIDADE.SABMF);
		panel.add(CdaoDISPONIBILIDADE.CKSABMAT);

		JLabel lblPeriodoMatutino = new JLabel("Periodo Matutino");
		lblPeriodoMatutino.setBounds(217, 35, 124, 16);
		panel_5.add(lblPeriodoMatutino);
		lblPeriodoMatutino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeriodoMatutino.setForeground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(383, 53, 145, 257);
		panel_5.add(panel_1);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		panel_1.add(CdaoDISPONIBILIDADE.SEGAI);
		panel_1.add(CdaoDISPONIBILIDADE.SEGAF);
		panel_1.add(CdaoDISPONIBILIDADE.CKSEGALM);
		panel_1.add(CdaoDISPONIBILIDADE.TERAI);
		panel_1.add(CdaoDISPONIBILIDADE.TERAF);
		panel_1.add(CdaoDISPONIBILIDADE.CKTERALM);
		panel_1.add(CdaoDISPONIBILIDADE.QUAAI);
		panel_1.add(CdaoDISPONIBILIDADE.QUAAF);
		panel_1.add(CdaoDISPONIBILIDADE.CKQUAALM);
		panel_1.add(CdaoDISPONIBILIDADE.QUIAI);
		panel_1.add(CdaoDISPONIBILIDADE.QUIAF);
		panel_1.add(CdaoDISPONIBILIDADE.CKQUIALM);
		panel_1.add(CdaoDISPONIBILIDADE.SEXAI);
		panel_1.add(CdaoDISPONIBILIDADE.SEXAF);
		panel_1.add(CdaoDISPONIBILIDADE.CKSEXALM);
		panel_1.add(CdaoDISPONIBILIDADE.SABAI);
		panel_1.add(CdaoDISPONIBILIDADE.SABAF);
		panel_1.add(CdaoDISPONIBILIDADE.CKSABALM);

		JLabel lblPeriodoAlmoco = new JLabel("Periodo Almoco");
		lblPeriodoAlmoco.setBounds(399, 35, 111, 16);
		panel_5.add(lblPeriodoAlmoco);
		lblPeriodoAlmoco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeriodoAlmoco.setForeground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(559, 53, 145, 257);
		panel_5.add(panel_2);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setLayout(null);
		panel_2.add(CdaoDISPONIBILIDADE.SEGVI);
		panel_2.add(CdaoDISPONIBILIDADE.SEGVF);
		panel_2.add(CdaoDISPONIBILIDADE.CKSEGVES);
		panel_2.add(CdaoDISPONIBILIDADE.TERVI);
		panel_2.add(CdaoDISPONIBILIDADE.TERVF);
		panel_2.add(CdaoDISPONIBILIDADE.CKTERVES);
		panel_2.add(CdaoDISPONIBILIDADE.QUAVI);
		panel_2.add(CdaoDISPONIBILIDADE.QUAVF);
		panel_2.add(CdaoDISPONIBILIDADE.CKQUAVES);
		panel_2.add(CdaoDISPONIBILIDADE.QUIVI);
		panel_2.add(CdaoDISPONIBILIDADE.QUIVF);
		panel_2.add(CdaoDISPONIBILIDADE.CKQUIVES);
		panel_2.add(CdaoDISPONIBILIDADE.SEXVI);
		panel_2.add(CdaoDISPONIBILIDADE.SEXVF);
		panel_2.add(CdaoDISPONIBILIDADE.CKSEXVES);
		panel_2.add(CdaoDISPONIBILIDADE.SABVI);
		panel_2.add(CdaoDISPONIBILIDADE.SABVF);
		panel_2.add(CdaoDISPONIBILIDADE.CKSABVES);

		JLabel lblPeriodoVespertino = new JLabel("Periodo Vespertino");
		lblPeriodoVespertino.setBounds(567, 35, 137, 16);
		panel_5.add(lblPeriodoVespertino);
		lblPeriodoVespertino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeriodoVespertino.setForeground(Color.WHITE);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(735, 53, 145, 257);
		panel_5.add(panel_3);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setLayout(null);
		panel_3.add(CdaoDISPONIBILIDADE.SEGNI);
		panel_3.add(CdaoDISPONIBILIDADE.SEGNF);
		panel_3.add(CdaoDISPONIBILIDADE.CKSEGNOT);
		panel_3.add(CdaoDISPONIBILIDADE.TERNI);
		panel_3.add(CdaoDISPONIBILIDADE.TERNF);
		panel_3.add(CdaoDISPONIBILIDADE.CKTERNOT);
		panel_3.add(CdaoDISPONIBILIDADE.QUANI);
		panel_3.add(CdaoDISPONIBILIDADE.QUANF);
		panel_3.add(CdaoDISPONIBILIDADE.CKQUANOT);
		panel_3.add(CdaoDISPONIBILIDADE.QUINI);
		panel_3.add(CdaoDISPONIBILIDADE.QUINF);
		panel_3.add(CdaoDISPONIBILIDADE.CKQUINOT);
		panel_3.add(CdaoDISPONIBILIDADE.SEXNI);
		panel_3.add(CdaoDISPONIBILIDADE.SEXNF);
		panel_3.add(CdaoDISPONIBILIDADE.CKSEXNOT);
		panel_3.add(CdaoDISPONIBILIDADE.SABNI);
		panel_3.add(CdaoDISPONIBILIDADE.SABNF);
		panel_3.add(CdaoDISPONIBILIDADE.CKSABNOT);

		JLabel lblPeriodoNoturno = new JLabel("Periodo Noturno");
		lblPeriodoNoturno.setBounds(743, 35, 124, 16);
		panel_5.add(lblPeriodoNoturno);
		lblPeriodoNoturno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeriodoNoturno.setForeground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("Disponibilidade para Coleta:");
		lblNewLabel.setBounds(349, 6, 231, 16);
		panel_5.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setBounds(0, 42, 916, 264);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		

		CdaoMULL.txtObs = new JTextArea();
		CdaoMULL.txtObs.setBounds(505, 88, 338, 163);
		panel_6.add(CdaoMULL.txtObs);
		CdaoMULL.txtObs.setColumns(10);
		
		CdaoMULL.txtCOD_MULL = new JTextField();
		CdaoMULL.txtCOD_MULL.setBounds(232, 229, 201, 22);
		panel_6.add(CdaoMULL.txtCOD_MULL);
		CdaoMULL.txtCOD_MULL.setColumns(10);
		
		JLabel lblIdMll = new JLabel("ID m\u00FCll");
		lblIdMll.setFont(new Font("Roboto", Font.BOLD, 15));
		lblIdMll.setForeground(Color.WHITE);
		lblIdMll.setBounds(72, 235, 56, 16);
		panel_6.add(lblIdMll);
		
		
		CdaoMULL.cbxDescricao.setModel(new DefaultComboBoxModel(new String[] {" ", "Roupas", "Calcados", "Roupas de Cama/Mesa/Banho"}));
		
		CdaoMULL.cbxDescricao.setBounds(232, 57, 201, 24);
		panel_6.add(CdaoMULL.cbxDescricao);
		
		CdaoMULL.cbxFaixaEtaria.setBounds(232, 115, 201, 24);
		panel_6.add(CdaoMULL.cbxFaixaEtaria);
		
		CdaoMULL.txtPecas = new JTextField();
		CdaoMULL.txtPecas.setBounds(232, 185, 201, 22);
		panel_6.add(CdaoMULL.txtPecas);
		CdaoMULL.txtPecas.setColumns(10);
		
		JLabel lblPeas = new JLabel("Pe\u00E7as:");
		lblPeas.setFont(new Font("Roboto", Font.BOLD, 15));
		lblPeas.setForeground(Color.WHITE);
		lblPeas.setBounds(72, 188, 56, 16);
		panel_6.add(lblPeas);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Roboto", Font.BOLD, 15));
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setBounds(72, 61, 88, 16);
		panel_6.add(lblDescrio);
		
		JLabel lblPeso = new JLabel("Faixa Et\u00E1ria");
		lblPeso.setFont(new Font("Roboto", Font.BOLD, 15));
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setBounds(72, 119, 88, 16);
		panel_6.add(lblPeso);
		
		JLabel lblNewLabel_1 = new JLabel("Observa\u00E7\u00E3o: ");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(505, 59, 110, 16);
		panel_6.add(lblNewLabel_1);
		
		JLabel lblGnero = new JLabel("G\u00EAnero :");
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setFont(new Font("Roboto", Font.BOLD, 15));
		lblGnero.setBounds(72, 159, 56, 16);
		panel_6.add(lblGnero);
		
		
		CdaoMULL.cbxGenero.setBounds(232, 157, 201, 24);
		panel_6.add(CdaoMULL.cbxGenero);

		label = new JLabel("");
		label.setBounds(0, 0, 225, 135);
		contentPane.add(label);

		JLabel frame = new JLabel("");
		frame.setBounds(0, 0, 1280, 720);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/fundoEDITmull.jpg")));
		contentPane.add(frame);
		
		 System.out.println("PAGINA EDITAR ELETRONICO : COD MULL : " +cDISPONIBILIDADE.getCOD_MULL());
		
		 
		 Cmull.setCOD_MULL(cDISPONIBILIDADE.getCOD_MULL());
		 
		 CdaoDISPONIBILIDADE.DiasDAsemana(cDISPONIBILIDADE);
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
		  CdaoMULL.QUERY_mMuLL_ROUPASCALCADOS(Cmull);
		  CdaoMULL.QUERYGeneroCOMBOBOX();
		CdaoMULL.QUERYfaixaEtariaCOMBOBOX();
		  CdaoDISPONIBILIDADE.QueryDisponibilidadeDias(cDISPONIBILIDADE);
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutino();
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCO();
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertino();
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNO();
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaMatutinoNON();
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaALMOCONON();
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaVespertinoNON();
		  CdaoDISPONIBILIDADE.DisponibilidadeColetaNOTURNONON();
		 

	}
}
	



	
