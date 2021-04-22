package Loja.OuvintesDetalhes;

import Loja.Tela.DetalhesLivro.TelaDetalhes;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteDosJButtons implements ActionListener {

    private TelaDetalhes tela;
    public OuvinteDosJButtons(TelaDetalhes tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();

        switch (botao.getText()){
            case"Comprar":
                Livro l = tela.getLivro();
                CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
                Usuario u = tela.getUser();
                central.getUsuario().remove(u);
                l.setNumeroDeVisualizacoes(-1);
                u.addCompras(l);
                central.addUser(u);
                central.salvar();
                System.out.println(u.getCompras());
        }
    }
}
