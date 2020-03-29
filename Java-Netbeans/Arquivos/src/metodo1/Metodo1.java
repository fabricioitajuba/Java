/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo1;

/**
 *
 * @author fabricio
 */
public class Metodo1 {
    
    public static void main(String[] args) {
        
        String arq = "teste.txt";        
        //Para salvar com quebra de linha:
        //- "\r\n" - windows
        //- "\n" - linux
        String texto = "Isso é um texto muito legal.\r\n" + "Eu quem criei.\r\n" + "Show de bola\r\n";
        
        //Escrever no arquivo:
        if(Arquivo.Write(arq, texto))
            System.out.println("Arquivo salvo com sucesso!");
        else
            System.out.println("Erro ao gravar o arquivo!");        
        
        //Ler arquivo
        String texto2 = Arquivo.Read(arq);
        if(texto2.isEmpty())
            System.out.println("Erro ao ler o arquivo!");
        else
            System.out.println(texto2);
    }
}
