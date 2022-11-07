package lab2.uppgift1;
import java.util.*;

class TicTacToe implements Boardgame {

    static TicTacToe ttt = new TicTacToe(false);
    static String[][] board;
    static String vinnare;
    static int count = 1;
	static String färg;
    static int drag = 6;

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe(true);
    }
    
    TicTacToe(boolean inTerminal) {

        // använderen får en färg men väljer position
        Scanner sc = new Scanner(System.in);
        String winner = null;

		board = new String[4][4];

        // skapar brädet
        //int värde = 1;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                board[i][j] = "_"; //String.valueOf((värde));
                //värde ++; // ändra till koordinater istället
            }
		}

        if (!inTerminal) {
            return;
        }

        System.out.println("Välkommen till Tre i rad!");
        printBoard();
        System.out.println("X börjar spela, ange rad och kolonn för att placera X: ");
		
		while (winner == null) {
            
            // kvar:
            // efter tre ska man flytta dem
            if (drag > 0) { 
            
                färg = whoIsNext(count);

                if (count > 1) {
                    System.out.println("Nu är det");
                    System.out.print(färg);
                    System.out.print(":s tur att spela");
                    System.out.println("");
                }

                int rad = sc.nextInt();
                int kol = sc.nextInt();

                if (ttt.move(rad, kol) == true) {
                    ttt.getStatus(rad, kol);
                } else {
                    System.out.println(ttt.getMessage());
                }

                //count ++;
                winner = checkWinner();
                //drag --;

            } else {

                while (winner == null) {

                System.out.println("Nu är alla pjäser utlagda, flytta dem istället genom att skriva:");
                System.out.println("radFrån, kolFrån till radTill, kolTill\n");

                färg = whoIsNext(count);
                System.out.print("Nu är det");
                System.out.print(färg);
                System.out.print(":s tur att spela");
                System.out.println("");

                int radFrån = sc.nextInt();
                int kolFrån = sc.nextInt();

                int radTill = sc.nextInt();
                int kolTill = sc.nextInt();

                if (ttt.move(radFrån, kolFrån) == true && board[radFrån][kolFrån] == färg) {
                    moveFärg(radFrån, kolFrån, radTill, kolTill);
                } else {
                    System.out.println(ttt.getMessage());
                    printBoard();
                }

                winner = checkWinner();
                }
                //break;
            }
		}

        sc.close();
    }

    public static void moveFärg(int x1, int y1, int x2, int y2) {

        
        if (board[x2][y2] == "_") {

            // gör platsen tillägnlig i brädet
            board[x1][y1] = "_";

            // lägg till ny
            ttt.getStatus(x2, y2);

        } else {
            System.out.println(ttt.getMessage());
            printBoard();
        }
        
    }

    // för ViewControl
    public boolean getTurn() {
        if (whoIsNext(count).equals("X")) {
            return true;
        } else {
            return false;
        }
    }

    // för ViewControl
    public String[][] getBoard() {
        return board.clone();
    }

    public boolean move(int x, int y) { // drag ok? True/False

        boolean drag = true;

         // felhantering
         try {
            
            if (!(x > 0 && x <= 3 || y > 0 && y <= 3)) {
				
                drag = false;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Felaktigt drag, försök igen: ");
        }
        
        return drag;
    }

    public String getStatus(int x, int y) { // uppdaterar positionen i klassen

        if (x == 1){

            switch (y) {

                case 1:
                    if (board[1][1] != "X" && board[1][1] != "O") {
                        board[1][1] = färg;
                        count ++;
                        drag --;
                    } else {
                        System.out.println(getMessage());
                    }
                    break;
                case 2:
                if (board[1][2] != "X" && board[1][2] != "O") {
                    board[1][2] = färg;
                    count ++;
                    drag --;
                } else {
                    System.out.println(getMessage());
                }
                    break;
                case 3:
                    if (board[1][3] != "X" && board[1][3] != "O") {
                        board[1][3] = färg;
                        count ++;
                        drag --;
                    } else {
                        System.out.println(getMessage());
                }
                break;
            }
        }

        if (x == 2){

            switch (y) {

                case 1:
                    if (board[2][1] != "X" && board[2][1] != "O") {
                    board[2][1] = färg;
                    count ++;
                    drag --;
                    } else {
                        System.out.println(getMessage());
                    }
                    break;
                case 2:
                    if (board[2][2] != "X" && board[2][2] != "O") {
                        board[2][2] = färg;
                        count ++;
                        drag --;
                    } else {
                        System.out.println(getMessage());
                    }
                    break;
                case 3:
                    if (board[2][3] != "X" && board[2][3] != "O") {
                        board[2][3] = färg;
                        count ++;
                        drag --;
                    } else {
                        System.out.println(getMessage());
                    }
                    break;
            }
        }

        if (x == 3){

            switch (y) {

                case 1:
                    if (board[3][1] != "X" && board[3][1] != "O") {
                        board[3][1] = färg;
                        count ++;
                        drag --;
                    } else {
                        System.out.println(getMessage());
                    }
                    break;
                case 2:
                    if (board[3][2] != "X" && board[3][2] != "O") {
                        board[3][2] = färg;
                        count ++;
                        drag --;
                    } else {
                        System.out.println(getMessage());
                    }
                    break;
                case 3:
                    if (board[3][3] != "X" && board[3][3] != "O") {
                        board[3][3] = färg;
                        count ++;
                        drag --;
                    } else {
                        System.out.println(getMessage());
                    }
                    break;
            }
        }
        printBoard();
        return "";
    }

    public String getMessage() {
        return "Felaktigt drag, försök igen!";
    }

    public static void printBoard() {
        
        System.out.println("|---|---|---|");

        System.out.println("| " + board[1][1] + " | " + board[1][2] + " | " + board[1][3]  + " |");

        System.out.println("|-----------|");

        System.out.println("| " + board[2][1]  + " | " + board[2][2] + " | " + board[2][3] + " |");

        System.out.println("|-----------|");

        System.out.println("| " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " |");

        System.out.println("|---|---|---|");

    }

    public static String checkWinner() {

        for (int a = 0; a < 8; a++) {
            String line = null;
 
            switch (a) {
            case 0:
                line = board[1][1] + board[1][2] + board[1][3]; // rad
                break;
            case 1:
                line = board[2][1] + board[2][2] + board[2][3]; // rad
                break;
            case 2:
                line = board[3][1] + board[3][2] + board[3][3]; // rad
                break;
            case 3:
                line = board[1][1] + board[2][1] + board[3][1]; // ner
                break;
            case 4:
                line = board[1][2] + board[2][2] + board[3][2]; // ner
                break;
            case 5:
                line = board[1][3] + board[2][3] + board[3][3]; // ner
                break;
            case 6:
                line = board[1][1] + board[2][2] + board[3][3]; // diagonalt
                break;
            case 7:
                line = board[1][3] + board[2][2] + board[3][1]; // diagonalt
                break;
            }

            //For X winner
            if (line.equals("XXX")) {
                vinnare = "X vann!";
                System.out.println(vinnare);
            }
             
            // For O winner
            else if (line.equals("OOO")) {
                vinnare = "O vann!";
                System.out.println(vinnare);
            }
        }
        return vinnare;
    }

    public static String whoIsNext(int count) {

		if (count % 2 == 0) {
			färg = "O";
		} else {
			färg = "X";
		}
		
		return färg;
	}
}
