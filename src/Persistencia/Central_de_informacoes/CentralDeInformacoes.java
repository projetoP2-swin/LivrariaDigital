package Persistencia.Central_de_informacoes;

import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaAll.Persistencia;
import Persistencia.Usuario.Usuario;

import java.util.ArrayList;

public class CentralDeInformacoes {
    private Livreiro livreiro;
    private ArrayList<Usuario> usuario = new ArrayList<Usuario>();

    private static Persistencia pADM = new Persistencia();

    public void salvar(){
        Persistencia persistencia = new Persistencia();
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
