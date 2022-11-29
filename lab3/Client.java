package lab3;

import java.net.*; // networking package
import java.io.*;

public class Client {

    // för alla Client-objekt
    private int port;
    private String addr;
    private Socket sock;

    // finns andra alt? DataInputStream/DataOutputStream
    private BufferedReader in;
    private PrintWriter out;

    // konstruktor
    Client(String addr, int port) {

        // unika
        this.addr = addr;
        this.port = port;

        // försöker koppla till serven
        boolean success = connectToServer();
        while (!success) {
            try {
                System.out.println("Did not connect successfully. Trying again...");
                Thread.sleep(1000);
                success = connectToServer();
            } catch (InterruptedException e) {
                ;
            }
        }
    }

    // metod för att testa om kopplad
    public boolean isConnected() {
        if (this.sock == null) {
            return false;
        }
        return this.sock.isConnected();
    }

    // metod som försöker koppla till serven
    private boolean connectToServer() {

        // To connect to another machine we need a socket connection
		// this means that two machines have information about each other’s network location (IP Address)
        try {
            this.sock = new Socket(this.addr, this.port);
        } catch(IOException e) {
            return false;
        }
        // Try to set up in and out
        try {
            this.in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
            this.out= new PrintWriter(this.sock.getOutputStream());
        }
        catch(IOException e) {
            return false;
        }
        return this.sock.isConnected();
    }

    // metod för att koppla ifrån
    public boolean disconnect() {
        if (this.sock == null) {
            return true;
        }
        try {
            this.sock.close();
            this.in.close();
            this.out.close();
            this.sock = null;
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    // Get what the server played
    public String getAnswer() {
        if (!this.isConnected()) {
            return "";
        }
        try {
            String answer = this.in.readLine();
            if (answer.contains("Bye")) {
                this.disconnect();
            }
            return answer;
        } catch(Exception e) {
            return "ERROR";
        }
    }

    // send to server
    public boolean sendReply(String reply) {
        if (!this.isConnected()) {
            return false;
        }
        try {
            this.out.println(reply);
            this.out.flush();
        } catch(Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
}
