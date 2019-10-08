package Empresa;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import beans.Mensagem;
import dao.DAOmensagem;
import login.menulogin;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class InicioEmpresa extends JFrame {

	private JPanel contentPane;
	int imagem = 0;
	int x =240;
	int y=240;
	int z=240;
	int mull =255;
	
	JButton btnMensagens = new JButton("");
	DAOmensagem daoMENSAGEM = new DAOmensagem();
	Mensagem mensagem = new Mensagem();
	//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioEmpresa frame = new InicioEmpresa();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InicioEmpresa() {
		
		setTitle("Menu Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(902, 237, 378, 330);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(29, 10, 320, 43);
		panel_1.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnColetasAgendadas.jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaPesquisaColetasAgendadas frame = new EmpresaPesquisaColetasAgendadas();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnIniciarColetas = new JButton("");
		btnIniciarColetas.setBounds(29, 63, 320, 43);
		panel_1.add(btnIniciarColetas);
		
		btnIniciarColetas.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnIniciarColetas.jpg")));
		
		
		btnMensagens.setBounds(29, 116, 320, 43);
		panel_1.add(btnMensagens);
		btnMensagens.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMensagens.jpg")));
		
		JButton btnSolicitarColeta = new JButton("");
		btnSolicitarColeta.setBounds(29, 169, 320, 43);
		panel_1.add(btnSolicitarColeta);
		btnSolicitarColeta.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnNovasColetas.jpg")));
		
		JButton btnMinhaConta = new JButton("");
		btnMinhaConta.setBounds(29, 222, 320, 43);
		panel_1.add(btnMinhaConta);
		btnMinhaConta.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMinhaConta.jpg")));
		
		JButton btnFechar = new JButton("");
		btnFechar.setBounds(29, 275, 320, 43);
		panel_1.add(btnFechar);
		
		btnFechar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				menulogin frame = new menulogin();
			dispose();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnFechar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
		
		btnMinhaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSolicitarColeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaProcurarColetas frame = new EmpresaProcurarColetas();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
				
			}
		});
		btnMensagens.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(mensagem.getNRO_MENSAGENS()+" NRO MENSAGENS");
				
				mensagem.setNRO_MENSAGENS(mensagem.getCX_MENSAGENS());
				
				daoMENSAGEM.UpdateMensagensCX(mensagem);
				
				EmpresaMensagens frame = new EmpresaMensagens();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		btnIniciarColetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmpresaParceiroIniciarColetas frame = new EmpresaParceiroIniciarColetas();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 237, 902, 330);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 878, 304);
		panel.add(scrollPane);
		
		JLabel framescrollpane = new JLabel("");
		scrollPane.setViewportView(framescrollpane);
		framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/fundoinicioEmpresa.jpg")));
		
		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/fundoinicioEmpresa.jpg")));
			}
		});
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnInicio.setBounds(98, 166, 99, 25);
		contentPane.add(btnInicio);
		
		
		JButton btnMull = new JButton("");
		btnMull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x=255;
				y=255;
				z=255;
				panel_1.setBackground(new Color(mull, mull, mull));
				
			}
		});
		btnMull.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnMull.setBounds(893, 144, 93, 71);
		contentPane.add(btnMull);
		
		JButton btnMenu = new JButton("");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int color = 0;
				
				panel_1.setBackground(new Color(x, y, z));
				color= color+20;
				x= x-color;
				y=y-color;
				z=z-color;
				
				
			}
		});
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnMenu.setBounds(1028, 166, 99, 25);
		contentPane.add(btnMenu);
		
		JButton btnmanual = new JButton("");
		btnmanual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/manualmull2.jpg")));
			}
		});
		btnmanual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnmanual.setBounds(407, 166, 138, 25);
		contentPane.add(btnmanual);
		btnmanual.setOpaque(true);
		btnmanual.setContentAreaFilled(false);
		btnmanual.setBorderPainted(false);
		btnmanual.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel frame_1 = new JLabel("");
		frame_1.setBounds(0, 0, 1280, 670);
		contentPane.add(frame_1);
		frame_1.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/FundoInicial.jpg")));
		
		btnInicio.setOpaque(true);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.setBackground(Color.DARK_GRAY);
		
		btnMull.setOpaque(true);
		btnMull.setContentAreaFilled(false);
		btnMull.setBorderPainted(false);
		btnMull.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		btnMenu.setOpaque(true);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		daoMENSAGEM.SelectNROmensagens(mensagem);
		daoMENSAGEM.selectMensagensAntes(mensagem);
		VerificacaoMensagens();
		System.out.println(mensagem.getCX_MENSAGENS()+" CX_MENSAGENS");
		System.out.println(mensagem.getNRO_MENSAGENS() +"NRO_MENSAGENS");
		
		}
		public void VerificacaoMensagens(){
			
			if (mensagem.getCX_MENSAGENS()>mensagem.getNRO_MENSAGENS()){
				btnMensagens.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnNovasMensagens.jpg")));
			}else btnMensagens.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMensagens.jpg")));
			//
		}
	}
	
	

