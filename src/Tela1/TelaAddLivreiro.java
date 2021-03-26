package Tela1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Tela1.Ouvintes.OuvinteDaClasseTelaAddLivreiro;
import TelaPadrao.TelaPadrao;

public class TelaAddLivreiro extends TelaPadrao{

	private static final long serialVersionUID = 1L;
	private JPanel jpPainel =  new JPanel();
	private JTextField nome;
	private JTextField email;
	private JTextField senha;
	
	public void addPainel() {
		this.jpPainel.setBounds(0, 0, 370, 400);
		this.jpPainel.setBackground(Color.DARK_GRAY);
		this.jpPainel.setLayout(null);
		this.add(jpPainel);
	}
	
	public void addImagemUser() {
		ImageIcon imagemUser = new ImageIcon("img/livreiro.png");
		JLabel boasVindas = new JLabel();
		
		boasVindas.setBounds(145, 10, 110, 110);
		boasVindas.setIcon(imagemUser);
		
		this.jpPainel.add(boasVindas);
	}
	
	public void addFormLabel() {
		JLabel boasVindas = new JLabel("Livreiro");
		JLabel nome = new JLabel("Nome:");
		JLabel email = new JLabel("Email:");
		JLabel senha = new JLabel("Senha:");
		Font font = new Font("Arial",Font.BOLD,15);
		
		boasVindas.setBounds(168, 75, 100, 100);
		boasVindas.setFont(new Font("Arial",Font.BOLD,13));
		boasVindas.setForeground(Color.WHITE);
		
		nome.setBounds(50, 120, 100, 100);
		nome.setFont(font);
		nome.setForeground(Color.WHITE);
		
		
		email.setBounds(50, 180, 100, 100);
		email.setFont(font);
		email.setForeground(Color.WHITE);
		
		senha.setBounds(50, 240, 100, 100);
		senha.setFont(font);
		senha.setForeground(Color.WHITE);
		
		this.jpPainel.add(boasVindas);
		this.jpPainel.add(nome);
		this.jpPainel.add(email);
		this.jpPainel.add(senha);
	}
	
	public void addInputsAndButton() {
		this.nome = new JTextField();
		this.email = new JTextField();
		this.senha = new JTextField();
		
		JButton botao = new JButton("Enviar");

		OuvinteDaClasseTelaAddLivreiro ouvinte = new OuvinteDaClasseTelaAddLivreiro(this);
		botao.addActionListener(ouvinte);
		
		Font font = new Font("Arial",Font.BOLD,12);
		
		this.nome.setBounds(120, 157, 200, 25);
		this.nome.setFont(font);
		
		this.email.setBounds(120, 217, 200, 25);
		this.email.setFont(font);
		
		this.senha.setBounds(120, 275, 200, 25);
		this.senha.setFont(font);

		
		botao.setBounds(35, 330, 300, 30);
		botao.setFont(font);
		botao.setForeground(Color.BLACK);
		
		this.jpPainel.add(nome);
		this.jpPainel.add(email);
		this.jpPainel.add(senha);
		this.jpPainel.add(botao);
	}
	
	public void addImgLivraria() {
		ImageIcon imagem = new  ImageIcon("img/livraria.png");
		JLabel lbImg = new JLabel();
		
		lbImg.setBounds(390, 70, 300, 225);
		lbImg.setIcon(imagem);
		this.add(lbImg);
	}
	public TelaAddLivreiro(String titulo) {
		super(titulo);
	
		this.addPainel();
		this.addImagemUser();
		this.addFormLabel();
		this.addInputsAndButton();
		this.addImgLivraria();
	}

	public String getNome() {
		return nome.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getSenha() {
		return senha.getText();
	}


}
