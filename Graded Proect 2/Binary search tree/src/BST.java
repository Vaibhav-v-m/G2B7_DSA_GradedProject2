class Node {
    int val;
    Node left, right;

    Node(int item) {
        val = item;
        left = right = null;
    }

}

class BST {
    public Node node;
    Node prevNode = null;
    Node headNode = null;

    //    Skewed tree
    void flattenBSTToSkewed(Node root, int order) {
        if (root == null) {
            return;
        }

        if (order > 0) {
            flattenBSTToSkewed(root.right, order);
        } else {
            flattenBSTToSkewed(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;

        if (headNode == null) {
            headNode = root;
            root.left = null;
            prevNode = root;
        } else {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }

        if (order > 0) {
            flattenBSTToSkewed(leftNode, order);
        } else {
            flattenBSTToSkewed(rightNode, order);
        }
    }

    void traverseRightSkewed(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        traverseRightSkewed((root.right));
    }

}
