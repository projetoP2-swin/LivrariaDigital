package Tela2_login_ADM.Tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import Tela2_login_ADM.Ouvintes.OuvinteDoEsqueceuASenha;
import Tela2_login_ADM.Ouvintes.OuvinteLoginButton;
import TelaPadrao.TelaPadrao;

public class TelaADM extends TelaPadrao {

	private final JPanel JP_PAINEL =  new JPanel();
	private JTextField email;
	private JPasswordField senha;
	
	public void addPainel() {
		this.JP_PAINEL.setBounds(200, 15, 300, 330);
		this.JP_PAINEL.setBackground(Color.DARK_GRAY);
		this.JP_PAINEL.setLayout(null);
		this.add(JP_PAINEL);
	}

	public void background() {
		ImageIcon img = new ImageIcon("img/img_ADM/img/livros.png");
		JLabel imgb = new JLabel();
		
		imgb.setBounds(0, 0, 700, 400);
		imgb.setIcon(img);
		this.add(imgb);
		
	}
	
	public void imagemUser() {
		ImageIcon imagemUser = new ImageIcon("img/img_ADM/img/userADM.png");
		JLabel boasVindas = new JLabel();
		boasVindas.setBounds(0, 20, 300, 100);
		boasVindas.setHorizontalAlignment(JLabel.CENTER);
		boasVindas.setIcon(imagemUser);
		this.JP_PAINEL.add(boasVindas);
	}
	
	public void formLabel() {
		JLabel login = new JLabel("Login do Livreiro",JLabel.CENTER);
		JLabel email = new JLabel("E-mail:",JLabel.RIGHT);
		JLabel senha = new JLabel("Senha:",JLabel.RIGHT);
		Font font = new Font("Arial",Font.BOLD,12);
		
		login.setBounds(0, 120, 300, 30);
		login.setFont(new Font("Arial",Font.BOLD,13));
		login.setForeground(Color.WHITE);
		this.JP_PAINEL.add(login);
		
		email.setBounds(0, 155, 80, 20);
		email.setFont(font);
		this.JP_PAINEL.add(email);
		
		senha.setBounds(0, 195, 80, 20);
		senha.setFont(font);
		this.JP_PAINEL.add(senha);
		
		
	}
	
	public void inputsAndButton() {
		this.email = new JTextField();
		this.senha = new JPasswordField();
		Font font = new Font("Arial",Font.BOLD,12);

		JSeparator emailSeparador = new JSeparator();
		JSeparator senhaSeparador = new JSeparator();
		
		email.setBounds(90, 153, 175, 25);
		email.setFont(font);
		email.setForeground(new Color(128, 255, 128));
		email.setBorder(null);
		this.JP_PAINEL.add(email);
		
		senha.setBounds(90, 192, 175, 25);
		senha.setFont(font);
		senha.setForeground(new Color(128, 255, 128));
		senha.setBorder(null);
		this.JP_PAINEL.add(senha);
		
		emailSeparador.setBounds(90,177,175,10);
		emailSeparador.setOrientation(JSeparator.HORIZONTAL);
		emailSeparador.setBackground(Color.WHITE);
		this.JP_PAINEL.add(emailSeparador);
		
		senhaSeparador.setBounds(90,217,175,10);
		senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
		senhaSeparador.setBackground(Color.WHITE);
		this.JP_PAINEL.add(senhaSeparador);
		
		JButton entrar = new JButton("Entrar");

		OuvinteLoginButton ouvinte = new OuvinteLoginButton(this);
		entrar.addActionListener(ouvinte);

		entrar.setBounds(120, 240, 60, 25);
		entrar.setBackground(new Color(102, 102, 102));
		entrar.setFont(font);
		entrar.setBorder(null);
		this.JP_PAINEL.add(entrar);

		OuvinteDoEsqueceuASenha ouvinteDoEsqueceuASenha = new OuvinteDoEsqueceuASenha(this);
		JLabel esqueceu = new JLabel("Esqueceu a senha?",JLabel.CENTER);
		esqueceu.addMouseListener(ouvinteDoEsqueceuASenha);

		esqueceu.setBounds(0, 280, 300, 40);
		esqueceu.setFont(font);


		this.JP_PAINEL.add(esqueceu);
		
	}

	public TelaADM(String titulo) {
		super(titulo);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		this.addPainel();
		
		this.background();
		this.imagemUser();
		this.formLabel();
		this.inputsAndButton();
		
	}

	public String getEmail() {
		return email.getText();
	}

	public String getSenha() {
		return senha.getText();
	}
}
