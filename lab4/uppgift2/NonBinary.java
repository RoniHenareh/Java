package lab4.uppgift2;

public class NonBinary extends Human {

    NonBinary(String name, String prn) {
        super(name, prn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello! I am non-binary with name ");
        sb.append(this.name);
        sb.append(".");
        return sb.toString();
    }
}