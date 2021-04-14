package SpaceADM.Home.Ouvinte;

import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceADM.login.Tela.TelaLoginADM;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Info_Login.LoginSingleton;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        this.btnSair();

    }
}
