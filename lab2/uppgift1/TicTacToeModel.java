package lab2.uppgift1;

public class TicTacToeModel implements Boardgame {

    private static final String BADMOVE = "Can not move piece to square already occupied by another piece.";
    private static final String BADLIFT = "Can only move your own pieces.";
    private static final String OK = "OK";
    private static final String SELECT_PIECE = "select piece to move.";
    private static final String MOVE_PIECE = "select where to move piece.";

    private String message = OK; // Gives helpful error messages.
    private int[][] board = new int[3][3]; // 0 for empty, 1 for white, -1 for black.
    private int whitePieces = 0; // Number of pieces on the board.
    private int blackPieces = 0; // Number of pieces on the board.
    private boolean whiteTurn = true; // true = white's turn, false = black's turn.
    private boolean gameEnded = false; 
    private int toMoveX = -1;
    private int toMoveY = -1;

    TicTacToeModel() {}

    private void checkWin() {
        // Check if we have already ended the game.
        if (gameEnded) {return;}
        // Check if there are not enough pieces placed to win.
        if (whitePieces < 3 && blackPieces < 3) {return;}
        // Check for win in rows and columns.
        for (int i = 0; i < board.length; i++) {
            // White
            if ( ( board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1 ) || ( board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1 )) {
                gameEnded = true;
            } 
            // Black
            if ( ( board[i][0] == -1 && board[i][1] == -1 && board[i][2] == -1 ) || ( board[0][i] == -1 && board[1][i] == -1 && board[2][i] == -1 )) {
                gameEnded = true;
            } 
        }
        // Check diagonals
        // White
        if ( board[1][1] == 1 && ( (board[0][0] == 1 && board[2][2] == 1) || (board[0][2] == 1 && board[2][0] == 1) ) ) {
            gameEnded = true;
        }
        // Black
        if ( board[1][1] == -1 && ( (board[0][0] == -1 && board[2][2] == -1) || (board[0][2] == -1 && board[2][0] == -1) ) ) {
            gameEnded = true;
        }
    }

    public boolean move(int x, int y) {
        // Make sure that we don't already have a winner.
        if (gameEnded) {
            return false;
        }
        if ((whiteTurn && (whitePieces < 3)) || (!whiteTurn && (blackPieces < 3))) {
            boolean ret = move_lt3(x, y);
            if (blackPieces == 3) {
                String player = whiteTurn ? "O:s" : "X:s";
                message = player + " turn to " + SELECT_PIECE;
            }
            return ret;
        } else {
            return move_geq3(x, y);
        }
    }

    private boolean move_geq3(int x, int y) {
        if ((toMoveX == -1) && (toMoveY == -1)) {
            if ((whiteTurn && board[x][y] != 1) || (!whiteTurn && board[x][y] != -1)) {
                String player = whiteTurn ? "O:s" : "X:s";
                message = BADLIFT + " " + player + " turn to " + SELECT_PIECE;
                return false;
            }
            toMoveX = x;
            toMoveY = y;
            String player = whiteTurn ? "O:s" : "X:s";
            message = player + " turn to " + MOVE_PIECE;
            return true;
        } else {
            if (board[x][y] == 0) {
                int sgn = whiteTurn ? 1 : -1;
                board[toMoveX][toMoveY] = 0;
                board[x][y] = sgn;
                message = OK;
                checkWin();
                if (gameEnded) {
                    String player = whiteTurn ? "O" : "X";
                    message = player + " wins!";
                    return true;
                }
                else {
                    whiteTurn = !whiteTurn;
                }
                if (blackPieces == 3) {
                    String player = whiteTurn ? "O:s" : "X:s";
                    message = player + " turn to " + SELECT_PIECE;
                }
                toMoveX = -1;
                toMoveY = -1;
                return true;
            } else {
                message = BADMOVE;
                return false;
            }
        }
    }

    private boolean move_lt3(int x, int y) {
        // Make sure that the move is allowed; check that x,y is empty.
        if (board[x][y] != 0) {
            message = BADMOVE;
            return false;
        }
        // If we don't have tree peices on the board, place them out. Otherwise, move them.
        if (whiteTurn) {
            if (whitePieces < 3) {
                board[x][y] = 1;
            }
        } else {
            if (blackPieces < 3) {
                board[x][y] = -1;
            }
        }
        // Increase the count of the player moves
        if (whiteTurn) {
            whitePieces += 1;
        } else {
            blackPieces += 1;
        }

        message = OK;
        checkWin();
        if (gameEnded) {
            String player = whiteTurn ? "O" : "X";
            message = player + " wins!";
        }
        else {
            whiteTurn = !whiteTurn;
        }
        return true;
    }

    // avläser positionen
    public String getStatus(int x, int y) {
        if (this.board[x][y] == 1) {
            return "O";
        } else if (this.board[x][y] == -1) {
            return "X";
        } else {
            return " ";
        }
    }

    public String getMessage() {
        return this.message;
    }

    public boolean getTurn() {
        return this.whiteTurn;
    }

}