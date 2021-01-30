package dsa.tree;

public class BinarySearchTreeDriver {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(25);
        bst.insert(8);
        bst.insert(12);

        // Min and Max Values
        System.out.println("Min Value : " + bst.min());
        System.out.println("Max Value : " + bst.max());

        // Traversals
        bst.levelOrderTraversal();
        bst.preOrderTraversal();
        bst.inOrderTraversal();
        bst.postOrderTraversal();
    }
}
