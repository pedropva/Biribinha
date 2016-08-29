package Estoque;

public class Higiene extends Produtos {
	private String validade;
	
	public Higiene(String nome, String marca, float preco,String validade,int unidades) {
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
