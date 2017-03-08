package Estoque;

import java.io.Serializable;

public abstract class Produtos implements Serializable{
	private String nome;
	private String marca;
	private float preco;
	private int unidades;

	public Produtos(){};
	public Produtos(String nome, String marca, float preco,int unidades) {
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.unidades = unidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

}
