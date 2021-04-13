package Utilitarios.Persistencia.Central_de_informacoes.Central;




import Utilitarios.Persistencia.Central_de_informacoes.Livreiro.Livreiro;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import java.util.ArrayList;

public class CentralDeInformacoes {
    private Livreiro livreiro;
    private ArrayList<Usuario> usuario = new ArrayList<Usuario>();

    private static Persistencia pADM = Persistencia.getUnicaInstancia();

    public void salvar(){
        Persistencia persistencia = Persistencia.getUnicaInstancia();
        try {
            persistencia.salvarCentral(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLivreiro(Livreiro livreiro) {
        this.livreiro = livreiro;

    }

    public void addUser(Usuario usuario){
        this.usuario.add(usuario);
    }

    
    public Livreiro getLivreiro() {
        return livreiro;
    }

    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }
}
