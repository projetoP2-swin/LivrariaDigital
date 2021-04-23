package SpaceUSER.Home.Tela;

import SpaceUSER.Home.Tela.TelaParaColeções.Tela;
import net.infonode.gui.laf.InfoNodeLookAndFeel;
import net.infonode.gui.laf.InfoNodeLookAndFeelTheme;

import javax.swing.*;
import java.awt.*;

public class mainteste {

    public static void main(String[] args) {
        try {
            InfoNodeLookAndFeelTheme theme = new InfoNodeLookAndFeelTheme("My Theme",
                    new Color(166, 166, 166),
                    new Color(255, 255, 255),
                    Color.DARK_GRAY,
                    Color.WHITE,
                    new Color(252, 83, 28),
                    Color.WHITE,
                    0.8);

            UIManager.setLookAndFeel(new InfoNodeLookAndFeel(theme));
            Tela tela = new Tela(null, "Livros Comprados");


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um problema, entre em contato com o desenvolvedor");

        }

    }

}
