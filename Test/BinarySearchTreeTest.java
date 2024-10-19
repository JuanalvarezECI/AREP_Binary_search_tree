package Test;

import App.BinarySearchTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    public void testInsertAndTraversals() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // In-order Traversal
        assertEquals("20 30 40 50 60 70 80 ", bst.inOrderTraversal());

        // Pre-order Traversal
        assertEquals("50 30 20 40 70 60 80 ", bst.preOrderTraversal());

        // Post-order Traversal
        assertEquals("20 40 30 60 80 70 50 ", bst.postOrderTraversal());

        // Level-order Traversal
        assertEquals("50 30 70 20 40 60 80 ", bst.levelOrderTraversal());
    }

    @Test
    public void testSearch() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        assertTrue(bst.search(30));
        assertFalse(bst.search(90));
    }

    @Test
    public void testFindMinAndMax() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        assertEquals(20, bst.findMin());
        assertEquals(80, bst.findMax());
    }

    @Test
    public void testHeightAndBalance() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        assertEquals(3, bst.height());
        assertTrue(bst.isBalanced());
    }

    @Test
    public void testCountNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        assertEquals(7, bst.countNodes());
    }

    @Test
    public void testDeleteAndClear() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.delete(20);
        assertEquals("30 40 50 60 70 80 ", bst.inOrderTraversal());

        bst.clear();
        assertEquals("", bst.inOrderTraversal());
    }
}