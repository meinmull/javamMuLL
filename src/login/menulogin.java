package login;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import beans.Login;
import beans.Usuario;
import dao.DAOlogin;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class menulogin extends JFrame {

	private JPanel contentPane;
	Login login = new Login();
	Usuario usuario = new Usuario();
	DAOlogin daoLOGIN = new DAOlogin();
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menulogin frame = new menulogin();
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
	public menulogin() {
		java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);
		setBounds(0, 0, 1290, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnFechar = new JButton("");

		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 642, 1290, 92);
		contentPane.add(panel_1);

		JPanel panel = new JPanel();
		panel.setBounds(925, 0, 349, 640);
		contentPane.add(panel);
		panel.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(21, 149, 316, 45);
		panel.add(txtUsuario);
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Roboto Thin", Font.PLAIN, 23));
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(21, 257, 316, 45);
		panel.add(txtSenha);
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setFont(new Font("Roboto Thin", Font.BOLD, 20));

		JButton btnEntrar = new JButton("");
		btnEntrar.setBounds(21, 399, 320, 45);
		panel.add(btnEntrar);
		btnEntrar.setBackground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		btnEntrar.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 13));

		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					login.setEMA_USUARIO(txtUsuario.getText());
					login.setSEN_DIGITADA(txtSenha.getText());
					daoLOGIN.LoginEmpresa(login);
					daoLOGIN.LoginUSUARIO(login);

					;

					dispose();

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Senha Ou Usuario Inválido");
				}

			}
		});
		btnEntrar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnEntrarLogin.jpg")));

		JButton btnSair = new JButton("");
		btnSair.setBounds(21, 498, 320, 45);
		panel.add(btnSair);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharLogin.jpg")));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		lblEmail.setBounds(21, 112, 107, 24);
		panel.add(lblEmail);

		JLabel lblSenha = new JLabel("senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		lblSenha.setBounds(21, 220, 80, 24);
		panel.add(lblSenha);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 349, 664);
		panel.add(label);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(925, 536, 71, 53);
		btnFechar.setBorderPainted(false);
		btnFechar.setContentAreaFilled(false);
		btnFechar.setFocusPainted(false);
		btnFechar.setOpaque(false);
		contentPane.add(btnFechar);

		JButton btnFace = new JButton("");
		btnFace.setBounds(164, 642, 30, 30);
		btnFace.setBorderPainted(false);
		btnFace.setContentAreaFilled(false);
		btnFace.setFocusPainted(false);
		btnFace.setOpaque(false);
		contentPane.add(btnFace);

		JButton btnIntagram = new JButton("");
		btnIntagram.setBounds(107, 642, 30, 30);
		btnIntagram.setBorderPainted(false);
		btnIntagram.setContentAreaFilled(false);
		btnIntagram.setFocusPainted(false);
		btnIntagram.setOpaque(false);
		contentPane.add(btnIntagram);

		JButton btntwicth = new JButton("");
		btntwicth.setBounds(50, 642, 30, 30);
		btntwicth.setBorderPainted(false);
		btntwicth.setContentAreaFilled(false);
		btntwicth.setFocusPainted(false);
		btntwicth.setOpaque(false);
		contentPane.add(btntwicth);

		JButton btnNovoUsuario = new JButton("");
		btnNovoUsuario.setBounds(497, 488, 178, 38);
		contentPane.add(btnNovoUsuario);
		btnNovoUsuario.setBorderPainted(false);
		btnNovoUsuario.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnNovoUsuarioLogin.jpg")));
		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoUsuario frame = new NovoUsuario();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

			}
		});

		JLabel frame = new JLabel("");
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/projetologin.jpg")));
		frame.setBounds(0, 0, 1290, 670);
		contentPane.add(frame);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(81, 221, 46, 14);
		contentPane.add(lblNewLabel);
		label.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/12.jpg")));
	}
}
