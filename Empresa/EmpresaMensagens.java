package Empresa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import Aconexao.conexao;
import abstractTableModel.ModeloTabela;
import beans.Mensagem;
import beans.Mull;
import dao.DAOcoleta;
import dao.DAOmensagem;
import dao.DAOmull;
import login.menulogin;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.Color;

public class EmpresaMensagens extends JFrame {

	JCheckBox cbx1 = new JCheckBox("");
	private JPanel contentPane;
	
	
	
	
	
	
	Mull mull = new Mull();
	DAOmensagem daoMENSAGEM = new DAOmensagem();
	Mensagem mensagem = new Mensagem();
	DAOmull daoMULL = new DAOmull();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaMensagens frame = new EmpresaMensagens();
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

	public EmpresaMensagens() {
		
		setTitle("Agendar Coleta  - Eletronico");
		ImageIcon ImageIcon = new ImageIcon("src/resources/icone.png");
		Image Image = ImageIcon.getImage();
		this.setIconImage(Image);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(390, 593, 852, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		btnExcluirMensagem.setBounds(248, -5, 355, 55);
		panel_1.add(btnExcluirMensagem);
		btnExcluirMensagem.setBackground(Color.DARK_GRAY);
		btnExcluirMensagem.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnExcluirMensagem.jpg")));
		btnExcluirMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				daoMENSAGEM.SelectNROmensagens(mensagem);
				daoMENSAGEM.UpdateMensagensCXexclusao(mensagem);
				
				
				getCODMensagem();
				
				
				daoMENSAGEM.ExcluirMensagemCaixadeEntradaEmpresaInstituicao(mensagem);
				
				daoMENSAGEM.QueryCaixadeEntradaMensagensInstituicao(mensagem);
				
				
				ApagarCamposMensagens();
				DAOmensagem.tblConsulta.setRowSelectionInterval(0, 0);

			}
		});

		cbx1.setBounds(0, 0, 0, 0);

		contentPane.add(cbx1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(390, 37, 843, 243);
		contentPane.add(scrollPane);
		DAOmensagem.tblConsulta = new JTable();
		DAOmensagem.tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ApagarCamposMensagens();
				getCODMensagem();
				daoMENSAGEM.QuerygetTextMensagensEmpresa(mensagem);
				mull.setDES_TAB(mensagem.getDES_TAB());
				mull.setCOD_MULL(mensagem.getCOD_mMuLL());
				System.out.println(mull.getDES_TAB());
				daoMULL.QuerymMuLLViewDetalhesEmpresaMull(mull);
				System.out.println(mull.getQuerySelect());
				daoMULL.outro(mull);
				
				DAOmensagem.txtPeso.setText(mull.getTxtPeso());
				DAOmensagem.txtPcs.setText(mull.getTxtPeças());
				DAOmensagem.txtObs.setText(mull.getTxtobservacao());
				DAOmensagem.txtDescricao.setText(mull.getTxtDescrição());
				DAOmensagem.txtFaixaEtaria.setText("");
			}
		});
		DAOmensagem.tblConsulta.setShowVerticalLines(false);
		DAOmensagem.tblConsulta.setShowHorizontalLines(false);
		DAOmensagem.tblConsulta.setShowGrid(false);

		scrollPane.setViewportView(DAOmensagem.tblConsulta);

		JButton btnSair = new JButton("");
		btnSair.setBounds(31, 593, 320, 45);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioEmpresa frame = new InicioEmpresa();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}

		});

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(390, 291, 852, 304);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblRemetente = new JLabel("Remetente");
		lblRemetente.setBounds(0, 17, 81, 29);
		panel.add(lblRemetente);
		lblRemetente.setForeground(Color.WHITE);
		lblRemetente.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(0, 64, 68, 16);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescrio.setForeground(Color.WHITE);

		JLabel lblIdMull = new JLabel("Id MuLL");
		lblIdMull.setBounds(647, 64, 74, 16);
		panel.add(lblIdMull);
		lblIdMull.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdMull.setForeground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("Pe\u00E7as");
		lblNewLabel.setBounds(278, 105, 68, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblGenero = new JLabel("Peso");
		lblGenero.setBounds(537, 105, 56, 16);
		panel.add(lblGenero);
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblObservaes = new JLabel("Observa\u00E7\u00F5es ");
		lblObservaes.setBounds(0, 163, 102, 16);
		panel.add(lblObservaes);
		lblObservaes.setForeground(Color.WHITE);
		lblObservaes.setFont(new Font("Tahoma", Font.BOLD, 13));
		DAOmensagem.txtRemetente = new JTextField();
		DAOmensagem.txtRemetente.setBounds(93, 21, 220, 20);
		panel.add(DAOmensagem.txtRemetente);
		DAOmensagem.txtRemetente.setBackground(Color.WHITE);
		DAOmensagem.txtRemetente.setEditable(false);
		DAOmensagem.txtRemetente.setForeground(Color.BLACK);
		DAOmensagem.txtRemetente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtRemetente.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtRemetente.setColumns(10);
		DAOmensagem.txtDESCRICAOmMULL = new JTextField();
		DAOmensagem.txtDESCRICAOmMULL.setBounds(93, 62, 171, 20);
		panel.add(DAOmensagem.txtDESCRICAOmMULL);
		DAOmensagem.txtDESCRICAOmMULL.setBackground(Color.WHITE);
		DAOmensagem.txtDESCRICAOmMULL.setEditable(false);
		DAOmensagem.txtDESCRICAOmMULL.setForeground(Color.BLACK);
		DAOmensagem.txtDESCRICAOmMULL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtDESCRICAOmMULL.setBorder(BorderFactory.createEmptyBorder());

		DAOmensagem.txtDESCRICAOmMULL.setColumns(10);
		DAOmensagem.txtID_mMULL = new JTextField();
		DAOmensagem.txtID_mMULL.setBounds(705, 62, 130, 20);
		panel.add(DAOmensagem.txtID_mMULL);
		DAOmensagem.txtID_mMULL.setBackground(Color.WHITE);
		DAOmensagem.txtID_mMULL.setEditable(false);
		DAOmensagem.txtID_mMULL.setForeground(Color.BLACK);
		DAOmensagem.txtID_mMULL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtID_mMULL.setBorder(BorderFactory.createEmptyBorder());

		DAOmensagem.txtID_mMULL.setColumns(10);

		DAOmensagem.txtPcs = new JTextField();
		DAOmensagem.txtPcs.setBounds(348, 102, 68, 22);
		panel.add(DAOmensagem.txtPcs);
		DAOmensagem.txtPcs.setColumns(10);
		DAOmensagem.txtPcs.setEditable(false);
		DAOmensagem.txtPcs.setBackground(Color.WHITE);
		DAOmensagem.txtPcs.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtPcs.setForeground(Color.BLACK);

		DAOmensagem.txtPeso = new JTextField();
		DAOmensagem.txtPeso.setBounds(580, 102, 251, 22);
		panel.add(DAOmensagem.txtPeso);
		DAOmensagem.txtPeso.setColumns(10);
		DAOmensagem.txtPeso.setEditable(false);
		DAOmensagem.txtPeso.setBackground(Color.WHITE);
		DAOmensagem.txtPeso.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtPeso.setForeground(Color.BLACK);

		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(320, 23, 59, 16);
		panel.add(lblAssunto);
		lblAssunto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAssunto.setForeground(Color.WHITE);

		JLabel lblSolicitaoFeita = new JLabel("Solicita\u00E7\u00E3o feita");
		lblSolicitaoFeita.setBounds(277, 64, 111, 16);
		panel.add(lblSolicitaoFeita);
		lblSolicitaoFeita.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSolicitaoFeita.setForeground(Color.WHITE);

		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio_1.setBounds(0, 105, 102, 16);
		panel.add(lblDescrio_1);
		lblDescrio_1.setForeground(Color.WHITE);
		lblDescrio_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblRecebidoEm = new JLabel("Recebido");
		lblRecebidoEm.setBounds(598, 23, 81, 16);
		panel.add(lblRecebidoEm);
		lblRecebidoEm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecebidoEm.setForeground(Color.WHITE);
		DAOmensagem.txtAssunto = new JTextField();
		DAOmensagem.txtAssunto.setBounds(386, 21, 200, 20);
		panel.add(DAOmensagem.txtAssunto);
		DAOmensagem.txtAssunto.setBackground(Color.WHITE);
		DAOmensagem.txtAssunto.setEditable(false);
		DAOmensagem.txtAssunto.setForeground(Color.BLACK);
		DAOmensagem.txtAssunto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtAssunto.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtAssunto.setColumns(10);
		DAOmensagem.txtDATAminhaSOlicitacao = new JTextField();
		DAOmensagem.txtDATAminhaSOlicitacao.setBounds(386, 62, 134, 20);
		panel.add(DAOmensagem.txtDATAminhaSOlicitacao);
		DAOmensagem.txtDATAminhaSOlicitacao.setBackground(Color.WHITE);
		DAOmensagem.txtDATAminhaSOlicitacao.setEditable(false);
		DAOmensagem.txtDATAminhaSOlicitacao.setForeground(Color.BLACK);
		DAOmensagem.txtDATAminhaSOlicitacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtDATAminhaSOlicitacao.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtDATAminhaSOlicitacao.setBorder(BorderFactory.createEmptyBorder());

		DAOmensagem.txtDATAminhaSOlicitacao.setColumns(10);
		DAOmensagem.txtHoraMinhaSOlicitacao = new JTextField();
		DAOmensagem.txtHoraMinhaSOlicitacao.setBounds(536, 62, 109, 20);
		panel.add(DAOmensagem.txtHoraMinhaSOlicitacao);
		DAOmensagem.txtHoraMinhaSOlicitacao.setBackground(Color.WHITE);
		DAOmensagem.txtHoraMinhaSOlicitacao.setEditable(false);
		DAOmensagem.txtHoraMinhaSOlicitacao.setForeground(Color.BLACK);
		DAOmensagem.txtHoraMinhaSOlicitacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtHoraMinhaSOlicitacao.setBorder(BorderFactory.createEmptyBorder());

		DAOmensagem.txtHoraMinhaSOlicitacao.setColumns(10);

		DAOmensagem.txtDescricao = new JTextField();
		DAOmensagem.txtDescricao.setBounds(93, 102, 172, 22);
		panel.add(DAOmensagem.txtDescricao);
		DAOmensagem.txtDescricao.setColumns(10);
		DAOmensagem.txtDescricao.setEditable(false);
		DAOmensagem.txtDescricao.setBackground(Color.WHITE);
		DAOmensagem.txtDescricao.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtDescricao.setForeground(Color.BLACK);

		
		DAOmensagem.txtDAtAMSG = new JTextField();
		DAOmensagem.txtDAtAMSG.setBounds(667, 21, 81, 20);
		panel.add(DAOmensagem.txtDAtAMSG);
		DAOmensagem.txtDAtAMSG.setBackground(Color.WHITE);
		DAOmensagem.txtDAtAMSG.setEditable(false);
		DAOmensagem.txtDAtAMSG.setForeground(Color.BLACK);
		DAOmensagem.txtDAtAMSG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtDAtAMSG.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtDAtAMSG.setColumns(10);
		DAOmensagem.txtHoraMSG = new JTextField();
		DAOmensagem.txtHoraMSG.setBounds(760, 21, 75, 20);
		panel.add(DAOmensagem.txtHoraMSG);
		DAOmensagem.txtHoraMSG.setBackground(Color.WHITE);
		DAOmensagem.txtHoraMSG.setEditable(false);
		DAOmensagem.txtHoraMSG.setForeground(Color.BLACK);
		DAOmensagem.txtHoraMSG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DAOmensagem.txtHoraMSG.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.txtHoraMSG.setColumns(10);

		DAOmensagem.txtObs = new JTextArea();
		DAOmensagem.txtObs.setBounds(93, 149, 742, 43);
		panel.add(DAOmensagem.txtObs);
		DAOmensagem.txtObs.setBackground(Color.WHITE);
		DAOmensagem.txtObs.setForeground(Color.BLACK);
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.WHITE);
		lblMensagem.setFont(new Font("Roboto", Font.BOLD, 14));
		lblMensagem.setBounds(0, 220, 81, 16);
		panel.add(lblMensagem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(93, 220, 738, 79);
		panel.add(scrollPane_1);
		
		DAOmensagem.txtMsg = new JTextArea();
		scrollPane_1.setViewportView(DAOmensagem.txtMsg);
		
		contentPane.add(btnSair);
		frame = new JLabel("");
		frame.setBackground(Color.DARK_GRAY);

		frame.setBounds(0, 0, 1280, 670);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/modeloPaginaMensagem.jpg")));
		contentPane.add(frame);
		
		
		
		
		daoMENSAGEM.QueryCaixadeEntradaMensagensInstituicao(mensagem);
		DAOmensagem.tblConsulta.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.tblConsulta.setOpaque(true);
		DAOmensagem.tblConsulta.setForeground(Color.BLACK);

		
		
	
		
		
		
		
		
		
		scrollPane.setOpaque(true);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
	}

	DefaultTableModel tabela = new DefaultTableModel(null,
			new String[] { "Remetente", "Assunto", "Recebido :", "Status", "", "", "", "" });

	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final JButton btnExcluirMensagem = new JButton("");
	private JLabel frame;

	private JLabel frame1;
	private JLabel lblObservaes;
	private JPanel panel;

	public void getCODMensagem() {
		int a = 0;
		a = DAOmensagem.tblConsulta.getSelectedRow();

		mensagem.setCOD_MENSAGEM((String) (DAOmensagem.tblConsulta.getValueAt(a, 0)));
		mensagem.setCOD_mMuLL((String) (DAOmensagem.tblConsulta.getValueAt(a, 1)));

	}

	public void ApagarCamposMensagens() {
		DAOmensagem.txtHoraMSG.setText("");
		DAOmensagem.txtDAtAMSG.setText("");
		DAOmensagem.txtRemetente.setText("");
		DAOmensagem.txtMsg.setText("");
		DAOmensagem.txtID_mMULL.setText("");
		DAOmensagem.txtDATAminhaSOlicitacao.setText("");
		DAOmensagem.txtHoraMinhaSOlicitacao.setText("");
		DAOmensagem.txtAssunto.setText("");
		DAOmensagem.txtDESCRICAOmMULL.setText("");
		DAOmensagem.txtPcs.setText("");
		DAOmensagem.txtPeso.setText("");
		DAOmensagem.txtDescricao.setText("");
		DAOmensagem.txtObs.setText("");
	}
}
