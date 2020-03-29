/*
 * Encapsulamento getters and setters
 * 16/02/19
 * 
 * Encapsulamento � tornar os atributos e m�todos privado somente para a classe
 * e criar o acesso atrav�s dos m�todos getters and setters.
 * 
 * m�todo get - usado para obter o valor do atributo
 * m�todo set - usado para dar o valor ao atributo
 * 
 * Obtendo os m�todos getters and setters automaticamente no eclipse:
 * Menu: Source -> Generate getters and setters - public
 */

package encapsulamento;

public class TesteCarro {

	public static void main(String[] args) {

		Carro van = new Carro();
		
		van.setMarca("Fiat");
		System.out.println(van.getMarca());
		van.setModelo("Uno");
		System.out.println(van.getModelo());
	}

}
