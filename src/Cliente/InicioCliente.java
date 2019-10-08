package Cliente;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import beansCliente.cMensagem;
import daoCliente.cDAOmensagem;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class InicioCliente extends JFrame {

	private JPanel contentPane;
	int x =240;
	int y=240;
	int z=240;
	int mull =255;
	JButton btnMensagens = new JButton("");
	cDAOmensagem daoMENSAGEM = new cDAOmensagem();
	cMensagem  Cmensagem = new cMensagem();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioCliente frame = new InicioCliente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InicioCliente() {
		java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Cliente - Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(0, 0, 1290, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		JLabel framescrollpane = new JLabel("");
		
		
		
	
		JButton btnInicio = new JButton("");
	
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/testeframe.jpg")));
				
			}
		});
		
		
		JButton btnManual = new JButton("");
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/manualmull2.jpg")));
			}
		});
		
			
			
			
	
		btnManual.setBounds(388, 169, 189, 25);
		contentPane.add(btnManual);
		btnManual.setOpaque(true);
		btnManual.setContentAreaFilled(false);
		btnManual.setBorderPainted(false);
		btnManual.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		
		btnInicio.setBounds(104, 160, 99, 34);
		contentPane.add(btnInicio);
		JButton button = new JButton("");
		
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setOpaque(true);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBounds(1031, 169, 99, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		
		button_1.setBounds(901, 135, 81, 75);
		contentPane.add(button_1);
		button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button_1.setOpaque(true);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 239, 904, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 878, 311);
		panel.add(scrollPane);
		
		
		scrollPane.setViewportView(framescrollpane);
		framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/testeframe.jpg")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(901, 239, 403, 350);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnMinhaConta = new JButton("");
		btnMinhaConta.setBounds(41, 225, 320, 43);
		panel_1.add(btnMinhaConta);
		btnMinhaConta.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMinhaConta.jpg")));
		
		JButton btnFechar = new JButton("");
		btnFechar.setBounds(41, 292, 320, 43);
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
		btnFechar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharLogin.jpg")));
		
		JButton btnGerenciarMull = new JButton("");
		btnGerenciarMull.setBounds(41, 158, 320, 43);
		panel_1.add(btnGerenciarMull);
		btnGerenciarMull.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnGerenciarMüll.jpg")));
		
		
		btnMensagens.setBounds(41, 91, 320, 43);
		panel_1.add(btnMensagens);
		btnMensagens.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMensagens.jpg")));
		
		JButton btnSolicitarColeta = new JButton("");
		btnSolicitarColeta.setBounds(41, 24, 320, 43);
		panel_1.add(btnSolicitarColeta);
		btnSolicitarColeta.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSolicitarColeta.jpg")));
		btnSolicitarColeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SolicitarColetaCliente frame = new SolicitarColetaCliente();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
				
			}
		});
		btnSolicitarColeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMensagens.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Cmensagem.setNRO_MENSAGENS(Cmensagem.getCX_MENSAGENS());
				daoMENSAGEM.UpdateMensagensCX(Cmensagem);
				MensagemCliente frame = new MensagemCliente();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				
			}
		});
		btnGerenciarMull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarMull frame = new GerenciarMull();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
				
			}
		});
		
		btnMinhaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JLabel frame_1 = new JLabel("");
		frame_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		frame_1.setBounds(0, 0, 1280,670);
		contentPane.add(frame_1);
		frame_1.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/FundoInicial.jpg")));
	btnInicio.setOpaque(true);
	btnInicio.setContentAreaFilled(false);
	btnInicio.setBorderPainted(false);
	btnInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int color = 0;
			
			panel_1.setBackground(new Color(x, y, z));
			color= color+20;
			x= x-color;
			y=y-color;
			z=z-color;
			
		}
	});
	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			x=255;
			y=255;
			z=255;
			panel_1.setBackground(new Color(mull, mull, mull));
		}
	});
	button_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
		}
	});
	daoMENSAGEM.SelectNROmensagens(Cmensagem);
	daoMENSAGEM.selectMensagensAntes(Cmensagem);
	VerificacaoMensagens();
	System.out.println(Cmensagem.getCX_MENSAGENS()+" CX_MENSAGENS");
	System.out.println(Cmensagem.getNRO_MENSAGENS() +"NRO_MENSAGENS");
	
	}
	public void VerificacaoMensagens(){
		
		if (Cmensagem.getCX_MENSAGENS()>Cmensagem.getNRO_MENSAGENS()){
			btnMensagens.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnNovasMensagens.jpg")));
		}else btnMensagens.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMensagens.jpg")));
		//
	}
	
	
}
