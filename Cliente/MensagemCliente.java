package Cliente;


import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import beans.Mull;
import beansCliente.cMensagem;
import beansCliente.cUsuario;
import dao.DAOmensagem;
import dao.DAOmull;
import daoCliente.cDAOmensagem;
import login.menulogin;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;

public class MensagemCliente extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JCheckBox cbx1 = new JCheckBox("");
	private JPanel contentPane;
	
	
	
	
	
	
	Mull mull = new Mull();
	cDAOmensagem daoMENSAGEM =  new cDAOmensagem();
	cMensagem Cmensagem = new cMensagem();
	DAOmull daoMULL = new DAOmull();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MensagemCliente frame = new MensagemCliente();
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

	public MensagemCliente() {
		
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

		cbx1.setBounds(0, 0, 0, 0);

		contentPane.add(cbx1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(390, 37, 843, 243);
		contentPane.add(scrollPane);
		cDAOmensagem.tblConsulta = new JTable();
		cDAOmensagem.tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ApagarCamposMensagens();
				getCODMensagem();
				daoMENSAGEM.QueryMensagensgetTextCliente(Cmensagem);
			
				
					
				
			
			}
		});
		cDAOmensagem.tblConsulta.setShowVerticalLines(false);
		cDAOmensagem.tblConsulta.setShowHorizontalLines(false);
		cDAOmensagem.tblConsulta.setShowGrid(false);

		scrollPane.setViewportView(cDAOmensagem.tblConsulta);

		JButton btnSair = new JButton("");
		btnSair.setBounds(25, 593, 320, 45);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioCliente frame = new InicioCliente();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}

		});

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(399, 291, 843, 304);
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
		cDAOmensagem.txtRemetente = new JTextField();
		cDAOmensagem.txtRemetente.setBounds(93, 21, 220, 20);
		panel.add(cDAOmensagem.txtRemetente);
		cDAOmensagem.txtRemetente.setBackground(Color.WHITE);
		cDAOmensagem.txtRemetente.setEditable(false);
		cDAOmensagem.txtRemetente.setForeground(Color.BLACK);
		cDAOmensagem.txtRemetente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtRemetente.setBorder(BorderFactory.createEmptyBorder());
		cDAOmensagem.txtRemetente.setColumns(10);
		cDAOmensagem.txtDESCRICAOmMULL = new JTextField();
		cDAOmensagem.txtDESCRICAOmMULL.setBounds(93, 62, 171, 20);
		panel.add(cDAOmensagem.txtDESCRICAOmMULL);
		cDAOmensagem.txtDESCRICAOmMULL.setBackground(Color.WHITE);
		cDAOmensagem.txtDESCRICAOmMULL.setEditable(false);
		cDAOmensagem.txtDESCRICAOmMULL.setForeground(Color.BLACK);
		cDAOmensagem.txtDESCRICAOmMULL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtDESCRICAOmMULL.setBorder(BorderFactory.createEmptyBorder());

		cDAOmensagem.txtDESCRICAOmMULL.setColumns(10);
		cDAOmensagem.txtID_mMULL = new JTextField();
		cDAOmensagem.txtID_mMULL.setBounds(705, 62, 130, 20);
		panel.add(cDAOmensagem.txtID_mMULL);
		cDAOmensagem.txtID_mMULL.setBackground(Color.WHITE);
		cDAOmensagem.txtID_mMULL.setEditable(false);
		cDAOmensagem.txtID_mMULL.setForeground(Color.BLACK);
		cDAOmensagem.txtID_mMULL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtID_mMULL.setBorder(BorderFactory.createEmptyBorder());

		cDAOmensagem.txtID_mMULL.setColumns(10);

		

		

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

		JLabel lblRecebidoEm = new JLabel("Recebido");
		lblRecebidoEm.setBounds(598, 23, 81, 16);
		panel.add(lblRecebidoEm);
		lblRecebidoEm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecebidoEm.setForeground(Color.WHITE);
		cDAOmensagem.txtAssunto = new JTextField();
		cDAOmensagem.txtAssunto.setBounds(386, 21, 200, 20);
		panel.add(cDAOmensagem.txtAssunto);
		cDAOmensagem.txtAssunto.setBackground(Color.WHITE);
		cDAOmensagem.txtAssunto.setEditable(false);
		cDAOmensagem.txtAssunto.setForeground(Color.BLACK);
		cDAOmensagem.txtAssunto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtAssunto.setBorder(BorderFactory.createEmptyBorder());
		cDAOmensagem.txtAssunto.setColumns(10);
		cDAOmensagem.txtDATAminhaSOlicitacao = new JTextField();
		cDAOmensagem.txtDATAminhaSOlicitacao.setBounds(386, 62, 134, 20);
		panel.add(cDAOmensagem.txtDATAminhaSOlicitacao);
		cDAOmensagem.txtDATAminhaSOlicitacao.setBackground(Color.WHITE);
		cDAOmensagem.txtDATAminhaSOlicitacao.setEditable(false);
		cDAOmensagem.txtDATAminhaSOlicitacao.setForeground(Color.BLACK);
		cDAOmensagem.txtDATAminhaSOlicitacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtDATAminhaSOlicitacao.setBorder(BorderFactory.createEmptyBorder());
		cDAOmensagem.txtDATAminhaSOlicitacao.setBorder(BorderFactory.createEmptyBorder());

		cDAOmensagem.txtDATAminhaSOlicitacao.setColumns(10);
		cDAOmensagem.txtHoraMinhaSOlicitacao = new JTextField();
		cDAOmensagem.txtHoraMinhaSOlicitacao.setBounds(536, 62, 109, 20);
		panel.add(cDAOmensagem.txtHoraMinhaSOlicitacao);
		cDAOmensagem.txtHoraMinhaSOlicitacao.setBackground(Color.WHITE);
		cDAOmensagem.txtHoraMinhaSOlicitacao.setEditable(false);
		cDAOmensagem.txtHoraMinhaSOlicitacao.setForeground(Color.BLACK);
		cDAOmensagem.txtHoraMinhaSOlicitacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtHoraMinhaSOlicitacao.setBorder(BorderFactory.createEmptyBorder());

		cDAOmensagem.txtHoraMinhaSOlicitacao.setColumns(10);

	

		
		cDAOmensagem.txtDAtAMSG = new JTextField();
		cDAOmensagem.txtDAtAMSG.setBounds(667, 21, 81, 20);
		panel.add(cDAOmensagem.txtDAtAMSG);
		cDAOmensagem.txtDAtAMSG.setBackground(Color.WHITE);
		cDAOmensagem.txtDAtAMSG.setEditable(false);
		cDAOmensagem.txtDAtAMSG.setForeground(Color.BLACK);
		cDAOmensagem.txtDAtAMSG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtDAtAMSG.setBorder(BorderFactory.createEmptyBorder());
		cDAOmensagem.txtDAtAMSG.setColumns(10);
		cDAOmensagem.txtHoraMSG = new JTextField();
		cDAOmensagem.txtHoraMSG.setBounds(760, 21, 75, 20);
		panel.add(cDAOmensagem.txtHoraMSG);
		cDAOmensagem.txtHoraMSG.setBackground(Color.WHITE);
		cDAOmensagem.txtHoraMSG.setEditable(false);
		cDAOmensagem.txtHoraMSG.setForeground(Color.BLACK);
		cDAOmensagem.txtHoraMSG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cDAOmensagem.txtHoraMSG.setBorder(BorderFactory.createEmptyBorder());
		cDAOmensagem.txtHoraMSG.setColumns(10);

		cDAOmensagem.txtObs = new JTextArea();
		cDAOmensagem.txtObs.setBounds(93, 149, 742, 43);
		panel.add(cDAOmensagem.txtObs);
		cDAOmensagem.txtObs.setBackground(Color.WHITE);
		cDAOmensagem.txtObs.setForeground(Color.BLACK);
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.WHITE);
		lblMensagem.setFont(new Font("Roboto", Font.BOLD, 14));
		lblMensagem.setBounds(0, 244, 81, 16);
		panel.add(lblMensagem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(93, 154, 738, 137);
		panel.add(scrollPane_1);
		
		cDAOmensagem.txtMsg = new JTextArea();
		scrollPane_1.setViewportView(cDAOmensagem.txtMsg);
		
		contentPane.add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(398, 593, 844, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		btnExcluirMensagem.setBounds(281, 0, 320, 45);
		panel_1.add(btnExcluirMensagem);
		btnExcluirMensagem.setBackground(Color.DARK_GRAY);
		btnExcluirMensagem.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnExcluirMensagem.jpg")));
		btnExcluirMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoMENSAGEM.SelectNROmensagens(Cmensagem);
				daoMENSAGEM.UpdateMensagensCXexclusao(Cmensagem);
				
				getCODMensagem();
				
				
				daoMENSAGEM.ExcluirMensagem(Cmensagem);
				daoMENSAGEM.QueryMensagensCliente();
				ApagarCamposMensagens();
				cDAOmensagem.tblConsulta.setRowSelectionInterval(0, 0);

			}
		});
		frame = new JLabel("");
		frame.setBackground(Color.DARK_GRAY);

		frame.setBounds(0, 0, 1280, 670);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/modeloPaginaMensagem.jpg")));
		contentPane.add(frame);
		
		
		
		
		daoMENSAGEM.QueryMensagensCliente();
	/*	DAOmensagem.tblConsulta.setBorder(BorderFactory.createEmptyBorder());
		DAOmensagem.tblConsulta.setOpaque(true);
		DAOmensagem.tblConsulta.setForeground(Color.BLACK);
		
*/
		
		
	
		
		
		
		
		
		
		scrollPane.setOpaque(true);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
	
	}

	
	@SuppressWarnings("unused")
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	@SuppressWarnings("unused")
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final JButton btnExcluirMensagem = new JButton("");
	private JLabel frame;

	@SuppressWarnings("unused")
	private JLabel frame1;
	private JPanel panel;

	public void getCODMensagem() {
		int a = 0;
		a = cDAOmensagem.tblConsulta.getSelectedRow();

		Cmensagem.setCOD_MENSAGEM((String) (cDAOmensagem.tblConsulta.getValueAt(a, 4)));
		Cmensagem.setCOD_mMuLL((String) (cDAOmensagem.tblConsulta.getValueAt(a, 6)));
		Cmensagem.setCOD_MENSAGEM_USUARIO((String) cDAOmensagem.tblConsulta.getValueAt(a, 4));
	System.out.println(Cmensagem.getCOD_MENSAGEM());

	}

	public void ApagarCamposMensagens() {
		
		
		cDAOmensagem.txtHoraMSG.setText("");
		cDAOmensagem.txtDAtAMSG.setText("");
		cDAOmensagem.txtRemetente.setText("");
		cDAOmensagem.txtMsg.setText("");
		cDAOmensagem.txtID_mMULL.setText("");
		cDAOmensagem.txtDATAminhaSOlicitacao.setText("");
		cDAOmensagem.txtHoraMinhaSOlicitacao.setText("");
		cDAOmensagem.txtAssunto.setText("");
		cDAOmensagem.txtDESCRICAOmMULL.setText("");
	}
	
}
