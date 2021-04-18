package SpaceADM.CadastroDeLivros.Tela.Componentes;

import Interfaces.Package_SpaceADM.ComponentesAddNaTela;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Literatura implements ComponentesAddNaTela {
    private ArrayList<JComponent> componentes = new ArrayList<JComponent>();
    private JComboBox<String> genero;
    private JTextField autoresInput;

    public Literatura(){
        this.addGenero();
        this.addLabels();
        this.addInput();
    }

    public String[] getGeneros() {
        return new String[] {
                "Literatura Brasileira",
                "Literatura Estrangeira",
                "Infanto Juvenil",
                "Artes",
                "Biografia",
                "Poesia"};
    }


    public void addGenero(){
        genero = new JComboBox(getGeneros());
        genero.setBackground(Color.DARK_GRAY);
        genero.setFont(FONT);
        genero.setForeground(COR_PADRAO);
        genero.setBounds(90, 375, 190, 30);

        this.componentes.add(genero);

    }

    public void addInput(){
        autoresInput = new JTextField();

        autoresInput.setBounds(90,410,178,30);
        autoresInput.setFont(FONT);

        this.componentes.add(autoresInput);
    }

    public void addLabels(){
        JLabel genero = new JLabel("Genero: ",JLabel.CENTER);
        JLabel autores = new JLabel("Autores: ", JLabel.CENTER);


        genero.setBounds(0,375,90,30);
        genero.setFont(FONT);

        autores.setBounds(0,410,90,30);
        autores.setFont(FONT);

        this.componentes.add(genero);
        this.componentes.add(autores);

    }

    @Override
    public ArrayList<JComponent> getComponentes() {
        return componentes;
    }

    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> informacoes = new ArrayList<String>();
        informacoes.add((String) genero.getSelectedItem());
        informacoes.add(autoresInput.getText());

        return informacoes;
    }

    @Override
    public int getMaiorAltura() {
        return 410;
    }

    @Override
    public String getTipo() {
        return "Literatura";
    }
}
