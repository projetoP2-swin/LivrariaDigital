package SpaceLivros.ClassesDosLivros;

public class DesenvolvimentoP extends Livro {

    private String[] generoarray = {"autoajuda", "religião", "saúde"};

    private String[] autores;

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String[] getArraydegen() {
        return generoarray;
    }

    public String getTipo() {
        return "Desenvolvimento Pessoal";
    }

}
