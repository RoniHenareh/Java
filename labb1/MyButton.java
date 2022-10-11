package labb1;

import java.awt.Color;
import javax.swing.JButton; 

// rm *.class

/* Uppgift 2 

krav:

1. Skapa en klass MyButton som ärver från JButton. 

2. Knappen ska ha två olika tillstånd: 

Låt tillstånden representeras av knappens bakgrundsfärg och text på knappen. 
Det behövs alltså två olika bakgrundsfärger och två texter för varje objekt av MyButton.

3. Definiera en metod toggleState() i MyButton. 

Toggle brukar betyda att man växlar mellan två tillstånd. 
Metoden ska ändra knappens tillstånd, alltså byta både färg och text till den andra.

*/

public class MyButton extends JButton {

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

    }

    public static void main(String[] args) {

        new MyButton();
        
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
