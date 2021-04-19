package SpaceADM.Home.Ouvinte;

import SpaceADM.CadastroDeLivros.Tela.Tela.TelaAddLivro;
import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceADM.login.Tela.TelaLoginADM;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Info_Login.LoginSingleton;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteDosButtons implements ActionListener {

    private TelaHomeADM  tela;

    public OuvinteDosButtons(TelaHomeADM tela){
        this.tela=tela;
    }

    public String btnSair(){
        Persistencia persistencia = Persistencia.getUnicaInstancia();
        CentralDeInformacoes central = persistencia.recuperar();
        LoginSingleton login = LoginSingleton.getUnicaInstancia();
        login.setLivreiro(false);
        central.addLogin(login);
        central.salvar();
        tela.dispose();
        new TelaLoginADM();

        return "";
    }

    public void btnCadastrarLivro(){
        tela.dispose();
        new TelaAddLivro();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch (btn.getText()){
            case"Sair":
                this.btnSair();
                break;
            case"Cadastrar Livro":
                this.btnCadastrarLivro();
                break;
        }

    }
}
