package BinaryTree;

public class BinaryLinkedTree implements BinaryTree {

    private BinaryTreeNode root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Object getRoot() {
        return (isEmpty()) ? null : root.getPayload();
    }

    @Override
    public void makeTree(Object root, BinaryTreeNode left, BinaryTreeNode right) {
        this.root = new BinaryTreeNode(root, left, right);
    }

}