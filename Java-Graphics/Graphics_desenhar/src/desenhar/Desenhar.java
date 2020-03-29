/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenhar;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Desenhar extends JFrame {

    public Desenhar() {
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawLine(100, 100, 500, 500);
        g.drawRect(400, 100, 300, 300);
        g.drawOval(420, 120, 260, 260);
        g.fillRect(600, 350, 300, 300);
        g.setColor(Color.green);
        g.fillOval(620, 370, 260, 260);
    }

    public static void main(String[] args) {
        new Desenhar();
    }

}
