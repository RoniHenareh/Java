package lab4.uppgift2;

public abstract class Human {

    String name;
    String prn;

    // varje människa har ett namn och ett personnummer
    Human(String name, String prn) {
        this.name = name;
        this.prn = prn;
    }

    public static Human create(String name, String prn) {

        // personnummret ger oss information om människans kön
        int value = Integer.parseInt(prn.substring(9, 10));

        if (value == 0) {
            return new NonBinary(name, prn);
        } else if (value % 2 == 0) {
            return new Woman(name, prn);
        } else {
            return new Man(name, prn);
        }
    }
}
