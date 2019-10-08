package login;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Cadastro.cadastroEmpresa;
import Cadastro.cadastroInstituicao;
import Cadastro.cadastroUsuario;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NovoUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoUsuario frame = new NovoUsuario();
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
	public NovoUsuario() {
		setTitle("Cadastre-se");
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel framescrollpane = new JLabel("");
		setResizable(true);
		setBounds(0, 0, 1290, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		JButton btnComoFunciona = new JButton("");
		btnComoFunciona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnComoFunciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/manualmull1.jpg")));
			}
		});
		btnComoFunciona.setBounds(979, 150, 173, 47);
		contentPane.add(btnComoFunciona);
		
		JButton btnQuemSomos = new JButton("");
		btnQuemSomos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		btnQuemSomos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/frameNovoUsuario.jpg")));
			}
		});
		btnQuemSomos.setBounds(71, 150, 173, 47);
		contentPane.add(btnQuemSomos);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 467, 1280, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		//btnUsuario.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnNovoUsuarioMenu.jpg")));
		
		JButton btnEmpresa = new JButton("");
		btnEmpresa.setBounds(480, 12, 320, 112);
		panel.add(btnEmpresa);
		
		JButton btnSair = new JButton("");
		btnSair.setBounds(480, 136, 320, 45);
		panel.add(btnSair);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharLogin.jpg")));
		JButton btnCliente = new JButton("");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroUsuario frame = new cadastroUsuario();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnCliente.setBounds(880, 12, 320, 112);
		panel.add(btnCliente);
		btnCliente.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnUsuarioCliente.jpg")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(80, 12, 320, 112);
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnInstituicao.jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroInstituicao frame = new cadastroInstituicao();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroEmpresa frame = new cadastroEmpresa();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnEmpresa.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnEmpresa.jpg")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 224, 1280, 153);
		contentPane.add(scrollPane);
		
	
		scrollPane.setViewportView(framescrollpane);
		
		JLabel frame = new JLabel("");
		frame.setBounds(0, 0, 1280, 670);
		contentPane.add(frame);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/MenuNovoUsuario.jpg")));
		
		btnComoFunciona.setOpaque(true);
		btnComoFunciona.setContentAreaFilled(false);
		btnComoFunciona.setBorderPainted(false);
		btnComoFunciona.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnQuemSomos.setOpaque(true);
		btnQuemSomos.setContentAreaFilled(false);
		btnQuemSomos.setBorderPainted(false);
		btnQuemSomos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		framescrollpane.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/frameNovoUsuario.jpg")));
	}
	}

