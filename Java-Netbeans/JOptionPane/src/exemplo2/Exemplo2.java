/*
20/02/19
Caixas de Diálogo Input Text

As caixas de diálogo de entrada de texto ou Input Text Dialog servem para fazer 
uma requisição de algum dado ao usuário de forma bem simples e direta.
O que é digitado pelo usuário é retornado pelo método em forma de string.
Existem mais de 10 métodos sobrecarregados para invocar uma caixa de diálogo 
Input Text, mas, a princípio, usaremos a mais simples. O método showInputText 
recebe um argumento que é a string contendo a informação desejada, o que na 
maioria das vezes é uma pergunta ou pedido.

O exemplo abaixo demonstra um programa pedindo para que digite seu nome.
 */
package exemplo2;

import javax.swing.JOptionPane;

/**
 *
 * @author fabricio
 */
public class Exemplo2 {
    
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        System.out.println("Seu nome é:" + nome);
    }    
}
