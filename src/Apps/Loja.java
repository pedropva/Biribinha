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
	private int keyMestra; // chave dada ao dono da loja
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
		this.keyMestra = 28082016;
		
	}
	//encapsulamento
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

	public void setRenda(int renda) {
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
	
	
	public int getKeyMestra() {
		return keyMestra;
	}
	public void setKeyMestra(int keyMestra) {
		this.keyMestra = keyMestra;
	}
	//metodos da classe usados pelo gerente
	public void listar(ArrayList<Produtos> listaprodutos){
		if(listaprodutos.size() > 0){
			for(Produtos p: listaprodutos){
				System.out.println("Produto: "+p.getNome());
				System.out.println("Marca: "+p.getMarca());
				System.out.println("Preco R$:"+p.getPreco());
				System.out.println("unds em estoque: "+p.getUnidades());
				if( p instanceof Alimentacao ){
					Alimentacao tmp = (Alimentacao)p;
					System.out.println("validade: "+tmp.getValidade());
				}else if(p instanceof Higiene){
					Higiene tmp = (Higiene)p;
					System.out.println(tmp.getValidade());
				}else if(p instanceof Eletronicos){
					Eletronicos tmp = (Eletronicos)p;
					System.out.println(tmp.getVoltagem());
				}
				System.out.println();
			}
		}else{
			System.out.println("Estoque Vazio");
		}
	}

	public void Demitir(HashMap<Integer, Funcionario> funcionario){
		int registro;
		System.out.print("Informe o registro do funcionario: "); 
		registro = Ler.inteiro();
		if(funcionario.remove(registro)==null){
			System.out.println("Funcionario nao Existe");
		}else{
			System.out.println("Funcionario demitido!");
		}	
	}

	public void Cadastrar(Pessoa p){
		if(p instanceof Funcionario){
			Funcionario aux = (Funcionario)p;
			if(this.funcionario.put(aux.getRegistro(), aux)==null){
				System.out.println("Funcionario Adimitido! ");
			}else{
				System.out.println("Erro ao cadastrar");
			}
		}
		if(p instanceof Gerente){
			Gerente aux = (Gerente)p;
			if(this.gerentes.put(aux.getRegistro(), aux)==null){
				System.out.println("Gerente Adimitido! ");
			}else{
				System.out.println("Erro ao cadastrar");
			}
		}
		
	}

	public void Comprar(float renda,ArrayList<Produtos> listaprodutos){
		int esc; 
		System.out.println("Qual o tipo de produto que deseja adicionar:"); 
		System.out.println("[1] - Alimentacao"); 
		System.out.println("[2] - Higiene");
		System.out.println("[1] - Eletronico");
		esc = Ler.inteiro();
			if(esc == 1){
				Ler.linha();
				System.out.print("Informe o nome do produto: "); String nome = Ler.linha();
				System.out.print("Informe a marca do produto: "); String marca = Ler.linha();
				System.out.print("Informe o preço: "); float preco = Ler.inteiro();
				Ler.linha();
				System.out.print("Informe a validade(_/_/_): "); String validade = Ler.linha();
				System.out.print("Informe a qnts unidades: "); int und = Ler.inteiro();
				Alimentacao novo = new Alimentacao(nome,marca,preco,validade,und);
				if(listaprodutos.add(novo)){
					this.renda -= preco*und;
					System.out.println("Produto estocado");
				}else{
					System.out.println("Erro ao estocar");

				}
				
			}else if( esc == 2){
				Ler.linha();
				System.out.print("Informe o nome do produto: "); String nome = Ler.linha();
				System.out.print("Informe a marca do produto: "); String marca = Ler.linha();
				System.out.print("Informe o preço: "); float preco = Ler.preco();
				Ler.linha();
				System.out.print("Informe a validade(_/_/_): "); String validade = Ler.linha();
				System.out.print("Informe a qnts unidades: "); int und = Ler.inteiro();
				Higiene novo =new Higiene(nome,marca,preco,validade,und);
				if(listaprodutos.add(novo)){
					System.out.println("Produto estocado");
					this.renda -= preco*und;
				}else{
					System.out.println("Erro ao estocar");
				}
				
			}else if( esc == 3){
				Ler.linha();
				System.out.print("Informe o nome do produto: "); String nome = Ler.linha();
				System.out.print("Informe a marca do produto: "); String marca = Ler.linha();
				System.out.print("Informe o preço: "); float preco = Ler.preco();
				System.out.print("Informe a qunts unidades: "); int und = Ler.inteiro();
				System.out.print("Informe a voltagem(220w ou 110w: "); int voltagem = Ler.inteiro();
				Eletronicos novo = new Eletronicos(nome,marca,preco,voltagem,und);
				if(listaprodutos.add(novo)){
					System.out.println("Produto estocado");
					this.renda -= preco*und;
				}else{
					System.out.println("Erro ao estocar");
				}
			}else{
				System.out.println("Escolha um tipo valido");
			}
			
		}
	//metodos da clsse usados pelos funcionarios
	public void consultar(ArrayList<Produtos> listaprodutos){
		if(listaprodutos.size() > 0){
			Ler.linha();
			System.out.println("Informe o nome do produto: "); 
			String nome = Ler.linha();
			for(Produtos p: listaprodutos){
				if(p.getNome().equals(nome)){
					System.out.println(p.getNome());
					System.out.println(p.getMarca());
					System.out.println(p.getPreco());
					System.out.println(p.getUnidades());
					if( p instanceof Alimentacao ){
						Alimentacao tmp = (Alimentacao)p;
						System.out.println(tmp.getValidade());
					}else if(p instanceof Higiene){
						Higiene tmp = (Higiene)p;
						System.out.println(tmp.getValidade());
					}else if(p instanceof Eletronicos){
						Eletronicos tmp = (Eletronicos)p;
						System.out.println(tmp.getVoltagem());
					}
				}
			}
		}else{
			System.out.println("Estoque Vazio");
		}
	}
	
	public void vender(ArrayList<Produtos> listaprodutos){
		
		if(listaprodutos.size() > 0){
			Ler.linha();
			System.out.println("Informe o nome do produto: "); String nome = Ler.linha();
			System.out.println("Informe a quantidade do produto: "); int qnt = Ler.inteiro();
				for(int i=0;i<listaprodutos.size();i++){
					if(listaprodutos.get(i).getNome().equals(nome)){
						if(qnt <= listaprodutos.get(i).getUnidades()){
							this.renda += (listaprodutos.get(i).getPreco() + (listaprodutos.get(i).getPreco()/10))*qnt;
							if(qnt == listaprodutos.get(i).getUnidades()){
								listaprodutos.get(i).setUnidades(0);
								if(listaprodutos.get(i).getUnidades()==0){
									listaprodutos.remove(i);
								}
								System.out.println("Venda realizada com sucesso!");
							}else{
								listaprodutos.get(i).setUnidades(listaprodutos.get(i).getUnidades()-qnt);
								System.out.println("Venda realizada com sucesso!");
							}
						}else{
							System.out.println("Quantidade no estoque insuficiente!");
						}
					}else{
						System.out.println("Produto nn disponivel em estoque!");
					}
				}
		}else{
			System.out.println("Estoque Vazio");
		}
	}
}
