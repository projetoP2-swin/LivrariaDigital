package SpaceLivros.ClassesDosLivros;

import SpaceLivros.ClassesDosLivros.Livro;

public class Tecnicos extends Livro {

    private String assunto;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    private String[] generoarray = {"paradidático", "formação profissional"};


    public String[] getArraydegen() {
        return generoarray;
    }

    private String[] autores;

    public String getTipo() {
        return "Técnico";
    }
}
