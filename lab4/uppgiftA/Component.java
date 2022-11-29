package lab4.uppgiftA;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;

public abstract class Component implements Iterator<Component>, Iterable<Component> {

    protected ArrayList<Component> components = new ArrayList<Component>();
    private String name;
    private double weight;

    // varje "väska" har ett namn och en vikt
    public Component(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }


    // returnerar nodens namn
    @Override
    public String toString() {
        return this.name;
    }

    public String tree() {
        return tree(1);
    }

    protected String tree(int depth) {

        StringBuilder sb = new StringBuilder();
        String spacer = "    ".repeat(depth);

        // sparar namnen i en lista
        sb.append(this.name);
        sb.append("\n");

        // detta gör vi för varje "väsk"-objekt
        for (Component c : components) {

            sb.append(spacer);
            sb.append(c.tree(depth + 1));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public double getWeight() {

        double weight = this.weight;

        for (Component c : components) {
            weight += c.getWeight();
        }
        return weight;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Component next() {
        return null;
    }

    @Override
    public Iterator<Component> iterator() {
        return this;
    }
}
