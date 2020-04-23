/*
 Gravando objetos dentro de arquivos
22/04/2020
 */
package principal;

import classes.Pessoa;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author fabricio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa();
        
        p1.setNome("Fabrício");
        p1.setEndereço("Moro lá");
        p1.setIdade(44);
        
        //Escrita no arquivo
        try{
            FileOutputStream arq = new FileOutputStream("arquivo/arquivo.txt");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            obj.writeObject(p1);
            obj.flush();
        }catch(Exception erro){
            System.out.println("Erro na gravação do arquivo!"+erro);
        }
        
        //Leitura do arquivo
        try{
            FileInputStream arq = new FileInputStream("arquivo/arquivo.txt");
            ObjectInputStream obj = new ObjectInputStream(arq);            
            Pessoa p2 = (Pessoa)obj.readObject();
            System.out.println(p2.getNome()+" "+ p2.getEndereço()+" "+ p2.getIdade());
        }catch(Exception erro){
            System.out.println("Erro na gravação do arquivo!"+erro);
        }        
        
    }
    
}
