package SpaceLivros.Ouvintes;

import SpaceLivros.Tela1AddLivro;
import SpaceLivros.Tela2Periodicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteVoltar implements ActionListener {

    private Tela1AddLivro tela1;
    private Tela2Periodicos tela2;

    public OuvinteVoltar (Tela1AddLivro addLivro, Tela2Periodicos add2) {
        this.tela1 = addLivro;
        this.tela2 = add2;
    }
    public void actionPerformed(ActionEvent e) {
        tela2.dispose();
        tela1.setVisible(true);

    }
}
