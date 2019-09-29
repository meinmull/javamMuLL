package Instituicao;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import beans.Coleta;
import beans.Mensagem;
import beans.Mull;
import dao.DAOcoleta;
import dao.DAOmensagem;
import dao.DAOmull;
import login.menulogin;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;

public class InstituicaoSolicitarColetaCalcadosDetalhes extends JFrame {
	

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	Mensagem mensagem = new Mensagem();
	static Coleta coleta = new Coleta();
	Mull mull =  new Mull();
	DAOcoleta daoCOLETA = new DAOcoleta();
	DAOmull daoMULL = new DAOmull();
	DAOmensagem daoMENSAGEM = new DAOmensagem();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstituicaoSolicitarColetaCalcadosDetalhes frame = new InstituicaoSolicitarColetaCalcadosDetalhes(coleta);
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
	 * @param coleta 
	 * @param coleta 
	 */
	public InstituicaoSolicitarColetaCalcadosDetalhes(Coleta coleta) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCidade.setBounds(265, 189, 56, 16);
		contentPane.add(lblCidade);
		
		DAOcoleta.txtCidade = new JTextField();
		DAOcoleta.txtCidade.setForeground(Color.BLACK);
		DAOcoleta.txtCidade.setBackground(Color.WHITE);
		DAOcoleta.txtCidade.setEditable(false);
		DAOcoleta.txtCidade.setBounds(361, 186, 372, 22);
		contentPane.add(DAOcoleta.txtCidade);
		DAOcoleta.txtCidade.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBairro.setBounds(265, 277, 56, 16);
		contentPane.add(lblBairro);
		
		DAOcoleta.txtBairo = new JTextField();
		DAOcoleta.txtBairo.setForeground(Color.BLACK);
		DAOcoleta.txtBairo.setBackground(Color.WHITE);
		DAOcoleta.txtBairo.setEditable(false);
		DAOcoleta.txtBairo.setBounds(361, 274, 306, 22);
		contentPane.add(DAOcoleta.txtBairo);
		DAOcoleta.txtBairo.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco.setBounds(265, 231, 65, 16);
		contentPane.add(lblEndereco);
		
		DAOcoleta.txtEndereco = new JTextField();
		DAOcoleta.txtEndereco.setForeground(Color.BLACK);
		DAOcoleta.txtEndereco.setBackground(Color.WHITE);
		DAOcoleta.txtEndereco.setEditable(false);
		DAOcoleta.txtEndereco.setBounds(361, 228, 551, 22);
		contentPane.add(DAOcoleta.txtEndereco);
		DAOcoleta.txtEndereco.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCep.setBounds(746, 189, 39, 16);
		contentPane.add(lblCep);
		
		DAOcoleta.txtCep = new JTextField();
		DAOcoleta.txtCep.setForeground(Color.BLACK);
		DAOcoleta.txtCep.setBackground(Color.WHITE);
		DAOcoleta.txtCep.setEditable(false);
		DAOcoleta.txtCep.setBounds(796, 186, 116, 22);
		contentPane.add(DAOcoleta.txtCep);
		DAOcoleta.txtCep.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComplemento.setBounds(687, 277, 97, 16);
		contentPane.add(lblComplemento);
		
		DAOcoleta.txtComplemento = new JTextField();
		DAOcoleta.txtComplemento.setForeground(Color.BLACK);
		DAOcoleta.txtComplemento.setBackground(Color.WHITE);
		DAOcoleta.txtComplemento.setEditable(false);
		DAOcoleta.txtComplemento.setBounds(796, 274, 116, 22);
		contentPane.add(DAOcoleta.txtComplemento);
		DAOcoleta.txtComplemento.setColumns(10);
		
		JLabel lblMmull = new JLabel("mMuLL");
		lblMmull.setForeground(Color.WHITE);
		lblMmull.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMmull.setBounds(265, 380, 56, 16);
		contentPane.add(lblMmull);
		
		DAOcoleta.txtCODmMuLL = new JTextField();
		DAOcoleta.txtCODmMuLL.setForeground(Color.BLACK);
		DAOcoleta.txtCODmMuLL.setBackground(Color.WHITE);
		DAOcoleta.txtCODmMuLL.setEditable(false);
		DAOcoleta.txtCODmMuLL.setBounds(724, 377, 188, 22);
		contentPane.add(DAOcoleta.txtCODmMuLL);
		DAOcoleta.txtCODmMuLL.setColumns(10);
		
		JLabel lblTipo = new JLabel("Descri\u00E7\u00E3o:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(265, 426, 85, 16);
		contentPane.add(lblTipo);
		
		DAOcoleta.txtDescricao = new JTextField();
		DAOcoleta.txtDescricao.setForeground(Color.BLACK);
		DAOcoleta.txtDescricao.setBackground(Color.WHITE);
		DAOcoleta.txtDescricao.setEditable(false);
		DAOcoleta.txtDescricao.setBounds(361, 423, 313, 22);
		contentPane.add(DAOcoleta.txtDescricao);
		DAOcoleta.txtDescricao.setColumns(10);
		
		JLabel lblDataSolicitao = new JLabel("Data Solicita\u00E7\u00E3o:");
		lblDataSolicitao.setForeground(Color.WHITE);
		lblDataSolicitao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataSolicitao.setBounds(601, 380, 111, 16);
		contentPane.add(lblDataSolicitao);
		
		DAOcoleta.txtDataSolicitacao = new JTextField();
		DAOcoleta.txtDataSolicitacao.setForeground(Color.BLACK);
		DAOcoleta.txtDataSolicitacao.setBackground(Color.WHITE);
		DAOcoleta.txtDataSolicitacao.setEditable(false);
		DAOcoleta.txtDataSolicitacao.setBounds(361, 377, 224, 22);
		contentPane.add(DAOcoleta.txtDataSolicitacao);
		DAOcoleta.txtDataSolicitacao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Genero:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(717, 461, 56, 16);
		contentPane.add(lblNewLabel);
		
		DAOcoleta.txtGenero = new JTextField();
		DAOcoleta.txtGenero.setForeground(Color.BLACK);
		DAOcoleta.txtGenero.setBackground(Color.WHITE);
		DAOcoleta.txtGenero.setEditable(false);
		DAOcoleta.txtGenero.setBounds(785, 458, 127, 22);
		contentPane.add(DAOcoleta.txtGenero);
		DAOcoleta.txtGenero.setColumns(10);
		
		JLabel lblObservacao = new JLabel("Observacao :");
		lblObservacao.setForeground(Color.WHITE);
		lblObservacao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObservacao.setBounds(265, 523, 97, 16);
		contentPane.add(lblObservacao);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/BtnMenu.jpg")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		btnVoltar.setBounds(12, 591, 182, 52);
		contentPane.add(btnVoltar);
		
		JButton btnColetar = new JButton("");
		btnColetar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSolicicarColetas.jpg")));
		btnColetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				daoCOLETA.AGENDARCOLETA(coleta);
				daoCOLETA.INFORMACOESCOLETASOLICITADA(coleta);
				daoCOLETA.UPDATEMMULL_COL_AGENDADA(coleta);
				daoMULL.BuscaDadosmMuLL (mull);
				daoMENSAGEM.EnviarMensagemParaUsuario(mensagem);
				
				dispose();
				
			}
		});
		btnColetar.setBounds(12, 506, 182, 52);
		contentPane.add(btnColetar);
		
		JLabel lblDescrio = new JLabel("Faixa Etaria");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescrio.setBounds(265, 461, 76, 16);
		contentPane.add(lblDescrio);
		
		DAOcoleta.txtFaixaEtaria = new JTextField();
		DAOcoleta.txtFaixaEtaria.setForeground(Color.BLACK);
		DAOcoleta.txtFaixaEtaria.setBackground(Color.WHITE);
		DAOcoleta.txtFaixaEtaria.setEditable(false);
		DAOcoleta.txtFaixaEtaria.setBounds(361, 458, 310, 22);
		contentPane.add(DAOcoleta.txtFaixaEtaria);
		DAOcoleta.txtFaixaEtaria.setColumns(10);
		
		JLabel lblPeas = new JLabel("Pe\u00E7as:");
		lblPeas.setForeground(Color.WHITE);
		lblPeas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeas.setBounds(717, 426, 56, 16);
		contentPane.add(lblPeas);
		
		DAOcoleta.txtPcs = new JTextField();
		DAOcoleta.txtPcs.setForeground(Color.BLACK);
		DAOcoleta.txtPcs.setBackground(Color.WHITE);
		DAOcoleta.txtPcs.setEditable(false);
		DAOcoleta.txtPcs.setBounds(785, 423, 127, 22);
		contentPane.add(DAOcoleta.txtPcs);
		DAOcoleta.txtPcs.setColumns(10);
		
		DAOcoleta.txtData = new JTextField();
		DAOcoleta.txtData.setBackground(Color.WHITE);
		DAOcoleta.txtData.setForeground(Color.BLACK);
		DAOcoleta.txtData.setEditable(false);
		DAOcoleta.txtData.setBounds(438, 610, 127, 22);
		contentPane.add(DAOcoleta.txtData);
		DAOcoleta.txtData.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setForeground(Color.WHITE);
		lblPeriodo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeriodo.setBounds(717, 613, 56, 16);
		contentPane.add(lblPeriodo);
		
		DAOcoleta.txtPeriodo = new JTextField();
		DAOcoleta.txtPeriodo.setForeground(Color.BLACK);
		DAOcoleta.txtPeriodo.setBackground(Color.WHITE);
		DAOcoleta.txtPeriodo.setEditable(false);
		DAOcoleta.txtPeriodo.setBounds(817, 610, 85, 22);
		contentPane.add(DAOcoleta.txtPeriodo);
		DAOcoleta.txtPeriodo.setColumns(10);
		
		DAOcoleta.txtDia = new JTextField();
		DAOcoleta.txtDia.setForeground(Color.BLACK);
		DAOcoleta.txtDia.setBackground(Color.WHITE);
		DAOcoleta.txtDia.setEditable(false);
		DAOcoleta.txtDia.setBounds(578, 610, 116, 22);
		contentPane.add(DAOcoleta.txtDia);
		DAOcoleta.txtDia.setColumns(10);
		
		JLabel lblAgendarColetaPara = new JLabel("Agendar Coleta para:");
		lblAgendarColetaPara.setForeground(Color.WHITE);
		lblAgendarColetaPara.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAgendarColetaPara.setBounds(265, 613, 150, 16);
		contentPane.add(lblAgendarColetaPara);
		daoCOLETA.QuerymMuLLViewDetalhesRoupasEcalcados(coleta);
		DAOcoleta.txtPeriodo.setText(coleta.getHORARIO_JTABLE());
		DAOcoleta.txtCODmMuLL.setText(coleta.getCOD_mMuLL());
		DAOcoleta.txtDia.setText(coleta.getStringDia());
		DAOcoleta.txtData.setText(coleta.getDATACOLETA());
		
		JLabel lblInformaesSobreMll = new JLabel("Informa\u00E7\u00F5es sobre M\u00FCll :");
		lblInformaesSobreMll.setForeground(Color.WHITE);
		lblInformaesSobreMll.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformaesSobreMll.setBounds(504, 332, 263, 16);
		contentPane.add(lblInformaesSobreMll);
		
		JLabel lblEndereco_1 = new JLabel("Endereco :");
		lblEndereco_1.setForeground(Color.WHITE);
		lblEndereco_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEndereco_1.setBounds(543, 157, 111, 16);
		contentPane.add(lblEndereco_1);
		
		JLabel lblAgendarColetaPara_1 = new JLabel("Agendar Coleta para :");
		lblAgendarColetaPara_1.setForeground(Color.WHITE);
		lblAgendarColetaPara_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAgendarColetaPara_1.setBounds(504, 557, 222, 26);
		contentPane.add(lblAgendarColetaPara_1);
		DAOcoleta.txtObs.setBounds(361, 496, 547, 48);
		contentPane.add(DAOcoleta.txtObs);
		DAOcoleta.txtObs.setForeground(Color.BLACK);
		DAOcoleta.txtObs.setEditable(false);
		
		JLabel frame1 = new JLabel("");
		frame1.setBounds(0, 0, 1018, 133);
		contentPane.add(frame1);
		frame1.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/cabecalhoRoupas.jpg")));
		
		JLabel frame = new JLabel("");
		frame.setBounds(0, 0, 1018, 680);
		contentPane.add(frame);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/SolicitarColetaPedido.jpg")));
		daoCOLETA.QuerymMuLLViewDetalhesRoupasEcalcados(coleta);
	}
}
	


