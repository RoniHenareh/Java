package lab3;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Skapar en Client instans
        Client c = new Client("localhost", 4713);

        Scanner sc = new Scanner(System.in);
        System.out.print("Write .exit to exit. Enter your name: ");

        // trim tar bort mellanrum
        String input = sc.nextLine().trim();
        
        while (!input.equalsIgnoreCase(".exit") && c.isConnected()) {

            // First send name, then send STEN SAX or PASE
            c.sendReply(input);

            // Get what the server played
            String recv = c.getAnswer();
            System.out.println(recv);

            // Read next message to send to server
            input = sc.nextLine().trim(); 
        }
        // Close scanner and socket
        sc.close();
        if (c.isConnected()) {
            c.disconnect();
        }
    }
}
