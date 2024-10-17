package App;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order Traversal:");
        System.out.println(bst.inOrderTraversal());

        System.out.println("Pre-order Traversal:");
        System.out.println(bst.preOrderTraversal());

        System.out.println("Post-order Traversal:");
        System.out.println(bst.postOrderTraversal());

        System.out.println("Level-order Traversal:");
        System.out.println(bst.levelOrderTraversal());

        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));

        System.out.println("Minimum value: " + bst.findMin());
        System.out.println("Maximum value: " + bst.findMax());

        System.out.println("Height of tree: " + bst.height());
        System.out.println("Is tree balanced: " + bst.isBalanced());

        System.out.println("Number of nodes: " + bst.countNodes());

        bst.delete(20);
        System.out.println("In-order Traversal after deleting 20:");
        System.out.println(bst.inOrderTraversal());

        bst.clear();
        System.out.println("In-order Traversal after clearing the tree:");
        System.out.println(bst.inOrderTraversal());
    }
}