package Tela2_login_ADM.Ouvintes;

import Criptografia.CriptografiaDeSenha;
import Persistencia.Central_de_informacoes.CentralDeInformacoes;
import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaLivreiro.PersistenciaADM;
import Tela2_login_ADM.Tela.TelaADM;

import javax.swing.*;
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
            CentralDeInformacoes central= (CentralDeInformacoes) persistencia.recuperarLivreiro();
            Livreiro dadosLivreiro = central.getLivreiro();
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
