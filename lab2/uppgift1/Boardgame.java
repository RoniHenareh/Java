package lab2.uppgift1;

public interface Boardgame {

    // abstarkta metoder
    boolean move(int x, int y); // drag ok? True/False
    String getStatus(int x, int y); // uppdaterar positionen i klassen
    String getMessage(); // retunera string med information om drag
    
}
