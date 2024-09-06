package data_structures;

class _10_Node {
    int data;
    _10_Node left;
    _10_Node right;

    _10_Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    _10_Node root;

    public void insert(_10_Node node) {
        root = insertHelper(root, node);
    }

    private _10_Node insertHelper(_10_Node root, _10_Node node) {
        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    // In-order traversal: left -> root -> right
    public void inorderTraverse() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(_10_Node root) {
        if (root != null) {
            inorderHelper(root.left);
            System.out.print(root.data + " ");
            inorderHelper(root.right);
        }
    }

    // Pre-order traversal: root -> left -> right
    public void preorderTraverse() {
        preorderHelper(root);
        System.out.println();
    }

    private void preorderHelper(_10_Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderHelper(root.left);
            preorderHelper(root.right);
        }
    }

    // Post-order traversal: left -> right -> root
    public void postorderTraverse() {
        postorderHelper(root);
        System.out.println();
    }

    private void postorderHelper(_10_Node root) {
        if (root != null) {
            postorderHelper(root.left);
            postorderHelper(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class _10_TreeTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        for (int i : new int[] {15, 28, 6, 39, 11, 33, 20, 4, 26, 43}) {
            tree.insert(new _10_Node(i));
        }

        System.out.println("In-order traversal:");
        tree.inorderTraverse();
        System.out.println();

        System.out.println("Pre-order traversal:");
        tree.preorderTraverse();
        System.out.println();

        System.out.println("Post-order traversal:");
        tree.postorderTraverse();
        System.out.println();
    }
}