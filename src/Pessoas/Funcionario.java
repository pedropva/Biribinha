package Pessoas;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable{
	private String funcao;
	public Funcionario(){};
	public Funcionario(String nome, int registro, String funcao,int senha) {
		super(nome, registro, senha);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
