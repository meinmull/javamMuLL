package Cadastro;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.DAOcadastro;
import dao.DAOempresa;
import dao.DAOendereco;
import beans.Cadastro;
import beans.Empresa;
import beans.Endereco;
import login.menulogin;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;


public class cadastroEmpresa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNOM_EM;
	private JTextField txtCNPJ;
	private JTextField txtCOMPLEMENTO_US;
	private JTextField txtEND_US;
	private JTextField txtCEP_US;
	private JTextField txtTEL_EMP;
	private JTextField txtIE;
	private JTextField txtEMA;
	private JPasswordField txtSenha;
	private JPasswordField txtSenha2;
	int a = 0;
	
	Endereco endereco = new Endereco();
	Empresa empresa = new Empresa();
	DAOendereco DaoENDERECO = new DAOendereco();
	DAOempresa DaoEMPRESA = new DAOempresa();
	DAOcadastro  DaoCADASTRO = new DAOcadastro();
	Cadastro CADASTRO = new Cadastro();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroEmpresa frame = new cadastroEmpresa();
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
	public cadastroEmpresa() {
		try {
			new javax.swing.text.MaskFormatter("###.###.###.###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		javax.swing.text.MaskFormatter format_CNPJ = null;
		try {
			format_CNPJ = new javax.swing.text.MaskFormatter("##.###.###.####-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			new javax.swing.text.MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			new javax.swing.text.MaskFormatter("(##)#####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		javax.swing.text.MaskFormatter format_TEL = null;
		try {
			format_TEL = new javax.swing.text.MaskFormatter("(##)####-####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		javax.swing.text.MaskFormatter format_CEP = null;
		try {
			format_CEP = new javax.swing.text.MaskFormatter("##.###-###");
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		setTitle("Cadastro Usu\u00E1rio mM\u00FCLL");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Casa\\Desktop\\mM\u00FClle\\ico.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnSair.setBounds(954, 660, 326, 47);
		btnSair.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnFecharLogin.jpg")));
		contentPane.add(btnSair);

		DAOendereco.cbxCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DAOendereco.cbxBairro.removeAllItems();
				DAOendereco.carregarBairro();

			}
		});

		DAOendereco.cbxCidade.setBounds(602, 365, 213, 24);
		contentPane.add(DAOendereco.cbxCidade);

		DAOendereco.cbxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOendereco.cbxCidade.removeAllItems();
				DAOendereco.cbxBairro.removeAllItems();
				DAOendereco.carregarCIDADE();

			}
		});

		DAOendereco.cbxEstado.setSelectedItem("SELECIONE");
		DAOendereco.cbxBairro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		DAOendereco.cbxBairro.setBounds(191, 418, 345, 24);
		contentPane.add(DAOendereco.cbxBairro);

		DAOendereco.cbxEstado.setBounds(191, 365, 345, 24);
		contentPane.add(DAOendereco.cbxEstado);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 51));
		panel.setBounds(0, 29, 928, 665);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNomeDaEmpresa = new JLabel("Nome \r\n:");
		lblNomeDaEmpresa.setBounds(103, 98, 103, 32);
		panel.add(lblNomeDaEmpresa);
		lblNomeDaEmpresa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDaEmpresa.setForeground(Color.WHITE);

		txtNOM_EM = new JTextField();
		txtNOM_EM.setBounds(191, 103, 624, 22);
		panel.add(txtNOM_EM);
		txtNOM_EM.setColumns(10);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(103, 165, 56, 16);
		panel.add(lblCnpj);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setForeground(Color.WHITE);

		txtCNPJ = new javax.swing.JFormattedTextField(format_CNPJ);
		txtCNPJ.setBounds(191, 162, 341, 22);
		panel.add(txtCNPJ);
		txtCNPJ.setText("--------");
		txtCNPJ.setColumns(10);

		JLabel lblIe = new JLabel("IE:");
		lblIe.setBounds(544, 166, 46, 14);
		panel.add(lblIe);
		lblIe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIe.setForeground(Color.WHITE);

		txtIE = new JTextField();
		txtIE.setBounds(602, 163, 213, 20);
		panel.add(txtIE);
		txtIE.setColumns(10);

		JLabel lblTelefoneComercial = new JLabel("Telefone:");
		lblTelefoneComercial.setBounds(103, 224, 125, 16);
		panel.add(lblTelefoneComercial);
		lblTelefoneComercial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefoneComercial.setForeground(Color.WHITE);

		txtTEL_EMP = new javax.swing.JFormattedTextField(format_TEL);
		txtTEL_EMP.setBounds(191, 221, 342, 22);
		panel.add(txtTEL_EMP);
		txtTEL_EMP.setColumns(10);

		txtTEL_EMP.setText("----------");

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(545, 224, 45, 16);
		panel.add(lblCep);
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtCEP_US = new javax.swing.JFormattedTextField(format_CEP);
		txtCEP_US.setBounds(602, 218, 213, 22);
		panel.add(txtCEP_US);
		txtCEP_US.setText("---------");
		txtCEP_US.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(103, 283, 80, 16);
		panel.add(lblEndereo);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setForeground(Color.WHITE);

		txtEND_US = new JTextField();
		txtEND_US.setBounds(191, 280, 345, 22);
		panel.add(txtEND_US);
		txtEND_US.setColumns(10);

		JLabel lblInscrioEstatual = new JLabel("Complemento");
		lblInscrioEstatual.setBounds(544, 283, 88, 16);
		panel.add(lblInscrioEstatual);
		lblInscrioEstatual.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInscrioEstatual.setForeground(Color.WHITE);

		txtCOMPLEMENTO_US = new JTextField();
		txtCOMPLEMENTO_US.setBounds(667, 283, 148, 22);
		panel.add(txtCOMPLEMENTO_US);
		txtCOMPLEMENTO_US.setColumns(10);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(103, 339, 45, 16);
		panel.add(lblUf);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setForeground(Color.WHITE);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(544, 339, 56, 16);
		panel.add(lblCidade);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setForeground(Color.WHITE);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(103, 392, 56, 16);
		panel.add(lblBairro);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBairro.setForeground(Color.WHITE);

		JLabel lblTermos = new JLabel("Termos :");
		lblTermos.setBounds(544, 415, 56, 16);
		panel.add(lblTermos);
		lblTermos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTermos.setForeground(Color.WHITE);

		JButton btnContrato = new JButton("Contrato");
		btnContrato.setBounds(544, 444, 130, 25);
		panel.add(btnContrato);
		btnContrato.setBackground(Color.DARK_GRAY);
		btnContrato.setForeground(Color.WHITE);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(103, 448, 56, 16);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setForeground(Color.WHITE);

		txtEMA = new JTextField();
		txtEMA.setBounds(191, 445, 345, 22);
		panel.add(txtEMA);
		txtEMA.setColumns(10);

		JCheckBox chckbxLiEConcordo = new JCheckBox("Li e concordo");
		chckbxLiEConcordo.setBounds(682, 444, 130, 25);
		panel.add(chckbxLiEConcordo);
		chckbxLiEConcordo.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxLiEConcordo.setForeground(Color.WHITE);
		chckbxLiEConcordo.setBackground(Color.DARK_GRAY);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(103, 507, 56, 16);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setForeground(Color.WHITE);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(191, 504, 198, 22);
		panel.add(txtSenha);

		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
		lblConfirmeASenha.setBounds(544, 507, 125, 16);
		panel.add(lblConfirmeASenha);
		lblConfirmeASenha.setForeground(Color.WHITE);
		lblConfirmeASenha.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtSenha2 = new JPasswordField();
		txtSenha2.setBounds(667, 504, 148, 22);
		panel.add(txtSenha2);

		JButton btnCadastar = new JButton("");
		btnCadastar.setBounds(315, 563, 320, 45);
		panel.add(btnCadastar);
		btnCadastar.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/btnConfirarCadastro.jpg")));

		JLabel lblCadastroParceiro = new JLabel("Cadastro Empresa");
		lblCadastroParceiro.setBounds(385, 37, 157, 29);
		panel.add(lblCadastroParceiro);
		lblCadastroParceiro.setForeground(Color.WHITE);
		lblCadastroParceiro.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/fundoCadastro.jpg")));
		label.setBounds(0, 0, 928, 665);
		panel.add(label);
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				getDados();
				Verificacaotexto();
				CADASTRO.setEmail_digitado(txtEMA.getText());
				selectEmailEmpresa(CADASTRO); 
				selectEmailUsuario(CADASTRO);
				if (a==0){
				DaoENDERECO.QueryCOD_BAIRRO();
				DaoENDERECO.cadastrarendereco();
				DaoENDERECO.SelectCOD_ENDERECO();
				System.out.println(endereco.getCOD_ENDERECO());
				empresa.setCOD_ENDERECO(endereco.getCOD_ENDERECO());
				System.out.println(empresa.getCOD_ENDERECO());
				DaoEMPRESA.cadastrarEmpresa(empresa);
				DaoEMPRESA.QUERYCOD_EMPRESA_DADOS(empresa);
				DaoEMPRESA.InsertLOGINEmpresa(empresa);
				
				DaoEMPRESA.QUERYCOD_EMPRESA(empresa);
				CADASTRO.setCOD_USUARIO(empresa.getCOD_Empresa());
				System.out.println(CADASTRO.getCOD_USUARIO());
				DaoCADASTRO.InsertCaixadeMensagens(CADASTRO);
				
				dispose();}

			}
		});

		JLabel frame = new JLabel("");
		frame.setBounds(0, 0, 1280, 720);
		frame.setIcon(new ImageIcon(menulogin.class.getResource("/Aaimagens/testefundo3.jpg")));

		contentPane.add(frame);
		DAOendereco.carregarESTADO();

	}

	public void getDados() {
		endereco.setCEP_ENDERECO(txtCEP_US.getText());
		endereco.setEND_ENDERECO(txtEND_US.getText());
		endereco.setCOM_ENDERECO(txtCOMPLEMENTO_US.getText());
		empresa.setCNPJ_EMPRESA(txtCNPJ.getText());
		empresa.setEMA_EMPRESA(txtEMA.getText());
		empresa.setIE_EMPRESA(txtIE.getText());
		empresa.setNOM_EMPRESA(txtNOM_EM.getText());
		empresa.setSEN_EMPRESA(txtSenha.getText());
		empresa.setTEL_EMPRESA(txtTEL_EMP.getText());
	}
	
	public void Verificacaotexto(){
		
		
		if(txtCEP_US.getText().equalsIgnoreCase("")||
			txtCNPJ.getText().equalsIgnoreCase("")||
			txtEMA.getText().equalsIgnoreCase("")||
			txtNOM_EM.getText().equalsIgnoreCase("")||
			txtSenha.getText().equalsIgnoreCase("") ||
			txtSenha2.getText().equalsIgnoreCase("")||
			txtTEL_EMP.getText().equalsIgnoreCase("")||
		txtEND_US.getText().equalsIgnoreCase("")){
			 JOptionPane.showMessageDialog(null, "Falha no cadastro , campos vazios.");
		a=1;
		
		}
		else if(!txtSenha.getText().equalsIgnoreCase(txtSenha2.getText())){
			JOptionPane.showMessageDialog(null, "Falha no cadastro . As senhas não são iguais.");
		a =2;
		}
		}
	
		
		
		
		
		
	
public void selectEmailEmpresa(Cadastro CADASTRO){
	DaoCADASTRO.VerificacaoEmailEmpresa(CADASTRO);
	
	 if (CADASTRO.getEmail_digitado().equalsIgnoreCase(CADASTRO.getEmail())){
		JOptionPane.showMessageDialog(null, "E-mail já cadastrado.");
	a = 3;
}}
	 public void selectEmailUsuario(Cadastro CADASTRO){
		 DaoCADASTRO.VerificacaoEmailUsuario(CADASTRO);
			if (CADASTRO.getEmail_digitado().equalsIgnoreCase(CADASTRO.getEmail())){
				JOptionPane.showMessageDialog(null, "E-mail já cadastrado.");
			a = 4;
	 }
	 }
	 }
	
	

