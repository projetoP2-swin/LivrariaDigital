package ClasseMain;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Tela1.TelaAddLivreiro;
import net.infonode.gui.laf.InfoNodeLookAndFeel;
import net.infonode.gui.laf.InfoNodeLookAndFeelTheme;

public class Main {

	public static void main(String[] args) {
		//TODO verificação se ja existe livreiro
		    try {
		    	InfoNodeLookAndFeelTheme theme = new InfoNodeLookAndFeelTheme("My Theme",
		    			new Color(166, 166, 166),
		    			new Color(0, 170, 0),
		    			new Color(102, 102, 102),
		    			Color.WHITE,
		    			new Color(0, 170, 0),
		    			Color.WHITE,
		    			0.8);

		    	
				UIManager.setLookAndFeel(new InfoNodeLookAndFeel(theme));
				TelaAddLivreiro livreiro = new TelaAddLivreiro("Livraria Digital - Adicionar Livreiro");
				livreiro.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Ocorreu um problema, entre em contato com o desenvolvedor");

			}
		
	}

}
