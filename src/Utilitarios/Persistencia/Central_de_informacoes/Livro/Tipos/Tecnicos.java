package Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos;


import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import java.util.ArrayList;

public class Tecnicos extends Livro {

    private String assunto;
    private String autor;

    public Tecnicos(ArrayList<String> info, String assunto, String autor) {
        super(
                info.get(0), info.get(1), info.get(2),
                info.get(3), info.get(4), info.get(7),
                Integer.parseInt(info.get(8)), Long.parseLong(info.get(9)),
                Integer.parseInt(info.get(10)));
        this.assunto = assunto;
        this.autor = autor;
    }


    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

}
