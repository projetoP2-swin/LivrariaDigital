package Tela3_login_Cliente.Ouvintes;

import Criptografia.CriptografiaDeSenha;
import Persistencia.Central_de_informacoes.CentralDeInformacoes;
import Persistencia.PersistenciaAll.Persistencia;
import Persistencia.Usuario.Usuario;
import Tela2_login_ADM.Tela.TelaADM;
import Tela3_login_Cliente.Tela.TelaLoginCliente;
import Tela4_cadastro_cliente.Tela.TelaCadastroCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteDosButtons implements ActionListener {
    private TelaLoginCliente telaLoginCliente;

    public OuvinteDosButtons(TelaLoginCliente telaLoginCliente){
        this.telaLoginCliente = telaLoginCliente;

    }
    public String isLogin(){
        String email = telaLoginCliente.getEmail();

        String senha = telaLoginCliente.getSenha();

        Persistencia persistencia = new Persistencia();
        CentralDeInformacoes central = persistencia.recuperar();

        for(Usuario user: central.getUsuario()){
            if(user.getEmail().equals(email) &&
               CriptografiaDeSenha.descriptografia(user.getSenha()).equals(senha)){
                return user.getNome();

            }
        }
        return null;
    }
    public void estaLodadoQuestion(){
        String b = this.isLogin();
        if(b!=null){
            JOptionPane.showMessageDialog(telaLoginCliente,"<html>Você está logado<br>"+
                    ",Seja bem vindo, <html>"+b);
        }else{
            JOptionPane.showMessageDialog(telaLoginCliente,"Email ou senha incorretos");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();
        String nomeBtn = botao.getText();
        if(!nomeBtn.equals("Entrar")){
            telaLoginCliente.dispose();
        }
        if(nomeBtn.equals("Sou Livreiro")){
            new TelaADM("Livraria Digital - Livreiro");
        }else if(nomeBtn.equals("Cadastre-se")){
            new TelaCadastroCliente("Livraria Digital - Cadastro Clientes");
        }else{
            this.estaLodadoQuestion();
        }

    }
}
