package lab4.uppgiftA;

import java.util.Iterator;

public class Composite extends Component {

    // nya funktioner

    private static final int breadthFirst = 0;
    private static final int depthFirst = 1;
    private int iteratorType = breadthFirst;

    public Composite(String name, double weight) {
        super(name, weight);
    }

    public void add(Leaf leaf) {
        this.components.add(leaf);
    }

    public void add(Composite composite) {
        this.components.add(composite);
    }

    public void remove(Leaf leaf) {
        this.components.remove(leaf);
    }

    public void remove(Composite composite) {
        this.components.remove(composite);
    }

    public Component getChild(int index) {
        return this.components.get(index);
    }

    public void toggleIteratorType() {
        if (iteratorType == breadthFirst) {
            iteratorType = depthFirst;
        } else if (iteratorType == depthFirst) {
            iteratorType = breadthFirst;
        }
    }

    public String getIteratorType() {
        String ret = null;
        if (iteratorType == breadthFirst) {
            ret = "Breadth first";
        } else if (iteratorType == depthFirst) {
            ret = "Depth first";
        }
        return ret;
    }

    @Override
    public Iterator<Component> iterator() {
        Iterator<Component> ret = null;
        if (iteratorType == breadthFirst) {
            ret = new BreadthFirstIterator(this);
        } else if (iteratorType == depthFirst) {
            ret = new DepthFirstIterator(this);
        }
        return ret;
    }
}
