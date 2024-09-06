package data_structures;

import java.util.NoSuchElementException;

class Node {
    int data;
    Node leftChild;
    Node rightChild;

    Node(int data) {
        this.data = data;
    }
}

class BinarySearchTree {
    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.leftChild = insertHelper(root.leftChild, node);
        } else {
            root.rightChild = insertHelper(root.rightChild, node);
        }

        return root;
    }

    public void display() {
        displayHelper(root);
        System.out.println();
    }

    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.leftChild);
            System.out.print(root.data + " ");
            displayHelper(root.rightChild);
        }
    }

    public boolean search(int target) {
        return searchHelper(root, target);
    }

    private boolean searchHelper(Node root, int target) {
        if (root == null) {
            return false;
        } else if (root.data == target) {
            return true;
        } else if (root.data < target) {
            return searchHelper(root.rightChild, target);
        } else {
            return searchHelper(root.leftChild, target);
        }
    }

    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            throw new NoSuchElementException("Data " + data + " not found in the tree");
        }
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.leftChild = removeHelper(root.leftChild, data);
        } else if (data > root.data) {
            root.rightChild = removeHelper(root.rightChild, data);
        } else {
            if (root.leftChild == null && root.rightChild == null) {
                root = null;
            } else if (root.rightChild != null) {
                root.data = successor(root);
                root.rightChild = removeHelper(root.rightChild, root.data);
            } else {
                root.data = predecessor(root);
                root.leftChild = removeHelper(root.leftChild, root.data);
            }
        }

        return root;
    }

    private int predecessor(Node root) {
        root = root.leftChild;

        while (root.rightChild != null) {
            root = root.rightChild;
        }

        return root.data;
    }

    private int successor(Node root) {
        root = root.rightChild;

        while (root.leftChild != null) {
            root = root.leftChild;
        }

        return root.data;
    }
}

public class _09_BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        for (int i : new int[] {17, 39, 36, 34, 23, 20, 13, 28, 8, 16}) {
            tree.insert(new Node(i));
        }

        System.out.println("Tree:");
        tree.display();

        System.out.println("Contain value 0? " + tree.search(0));
        System.out.println("Contain value 23? " + tree.search(23));
        System.out.println("Contain value 17? " + tree.search(17));
        System.out.println("Contain value 10? " + tree.search(10));

        try {
            tree.remove(13);
            System.out.println("Updated tree:");
            tree.display();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}