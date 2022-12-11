package lab5;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.Scanner; 
import java.awt.Color; 

public class LifeTree extends TreeFrame {

    private static Scanner sc;
    private String line;

    private static String fileName = "/Users/ronihenareh/Desktop/DD1385/lab5/Liv.xml";

    void initTree() {

        root = findChildren(null);

	    treeModel = new DefaultTreeModel(root);
	    tree = new JTree( treeModel );

        tree.setBackground(Color.GREEN);
    }

    void showDetails(TreePath p) {

        if (p == null) {
            return;
        }
        LifeNode node = (LifeNode)p.getLastPathComponent();
        JOptionPane.showMessageDialog( this, node.getDesc() + '\n' + getTrace(node) );
    }

    private String getNextLine() {
        String s = sc.nextLine();
        if (s.contains("<?xml")) {
            s = sc.nextLine();
        }
        line = s.strip();
        return line;
    }

    private String getLine() {
        if (line == null) {
            return getNextLine();
        }
        return line;
    }

    private DefaultMutableTreeNode parseString(String s) {
        String name = Parser.getName(s);
        String type = Parser.getType(s);
        String desc = Parser.getDesc(s);
        return new LifeNode(name, type, desc);
    }

    private DefaultMutableTreeNode findChildren(DefaultMutableTreeNode parent) {

        String line = getLine();
        String type = Parser.getType(line);
        String endTag = "</" + type + ">";

        // Create child
        DefaultMutableTreeNode child = parseString(line);
        if (parent != null) {
            parent.add(child);
        }

        // all felhantering
        // Recursivly add children.
        while (!getNextLine().contains(endTag) && sc.hasNextLine()) {
            if (getLine().startsWith("</")) {
                System.out.printf("Felaktig slut-tag för %s, exiting.\n", line);
                System.exit(ABORT);
            }
            findChildren(child);
        }
        return child;
    }

    private String getTrace(LifeNode node) {
        StringBuilder sb = new StringBuilder("Men allt som");
        while (node != null) {
            sb.append(" är " + node.toString());
            TreeNode parent = node.getParent();
            if (parent instanceof LifeNode) {
                node = (LifeNode)parent;
            } else {
                node = null;
            }
        }
        return sb.append(".").toString();
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            fileName = args[0];
        }
        try {
            sc = new Scanner(new File(fileName));
        } catch (Exception FileNotFoundException) {
            System.out.printf("'%s' hittades inte. Avslutar programkörningen.\n", fileName);
            System.exit(ABORT);
        }
        new LifeTree();
        sc.close();
    }
}
