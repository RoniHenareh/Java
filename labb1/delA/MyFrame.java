package labb1.delA;

import javax.swing.JFrame;
import javax.swing.JPanel; 

import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// se UML-diagram

public class MyFrame extends JFrame implements ActionListener {

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
        knapp1.addActionListener(this); // nytt
        panel.add(knapp1);
        
        MyButton knapp2 = new MyButton();
        knapp2.addActionListener(this); // nytt
        panel.add(knapp2);

        // Add action listeners
        /*knapp1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { knapp1.toggleState(); }
        });*/
     
       /*knapp2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { knapp2.toggleState(); }
        }); */

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        MyButton knapp = (MyButton)e.getSource();
        knapp.toggleState();
    }
     
    public static void main(String[] args) {

        new MyFrame();

    }
}

