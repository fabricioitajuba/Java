/*
 * Construtores
 * Toda classe do java j� possui um construtor vazio mas n�o mostra
 * ex: Carro();
 * Criando um construtor com v�rios par�metros:
 * Menu: Source -> Generate Constructor using Fields
 */
package construtores;

public class TesteCarro {

	public static void main(String[] args) {

		//Atribui��o dos atributos - 1 
		Carro van = new Carro();
		van.marca = "Fiat";
		van.modelo = "Ducato";
		//van.numPassageiros = 10;
		van.capCombustivel = 100;
		van.consumoCombustivel = 0.2;		
		System.out.println(van.numPassageiros);
		
		//Atribui��o dos atributos - 2 - mais utilizada
		Carro van2 = new Carro("Fiat", "Ducato", 10, 100, 0.2);
		System.out.println(van2.marca);
		System.out.println(van2.modelo);
		System.out.println(van2.numPassageiros);
		System.out.println(van2.capCombustivel);
		System.out.println(van2.consumoCombustivel);
		
		Carro2 carro2 = new Carro2("Chevrolet", "Corsa", 10, 100, 0.2);
		System.out.println(carro2.marca);
		System.out.println(carro2.modelo);
		System.out.println(carro2.numPassageiros);
		System.out.println(carro2.capCombustivel);
		System.out.println(carro2.consumoCombustivel);		
	}

}
