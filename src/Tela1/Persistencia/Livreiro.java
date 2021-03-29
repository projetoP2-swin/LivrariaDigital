package Tela1.Persistencia;

public class Livreiro {
	private String nome;
	private String email;
	private String senha;
	
	public Livreiro(String nome,String email,String senha) {
		this.nome=nome;
		this.email=email;
		this.senha=senha;
		
	}
	public Livreiro(){

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
}
