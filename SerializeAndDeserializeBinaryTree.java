import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = "1,2,3,X,X,4,5";
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        serializeAndDeserializeBinaryTree.serialize(root);
        serializeAndDeserializeBinaryTree.deserialize(str);
    }


    final String X = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return X;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    String[] arr;
    int index = 0;

    public TreeNode deserialize(String data) {
        arr = data.split(",");
        return dfs();
    }

    private TreeNode dfs() {
        if (index == arr.length) return null;
        // base case
        if (arr[index].equals("X")) {
            index++;
            return null;
        }
        // deserialize the current value
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        // build our left subtree and return its root
        root.left = dfs();
        // build our right subtree and return its root
        root.right = dfs();
        return root;
    }
}