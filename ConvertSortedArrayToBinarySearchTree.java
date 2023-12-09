public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        int[] arr = {-10,-3,0,5,9};
        convertSortedArrayToBinarySearchTree.sortedArrayToBST(arr);
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

        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        populatedSorted(nums, 0, nums.length);
        System.out.println(root.val);
        return root;
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

}
