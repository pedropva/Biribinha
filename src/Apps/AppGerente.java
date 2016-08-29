package Apps;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Estoque.Alimentacao;
import Estoque.Eletronicos;
import Estoque.Higiene;
import Estoque.Produtos;
import Pessoas.Funcionario;



public class AppGerente extends JPanel implements Menu,ActionListener{
	private static final long serialVersionUID = 1L;
	private AppPrincipal principal;
	private SpringLayout layout;

	private JLabel labelTitulo = new JLabel("APLICATIVO DO GERENTE:");
	private JLabel labelFazer = new JLabel("O que deseja fazer?");
	private JLabel labelNome = new JLabel("Informe o Nome:");
	private JLabel labelRegistro = new JLabel("Informe o Registro:");
	private JLabel labelFuncao = new JLabel("Informe a Funcão:");
	private JLabel labelSenha = new JLabel("Informe a Senha:");

	private JTextField textNome = new JTextField(20);
	private JTextField textRegistro = new JTextField(20);
	private JTextField textFuncao = new JTextField(20);
	private JPasswordField textSenha = new JPasswordField(20);

	private static JButton btCadastrar = new JButton("Cadastrar");
	private static JButton btVoltar = new JButton("Voltar");
	private static JButton btAddGerente = new JButton("Adicionar Gerente");
	private static JButton btAddFuncionario = new JButton("Adicionar Funcionário");
	private static JButton btRemove = new JButton("Remover Funcionário");
	private static JButton btLista = new JButton("Ver Estoque");
	private static JButton btRenda = new JButton("Mostrar Estatisticas");
	private static JButton btSenha = new JButton("Alterar Senha");
	private static JButton btSair = new JButton("Sair");

	public AppGerente(AppPrincipal principal){
		this.principal = principal;
		this.setSize(500, 500);
		this.inicializarComponentes();
		this.setLayout(layout);
	}
	public void inicializarComponentes(){

		layout=new SpringLayout();

		btCadastrar.addActionListener(this);
		btVoltar.addActionListener(this);
		btAddGerente.addActionListener(this);
		btAddFuncionario.addActionListener(this);
		btRemove.addActionListener(this);
		btLista.addActionListener(this);
		btRenda.addActionListener(this);
		btSenha.addActionListener(this);
		btSair.addActionListener(principal);

		labelNome.setVisible(false);
		labelRegistro.setVisible(false);
		labelSenha.setVisible(false);
		labelFuncao.setVisible(false);
		textNome.setVisible(false);
		textRegistro.setVisible(false);
		textFuncao.setVisible(false);
		textSenha.setVisible(false);

		btVoltar.setVisible(false);
		btCadastrar.setVisible(false);

		labelTitulo.setFont(new Font("Arial", 0, 18));

		this.add(labelTitulo);
		this.add(labelFazer);

		this.add(labelNome);
		this.add(labelRegistro);
		this.add(labelFuncao);
		this.add(labelSenha);

		this.add(textNome);
		this.add(textRegistro);
		this.add(textFuncao);
		this.add(textSenha);


		this.add(btVoltar);
		this.add(btCadastrar);
		this.add(btAddGerente);
		this.add(btAddFuncionario);
		this.add(btRemove);
		this.add(btLista);
		this.add(btRenda);
		this.add(btSenha);
		this.add(btSair);

		//Titulo
		layout.putConstraint(SpringLayout.WEST, labelTitulo, 175, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 10, SpringLayout.NORTH, this);

		//Mensagem de o que fazer
		layout.putConstraint(SpringLayout.WEST, labelFazer, 10, SpringLayout.WEST, labelTitulo);
		layout.putConstraint(SpringLayout.NORTH, labelFazer, 100, SpringLayout.NORTH, labelTitulo);

		//Botao AddGerente
		layout.putConstraint(SpringLayout.WEST, btAddGerente, 0, SpringLayout.WEST, labelFazer);
		layout.putConstraint(SpringLayout.NORTH, btAddGerente, 10, SpringLayout.SOUTH, labelFazer);

		//Botao AddFuncionario
		layout.putConstraint(SpringLayout.WEST, btAddFuncionario, 0, SpringLayout.WEST, btAddGerente);
		layout.putConstraint(SpringLayout.NORTH, btAddFuncionario, 10, SpringLayout.SOUTH, btAddGerente);

		//Botao Remove
		layout.putConstraint(SpringLayout.WEST, btRemove, 0, SpringLayout.WEST, btAddFuncionario);
		layout.putConstraint(SpringLayout.NORTH, btRemove, 10, SpringLayout.SOUTH, btAddFuncionario);

		//Botao Lista
		layout.putConstraint(SpringLayout.WEST, btLista, 0, SpringLayout.WEST, btRemove);
		layout.putConstraint(SpringLayout.NORTH, btLista, 10, SpringLayout.SOUTH, btRemove);

		//Botao Renda
		layout.putConstraint(SpringLayout.WEST, btRenda, 0, SpringLayout.WEST, btLista);
		layout.putConstraint(SpringLayout.NORTH, btRenda, 10, SpringLayout.SOUTH, btLista);

		//Botao Senha
		layout.putConstraint(SpringLayout.WEST, btSenha, 0, SpringLayout.WEST, btRenda);
		layout.putConstraint(SpringLayout.NORTH, btSenha, 10, SpringLayout.SOUTH, btRenda);

		//Botao Sair 
		layout.putConstraint(SpringLayout.WEST, btSair, 0, SpringLayout.WEST, btSenha);
		layout.putConstraint(SpringLayout.NORTH, btSair, 10, SpringLayout.SOUTH, btSenha);

		//label Nome
		layout.putConstraint(SpringLayout.EAST, labelNome, 5, SpringLayout.WEST, labelTitulo);
		layout.putConstraint(SpringLayout.NORTH, labelNome, 100, SpringLayout.SOUTH, labelTitulo);

		//label Registro
		layout.putConstraint(SpringLayout.WEST, labelRegistro, 0, SpringLayout.WEST, labelNome);
		layout.putConstraint(SpringLayout.NORTH, labelRegistro, 10, SpringLayout.SOUTH, labelNome);

		//label Funcao
		layout.putConstraint(SpringLayout.WEST, labelFuncao, 0, SpringLayout.WEST, labelNome);
		layout.putConstraint(SpringLayout.NORTH, labelFuncao, 10, SpringLayout.SOUTH, labelSenha);

		//label Senha
		layout.putConstraint(SpringLayout.WEST, labelSenha, 0, SpringLayout.WEST, labelRegistro);
		layout.putConstraint(SpringLayout.NORTH, labelSenha, 10, SpringLayout.SOUTH, labelRegistro);

		//TextField Nome
		layout.putConstraint(SpringLayout.WEST, textNome, 5, SpringLayout.EAST, labelNome);
		layout.putConstraint(SpringLayout.NORTH, textNome, 0, SpringLayout.NORTH, labelNome);

		//TextField Registro
		layout.putConstraint(SpringLayout.WEST, textRegistro, 5, SpringLayout.EAST, labelRegistro);
		layout.putConstraint(SpringLayout.NORTH, textRegistro, 0, SpringLayout.NORTH, labelRegistro);

		//TextField Funcao
		layout.putConstraint(SpringLayout.WEST, textFuncao, 5, SpringLayout.EAST, labelFuncao);
		layout.putConstraint(SpringLayout.NORTH, textFuncao, 0, SpringLayout.NORTH, labelFuncao);

		//TextField Senha
		layout.putConstraint(SpringLayout.WEST, textSenha, 5, SpringLayout.EAST, labelSenha);
		layout.putConstraint(SpringLayout.NORTH, textSenha, 0, SpringLayout.NORTH, labelSenha);

		//Botao Cadastrar 
		layout.putConstraint(SpringLayout.EAST, btCadastrar, 100, SpringLayout.WEST, btSenha);
		layout.putConstraint(SpringLayout.NORTH, btCadastrar, 10, SpringLayout.SOUTH, labelFuncao);

		//Botao Voltar
		layout.putConstraint(SpringLayout.WEST, btVoltar, 10, SpringLayout.EAST, btCadastrar);
		layout.putConstraint(SpringLayout.NORTH, btVoltar, 10, SpringLayout.SOUTH, labelFuncao);

	}
	@Override
	public void actionPerformed( ActionEvent e ){
		//ANIMAL EU A NAO TE DISSE PRA SEPARAR EM METODOS ESSAS PORCARIAS MUDA LOGO ESSA ABERRACAO
		btAddFuncionario.setVisible(false);
		btAddGerente.setVisible(false);
		btRemove.setVisible(false);
		btLista.setVisible(false);
		btRenda.setVisible(false);
		btSenha.setVisible(false);
		btSair.setVisible(false);
		labelFazer.setVisible(false);
		if(e.getSource() == btAddFuncionario){
			labelTitulo.setText("Cadastrar novo funcionário");
			labelNome.setVisible(true);
			labelRegistro.setVisible(true);
			labelSenha.setVisible(true);
			labelFuncao.setVisible(true);
			textNome.setVisible(true);
			textRegistro.setVisible(true);
			textSenha.setVisible(true);
			textFuncao.setVisible(true);
			btVoltar.setVisible(true);
			btCadastrar.setVisible(true);
		}
		//ALA ,ESSE ANIMAL DE TETA FEZ O QUE EU DISSE PRA N FAZER DNV
		else if(e.getSource() == btAddGerente){
			labelTitulo.setText("Cadastrar novo Gerente");
			labelNome.setVisible(true);
			labelRegistro.setVisible(true);
			labelSenha.setVisible(true);
			textNome.setVisible(true);
			textRegistro.setVisible(true);
			textSenha.setVisible(true);
			btVoltar.setVisible(true);
			btCadastrar.setVisible(true);
		}
		else if(e.getSource() == btCadastrar){
			String registro="",novaSenha="",nome="",func="";
			int pass = 0;
			int novoRegistro=0;

			try {
				nome = textNome.getText();
			} catch (Exception e2) {
				nome=null;
				System.out.println(e2);
				principal.getStatus().setTexto("Digite um nome válido!");
			}
			//isso nao ta funfando,nao sei pq
			if(nome!=null && nome != ""){
				try{
					char[] senha = textSenha.getPassword();
					for (int i = 0; i < senha.length; i++) {
						novaSenha += senha[i];
					}
					pass = Integer.parseInt(novaSenha);
				}catch (Exception e2) {
					System.out.println(e2);
					principal.getStatus().setTexto("Digite uma Senha válida!");
					pass = 0;
				}
				try{
					registro = textRegistro.getText();
					novoRegistro = Integer.parseInt(registro);
				}catch (Exception e2) {
					System.out.println(e2);
					principal.getStatus().setTexto("Digite um Registro válido!");
					novoRegistro = 0;
				}
				//VC DEVIA FAZER UM METODO PRA ISSO SU RETARDADO TA MTO FEIO
				if(novoRegistro != 0 && pass != 0){
					if(labelTitulo.getText() == "Cadastrar novo funcionário"){
						if(String.valueOf(novoRegistro).length() == 6){
							if(String.valueOf(pass).length() == 4){
								if(principal.getLoja().getFuncionario().get(novoRegistro) == null){
									try {
										func = textFuncao.getText();
									} catch (Exception e2) {
										func=null;
										System.out.println(e2);
										principal.getStatus().setTexto("Digite uma funcão válida!");
									}
									if(func != null && func != ""){
										Funcionario novo = new Funcionario(nome,novoRegistro,func,pass);
										principal.getLoja().Cadastrar(novo);
										principal.getStatus().setTexto("Funcionario Cadastrado!");
									}else{
										principal.getStatus().setTexto("Digite uma funcão válida!");
									}
								}else{
									principal.getStatus().setTexto("Funcionario já Cadastrado!");
								}
							}else{
								principal.getStatus().setTexto("Digite uma senha de 4 digitos!");
							}
						}else{
							principal.getStatus().setTexto("Digite um Registro de 6 digitos!");
						}
					}else{
						//Gerente gerente = new Gerente(nomeg,regg,senhag);
						//x.Cadastrar(gerente);
					}
				}
			}
		}
		else if(e.getSource() == btVoltar){
			btAddFuncionario.setVisible(true);
			btAddGerente.setVisible(true);
			btRemove.setVisible(true);
			btLista.setVisible(true);
			btRenda.setVisible(true);
			btSenha.setVisible(true);
			btSair.setVisible(true);
			labelFazer.setVisible(true);

			labelTitulo.setText("APLICATIVO DO GERENTE");
			labelNome.setVisible(false);
			labelRegistro.setVisible(false);
			labelSenha.setVisible(false);
			labelFuncao.setVisible(false);
			textNome.setVisible(false);
			textRegistro.setVisible(false);
			textSenha.setVisible(false);
			textFuncao.setVisible(false);
			btVoltar.setVisible(false);
			btCadastrar.setVisible(false);

		}
		else if(e.getSource() == btRemove){

		}
		else if(e.getSource() == btLista){

		}
		else if(e.getSource() == btRenda){

		}
		else if(e.getSource() == btSenha){

		}
		principal.repaint();
	}
	@Override
	public void mostrarMenu(){
		System.out.println("[1] - ADICIONAR FUNCIONARIO");
		System.out.println("[2] - DEMITIR FUNCIONARIO");
		System.out.println("[3] - REPOR ESTOQUE");
		System.out.println("[4] - LISTAR ESTOQUE");
		System.out.println("[5] - MOSTRAR RENDA");
		System.out.println("[6] - ALTERAR SENHA");
		System.out.println("[0] - SAIR");
	}
}
