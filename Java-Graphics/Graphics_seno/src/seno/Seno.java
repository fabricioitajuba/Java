/*
 Este programa plota o gráfico da funcao seno
Autor: Eng. Fabricio de Lima Ribeiro
Data: 23/02/2019
 */
package seno;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Seno extends JFrame {

    public Seno() {
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//Executa maximizado
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {

        int x_min, x_max, y, y_min, y_max, x_offset, y_offset, A, n;
        double x1;
              
        x_min = 0;
        x_max = getWidth() - 10; //maximo de pixels em x
        y_min = 0;
        y_max = getHeight(); //maximo de pixels em y

        x_offset = x_max / 2;
        y_offset = y_max / 2;

        A = y_offset - 30; //amplitude        
        n = 2; //numero de periodos
        
        g.drawLine(x_min, y_offset, x_max, y_offset); //desenha eixo X
        g.drawLine(x_offset, y_min, x_offset, y_max); //desenha eixo Y
        
        g.setColor(Color.red);
        g.drawString("Funcao seno", 3*x_max/4, y_max/4);
        
        g.setColor(Color.blue);
        for (int x = x_min; x < x_max; x++) {          
            x1 = ((2 * Math.PI * x * n) / x_max) + Math.PI;
            y = (int) (y_offset + A * Math.sin(x1));
            g.drawOval(x, y, 0, 0); //0 0 - largura do pixel
        }
    }

    public static void main(String[] args) {
        new Seno();
    }
}
