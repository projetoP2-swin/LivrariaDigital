package SpaceLivros.Ouvintes;

import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceLivros.Tela1AddLivro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteCancelar implements ActionListener {
    private Tela1AddLivro addLivro;
    private TelaHomeADM home;

    public OuvinteCancelar (Tela1AddLivro tela, TelaHomeADM home) {
        this.addLivro = tela;
        this.home = home;
    }

    public void actionPerformed(ActionEvent e) {
        addLivro.dispose();
        home.setVisible(true);
    }
}
