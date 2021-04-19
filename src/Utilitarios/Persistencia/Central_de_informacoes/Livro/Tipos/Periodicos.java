package Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos;


import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import java.util.ArrayList;

public class Periodicos extends Livro {
    private long numeroDaEdicao;
    private String mesDeLancamento;
    private String autor;

    public Periodicos(ArrayList<String> info,
                      String numeroDaEdicao,
                      String mesDeLancamento,
                      String autor) {
        super(
            info.get(0), info.get(1), info.get(2),
            info.get(3), info.get(4), info.get(8),
            Integer.parseInt(info.get(9)),Long.parseLong(info.get(10)),
            Integer.parseInt(info.get(11)));
        this.numeroDaEdicao = Long.parseLong(numeroDaEdicao);
        this.mesDeLancamento = mesDeLancamento;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getNumeroDaEdicao() {
        return numeroDaEdicao;
    }

    public void setNumeroDaEdicao(long numeroDaEdicao) {
        this.numeroDaEdicao = numeroDaEdicao;
    }

    public String getMesDeLancamento() {
        return mesDeLancamento;
    }

    public void setMesDeLancamento(String mesDeLancamento) {
        this.mesDeLancamento = mesDeLancamento;
    }



}
