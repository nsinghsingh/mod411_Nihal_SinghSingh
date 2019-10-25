package BinaryTree;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryLinkedTreeTest {

    private BinaryLinkedTree tree;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        BinaryLinkedTree
                a = new BinaryLinkedTree(),
                b = new BinaryLinkedTree(),
                c = new BinaryLinkedTree(),
                d = new BinaryLinkedTree(),
                e = new BinaryLinkedTree(),
                f = new BinaryLinkedTree();

        a.makeTree(1, new BinaryLinkedTree(), new BinaryLinkedTree());
        b.makeTree(3, new BinaryLinkedTree(), new BinaryLinkedTree());
        c.makeTree(5, new BinaryLinkedTree(), new BinaryLinkedTree());
        d.makeTree(7, new BinaryLinkedTree(), new BinaryLinkedTree());
        e.makeTree(2, a, b);
        f.makeTree(6, c, d);

        tree = new BinaryLinkedTree();
        tree.makeTree(4, e, f);

        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void preOrder() {
        tree.preOrder(BinaryLinkedTree.outputMethod);
        assertEquals("4 2 1 3 6 5 7 ", outContent.toString());
    }

    @Test
    void inOrder() {
        tree.inOrder(BinaryLinkedTree.outputMethod);
        assertEquals("1 2 3 4 5 6 7 ", outContent.toString());
    }

    @Test
    void postOrder() {
        tree.postOrder(BinaryLinkedTree.outputMethod);
        assertEquals("1 3 2 5 7 6 4 ", outContent.toString());
    }

    @Test
    void levelOrder() {
        tree.levelOrder(BinaryLinkedTree.outputMethod);
        assertEquals("4 2 6 1 3 5 7 ", outContent.toString());
    }

    @Test
    void size() {
        assertEquals(7, tree.size());
    }

    @Test
    void height() {
        assertEquals(3, tree.height());
    }

}
