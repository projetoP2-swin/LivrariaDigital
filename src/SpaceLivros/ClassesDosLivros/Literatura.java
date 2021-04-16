package SpaceLivros.ClassesDosLivros;

public class Literatura extends Livro {

    private String[] generoarray = {"literatura brasileira", "literatura estrangeira",
            "infanto juvenil", "artes", "biografias", "poesia"};

    public String[] getArraydegen() {
        return generoarray;
    }

    private String[] autores;

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String getTipo() {
        return "Literatura";
    }
}
