package lab2.uppgift1;

import java.util.Random;

public class FemtonspeletModel implements Boardgame {
    private static final String BADMOVE = "Bad move";
    private static final String OK = "OK";

    private int[][] board = new int[4][4];
    private String message = OK;
    private Random random = new Random();

    FemtonspeletModel() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i+1)*(j+1) != 16) {
                    board[i][j] = i*4 + (j+1);
                }
            }
        }
        scramble(3);
        while (checkWin()) {
            scramble(3);
        }
    }

    private boolean checkWin() {
        boolean ret = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i+1)*(j+1) != 16) {
                    if (board[i][j] != i*4 + (j+1)) {
                        ret = false;
                        break;
                    }
                }
            }
        }
        if (ret) {
            message = "Solved!";
        }
        return ret;
    }

    private int[] findZero() {
        int freeRow = -1;
        int freeCol = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    freeRow = i;
                    freeCol = j;
                }
            }
        }
        int[] ret = new int[2];
        ret[0] = freeRow;
        ret[1] = freeCol;
        return ret;
    }

    private int[][] getLegalMoves() {
        int[] zeroPos = findZero();
        int freeRow = zeroPos[0];
        int freeCol = zeroPos[1];

        int numLegalMoves = 4;
        if ((freeRow == 0 && (freeCol == 0 || freeCol == 3)) || (freeRow == 3 && (freeCol == 0 || freeCol == 3))) {
            numLegalMoves = 2;
        } else if (freeRow == 0 || freeRow == 3 || freeCol == 0 || freeCol == 3) {
            numLegalMoves = 3;
        }
        int[][] legalMoves = new int[numLegalMoves][2];
        if (numLegalMoves == 2) {
            if (freeRow == 0) {
                if (freeCol == 0) {
                    legalMoves[0][0] = 0;
                    legalMoves[0][1] = 1;

                    legalMoves[1][0] = 1;
                    legalMoves[1][1] = 0;
                } else if (freeCol == 3) {
                    legalMoves[0][0] = 0;
                    legalMoves[0][1] = 2;

                    legalMoves[1][0] = 1;
                    legalMoves[1][1] = 3;
                }
            } else if (freeRow == 3) {
                if (freeCol == 0) {
                    legalMoves[0][0] = 0;
                    legalMoves[0][1] = 2;

                    legalMoves[1][0] = 1;
                    legalMoves[1][1] = 3;
                } else if (freeCol == 3) {
                    legalMoves[0][0] = 3;
                    legalMoves[0][1] = 2;

                    legalMoves[1][0] = 2;
                    legalMoves[1][1] = 3;
                }
            }
        } else if (numLegalMoves == 3) {
            if (freeRow == 0) {
                legalMoves[0][0] = 0;
                legalMoves[0][1] = freeCol + 1;

                legalMoves[1][0] = 0;
                legalMoves[1][1] = freeCol - 1;

                legalMoves[2][0] = 1;
                legalMoves[2][1] = freeCol;
            } else if (freeRow == 3) {
                legalMoves[0][0] = 3;
                legalMoves[0][1] = freeCol + 1;

                legalMoves[1][0] = 3;
                legalMoves[1][1] = freeCol - 1;

                legalMoves[2][0] = 2;
                legalMoves[2][1] = freeCol;
            } else if (freeCol == 0) {
                legalMoves[0][0] = freeRow + 1;
                legalMoves[0][1] = 0;

                legalMoves[1][0] = freeRow - 1;
                legalMoves[1][1] = 0;

                legalMoves[2][0] = freeRow;
                legalMoves[2][1] = 1;
            } else if (freeCol == 3) {
                legalMoves[0][0] = freeRow + 1;
                legalMoves[0][1] = 3;

                legalMoves[1][0] = freeRow - 1;
                legalMoves[1][1] = 3;

                legalMoves[2][0] = freeRow;
                legalMoves[2][1] = 2;
            }
        } else if (numLegalMoves == 4) {
            legalMoves[0][0] = freeRow - 1;
            legalMoves[0][1] = freeCol;

            legalMoves[1][0] = freeRow + 1;
            legalMoves[1][1] = freeCol;

            legalMoves[2][0] = freeRow;
            legalMoves[2][1] = freeCol + 1;

            legalMoves[3][0] = freeRow;
            legalMoves[3][1] = freeCol - 1;
        }

        return legalMoves;
    }

    public void scramble(int n) {
        for (int i = 0; i < n; i++) {
            int[][] moves = getLegalMoves();
            int index = this.random.nextInt(moves.length);
            move(moves[index][0], moves[index][1]);
        }
    }

    public boolean move(int x, int y) {
        int[][] legalMoves = getLegalMoves();
        boolean goodmove = false;
        for (int i = 0; i < legalMoves.length; i++) {
            if (legalMoves[i][0] == x && legalMoves[i][1] == y) {
                goodmove = true;
                break;
            }
        }
        if (!goodmove) {
            message = BADMOVE;
            return false;
        }
        int[] zeroPos = findZero();
        board[zeroPos[0]][zeroPos[1]] = board[x][y];
        board[x][y] = 0;
        message = OK;
        checkWin();
        return true;
    }

    public String getStatus(int x, int y) {
        if (board[x][y] == 0) {
            return " ";
        }
        return Integer.toString(board[x][y]);
    }

    public String getMessage() {
        return message;
    }
}