package SpaceADM.Home.Ouvinte;

import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceADM.login.Tela.TelaLoginADM;
import SpaceLivros.Ouvintes.OuvinteCancelar;
import SpaceLivros.Tela1AddLivro;
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

    private final String []NOMES_DOS_BTN = {
            "Cadastrar Livro","Ver a loja",
            "Mais interessados","Mais visualizados",
            "Carregar planilha","Sair"};

    public void btnSair(){
        Persistencia persistencia = Persistencia.getUnicaInstancia();
        CentralDeInformacoes central = persistencia.recuperar();
        LoginSingleton login = LoginSingleton.getUnicaInstancia();
        login.setLivreiro(false);
        central.addLogin(login);
        central.salvar();
        tela.dispose();
        new TelaLoginADM();
    }

    public void btnCadastrar() {
        tela.setVisible(false);
        Tela1AddLivro telaadd = new Tela1AddLivro();
        telaadd.getCancelar().addActionListener(new OuvinteCancelar(telaadd, tela));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton botao = (JButton) e.getSource();

        if (botao.getText().equals(NOMES_DOS_BTN[0])) {
            this.btnCadastrar();

        } else if (botao.getText().equals(NOMES_DOS_BTN[5])) {
            this.btnSair();
        }



    }
}
