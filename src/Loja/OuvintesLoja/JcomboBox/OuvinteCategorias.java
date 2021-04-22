package Loja.OuvintesLoja.JcomboBox;

import Loja.Tela.Loja.TelaLoja;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuvinteCategorias implements ActionListener {

    private TelaLoja tela;


    public OuvinteCategorias(TelaLoja tela) {
        this.tela=tela;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox combo= (JComboBox) e.getSource();
        String tipo = (String) combo.getItemAt(0);

        ArrayList<Livro> finalLivros = this.tela.LIVROS;

        if(tipo.equals("Todos os Livros")){
            String volta = (String) combo.getSelectedItem();
            if(volta.equals("Todos os Livros")){
                this.tela.limpaPlanilha();
                this.tela.addLivros(this.tela.LIVROS);

            }else{
                ArrayList<Livro> l = new ArrayList<Livro>();
                for(Livro livro : this.tela.LIVROS){
                    if(livro.getTIPO().equals(volta)){
                        l.add(livro);
                    }
                }
                this.tela.limpaPlanilha();
                this.tela.addLivros(l);
            }
        }

    }
}
