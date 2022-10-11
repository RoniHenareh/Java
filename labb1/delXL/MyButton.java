package labb1.delXL;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.JButton; 

public class MyButton extends JButton {

    JButton button;

    // för alla knappar 
    String text1;
    String text2;
    Color background = Color.red;

    MyFrame parent;
    MyButton me;
    
    // konstruktor
    MyButton(MyFrame parent, String text1, String text2) {
        this.text1 = text1;

        this.text2 = text2;
        this.parent = parent;
        this.me = this;
        
        setText(text1);
        setVisible(true);
        setOpaque(true);
        setBackground(background);
        setBorderPainted(false);

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { parent.toggle(me); }
        });

    }
    
    Boolean pressed = false;
    public void toggleState() {

        if (pressed) {

            setText(this.text1);
            background = Color.red;
        } else {
            setText(this.text2);
            background = Color.blue;
        }
        setBackground(background);
        pressed = !pressed;

    }
}
