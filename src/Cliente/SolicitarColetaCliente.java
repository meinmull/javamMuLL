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
	public SolicitarColetaCliente() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(menulogin.class.getResource("/Aaimagens/logoIcone1.jpg")));
		setTitle("Cliente - Solicitar Coleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		
		/*JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/framemenusolicitacaocoleta.jpg")));
		label.setBounds(0, 0, 1274, 179);
		contentPane.add(label);*/
		
		JButton button = new JButton("");
		button.setBounds(952, 593, 320, 45);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		button.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharlogin.jpg")));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 223, 1280, 343);
		contentPane.add(panel);
		panel.setLayout(null);
		
			
			JButton btnOrgnicos = new JButton("");
			btnOrgnicos.setBounds(984, 13, 200, 150);
			panel.add(btnOrgnicos);
			
					btnOrgnicos.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnOrganico.jpg")));
					
					JButton btnEletrnico = new JButton("");
					btnEletrnico.setBounds(984, 180, 200, 150);
					panel.add(btnEletrnico);
					btnEletrnico.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnEletronicos.jpg")));
					
					
					JButton btnRoupasECalados = new JButton("");
					btnRoupasECalados.setBounds(688, 180, 200, 150);
					panel.add(btnRoupasECalados);
					btnRoupasECalados.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnRoupasEcalcados.jpg")));
					
					
					JButton btnPapel = new JButton("");
					btnPapel.setBounds(688, 13, 200, 150);
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
						btnMetal.setBounds(392, 13, 200, 150);
						panel.add(btnMetal);
						btnMetal.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnMetal.jpg")));
						
						
						JButton btnColetaSeletiva = new JButton("");
						btnColetaSeletiva.setBounds(392, 180, 200, 150);
						panel.add(btnColetaSeletiva);
						btnColetaSeletiva.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSeletiva.jpg")));
						
						btnColetaSeletiva.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								SolicitacaoSeletiva frame = new SolicitacaoSeletiva();
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							}
						});
						
						
						btnColetaSeletiva.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnSeletiva.jpg")));
						
						JButton btnPlastico = new JButton("");
						btnPlastico.setBounds(96, 178, 200, 150);
						panel.add(btnPlastico);
						btnPlastico.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnPlastico.jpg")));
						
						JButton btnVidro = new JButton("");
						btnVidro.setBounds(96, 14, 200, 150);
						panel.add(btnVidro);
						btnVidro.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnVidro.jpg")));
						
						btnVidro.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								SolicitacaoVidro frame = new SolicitacaoVidro();
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							}
						});
						
						btnMetal.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								SolicitacaoMetal frame = new SolicitacaoMetal();
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							}
						});
					
					btnRoupasECalados.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							SolicitacaoRoupasECalcados frame = new SolicitacaoRoupasECalcados();
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						}
					});
					btnEletrnico.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							SolicitacaoEletronicos frame = new SolicitacaoEletronicos();
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
				
		
		
		JLabel frame = new JLabel("");
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/framePrincipalSolicitarColeta.jpg")));
		frame.setBounds(0, 0, 1280, 670);
		contentPane.add(frame);
	
	}
}
