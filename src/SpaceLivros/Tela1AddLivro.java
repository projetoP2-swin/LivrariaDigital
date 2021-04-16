package SpaceLivros;

import SpaceLivros.Ouvintes.OuvinteProsseguir;
import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class Tela1AddLivro extends TelaPadrao {
    private final JPanel JP_PAINEL =  new JPanel();
    private  Font font = new Font("Arial",Font.BOLD,13);
    private JComboBox<String> tipos;

    public String getCamporesumo() {
        return camporesumo.getText();
    }

    private JTextArea camporesumo;
    private JTextField titulo;
    private JTextField imagem;
    private JTextField idioma;
    private JTextField editora;
    private JTextField autor;
    private JTextField quantidade;
    private JTextField preco;

    public String getTitulo() {
        return titulo.getText();
    }

    public String getIdioma() {
        return idioma.getText();
    }

    public String getEditora() {
        return editora.getText();
    }

    public String getAutor() {
        return autor.getText();
    }

    public int getQuantidade() {
        return Integer.parseInt(quantidade.getText());
    }

    public float getPreco() {
        return Float.parseFloat(preco.getText());
    }


    private JButton cancelar;

    public JComboBox<String> getTipos() {
        return tipos;
    }
    public JButton getCancelar() {
        return cancelar;
    }

    private JButton prosseguir;

    public void addPainel() {
        this.JP_PAINEL.setBounds(200, 0, 300, 330);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(null);
        this.JP_PAINEL.setPreferredSize(new Dimension(0,390));

    }

    public void addScrollPane(){
        this.addPainel();
        JScrollPane scroll = new JScrollPane(JP_PAINEL);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(200, 15,300 , 330);
        this.add(scroll);

    }

    public void addBackground() {
        ImageIcon img = new ImageIcon("img/img_ADM/img/livros.png");
        JLabel imgb = new JLabel();
        imgb.setBounds(0, 0, 700, 400);
        imgb.setIcon(img);
        this.add(imgb);

    }

    public void addFormLabel() {
        JLabel titulo = new JLabel("Título:");
        JLabel imagem = new JLabel("Imagem:");
        JLabel resumo = new JLabel("Resumo:");
        JLabel idioma = new JLabel("Idioma:");
        JLabel tipo = new JLabel("Tipo:");
        JLabel editora = new JLabel("Editora:");
        JLabel autor = new JLabel("Autor:");
        JLabel quantidade = new JLabel("Quantidade:");
        JLabel preco = new JLabel("Preço:");

        titulo.setBounds(15, 15, 50, 20);
        titulo.setFont(font);

        imagem.setBounds(15, 50, 60, 20);
        imagem.setFont(font);

        resumo.setBounds(15, 85, 60, 20);
        resumo.setFont(font);

        idioma.setBounds(15, 170, 60, 20);
        idioma.setFont(font);

        tipo.setBounds(15, 205, 60, 20);
        tipo.setFont(font);

        editora.setBounds(15, 240, 60, 20);
        editora.setFont(font);

        autor.setBounds(15, 275, 60, 20);
        autor.setFont(font);

        quantidade.setBounds(15, 305, 80, 20);
        quantidade.setFont(font);

        preco.setBounds(160, 305, 60, 20 );
        preco.setFont(font);


        this.JP_PAINEL.add(titulo);
        this.JP_PAINEL.add(imagem);
        this.JP_PAINEL.add(resumo);
        this.JP_PAINEL.add(idioma);
        this.JP_PAINEL.add(tipo);
        this.JP_PAINEL.add(editora);
        this.JP_PAINEL.add(autor);
        this.JP_PAINEL.add(quantidade);
        this.JP_PAINEL.add(preco);

    }

    public void addInputs() {
        Color azulzin = new Color(128, 196, 255);
        camporesumo = new JTextArea("Resumo do livro");
        JScrollPane painel = new JScrollPane(camporesumo);
        painel.setBounds(85, 85, 180, 70);
        camporesumo.setLineWrap(true);
        camporesumo.setWrapStyleWord(true);

        titulo = new JTextField();
        titulo.setBounds(85, 13, 180, 25);
        titulo.setForeground(azulzin);

        titulo.setFont(font);

        imagem = new JTextField();
        imagem.setBounds(85, 48, 180, 25);
        imagem.setForeground(azulzin);
        imagem.setFont(font);

        idioma = new JTextField();
        idioma.setBounds(85, 168, 180, 25);
        idioma.setForeground(azulzin);
        idioma.setFont(font);

        editora = new JTextField();
        editora.setBounds(85, 238, 180, 25);
        editora.setForeground(azulzin);
        editora.setFont(font);

        autor = new JTextField();
        autor.setBounds(85, 273, 180, 25);
        autor.setForeground(azulzin);
        autor.setFont(font);

        quantidade = new JTextField();
        quantidade.setBounds(98, 303, 50, 25);
        quantidade.setForeground(azulzin);
        quantidade.setFont(font);

        preco = new JTextField();
        preco.setBounds(215, 303, 50, 25);
        preco.setForeground(azulzin);
        preco.setFont(font);





        this.JP_PAINEL.add(painel);
        this.JP_PAINEL.add(titulo);
        this.JP_PAINEL.add(imagem);
        this.JP_PAINEL.add(idioma);
        this.JP_PAINEL.add(editora);
        this.JP_PAINEL.add(autor);
        this.JP_PAINEL.add(quantidade);
        this.JP_PAINEL.add(preco);

    }

    public void addComboTipos() {
        String[] arrayTipos = {".", "Literatura", "Periódico", "Desenvolvimento Pessoal", "Técnico"};
        tipos = new JComboBox(arrayTipos);
        tipos.setBackground(Color.DARK_GRAY);
        tipos.setSelectedIndex(0);
        tipos.setFont(font);
        tipos.setBounds(85, 200, 180, 25 );

        this.JP_PAINEL.add(tipos);

    }

    public void addButtons() {

        cancelar = new JButton("Cancelar");
        prosseguir = new JButton("Prosseguir");

        cancelar.setBounds(15,345,110,30);
        cancelar.setFont(font);
        cancelar.setForeground(Color.BLACK);

        OuvinteProsseguir ouvintep = new OuvinteProsseguir(this);
        prosseguir.setBounds(155,345,110,30);
        prosseguir.setFont(font);
        prosseguir.setForeground(Color.BLACK);
        prosseguir.addActionListener(ouvintep);

        this.JP_PAINEL.add(cancelar);
        this.JP_PAINEL.add(prosseguir);
    }





    public Tela1AddLivro() {
        super("Adicionar Livro");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addPainel();
        this.addScrollPane();
        this.addBackground();
        this.addFormLabel();
        this.addInputs();
        this.addComboTipos();
        this.addButtons();
        this.setVisible(true);




    }
}
