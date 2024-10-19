package App;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    // Insertion
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Search
    public boolean search(T value) {
        return searchRec(root, value) != null;
    }

    private Node<T> searchRec(Node<T> root, T value) {
        if (root == null || root.value.equals(value)) {
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            return searchRec(root.left, value);
        }
        return searchRec(root.right, value);
    }

    // Deletion
    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private Node<T> deleteRec(Node<T> root, T value) {
        if (root == null) {
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = findMin(root.right).value;
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    // Traversal Methods
    public String inOrderTraversal() {
        StringBuilder result = new StringBuilder();
        inOrderRec(root, result);
        return result.toString();
    }

    private void inOrderRec(Node<T> root, StringBuilder result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.append(root.value).append(" ");
            inOrderRec(root.right, result);
        }
    }

    public String preOrderTraversal() {
        StringBuilder result = new StringBuilder();
        preOrderRec(root, result);
        return result.toString();
    }

    private void preOrderRec(Node<T> root, StringBuilder result) {
        if (root != null) {
            result.append(root.value).append(" ");
            preOrderRec(root.left, result);
            preOrderRec(root.right, result);
        }
    }

    public String postOrderTraversal() {
        StringBuilder result = new StringBuilder();
        postOrderRec(root, result);
        return result.toString();
    }

    private void postOrderRec(Node<T> root, StringBuilder result) {
        if (root != null) {
            postOrderRec(root.left, result);
            postOrderRec(root.right, result);
            result.append(root.value).append(" ");
        }
    }

    // Find Minimum
    public T findMin() {
        Node<T> minNode = findMin(root);
        return minNode != null ? minNode.value : null;
    }

    private Node<T> findMin(Node<T> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Find Maximum
    public T findMax() {
        Node<T> maxNode = findMax(root);
        return maxNode != null ? maxNode.value : null;
    }

    private Node<T> findMax(Node<T> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // Height
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Check if the Tree is Balanced
    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node<T> root) {
        if (root == null) {
            return true;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedRec(root.left) && isBalancedRec(root.right);
    }

    // Level-Order Traversal
    public String levelOrderTraversal() {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> tempNode = queue.poll();
            result.append(tempNode.value).append(" ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return result.toString();
    }

    // Clear
    public void clear() {
        root = null;
    }

    // Count Nodes
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
}