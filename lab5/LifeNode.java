package lab5;

import javax.swing.tree.DefaultMutableTreeNode;

public class LifeNode extends DefaultMutableTreeNode {

    private String name;
    private String type;
    private String description;

    LifeNode(String name, String type, String description) {
        
        super(name);
        this.name = name;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDesc() {
        return type + ": " + name + " " + description + ".";
    }
}