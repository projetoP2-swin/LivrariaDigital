package Tela2_login_ADM.Ouvintes;

import Criptografia.CriptografiaDeSenha;
import Persistencia.Central_de_informacoes.CentralDeInformacoes;
import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaAll.Persistencia;
import Tela2_login_ADM.Tela.TelaADM;
import Tela3_login_Cliente.Tela.TelaLoginCliente;

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
            Persistencia persistencia = new Persistencia();
            CentralDeInformacoes central= persistencia.recuperar();
            Livreiro dadosLivreiro = central.getLivreiro();
            if(dadosLivreiro==null){
                return false;
            }
            String email = dadosLivreiro.getEmail();
            String senha = CriptografiaDeSenha.descriptografia(dadosLivreiro.getSenha());

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
