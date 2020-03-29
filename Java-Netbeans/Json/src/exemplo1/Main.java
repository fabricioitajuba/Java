/*
JSON - Javascript Object Notation
Exemplo de conversao de objeto para json e de json para objeto
Eng. Fabricio de Lima Ribeiro
28/02/2019
 */
package exemplo1;

import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {

        Aluno a = new Aluno();        
        a.setNome("Fabricio");
        a.setMatricula("9206");
        a.setIdade(42);
        a.setNascimento(Timestamp.valueOf("1976-03-07 00:00:00"));
        //Imprime o json criado do aluno a
        System.out.println(a.toJson().toString());
        
        //Cria o aluno b e passa o json do aluno a para o aluno b
        Aluno b = new Aluno(a.toJson());
        //Imprime os atributos do aluno b
        System.out.println("Nome=" + b.getNome());
        System.out.println("Matricula=" + b.getMatricula());
        System.out.println("Idade=" + b.getIdade());
        System.out.println("Nascimento=" + b.getNascimento());
        
    }
}
