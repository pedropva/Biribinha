package Estoque;

import java.io.Serializable;

public class Alimentacao extends Produtos implements Serializable{
	private String validade;

	public Alimentacao(){};

	public Alimentacao(String nome, String marca, float preco,String validade,int unidades) {
		super(nome, marca, preco,unidades);
		this.validade = validade;

	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}




}
