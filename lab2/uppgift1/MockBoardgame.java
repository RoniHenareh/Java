package lab2.uppgift1;

public class MockBoardgame implements Boardgame {
    private int[][] board = new int[5][5];
    private boolean turn = true;
    private String message = "OK";

    MockBoardgame() { }

    public boolean move(int xin, int yin) {
        int x = yin;
        int top = board.length - 1;
        if (board[x][top] != 0) {
            message = "Bad move";
            return false;
        }
        int sgn = turn ? 1 : -1;
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == 0) {
                board[x][i] = sgn;
                break;
            }
        }
        turn = !turn;
        message = "OK";
        return true;
    }

    public String getStatus(int x, int y) {
        if (this.board[y][4-x] == 1) {
            return "O";
        } else if (this.board[y][4-x] == -1) {
            return "X";
        } else {
            return " ";
        }
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        MockBoardgame mb = new MockBoardgame();
        for (int i = 0; i < 3; i++) {
            mb.move(i, 0);
            mb.move(4-i, 0);
        }
        System.out.println(mb.getMessage());
        for (int i = 0; i < mb.board.length; i++) {
            for (int j = 0; j < mb.board[i].length; j++) {
                System.out.print(" " + mb.getStatus(i, j));
            }
            System.out.println();
        }
    }
}