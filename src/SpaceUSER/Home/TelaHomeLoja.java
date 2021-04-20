package SpaceUSER.Home;


import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class TelaHomeLoja extends TelaPadrao {
    private JPanel painelTitulo,panelComScroll;
    private JPanel painelfiltros;
    private JScrollPane scroll;
    private JTextField pesquisa;
    private Color padraocombo = new Color(74, 148, 154, 255);

    public TelaHomeLoja() {
        super("Home");
        this.setSize(800,600);
        this.addJPainelTitulo();
        this.addPainelFiltros();
        this.addLabelsIntoPainel();
        this.addImgGoToPerfil();
        this.addLabels();
        this.addComboBox();
        this.addPesquisa();
        this.addJScrollPane();
        this.addButtonDePesquisa();
        this.addBackground();
        this.setVisible(true);
    }

    public void addJPainelTitulo(){
        painelTitulo = new JPanel();
        painelTitulo.setLayout(null);
        painelTitulo.setBounds(0,0,800,50);
        painelTitulo.setBackground(new Color(250, 196, 196, 163));
        this.add(this.painelTitulo);


    }

    public void addPainelFiltros() {
        painelfiltros = new JPanel();
        painelfiltros.setLayout(null);
        painelfiltros.setBounds(0, 50, 800, 70);
        painelfiltros.setBackground(new Color(245, 135, 104, 255));
        this.add(this.painelfiltros);
    }

    public void addLabelsIntoPainel(){
        Font font = new Font("Impact",Font.PLAIN,40);
        JLabel estantenome = new JLabel("Estante Virtual", JLabel.CENTER);
        estantenome.setForeground(Color.black);
        estantenome.setFont(font);
        estantenome.setBounds(0, 0, 800, 45);
        this.painelTitulo.add(estantenome);


    }

    /*public void addLabelsIntoPainel(){
        Font font = new Font("Impact",Font.PLAIN,40);
        JLabel estantenome = new JLabel("Estante Virtual", JLabel.CENTER);
        estantenome.setForeground(Color.DARK_GRAY);
        estantenome.setFont(font);
        estantenome.setBounds(0, 0, 700, 45);

        this.painelTitulo.add(estantenome);


    }*/

    public void addImgGoToPerfil(){
        ImageIcon perfil = new ImageIcon("img/loja/avatar.png");
        JLabel label = new JLabel(perfil, JLabel.RIGHT);
        label.setBounds(720,0, 50, 50);


        this.painelTitulo.add(label);

    }

    public void addLabels(){
        Font font = new Font("Arial",Font.BOLD,16);

        JLabel categoria = new JLabel("Categoria");
        JLabel filtrar = new JLabel("Filtrar");
        JLabel ordenar = new JLabel("Ordenar");
        JLabel pesquisar = new JLabel("Pesquisar");

        categoria.setBounds(60,3,100,22);
        categoria.setForeground(Color.BLACK);
        categoria.setFont(font);
        this.painelfiltros.add(categoria);

        filtrar.setBounds(277,3,100,22);
        filtrar.setForeground(Color.BLACK);
        filtrar.setFont(font);
        this.painelfiltros.add(filtrar);

        ordenar.setBounds(460,3,100,22);
        ordenar.setForeground(Color.BLACK);
        ordenar.setFont(font);
        this.painelfiltros.add(ordenar);

        pesquisar.setBounds(630, 3, 100, 22);
        pesquisar.setForeground(Color.BLACK);
        pesquisar.setFont(font);
        this.painelfiltros.add(pesquisar);
    }
    public void addComboBox(){
        String []categorias={"Todos os Livros",
                "Recomendados",
                "Literatura",
                "Técnicos",
                "Periódicos",
                "Desenvolvimento Pessoal"};

        String[] generos = {"Todos os Livros","Literatura brasileira", "Literatura estrangeira",
                "Infanto juvenil", "Artes", "Biografias",
                "Poesia", "Gibi", "Revista de Notícias", "Autoajuda",
                "Religião", "Saúde", "Paradidático", "Formação profissional"};

        String [] ordem ={"Todos os Livros","A-Z","Mais Procurados","Menos procurados","Em Falta"};
        JComboBox<String> categoria = new JComboBox<>(categorias);
        JComboBox<String> filtrar = new JComboBox<>(generos);
        JComboBox<String> ordenar = new JComboBox<>(ordem);
        Font font = new Font("Arial",Font.BOLD,13);

        categoria.setBackground(padraocombo);
        categoria.setForeground(Color.BLACK);
        categoria.setSelectedIndex(0);
        categoria.setFont(font);
        categoria.setBounds(10, 30, 180, 30 );
        this.painelfiltros.add(categoria);


        filtrar.setBackground(padraocombo);
        filtrar.setForeground(Color.BLACK);
        filtrar.setSelectedIndex(0);
        filtrar.setFont(font);
        filtrar.setBounds(205, 30, 180, 30 );
        this.painelfiltros.add(filtrar);

        ordenar.setBackground(padraocombo);
        ordenar.setForeground(Color.BLACK);
        ordenar.setBorder(null);
        ordenar.setSelectedIndex(0);
        ordenar.setFont(font);
        ordenar.setBounds(400, 30, 180, 30 );
        this.painelfiltros.add(ordenar);
    }

    public void addPesquisa(){
        Font font = new Font("Arial",Font.BOLD,13);

        this.pesquisa = new JTextField();
        this.pesquisa.setBounds(595,30,150,30);
        this.pesquisa.setBackground(padraocombo);
        this.pesquisa.setFont(font);
        this.pesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.pesquisa.setForeground(Color.BLACK);

        this.painelfiltros.add(this.pesquisa);


    }
    public void addButtonDePesquisa(){
        ImageIcon icon = new ImageIcon("img/loja/pesquisa.png");

        JLabel button = new JLabel(icon);

        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBackground(null);
        button.setBorder(null);
        button.setBounds(745,28,35,35);

        this.painelfiltros.add(button);


    }

    public void addJScrollPane(){
        this.panelComScroll = new JPanel();
        this.panelComScroll.setBounds(40, 155, 710, 370);
        this.panelComScroll.setBackground(new Color(255, 252, 197, 255));
        this.panelComScroll.setLayout(new GridLayout(6,5));
        this.panelComScroll.setPreferredSize(new Dimension(0,560));


        this.scroll = new JScrollPane(this.panelComScroll);
        this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.scroll.setBounds(40, 155,710 , 370);

        this.add(this.scroll);

    }

}

