package Tela2_login_ADM.Ouvintes;

import Tela2_login_ADM.EsqueceuASenha.RecuperarSenha;
import Tela2_login_ADM.Tela.TelaADM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteDoEsqueceuASenha implements MouseListener {
    private TelaADM telaADM;

    public OuvinteDoEsqueceuASenha(TelaADM telaADM){
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
        thread.start();
        ImageIcon gif = new ImageIcon("img/img_ADM/load/Book.gif");
        label.setText("");
        label.setIcon(gif);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setForeground(new Color(252, 83, 28));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setForeground(Color.WHITE);

    }
}
