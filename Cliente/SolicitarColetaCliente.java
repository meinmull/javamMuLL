package Cliente;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClienteSolicitacao.SolicitacaoEletronicos;
import ClienteSolicitacao.SolicitacaoMetal;
import ClienteSolicitacao.SolicitacaoRoupasECalcados;
import ClienteSolicitacao.SolicitacaoSeletiva;
import ClienteSolicitacao.SolicitacaoVidro;
import login.menulogin;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class SolicitarColetaCliente extends JFrame {

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
					SolicitarColetaCliente frame = new SolicitarColetaCliente();
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
	public SolicitarColetaCliente() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Casa\\Desktop\\mM\u00FClle\\ico.png"));
		setTitle("Solicitar Coleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 592, 1274, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		button.setBounds(477, 1, 320, 45);
		panel_1.add(button);
		button.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharlogin.jpg")));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 180, 1280, 414);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnPlastico = new JButton("");
		btnPlastico.setBounds(96, 4, 200, 201);
		panel.add(btnPlastico);
		btnPlastico.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnPlastico.jpg")));
		
		JButton btnVidro = new JButton("");
		btnVidro.setBounds(392, 4, 200, 201);
		panel.add(btnVidro);
		btnVidro.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnVidro.jpg")));
		
		btnVidro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolicitacaoVidro frame = new SolicitacaoVidro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		
		JButton btnRoupasECalados = new JButton("");
		btnRoupasECalados.setBounds(688, 4, 200, 201);
		panel.add(btnRoupasECalados);
		btnRoupasECalados.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnRoupasEcalcados.jpg")));
		
		btnRoupasECalados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolicitacaoRoupasECalcados frame = new SolicitacaoRoupasECalcados();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		
		JButton btnPapel = new JButton("");
		btnPapel.setBounds(984, 4, 200, 201);
		panel.add(btnPapel);
		btnPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*SolicitarColetaPapel frame = new SolicitarColetaPapel();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);*/
			}
		});
		btnPapel.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnPapel.jpg")));
	
		
		JButton btnMetal = new JButton("");
		btnMetal.setBounds(96, 209, 200, 200);
		panel.add(btnMetal);
		btnMetal.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMetal.jpg")));
		
		btnMetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SolicitacaoMetal frame = new SolicitacaoMetal();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		
		JButton btnColetaSeletiva = new JButton("");
		btnColetaSeletiva.setBounds(392, 209, 200, 201);
		panel.add(btnColetaSeletiva);
		btnColetaSeletiva.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSeletiva.jpg")));
		
		btnColetaSeletiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolicitacaoSeletiva frame = new SolicitacaoSeletiva();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		
		btnColetaSeletiva.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSeletiva.jpg")));
		
		JButton btnEletrnico = new JButton("");
		btnEletrnico.setBounds(688, 209, 200, 201);
		panel.add(btnEletrnico);
		btnEletrnico.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnEletronicos.jpg")));
		btnEletrnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SolicitacaoEletronicos frame = new SolicitacaoEletronicos();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
	
		
		JButton btnOrgnicos = new JButton("");
		btnOrgnicos.setBounds(984, 209, 200, 201);
		panel.add(btnOrgnicos);
		
				btnOrgnicos.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnOrganico.jpg")));
				
				JButton btnMenuPrincipal = new JButton("");
				btnMenuPrincipal.setBounds(480, 471, 320, 45);
				panel.add(btnMenuPrincipal);
				btnMenuPrincipal.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSair.jpg")));
				btnMenuPrincipal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnOrgnicos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*SolicitarColetaOrganico frame = new SolicitarColetaOrganico();
						dispose();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);*/
						
					}
				});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/framemenusolicitacaocoleta.jpg")));
		label.setBounds(0, 0, 1274, 179);
		contentPane.add(label);
				
		
		
		JLabel frame = new JLabel("");
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/fundoEDITmull.jpg")));
		frame.setBounds(0, 0, 1280, 670);
		contentPane.add(frame);
	

	
	
	
	}
}
