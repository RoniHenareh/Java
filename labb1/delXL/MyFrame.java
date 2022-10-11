package labb1.delXL;

import java.awt.Color;
import javax.swing.JFrame; 
import javax.swing.JPanel; 

public class MyFrame extends JFrame { 
 
    JFrame frame;

    MyButton[] buttons;
    MyFrame me;

    MyFrame(int n, String[] states) {
        
        // ramen
        setTitle("LabbX");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // lägger till canvas till ramen
        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setVisible(true);
        add(panel);

        buttons = new MyButton[n];
        me = this;

        // ny del
        for (int i = 0; i < n; i++) {

            MyButton knapp = new MyButton(me, states[2*i], states[2*i+1]);
            
            panel.add(knapp);
            buttons[i] = knapp;
            setVisible(true);
        }
    }

    public void toggle(MyButton from) {
        for (MyButton button : buttons) {
            if (button != from) {
                button.toggleState();
            }
        }
    }
     
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]); // antal knappar
        String[] states = new String[2*n];
        for (int i = 0; i < n; i++) {

            String text1 = args[2*i+1];
            String text2 = args[2*i+2];
            states[2*i] = text1;
            states[2*i+1] = text2;
        }
        new MyFrame(n, states);
    }
}



