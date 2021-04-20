package Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import java.util.ArrayList;

public class Literatura  extends Livro{

    private String[] autores;

    public Literatura(ArrayList<String> info, String autores ) {
        super(
            info.get(0),info.get(1), info.get(2), info.get(3),
            info.get(4), info.get(6),
            Integer.parseInt(info.get(7)), Long.parseLong(info.get(8)));
        this.autores = autores.contains(",")?autores.split(","):autores.split(" ");
    }


    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

}
