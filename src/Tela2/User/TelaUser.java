package Tela2.User;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;

import TelaPadrao.TelaPadrao;

public class TelaUser extends TelaPadrao {
	
	private static final long serialVersionUID = 1L;
	private JPanel jpPainel =  new JPanel();
	private JTextField email;
	private JTextField senha;
	
	public void addPainel() {
		this.jpPainel.setBounds(200, 15, 300, 330);
		this.jpPainel.setBackground(Color.DARK_GRAY);
		this.jpPainel.setLayout(null);
		//this.jpPainel.setBorder(LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		//this.jpPainel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		this.add(jpPainel);
	}
	
	/*private Border LineBorder(Color color, int i, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}*/

	public void background() {
		ImageIcon img = new ImageIcon("img/addLivreiro/livros.png");
		JLabel imgb = new JLabel();
		
		imgb.setBounds(0, 0, 700, 400);
		imgb.setIcon(img);
		this.add(imgb);
		
	}
	
	public void imagemUser() {
		ImageIcon imagemUser = new ImageIcon("img/addLivreiro/user2.png");
		JLabel boasVindas = new JLabel();
		boasVindas.setBounds(100, 20, 100, 100);
		boasVindas.setIcon(imagemUser);
		this.jpPainel.add(boasVindas);
	}
	
	public void formLabel() {
		JLabel login = new JLabel("Login do Livreiro");
		JLabel email = new JLabel("E-mail:");
		JLabel senha = new JLabel("Senha:");
		Font font = new Font("Arial",Font.BOLD,12);
		
		login.setBounds(100, 80, 120, 100);
		login.setFont(new Font("Arial",Font.BOLD,13));
		login.setForeground(Color.WHITE);
		this.jpPainel.add(login);
		
		email.setBounds(20, 155, 45, 20);
		email.setFont(font);
		email.setForeground(Color.white);
		this.jpPainel.add(email);
		
		senha.setBounds(20, 195, 45, 20);
		senha.setFont(font);
		senha.setForeground(Color.WHITE);
		this.jpPainel.add(senha);
		
		
	}
	
	public void inputsandbutton() {
		this.email = new JTextField();
		this.senha = new JTextField();
		Font font = new Font("Arial",Font.BOLD,12);
		JSeparator emailSeparador = new JSeparator();
		JSeparator senhaSeparador = new JSeparator();
		
		email.setBounds(70, 153, 200, 25);
		email.setFont(font);
		email.setBorder(null);
		this.jpPainel.add(email);
		
		senha.setBounds(70, 192, 200, 25);
		senha.setFont(font);
		senha.setBorder(null);
		this.jpPainel.add(senha);
		
		emailSeparador.setBounds(70,180,200,100);
		emailSeparador.setOrientation(JSeparator.HORIZONTAL);
		emailSeparador.setBackground(Color.WHITE);
		this.jpPainel.add(emailSeparador);
		
		senhaSeparador.setBounds(70,220,200,100);
		senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
		senhaSeparador.setBackground(Color.WHITE);
		this.jpPainel.add(senhaSeparador);
		
		JButton entrar = new JButton("Entrar");
		entrar.setBounds(120, 240, 60, 25);
		entrar.setFont(font);
		entrar.setBorder(null);
		this.jpPainel.add(entrar);
		
		JButton esqueceu = new JButton("Esqueceu a senha?");
		esqueceu.setBounds(85, 280, 130, 25);
		esqueceu.setFont(font);
		esqueceu.setBackground(null);
		esqueceu.setBorder(null);
		this.jpPainel.add(esqueceu);
		
	}

	public TelaUser(String titulo) {
		super(titulo);
		
		
		this.addPainel();
		
		this.background();
		this.imagemUser();
		this.formLabel();
		this.inputsandbutton();
		
	}
	
	

}
