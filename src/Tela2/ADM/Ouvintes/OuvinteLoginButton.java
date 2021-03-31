package Tela2.ADM.Ouvintes;

import Criptografia.CriptografiaDeSenha;
import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaLivreiro.PersistenciaADM;
import Tela2.ADM.EsqueceuASenha.RecuperarSenha;
import Tela2.ADM.Tela.TelaADM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteLoginButton implements ActionListener {
    private TelaADM telaADM;

    public OuvinteLoginButton(TelaADM telaADM){
        this.telaADM = telaADM;
    }

    public boolean isLogin(){
        try {
            PersistenciaADM persistencia = new PersistenciaADM();
            Livreiro dadosLivreiro= persistencia.recuperarLivreiro();
            String email = dadosLivreiro.getEmail();
            String senha = new CriptografiaDeSenha().descriptografia(dadosLivreiro.getSenha());

            return telaADM.getSenha().equals(senha)&&
                    telaADM.getEmail().equals(email);

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public void login(){
        boolean condicao = this.isLogin();
        if(condicao){
            JOptionPane.showMessageDialog(telaADM,"Você está logado");
        }else{
            JOptionPane.showMessageDialog(telaADM,"Email ou senha incorreto(s)");
        }
    }





    @Override
    public void actionPerformed(ActionEvent e){
            this.login();




    }
}
