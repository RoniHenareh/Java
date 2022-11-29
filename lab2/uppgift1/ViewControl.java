package lab2.uppgift1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ViewControl extends JFrame implements ActionListener {
    
    private Boardgame model;
    private JButton[] buttons;
    private int dim;

    ViewControl(int dim, Boardgame model) {

        this.model = model;
        // Configure the frame
        this.setTitle("MVC");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        this.dim = dim;
        GridLayout grid = new GridLayout(dim,dim);
        buttons = new JButton[dim*dim];
        container.setBackground(Color.lightGray);
        container.setLayout(grid);
        this.add(container);

        // Add buttons representing squares on the playing field.
        int index = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                JButton btn = new JButton();
                btn.addActionListener(this);
                container.add(btn);
                btn.setFont(new Font("Arial", Font.BOLD, 40));
                buttons[index++] = btn;
            }
        }
        updateInterface();
        // Finally make frame visible
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        int index = 0;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] == btn) {
                index = i;
                break;
            }
        }
        int x = index % this.dim;
        int y = (int) (index / this.dim);
        this.model.move(y, x);
        updateInterface();
    }

    private void updateInterface() {
        updateFaces();
        updateTurnIndicator();
    }

    private void updateTurnIndicator() {
        String message = this.model.getMessage();
        this.setTitle(message);
    }

    private void updateFaces() {
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                //String txt = Integer.toString(board[i][j]);
                String txt = this.model.getStatus(i, j);
                buttons[j + this.dim * i].setText(txt);
            }
        }
    }
}