/*
20/02/19

Caixas de Diálogo Confirm

Outra caixa de diálogo simples e objetiva do JOptionPane é a caixa de diálogo de 
confirmação ou Confirm Dialog.

A Confirm Dialog (caixa de confirmação) consiste de uma caixa contendo uma 
mensagem, um ícone e três botões: sim, não e cancelar.

Apesar deste ser o aspecto padrão, esta caixa, como qualquer outra de 
JOptionPane, pode ser facilmente configurada (assunto que será tratado com mais 
detalhes nas próximas páginas).

No método padrão chamado showConfirmDialog usamos dois argumentos:

O primeiro é a dependência ou frame pai, ou seja, de qual janela esta 
confirmação está sendo gerada. Como nossos exemplos iniciais não possuem nenhuma 
dependência, então, sempre usaremos null neste argumento.

O segundo argumento é a mensagem que desejamos mostrar ao usuário.

O método showConfirmDialog sempre retorna uma constante que é a resposta clicada 
pelo usuário, que são:

Valor	Nome da Constante	Equivale
0	YES_OPTION              ao clicar no botão Yes (sim)
1	NO_OPTION               ao clicar no botão No (não)
2	CANCEL_OPTION           ao clicar no botão Cancel (cancelar)
 */
package exemplo3;

import javax.swing.JOptionPane;

/**
 *
 * @author fabricio
 */
public class Exemplo3 {

    public static void main(String[] args) {

        String nome; 
        int opcao;
        
        nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        opcao = JOptionPane.showConfirmDialog(null, "O seu nome é " + nome + "?");
        System.out.println("Opção escolhida:" + opcao);
    }    
}
