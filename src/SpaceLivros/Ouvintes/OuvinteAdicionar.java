package SpaceLivros.Ouvintes;

import SpaceLivros.ClassesDosLivros.Livro;
import SpaceLivros.ClassesDosLivros.Periodicos;
import SpaceLivros.Tela1AddLivro;
import SpaceLivros.Tela2Periodicos;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteAdicionar implements ActionListener {

    private Tela1AddLivro tela1;
    private Tela2Periodicos tela2;
    private static final Persistencia persistencia = Persistencia.getUnicaInstancia();
    private static final CentralDeInformacoes central = persistencia.recuperar();

    public OuvinteAdicionar (Tela1AddLivro tela1, Tela2Periodicos tela2) {
        this.tela1 = tela1;
        this.tela2 = tela2;

    }
    public void obterLivreiro() {

    }

    public void actionPerformed(ActionEvent e) {
        try {
            Livro l = null;
            if (tela1.getTipos().getSelectedItem().equals("Periódico")) {
                l = new Periodicos(tela1.getTitulo(), tela1.getCamporesumo(), tela1.getIdioma(),
                        (String) tela2.getGenero().getSelectedItem(), tela1.getEditora(), tela1.getAutor(), tela1.getQuantidade(),
                        tela1.getPreco(), (String) tela2.getMeses().getSelectedItem(), tela2.getNumero());


            }
            central.getLivreiro().adicionarLivro(l);
            central.salvar();
            tela2.dispose();
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");

        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar.");
        }

    }
}
