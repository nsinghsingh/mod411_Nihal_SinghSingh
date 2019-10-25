
package BinaryTree;

public interface BinaryTree<T extends Comparable<T>> {

    boolean isEmpty();

    Object getRoot();

    BinaryTreeNode getLeft();

    BinaryTreeNode getRight();

    void makeTree(T root, BinaryTreeNode left, BinaryTreeNode right);

    void setTree(T[] values);

    BinaryTreeNode setBranch(BinaryTreeNode<T> branch, BinaryTreeNode newNode, T value);

    boolean insert(T value);

    boolean delete(T value);
}