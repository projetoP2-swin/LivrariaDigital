package ClasseMain.ExisteLivreiro;

import SpaceADM.Cadastro.Tela.TelaAddLivreiro;
import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceUSER.Home.Tela.TelaHomeUser;
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
        boolean existeLoginLivreiro = existeLoginLivreiro();
        int existeLoginUsuario;
        try{
            existeLoginUsuario = central.getLogin().getUsuario();
        }catch (Exception e){
            existeLoginUsuario = -1;
        }

        if(existeLoginUsuario!=-1){
            return new TelaHomeUser(central.getUsuario().get(existeLoginUsuario));

        }else if(existeLoginLivreiro){
            return new TelaHomeADM();

        }else if(existeLiveiero && !existeLoginLivreiro){
            return new TelaLoginCliente();
        }else{
            return new TelaAddLivreiro();

        }
    }


}
