package BinaryTree;

public class BinaryLinkedTree<T extends Comparable<T>> implements BinaryTree<T> {

    private BinaryTreeNode<T> root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public T getRoot() {
        return (isEmpty()) ? null : root.getPayload();
    }

    @Override
    public BinaryTreeNode getLeft() {
        return (isEmpty()) ? null : root.getLeft();
    }

    @Override
    public BinaryTreeNode getRight() {
        return (isEmpty()) ? null : root.getRight();
    }

    @Override
    public void makeTree(T root, BinaryTreeNode left, BinaryTreeNode right) {
        if (root == null && left == null && right == null){
            this.root = null;
        }
        else{
            this.root = new BinaryTreeNode<T>(root, left, right);
        }
    }

    @Override
    public void setTree(T[] values){
        makeTree(values[0], null, null);
        for (int i = 1; i < values.length; i++) {
            BinaryTreeNode<T> newNode = new BinaryTreeNode<>(values[i]);
            root = setBranch(root, newNode, values[i]);
        }
    }

    @Override
    public BinaryTreeNode<T> setBranch(BinaryTreeNode<T> branch, BinaryTreeNode newNode, T value){
        if (branch.getPayload().compareTo(value) < 0) {
            if (branch.getRight() == null) {
                branch = new BinaryTreeNode<T>(branch.getPayload(), branch.getLeft(), newNode);
            } else {
                branch = new BinaryTreeNode<T>(branch.getPayload(), branch.getLeft(), setBranch(branch.getRight(), newNode, value));
            }
        } else {
            if (branch.getLeft() == null) {
                branch = new BinaryTreeNode<T>(branch.getPayload(), newNode, branch.getRight());
            } else {
                branch = new BinaryTreeNode<T>(branch.getPayload(), setBranch(branch.getLeft(), newNode, value), branch.getRight());
            }
        }
        return branch;
    }

}