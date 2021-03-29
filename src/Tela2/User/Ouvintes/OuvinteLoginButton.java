package Tela2.User.Ouvintes;

import Criptografia.CriptografiaDeSenha;
import Tela1.Persistencia.Livreiro;
import Tela1.Persistencia.PersistenciaADM;
import Tela2.User.Tela.TelaUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteLoginButton implements ActionListener {
    private TelaUser telaUser;

    public OuvinteLoginButton(TelaUser telaUser){
        this.telaUser=telaUser;
    }

    public boolean isLogin(){
        try {
            PersistenciaADM persistencia = new PersistenciaADM();
            Livreiro dadosLivreiro= persistencia.recuperarLivreiro();
            String email = dadosLivreiro.getEmail();
            String senha = new CriptografiaDeSenha().descriptografia(dadosLivreiro.getSenha());
            return telaUser.getSenha().equals(senha)&&
                   telaUser.getEmail().equals(email);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
    public void login(){
        boolean condicao = this.isLogin();
        if(condicao == true){
            JOptionPane.showMessageDialog(telaUser,"Você está logado");
        }else{
            JOptionPane.showMessageDialog(telaUser,"Email ou senha incorreto");
        }
    }

    public void esqueceuASenha(){

    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton) e.getSource();
        String nomeBtn = b.getText();

        if(nomeBtn.equals("Entrar")){
            this.login();
        }else{
            this.esqueceuASenha();
        }



    }
}
