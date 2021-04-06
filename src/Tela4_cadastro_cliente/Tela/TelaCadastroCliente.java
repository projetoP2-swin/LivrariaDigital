package Tela4_cadastro_cliente.Tela;

import Tela1_cadastro_ADM.Ouvintes.OuvinteDaClasseTelaAddLivreiro;
import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

public class TelaCadastroCliente extends TelaPadrao {
    //TODO pegar genero, pegar aniversario e 3 generos de livro
    private final JPanel JP_PAINEL =  new JPanel();
    private JTextField nomec;
    private JTextField emailc;
    private JTextField senhac;
    private JFormattedTextField datac;



    public void addPainel() { ;
        this.JP_PAINEL.setBounds(330, 0, 370, 400);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(null);
        this.add(JP_PAINEL);

    }









    public void addImagemUser() {
        ImageIcon imagemUser = new ImageIcon("img/img_ADM/img/userADM.png");
        JLabel boasVindas = new JLabel();

        boasVindas.setBounds(5, 10, 100, 110);
        //boasVindas.setHorizontalAlignment(JLabel.CENTER);
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
        JLabel boasVindas = new JLabel("Cadastro do Cliente");
        JLabel nomec = new JLabel("Nome:");
        JLabel sexoc = new JLabel("Sexo:");
        JLabel emailc = new JLabel("Email:",JLabel.RIGHT);
        JLabel senhac = new JLabel("Senha:",JLabel.RIGHT);
        JLabel datac = new JLabel("Data de Nascimento:", JLabel.RIGHT);
        Font font = new Font("Arial",Font.BOLD,15);

        boasVindas.setBounds(150, 10, 370, 25);
        boasVindas.setFont(new Font("Arial",Font.BOLD,13));
        boasVindas.setForeground(Color.WHITE);


        nomec.setBounds(110, 45, 55, 30);
        nomec.setFont(font);

        JSeparator nomeSeparador = new JSeparator();
        nomeSeparador.setBounds(170, 75, 145, 100);
        nomeSeparador.setOrientation(JSeparator.HORIZONTAL);
        nomeSeparador.setBackground(Color.WHITE);

        sexoc.setBounds(110, 87, 55, 30);
        sexoc.setFont(font);

        emailc.setBounds(0, 200, 100, 30);
        emailc.setFont(font);

        senhac.setBounds(0, 250, 100, 30);
        senhac.setFont(font);

        datac.setBounds(45, 150, 150, 30 );
        datac.setFont(font);

        this.JP_PAINEL.add(boasVindas);
        this.JP_PAINEL.add(nomec);
        this.JP_PAINEL.add(datac);
        this.JP_PAINEL.add(emailc);
        this.JP_PAINEL.add(senhac);
        this.JP_PAINEL.add(sexoc);
        this.JP_PAINEL.add(nomeSeparador);
    }

    public void radioSexo () {
        JRadioButton rbMasc = new JRadioButton("Masculino", false);
        rbMasc.setBounds(170, 90, 80, 25);
        rbMasc.setBackground(null);

        JRadioButton rbFem = new JRadioButton("Feminino", false);
        rbFem.setBounds(250, 90, 70, 25);
        rbFem.setBackground(null);

        ButtonGroup group = new ButtonGroup();
        group.add(rbMasc);
        group.add(rbFem);

        JSeparator sexoSeparador = new JSeparator();
        sexoSeparador.setBounds(170,130,145,100);
        sexoSeparador.setOrientation(JSeparator.HORIZONTAL);
        sexoSeparador.setBackground(Color.WHITE);

        this.JP_PAINEL.add(rbMasc);
        this.JP_PAINEL.add(rbFem);
        this.JP_PAINEL.add(sexoSeparador);
    }

    public void addInputs() {
        this.nomec = new JTextField();
        this.emailc = new JTextField();
        this.senhac = new JTextField();


        JSeparator dataSeparador = new JSeparator();
        JSeparator emaileSeparador = new JSeparator();
        JSeparator senhaSeparador = new JSeparator();

        Font font = new Font("Arial",Font.BOLD,12);

        this.nomec.setBounds(170, 53, 150, 20);
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

        dataSeparador.setBounds(210,180,105,100);
        dataSeparador.setOrientation(JSeparator.HORIZONTAL);
        dataSeparador.setBackground(Color.WHITE);

        emaileSeparador.setBounds(115,227,200,100);
        emaileSeparador.setOrientation(JSeparator.HORIZONTAL);
        emaileSeparador.setBackground(Color.WHITE);

        senhaSeparador.setBounds(115,277,200,100);
        senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
        senhaSeparador.setBackground(Color.WHITE);

        try {
            MaskFormatter mascaraDeData = new MaskFormatter("##/##/####");
            this.datac = new JFormattedTextField(mascaraDeData);
            this.datac.setBounds(210, 153, 110, 25 );
            this.datac.setForeground(new Color(128, 196, 255));
            this.datac.setHorizontalAlignment(JLabel.CENTER);
            //this.datac.setBackground(Color.blue);
            this.datac.setBorder(null);
            this.datac.setFont(font);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.JP_PAINEL.add(datac);
        this.JP_PAINEL.add(nomec);
        this.JP_PAINEL.add(dataSeparador);
        this.JP_PAINEL.add(emailc);
        this.JP_PAINEL.add(emaileSeparador);
        this.JP_PAINEL.add(senhac);
        this.JP_PAINEL.add(senhaSeparador);

    }
    public void addBotoes(){
        JButton enviar = new JButton("Enviar");
        JButton login = new JButton("Voltar");
        JButton teste = new JButton("teste");
        Font font = new Font("Arial",Font.BOLD,12);

        teste.setBounds(190, 350, 135, 30);
        teste.setFont(font);
        teste.setForeground(Color.BLACK);

        enviar.setBounds(190, 315, 135, 30);
        enviar.setIcon(new ImageIcon("./img/img_ADM/img/botao.png"));
        enviar.setFont(font);
        enviar.setForeground(Color.BLACK);

        login.setBounds(40,315,135,30);
        login.setFont(font);
        login.setForeground(Color.BLACK);

        this.JP_PAINEL.add(login);
        this.JP_PAINEL.add(enviar);
        this.JP_PAINEL.add(teste);
    }



    public TelaCadastroCliente(String titulo) {
        super(titulo);
        //JScrollPane scroll = new JScrollPane(this.JP_PAINEL);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addPainel();

        this.addImagemUser();
        this.addImgLivraria();
        this.addFormLabel();
        this.addInputs();
        this.addBotoes();
        this.radioSexo();
        //this.add(scroll);



        //JScrollPane scroll = new JScrollPane(this.JP_PAINEL);
        //this.add(scroll);



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
