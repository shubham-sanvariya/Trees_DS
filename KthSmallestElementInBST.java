public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
        System.out.println(kthSmallestElementInBST.kthSmallest(root,4));
    }

    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
      return helper(root,k).val;
    }

    private TreeNode helper(TreeNode root, int k) {
        if (root == null) return null;

        TreeNode left = helper(root.left, k);

        if (left != null){
            return left;
        }
        count++;

        if (count == k){
            return root;
        }
        return helper(root.right,k);
    }

}
