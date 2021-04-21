package SpaceLIVROS;

import TelaPadrao.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import javax.swing.*;
import java.awt.*;

public class TelaLivro extends TelaPadrao {



    private Color corInfo = new Color(243, 109, 11, 255);
    private Font font = new Font("Arial",Font.BOLD,13);
    private JPanel back;
    private JPanel detalhesDoLivro;
    private JPanel painelComentarios;
    private  JTextArea comentario;
    private Livro livro;


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
        detalhesDoLivro.setBackground(new Color(246, 229, 186, 255));
        this.detalhesDoLivro.setPreferredSize(new Dimension(0,630));

        JScrollPane scroll = new JScrollPane(detalhesDoLivro);
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
        JPanel simula = new JPanel();
        simula.setLayout(null);
        simula.setBounds(40, 15, 135, 185);
        simula.setBackground(Color.BLUE);
        this.detalhesDoLivro.add(simula);
    }

    public void addFormDetalhes() {
        JLabel titulo = new JLabel("Título:");
        JLabel tipo = new JLabel("Tipo:");
        JLabel  resumo = new JLabel("Resumo:");
        JLabel  idioma = new JLabel("Idioma:");
        JLabel  genero = new JLabel("Gênero:");
        JLabel  editora = new JLabel("Editora:");
        JLabel  autor = new JLabel("Autor:");
        JLabel quantidade = new JLabel("Quantidade:");
        JLabel preco = new JLabel("Preço:");

        titulo.setFont(font);
        titulo.setForeground(Color.darkGray);
        titulo.setBounds(10, 210, 60, 20);

        tipo.setFont(font);
        tipo.setForeground(Color.darkGray);
        tipo.setBounds(10, 245, 40, 20);

        resumo.setFont(font);
        resumo.setForeground(Color.darkGray);
        resumo.setBounds(10, 280, 60, 20);

        idioma.setFont(font);
        idioma.setForeground(Color.darkGray);
        idioma.setBounds(10, 350, 60, 20);

        genero.setFont(font);
        genero.setForeground(Color.darkGray);
        genero.setBounds(10, 385, 60, 20);

        editora.setFont(font);
        editora.setForeground(Color.darkGray);
        editora.setBounds(10, 420, 60, 20);

        autor.setFont(font);
        autor.setForeground(Color.darkGray);
        autor.setBounds(10, 455, 40, 20);

        quantidade.setFont(font);
        quantidade.setForeground(Color.darkGray);
        quantidade.setBounds(10, 490, 80, 20);

        preco.setFont(font);
        preco.setForeground(Color.darkGray);
        preco.setBounds(10, 525, 45, 20);

        this.detalhesDoLivro.add(titulo);
        this.detalhesDoLivro.add(tipo);
        this.detalhesDoLivro.add(resumo);
        this.detalhesDoLivro.add(idioma);
        this.detalhesDoLivro.add(genero);
        this.detalhesDoLivro.add(editora);
        this.detalhesDoLivro.add(autor);
        this.detalhesDoLivro.add(quantidade);
        this.detalhesDoLivro.add(preco);
    }

    public void addInfos() {
        JLabel titulo = new JLabel(livro.getTitulo());
        JLabel tipo = new JLabel(livro.getTipo());
        JLabel  idioma = new JLabel(livro.getIdioma());
        JLabel  genero = new JLabel(livro.getGenero());
        JLabel  editora = new JLabel(livro.getEditora());
        JLabel  autor = new JLabel("nseii");
        JLabel quantidade = new JLabel(String.valueOf(livro.getQuantidade()));
        JLabel preco = new JLabel(String.valueOf(livro.getPreco()));

        titulo.setFont(font);
        titulo.setForeground(corInfo);
        titulo.setBounds(60, 210, 120, 20);

        tipo.setFont(font);
        tipo.setForeground(corInfo);
        tipo.setBounds(55, 245, 120, 20);

        idioma.setFont(font);
        idioma.setForeground(corInfo);
        idioma.setBounds(65, 350, 120, 20);

        genero.setFont(font);
        genero.setForeground(corInfo);
        genero.setBounds(70, 385, 120, 20);

        editora.setFont(font);
        editora.setForeground(corInfo);
        editora.setBounds(70, 420, 120, 20);

        autor.setFont(font);
        autor.setForeground(corInfo);
        autor.setBounds(60, 455, 120, 20);

        quantidade.setFont(font);
        quantidade.setForeground(corInfo);
        quantidade.setBounds(100, 490, 120, 20);

        preco.setFont(font);
        preco.setForeground(corInfo);
        preco.setBounds(60, 525, 120, 20);

        this.detalhesDoLivro.add(titulo);
        this.detalhesDoLivro.add(tipo);
        this.detalhesDoLivro.add(idioma);
        this.detalhesDoLivro.add(genero);
        this.detalhesDoLivro.add(editora);
        this.detalhesDoLivro.add(autor);
        this.detalhesDoLivro.add(quantidade);
        this.detalhesDoLivro.add(preco);


    }

    public void addResumo() {
        JTextArea resumoArea = new JTextArea();
        JScrollPane painel = new JScrollPane(resumoArea);
        painel.setBounds(80, 280, 120, 60);
        resumoArea.setEnabled(false);
        resumoArea.setText("Exemplo de resumo");
        resumoArea.setLineWrap(true);
        resumoArea.setWrapStyleWord(true);

        this.detalhesDoLivro.add(painel);
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
        Color cor = new Color(102, 102, 102);

        JButton comprar = new JButton("Comprar");
        JButton addColecao = new JButton("Add a Coleção");
        JButton interesse = new JButton("Tenho interesse");
        JButton comentar = new JButton("Comentar");

        comprar.setBounds(260, 170, 130, 35);
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




    public TelaLivro(Livro livro) {
        super("Detalhes do Livro");

        this.livro = livro;
        this.addPainelDetalhes();
        this.addPainelComentarios();
        this.addPainelBackg();
        this.addButtons();
        this.addImagem();
        this.addFormDetalhes();
        this.addResumo();
        this.addInfos();
        this.addComentario();

        this.setVisible(true);

    }
}
