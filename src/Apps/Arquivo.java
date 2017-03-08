package Apps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Arquivo{
	public static boolean salvar(Serializable s,String caminho){
		FileOutputStream f;
		ObjectOutputStream o;
		try {
			f = new FileOutputStream(caminho);
			o = new ObjectOutputStream(f);
			o.writeObject(s);
			o.close();
			return true;
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} 
		return false;
	}

	public static Loja carregar(String caminho){
		FileInputStream f;
		ObjectInputStream o;
		Loja obojoto;
		try {
			f = new FileInputStream(caminho);
			o = new ObjectInputStream(f);
			obojoto = (Loja)o.readObject();
			o.close();
			return obojoto;

		} catch (FileNotFoundException e) {
			System.err.println(e); 
		} catch (IOException e) {
			System.err.println(e); 
		} catch (ClassNotFoundException e) {
			System.err.println(e); 
		}
		return null;
	}
	public static boolean relatorio(Loja l){
		int m = LocalDateTime.now().getMonthValue();
		int d = LocalDateTime.now().getDayOfMonth();
		int an = LocalDateTime.now().getYear();
		PrintWriter writer = null;	
		String caminho = d+"_"+m+"_"+an+".txt";
		try{
			writer = new PrintWriter(caminho);
			writer.println("Renda:"+l.getRenda());
			writer.println("=============================================================");
			writer.println("Estoque:");
			for(int i=0; i< l.getListaprodutos().size();){
				writer.println("Produto: "+l.getListaprodutos().get(i).getNome());
				writer.println("Marca: "+l.getListaprodutos().get(i).getMarca());
				writer.println("Unidades: "+l.getListaprodutos().get(i).getUnidades());
				writer.println("=============================================================");
				writer.close();
				return true;
			}
			writer.close();
			return true;
		}
		catch ( IOException e){
			System.out.println(e);
		}
		return false;
	}
}