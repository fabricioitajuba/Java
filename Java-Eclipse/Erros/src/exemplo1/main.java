/*
 * Tratamento simples de erros usando Try Catch
 * Eng. Fabricio de Lima Ribeiro
 * 26/02/2019
 */
package exemplo1;

public class main {

	public static void main(String[] args) {
		
		//int vetor[];
		//vetor = new int[10];
		//ou
		int vetor[] = new int[10]; //vetor com 10 posicoes (0-9)
		
		//vamos tentar escrever na posicao 10, certamente tera um erro
		try{
			vetor[10] = 1;
			System.out.println("deu certo!");//Será executado se der certo
		}
		catch (Exception e ){
			System.out.println("deu errado: " + e);
		}

	}

}
