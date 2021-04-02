package Tela3_login_Cliente.Tela;

import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class TelaLoginCliente extends TelaPadrao {

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
        boasVindas.setBounds(0, 2, 300, 100);
        boasVindas.setHorizontalAlignment(JLabel.CENTER);
        boasVindas.setIcon(imagemUser);
        this.JP_PAINEL.add(boasVindas);
    }

    public void formLabel() {
        JLabel login = new JLabel("Login do Cliente",JLabel.CENTER);
        JLabel email = new JLabel("E-mail:",JLabel.RIGHT);
        JLabel senha = new JLabel("Senha:",JLabel.RIGHT);
        Font font = new Font("Arial",Font.BOLD,12);

        login.setBounds(0, 105, 300, 30);
        login.setFont(new Font("Arial",Font.BOLD,13));
        login.setForeground(Color.WHITE);
        this.JP_PAINEL.add(login);

        email.setBounds(0, 145, 80, 20);
        email.setFont(font);
        this.JP_PAINEL.add(email);

        senha.setBounds(0, 185, 80, 20);
        senha.setFont(font);
        this.JP_PAINEL.add(senha);

    }

    public void inputsAndButton() {
        this.email = new JTextField();
        this.senha = new JPasswordField();
        Font font = new Font("Arial",Font.BOLD,12);

        JSeparator emailSeparador = new JSeparator();
        JSeparator senhaSeparador = new JSeparator();

        email.setBounds(90, 142, 175, 25);
        email.setFont(font);
        email.setForeground(new Color(128, 196, 255));
        email.setBorder(null);
        this.JP_PAINEL.add(email);

        senha.setBounds(90, 182, 175, 25);
        senha.setFont(font);
        senha.setForeground(new Color(128, 196, 255));
        senha.setBorder(null);
        this.JP_PAINEL.add(senha);

        emailSeparador.setBounds(90,167,170,10);
        emailSeparador.setOrientation(JSeparator.HORIZONTAL);
        emailSeparador.setBackground(Color.WHITE);
        this.JP_PAINEL.add(emailSeparador);

        senhaSeparador.setBounds(90,207,170,10);
        senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
        senhaSeparador.setBackground(Color.WHITE);
        this.JP_PAINEL.add(senhaSeparador);

        JButton entrar = new JButton("Entrar");

        //OuvinteLoginButton ouvinte = new OuvinteLoginButton(this);
        //entrar.addActionListener(ouvinte);

        entrar.setBounds(70, 220, 60, 25);
        entrar.setBackground(new Color(102, 102, 102));
        entrar.setFont(font);
        entrar.setBorder(null);
        this.JP_PAINEL.add(entrar);

        JLabel ou = new JLabel("ou");
        ou.setBounds(138, 225, 300, 15);
        ou.setFont(new Font("Arial",Font.BOLD,12));
        ou.setForeground(Color.GRAY);
        this.JP_PAINEL.add(ou);

        JButton cadastre = new JButton("Cadastre-se");
        cadastre.setBounds(160, 220, 100, 25);
        cadastre.setBackground(new Color(102, 102, 102));
        cadastre.setFont(font);
        cadastre.setBorder(null);
        this.JP_PAINEL.add(cadastre);


        JLabel esqueceu = new JLabel("Esqueceu a senha?",JLabel.CENTER);
        esqueceu.setBounds(0, 257, 300, 30);
        esqueceu.setFont(font);
        this.JP_PAINEL.add(esqueceu);

       /* JLabel ou2 = new JLabel("Ou");
        ou2.setBounds(80, 305, 300, 15);
        ou2.setFont(new Font("Arial",Font.BOLD,12));
        ou2.setForeground(Color.GRAY);
        this.JP_PAINEL.add(ou2);*/


        JButton soulivreiro = new JButton("Sou Livreiro");
        soulivreiro.setBounds(100, 300, 100, 25);
        soulivreiro.setBackground(new Color(102, 102, 102));
        soulivreiro.setFont(font);
        soulivreiro.setBorder(null);
        this.JP_PAINEL.add(soulivreiro);

    }



    public TelaLoginCliente(String titulo) {
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
