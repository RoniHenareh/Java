package labb1.delC;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ear implements ActionListener {

    MyButton knapp;

    // konstruktor
    Ear(MyButton knapp) { 
        
        this.knapp = knapp; 
        knapp.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) { 
        knapp.toggleState(); 
    }
}

