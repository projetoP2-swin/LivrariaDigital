package SpaceADM.CadastroDeLivros.Tela.Tela;


import SpaceADM.CadastroDeLivros.Ouvintes.OuvinteCombo;
import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaAddLivro extends TelaPadrao {
    private final Color COR_PADRAO = new Color(128, 196, 255);
    public final JPanel JP_PAINEL =  new JPanel();
    private final Font FONT = new Font("Arial",Font.BOLD,13);

    public TelaAddLivro() {
        super("Adicionar Livro");
        this.addPainel();
        this.addScrollPane();
        this.addCabecalho(0);
        this.addBackground();
        this.setVisible(true);
    }

    private JTextField titulo;
    private JTextField imagem;
    private JTextArea resumo;
    private JTextField idioma;
    private JComboBox<String> tipos;
    private JTextField editora;
    private JTextField quantidade;
    private JTextField preco;

    public void addJLabelParaOtipo(String titulo){
        JLabel livro = new JLabel(titulo, JLabel.CENTER);
        Font font = new Font("Arial",Font.BOLD,17);

        livro.setBounds(0, 80, 290, 20);
        livro.setFont(font);

        this.JP_PAINEL.add(livro);
    }
    public void addPainel() {
        this.JP_PAINEL.setBounds(200, 0, 300, 330);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(null);


    }

    public void addScrollPane(){
        this.addPainel();
        JScrollPane scroll = new JScrollPane(JP_PAINEL);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(200, 15,300 , 330);
        this.add(scroll);

    }


    public void addCabecalho(int index) {
        Font font = new Font("Arial",Font.BOLD,17);
        JLabel titulo = new JLabel("Escolha o tipo de livro: ",JLabel.CENTER);

        titulo.setFont(font);
        titulo.setBounds(0,0,300,40);


        String[] arrayTipos = {"",
                "Literatura",
                "Periódico",
                "Desenvolvimento Pessoal",
                "Técnico"};

        tipos = new JComboBox(arrayTipos);
        tipos.setBackground(Color.DARK_GRAY);
        tipos.setSelectedIndex(index);
        tipos.addActionListener(new OuvinteCombo(this));
        tipos.setFont(FONT);
        tipos.setBounds(30, 45, 230, 25 );

        this.JP_PAINEL.add(tipos);
        this.JP_PAINEL.add(titulo);

    }

    public void addFormLabel() {
        JLabel titulo = new JLabel("Título:",JLabel.RIGHT);
        JLabel imagem = new JLabel("Imagem:",JLabel.RIGHT);
        JLabel resumo = new JLabel("Resumo:",JLabel.RIGHT);
        JLabel idioma = new JLabel("Idioma:",JLabel.RIGHT);
        JLabel editora = new JLabel("Editora:",JLabel.RIGHT);
        JLabel quantidade = new JLabel("Quantidade:",JLabel.CENTER);
        JLabel preco = new JLabel("Preço:",JLabel.RIGHT);

        titulo.setBounds(0, 120, 80, 20);
        titulo.setFont(FONT);

        imagem.setBounds(0, 155, 80, 20);
        imagem.setFont(FONT);

        resumo.setBounds(0, 190, 80, 20);
        resumo.setFont(FONT);

        idioma.setBounds(0, 265, 80, 20);
        idioma.setFont(FONT);

        editora.setBounds(0, 300, 80, 20);
        editora.setFont(FONT);

        quantidade.setBounds(0, 335, 110, 20);
        quantidade.setFont(FONT);

        preco.setBounds(150, 335, 60, 20 );
        preco.setFont(FONT);

        this.JP_PAINEL.add(resumo);
        this.JP_PAINEL.add(imagem);
        this.JP_PAINEL.add(titulo);
        this.JP_PAINEL.add(idioma);
        this.JP_PAINEL.add(editora);
        this.JP_PAINEL.add(quantidade);
        this.JP_PAINEL.add(preco);


    }

    public void addInputs() {
        Color corPadrao = new Color(128, 196, 255);

        titulo = new JTextField();
        titulo.setBounds(85, 118, 180, 25);
        titulo.setForeground(corPadrao);
        titulo.setFont(FONT);

        imagem = new JTextField();
        imagem.setBounds(85, 153, 180, 25);
        imagem.setForeground(corPadrao);
        imagem.setFont(FONT);

        resumo = new JTextArea();
        JScrollPane painel = new JScrollPane(resumo);
        painel.setBounds(85, 188, 180, 70);
        resumo.setLineWrap(true);
        resumo.setWrapStyleWord(true);

        idioma = new JTextField();
        idioma.setBounds(85, 263, 180, 25);
        idioma.setForeground(corPadrao);
        idioma.setFont(FONT);

        editora = new JTextField();
        editora.setBounds(85, 298, 180, 25);
        editora.setForeground(corPadrao);
        editora.setFont(FONT);

        quantidade = new JTextField();
        quantidade.setBounds(108, 333, 50, 25);
        quantidade.setForeground(corPadrao);
        quantidade.setFont(FONT);

        preco = new JTextField();
        preco.setBounds(215, 333, 50, 25);
        preco.setForeground(corPadrao);
        preco.setFont(FONT);


        this.JP_PAINEL.add(titulo);
        this.JP_PAINEL.add(imagem);
        this.JP_PAINEL.add(painel);
        this.JP_PAINEL.add(idioma);
        this.JP_PAINEL.add(editora);
        this.JP_PAINEL.add(quantidade);
        this.JP_PAINEL.add(preco);


    }

    public String getTitulo() {
        return titulo.getText();
    }

    public String getImagem() {
        return imagem.getText();
    }

    public String getResumo() {
        return resumo.getText();
    }

    public String getIdioma() {
        return idioma.getText();
    }


    public String getEditora() {
        return editora.getText();
    }


    public String getQuantidade() {
        return quantidade.getText();
    }

    public String getPreco() {
        return preco.getText();
    }

}
