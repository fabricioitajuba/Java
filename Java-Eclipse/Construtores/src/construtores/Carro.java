package construtores;

public class Carro {
	
	//atributos
	String marca;
	String modelo;
	int numPassageiros;
	double capCombustivel;
	double consumoCombustivel;

	//Construtor, se for vazio n�o precisa declarar
	//Construtor 1
	Carro(){
		System.out.println("A classe Carro foi instaciada.");
		numPassageiros = 4;
	}
	
	//Construtor 2
	Carro(String marca, String modelo, int numPassageiros, double capCombustivel, double consumoCombustivel){
		this.marca = marca;
		this.modelo = modelo;
		this.numPassageiros = numPassageiros;
		this.capCombustivel = capCombustivel;
		this.consumoCombustivel = consumoCombustivel;
	}	
	
	//m�todos	
	void exibirAutonomia(){
		System.out.println("A autonomia do carro 'e: " + capCombustivel * consumoCombustivel);
	}
	
	double obterAutonomia(){
		System.out.println("Metodo obterAutonomia foi chamado."); 
		return capCombustivel * consumoCombustivel;
	}

	double calcularCombustivel(double km){
		double qtdCombustivel = km/consumoCombustivel;
		return qtdCombustivel;
	}	
}
