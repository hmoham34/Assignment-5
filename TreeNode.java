/**
 * Represents a node in a binary tree with references to data, left, and right children.
 * 
 * @param <T> The type of data stored in the node.
 * @author Hussain
 */
public class TreeNode<T> {

    protected T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    /**
     * Creates a new TreeNode with the specified data and no children.
     * 
     * @param dataNode The data to store in this TreeNode.
     */
    public TreeNode(T dataNode) {
        this.data = dataNode;
        this.left = null;
        this.right = null;
    }

    /**
     * Creates a deep copy of the specified TreeNode.
     * 
     * @param node The TreeNode to copy. References to left and right nodes are shallow copies.
     */
    public TreeNode(TreeNode<T> node) {
        this.data = node.data;
        this.left = node.left;  // Note: shallow copy of left child
        this.right = node.right;  // Note: shallow copy of right child
    }

    /**
     * Returns the data stored in this TreeNode.
     * 
     * @return The data of this TreeNode.
     */
    public T getData() {
        return data;
    }
}
