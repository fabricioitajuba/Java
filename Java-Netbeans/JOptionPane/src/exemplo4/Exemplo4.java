/*
20/02/19

Caixa de Diálogo de Mensagem

A caixa de diálogo de mensagem é uma caixa que serve apenas para emitir uma 
mensagem. Esta caixa também é muito configurável e versátil, pois serve para 
muitas situações distintas como uma mensagem de erro, um alerta, ou simplesmente 
uma informação.

O método showMessageDialog é responsável em trazer a caixa de mensagem, o qual 
pode ter muitos argumentos, porém, vamos nos ater ao mais simples.

Assim como o método showConfirmDialog, usaremos null como valor de nosso primeiro 
argumento, pois, por enquanto, não há dependência de outras janelas em nosso 
programa. O segundo argumento é a mensagem que desejamos emitir.

Para finalizar nosso exemplo, incluiremos as caixas de mensagem de acordo com as 
respostas.
 */
package exemplo4;

import javax.swing.JOptionPane;

/**
 *
 * @author fabricio
 */
public class Exemplo4 {

    public static void main(String[] args) {

        String nome;

        int resposta;

        nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        resposta = JOptionPane.showConfirmDialog(null, "O seu nome é " + nome + "?");

        if (resposta == JOptionPane.YES_OPTION) {
            // verifica se o usuário clicou no botão YES
            JOptionPane.showMessageDialog(null, "Seu nome é " + nome);

        } else {
            JOptionPane.showMessageDialog(null, "Seu nome não é " + nome);
        }
    }
}
