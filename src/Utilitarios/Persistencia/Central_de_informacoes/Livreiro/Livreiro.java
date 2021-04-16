package Utilitarios.Persistencia.Central_de_informacoes.Livreiro;


import SpaceLivros.ClassesDosLivros.Livro;

import java.util.ArrayList;

public class Livreiro {
	private String nome;
	private String email;
	private String senha;
	private String numeroDeRecuperacao;
	private ArrayList<Livro> arraydelivros = new ArrayList<Livro>();

	public void adicionarLivro(Livro livro) {
		arraydelivros.add(livro);
	}

	public Livreiro(String nome,String email,String senha) {
		this.nome=nome;
		this.email=email;
		this.senha=senha;

	}
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNumeroDeRecuperacao() {
		return numeroDeRecuperacao;
	}

	public void setNumeroDeRecuperacao(String numeroDeRecuperacao) {
		this.numeroDeRecuperacao = numeroDeRecuperacao;
	}
}
