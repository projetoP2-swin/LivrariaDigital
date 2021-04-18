package SpaceADM.CadastroDeLivros.Tela.Componentes;


import Interfaces.Package_SpaceADM.ComponentesAddNaTela;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Periodicos implements ComponentesAddNaTela {
    private ArrayList<JComponent> componentes = new ArrayList<JComponent>();
    private JTextField numero;
    private JComboBox genero,meses;

    public Periodicos() {
        this.addFormLabel();
        this.addInput();
        this.addCombos();
    }


    public void addFormLabel() {
        Font font2 = new Font("Arial",Font.BOLD,17);
        JLabel genero = new JLabel("Gênero: ", JLabel.RIGHT);
        JLabel mes = new JLabel("  Mês de lançamento:", JLabel.LEFT);
        JLabel numero = new JLabel("  Número da edição:", JLabel.LEFT);



        genero.setBounds(0, 375, 80, 20);
        genero.setFont(FONT);

        mes.setBounds(0, 410, 170, 20);
        mes.setFont(FONT);

        numero.setBounds(0, 445, 170, 20);
        numero.setFont(FONT);

        componentes.add(genero);
        componentes.add(mes);
        componentes.add(numero);
    }
    public void addInput() {
        numero = new JTextField();
        numero.setBounds(165, 443, 110, 30);
        numero.setForeground(COR_PADRAO);
        numero.setFont(FONT);

        componentes.add(numero);

    }
    public void addCombos() {
        String[] arrayMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        String[] arrayGenero = {"Gibi", "Revista de notícias"};


        genero = new JComboBox(arrayGenero);
        genero.setBackground(Color.DARK_GRAY);
        genero.setFont(FONT);
        genero.setForeground(COR_PADRAO);
        genero.setBounds(90, 373, 188, 30);

        meses = new JComboBox(arrayMeses);
        meses.setBackground(Color.DARK_GRAY);
        meses.setFont(FONT);
        meses.setBounds(165, 408, 110, 30);
        meses.setForeground(COR_PADRAO);


        componentes.add(genero);
        componentes.add(meses);


    }


    @Override
    public ArrayList<JComponent> getComponentes() {
        return componentes;
    }

    @Override
    public ArrayList<String> getInfo() {

        ArrayList<String> informacoes = new ArrayList<String>();
        informacoes.add((String) genero.getSelectedItem());
        informacoes.add((String) meses.getSelectedItem());
        informacoes.add(numero.getText());

        return informacoes;
    }

    @Override
    public int getMaiorAltura() {
        return 445;
    }

    @Override
    public String getTipo() {
        return "Periódicos";
    }

}
