package BinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryLinkedTreeTest {

    BinaryLinkedTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryLinkedTree<Integer>();
    }

    @Test
    void isEmpty() {
        assertTrue(tree.isEmpty());
        tree.makeTree(0, null, null);
        assertFalse(tree.isEmpty());
    }

    @Test
    void getRoot() {
        tree.makeTree(32, null, null);
        assertEquals(32, tree.getRoot());
    }

    @Test
    void makeTree() {
        assertTrue(tree.isEmpty());
        BinaryTreeNode node1 = new BinaryTreeNode<>(38);
        tree.makeTree(10, null, node1);
        assertFalse(tree.isEmpty());
        assertEquals(38, tree.getRight().getPayload());
        tree.makeTree(null, null, null);
        assertTrue(tree.isEmpty());
    }

    @Test
    void getRight() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(32);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(0);
        node1 = new BinaryTreeNode<Integer>(node1.getPayload(), node3, node4);
        tree.makeTree(null, node1, node2);
        assertEquals(3, tree.getRight().getPayload());
    }

    @Test
    void getLeft() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(32);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(0);
        node1 = new BinaryTreeNode<Integer>(node1.getPayload(), node3, node4);
        tree.makeTree(null, node1, node2);
        assertEquals(9, tree.getLeft().getLeft().getPayload());
    }

    @Test
    void setTree() {
        Integer[] array = {4, 5, 2, 1, 3, 6};
        tree.setTree(array);
        assertEquals(6, tree.getRight().getRight().getPayload());
    }
}