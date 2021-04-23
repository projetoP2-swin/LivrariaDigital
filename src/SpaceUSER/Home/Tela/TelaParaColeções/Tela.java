package SpaceUSER.Home.Tela.TelaParaColeções;

import TelaPadrao.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Tela extends TelaPadrao {
    private JPanel painelTitulo;

    public Tela(ArrayList <Livro> livros, String label) {
        super("Minha Coleção");

        this.addJPainelTitulo();
        this.addLabelsIntoPainel(label);
        this.addTabela();
        this.addButton();
        this.addBackground();

        this.setVisible(true);
    }

    public void addJPainelTitulo(){
        painelTitulo = new JPanel();
        painelTitulo.setLayout(null);
        painelTitulo.setBounds(0,0,700,60);
        painelTitulo.setBackground(new Color(252, 203, 177, 163));
        this.add(this.painelTitulo);

    }

    public void addLabelsIntoPainel(String label){
        Font font = new Font("Impact",Font.PLAIN,40);
        JLabel colecao = new JLabel(label, JLabel.CENTER);
        colecao.setForeground(new Color(21, 27, 38, 248));
        colecao.setFont(font);
        colecao.setBounds(0, 5, 700, 45);
        this.painelTitulo.add(colecao);

    }

    public void addButton() {
        Color cor = new Color(102, 102, 102);
        Font font = new Font("Arial",Font.BOLD,13);
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(10, 325, 130, 30);
        voltar.setFont(font);
        voltar.setBackground(cor);
        //voltar.setBorder(null);

        this.add(voltar);
    }

    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    public void addTabela(){
        Font font = new Font("Arial",Font.PLAIN,13);
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Gênero");

        JTable tabela = new JTable();
        tabela.setModel(modelo);
        tabela.setBounds(10, 70, 665, 250);
        tabela.getColumn("ID").setMaxWidth(70);
        tabela.getColumn("Título").setMaxWidth(370);
        tabela.getColumn("Gênero").setMaxWidth(260);
        tabela.getTableHeader().setFont(font);
        tabela.getTableHeader().setForeground(Color.black);

        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setFont(font);
        tabela.setRowHeight(30);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 70, 665, 250);


        this.add(scroll);
    }





}
