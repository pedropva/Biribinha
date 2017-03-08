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



public class AppFuncionario extends JPanel implements ActionListener{
  private static final long serialVersionUID = 1L;
  AppPrincipal principal;
  private SpringLayout layout;

  private JLabel labelTitulo;
  private JLabel labelFazer;
  private JLabel labelConsultarMarca;
  private JLabel labelNewSenha; //alterar senha
  private JLabel labelConsultar;//consultar
  private JLabel labelVender; // produto(venda)
  private JLabel labelQuant; // produto(Quant)

  private JTextField textConsultar;//consultar
  private JTextField textConsultarMarca;//consultar
  private JPasswordField textNewSenha; //alterar senha
  private JTextField textVender; // produto(venda)
  private JTextField textQuant;  // produto(Quant)

  private static JButton btListar;
  private static JButton btConsultar;
  private static JButton btVender;
  private static JButton btSenha;
  private static JButton btSair ; 
  private static JButton btVoltar;
  private static JButton btAlterar; //alterar senha
  private static JButton btBuscar;// dentro de fazer consulta 
  private static JButton btSell; // vender
  private static JButton btVoltar3;// novo botao voltar
  
  private static JTable tabela;
  private static JScrollPane barraRolagem;


  public AppFuncionario(AppPrincipal principal){
    //labels
    labelConsultarMarca = new JLabel("Informe a marca: "); //consultar
    labelTitulo = new JLabel("APLICATIVO DO FUNCIONARIO");
    labelFazer = new JLabel("O que deseja fazer?");
    labelNewSenha = new JLabel("Digite a nova senha: "); //alterar senha
    labelConsultar = new JLabel("Informe o produto: "); //consultar
    labelVender = new JLabel("Informe o produto:"); // produto(venda)
    labelQuant = new JLabel ("Quantidade:"); // produto(Quant)

    //botões
    btListar = new JButton("Listar estoque");
    btConsultar = new JButton("Fazer consulta");
    btVender = new JButton("Vender");
    btSenha = new JButton("Alterar Senha");
    btSair = new JButton("Sair");
    btAlterar = new JButton("Alterar"); //alterar senha
    btBuscar = new JButton("Consultar");//consultar
    btSell = new JButton("Vender");// vender
    btVoltar = new JButton("Voltar");
    btVoltar3 = new JButton("Voltar");

    textConsultarMarca = new JTextField(20);//consultar
    textNewSenha = new JPasswordField(20); //alterar senha
    textConsultar = new JTextField(20);//consultar
    textQuant = new JTextField(5);  // produto(Quant)
    textVender = new JTextField(20);// produto(venda)
    
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
    btBuscar.addActionListener(this);
    btAlterar.addActionListener(this);
    btVoltar.addActionListener(this);
    btSell.addActionListener(this);
    btVoltar3.addActionListener(this);//novo botao voltar

    labelNewSenha.setVisible(false); //alterar senha
    labelConsultar.setVisible(false);//consultar
    labelConsultarMarca.setVisible(false);//consultar
    labelVender.setVisible(false); // produto(venda)
    labelQuant.setVisible(false);

    textNewSenha.setVisible(false); //alterar senha
    textConsultar.setVisible(false);//consultar
    textConsultarMarca.setVisible(false);//consultar
    textQuant.setVisible(false);   // produto(Quant)
    textVender.setVisible(false);//produto(venda)

    btAlterar.setVisible(false); //alterar senha
    btBuscar.setVisible(false);//consultar
    btSell.setVisible(false);//produto(venda)
    btVoltar.setVisible(false);//produto(venda)
    btVoltar3.setVisible(false);

    labelTitulo.setFont(new Font("Arial", 0, 18));

    this.add(labelTitulo);
    this.add(labelFazer);
    this.add(labelNewSenha); //alterar senha
    this.add(labelConsultar);//consultar
    this.add(labelConsultarMarca);//consultar
    this.add(labelVender);//venda
    this.add(labelQuant);

    this.add(textNewSenha); //alterar senha
    this.add(textConsultar);//consultar
    this.add(textConsultarMarca);//consultar
    this.add(textQuant);//venda
    this.add(textVender);//venda

    this.add(btListar);
    this.add(btConsultar);
    this.add(btVender);
    this.add(btSenha);
    this.add(btSair);
    this.add(btAlterar); //alterar senha
    this.add(btBuscar);//consultar
    this.add(btSell);//venda
    this.add(btVoltar);
    this.add(btVoltar3);

    //Titulo
    layout.putConstraint(SpringLayout.WEST, labelTitulo, 100, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, labelTitulo, 10, SpringLayout.NORTH, this);

    //Mensagem de o que fazer
    layout.putConstraint(SpringLayout.WEST, labelFazer, 60, SpringLayout.WEST, labelTitulo);
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

    //Botao Voltar
    layout.putConstraint(SpringLayout.WEST, btVoltar, 10, SpringLayout.EAST, btSenha);
    layout.putConstraint(SpringLayout.NORTH, btVoltar, 0, SpringLayout.NORTH, btSenha);

    //Botao Sair 
    layout.putConstraint(SpringLayout.WEST, btSair, 0, SpringLayout.WEST, btSenha);
    layout.putConstraint(SpringLayout.NORTH, btSair, 10, SpringLayout.SOUTH, btSenha);

    //Botao alterar
    layout.putConstraint(SpringLayout.EAST, btAlterar, -10, SpringLayout.WEST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, btAlterar, 0, SpringLayout.NORTH, btVoltar );


    //textfield(senha)
    layout.putConstraint(SpringLayout.EAST, textNewSenha, 0, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, textNewSenha, -25, SpringLayout.NORTH,btVoltar );


    //label newsenha
    layout.putConstraint(SpringLayout.EAST, labelNewSenha, -5, SpringLayout.WEST, textNewSenha);
    layout.putConstraint(SpringLayout.NORTH, labelNewSenha, 0, SpringLayout.NORTH, textNewSenha);

    //botao buscar(consultar)
    layout.putConstraint(SpringLayout.WEST, btBuscar, 10, SpringLayout.EAST, textConsultarMarca);
    layout.putConstraint(SpringLayout.NORTH, btBuscar, -5, SpringLayout.NORTH, labelConsultarMarca );

    //textfild(Consultar)
    layout.putConstraint(SpringLayout.WEST, textConsultar, 20, SpringLayout.WEST, labelTitulo);
    layout.putConstraint(SpringLayout.NORTH, textConsultar, 0, SpringLayout.NORTH,labelTitulo);

    //label Consultar
    layout.putConstraint(SpringLayout.EAST, labelConsultar, -5, SpringLayout.WEST, textConsultar);
    layout.putConstraint(SpringLayout.NORTH, labelConsultar, 0, SpringLayout.NORTH, textConsultar);

    //botao vender
    layout.putConstraint(SpringLayout.EAST, btSell, -10, SpringLayout.WEST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, btSell, 0, SpringLayout.NORTH, btVoltar );

    //textfild (Quant)
    layout.putConstraint(SpringLayout.WEST, textQuant, 0, SpringLayout.WEST, textVender);
    layout.putConstraint(SpringLayout.NORTH, textQuant, -25, SpringLayout.NORTH,btVoltar );


    //label vender(quant)
    layout.putConstraint(SpringLayout.EAST, labelQuant, -5, SpringLayout.WEST, textQuant);
    layout.putConstraint(SpringLayout.NORTH, labelQuant, 0, SpringLayout.NORTH, textQuant);

    //textfild venda(produto)
    layout.putConstraint(SpringLayout.EAST, textVender, 0, SpringLayout.EAST, btVoltar);
    layout.putConstraint(SpringLayout.NORTH, textVender, -25, SpringLayout.NORTH,textQuant);


    //label venda(produto)
    layout.putConstraint(SpringLayout.EAST, labelVender, -5, SpringLayout.WEST, textVender);
    layout.putConstraint(SpringLayout.NORTH, labelVender, 0, SpringLayout.NORTH, textVender);

    //Label btVoltar3
    layout.putConstraint(SpringLayout.WEST, btVoltar3, -90, SpringLayout.EAST, this);
    layout.putConstraint(SpringLayout.NORTH, btVoltar3, 440, SpringLayout.NORTH, this);
    
    //textfield(ConsultarMarca)
    layout.putConstraint(SpringLayout.EAST, textConsultarMarca, 0, SpringLayout.EAST, textConsultar);
    layout.putConstraint(SpringLayout.NORTH, textConsultarMarca, 10, SpringLayout.SOUTH,textConsultar);

    //label ConsultarMarca
    layout.putConstraint(SpringLayout.EAST, labelConsultarMarca, -5, SpringLayout.WEST, textConsultarMarca);
    layout.putConstraint(SpringLayout.NORTH, labelConsultarMarca, 0, SpringLayout.NORTH, textConsultarMarca);

  }
  @Override
  public void actionPerformed( ActionEvent e ){
    btListar.setVisible(false);
    btConsultar.setVisible(false);
    btVender.setVisible(false);
    btSenha.setVisible(false);
    btSair.setVisible(false);


    labelFazer.setVisible(false);

    if(e.getSource() == btListar){
      labelTitulo.setVisible(false);
      btVoltar3.setVisible(true);
      btVoltar.setVisible(false);
      
      createTable(principal.getLoja().getListaprodutos());
      this.add(barraRolagem);
      
      this.remove(btVoltar3);
      this.add(btVoltar3);
      
      //Label btVoltar3
      layout.putConstraint(SpringLayout.WEST, btVoltar3, -90, SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.NORTH, btVoltar3, 440, SpringLayout.NORTH, this);
      
      //ScrollBar barraRolagem
      layout.putConstraint(SpringLayout.WEST,barraRolagem, 10, SpringLayout.WEST, this);
      layout.putConstraint(SpringLayout.NORTH,barraRolagem, 10, SpringLayout.NORTH, this);
      
      principal.setSize(500, 530);
      this.setSize(500, 530);
    }
    else if(e.getSource() == btVoltar3){
      principal.getStatus().setTexto("Aplicativo do Funcionario!");
      principal.setSize(500, 500);
      this.setSize(500, 500);
      this.remove(barraRolagem);
      btVoltar3.setVisible(false);
      
      btListar.setVisible(true);
      btConsultar.setVisible(true);
      btSenha.setVisible(true);
      btSair.setVisible(true);
      btVender.setVisible(true);
      
      btVoltar.setVisible(false);
      
      btBuscar.setVisible(false);
      textConsultar.setVisible(false);
      labelConsultar.setVisible(false);
      textConsultarMarca.setVisible(false);
      labelConsultarMarca.setVisible(false);
      labelFazer.setVisible(false);
      
      labelTitulo.setVisible(true);
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
        if(String.valueOf(senha).length() == 4){
          principal.getLoja().alterarSenhaFunc(principal.getLogada(), senha);
          principal.getStatus().setTexto("Senha alterada com sucesso");
        }else{
          principal.getStatus().setTexto("Digite uma senha com 4 digitos!");
        }
      }
    }
    else if(e.getSource() == btConsultar){
      principal.setSize(500, 600);
      this.setSize(500, 600);
      labelTitulo.setVisible(false);
      btVoltar3.setVisible(true);
      ArrayList<Produtos> p =new ArrayList<Produtos>();
      createTable(p);
      this.add(barraRolagem);
      //ScrollBar barraRolagem
      layout.putConstraint(SpringLayout.WEST,barraRolagem, 0, SpringLayout.WEST, labelConsultarMarca);
      layout.putConstraint(SpringLayout.NORTH,barraRolagem, 30, SpringLayout.NORTH, labelConsultarMarca);
      
      //Label btVoltar3
      layout.putConstraint(SpringLayout.EAST, btVoltar3, 0, SpringLayout.EAST, barraRolagem);
      layout.putConstraint(SpringLayout.NORTH, btVoltar3, 10, SpringLayout.SOUTH, barraRolagem);
      
      btBuscar.setVisible(true);
      textConsultar.setVisible(true);
      labelConsultar.setVisible(true);
      textConsultarMarca.setVisible(true);
      labelConsultarMarca.setVisible(true);
    }
    else if(e.getSource() == btBuscar){
      this.remove(barraRolagem);
      ArrayList<Produtos> p=null;
      String nome="",marca="";
      try{
        marca = textConsultarMarca.getText();
        if(marca.isEmpty()){
          marca ="-32000";
        }    
      }catch (Exception e2) {
        principal.getStatus().setTexto("Digite um marca válida!");
        marca = "";
      }
      try{
        nome = textConsultar.getText();
        if(nome.isEmpty()){
          nome ="-32000";
        }    
      }catch (Exception e2) {
        principal.getStatus().setTexto("Digite um produto válido!");
        nome = "";
      }
      if(nome !="" && marca != ""){
        if(nome!="-32000" && marca!= "-32000"){//DIGITOU UM NOME E A MARCA
          p = principal.getLoja().Consultar(nome, marca);
          System.out.println("digitou o nome a marca");
        }else if(nome !="-32000" && marca == "-32000"){//DIGITOU SO O NOME
          p = principal.getLoja().Consultar(nome);
          System.out.println("digitou so nome");
        }else if(nome =="-32000" && marca!= "-32000"){//DIGITOU SO A MARCA
          p = principal.getLoja().ConsultarMarca(marca);
          System.out.println("digitou so a marca");
        }else{
          principal.getStatus().setTexto("Tente digitar algo!");
          p =new ArrayList<Produtos>();
        }
      }else{
        p =new ArrayList<Produtos>();
      }
      if(p.size()!=0){
        principal.getStatus().setTexto("Resultados encontrados!");
      }else{
        principal.getStatus().setTexto("Sem resultados encontrados!");
      }
      createTable(p);
      this.add(barraRolagem);
      //ScrollBar barraRolagem
      layout.putConstraint(SpringLayout.WEST,barraRolagem, 0, SpringLayout.WEST, labelConsultarMarca);
      layout.putConstraint(SpringLayout.NORTH,barraRolagem, 30, SpringLayout.NORTH, labelConsultarMarca);
      
      this.remove(btVoltar3);
      this.add(btVoltar3);
      
      //Label btVoltar3
      layout.putConstraint(SpringLayout.EAST, btVoltar3, 0, SpringLayout.EAST, barraRolagem);
      layout.putConstraint(SpringLayout.NORTH, btVoltar3, 10, SpringLayout.SOUTH, barraRolagem);
    }
    else if(e.getSource() == btVender){
      labelTitulo.setText("           Vender Produto");
      btVoltar.setVisible(true);
      btSell.setVisible(true);
      textVender.setVisible(true);
      textQuant.setVisible(true);
      labelVender.setVisible(true);
      labelQuant.setVisible(true);
    }
    else if(e.getSource() == btVoltar){
      labelFazer.setVisible(true);
      principal.getStatus().setTexto("Aplicativo do Funcionario!");
      btListar.setVisible(true);
      btConsultar.setVisible(true);
      btVender.setVisible(true);
      btSenha.setVisible(true);
      btSair.setVisible(true);
      btVoltar.setVisible(false);
      btAlterar.setVisible(false);
      btBuscar.setVisible(false);
      btSell.setVisible(false);
      
      textNewSenha.setVisible(false);
      textConsultar.setVisible(false);//(consultar)
      textVender.setVisible(false);
      textQuant.setVisible(false);  

      labelNewSenha.setVisible(false);
      labelConsultar.setVisible(false);//consultar
      labelVender.setVisible(false);
      labelQuant.setVisible(false);

    }
    else if(e.getSource() == btSenha){
      labelTitulo.setText("              Alterar Senha");
      btAlterar.setVisible(true);
      btVoltar.setVisible(true);
      textNewSenha.setVisible(true);
      labelNewSenha.setVisible(true);
    }
    else if(e.getSource() == btSell){
      String nome="",Tunidades="";
      int unidades= -32000;
      try{
        Tunidades = textQuant.getText();
        unidades = Integer.parseInt(Tunidades);
      }catch (Exception e21) {
        System.out.println(e21);
        principal.getStatus().setTexto("Digite uma quantidade válida!");
        unidades = -32000;
      }
      try{
        nome = textVender.getText();
        if(nome.isEmpty()){
          nome ="";
          principal.getStatus().setTexto("Digite um produto válido!");
        }    
      }catch (Exception e2) {
        principal.getStatus().setTexto("Digite um produto válido!");
        nome = "";
      }
      if(nome!="" && unidades!= -32000){
        vende(nome,unidades);
      }
    } 
  }
  public void vende(String nome,int und){
    int res =  principal.getLoja().vender(nome, und,10);
    if(res == 1){
      principal.getStatus().setTexto("Venda realizada com sucesso!");
    } else if(res == -1){
      principal.getStatus().setTexto("Venda não realizada");
    } else {
      principal.getStatus().setTexto("Estoque vazio!");
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
