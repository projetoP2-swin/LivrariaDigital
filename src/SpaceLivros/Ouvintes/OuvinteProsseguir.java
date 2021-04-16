package SpaceLivros.Ouvintes;

import SpaceLivros.ClassesDosLivros.Periodicos;
import SpaceLivros.Tela1AddLivro;
import SpaceLivros.Tela2Periodicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteProsseguir implements ActionListener {

    private Tela1AddLivro addLivro;


    public OuvinteProsseguir (Tela1AddLivro tela) {
        this.addLivro = tela;
    }

    public void actionPerformed(ActionEvent e) {
        if (addLivro.getTipos().getSelectedItem().equals("Periódico")) {
            addLivro.setVisible(false);
            Tela2Periodicos telap = new Tela2Periodicos();
            OuvinteVoltar ouvintev = new OuvinteVoltar(addLivro, telap);
            telap.getVoltar().addActionListener(ouvintev);
            OuvinteAdicionar ouvintea = new OuvinteAdicionar(addLivro, telap);
            telap.getAdicionar().addActionListener(ouvintea);

        }


    }
}
