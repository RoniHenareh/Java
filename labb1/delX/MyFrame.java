package labb1.delX;

import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.JFrame; 
import javax.swing.JPanel; 

public class MyFrame extends JFrame { 

    JFrame frame;

    MyFrame(int n, String text1, String text2) {

        // ramen
        setTitle("LabbX");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // lägger till canvas till ramen
        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setVisible(true);
        add(panel);

        // ny del
        for (int i = 0; i < n; i++) {

            MyButton knapp = new MyButton(text1, text2);

            knapp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { knapp.toggleState(text1, text2); }
            });

            panel.add(knapp);
            setVisible(true);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // antal knappar

        if (sc.hasNext()) {

            for (int i = 0; i < n; i++) {

                String text1 = sc.next(); // text 1
                //System.out.println(text1);
                String text2 = sc.next(); // text 2
                //System.out.println(text2);

                new MyFrame(n, text1, text2);
            }

        } else {

            for (int i = 0; i < n; i++) {

                String text1 = null; // blankt
                String text2 = null; 

                new MyFrame(n, text1, text2);

            }
        }

        sc.close();
    }
}
