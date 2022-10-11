package labb1;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.JFrame; 
import javax.swing.JPanel; 

/* då paketet är labb1

rm *.class
javac *.java
cd ..
java labb1.MyFrame 

*/

/* Uppgift 1

Krav:
 
1. MyFrame ska ärva från biblioteksklassen JFrame.

2. De kod du väljer att placera i konstruktoren ska vara den kod som ska vara i konstruktoren.

3. Se till att du har den kod som gör att programmet avslutas när man sklickar på avstängningsknappen för fönstret.

4. Extra: Se till att författarnas namn står i ramen som fönstrets titel. Ge fönstret din favoritfärg som bakgrundsfärg.

*/

// inheriting JFrame
public class MyFrame extends JFrame { // krav

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

        // Add action listeners
        knapp1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { knapp1.toggleState(); }
        });

        knapp2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { knapp2.toggleState(); }
        });

        setVisible(true);
    }
     
    public static void main(String[] args) {

        new MyFrame();

    }
}



