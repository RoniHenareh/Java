package lab4.uppgift1;

import java.util.ArrayList;

public class Component {

    private ArrayList<Composite> composites = new ArrayList<Composite>();
    private ArrayList<Leaf> leaves = new ArrayList<Leaf>();

    private String name;
    private double weight;

    // varje "väska" har ett namn och en vikt
    public Component(String name, double weight) {

        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return toString(1);
    }

    // för snygga prints
    protected String toString(int depth) {
        StringBuilder sb = new StringBuilder();
        String spacer = "    ".repeat(depth);
        sb.append(this.name);
        sb.append("\n");
        for (Leaf l : leaves) {
            sb.append(spacer);
            sb.append(l.toString());
            sb.append("\n");
        }
        for (Composite c : composites) {
            sb.append(spacer);
            sb.append(c.toString(depth + 1));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public double getWeight() {

        double childWeight = 0;

        // för väskor
        for (Composite c : composites) {
            childWeight += c.getWeight();
        }
        // för prylar
        for (Leaf l : leaves) {
            childWeight += l.getWeight();
        }
        return childWeight + this.weight;
    }

    public void add(Leaf leaf) {
        this.leaves.add(leaf);
    }

    public void add(Composite composite) {
        this.composites.add(composite);
    }

    public void remove(Leaf leaf) {
        this.leaves.remove(leaf);
    }

    public void remove(Composite composite) {
        this.composites.remove(composite);
    }
}
