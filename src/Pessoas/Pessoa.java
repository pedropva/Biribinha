package Pessoas;

public class Pessoa {
	private String nome;
	private int registro;
	private int senha;
	
	
	public Pessoa(){};
	public Pessoa(String nome, int registro, int senha) {
		this.nome = nome;
		this.registro = registro;
		this.senha = senha;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public boolean autenticar(int senha){
		return true;
	}
}
