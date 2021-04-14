package SpaceUSER.Home;


import TelaPadrao.TelaPadrao;
import net.infonode.gui.laf.InfoNodeLookAndFeel;
import net.infonode.gui.laf.InfoNodeLookAndFeelTheme;

import javax.swing.*;
import java.awt.*;

public class TelaHomeUser extends TelaPadrao {
    private JPanel painelTitulo;
    private JScrollPane scroll;
    private JTextField pesquisa;
    //TODO mudar todos os cursores
    public TelaHomeUser() {
        super("Home");
        this.setSize(700,500);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.addJPainelTitulo();
        this.addLabelsIntoPainel();
        this.addImgGoToPerfil();
        this.addLabels();
        this.addComboBox();
        this.addPesquisa();
        this.addJScrollPane();
        this.addButtonDePesquisa();
        this.setVisible(true);
    }

    public void addJPainelTitulo(){
        painelTitulo = new JPanel();
        painelTitulo.setBounds(0,0,700,45);
        painelTitulo.setLayout(new BorderLayout());
        painelTitulo.setBackground(Color.GRAY);
        this.add(painelTitulo);
    }

    public void addLabelsIntoPainel(){
        Font font = new Font("Arial",Font.BOLD,22);
        JSeparator separador = new JSeparator();

        JLabel recomendados = new JLabel("Recomendados",JLabel.CENTER);
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
        categoria.setFont(font);
        this.add(categoria);

        filtrar.setBounds(245,50,210,30);
        filtrar.setForeground(Color.BLACK);
        filtrar.setFont(font);
        this.add(filtrar);

        ordenar.setBounds(465,50,210,30);
        ordenar.setForeground(Color.BLACK);
        ordenar.setFont(font);
        this.add(ordenar);
    }
    public void addComboBox(){
        String []categorias={"",
                "Literatura",
                "Técnicos",
                "Periódicos",
                "Desenvolvimento Pessoal"};

        String[] generos = {"","Literatura brasileira", "Literatura estrangeira",
                "Infanto juvenil", "Artes", "Biografias",
                "Poesia", "Gibi", "Revista de Notícias", "Autoajuda",
                "Religião", "Saúde", "Paradidático", "Formação profissional"};

        String [] ordem ={"","A-Z","Mais Procurados","Menos procurados","Em Falta"};

        JComboBox<String> categoria = new JComboBox(categorias);
        JComboBox<String> filtrar = new JComboBox(generos);
        JComboBox<String> ordenar = new JComboBox(ordem);
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
        this.pesquisa.setBackground(Color.WHITE);
        this.pesquisa.setFont(font);
        this.pesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.pesquisa.setForeground(Color.BLACK);



        this.add(this.pesquisa);

    }
    public void addButtonDePesquisa(){
        ImageIcon icon = new ImageIcon("img/loja/pesquisa.png");

        JButton button = new JButton(icon);

        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBackground(null);
        button.setBorder(null);
        button.setBounds(625,116,35,35);

        this.add(button);

    }
    public void addJScrollPane(){
        this.scroll = new JScrollPane();
        this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.scroll.setBackground(Color.WHITE);
        this.scroll.setBounds(26, 160,600 , 300);

        this.add(this.scroll);
    }

    public static void main(String[] args) {

        InfoNodeLookAndFeelTheme theme = new InfoNodeLookAndFeelTheme("My Theme",
                new Color(166, 166, 166),
                new Color(255, 255, 255),
                Color.DARK_GRAY,
                Color.WHITE,
                new Color(252, 83, 28),
                Color.WHITE,
                0.8);

        try {
            UIManager.setLookAndFeel(new InfoNodeLookAndFeel(theme));
            TelaHomeUser tela = new TelaHomeUser();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
