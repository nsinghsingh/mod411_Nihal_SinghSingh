package BinaryTree;

import lombok.Getter;
import lombok.Setter;

/**
 * Representiert einen Knoten in einer binären Baumstruktur
 */
@Setter
@Getter
public class BinaryTreeNode {

    private Object payload;

    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    /**
     * Konstruktor ohne Argumente.
     */
    public BinaryTreeNode() {
    }

    /**
     * Erstellt einen Knotenpunkt mit den gegebenen Daten.
     *
     * @param payload Zu speichernde Daten im Knoten
     */
    public BinaryTreeNode(Object payload) {
        this.payload = payload;
    }

    /**
     * Erstellt einen Knotenpunkt mit den übergebenen Daten.
     *
     * @param payload Root element of the BinaryTreeNode
     * @param leftChild Linker Teilbaum
     * @param rightChild Rechter Teilbaum
     */
    public BinaryTreeNode(Object payload,
                          BinaryTreeNode leftChild,
                          BinaryTreeNode rightChild) {
        this.payload = payload;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

}
