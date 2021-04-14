package ClasseMain.ExisteLivreiro;

import SpaceADM.Cadastro.Tela.TelaAddLivreiro;
import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import TelaPadrao.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

public class ExisteLivreiroQuestion {

    private Persistencia persistencia = Persistencia.getUnicaInstancia();
    private CentralDeInformacoes central = persistencia.recuperar();

    private boolean existLivreiro(){
        try{
            central.getLivreiro();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private boolean existeLoginLivreiro(){
        try{
            boolean b = central.getLogin().isLivreiro();
            return b;
        }catch (Exception e){
            return false;
        }
    }

    public TelaPadrao primeiraTelaFactory() throws Exception{
        boolean existeLiveiero = existLivreiro();
        boolean existeLogin = existeLoginLivreiro();

        if(existeLiveiero && !existeLogin){
            return new TelaLoginCliente();

        }else if(existeLogin){
            return new TelaHomeADM();

        }else{
            return new TelaAddLivreiro();

        }
    }


}
