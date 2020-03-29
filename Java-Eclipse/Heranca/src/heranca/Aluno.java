package heranca;

//Classe Aluno herdando os atributos da classe Pessoa
public class Aluno extends Pessoa {

	private String curso;
	private String notas;

	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	//metodos
	public double calcularMedia(){		
		return 0;
	}
	
	public boolean verificarAprovado(){
		return true;
	}
}
