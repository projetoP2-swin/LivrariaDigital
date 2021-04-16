package SpaceUSER.Home;


import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class TelaHomeUser extends TelaPadrao {
    private JPanel painelTitulo,panelComScroll;
    private JScrollPane scroll;
    private JTextField pesquisa;

    public TelaHomeUser() {
        super("Home");
        this.setSize(700,500);
        this.addJPainelTitulo();
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
        painelTitulo.setBounds(0,0,700,45);
        painelTitulo.setBackground(new Color(204, 230, 255));
        painelTitulo.setLayout(new BorderLayout());
        this.add(this.painelTitulo);
    }

    public void addLabelsIntoPainel(){
        Font font = new Font("Arial",Font.BOLD,22);
        JSeparator separador = new JSeparator();

        JLabel recomendados = new JLabel("Estante Virtual",JLabel.CENTER);
        recomendados.setFont(font);
        recomendados.setForeground(Color.BLACK);

        separador.setOrientation(JSeparator.HORIZONTAL);
        separador.setBounds(0,45,700,60);
        separador.setBackground(Color.BLACK);
        this.add(separador);

        this.painelTitulo.add(recomendados, BorderLayout.CENTER);


    }

    public void addImgGoToPerfil(){
        ImageIcon perfil = new ImageIcon("img/loja/avatar.png");
        JLabel label = new JLabel(perfil);
        JLabel complemento = new JLabel("                   ");

        this.painelTitulo.add(label,BorderLayout.EAST);
        this.painelTitulo.add(complemento,BorderLayout.WEST);
    }

    public void addLabels(){
        Font font = new Font("Arial",Font.BOLD,19);

        JLabel categoria = new JLabel("Categoria",JLabel.CENTER);
        JLabel filtrar = new JLabel("Filtrar",JLabel.CENTER);
        JLabel ordenar = new JLabel("Ordenar",JLabel.CENTER);

        categoria.setBounds(25,50,210,30);
        categoria.setForeground(Color.BLACK);
        categoria.setOpaque(true);
        categoria.setBackground(new Color(252, 83, 28));
        categoria.setFont(font);
        this.add(categoria);

        filtrar.setBounds(235,50,230,30);
        filtrar.setForeground(Color.BLACK);
        filtrar.setOpaque(true);
        filtrar.setBackground(new Color(252, 83, 28));
        filtrar.setFont(font);
        this.add(filtrar);

        ordenar.setBounds(465,50,210,30);
        ordenar.setForeground(Color.BLACK);
        ordenar.setOpaque(true);
        ordenar.setBackground(new Color(252, 83, 28));
        ordenar.setFont(font);
        this.add(ordenar);
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

        categoria.setBackground(Color.GRAY);
        categoria.setForeground(Color.BLACK);
        categoria.setSelectedIndex(0);
        categoria.setFont(font);
        categoria.setBounds(25, 80, 210, 30 );
        this.add(categoria);


        filtrar.setBackground(Color.GRAY);
        filtrar.setForeground(Color.BLACK);
        filtrar.setSelectedIndex(0);
        filtrar.setFont(font);
        filtrar.setBounds(245, 80, 210, 30 );
        this.add(filtrar);

        ordenar.setBackground(Color.GRAY);
        ordenar.setForeground(Color.BLACK);
        ordenar.setSelectedIndex(0);
        ordenar.setFont(font);
        ordenar.setBounds(465, 80, 210, 30 );
        this.add(ordenar);
    }

    public void addPesquisa(){
        Font font = new Font("Arial",Font.BOLD,12);

        this.pesquisa = new JTextField();
        this.pesquisa.setBounds(465,120,150,25);
        this.pesquisa.setBackground(new Color(204, 230, 255));
        this.pesquisa.setFont(font);
        this.pesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.pesquisa.setForeground(Color.BLACK);

        this.add(this.pesquisa);


    }
    public void addButtonDePesquisa(){
        ImageIcon icon = new ImageIcon("img/loja/pesquisa.png");

        JLabel button = new JLabel(icon);

        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBackground(null);
        button.setBorder(null);
        button.setBounds(625,116,35,35);

        this.add(button);


    }

    public void addJScrollPane(){
        this.panelComScroll = new JPanel();
        this.panelComScroll.setBounds(50, 160, 600, 300);
        this.panelComScroll.setBackground(new Color(204, 230, 255));
        this.panelComScroll.setLayout(new GridLayout(6,5));
        this.panelComScroll.setPreferredSize(new Dimension(0,560));


        this.scroll = new JScrollPane(this.panelComScroll);
        this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.scroll.setBounds(50, 160,600 , 300);

        this.add(this.scroll);

    }

}

