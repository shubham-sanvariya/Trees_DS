public class LowestCommonAncestorBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorBinaryTree lowestCommonAncestorBinaryTree = new LowestCommonAncestorBinaryTree();
        lowestCommonAncestorBinaryTree.lowestCommonAncestor(root,root.left,root.left.right.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left != null & right != null) return root;

        return left == null ? right : left;
    }
}
