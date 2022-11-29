package lab4.uppgift2;

public class Woman extends Human {

    Woman(String name, String prn) {
        super(name, prn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello! I am a woman with name ");
        sb.append(this.name);
        sb.append(".");
        return sb.toString();
    }
}
