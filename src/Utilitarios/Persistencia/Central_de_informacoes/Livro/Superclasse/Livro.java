package Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse;

public  abstract class Livro {

    private String titulo, tipo;
    private String resumo;
    private String idioma;
    private String genero;
    private String editora;
    private int quantidade;
    private float preco;

    public String getTipo() {
        return tipo;
    }



    public Livro(
            String tipo, String titulo, String resumo, String idioma,
            String genero, String editora, int quantidade, float preco) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.resumo = resumo;
        this.idioma = idioma;
        this.genero = genero;
        this.editora = editora;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
