package labb1.delX;

import java.awt.Color;
import javax.swing.JButton; 

public class MyButton extends JButton {

    JButton button;

    // för alla knappar
    String text1;
    Color background = Color.red;

    // konstruktor
    MyButton(String text1, String text2) {

        setText(text1);
        setVisible(true);
        setOpaque(true);
        setBackground(background);
        setBorderPainted(false);

    }

    Boolean pressed = false;
    public void toggleState(String text1, String text2) {

        if (pressed) {

            setText(text1);
            background = Color.red;
        } else {
            setText(text2);
            background = Color.blue;
        }
        setBackground(background);
        pressed = !pressed;

    }
}
