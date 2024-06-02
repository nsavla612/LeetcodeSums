import java.util.ArrayList;
import java.util.*;

class Node {
    int data;
    List<Node> children;

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class Tree {

    private Node root;
    static List<Integer> managersHavingLessSalaryThanSubordinates = new ArrayList<>();
    static List<Integer> managersHavingLessThanAverageSalaryOfSubordinates = new ArrayList<>();
    static List<Integer> managersHavingGreaterSalaryThanSkips = new ArrayList<>();

    public Tree(Node root) {
        this.root = root;
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        Tree tree = new Tree(root);

        tree.root.children.add(new Node(11));

        tree.root.children.get(0).children.add(new Node(5));
        tree.root.children.get(0).children.add(new Node(15));
        tree.root.children.get(0).children.add(new Node(10));

        tree.root.children.get(0).children.get(0).children.add( new Node(3));
        tree.root.children.get(0).children.get(0).children.add( new Node(6));

        tree.root.children.get(0).children.get(1).children.add( new Node(2));
        tree.root.children.get(0).children.get(1).children.add( new Node(5));
        tree.root.children.get(0).children.get(1).children.add( new Node(8));
        tree.root.children.get(0).children.get(1).children.add( new Node(4));

        tree.root.children.get(0).children.get(2).children.add( new Node(20));

        getManagersHavingLessSalary(tree.root);
        getManagersHavingLessThanAverageSalaryOfSubordinates(tree.root);
        getManagersHavingMoreSalaryThanAnySkips(tree.root, tree.root.data);

        System.out.println(" Managers That have less salary than any of their subordinates - ");
        for(Integer manager : managersHavingLessSalaryThanSubordinates)
            System.out.print(manager + " ");
        System.out.println();
        System.out.println();

        System.out.println(" Managers That have less salary than the average salary of their subordinates - ");
        for(Integer manager : managersHavingLessThanAverageSalaryOfSubordinates)
            System.out.print(manager + " ");
        System.out.println();
        System.out.println();

        System.out.println(" Managers That have more salary than all of their skips - ");
        for(Integer manager : managersHavingGreaterSalaryThanSkips)
            System.out.print(manager + " ");
        System.out.println();
    }

    public static int getManagersHavingLessSalary(Node node)
    {
        if(node.children.isEmpty()) return node.data;

        int childMax = -1;
        for( Node child : node.children)
        {
            childMax = Math.max(childMax, getManagersHavingLessSalary(child));
        }
        if(node.data < childMax && childMax != -1)
            managersHavingLessSalaryThanSubordinates.add(node.data);

        return Math.max( node.data, childMax);
    }


    /***
     *  int[0] is sum of all nodes of subtree.
     * int[1] is count of nodes of subtree.
     */
    public static int[] getManagersHavingLessThanAverageSalaryOfSubordinates(Node node) {
        if(node.children.isEmpty())
            return new int[] {node.data, 1};

        int childSum = 0;
        int childCount = 0;
        for( Node child : node.children)
        {
            int[] pair = getManagersHavingLessThanAverageSalaryOfSubordinates(child);
            childCount += pair[1];
            childSum += pair[0];
        }

        double average = childSum / childCount;
        if( Math.abs( node.data - average) > 0.0001)
            managersHavingLessThanAverageSalaryOfSubordinates.add(node.data);
        return new int[] { childSum, childCount };

    }

    public static void getManagersHavingMoreSalaryThanAnySkips(Node node, int max)
    {
        if(node == null) return ;
        System.out.println(" value is " + node.data + " max = " + max);

        if(node.data > max)
        {
            managersHavingGreaterSalaryThanSkips.add(node.data);
        }

        max = Math.max(max, node.data);
        for( Node child : node.children)
        {
            getManagersHavingMoreSalaryThanAnySkips(child, max);
        }
    }
}
