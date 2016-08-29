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



public class AppFuncionario extends JPanel implements Menu,ActionListener{
	private static final long serialVersionUID = 1L;
	private AppPrincipal principal;
	private SpringLayout layout;

	private JLabel labelTitulo;
	private JLabel labelFazer;
	
	private static JButton btListar;
	private static JButton btConsultar;
	private static JButton btVender;
	private static JButton btSenha;
	private static JButton btSair = new JButton("Sair");

	public AppFuncionario(AppPrincipal principal){
		labelTitulo = new JLabel("APLICATIVO DO FUNCIONARIO");
		labelFazer = new JLabel("O que deseja fazer?");
		btListar = new JButton("Listar estoque");
		btConsultar = new JButton("Fazer consulta");
		btVender = new JButton("Vender");
		btSenha = new JButton("Alterar Senha");
		btSair = new JButton("Sair");
		this.principal = principal;
		this.setSize(500, 500);
		this.inicializarComponentes();
		this.setLayout(layout);
	}
	public void inicializarComponentes(){

		layout=new SpringLayout();

		btListar.addActionListener(this);
		btConsultar.addActionListener(this);
		btVender.addActionListener(this);
		btSenha.addActionListener(this);
		btSair.addActionListener(principal);

		labelTitulo.setFont(new Font("Arial", 0, 18));

		this.add(labelTitulo);
		this.add(labelFazer);

		this.add(btListar);
		this.add(btConsultar);
		this.add(btVender);
		this.add(btSenha);
		this.add(btSair);

		//Titulo
		layout.putConstraint(SpringLayout.WEST, labelTitulo, 175, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 10, SpringLayout.NORTH, this);

		//Mensagem de o que fazer
		layout.putConstraint(SpringLayout.WEST, labelFazer, 10, SpringLayout.WEST, labelTitulo);
		layout.putConstraint(SpringLayout.NORTH, labelFazer, 100, SpringLayout.NORTH, labelTitulo);

		//Botao Listar
		layout.putConstraint(SpringLayout.WEST, btListar, 0, SpringLayout.WEST, labelFazer);
		layout.putConstraint(SpringLayout.NORTH, btListar, 10, SpringLayout.SOUTH, labelFazer);
		
		//Botao Consultar
		layout.putConstraint(SpringLayout.WEST, btConsultar, 0, SpringLayout.WEST, btListar);
		layout.putConstraint(SpringLayout.NORTH, btConsultar, 10, SpringLayout.SOUTH, btListar);

		//Botao Vender
		layout.putConstraint(SpringLayout.WEST, btVender, 0, SpringLayout.WEST, btConsultar);
		layout.putConstraint(SpringLayout.NORTH, btVender, 10, SpringLayout.SOUTH, btConsultar);

		//Botao Senha
		layout.putConstraint(SpringLayout.WEST, btSenha, 0, SpringLayout.WEST, btVender);
		layout.putConstraint(SpringLayout.NORTH, btSenha, 10, SpringLayout.SOUTH, btVender);

		//Botao Sair 
		layout.putConstraint(SpringLayout.WEST, btSair, 0, SpringLayout.WEST, btSenha);
		layout.putConstraint(SpringLayout.NORTH, btSair, 10, SpringLayout.SOUTH, btSenha);

	}
	@Override
	public void actionPerformed( ActionEvent e ){
		
		if(e.getSource() == btListar){
			System.err.println("ta funfando?");
		}
		else if(e.getSource() == btConsultar){
			
		}
		else if(e.getSource() == btVender){
			
		}
		else if(e.getSource() == btSenha){
			
		}		
	}
	@Override
	public void mostrarMenu(){
		System.out.println("[1] - LISTAR ESTOQUE");
		System.out.println("[2] - CONSULTAR PRODUTO");
		System.out.println("[3] - VENDER");
		System.out.println("[4] - ALTERAR SENHA");
		System.out.println("[0] - SAIR");
	}
}
