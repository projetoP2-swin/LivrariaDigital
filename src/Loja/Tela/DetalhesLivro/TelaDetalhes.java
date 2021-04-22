package Loja.Tela.DetalhesLivro;


import Loja.Imagens.Imagens;
import Loja.OuvintesDetalhes.OuvinteDosJButtons;
import TelaPadrao.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TelaDetalhes extends TelaPadrao {

    private Color corInfo = new Color(243, 109, 11, 255);
    private Font font = new Font("Arial",Font.BOLD,13);
    private JPanel back;
    private JPanel detalhesDoLivro;
    private JPanel painelComentarios;
    private  JTextArea comentario;
    private Livro livro;
    private Usuario user;

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUser() {
        return user;
    }

    public void chamaTodosOsMetodos(){
        this.addPainelDetalhes();
        this.addPainelComentarios();
        this.addPainelBackg();
        this.addButtons();
        this.addImagem();
        this.addFormDetalhes();
        this.addInfos();
        this.addComentario();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public TelaDetalhes(Livro livro) {
        super("Detalhes do Livro");

        this.livro = livro;
        this.chamaTodosOsMetodos();
    }

    public TelaDetalhes(Livro livro, Usuario user){
        super("Detalhes do Livro");

        this.livro = livro;
        this.user=user;
        this.chamaTodosOsMetodos();
    }

    public boolean isUser(){
        if(user==null){
            return true;
        }
        return false;
    }



    public void addPainelBackg() {
        back = new JPanel();
        back.setLayout(null);
        back.setBounds(0, 0, 700, 400);
        back.setBackground(Color.DARK_GRAY);
        this.add(back);

    }

    public void addPainelDetalhes() {
        detalhesDoLivro = new JPanel();
        detalhesDoLivro.setLayout(null);
        detalhesDoLivro.setBounds(10, 10, 230, 340);
        detalhesDoLivro.setBackground(Color.DARK_GRAY);
        this.detalhesDoLivro.setPreferredSize(new Dimension(0,1000));

        JScrollPane scroll = new JScrollPane(detalhesDoLivro);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10, 10,230 , 340);

        this.add(scroll);

    }

    public void addPainelComentarios() {
        painelComentarios = new JPanel();
        painelComentarios.setLayout(null);
        painelComentarios.setBounds(260, 10, 410, 145);
        painelComentarios.setBackground(new Color(95, 92, 92, 255));
        this.painelComentarios.setPreferredSize(new Dimension(0,300));

        JScrollPane scroll = new JScrollPane(painelComentarios);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(260, 10,410 , 145);

        this.add(scroll);

    }

    public void addImagem() {
        String tipo = "Desenvolvimento Pessoal,Literatura,Periódicos,Técnicos";
        ArrayList<String> tipos = new ArrayList<String>(Arrays.asList(tipo.split(",")));
        int index = tipos.indexOf(livro.getTIPO());
        JLabel simula = new JLabel(new ImageIcon(Imagens.todasAsImg[index]));
        simula.setBounds(40, 15, 135, 185);
        this.detalhesDoLivro.add(simula);
    }

    public void addFormDetalhes() {
        JLabel titulo = new JLabel("  Título:",JLabel.LEFT);
        JLabel tipo = new JLabel("  Tipo:",JLabel.LEFT);
        JLabel  resumo = new JLabel("  Resumo:",JLabel.LEFT);
        JLabel  idioma = new JLabel("  Idioma:",JLabel.LEFT);
        JLabel  genero = new JLabel("  Gênero:",JLabel.LEFT);
        JLabel  editora = new JLabel("  Editora:",JLabel.LEFT);
        JLabel  autor = new JLabel("  Autor:",JLabel.LEFT);
        JLabel quantidade = new JLabel("  Quantidade:",JLabel.LEFT);
        JLabel preco = new JLabel("  Preço:",JLabel.LEFT);

        titulo.setFont(font);
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(0, 215, 230, 20);

        tipo.setFont(font);
        tipo.setForeground(Color.WHITE);
        tipo.setBounds(0, 300, 230, 20);

        this.detalhesDoLivro.add(titulo);
        this.detalhesDoLivro.add(tipo);

        resumo.setFont(font);
        resumo.setForeground(Color.WHITE);
        resumo.setBounds(0, 385, 230, 20);
        this.detalhesDoLivro.add(resumo);

        idioma.setFont(font);
        idioma.setForeground(Color.WHITE);
        idioma.setBounds(0, 490, 230, 20);
        this.detalhesDoLivro.add(idioma);

        genero.setFont(font);
        genero.setForeground(Color.WHITE);
        genero.setBounds(0, 575, 230, 20);
        this.detalhesDoLivro.add(genero);

        editora.setFont(font);
        editora.setForeground(Color.WHITE);
        editora.setBounds(0, 660, 230, 20);
        this.detalhesDoLivro.add(editora);

        autor.setFont(font);
        autor.setForeground(Color.WHITE);
        autor.setBounds(0, 745, 230, 20);
        this.detalhesDoLivro.add(autor);

        quantidade.setFont(font);
        quantidade.setForeground(Color.WHITE);
        quantidade.setBounds(0, 830, 230, 20);
        this.detalhesDoLivro.add(quantidade);

        preco.setFont(font);
        preco.setForeground(Color.WHITE);
        preco.setBounds(0, 915, 230, 20);


        this.detalhesDoLivro.add(preco);
    }

    public void addInfos() {
        JTextArea titulo = new JTextArea(livro.getTitulo());

        titulo.setFont(font);
        titulo.setEnabled(this.isUser());
        titulo.setForeground(corInfo);
        titulo.setBounds(10, 235, 190, 50);
        titulo.setBackground(new Color(51, 51, 51));
        titulo.setLineWrap(true);
        titulo.setWrapStyleWord(true);
        this.detalhesDoLivro.add(titulo);

        JTextArea tipo = new JTextArea(livro.getTIPO());
        tipo.setForeground(corInfo);
        tipo.setEnabled(this.isUser());
        tipo.setBounds(10, 320, 190, 50);
        tipo.setFont(font);
        tipo.setBackground(new Color(51, 51, 51));
        tipo.setLineWrap(true);
        tipo.setWrapStyleWord(true);
        this.detalhesDoLivro.add(tipo);


        JTextArea resumoArea = new JTextArea(livro.getResumo());
        JScrollPane painel = new JScrollPane(resumoArea);
        painel.setBounds(10, 410, 190, 70);
        resumoArea.setEnabled(this.isUser());
        resumoArea.setFont(font);
        resumoArea.setForeground(corInfo);
        resumoArea.setBackground(new Color(51, 51, 51));
        resumoArea.setLineWrap(true);
        resumoArea.setWrapStyleWord(true);
        this.detalhesDoLivro.add(painel);


        JTextArea  idioma = new JTextArea(livro.getIdioma());
        idioma.setFont(font);
        idioma.setEnabled(this.isUser());
        idioma.setForeground(corInfo);
        idioma.setBounds(10, 510, 190, 50);
        idioma.setBackground(new Color(51, 51, 51));
        idioma.setLineWrap(true);
        idioma.setWrapStyleWord(true);
        this.detalhesDoLivro.add(idioma);

        JTextArea  genero = new JTextArea(livro.getGenero());
        genero.setFont(font);
        genero.setEnabled(this.isUser());
        genero.setForeground(corInfo);
        genero.setBounds(10, 595, 190, 50);
        genero.setBackground(new Color(51, 51, 51));
        genero.setLineWrap(true);
        genero.setWrapStyleWord(true);
        this.detalhesDoLivro.add(genero);

        JTextArea  editora = new JTextArea(livro.getEditora());
        editora.setFont(font);
        editora.setEnabled(this.isUser());
        editora.setForeground(corInfo);
        editora.setBounds(10, 680, 190, 50);
        editora.setBackground(new Color(51, 51, 51));
        editora.setLineWrap(true);
        editora.setWrapStyleWord(true);
        this.detalhesDoLivro.add(editora);

        JTextArea  autor = new JTextArea(livro.getAutor());
        autor.setFont(font);
        autor.setEnabled(this.isUser());
        autor.setForeground(corInfo);
        autor.setBounds(10, 765, 190, 50);
        autor.setBackground(new Color(51, 51, 51));
        autor.setLineWrap(true);
        autor.setWrapStyleWord(true);
        this.detalhesDoLivro.add(autor);

        JTextArea quantidade = new JTextArea(String.valueOf(livro.getQuantidade()));
        quantidade.setFont(font);
        quantidade.setEnabled(this.isUser());
        quantidade.setForeground(corInfo);
        quantidade.setBounds(10, 850, 190, 50);
        quantidade.setBackground(new Color(51, 51, 51));
        quantidade.setLineWrap(true);
        quantidade.setWrapStyleWord(true);
        this.detalhesDoLivro.add(quantidade);

        JTextArea preco = new JTextArea(String.valueOf(livro.getPreco()));
        preco.setFont(font);
        preco.setEnabled(this.isUser());
        preco.setForeground(corInfo);
        preco.setBounds(10, 935, 190, 50);
        preco.setBackground(new Color(51, 51, 51));
        preco.setLineWrap(true);
        preco.setWrapStyleWord(true);
        this.detalhesDoLivro.add(preco);


    }

    public void addComentario() {
        comentario = new JTextArea();
        JScrollPane painel = new JScrollPane(comentario);
        painel.setBounds(260, 220, 270, 128);
        comentario.setText("Deixe um comentário sobre o livro");
        comentario.setForeground(corInfo);
        comentario.setLineWrap(true);
        comentario.setFont(font);
        comentario.setWrapStyleWord(true);

        this.back.add(painel);

    }

    public void addButtons() {
        OuvinteDosJButtons ouvinte = new OuvinteDosJButtons(this);
        Color cor = new Color(102, 102, 102);

        JButton comprar = new JButton("Comprar");
        JButton addColecao = new JButton("Add a Coleção");
        JButton interesse = new JButton("Tenho interesse");
        JButton comentar = new JButton("Comentar");

        comprar.setBounds(260, 170, 130, 35);
        comprar.addActionListener(ouvinte);
        comprar.setFont(font);
        comprar.setBackground(cor);
        comprar.setBorder(null);

        addColecao.setBounds(400, 170, 130, 35);
        addColecao.setFont(font);
        addColecao.setBackground(cor);
        addColecao.setBorder(null);

        interesse.setBounds(540, 170, 130, 35);
        interesse.setFont(font);
        interesse.setBackground(cor);
        interesse.setBorder(null);

        comentar.setBounds(540, 270, 130, 25);
        comentar.setFont(font);
        comentar.setBackground(cor);
        comentar.setBorder(null);

        this.back.add(comprar);
        this.back.add(addColecao);
        this.back.add(interesse);
        this.back.add(comentar);

    }


}