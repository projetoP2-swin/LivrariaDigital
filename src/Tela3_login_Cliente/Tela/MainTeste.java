package Tela3_login_Cliente.Tela;

import TelaPadrao.TelaPadrao;
import net.infonode.gui.laf.InfoNodeLookAndFeel;
import net.infonode.gui.laf.InfoNodeLookAndFeelTheme;

import javax.swing.*;
import java.awt.*;

public class MainTeste {

    public static void main(String[] args) {
        try {
            InfoNodeLookAndFeelTheme theme = new InfoNodeLookAndFeelTheme("My Theme",
                    new Color(166, 166, 166),
                    new Color(252, 83, 28),
                    Color.DARK_GRAY,
                    Color.WHITE,
                    new Color(252, 83, 28),
                    Color.WHITE,
                    0.8);


            UIManager.setLookAndFeel(new InfoNodeLookAndFeel(theme));
            TelaPadrao tela = new TelaLoginCliente("Livraria Digital - Cliente");
            tela.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um problema, entre em contato com o desenvolvedor");

        }

    }
}
