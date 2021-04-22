package SpaceUSER.Home.Ouvinte;

import Loja.Tela.Loja.TelaLoja;
import SpaceUSER.Home.Tela.TelaHomeUser;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteDosJButtons implements ActionListener {
    private TelaHomeUser tela;

    public OuvinteDosJButtons(TelaHomeUser tela){
        this.tela=tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch (button.getText()){
            case"Ir para a loja":
                this.tela.dispose();
                new TelaLoja(tela.getUser());
                break;
            case"Sair":
                this.tela.dispose();
                CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
                central.getLogin().setUsuario(-1);
                central.salvar();
                new TelaLoginCliente();

        }
    }
}
