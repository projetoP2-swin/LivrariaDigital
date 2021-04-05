package Persistencia.Central_de_informacoes;

import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaLivreiro.PersistenciaADM;
import Persistencia.Usuario.Usuario;

public class CentralDeInformacoes {
    private Livreiro livreiro;
    private Usuario usuario;

    public boolean addLivreiro(Livreiro livreiro) {
        PersistenciaADM pADM = new PersistenciaADM();
        this.livreiro = livreiro;
        try{
            pADM.salvarCentral(this);
            return true;

        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Livreiro getLivreiro() {
        return livreiro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
