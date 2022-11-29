package lab2.uppgift1;

public interface Boardgame {
    boolean move(int x, int y);
    String getStatus(int x, int y);
    String getMessage();
}
