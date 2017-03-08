package Apps;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import Pessoas.Funcionario;
import Pessoas.Gerente;


public class TelaPrincipal extends JPanel implements ActionListener{
  private AppPrincipal principal;
  private SpringLayout layout;

  private JLabel labelTitulo;
  private JLabel labelLogar;
  private JLabel labelRegistro;
  private JLabel labelSenha;
  private JLabel labelFuncionario;
  private JLabel labelGerente;

  private JTextField textRegistro;
  private JPasswordField textSenha;

  private static JButton btGerente;
  private static JButton btFuncionario;
  private static JButton btLoga;
  private static JButton btVolta;

  public TelaPrincipal(AppPrincipal principal){
    labelTitulo = new JLabel("TELA DE LOGIN:");
    labelLogar = new JLabel("Como deseja logar?");
    labelRegistro = new JLabel("Registro:");
    labelSenha = new JLabel("Senha:");
    labelFuncionario = new JLabel("Logando como Funcionário");
    labelGerente = new JLabel("Logando como Gerente");
    textRegistro = new JTextField(20);
    textSenha = new JPasswordField(20);
    btGerente = new JButton("Gerente");
    btFuncionario = new JButton("Funcionário");
    btLoga = new JButton("Logar");
    btVolta = new JButton("Voltar");
    this.principal = principal;
    this.setSize(500, 500);
    this.inicializarComponentes();
    this.setLayout(layout);
  }
  public void inicializarComponentes(){

    layout=new SpringLayout();

    textRegistro.setVisible(false);
    textSenha.setVisible(false);
    labelRegistro.setVisible(false);
    labelSenha.setVisible(false);
    labelFuncionario.setVisible(false);
    labelGerente.setVisible(false);
    btLoga.setVisible(false);//botao pra logar
    btVolta.setVisible(false);
    btGerente.setVisible(true);
    btFuncionario.setVisible(true);

    btLoga.addActionListener(this);
    btGerente.addActionListener(this);
    btFuncionario.addActionListener(this);
    btVolta.addActionListener(this);

    labelTitulo.setFont(new Font("Arial", 0, 18));

    this.add(labelGerente);
    this.add(labelFuncionario);
    this.add(labelRegistro);
    this.add(labelSenha);
    this.add(labelTitulo);
    this.add(labelLogar);

    this.add(textRegistro);
    this.add(textSenha);

    this.add(btVolta);
    this.add(btLoga);
    this.add(btGerente);
    this.add(btFuncionario);

    //Titulo
    layout.putConstraint(SpringLayout.WEST, labelTitulo, 175, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, labelTitulo, 10, SpringLayout.NORTH, this);

    //Mensagem de login
    layout.putConstraint(SpringLayout.WEST, labelLogar, 10, SpringLayout.WEST, labelTitulo);
    layout.putConstraint(SpringLayout.NORTH, labelLogar, 100, SpringLayout.NORTH, labelTitulo);

    //Botao gerente
    layout.putConstraint(SpringLayout.EAST, btGerente, 0, SpringLayout.WEST, labelLogar);
    layout.putConstraint(SpringLayout.NORTH, btGerente, 50, SpringLayout.SOUTH, labelLogar);

    //Botao Funcionario
    layout.putConstraint(SpringLayout.WEST, btFuncionario, 0, SpringLayout.EAST, labelLogar);
    layout.putConstraint(SpringLayout.NORTH, btFuncionario, 50, SpringLayout.SOUTH, labelLogar);

    //Botao Logar
    layout.putConstraint(SpringLayout.WEST, btLoga, -10, SpringLayout.WEST, labelGerente);
    layout.putConstraint(SpringLayout.NORTH, btLoga, 50, SpringLayout.SOUTH, labelSenha);

    //Botao Voltar
    layout.putConstraint(SpringLayout.WEST, btVolta, 10, SpringLayout.EAST, btLoga);
    layout.putConstraint(SpringLayout.NORTH, btVolta, 50, SpringLayout.SOUTH, labelSenha);

    //Label Registro
    layout.putConstraint(SpringLayout.WEST, labelRegistro, -100, SpringLayout.WEST, labelGerente);
    layout.putConstraint(SpringLayout.NORTH, labelRegistro, 50, SpringLayout.SOUTH, labelGerente);

    //Label Senha
    layout.putConstraint(SpringLayout.WEST, labelSenha, 10, SpringLayout.WEST, labelRegistro);
    layout.putConstraint(SpringLayout.NORTH, labelSenha, 50, SpringLayout.SOUTH, labelRegistro);

    //Label Gerente
    layout.putConstraint(SpringLayout.WEST, labelGerente, 0, SpringLayout.WEST, labelLogar);
    layout.putConstraint(SpringLayout.NORTH, labelGerente, 0, SpringLayout.NORTH, labelLogar);

    //Label Funcionario
    layout.putConstraint(SpringLayout.WEST, labelFuncionario, -25, SpringLayout.WEST, labelLogar);
    layout.putConstraint(SpringLayout.NORTH, labelFuncionario, 0, SpringLayout.NORTH, labelLogar);

    //TextField Registro
    layout.putConstraint(SpringLayout.WEST, textRegistro, 5, SpringLayout.EAST, labelRegistro);
    layout.putConstraint(SpringLayout.NORTH, textRegistro, 0, SpringLayout.NORTH, labelRegistro);

    //TextField Senha
    layout.putConstraint(SpringLayout.WEST, textSenha, 5, SpringLayout.EAST, labelSenha);
    layout.putConstraint(SpringLayout.NORTH, textSenha, 0, SpringLayout.NORTH, labelSenha);

  }
  @Override
  public void actionPerformed( ActionEvent e ){

    labelLogar.setVisible(false);
    btGerente.setVisible(false);
    btFuncionario.setVisible(false);

    textRegistro.setVisible(true);
    textSenha.setVisible(true);
    labelRegistro.setVisible(true);
    labelSenha.setVisible(true);
    btLoga.setVisible(true);//botao pra logar
    btVolta.setVisible(true);

    if(e.getSource() == btGerente){
      labelGerente.setVisible(true);
    }
    else if(e.getSource() == btFuncionario){
      labelFuncionario.setVisible(true);
    }
    else if(e.getSource() == btVolta){
      labelGerente.setVisible(false);
      labelFuncionario.setVisible(false);
      labelLogar.setVisible(true);
      btGerente.setVisible(true);
      btFuncionario.setVisible(true);

      textRegistro.setVisible(false);
      textSenha.setVisible(false);
      labelRegistro.setVisible(false);
      labelSenha.setVisible(false);
      btLoga.setVisible(false);//botao pra logar
      btVolta.setVisible(false);
      principal.setEstado("Login");
    }
    else if(e.getSource() == btLoga){
      String reg=null;
      String novaSenha="";
      int senha = -32000;
      int registro=-32000;
      char[] pass;
      try {
        pass = textSenha.getPassword();
        for (int i = 0; i < pass.length; i++) {
          novaSenha += pass[i];
        }
        senha = Integer.parseInt(novaSenha);
      } catch (Exception e2) {
        System.err.println(e2);
        principal.getStatus().setTexto("Digite uma Senha válida!");
        senha = -32000;
      }
      try{
        reg = textRegistro.getText();
        registro = Integer.parseInt(reg);    
      }catch (Exception e2) {
        principal.getStatus().setTexto("Digite um Registro válido!");
        registro = -32000;
      }
      
      if(registro != 0 && senha != 0){
        if(labelFuncionario.isVisible()){
          loginFuncionario(registro,senha,e);
        }else{
          loginGerente(registro,senha,e);
        }
      }
    }
    principal.repaint();
  }
  public void loginGerente(int registro,int senha,ActionEvent e){
    if(principal.getLoja().getGerentes().isEmpty()!=true){
      Gerente aux;
      aux = principal.getLoja().getGerentes().get(registro);
      if(aux !=null){
        if(senha == aux.getSenha()){
          //btGerente.setVisible(true);   se algum botao começar a sumir ative essse comentario
          //btFuncionario.setVisible(true);
          principal.setEstado("appGerente");
          principal.setLogada(registro);
          principal.actionPerformed(e);
        }else{
          principal.getStatus().setTexto("Senha Incorreta!");
        }
      }else{
        principal.getStatus().setTexto("Gerente não encontrado!");
      }
    }else{
      principal.getStatus().setTexto("Sem Gerentes cadastrados!");
    }
  }
  public void loginFuncionario(int registro,int senha,ActionEvent e){
    if(principal.getLoja().getFuncionario().isEmpty()!=true){
      Funcionario aux;
      aux = principal.getLoja().getFuncionario().get(registro);
      if(aux !=null){
        if(senha == aux.getSenha()){
          
          principal.setEstado("appFuncionario");
          principal.setLogada(registro);
          principal.actionPerformed(e);
        }else{
          principal.getStatus().setTexto("Senha Incorreta!");
        }
      }else{
        principal.getStatus().setTexto("Funcionário não encontrado!");
      }
    }else{
      principal.getStatus().setTexto("Sem Funcionários cadastrados!");
    }
  }
}
