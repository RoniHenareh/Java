package lab3;

/*******************************************
OBS! No swedish letters in this program.
STEN, SAX and PASE is played.
STEN = ROCK, SAX = SCISSORS, PASE = PAPER
*******************************************/

import java.net.*; // networking package
import java.io.*;
import java.util.*;

public class Server4713 {

    public static void main( String[] args) {

	try {
		// To connect to another machine we need a socket connection
		// this means that two machines have information about each other’s network location (IP Address)
	    ServerSocket sock = new ServerSocket(4713,100);

	    while (true) 
		new ClientHandler(sock.accept()).start();

	} catch(IOException e)
	    {System.err.println(e);
	}
    }
} 

class ClientHandler extends Thread {

    static int numberOfPls = 0;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket socket){

		try {
			// finns andra alt? DataInputStream/DataOutputStream
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
		}
		catch(IOException e) {System.err.println(e);
		}
    }
    
    public void run() {

		// serverns drag
		Random random = new Random();
		String[] hand = {"STEN","SAX","PASE"};

		try {
			String name = in.readLine();
			System.out.println((++numberOfPls) + ": " + name);
				out.println("Hello, " + name);
				out.flush();

			while(true) {
				
				String input = in.readLine();
				if(input == null || input.equals("")) break;
				out.println(hand[random.nextInt(3)]);
				out.flush();
			}
			System.out.println("Bye " + name); 
			out.flush();
			System.out.println(name + " stopped playing");
			numberOfPls --;
		}
			catch(Exception e) {
			System.err.println(e);
		}
    }
}