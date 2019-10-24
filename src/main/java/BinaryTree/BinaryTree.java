
package BinaryTree;

public interface BinaryTree {

    boolean isEmpty();

    Object getRoot();

    void makeTree(Object root, BinaryTreeNode left, BinaryTreeNode right);
}