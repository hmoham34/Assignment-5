import java.util.ArrayList;

/**
 * MorseCodeTree converts Morse code to English. 
 * It builds a binary tree where each node represents a letter.
 * '.' traverses left, and '-' traverses right.
 * 
 * @author Hussain Mohammad
 */
public final class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    private TreeNode<String> root;

    /**
     * Constructor initializes the MorseCodeTree by building the tree.
     */
    public MorseCodeTree() {
        buildTree();
    }

    /**
     * Builds the MorseCodeTree by inserting nodes level by level using Morse code patterns.
     */
    @Override
    public void buildTree() {
        root = new TreeNode<>("");

        // Level 1
        insert(".", "e");
        insert("-", "t");

        // Level 2
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        // Level 3
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

        // Level 4
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    @Override
    public MorseCodeTree insert(String code, String letter) {
        addNode(root, code, letter);
        return this;
    }

    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                root.left = new TreeNode<>(letter);
            } else {
                root.right = new TreeNode<>(letter);
            }
        } else {
            if (code.charAt(0) == '.') {
                if (root.left == null) root.left = new TreeNode<>("");
                addNode(root.left, code.substring(1), letter);
            } else {
                if (root.right == null) root.right = new TreeNode<>("");
                addNode(root.right, code.substring(1), letter);
            }
        }
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if (root == null) return null;

        if (code.length() == 1) {
            return code.equals(".") ? root.left.data : root.right.data;
        } else {
            return code.charAt(0) == '.'
                ? fetchNode(root.left, code.substring(1))
                : fetchNode(root.right, code.substring(1));
        }
    }

    @Override
    public MorseCodeTree delete(String data) {
        throw new UnsupportedOperationException("Delete operation is not supported.");
    }

    @Override
    public MorseCodeTree update() {
        throw new UnsupportedOperationException("Update operation is not supported.");
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.left, list);
            list.add(root.data);
            LNRoutputTraversal(root.right, list);
        }
    }
}
