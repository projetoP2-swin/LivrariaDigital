package Tela2.ADM.Ouvintes;

import Tela2.ADM.EsqueceuASenha.RecuperarSenha;
import Tela2.ADM.Tela.TelaADM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteDoJLabel implements MouseListener {
    private TelaADM telaADM;

    public OuvinteDoJLabel(TelaADM telaADM){
        this.telaADM = telaADM;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setText("dasdas");
        Thread thread = new Thread(() -> {
            try{
                new RecuperarSenha(telaADM,label);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(telaADM,
                        "Houve algum problema","Recuperação de senha",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ImageIcon gif = new ImageIcon("img/addLivreiro/CarregandoGIF/load.gif");
        label.setText("");
        label.setIcon(gif);
        thread.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setForeground(new Color(51, 255, 51));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setForeground(Color.WHITE);

    }
}
