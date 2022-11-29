package lab4.uppgiftA;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;

public class BreadthFirstIterator implements Iterator<Component>, Iterable<Component> {

    private int index = 0;
    private Composite composite;
    private ArrayList<Component> breadthFirst = new ArrayList<Component>();

    protected BreadthFirstIterator(Composite composite) {
        this.composite = composite;

        // Do breadth first search
        ArrayList<Component> queue = new ArrayList<Component>();
        
        queue.add(this.composite);
        while (queue.size() > 0) {
            Component first = queue.remove(0);
            for (Component c : first.components) {
                queue.add(c);
            }
            breadthFirst.add(first);
        }
    }

    @Override
    public boolean hasNext() {
        if (this.index < this.breadthFirst.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Component next() {
        if (this.hasNext()) {
            return this.breadthFirst.get(this.index++);
        }
        return null;
    }

    @Override
    public Iterator<Component> iterator() {
        return this;
    }
}
