package Apps;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Pessoas.Funcionario;
import Pessoas.Gerente;

public class AppPrincipal extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static JPanel painel;    
	private static AppPrincipal principal = new AppPrincipal();       
	private static StatusBar status = new StatusBar("Bem-vindo!Faça login pra começar!");
	private static String[] opMenu = {"Login","appGerente","appFuncionario","Sair"};
	private static String estado = "Login";
	private Loja loja;
	public static JPanel getPainel() {
		return painel;
	}
	public static void setPainel(JPanel painel) {
		AppPrincipal.painel = painel;
	}
	public static AppPrincipal getPrincipal() {
		return principal;
	}
	public static String[] getOpMenu() {
		return opMenu;
	}
	public static void setOpMenu(String[] opMenu) {
		AppPrincipal.opMenu = opMenu;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String state) {
		AppPrincipal.estado = state;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setPrincipal(AppPrincipal principal) {
		AppPrincipal.principal = principal;
	}

	public StatusBar getStatus() {
		return status;
	}
	public void setStatus(StatusBar status) {
		AppPrincipal.status = status;
	}

	public static void main(String[] args) {	
		int opc = -1;
		String nome = "Biribinha";
		Gerente gerente = new Gerente("Agripino",123456,654321);
		Funcionario funcio = new Funcionario("Agripino",123456,"Padeiro",1234);
		principal.loja = new Loja(nome,gerente);
		principal.loja.Cadastrar(funcio);
		principal.inicializarJanela(principal.loja);


		/*
		do{
			menuLogon();
			System.out.print("Escolha uma das opções: ");
			opc = Ler.inteiro();

			switch(opc){
			case 1:
				System.out.println("informe sua senha: "); int senha=Ler.inteiro();
				if(senha == gerente.getSenha()){
					appGerente.iniciarAppGerente(loja);
				}else{
					System.out.println("Senha incorreta!");
				}
			break;
			case 2:
				appFuncionario.iniciarAppFuncionario(loja);
			break;
			case 0:
				System.err.println("\n\tEXPEDIENTE ENCERRADO!");
			break;
			default :
				System.err.println("OPCAO INVALIDA!");
			break;

			}
		}while(opc!=0);
		 */
	}
	public void inicializarJanela(Loja loja){
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		principal.setTitle("Lojas "+loja.getNome()+".");
		principal.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );      
		principal.add(status, BorderLayout.SOUTH);

		setPainel(new TelaPrincipal(principal));

		principal.add(painel);
		principal.repaint();
		principal.setVisible(true);                
		principal.setSize(500,500);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Sair")){
			principal.setEstado("Login");
			if(painel != null) principal.remove(painel);
			status.setTexto("Bem-vindo!Faça login pra começar!");
			setPainel(new TelaPrincipal(principal));
			painel.setSize(500,500);

			principal.add(painel);
			principal.repaint();
			principal.setVisible(true);                		
		}
		else if(estado == "appGerente"){     
			if(painel != null)principal.remove(painel);
			painel = new AppGerente(principal);
			status.setTexto("Aplicativo do Gerente");
			
			principal.add(painel);
			principal.repaint();
			principal.setVisible(true);            
		}        
		else if(estado == "appFuncionario"){
			if(painel != null) principal.remove(painel);
			painel = new AppFuncionario(principal);
			status.setTexto("Aplicativo do Funcionario");

			principal.add(painel);
			principal.repaint();
			principal.setVisible(true);                   	        	
		}
		else if(estado == opMenu[3]){
			principal.dispose();
			System.exit(0);
		}
	}	
	public static  void menuLogon(){
		System.out.println("[1] - LOGAR COMO GERENTE");
		System.out.println("[2] - LOGAR COMO FUNCIONARIO");
		System.out.println("[0] - ENCERRAR EXPEDIENTE");
	}
}
