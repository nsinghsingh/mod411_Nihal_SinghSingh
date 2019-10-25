package BinaryTree;

import java.lang.reflect.Method;

public interface BinaryTree {

    /**
     * @return liefert den Wert true, falls der Baum leer ist
     */
    boolean isEmpty();

    /**
     * Liefert die Wurzel des Baumes.
     *
     * @return Liefert den Wert null, falls der Baum leer ist
     */
    Object getRoot();

    /**
     * Erstellt eine Baumstruktur mit den angegebenen Parameter.
     *
     * <b>Vorsicht:</b> Der rechte und linke Teilbaum wird nicht geklont!
     *
     * @param root  Wurzel der Baumstruktur
     * @param left  Linker Teilbaum
     * @param right Rechter Teilbaum
     */
    void makeTree(Object root, Object left, Object right);

    /**
     * Löscht den linken Teilbaum.
     *
     * @return Gelöschter Teilbaum
     */
    BinaryTree removeLeftSubtree();

    /**
     * Löscht den rechten Teilbaum.
     *
     * @return Gelöschter Teilbaum
     */
    BinaryTree removeRightSubtree();

    void preOrder(Method visit);

    void inOrder(Method visit);

    void postOrder(Method visit);

    void levelOrder(Method visit);

}
