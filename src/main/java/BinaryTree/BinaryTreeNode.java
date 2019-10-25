package BinaryTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BinaryTreeNode<T extends Comparable<T>>{
    private T payload;
    private BinaryTreeNode<T> left, right;

    public BinaryTreeNode() {
        this(null);
    }

    public BinaryTreeNode(T payload) {
        this(payload, null, null);
    }

    public BinaryTreeNode(T payload, BinaryTreeNode left, BinaryTreeNode right) {
        this.payload = payload;
        this.left = left;
        this.right = right;
    }
}