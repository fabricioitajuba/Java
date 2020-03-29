/*
 * Exemplo de uso do JOptionPane "sim, não, cancelar"
 * Fabrício de Lima Ribeiro
 * 20/02/2019
 */
package exemplo1;

import javax.swing.JOptionPane;

public class Exemplo1 {
    
    public static void main(String[] args) {
        
        int opcao = JOptionPane.showConfirmDialog(null, "Escolha uma opção:", "Opção", JOptionPane.YES_NO_OPTION);
        
        if (opcao == 0)
            System.out.println("Voce escolheu a opção SIM.");
        else if (opcao == 1)
            System.out.println("Voce escolheu a opção NÃO.");
        else if (opcao == -1)
            System.out.println("Voce escolheu a opção CANCELAR.");        
    }
   
}
