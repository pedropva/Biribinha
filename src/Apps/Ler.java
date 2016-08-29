package Apps;



import java.util.Scanner;
//faz o teste se recebeu de fato um inteiro
public class Ler {
	private static Scanner input = new Scanner(System.in);
	
	public static int inteiro(){
		while(!input.hasNextInt()){
			System.err.printf("Digite um inteiro: ");
			input.next();
		}
		return input.nextInt();
	}
	public static String linha(){
		return input.nextLine();
	}
	public static float preco(){
		return input.nextFloat();
	}
}