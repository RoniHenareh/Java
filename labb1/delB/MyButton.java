package labb1.delB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.JButton;

// se UML-diagram

public class MyButton extends JButton implements ActionListener {

    JButton button;

    // för alla knappar
    String text = "tillstånd1";
    Color background = Color.red;

    // konstruktor
    MyButton() {

        setText(text);
        setVisible(true);
        setOpaque(true);
        setBackground(background);
        setBorderPainted(false);

        // Add action listener
        /*this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { toggleState(); }
            });*/

        // Add action listener
        this.addActionListener(this);
    }

    public static void main(String[] args) {

        new MyButton();
    }

    public void actionPerformed(ActionEvent e) {
        toggleState();
    }

    // metod för att byta mellan tillstånd
    // Funkar ej, ty saknar lyssnarobjekt som lyssnar på knappen
    Boolean pressed = false;
    public void toggleState() {

        if (pressed) {
            text = "tillstånd1";
            background = Color.red;

        } else {
            text = "tillstånd2";
            background = Color.blue;

        }
        pressed = !pressed;

        setBackground(background);
        setText(text);

    }
    
}


