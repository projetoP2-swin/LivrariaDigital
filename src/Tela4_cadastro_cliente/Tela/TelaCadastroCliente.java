package Tela4_cadastro_cliente.Tela;

import Tela1_cadastro_ADM.Ouvintes.OuvinteDaClasseTelaAddLivreiro;
import Tela4_cadastro_cliente.Ouvintes.OuvinteDosButtons;
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
    private final JRadioButton RB_MASCULINO = new JRadioButton("Masculino", false);
    private final JRadioButton RB_FEMININO = new JRadioButton("Feminino", false);



    public void addPainel() { ;
        this.JP_PAINEL.setBounds(330, 0, 370, 400);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(null);
        this.JP_PAINEL.setPreferredSize(new Dimension(0,500));

    }
    public void addScrollPane(){
        this.addPainel();
        JScrollPane scroll = new JScrollPane(JP_PAINEL);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(330, 0,370 , 375);

        this.add(scroll);

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
        JLabel nomec = new JLabel("Nome:",JLabel.RIGHT);
        JLabel sexoc = new JLabel("Sexo:",JLabel.RIGHT);
        JLabel emailc = new JLabel("Email:",JLabel.RIGHT);
        JLabel senhac = new JLabel("Senha:",JLabel.RIGHT);
        JLabel datac = new JLabel("Nascimento:", JLabel.RIGHT);
        Font font = new Font("Arial",Font.BOLD,15);

        boasVindas.setBounds(150, 10, 370, 25);
        boasVindas.setFont(new Font("Arial",Font.BOLD,13));
        boasVindas.setForeground(Color.WHITE);



        JSeparator nomeSeparador = new JSeparator();
        nomeSeparador.setBounds(170, 75, 145, 100);
        nomeSeparador.setOrientation(JSeparator.HORIZONTAL);
        nomeSeparador.setBackground(Color.WHITE);

        nomec.setBounds(0, 45, 165, 30);
        nomec.setFont(font);

        sexoc.setBounds(0, 87, 165, 30);
        sexoc.setFont(font);

        datac.setBounds(0, 150, 165, 30 );
        datac.setFont(font);


        emailc.setBounds(0, 200, 100, 30);
        emailc.setFont(font);

        senhac.setBounds(0, 250, 100, 30);
        senhac.setFont(font);


        this.JP_PAINEL.add(boasVindas);
        this.JP_PAINEL.add(nomec);
        this.JP_PAINEL.add(datac);
        this.JP_PAINEL.add(emailc);
        this.JP_PAINEL.add(senhac);
        this.JP_PAINEL.add(sexoc);
        this.JP_PAINEL.add(nomeSeparador);
    }

    public void radioSexo () {
        this.RB_MASCULINO.setBounds(170, 90, 90, 25);
        this.RB_MASCULINO.setBackground(null);


        this.RB_FEMININO.setBounds(255, 90, 90, 25);
        this.RB_FEMININO.setBackground(null);

        ButtonGroup group = new ButtonGroup();
        group.add(this.RB_MASCULINO);
        group.add(this.RB_FEMININO);

        JSeparator sexoSeparador = new JSeparator();
        sexoSeparador.setBounds(170,130,145,100);
        sexoSeparador.setOrientation(JSeparator.HORIZONTAL);
        sexoSeparador.setBackground(Color.WHITE);

        this.JP_PAINEL.add(this.RB_MASCULINO);
        this.JP_PAINEL.add(this.RB_FEMININO);
        this.JP_PAINEL.add(sexoSeparador);
    }

    public void addInputs() throws ParseException {
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

        dataSeparador.setBounds(170,180,150,100);
        dataSeparador.setOrientation(JSeparator.HORIZONTAL);
        dataSeparador.setBackground(Color.WHITE);

        emaileSeparador.setBounds(115,227,200,100);
        emaileSeparador.setOrientation(JSeparator.HORIZONTAL);
        emaileSeparador.setBackground(Color.WHITE);

        senhaSeparador.setBounds(115,277,200,100);
        senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
        senhaSeparador.setBackground(Color.WHITE);


        MaskFormatter mascaraDeData = new MaskFormatter("##/##/####");
        this.datac = new JFormattedTextField(mascaraDeData);
        this.datac.setBounds(170, 153, 150, 25 );
        this.datac.setForeground(new Color(128, 196, 255));
        this.datac.setHorizontalAlignment(JLabel.CENTER);
        //this.datac.setBackground(Color.blue);
        this.datac.setBorder(null);
        this.datac.setFont(font);



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
        JButton voltar = new JButton("Voltar");
        OuvinteDosButtons ouvinte = new OuvinteDosButtons(this);

        Font font = new Font("Arial",Font.BOLD,12);


        enviar.setBounds(190, 315, 135, 30);
        enviar.setIcon(new ImageIcon("./img/img_ADM/img/botao.png"));
        enviar.setFont(font);
        enviar.addActionListener(ouvinte);
        enviar.setForeground(Color.BLACK);

        voltar.setBounds(40,315,135,30);
        voltar.setFont(font);
        voltar.addActionListener(ouvinte);
        voltar.setForeground(Color.BLACK);

        this.JP_PAINEL.add(voltar);
        this.JP_PAINEL.add(enviar);
    }



    public TelaCadastroCliente(String titulo) {
        super(titulo);
        try{
            //JScrollPane scroll = new JScrollPane(this.JP_PAINEL);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.addImagemUser();
            this.addImgLivraria();
            this.addFormLabel();
            this.addInputs();
            this.addBotoes();
            this.radioSexo();
            this.addScrollPane();

            this.setVisible(true);

        }catch(Exception e){

            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Houve um erro");
        }



    }

    public String getNome() {
        return nomec.getText();
    }

    public String getEmail() {
        return emailc.getText();
    }

    public String getSenha() {
        return senhac.getText();
    }

    public String getData(){
        return datac.getText();
    }

    public JRadioButton getRB_MASCULINO(){
        return this.RB_MASCULINO;
    }
    public JRadioButton getRB_FEMININO(){
        return this.RB_FEMININO;
    }

}
