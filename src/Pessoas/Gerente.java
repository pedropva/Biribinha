package Pessoas;

import java.io.Serializable;

public class Gerente extends Pessoa implements Serializable {

	public Gerente(String nome, int registro,int senha) {
		super(nome, registro,senha);
	}
	//talvez ter o metodo setSenha e setRegistro com os numeros especificos
}
