package labb1.delC;

import javax.swing.JFrame;
import javax.swing.JPanel; 

import java.awt.Color;

// se UML-diagram

public class MyFrame extends JFrame {

    JFrame frame;

    MyFrame() {

        setTitle("Roni Henareh"); // krav
        setSize(400, 400);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // krav
        
        // lägger till canvas till ramen
        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setVisible(true);
        
        add(panel);

        // utvidgning
        MyButton knapp1 = new MyButton();
        panel.add(knapp1);

        MyButton knapp2 = new MyButton();
        panel.add(knapp2);

        setVisible(true);
    }
     
    public static void main(String[] args) {

        new MyFrame();

    }
}

