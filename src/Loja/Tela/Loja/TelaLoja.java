package Loja.Tela.Loja;
import Loja.OuvintesLoja.JTable.OuvinteDosJTable;
import Loja.OuvintesLoja.JcomboBox.OuvinteCategorias;
import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceUSER.Home.Tela.TelaHomeUser;
import TelaPadrao.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class TelaLoja extends TelaPadrao {
    private JPanel painelTitulo;
    private JPanel painelfiltros;
    private JTextField pesquisa;
    private Color padraocombo = new Color(74, 148, 154, 255);
    public final ArrayList<Livro> LIVROS = Persistencia.getUnicaInstancia().recuperar().getLivros();

    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public void chamaMetodosIniciais(){
        this.setSize(800,500);
        this.addJPainelTitulo();
        this.addPainelFiltros();
        this.addLabelsIntoPainel();
        this.addImgGoToPerfil();
        this.addLabels();
        this.addPesquisa();
        this.addTabela();
        this.addComboBox();
        this.addBackground();
        this.setVisible(true);
    }

    public TelaLoja() {
        super("Loja");
        this.chamaMetodosIniciais();
    }

    public TelaLoja(Usuario user){
        super("Loja");
        this.user=user;
        this.chamaMetodosIniciais();
    }

    public void addImgGoToPerfil(){
        ImageIcon perfil = new ImageIcon("img/loja/avatar.png");
        JLabel label = new JLabel(perfil,JLabel.RIGHT);
        label.setBounds(720,0, 50, 50);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                if(getUser()==null){
                    new TelaHomeADM();
                }else{
                    new TelaHomeUser(getUser());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());


            }
        });
        this.painelTitulo.add(label);

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
        Font font = new Font("Impact",Font.BOLD,40);
        JLabel estantenome = new JLabel("Estante Virtual", JLabel.CENTER);
        estantenome.setForeground(Color.black);
        estantenome.setFont(font);
        estantenome.setBounds(0, 0, 800, 45);
        this.painelTitulo.add(estantenome);


    }

    public void addLabels(){
        Font font = new Font("Arial",Font.BOLD,16);
        JLabel categoria = new JLabel("Filtragem",JLabel.CENTER);
        JLabel pesquisar = new JLabel("Pesquisar",JLabel.CENTER);

        categoria.setBounds(260,3,260,22);
        categoria.setForeground(Color.BLACK);
        categoria.setFont(font);
        this.painelfiltros.add(categoria);

        pesquisar.setBounds(550, 3, 250, 22);
        pesquisar.setForeground(Color.BLACK);
        pesquisar.setFont(font);
        this.painelfiltros.add(pesquisar);
    }

    public void addComboBox(){
        String[] generos = {"Todos os Livros",
                "Recomendados",
                "Literatura",
                "Técnicos",
                "Periódicos",
                "Desenvolvimento Pessoal",
                "Em Falta"};


        JComboBox<String> filtrar = new JComboBox<>(generos);
        filtrar.addActionListener(new OuvinteCategorias(this));

        Font font = new Font("Arial",Font.BOLD,13);
        filtrar.setBackground(padraocombo);
        filtrar.setForeground(Color.BLACK);
        filtrar.setSelectedIndex(0);
        filtrar.setFont(font);
        filtrar.setBounds(255, 30, 255, 30 );
        this.painelfiltros.add(filtrar);

    }

    public void addPesquisa(){
        Font font = new Font("Arial",Font.BOLD,13);

        this.pesquisa = new JTextField();
        this.pesquisa.setBounds(595,30,150,30);
        this.pesquisa.setBackground(padraocombo);
        this.pesquisa.setFont(font);
        this.pesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.pesquisa.setForeground(Color.BLACK);
        this.pesquisa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Character c = e.getKeyChar();
                String letras = pesquisa.getText()+Character.toString(c).toLowerCase();
                ArrayList<Livro> l = new ArrayList<>();
                for(Livro livro :LIVROS){
                    if(livro.getTitulo().toLowerCase().contains(letras)){
                        l.add(livro);
                    }
                }if(l.isEmpty()){
                    l=LIVROS;
                }
                limpaPlanilha();
                addLivros(l);

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.painelfiltros.add(this.pesquisa);


    }
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    public void limpaPlanilha(){
        int index = modelo.getRowCount();
        if(index !=0){
            for(int a = index; a> 0; a--){
                this.modelo.removeRow(a-1);
            }
        }
    }
    private ArrayList<Livro> l;
    public void addLivros(ArrayList<Livro> livros){
        for(Livro livro: livros){
            Object ob [] = {livros.indexOf(livro),livro.getTitulo(),livro.getTIPO()};
            modelo.addRow(ob);
        }
        this.l =livros;
    }
    public ArrayList<Livro> getLivros(){
        return l;
    }
    public void addTabela(){
        Font font = new Font("Arial",Font.PLAIN,13);
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Gênero");

        JTable tabela = new JTable();
        tabela.setModel(modelo);
        tabela.setBounds(50, 155, 690, 290);
        tabela.getColumn("ID").setMaxWidth(70);
        tabela.getColumn("Título").setMaxWidth(370);
        tabela.getColumn("Gênero").setMaxWidth(260);
        tabela.getTableHeader().setFont(font);
        tabela.getTableHeader().setForeground(Color.black);

        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new OuvinteDosJTable(this));
        tabela.setFont(font);
        tabela.setRowHeight(30);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(50, 155, 690, 290);


        this.add(scroll);


    }

}

