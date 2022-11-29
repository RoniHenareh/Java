package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RPSSkel extends JFrame implements ActionListener {

    Gameboard myboard, computersboard;
    int counter = 0; // To count ONE ... TWO  and on THREE you play
	Client client;
    JButton closebutton;

    RPSSkel () {

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create client instance
		client = new Client("localhost", 4713);

		// Send "name" to server.
		client.sendReply("myID");

		// Get Hello
		client.getAnswer();

		closebutton = new JButton("Close");

		// Add actionListener to close button.
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// vad ska knappen göra?
				client.disconnect(); // detta
				System.exit(0);
			}
		});

		myboard = new Gameboard("Your board", this);
		computersboard = new Gameboard("Computer");

		JPanel boards = new JPanel();
		boards.setLayout(new GridLayout(1,2));
		boards.add(myboard);
		boards.add(computersboard);

		add(boards, BorderLayout.CENTER);
		add(closebutton, BorderLayout.SOUTH);

		setSize(350, 650);
		setVisible(true);
    }

    public static void main (String[] u) {
		new RPSSkel(); 
    }

	public void actionPerformed(ActionEvent e) {

		if (!(e.getSource() instanceof JButton)) {
			return;
		}

		JButton btn = (JButton)e.getSource();
		String playerChoice = btn.getActionCommand();

		if (++counter < 3) {
			myboard.setLower(Integer.toString(counter));
		} else {
			// Reset counter
			counter = 0;
			// Send choice to server and get server's choice
			client.sendReply(playerChoice);
			String serverChoice = client.getAnswer();
			// Display the choice
			myboard.setUpper(playerChoice);
			computersboard.setUpper(serverChoice);
			// Update score and button highlight
			updateScore(playerChoice, serverChoice);
			updateButtons(playerChoice, serverChoice);
		}
	}

	private void updateScore(String playerChoice, String serverChoice) {
		int res = determineResult(playerChoice, serverChoice);
		handleRes(res);
	}

	private void updateButtons(String playerChoice, String serverChoice) {
		// Clear previous choice
		myboard.resetColor();
		computersboard.resetColor();
		// Indicate which button has been played
		myboard.markPlayed(playerChoice);
		computersboard.markPlayed(serverChoice);
		// Mark which choices were maid
		myboard.markPlayed(playerChoice);
		computersboard.markPlayed(serverChoice);
	}

	private void handleRes(int res) {
		if (res == 0) {
			myboard.setLower("Draw");
			computersboard.setLower("Draw");
		} else if (res == -1) {
			myboard.setLower("Lose");
			computersboard.setLower("Win");
			computersboard.wins();
		} else if (res == 1) {
			myboard.setLower("Win");
			computersboard.setLower("Lose");
			myboard.wins();
		}
	}

	private int determineResult(String playerChoice, String serverChoice) {
		// Equal
		if (playerChoice.equals(serverChoice))
			return 0;
		// Player wins
		if ((playerChoice.equals("STEN") && serverChoice.equals("SAX")) || (playerChoice.equals("SAX") && serverChoice.equals("PASE")) || (playerChoice.equals("PASE") && serverChoice.equals("STEN")))
			return 1; 
		// Server wins
		return -1;
	}
}
