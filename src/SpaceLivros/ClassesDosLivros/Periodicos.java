package SpaceLivros.ClassesDosLivros;

import SpaceLivros.ClassesDosLivros.Livro;

public class Periodicos extends Livro {

    private int numeroDaEdicao;
    private String mesDeLancamento;

    public int getNumeroDaEdicao() {
        return numeroDaEdicao;
    }

    public void setNumeroDaEdicao(int numeroDaEdicao) {
        this.numeroDaEdicao = numeroDaEdicao;
    }

    public String getMesDeLancamento() {
        return mesDeLancamento;
    }

    public void setMesDeLancamento(String mesDeLancamento) {
        this.mesDeLancamento = mesDeLancamento;
    }

    private String[] generoarray = {"Gibi", "Revista de notícias"};

    public String[] getGeneroarray() {
        return generoarray;
    }

    public String[] getArraydegen() {
        return generoarray;
    }


    public String getTipo() {
        return "Periódico";
    }

    public Periodicos () {

    }
    public Periodicos (String titulo,  String resumo, String idioma, String genero,
                       String editora, String autor, int quantidade, float preço, String mes, int numeroDaEdicao) {

    }

}
