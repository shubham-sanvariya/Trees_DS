public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        validateBinarySearchTree.isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high){
        if(node == null) return true;

        if(low != null && node.val <= low){
            return false;
        }
        if(high != null && node.val >= high){
            return false;
        }

        boolean leftTree =  helper(node.left, low, node.val);
        boolean rightTree =  helper(node.right, node.val, high);

        return leftTree & rightTree;
    }
}
