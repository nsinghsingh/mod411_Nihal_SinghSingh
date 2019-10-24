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
    public void makeTree(Object root, Object left, Object right) {
        this.root = new BinaryTreeNode(root,
                ((BinaryLinkedTree) left).root,
                ((BinaryLinkedTree) right).root);
    }

}