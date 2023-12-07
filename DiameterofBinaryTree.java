import java.util.Scanner;

import static javax.swing.Spring.height;

public class DiameterofBinaryTree {
    public static void main(String[] args) {
        DiameterofBinaryTree diameterofBinaryTree = new DiameterofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        diameterofBinaryTree.diameterOfBinaryTree(root);
    }

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        System.out.println(diameter);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int dia = leftHeight + rightHeight;
        diameter = Math.max(diameter,dia);
        int max = Math.max(leftHeight, rightHeight ) + 1;
        return max;
    }
}