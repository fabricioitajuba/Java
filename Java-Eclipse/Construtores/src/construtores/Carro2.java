package construtores;

public class Carro2 {

	//definir os atributos
	String marca;
	String modelo;
	int numPassageiros;
	double capCombustivel;
	double consumoCombustivel;

	//Menu: Source -> Generate Constructor using Fields...
	public Carro2(String marca, String modelo, int numPassageiros,
			double capCombustivel, double consumoCombustivel) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.numPassageiros = numPassageiros;
		this.capCombustivel = capCombustivel;
		this.consumoCombustivel = consumoCombustivel;
	}

	//uma boa pr�tica
	//Menu: Source -> Generate Constructors from Superclass...
	public Carro2() {

	}
}
