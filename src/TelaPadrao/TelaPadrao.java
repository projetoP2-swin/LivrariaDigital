package TelaPadrao;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public abstract class TelaPadrao extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public TelaPadrao(String titulo) {
		Container div = this.getContentPane();
		div.setBackground(new Color(179, 179, 179));
		
		this.setTitle(titulo);
		this.setLayout(null);
		this.setSize(700,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	

}
