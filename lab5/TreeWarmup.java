package lab5;

import javax.swing.*;
import javax.swing.tree.*;       

class TreeWarmup extends TreeFrame {

    private DefaultMutableTreeNode root;

    // Overrides method in TreeFrame
    void initTree() {

		root = new DefaultMutableTreeNode("Liv");

		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Växter");
		DefaultMutableTreeNode child11 = new DefaultMutableTreeNode("Ek");
		DefaultMutableTreeNode child12 = new DefaultMutableTreeNode("Solros");
		DefaultMutableTreeNode child13 = new DefaultMutableTreeNode("Kaktus");

		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Djur");
		DefaultMutableTreeNode child21 = new DefaultMutableTreeNode("Hund");
		DefaultMutableTreeNode child22 = new DefaultMutableTreeNode("Katt");

		DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Svampar");
		DefaultMutableTreeNode child31 = new DefaultMutableTreeNode("Flugsvamp");
		DefaultMutableTreeNode child32 = new DefaultMutableTreeNode("Röksvamp");

		root.add(child1);
		root.add(child2);
		root.add(child3);

		child1.add(child11);
		child1.add(child12);
		child1.add(child13);

		child2.add(child21);
		child2.add(child22);
        
		child3.add(child31);
		child3.add(child32);

		treeModel = new DefaultTreeModel( root );
		tree = new JTree( treeModel );
		//buildTree();
    }

    public static void main(String[] args) {
	    new TreeWarmup();
    }

}
