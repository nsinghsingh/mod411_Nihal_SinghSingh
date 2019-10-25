package BinaryTree;

import Queue.ArrayQueue;

import java.lang.reflect.Method;

public class BinaryLinkedTree implements BinaryTree {

    // root node
    private BinaryTreeNode root;

    // class data members
    private static Method visit;                               // visit method to use during a traversal
    private static Object[] visitArgs = new Object[1];         // parameters of visit method
    private static int count;                                  // counter
    private static Class[] paramType = {BinaryTreeNode.class}; // type of parameter for visit
    private static Method theAdd1;                             // method to increment count by 1
    static Method outputMethod;                        // method to output node element

    // method to initialize class data members
    static {
        try {
            Class<BinaryLinkedTree> treeClass = BinaryLinkedTree.class;
            theAdd1 = treeClass.getMethod("add1", paramType);
            outputMethod = treeClass.getMethod("output", paramType);
        } catch (Exception e) {
            // can't catch exceptionn here
        }
    }

    /**
     * visit method that outputs element
     */
    public static void output(BinaryTreeNode treeNode) {
        System.out.print(treeNode.getPayload() + " ");
    }

    /**
     * Besuchsmethode zum Zählen von Knoten.
     */
    @SuppressWarnings("unused")
    public static void add1(BinaryTreeNode treeNode) {
        count++;
    }

    /**
     * @return Liefert den Wert true, falls der Baum leer ist
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Liefert die Wurzel des Baumes.
     *
     * @return Liefert den Wert null, falls der Baum leer ist
     */
    public Object getRoot() {
        return (isEmpty()) ? null : root.getPayload();
    }

    /**
     * Erstellt eine Baumstruktur mit den angegebenen Parameter.
     *
     * <b>Vorsicht:</b> Der rechte und linke Teilbaum wird nicht geklont!
     *
     * @param root  Wurzel der Baumstruktur
     * @param left  Linker Teilbaum
     * @param right Rechter Teilbaum
     */
    public void makeTree(Object root, Object left, Object right) {
        this.root = new BinaryTreeNode(root,
                ((BinaryLinkedTree) left).root,
                ((BinaryLinkedTree) right).root);
    }

    /**
     * Löscht den linken Teilbaum.
     *
     * @return Gelöschter Teilbaum
     * @throws IllegalArgumentException wenn der Teilbaum leer ist
     */
    public BinaryTree removeLeftSubtree() {
        if (isEmpty())
            throw new IllegalArgumentException("tree is empty");

        // Linken Teilbaum trennen
        BinaryLinkedTree leftSubtree = new BinaryLinkedTree();
        leftSubtree.root = root.getLeftChild();
        root.setLeftChild(null);

        return leftSubtree;
    }

    /**
     * Löscht den rechten Teilbaum.
     *
     * @return Gelöschter Teilbaum
     * @throws IllegalArgumentException wenn der Teilbaum leer ist
     */
    public BinaryTree removeRightSubtree() {
        if (isEmpty())
            throw new IllegalArgumentException("tree is empty");

        // Rechten Teilbaum trennen
        BinaryLinkedTree rightSubtree = new BinaryLinkedTree();
        rightSubtree.root = root.getRightChild();
        root.setRightChild(null);

        return rightSubtree;
    }

    /**
     * Preorder traversal
     *
     * @param visit Method to be used during visit
     */
    public void preOrder(Method visit) {
        BinaryLinkedTree.visit = visit;
        traversePreOrder(root);
    }

    /**
     * Actual preorder traversal method
     */
    private void traversePreOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            visitArgs[0] = treeNode;
            try {
                visit.invoke(null, visitArgs);
            } catch (Exception e) {
                System.out.println(e);
            }
            traversePreOrder(treeNode.getLeftChild());
            traversePreOrder(treeNode.getRightChild());
        }
    }

    /**
     * Inorder traversal
     */
    public void inOrder(Method visit) {
        BinaryLinkedTree.visit = visit;
        traverseInOrder(root);
    }

    /**
     * actual inorder traversal method
     */
    private void traverseInOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            traverseInOrder(treeNode.getLeftChild());
            visitArgs[0] = treeNode;
            try {
                visit.invoke(null, visitArgs);
            } catch (Exception e) {
                System.out.println(e);
            }
            traverseInOrder(treeNode.getRightChild());
        }
    }

    /**
     * Postorder traversal
     */
    public void postOrder(Method visit) {
        BinaryLinkedTree.visit = visit;
        traversePostOrder(root);
    }

    /**
     * Actual postorder traversal method
     */
    @SuppressWarnings("ThrowablePrintedToSystemOut")
    private void traversePostOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            traversePostOrder(treeNode.getLeftChild());
            traversePostOrder(treeNode.getRightChild());
            visitArgs[0] = treeNode;
            try {
                visit.invoke(null, visitArgs);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Level order traversal
     */
    public void levelOrder(Method visit) {
        ArrayQueue<BinaryTreeNode> queue = new ArrayQueue<BinaryTreeNode>();
        BinaryTreeNode treeNode = root;
        while (treeNode != null) {
            visitArgs[0] = treeNode;
            try {
                visit.invoke(null, visitArgs);
            } catch (Exception e) {
                System.out.println(e);
            }

            // put t's children on queue
            if (treeNode.getLeftChild() != null)
                queue.put(treeNode.getLeftChild());
            if (treeNode.getRightChild() != null)
                queue.put(treeNode.getRightChild());

            // get next node to visit
            treeNode = queue.remove();
        }
    }

    /**
     * Liefert die Anzahl der Knoten im Baum.
     *
     * @return Anzahl Knoten im Baum
     */
    public int size() {
        count = 0;
        preOrder(theAdd1);
        return count;
    }

    /**
     * Liefert die Tiefe des Baumes beginnend mit dem Startknoten.
     *
     * @return Tiefe des Baumes
     */
    public int height() {
        return countHeight(root);
    }


    /**
     * Liefert die Tiefe des Baumes beginnend mit dem angegebenen Knoten.
     *
     * @param treeNode Von diesem Knoten soll die Tiefe berechnet werden
     * @return Tiefe des Baumes
     */
    private int countHeight(BinaryTreeNode treeNode) {
        if (treeNode == null)
            return 0;

        int leftHeight = countHeight(treeNode.getLeftChild());
        int rightHeight = countHeight(treeNode.getRightChild());

        return (leftHeight > rightHeight) ? ++leftHeight : ++rightHeight;
    }

}
