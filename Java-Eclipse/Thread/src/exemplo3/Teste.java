/*
 * Estudo da thread
 * 13/02/19
 */

package exemplo3;

/**
 *
 * @author fabricio
 */
public class Teste {
    
    public static void main(String[] args) {
        
        MinhaThread thread = new MinhaThread("Thread #1", 250);
        //thread.start();//starta a thread nao muito correto
        MinhaThread thread2 = new MinhaThread("Thread #2", 1000);
        MinhaThread thread3 = new MinhaThread("Thread #3", 500);
    }    
}