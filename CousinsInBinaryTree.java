public class CousinsInBinaryTree {
    public static void main(String[] args) {
        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        int[] nums2 = {5,2,7};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        cousinsInBinaryTree.isCousins(root,4,3);
    }

    private TreeNode root;

    public void insert(int value){
        root = insert(value, root);
    }

    private TreeNode insert(int value, TreeNode node) {
        if (node == null){
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val){
            node.left = insert(value, node.left);
        }
        if (value > node.val){
            node.right = insert(value, node.right);
        }

//        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public TreeNode populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
        return root;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (
                (level(root,xx,0) == level(root,yy,0)) && (!isSibling(root,xx,yy))
        );
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        return (
                (node.left == x && node.right == y) || (node.left == y && node.right == x)
                        || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    private int level(TreeNode node, TreeNode x, int lev) {
        if(node == null) {
            return 0;
        }

        if(node == x) {
            return lev;
        }

        int l = level(node.left, x, lev+1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev+1);
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x)return node;
        TreeNode n = findNode(node.left,x);
        if (n != null){
            return n;
        }
        return findNode(node.right,x);
    }
}
