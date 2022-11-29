package lab4.uppgift1;

public class Leaf {
    
    String name;
    double weight;

    public Leaf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }
}