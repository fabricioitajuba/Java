package heranca;

//Classe Professor herdando os atributos da classe Pessoa
public class Professor extends Pessoa {

	private double salario;
	private String nomeCurso;

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}	
	
	//metodos
	public double calcularSalarioLiquido(){
		return 0;
	}		
}
