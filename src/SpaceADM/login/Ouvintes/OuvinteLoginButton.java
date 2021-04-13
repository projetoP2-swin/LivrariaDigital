package SpaceADM.login.Ouvintes;


import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceADM.login.Tela.TelaADM;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import Utilitarios.Persistencia.Central_de_informacoes.CentralDeInformacoes;
import Utilitarios.Persistencia.Livreiro.Livreiro;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import Utilitarios.criptografia.CriptografiaDeSenha;

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
            Persistencia persistencia = Persistencia.getUnicaInstancia();
            CentralDeInformacoes central= persistencia.recuperar();
            Livreiro dadosLivreiro = central.getLivreiro();
            String email = dadosLivreiro.getEmail();
            String senha = CriptografiaDeSenha.descriptografia(dadosLivreiro.getSenha());

            return telaADM.getSenha().equals(senha)&&
                    telaADM.getEmail().equals(email);

        } catch (Exception exception) {
            return false;
        }
    }

    public void login(){
        boolean condicao = this.isLogin();
        if(condicao){
            telaADM.dispose();
            TelaHomeADM tela = new TelaHomeADM("Home - Livreiro");
            tela.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(telaADM,"Email ou senha incorreto(s)");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e){
        JButton botao = (JButton) e.getSource();
        String nome = botao.getText();
        if(nome.equals("Entrar")){
            this.login();
        }else{
            telaADM.dispose();
            new TelaLoginCliente("Livraria Digital - Login Usuario");
        }

    }
}