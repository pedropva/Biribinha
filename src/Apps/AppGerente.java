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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Estoque.Alimentacao;
import Estoque.Eletronicos;
import Estoque.Higiene;
import Estoque.Produtos;
import Pessoas.Funcionario;
import Pessoas.Gerente;



public class AppGerente extends JPanel implements ActionListener{
  private static final long serialVersionUID = 1L;
  private AppPrincipal principal;
  private SpringLayout layout;

  private JLabel labelTitulo;
  private JLabel labelFazer;
  private JLabel labelNome;
  private JLabel labelRegistro;
  private JLabel labelRegistroDemitir;
  private JLabel labelFuncao;
  private JLabel labelSenha;
  private JLabel labelSenhaDemitir;
  private JLabel labelrenda;
  private JLabel labelNewSenha; //alterar senha
  private JLabel labelTipoProduto; 
  private JLabel labelNomeP;//produto
  private JLabel labelMarcaP; //produto
  private JLabel labelPrecoP; //protuto
  private JLabel labelUndP;  //produto
  private JLabel labelValidadeP; // produto
  private JLabel labelVoltP; //produto
  private JLabel labelInfoP;

  private JTextField textNome;
  private JTextField textRegistro;
  private JTextField textRegistroDemitir;
  private JTextField textFuncao;
  private JPasswordField textSenha;
  private JPasswordField textNewSenha; //alterar senha
  private JTextField textNomeP; ;//produto
  private JTextField textMarcaP;//produto
  private JTextField textPrecoP;//produto
  private JTextField textValidadeP;//produto
  private JTextField textUndP;//produto
  private JTextField textVoltP;//produto

  private static JButton btCadastrar;
  private static JButton btVoltar;
  private static JButton btVoltar2;
  private static JButton btAddGerente;
  private static JButton btAddFuncionario;
  private static JButton btRemove;
  private static JButton btLista;
  private static JButton btRenda;
  private static JButton btSenha;
  private static JButton btSair;
  private static JButton btDemitir;
  private static JButton btAlterar; //alterar senha
  private static JButton btNewProbuto; //cadastrar produto
  private static JButton btAlimento;
  private static JButton btHigiene;
  private static JButton btEletronico;
  private static JButton btCadastrarP;
  private static JButton btVoltar3;// novo botao voltar

  private static JTable tabela;
  private static JScrollPane barraRolagem;


  public AppGerente(AppPrincipal principal){

    labelTitulo = new JLabel("APLICATIVO DO GERENTE");
    labelFazer = new JLabel("O que deseja fazer?");
    labelNome = new JLabel("Informe o Nome:");
    labelRegistro = new JLabel("Informe o Registro:");
    labelRegistroDemitir = new JLabel("Informe o Registro:");
    labelFuncao = new JLabel("Informe a Funcão:");
    labelSenha = new JLabel("Informe a Senha:");
    labelSenhaDemitir = new JLabel("Informe a senha:");
    labelrenda = new JLabel("Renda");
    labelNewSenha = new JLabel("Digite a nova senha: "); //alterar senha
    labelTipoProduto = new JLabel("Qual tipo de produto deseja cadastar? ");
    labelNomeP = new JLabel("Nome: ");
    labelMarcaP = new JLabel("Marca: ");
    labelPrecoP = new JLabel("Preço: ");
    labelValidadeP = new JLabel("Validade: ");
    labelUndP = new JLabel("Unidades: "); 
    labelVoltP = new JLabel("Voltagem: ");
    labelInfoP = new JLabel("Informações do Produto: ");

    textNome = new JTextField(20);
    textRegistro = new JTextField(20);
    textRegistroDemitir = new JTextField(20);
    textFuncao = new JTextField(20);
    textSenha = new JPasswordField(20);
    textNewSenha = new JPasswordField(20); //alterar senha
    textNomeP = new JTextField(15); 
    textMarcaP = new JTextField(15); 
    textPrecoP = new JTextField(15); 
    textValidadeP = new JTextField(15); 
    textUndP = new JTextField(15); 
    textVoltP = new JTextField(15); 

    btCadastrar = new JButton("Cadastrar");
    btVoltar = new JButton("Voltar");
    btVoltar2 = new JButton("Voltar");
    btAddGerente = new JButton("Adicionar Gerente");
    btAddFuncionario = new JButton("Adicionar Funcionário");
    btRemove = new JButton("Demitir Funcionário");
    btLista = new JButton("Ver Estoque");
    btRenda = new JButton("Mostrar Renda");
    btSenha = new JButton("Alterar Senha");
    btSair = new JButton("Sair");
    btDemitir = new JButton("Demitir");
    btAlterar = new JButton("Alterar"); //alterar senha
    btNewProbuto = new JButton("Cadastrar Produto");
    btAlimento = new JButton("Alimentação");
    btHigiene = new JButton("Higiene");
    btEletronico = new JButton("Eletrônico");
    btCadastrarP = new JButton("Cadastrar produto");
    btVoltar3 = new JButton("Voltar"); //novo botao voltar


    this.principal = principal;
    this.setSize(500, 500);
    this.inicializarComponentes();
    this.setLayout(layout);
  }

  public void inicializarComponentes(){

    layout=new SpringLayout();

    btDemitir.addActionListener(this);
    btCadastrar.addActionListener(this);
    btVoltar.addActionListener(this);
    btVoltar2.addActionListener(this);
    btAddGerente.addActionListener(this);
    btAddFuncionario.addActionListener(this);
    btRemove.addActionListener(this);
    btLista.addActionListener(this);
    btRenda.addActionListener(this);
    btSenha.addActionListener(this);
    btSair.addActionListener(principal);
    btAlterar.addActionListener(this); //alterar senha
    btNewProbuto.addActionListener(this);
    btAlimento.addActionListener(this);
    btHigiene.addActionListener(this);
    btEletronico.addActionListener(this);
    btCadastrarP.addActionListener(this);
    btVoltar3.addActionListener(this);//novo botao voltar

    labelrenda.setVisible(false);
    labelNome.setVisible(false);
    labelRegistro.setVisible(false);
    labelSenha.setVisible(false);
    labelFuncao.setVisible(false);
    labelNewSenha.setVisible(false); //alterar senha
    labelTitulo.setFont(new Font("Arial", 0, 16));
    labelTipoProduto.setVisible(false);
    labelNomeP.setVisible(false);
    labelMarcaP.setVisible(false);
    labelPrecoP.setVisible(false);
    labelValidadeP.setVisible(false);
    labelUndP.setVisible(false);
    labelVoltP.setVisible(false);
    labelInfoP.setFont(new Font("Arial", 0, 16));
    labelInfoP.setVisible(false);
    labelRegistroDemitir.setVisible(false);

    textNome.setVisible(false);
    textRegistro.setVisible(false);
    textRegistroDemitir.setVisible(false);
    textFuncao.setVisible(false);
    textSenha.setVisible(false);
    textNewSenha.setVisible(false); //alterar senha
    textNomeP.setVisible(false);
    textMarcaP.setVisible(false);
    textPrecoP.setVisible(false);
    textValidadeP.setVisible(false);
    textUndP.setVisible(false);
    textVoltP.setVisible(false);

    btDemitir.setVisible(false);
    btVoltar.setVisible(false);
    btVoltar2.setVisible(false);
    btVoltar3.setVisible(false);
    btCadastrar.setVisible(false);
    btAlterar.setVisible(false); //alterar senha
    btAlimento.setVisible(false);
    btHigiene.setVisible(false);
    btEletronico.setVisible(false);
    btCadastrarP.setVisible(false);
    labelSenhaDemitir.setVisible(false);


    labelTitulo.setFont(new Font("Arial", 0, 18));

    this.add(labelTitulo);
    this.add(labelFazer);
    this.add(labelNome);
    this.add(labelRegistro);
    this.add(labelFuncao);
    this.add(labelSenha);
    this.add(labelrenda);
    this.add(labelNewSenha); //alterar senha
    this.add(labelTipoProduto);
    this.add(labelNomeP);
    this.add(labelMarcaP);
    this.add(labelPrecoP);
    this.add(labelValidadeP);
    this.add(labelUndP);
    this.add(labelVoltP);
    this.add(labelInfoP);
    this.add(labelRegistroDemitir);
    this.add(labelSenhaDemitir);

    this.add(textNome);
    this.add(textRegistro);
    this.add(textRegistroDemitir);
    this.add(textFuncao);
    this.add(textSenha);
    this.add(textNewSenha); //alterar senha
    this.add(textNomeP);
    this.add(textMarcaP);
    this.add(textPrecoP);
    this.add(textValidadeP);
    this.add(textUndP);
    this.add(textVoltP);

    this.add(btDemitir);
    this.add(btVoltar);
    this.add(btVoltar2);
    this.add(btCadastrar);
    this.add(btAddGerente);
    this.add(btAddFuncionario);
    this.add(btRemove);
    this.add(btLista);
    this.add(btRenda);
    this.add(btSenha);
    this.add(btSair);
    this.add(btAlterar); //alterar senha
    this.add(btNewProbuto);
    this.add(btAlimento);
    this.add(btHigiene);
    this.add(btEletronico);
    this.add(btCadastrarP);
    this.add(btVoltar3);//novo botao voltar


    //Titulo
    layout.putConstraint(SpringLayout.WEST, labelTitulo, 120, SpringLayout.WEST, this);
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

    //Botao cadastrar produto
    layout.putConstraint(SpringLayout.WEST, btNewProbuto, 0, SpringLayout.WEST, btSenha);
    layout.putConstraint(SpringLayout.NORTH, btNewProbuto, 10, SpringLayout.SOUTH, btSenha);

    //Botao Sair 
    layout.putConstraint(SpringLayout.WEST, btSair, 0, SpringLayout.WEST, btNewProbuto);
    layout.putConstraint(SpringLayout.NORTH, btSair, 10, SpringLayout.SOUTH, btNewProbuto);

    //label Nome
    layout.putConstraint(SpringLayout.EAST, labelNome, -10, SpringLayout.WEST, textNome);
    layout.putConstraint(SpringLayout.NORTH, labelNome, 100, SpringLayout.SOUTH, labelTitulo);

    //label Registro
    layout.putConstraint(SpringLayout.WEST, labelRegistro, -10, SpringLayout.WEST, labelNome);
    layout.putConstraint(SpringLayout.NORTH, labelRegistro, 10, SpringLayout.SOUTH, labelNome);

    //Botao Demitir
    layout.putConstraint(SpringLayout.EAST, btDemitir, -10, SpringLayout.WEST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, btDemitir, 0, SpringLayout.NORTH, btVoltar);

    //label Funcao
    layout.putConstraint(SpringLayout.EAST, labelFuncao, 0, SpringLayout.EAST, labelNome);
    layout.putConstraint(SpringLayout.NORTH, labelFuncao, 10, SpringLayout.SOUTH, labelSenha);

    //label Senha
    layout.putConstraint(SpringLayout.WEST, labelSenha, 0, SpringLayout.WEST, labelRegistro);
    layout.putConstraint(SpringLayout.NORTH, labelSenha, 10, SpringLayout.SOUTH, labelRegistro);

    //TextField Nome
    layout.putConstraint(SpringLayout.EAST, textNome, 5, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, textNome, 0, SpringLayout.NORTH, labelNome);

    //TextField Registro
    layout.putConstraint(SpringLayout.EAST, textRegistro, 5, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.SOUTH, textRegistro, -5, SpringLayout.NORTH, labelSenha);

    //TextField Funcao
    layout.putConstraint(SpringLayout.EAST, textFuncao,5 , SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, textFuncao, 0, SpringLayout.NORTH, labelFuncao);

    //TextField Senha
    layout.putConstraint(SpringLayout.EAST, textSenha, 5, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, textSenha, 0, SpringLayout.NORTH, labelSenha);

    //Botao Cadastrar 
    layout.putConstraint(SpringLayout.EAST, btCadastrar, -10, SpringLayout.WEST, btVoltar);
    layout.putConstraint(SpringLayout.SOUTH, btCadastrar, 0, SpringLayout.SOUTH, btVoltar);


    //Botao Voltar
    layout.putConstraint(SpringLayout.EAST, btVoltar, 0, SpringLayout.EAST, btEletronico);
    layout.putConstraint(SpringLayout.NORTH, btVoltar, 70, SpringLayout.SOUTH, btEletronico);

    //Botao Voltar2
    layout.putConstraint(SpringLayout.EAST, btVoltar2, 0, SpringLayout.EAST, btEletronico);
    layout.putConstraint(SpringLayout.NORTH, btVoltar2, 70, SpringLayout.SOUTH, btEletronico);

    //label renda
    layout.putConstraint(SpringLayout.EAST, labelrenda, -50, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.SOUTH, labelrenda, -50, SpringLayout.NORTH, btVoltar);

    //Botao alterar
    layout.putConstraint(SpringLayout.EAST, btAlterar, -10, SpringLayout.WEST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, btAlterar, 0, SpringLayout.NORTH, btVoltar2);

    //textfild
    layout.putConstraint(SpringLayout.EAST, textNewSenha, 0, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, textNewSenha, 0, SpringLayout.NORTH, labelFuncao);
    
    //text demitir
    layout.putConstraint(SpringLayout.EAST, textRegistroDemitir, 0, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, textRegistroDemitir, 0, SpringLayout.NORTH, labelFuncao);

    //label newsenha labelRegistroDemitir
    layout.putConstraint(SpringLayout.EAST, labelNewSenha, -5, SpringLayout.WEST, textNewSenha);
    layout.putConstraint(SpringLayout.NORTH, labelNewSenha, 0, SpringLayout.NORTH, labelFuncao);
    
    // label demitir
    layout.putConstraint(SpringLayout.EAST, labelRegistroDemitir, -5, SpringLayout.WEST, textRegistroDemitir);
    layout.putConstraint(SpringLayout.NORTH, labelRegistroDemitir, 0, SpringLayout.NORTH, textRegistroDemitir);
    
    //Botao Higiene
    layout.putConstraint(SpringLayout.WEST, btHigiene, 80, SpringLayout.WEST, btAddGerente);
    layout.putConstraint(SpringLayout.NORTH, btHigiene, 10, SpringLayout.SOUTH, btAddGerente);

    //Botao Alimentacao
    layout.putConstraint(SpringLayout.EAST, btAlimento, -10, SpringLayout.WEST, btHigiene);
    layout.putConstraint(SpringLayout.NORTH, btAlimento, 10, SpringLayout.SOUTH, btAddGerente);

    //Botao Eletronico
    layout.putConstraint(SpringLayout.WEST, btEletronico, 10, SpringLayout.EAST, btHigiene);
    layout.putConstraint(SpringLayout.NORTH, btEletronico, 10, SpringLayout.SOUTH, btAddGerente);

    //labelTipoProduto
    layout.putConstraint(SpringLayout.WEST, labelTipoProduto, 20, SpringLayout.WEST, labelTitulo);
    layout.putConstraint(SpringLayout.NORTH, labelTipoProduto, 130, SpringLayout.NORTH, labelTitulo);

    // Opcoes produtos

    //nome
    layout.putConstraint(SpringLayout.EAST,labelNomeP, -30, SpringLayout.WEST, btCadastrarP);
    layout.putConstraint(SpringLayout.NORTH, labelNomeP, -200, SpringLayout.SOUTH, btVoltar2);

    layout.putConstraint(SpringLayout.WEST, textNomeP, 0, SpringLayout.EAST, labelNomeP);
    layout.putConstraint(SpringLayout.NORTH, textNomeP, 0, SpringLayout.NORTH, labelNomeP);

    //Marca
    layout.putConstraint(SpringLayout.EAST,labelMarcaP, 0, SpringLayout.WEST, textMarcaP);
    layout.putConstraint(SpringLayout.NORTH, labelMarcaP, 0, SpringLayout.NORTH, textMarcaP);

    layout.putConstraint(SpringLayout.WEST, textMarcaP, 0, SpringLayout.WEST, textNomeP);
    layout.putConstraint(SpringLayout.NORTH, textMarcaP, 15, SpringLayout.SOUTH, textNomeP);

    //Preco
    layout.putConstraint(SpringLayout.EAST, labelPrecoP, 0, SpringLayout.WEST, textPrecoP);
    layout.putConstraint(SpringLayout.NORTH, labelPrecoP, 0, SpringLayout.NORTH, textPrecoP);

    layout.putConstraint(SpringLayout.WEST, textPrecoP, 0, SpringLayout.WEST, textMarcaP);
    layout.putConstraint(SpringLayout.NORTH, textPrecoP, 15, SpringLayout.SOUTH, textMarcaP);

    //Validade
    layout.putConstraint(SpringLayout.EAST,labelValidadeP, 0, SpringLayout.WEST, textValidadeP);
    layout.putConstraint(SpringLayout.NORTH, labelValidadeP, 0, SpringLayout.NORTH, textValidadeP);

    layout.putConstraint(SpringLayout.WEST, textValidadeP, 0, SpringLayout.WEST, textPrecoP);
    layout.putConstraint(SpringLayout.NORTH, textValidadeP, 15, SpringLayout.SOUTH, textPrecoP);

    //Voltagem
    layout.putConstraint(SpringLayout.EAST, labelVoltP, 0, SpringLayout.WEST, textValidadeP);
    layout.putConstraint(SpringLayout.NORTH, labelVoltP, 0, SpringLayout.NORTH, textValidadeP);

    layout.putConstraint(SpringLayout.WEST, textVoltP, 0, SpringLayout.EAST,labelVoltP);
    layout.putConstraint(SpringLayout.NORTH, textVoltP, 15, SpringLayout.SOUTH, textPrecoP);

    //Unidade
    layout.putConstraint(SpringLayout.EAST,labelUndP, 0, SpringLayout.WEST, textUndP);
    layout.putConstraint(SpringLayout.NORTH, labelUndP, 0, SpringLayout.NORTH, textUndP);

    layout.putConstraint(SpringLayout.WEST, textUndP, 0, SpringLayout.WEST, textValidadeP);
    layout.putConstraint(SpringLayout.NORTH, textUndP, 15, SpringLayout.SOUTH, textValidadeP);

    //Botao CadastrarP
    layout.putConstraint(SpringLayout.EAST, btCadastrarP, -10, SpringLayout.WEST, btVoltar2);
    layout.putConstraint(SpringLayout.NORTH, btCadastrarP, 0, SpringLayout.NORTH, btVoltar2);

    //Label labelInfoP
    layout.putConstraint(SpringLayout.WEST, labelInfoP, 175, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, labelInfoP, 10, SpringLayout.NORTH, this);

    //Label btVoltar3
    layout.putConstraint(SpringLayout.WEST, btVoltar3, -90, SpringLayout.EAST, this);
    layout.putConstraint(SpringLayout.NORTH, btVoltar3, 440, SpringLayout.NORTH, this);

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
    btNewProbuto.setVisible(false);

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
      String novoRegistro="",novaSenha="",nome="",func="";
      char[] pass;
      int registro;
      int senha =0;
      try {//FUNCAO
        func = textFuncao.getText();
        if(func.isEmpty()){
          func ="";
          principal.getStatus().setTexto("Digite uma funcão válida!");
        }
      } catch (Exception e2) {
        func="";
        System.out.println(e2);
        principal.getStatus().setTexto("Digite uma funcão válida!");
      }  
      try{//SENHA
        pass = textSenha.getPassword();
        for (int i = 0; i < pass.length; i++) {
          novaSenha += pass[i];
        }
        senha = Integer.parseInt(novaSenha);
      }catch (Exception e2) {
        System.out.println(e2);
        principal.getStatus().setTexto("Digite uma Senha válida!");
        senha = -32000;
      }
      try{//REGISTRO
        novoRegistro = textRegistro.getText();
        registro = Integer.parseInt(novoRegistro);
      }catch (Exception e2) {
        System.out.println(e2);
        principal.getStatus().setTexto("Digite um Registro válido!");
        registro = -32000;
      }
      try {//NOME
        nome = textNome.getText();
        if(nome.isEmpty()){
          nome ="";
          principal.getStatus().setTexto("Digite um nome válido!");
        }
      } catch (Exception e2) {
        nome=null;
        System.out.println(e2);
        principal.getStatus().setTexto("Digite um nome válido!");
      }

      if(labelTitulo.getText() == "Cadastrar novo funcionário"){
        if(registro != 0 && senha != 0 && nome != "" && func != ""){
          admiteFuncionario(nome,registro,senha,func);
        }
      }else{
        if(registro != 0 && senha != 0 && nome != ""){
          admiteGerente(nome,registro,senha);
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
      btNewProbuto.setVisible(true);
      btSair.setVisible(true);
      btVoltar.setVisible(false);
      btCadastrar.setVisible(false);
      btDemitir.setVisible(false);
      btAlterar.setVisible(false);
      btAlimento.setVisible(false);
      btHigiene.setVisible(false);
      btEletronico.setVisible(false);
      btVoltar2.setVisible(false);

      labelFazer.setVisible(true);
      labelTitulo.setText("APLICATIVO DO GERENTE");
      labelNome.setVisible(false);
      labelRegistro.setVisible(false);
      labelSenha.setVisible(false);
      labelFuncao.setVisible(false);
      labelrenda.setVisible(false);
      labelNewSenha.setVisible(false);
      labelTipoProduto.setVisible(false);
      labelRegistroDemitir.setVisible(false);

      textNome.setVisible(false);
      textRegistro.setVisible(false);
      textSenha.setVisible(false);
      textFuncao.setVisible(false);
      textNewSenha.setVisible(false);
      textRegistroDemitir.setVisible(false);

      principal.getStatus().setTexto("Aplicativo do Gerente");

    }
    else if(e.getSource() == btVoltar2){
      
      labelTitulo.setText("           Cadastrar Produto");
      labelTitulo.setVisible(true);
      labelTipoProduto.setVisible(true);
      btAlimento.setVisible(true);
      btHigiene.setVisible(true);
      btEletronico.setVisible(true);
      btVoltar.setVisible(true);
      btVoltar2.setVisible(false);
      btCadastrarP.setVisible(false);

      labelNomeP.setVisible(false);
      labelMarcaP.setVisible(false);
      labelPrecoP.setVisible(false);
      labelValidadeP.setVisible(false);
      labelUndP.setVisible(false);
      labelVoltP.setVisible(false);
      labelInfoP.setVisible(false);

      textUndP.setVisible(false);
      textNomeP.setVisible(false);
      textMarcaP.setVisible(false);
      textPrecoP.setVisible(false);
      textValidadeP.setVisible(false);
      textUndP.setVisible(false);
      textVoltP.setVisible(false);

      principal.getStatus().setTexto("Aplicativo do Gerente");
    }
    else if(e.getSource() == btRemove){
      textRegistroDemitir.setVisible(true);
      labelTitulo.setText("           Demitir Funcionario");
      labelTitulo.setVisible(true);
      //textRegistro.setVisible(true);
      btDemitir.setVisible(true);
      btVoltar.setVisible(true);
      labelRegistroDemitir.setVisible(true);
    }
    else if(e.getSource() == btLista){
      labelTitulo.setVisible(false);
      btVoltar3.setVisible(true);
      btVoltar.setVisible(false);
      btVoltar2.setVisible(false);
      createTable(principal.getLoja().getListaprodutos());
      this.add(barraRolagem);
      //ScrollBar barraRolagem
      layout.putConstraint(SpringLayout.WEST,barraRolagem, 10, SpringLayout.WEST, this);
      layout.putConstraint(SpringLayout.NORTH,barraRolagem, 10, SpringLayout.NORTH, this);
      principal.setSize(500, 530);
      this.setSize(500, 530);
    }
    else if(e.getSource() == btVoltar3){
      principal.getStatus().setTexto("Aplicativo do Gerente");
      principal.setSize(500, 500);
      this.setSize(500, 500);
      this.remove(barraRolagem);
      btVoltar3.setVisible(false);

      btAddFuncionario.setVisible(true);
      btAddGerente.setVisible(true);
      btRemove.setVisible(true);
      btLista.setVisible(true);
      btRenda.setVisible(true);
      btSenha.setVisible(true);
      btNewProbuto.setVisible(true);
      btSair.setVisible(true);
      btVoltar.setVisible(false);
      btCadastrar.setVisible(false);
      btDemitir.setVisible(false);
      btAlterar.setVisible(false);
      btAlimento.setVisible(false);
      btHigiene.setVisible(false);
      btEletronico.setVisible(false);
      btVoltar2.setVisible(false);

      labelFazer.setVisible(true);
      labelTitulo.setVisible(true);
      labelNome.setVisible(false);
      labelRegistro.setVisible(false);
      labelSenha.setVisible(false);
      labelFuncao.setVisible(false);
      labelrenda.setVisible(false);
      labelNewSenha.setVisible(false);
      labelTipoProduto.setVisible(false);

    }
    else if(e.getSource() == btRenda){
      labelTitulo.setText("     Renda Atual da Loja");
      
      String renda;
      btVoltar.setVisible(true);
      labelrenda.setVisible(true);
      labelrenda.setFont(new Font("Arial",0,18));
      renda  = "A RENDA DA LOJA R$: "+principal.getLoja().getRenda()+" ";
      labelrenda.setText(renda);
      principal.getStatus().setTexto("Verificação de renda!");
    }
    else if(e.getSource() == btSenha){
      labelTitulo.setText("           Alterar Senha");
      labelTitulo.setVisible(true);
      btAlterar.setVisible(true);
      textNewSenha.setVisible(true);
      labelNewSenha.setVisible(true);
      btVoltar.setVisible(true);
    }
    else if(e.getSource()==btAlterar){
      char[]pass;
      String novaSenha = "";
      int senha = 1;
      try{//SENHA
        pass = textNewSenha.getPassword();
        for (int i = 0; i < pass.length; i++) {
          novaSenha += pass[i];
        }
        senha = Integer.parseInt(novaSenha);
      }catch (Exception e2) {
        System.out.println(e2);
        principal.getStatus().setTexto("Digite uma Senha válida!");
        senha = -32000; //SUBSTITUIR O RESULTADO DA EXCESÃO
      }
      if(senha != -32000){
        if(String.valueOf(senha).length() == 6){
          principal.getLoja().alterarSenhaGerente(principal.getLogada(), senha);
          principal.getStatus().setTexto("Senha alterada com sucesso");
        }else{
          principal.getStatus().setTexto("Digite uma senha com 6 digitos!");
        }
      }
    }    
    else if(e.getSource() == btDemitir){
      int registro=0,aux=0;
      String novoRegistro;
      try{
        novoRegistro = textRegistro.getText();
        registro = Integer.parseInt(novoRegistro);
      }catch (Exception e2) {
        System.out.println(e2);
        principal.getStatus().setTexto("Digite um Registro válido!");
        registro = -32000;
      }
      if(registro !=0 ){
        aux=principal.getLoja().Demitir(registro);
        if(aux==1){
          principal.getStatus().setTexto("Funcionario Demitido!");
        }else{
          principal.getStatus().setTexto("Funcionario não encontrado!");
        }
      }
    }
    else if(e.getSource() == btNewProbuto){
      labelTitulo.setText("           Cadastrar Produto");
      labelTitulo.setVisible(true);
      labelTipoProduto.setVisible(true);
      btVoltar2.setVisible(false);
      btVoltar.setVisible(true);
      btAlimento.setVisible(true);
      btHigiene.setVisible(true);
      btEletronico.setVisible(true);

    }
    else if(e.getSource() == btAlimento){
      labelTitulo.setText("Cadastrar Alimento");
      labelTipoProduto.setVisible(false);
      btVoltar.setVisible(false);
      btAlimento.setVisible(false);
      btHigiene.setVisible(false);
      btEletronico.setVisible(false);
      btCadastrarP.setVisible(true);

      btVoltar2.setVisible(true);
      labelNomeP.setVisible(true);
      labelMarcaP.setVisible(true);
      labelPrecoP.setVisible(true);
      labelValidadeP.setVisible(true);
      labelUndP.setVisible(true);
      labelInfoP.setVisible(true);
      labelTitulo.setVisible(false);


      textUndP.setVisible(true);
      textNomeP.setVisible(true);
      textMarcaP.setVisible(true);
      textPrecoP.setVisible(true);
      textValidadeP.setVisible(true);
      textUndP.setVisible(true);

    }
    else if(e.getSource() == btHigiene){
      labelTitulo.setText("Cadastrar Higiene");
      labelTipoProduto.setVisible(false);
      btVoltar.setVisible(false);
      btAlimento.setVisible(false);
      btHigiene.setVisible(false);
      btEletronico.setVisible(false);
      btCadastrarP.setVisible(true);

      btVoltar2.setVisible(true);
      labelNomeP.setVisible(true);
      labelMarcaP.setVisible(true);
      labelPrecoP.setVisible(true);
      labelValidadeP.setVisible(true);
      labelUndP.setVisible(true);
      labelInfoP.setVisible(true);
      labelTitulo.setVisible(false);


      textUndP.setVisible(true);
      textNomeP.setVisible(true);
      textMarcaP.setVisible(true);
      textPrecoP.setVisible(true);
      textValidadeP.setVisible(true);
      textUndP.setVisible(true);

    }
    else if(e.getSource() == btEletronico){
      labelTitulo.setText("Cadastrar Eletronico");
      labelTipoProduto.setVisible(false);
      btVoltar.setVisible(false);
      btAlimento.setVisible(false);
      btHigiene.setVisible(false);
      btEletronico.setVisible(false);
      btCadastrarP.setVisible(true);

      btVoltar2.setVisible(true);
      labelNomeP.setVisible(true);
      labelMarcaP.setVisible(true);
      labelPrecoP.setVisible(true);
      labelValidadeP.setVisible(false);
      labelUndP.setVisible(true);
      labelVoltP.setVisible(true);
      labelInfoP.setVisible(true);
      labelTitulo.setVisible(false);

      textUndP.setVisible(true);
      textNomeP.setVisible(true);
      textMarcaP.setVisible(true);
      textPrecoP.setVisible(true);
      textValidadeP.setVisible(false);
      textUndP.setVisible(true);
      textVoltP.setVisible(true);
    }else if(e.getSource() == btCadastrarP){
      String nome="",marca="",Tpreco="",validade="",Tunidades="",Tvoltagem="";
      float preco = -32000f;
      int unidades = -32000;
      int voltagem = -32000;

      try{
        Tunidades = textUndP.getText();
        unidades = Integer.parseInt(Tunidades);
      }catch (Exception e21) {
        System.out.println(e21);
        principal.getStatus().setTexto("Digite unidades válidas!");
        unidades = -32000;
      }
      try{
        Tvoltagem = textVoltP.getText();
        voltagem = Integer.parseInt(Tvoltagem);
      }catch (Exception e21) {
        System.out.println(e21);
        principal.getStatus().setTexto("Digite uma voltagem válida!");
        voltagem = -32000;
      }
      try{
        validade = textValidadeP.getText();
        if(validade.isEmpty()){
          validade ="";
          principal.getStatus().setTexto("Digite uma validade!");
        }    
      }catch (Exception e2) {
        principal.getStatus().setTexto("Digite um validade!");
        validade = "";
      }
      try{
        Tpreco = textPrecoP.getText();
        preco = Float.parseFloat(Tpreco);
      }catch (Exception e2) {
        System.out.println(e2);
        principal.getStatus().setTexto("Digite um preco válido!");
        preco = -32000f;
      }
      try{
        marca = textMarcaP.getText();
        if(marca.isEmpty()){
          marca ="";
          principal.getStatus().setTexto("Digite uma marca válida!");
        }    
      }catch (Exception e2) {
        principal.getStatus().setTexto("Digite uma marca válida!");
        marca = "";
      }
      try{
        nome = textNomeP.getText();
        if(nome.isEmpty()){
          nome ="";
          principal.getStatus().setTexto("Digite um nome válido!");
        }    
      }catch (Exception e2) {
        principal.getStatus().setTexto("Digite um nome válido!");
        nome = "";
      }
      if(labelTitulo.getText()=="Cadastrar Eletronico"){
        if(nome!="" && marca!="" && preco!=-32000f && voltagem!=-32000 && unidades!=-32000){
          cadastroEletronico(nome,marca,preco,voltagem,unidades);
        }
      }else if(labelTitulo.getText()=="Cadastrar Alimento"){
        if(nome!="" && marca!="" && preco!=-32000f && validade!="" && unidades!=-32000){
          cadastroAlimento(nome,marca,preco,validade,unidades);
        }
      }else if(labelTitulo.getText()=="Cadastrar Higiene"){
        if(nome!="" && marca!="" && preco!=-32000f && validade!="" && unidades!=-32000){
          cadastroHigiene(nome,marca,preco,validade,unidades);
        }
      }
    }
    principal.repaint();
  }
  public void cadastroEletronico(String nome,String marca,float preco,int voltagem,int unidades){
    Eletronicos e= new Eletronicos(nome,marca,preco,voltagem,unidades);
    if(principal.getLoja().Comprar(e)){
      principal.getStatus().setTexto("Produto estocado com sucesso!");
    }else{
      principal.getStatus().setTexto("Produto não estocado!");
    }
  }
  public void cadastroAlimento(String nome,String marca,float preco,String validade,int unidades){
    Alimentacao a= new Alimentacao(nome,marca,preco,validade,unidades);
    if(principal.getLoja().Comprar(a)){
      principal.getStatus().setTexto("Produto estocado com sucesso!");
    }else{
      principal.getStatus().setTexto("Produto não estocado!");
    }
  }
  public void cadastroHigiene(String nome,String marca,float preco,String validade,int unidades){
    Higiene h= new Higiene(nome,marca,preco,validade,unidades);
    if(principal.getLoja().Comprar(h)){
      principal.getStatus().setTexto("Produto estocado com sucesso!");
    }else{
      principal.getStatus().setTexto("Produto não estocado!");
    }
  }

  public void admiteFuncionario(String nome,int registro,int senha,String funcao){
    if(String.valueOf(registro).length() == 6){
      if(String.valueOf(senha).length() == 4){
        if(principal.getLoja().getFuncionario().get(registro) == null){
          Funcionario novo = new Funcionario(nome,registro,funcao,senha);
          principal.getLoja().Cadastrar(novo);
          principal.getStatus().setTexto("Funcionario Cadastrado!");
        }else{
          principal.getStatus().setTexto("Funcionario já Cadastrado!");
        }
      }else{
        principal.getStatus().setTexto("Digite uma senha de 4 digitos!");
      }
    }else{
      principal.getStatus().setTexto("Digite um Registro de 6 digitos!");
    }
  }

  public void admiteGerente(String nome,int registro,int senha){
    if(String.valueOf(registro).length() == 6){
      if(String.valueOf(senha).length() == 6){
        if(principal.getLoja().getFuncionario().get(registro) == null){
          Gerente gerente = new Gerente(nome,registro,senha);
          principal.getLoja().Cadastrar(gerente);
          principal.getStatus().setTexto("Gerente Cadastrado!");
        }else{
          principal.getStatus().setTexto("Gerente já Cadastrado!");
        }
      }else{
        principal.getStatus().setTexto("Digite uma senha de 6 digitos!");
      }
    }else{
      principal.getStatus().setTexto("Digite um Registro de 6 digitos!");
    }
  }
  public void createTable(ArrayList<Produtos> p){
    String [] colunas = {"Nome", "Marca", "Preço","Unidades","Validade","Voltagem"};
    Object [][] dados;
    tabela = null;
    dados = new Object[p.size()][6];

    for(int i=0; i< p.size(); i++){
      if(p.get(i) instanceof Alimentacao){
        Alimentacao a = (Alimentacao)p.get(i);
        dados[i][0] = a.getNome();
        dados[i][1] = a.getMarca();
        dados[i][2] = a.getPreco();
        dados[i][3] = a.getUnidades();
        dados[i][4] = a.getValidade();
        dados[i][5] = "-";
      }else if(p.get(i) instanceof Higiene){
        Higiene h = (Higiene)p.get(i);
        dados[i][0] = h.getNome();
        dados[i][1] = h.getMarca();
        dados[i][2] = h.getPreco();
        dados[i][3] = h.getUnidades();
        dados[i][4] = h.getValidade();
        dados[i][5] = "-";
      }else if(p.get(i) instanceof Eletronicos){
        Eletronicos e = (Eletronicos)p.get(i);
        dados[i][0] = e.getNome();
        dados[i][1] = e.getMarca();
        dados[i][2] = e.getPreco();
        dados[i][3] = e.getUnidades();
        dados[i][4] = "-";
        dados[i][5] = e.getVoltagem();
      }
    }

    tabela = new JTable(dados, colunas);
    barraRolagem = new JScrollPane(tabela);        
  }
}

