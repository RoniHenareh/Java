package lab4.uppgift2;

public class Factory {

    public static void main(String[] args) {

        // create istället för new
        /*  Vanliga skäl för den här tekniken är 
        att användaren ska slippa bry sig om objektets typ 
        eller att det säkrare blir rätt typ om metoden väljer och inte användaren 
        eller att klassen själv skall ha full kontroll över vilka objekt som skapas. */
        Human billie = Human.create("Billie", "xxxxxx-560x");
        Human anna = Human.create("Anna", "xxxxxx-642x");
        Human magnus = Human.create("Magnus","xxxxxx-011x");

        System.out.println(billie);
        System.out.println(anna);
        System.out.println(magnus);
    }
}
