package Tela4_cadastro_cliente.Tela;

import Tela1_cadastro_ADM.Ouvintes.OuvinteDaClasseTelaAddLivreiro;
import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends TelaPadrao {

    private final JPanel JP_PAINEL =  new JPanel();
    private JTextField nomec;
    private JTextField emailc;
    private JTextField senhac;

    public void addPainel() {
        this.JP_PAINEL.setBounds(330, 0, 370, 400);
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

    public void addImgLivraria() {
        ImageIcon imagem = new  ImageIcon("img/img_ADM/img/tela1.png");
        JLabel lbImg = new JLabel();
        lbImg.setBounds(0, 0, 330, 400);
        lbImg.setIcon(imagem);
        this.add(lbImg);
    }

    public void addFormLabel() {
        JLabel boasVindas = new JLabel("Cadastro do Cliente",JLabel.CENTER);
        JLabel nomec = new JLabel("Nome:",JLabel.RIGHT);
        JLabel emailc = new JLabel("Email:",JLabel.RIGHT);
        JLabel senhac = new JLabel("Senha:",JLabel.RIGHT);
        Font font = new Font("Arial",Font.BOLD,15);

        boasVindas.setBounds(0, 120, 370, 25);
        boasVindas.setFont(new Font("Arial",Font.BOLD,13));
        boasVindas.setForeground(Color.WHITE);


        nomec.setBounds(0, 150, 100, 30);
        nomec.setFont(font);

        emailc.setBounds(0, 200, 100, 30);
        emailc.setFont(font);

        senhac.setBounds(0, 250, 100, 30);
        senhac.setFont(font);

        this.JP_PAINEL.add(boasVindas);
        this.JP_PAINEL.add(nomec);
        this.JP_PAINEL.add(emailc);
        this.JP_PAINEL.add(senhac);
    }

    public void addInputsAndButton() {
        this.nomec = new JTextField();
        this.emailc = new JTextField();
        this.senhac = new JTextField();

        JSeparator nomeSeparador = new JSeparator();
        JSeparator emaileSeparador = new JSeparator();
        JSeparator senhaSeparador = new JSeparator();

        JButton botao = new JButton("Enviar");

        Font font = new Font("Arial",Font.BOLD,12);

        this.nomec.setBounds(120, 153, 200, 25);
        this.nomec.setForeground(new Color(128, 196, 255));
        this.nomec.setBorder(null);
        this.nomec.setFont(font);

        this.emailc.setBounds(120, 203, 200, 25);
        this.emailc.setForeground(new Color(128, 196, 255));
        this.emailc.setBorder(null);
        this.emailc.setFont(font);

        this.senhac.setBounds(120, 253, 200, 25);
        this.senhac.setForeground(new Color(128, 196, 255));
        this.senhac.setBorder(null);
        this.senhac.setFont(font);

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

        this.JP_PAINEL.add(nomec);
        this.JP_PAINEL.add(nomeSeparador);

        this.JP_PAINEL.add(emailc);
        this.JP_PAINEL.add(emaileSeparador);

        this.JP_PAINEL.add(senhac);
        this.JP_PAINEL.add(senhaSeparador);

        this.JP_PAINEL.add(botao);
    }

    public TelaCadastroCliente(String titulo) {
        super(titulo);
        this.addPainel();
        this.addImagemUser();
        this.addImgLivraria();
        this.addFormLabel();
        this.addInputsAndButton();
    }

    public String getNomec() {
        return nomec.getText();
    }

    public String getEmailc() {
        return emailc.getText();
    }

    public String getSenhac() {
        return senhac.getText();
    }
}
