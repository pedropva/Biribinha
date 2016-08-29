package Estoque;

public class Eletronicos extends Produtos {
	private int voltagem;
	
	public Eletronicos(String nome, String marca, float preco,int voltagem,int unidades) {
		super(nome, marca, preco,unidades);
		this.voltagem = voltagem;
	}

	public int getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}
	
}
