// Exemplo de heranca
// 21/02/2019
// Fabricio de Lima Ribeiro

package heranca;

public class teste {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		Professor professor = new Professor();
		
		aluno.setNome("Fabricio");//aluno da classe Aluno
								  //setNome da classe Pessoa
		
		professor.setNome("Janaina");//professor da classe Professor
									 //setNome da classe Pessoa
		
		System.out.println(aluno.getNome());
		System.out.println(professor.getNome());
	}

}
