package Apps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Pessoas.Funcionario;
import Pessoas.Gerente;


public class AppPrincipal extends JFrame implements ActionListener{
	private static JPanel painel; 
	private int logada;
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
	public static void setPrincipal(AppPrincipal principal) {
		AppPrincipal.principal = principal;
	}

	public StatusBar getStatus() {
		return status;
	}
	public void setStatus(StatusBar status) {
		AppPrincipal.status = status;
	}

	public int getLogada() {
		return logada;
	}
	public void setLogada(int logada) {
		this.logada = logada;
	}
	//MAIN AQUIIIIIIIIIIIIII
	public static void main(String[] args) {
		principal.setLoja((Loja)Arquivo.carregar("Loja.txt"));
		if(principal.getLoja()==null){
			Gerente gerente = new Gerente("Agripino",123456,654321);
			Funcionario funcio = new Funcionario("Agripino",123456,"Padeiro",1234);
			principal.setLoja(new Loja("Biribinha",gerente));
			principal.getLoja().Cadastrar(funcio);
		}else{
			JOptionPane.showMessageDialog(null, "Save carregado com Sucesso!");
		}
		principal.inicializarJanela(principal.loja);
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
		//salvar
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				
				if(Arquivo.salvar(principal.getLoja(),"Loja.txt")){
					System.out.println("Salvo com sucesso!");
				}else{
					System.out.println("Falha ao Salvar!");
				}
				if(Arquivo.relatorio(principal.getLoja())){
					System.out.println("Relatorio feito com sucesso!");
				}else{
					System.out.println("Falha ao salvar o relatorio!");
				}
			}
		}, "Shutdown-thread"));
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
}
