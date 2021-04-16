package SpaceLivros;

import SpaceLivros.ClassesDosLivros.Periodicos;
import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class Tela2Periodicos extends TelaPadrao {

    private final JPanel JP_PAINEL =  new JPanel();
    private Font font = new Font("Arial",Font.BOLD,15);
    private Color azulzin = new Color(128, 196, 255);
    private JComboBox genero;
    private JComboBox meses;
    private JTextField numero;

    public int getNumero() {
        return Integer.parseInt(numero.getText());
    }

    private JButton voltar;
    private JButton adicionar;

    public JComboBox getGenero() {
        return genero;
    }

    public JComboBox getMeses() {
        return meses;
    }

    public void addPainel() {
        this.JP_PAINEL.setBounds(200, 15, 300, 330);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(null);
        this.add(JP_PAINEL);

    }

    public void addBackground() {
        ImageIcon img = new ImageIcon("img/img_ADM/img/livros.png");
        JLabel imgb = new JLabel();
        imgb.setBounds(0, 0, 700, 400);
        imgb.setIcon(img);
        this.add(imgb);

    }

    public void addFormLabel() {
        Font font2 = new Font("Arial",Font.BOLD,20);
        JLabel livro = new JLabel("Livro Periódico", JLabel.CENTER);
        JLabel genero = new JLabel("Gênero: ", JLabel.CENTER);
        JLabel mes = new JLabel("Mês de lançamento:", JLabel.CENTER);
        JLabel numero = new JLabel("Número da edição:", JLabel.CENTER);

        livro.setBounds(0, 20, 300, 30);
        livro.setFont(font2);

        genero.setBounds(0, 60, 300, 30);
        genero.setFont(font);

        mes.setBounds(0, 120, 300, 30);
        mes.setFont(font);

        numero.setBounds(0, 180, 300, 30);
        numero.setFont(font);

        this.JP_PAINEL.add(livro);
        this.JP_PAINEL.add(genero);
        this.JP_PAINEL.add(mes);
        this.JP_PAINEL.add(numero);

    }


    public JButton getAdicionar() {
        return adicionar;
    }

    public void addCombos() {
        Periodicos classe = new Periodicos();
        String[] arraymeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        String[] arraygenero = classe.getGeneroarray();
        genero = new JComboBox(arraygenero);
        genero.setBackground(Color.DARK_GRAY);
        genero.setFont(font);
        genero.setForeground(azulzin);
        genero.setBounds(50, 90, 200, 30);

        meses = new JComboBox(arraymeses);
        meses.setBackground(Color.DARK_GRAY);
        meses.setFont(font);
        meses.setBounds(50, 150, 200, 30);
        meses.setForeground(azulzin);


        this.JP_PAINEL.add(genero);
        this.JP_PAINEL.add(meses);


    }

    public void addInput() {
        numero = new JTextField();
        numero.setBounds(50, 210, 200, 30);
        numero.setForeground(azulzin);
        numero.setFont(font);

        this.JP_PAINEL.add(numero);

    }

    public void addButtons() {
        voltar = new JButton("Voltar");
        voltar.setBounds(30, 270,110, 30);
        voltar.setFont(font);
        voltar.setForeground(Color.BLACK);

        adicionar = new JButton("Adicionar");
        adicionar.setBounds(155, 270, 110, 30);
        adicionar.setFont(font);
        adicionar.setForeground(Color.BLACK);

        this.JP_PAINEL.add(voltar);
        this.JP_PAINEL.add(adicionar);

    }

    public JButton getVoltar() {
        return voltar;
    }

    public Tela2Periodicos() {
        super("Adicionar Livro - Periódicos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addPainel();
        this.addBackground();
        this.addFormLabel();
        this.addCombos();
        this.addInput();
        this.addButtons();
        this.setVisible(true);
    }
}
