package Tela1_cadastro_ADM.Tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import Tela1_cadastro_ADM.Ouvintes.OuvinteDaClasseTelaAddLivreiro;
import TelaPadrao.TelaPadrao;

public class TelaAddLivreiro extends TelaPadrao{

	private final JPanel JP_PAINEL =  new JPanel();
	private JTextField nome;
	private JTextField email;
	private JTextField senha;
	
	public void addPainel() {
		this.JP_PAINEL.setBounds(0, 0, 370, 400);
		this.JP_PAINEL.setBackground(Color.DARK_GRAY);
		this.JP_PAINEL.setLayout(null);
		this.add(JP_PAINEL);
	}
	
	public void addImagemUser() {
		ImageIcon imagemUser = new ImageIcon("img/img_ADM/img/userADM.png");
		JLabel boasVindas = new JLabel();
		
		boasVindas.setBounds(0, 10, 370, 110);
		boasVindas.setHorizontalAlignment(JLabel.CENTER);
		boasVindas.setIcon(imagemUser);
		
		this.JP_PAINEL.add(boasVindas);
	}
	
	public void addFormLabel() {
		JLabel boasVindas = new JLabel("Cadastro do Livreiro",JLabel.CENTER);
		JLabel nome = new JLabel("Nome:",JLabel.RIGHT);
		JLabel email = new JLabel("Email:",JLabel.RIGHT);
		JLabel senha = new JLabel("Senha:",JLabel.RIGHT);
		Font font = new Font("Arial",Font.BOLD,15);
		
		boasVindas.setBounds(0, 120, 370, 25);
		boasVindas.setFont(new Font("Arial",Font.BOLD,13));
		boasVindas.setForeground(Color.WHITE);

		
		nome.setBounds(0, 150, 100, 30);
		nome.setFont(font);

		
		
		email.setBounds(0, 200, 100, 30);
		email.setFont(font);

		
		senha.setBounds(0, 250, 100, 30);
		senha.setFont(font);

		
		this.JP_PAINEL.add(boasVindas);
		this.JP_PAINEL.add(nome);
		this.JP_PAINEL.add(email);
		this.JP_PAINEL.add(senha);
	}
	
	public void addInputsAndButton() {
		this.nome = new JTextField();
		this.email = new JTextField();
		this.senha = new JTextField();

		JSeparator nomeSeparador = new JSeparator();
		JSeparator emaileSeparador = new JSeparator();
		JSeparator senhaSeparador = new JSeparator();
		
		JButton botao = new JButton("Enviar");

		OuvinteDaClasseTelaAddLivreiro ouvinte = new OuvinteDaClasseTelaAddLivreiro(this);
		botao.addActionListener(ouvinte);
		
		Font font = new Font("Arial",Font.BOLD,12);
		
		this.nome.setBounds(120, 153, 200, 25);
		this.nome.setForeground(new Color(128, 196, 255));
		this.nome.setBorder(null);
		this.nome.setFont(font);
		
		this.email.setBounds(120, 203, 200, 25);
		this.email.setForeground(new Color(128, 196, 255));
		this.email.setBorder(null);
		this.email.setFont(font);
		
		this.senha.setBounds(120, 253, 200, 25);
		this.senha.setForeground(new Color(128, 196, 255));
		this.senha.setBorder(null);
		this.senha.setFont(font);

		nomeSeparador.setBounds(115,177,200,100);
		nomeSeparador.setOrientation(JSeparator.HORIZONTAL);
		nomeSeparador.setBackground(Color.WHITE);

		emaileSeparador.setBounds(115,227,200,100);
		emaileSeparador.setOrientation(JSeparator.HORIZONTAL);
		emaileSeparador.setBackground(Color.WHITE);

		senhaSeparador.setBounds(115,277,200,100);
		senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
		senhaSeparador.setBackground(Color.WHITE);

		botao.setBounds(50, 315, 270, 30);
		botao.setIcon(new ImageIcon("./img/img_ADM/img/botao.png"));
		botao.setFont(font);
		botao.setForeground(Color.BLACK);
		
		this.JP_PAINEL.add(nome);
		this.JP_PAINEL.add(nomeSeparador);

		this.JP_PAINEL.add(email);
		this.JP_PAINEL.add(emaileSeparador);

		this.JP_PAINEL.add(senha);
		this.JP_PAINEL.add(senhaSeparador);

		this.JP_PAINEL.add(botao);
	}
	
	public void addImgLivraria() {
		ImageIcon imagem = new  ImageIcon("img/img_ADM/img/tela1.png");
		JLabel lbImg = new JLabel();
		
		lbImg.setBounds(370, 0, 330, 400);
		lbImg.setIcon(imagem);
		this.add(lbImg);
	}
	public TelaAddLivreiro(String titulo) {
		super(titulo);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
