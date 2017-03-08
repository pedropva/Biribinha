package Apps;
import Estoque.Alimentacao;
import Estoque.Eletronicos;
import Estoque.Higiene;
import Estoque.Produtos;
import Pessoas.Gerente;
import Pessoas.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import Pessoas.Funcionario;

public class Loja implements Serializable {
	private String nome; //nome da loja
	private Gerente gerente; //gerente da loja
	private float renda; //renda da loja

	private HashMap<Integer, Funcionario> funcionario; //lista de funcionarios
	private HashMap<Integer, Gerente> gerentes; //lista de gerentes
	private ArrayList<Produtos> listaprodutos; //estoque de produtos da loja

	public Loja(){};
	public Loja(String nome,Gerente gerente) {
		this.nome = nome;
		this.gerente = gerente;
		funcionario = new HashMap< Integer, Funcionario>();
		listaprodutos = new ArrayList<Produtos>();
		gerentes = new HashMap<Integer , Gerente>();
		gerentes.put(gerente.getRegistro(), gerente);
		this.renda = 0f;
	}

	//encapsulamento
	public void setFuncionario(HashMap<Integer, Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	public void setGerentes(HashMap<Integer, Gerente> gerentes) {
		this.gerentes = gerentes;
	}
	public void setListaprodutos(ArrayList<Produtos> listaprodutos) {
		this.listaprodutos = listaprodutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public float getRenda() {
		return renda;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

	public HashMap<Integer, Funcionario> getFuncionario() {
		return funcionario;
	}

	public HashMap<Integer, Gerente> getGerentes() {
		return gerentes;
	}

	public ArrayList<Produtos> getListaprodutos() {
		return listaprodutos;
	}

	//Demite Funcionario
	public int Demitir(int registro){
		if(this.getFuncionario().remove(registro)==null){
			return 0;
		}else{
			return 1;
		}  
	}

	//cadastra um funcionario
	public void Cadastrar(Pessoa p){
		if(p instanceof Funcionario){
			Funcionario aux = (Funcionario)p;
			this.getFuncionario().put(aux.getRegistro(), aux);
		}
		if(p instanceof Gerente){
			Gerente aux = (Gerente)p;
			this.getGerentes().put(aux.getRegistro(), aux);
		}

	}
	//funções de consulta
	public ArrayList<Produtos> Consultar(String nome){
		ArrayList<Produtos> a = new ArrayList<Produtos>();
		for(int i=0;i<this.getListaprodutos().size();i++){
			if(this.getListaprodutos().get(i).getNome().equals(nome)){
				a.add(this.getListaprodutos().get(i));
			}
		}
		return a;
	}
	public ArrayList<Produtos> ConsultarMarca(String marca){
		ArrayList<Produtos> a = new ArrayList<Produtos>();
		for(int i=0;i<this.getListaprodutos().size();i++){
			if(this.getListaprodutos().get(i).getMarca().equals(marca)){
				a.add(this.getListaprodutos().get(i));
			}
		}
		return a;
	}
	public ArrayList<Produtos> Consultar(String nome,String marca){
		ArrayList<Produtos> a = new ArrayList<Produtos>();
		for(int i=0;i<this.getListaprodutos().size();i++){
			if(this.getListaprodutos().get(i).getNome().equals(nome) && this.getListaprodutos().get(i).getMarca().equals(marca)){
				a.add(this.getListaprodutos().get(i));
			}
		}
		return a;
	}

	//comprar
	public boolean Comprar(Produtos p){
		ArrayList<Produtos> p2 = Consultar(p.getNome(), p.getMarca());
		if(p2.size()==0){
			if(this.getListaprodutos().add(p)){
				this.setRenda(this.getRenda()-p.getPreco()*p.getUnidades());
				return true;
			}else{
				return false;
			}
		}else{
			p2.get(0).setUnidades(p2.get(0).getUnidades()+p.getUnidades());
			return true;
		}
	}	

	public int vender(String nome, int qnt,int lucro){
		int res = 0;
		if(this.getListaprodutos().size() > 0){
			for(int i=0;i<this.getListaprodutos().size();i++){
				if(this.getListaprodutos().get(i).getNome().equals(nome)){
					if(qnt <= this.getListaprodutos().get(i).getUnidades()){
						this.setRenda(this.getRenda() + (this.getListaprodutos().get(i).getPreco() + (this.getListaprodutos().get(i).getPreco()/lucro))*qnt);
						if(qnt == this.getListaprodutos().get(i).getUnidades()){
							this.getListaprodutos().get(i).setUnidades(0);
							if(this.getListaprodutos().get(i).getUnidades()==0){
								this.getListaprodutos().remove(i);
							}
							res = 1; //venda realizada
						}else{
							this.getListaprodutos().get(i).setUnidades(this.getListaprodutos().get(i).getUnidades()-qnt);
							res =  1; //venda realizada
						}
					}else{
						res =  -1; //quantidade em estoque insuficiente
					}
				}else{
					res =  1; //produto nn disponivel
				}
			}
		}else{
			res = 0; //estoque vazio
		}
		return res;
	}

	public void alterarSenhaGerente(int registro,int newSenha){
		this.getGerentes().get(registro).setSenha(newSenha);
	}
	public void alterarSenhaFunc(int registro,int newSenha){
		this.getFuncionario().get(registro).setSenha(newSenha);
	}
}
